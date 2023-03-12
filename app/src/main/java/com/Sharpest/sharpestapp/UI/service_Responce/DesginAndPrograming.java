package com.Sharpest.sharpestapp.UI.service_Responce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.Sharpest.sharpestapp.Login_Signup.Login;
import com.Sharpest.sharpestapp.MySingleton;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.SharedPrefManager;
import com.Sharpest.sharpestapp.UI.service_Responce.dataResponse_url_offers.DataOfersResponseService;
import com.Sharpest.sharpestapp.UI.service_Responce.modelService.desgnAndPrograming.DataResposeDesingnAndPrograming;
import com.Sharpest.sharpestapp.Urls;
import com.Sharpest.sharpestapp.VolleyMultipartRequest;
import com.Sharpest.sharpestapp.model.DataDedginProgramingRequest.Customer;
import com.Sharpest.sharpestapp.model.DataDedginProgramingRequest.DatadesignProgrammingRequest;
import com.Sharpest.sharpestapp.model.DataDedginProgramingRequest.DesignProgramming;
import com.Sharpest.sharpestapp.model.DataDedginProgramingRequest.ServiceRequestHeaderMobile;
import com.Sharpest.sharpestapp.model.DataSeana_Request.Offers;
import com.Sharpest.sharpestapp.sevicess.LocationMonitoringService;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class DesginAndPrograming extends AppCompatActivity {

    EditText userName,phone,location,desgin,materal,dimantion,machinUsed,address;

    Button request;
    ImageView locationservice;
    String location_name="";

    TextView getimage,canselimage;
    TextView price_offer;

    Double lat,loagtute;
    Bitmap bitmap;

    String num_offer_val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desgin_and_programing);

//        Intent intent_service = new Intent(DesginAndPrograming.this, LocationMonitoringService.class);
//        startService(intent_service);
        price_offer=findViewById(R.id.price_offer);
        Bundle extras = getIntent().getExtras(); // to get move intent
        if (extras != null) {
            String a = extras.getString("id_product");
            String test = extras.getString("test");
            if (a!=null){
                getdataFromJson(a);
            }else{
                getdataFromJson(a);
            }

        }else{
            price_offer.setVisibility(View.GONE);
        }


        canselimage=findViewById(R.id.text_getimagee_hiden_designandPrograming);
        canselimage.setVisibility(View.GONE);
        getimage=findViewById(R.id.text_getimagee_designandPrograming);
        getimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 100);
            }
        });

        canselimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canselimage.setVisibility(View.GONE);
                getimage.setVisibility(View.VISIBLE);
                bitmap=null;
            }
        });
        defineUI();


        locationservice=findViewById(R.id.image_Location_desgin_programing);
        locationservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("??location","location");
//                Intent intent_service = new Intent(DesginAndPrograming.this, LocationMonitoringService.class);
//                startService(intent_service);
                try {
                    LocalBroadcastManager.getInstance(DesginAndPrograming.this).registerReceiver(
                            new BroadcastReceiver() {
                                @Override
                                public void onReceive(Context context, Intent intent) {
                                    String latitude = intent.getStringExtra(LocationMonitoringService.EXTRA_LATITUDE);
                                    String longitude = intent.getStringExtra(LocationMonitoringService.EXTRA_LONGITUDE);
                                    String name = intent.getStringExtra(LocationMonitoringService.EXTRA_LOCATONNAME);

                                    if (latitude != null && longitude != null) {
                                        lat = Double.valueOf(latitude);
                                        loagtute = Double.valueOf(longitude);
                                        location_name = name;
                                        Log.e("??location", lat.toString());
                                        Log.e("??location", loagtute.toString());
                                        Log.e("??location", location_name);
                                        //my_location.setText(name);
                                        //                            Log.e("location>>>>",name+"\n Latitude : " + latitude + "\n Longitude: " + longitude);
                                    } else {
                                        Toast.makeText(context, "dddddddd", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }, new IntentFilter(LocationMonitoringService.ACTION_LOCATION_BROADCAST)
                    );

                }catch (Exception e){
                    Log.e(":::::::",e.toString());
                }

                location.setText(location_name.trim());
            }
        });

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().trim().isEmpty()){
                    userName.setFocusableInTouchMode(true);
                    userName.requestFocus();
                    userName.setError("ادخل البيانات");
                }else if (phone.getText().toString().trim().isEmpty()){
                    phone.setFocusableInTouchMode(true);
                    phone.requestFocus();
                    phone.setError("ادخل البيانات");
                }else if (location.getText().toString().trim().isEmpty()){
                    location.setFocusableInTouchMode(true);
                    location.requestFocus();
                    location.setError("ادخل البيانات");
                }else if (desgin.getText().toString().trim().isEmpty()){
                    desgin.setFocusableInTouchMode(true);
                    desgin.requestFocus();
                    desgin.setError("ادخل البيانات");
                }else if (materal.getText().toString().trim().isEmpty()){
                    materal.setFocusableInTouchMode(true);
                    materal.requestFocus();
                    materal.setError("ادخل البيانات");
                }else if (dimantion.getText().toString().trim().isEmpty()){
                    dimantion.setFocusableInTouchMode(true);
                    dimantion.requestFocus();
                    dimantion.setError("ادخل البيانات");
                }else if (machinUsed.getText().toString().trim().isEmpty()){
                    machinUsed.setFocusableInTouchMode(true);
                    machinUsed.requestFocus();
                    machinUsed.setError("ادخل البيانات");
                }else{
                    addReqestData();
                }
            }
        });


    }

    private void addReqestData(){
        final ProgressDialog progressDialog=new ProgressDialog(DesginAndPrograming.this);
        progressDialog.setMessage(" برجاء اﻻنتظار ...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);


        Gson gson = new Gson();
        DatadesignProgrammingRequest contactsTop=new DatadesignProgrammingRequest();


        Customer customer=new Customer();
        customer.setId(Integer.parseInt(SharedPrefManager.getInstance(getApplicationContext()).getid()));

        ServiceRequestHeaderMobile serviceRequestHeaderMobile=new ServiceRequestHeaderMobile();
        serviceRequestHeaderMobile.setCustomerPhone(phone.getText().toString().trim());
        serviceRequestHeaderMobile.setCustomer(customer);
        serviceRequestHeaderMobile.setCustomerName(userName.getText().toString().trim());
        serviceRequestHeaderMobile.setCustomerAddress(location.getText().toString().trim());

        if (num_offer_val!=null){
            Offers offers=new Offers();
            offers.setId(num_offer_val);
            contactsTop.setOffers(offers);
        }


        DesignProgramming designProgramming=new DesignProgramming();

        designProgramming.setDesignMaterial(materal.getText().toString().trim());
        designProgramming.setRequestedDescription(desgin.getText().toString().trim());

        designProgramming.setUsingMachine(machinUsed.getText().toString().trim());
        designProgramming.setWidthHight(dimantion.getText().toString().trim());
//
//        ServiceRequestHeaderMobile serviceRequestHeaderMobile=new ServiceRequestHeaderMobile();
//        serviceRequestHeaderMobile.setCustomer(customer);
//        serviceRequestHeaderMobile.setCustomerAddress(location.getText().toString().trim());
//        serviceRequestHeaderMobile.setCustomerName(userName.getText().toString().trim());
//        serviceRequestHeaderMobile.setCustomerPhone(phone.getText().toString().trim());
//
//
        contactsTop.setServiceRequestHeaderMobile(serviceRequestHeaderMobile);
        contactsTop.setDesignProgramming( designProgramming);

        Log.e("Volley:Response ", gson.toJson(contactsTop));

        JSONObject jsonObject = null;
        try {
            jsonObject=new JSONObject(gson.toJson(contactsTop));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Urls.designAndPrograming_Request
                , jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Log.e("response_booking",""+response);
//                finish();
                JSONObject sys = response;//// result

//                uploadBitmap(id);

                Gson gson = new Gson();
                DataResposeDesingnAndPrograming dataDelevery;
                dataDelevery = gson.fromJson(response.toString(), DataResposeDesingnAndPrograming.class);

                if (dataDelevery.getErrorStatus().equals(false)||dataDelevery.getErrorStatus() == false){
                    if (bitmap != null) {
                        uploadBitmap("" + dataDelevery.getResultData().getId());
                    }else{
                        finish();
                    }
                }
//
//                if (dataDelevery.getErrorStatus().equals(false)||dataDelevery.getErrorStatus() == false){
//                    showAlert(image,nameprodectAliaret,""+dataDelevery.getResultData().getId());
//
//                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    Toast.makeText(getApplicationContext(), "Error Network Time Out", Toast.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {
                    SharedPrefManager.getInstance(getApplicationContext()).logout();
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
//                        Toast.makeText(getApplicationContext(), "AuthFailureError", Toast.LENGTH_LONG).show();
                    //TODO
                } else if (error instanceof ServerError) {
                    Toast.makeText(getApplicationContext(), "ServerError", Toast.LENGTH_LONG).show();
                    //TODO
                } else if (error instanceof NetworkError) {
                    Toast.makeText(getApplicationContext(), "NetworkError", Toast.LENGTH_LONG).show();
                    //TODO
                } else if (error instanceof ParseError) {
                    Toast.makeText(getApplicationContext(), "ParseError", Toast.LENGTH_LONG).show();
                    //TODO
                }
            }

        }){
            //            /** Passing some request headers* */
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Authorization",
                        SharedPrefManager.getInstance(getApplicationContext()).getheader());
                return headers;
            }
        };;
//        {
//            /** Passing some request headers* */
//            @Override
//            public Map getHeaders() throws AuthFailureError {
//                HashMap headers = new HashMap();
//                headers.put("Authorization",
//                        SharedPrefManager_Login.getInstance(getApplicationContext()).getaccessType()+" "+
//                                SharedPrefManager_Login.getInstance(getApplicationContext()).getjwt());
//                return headers;
//            }
//        };;
        final RequestQueue requestQueue = Volley.newRequestQueue(DesginAndPrograming.this);
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                10000));

        requestQueue.add(jsonObjectRequest);
//        requestQueue.add(jsonObjectRequest);

    }

    private void defineUI() {

        userName=findViewById(R.id.ed_name_designPrograming);
        userName.setFocusableInTouchMode(false);
//        userName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                userName.setFocusableInTouchMode(true);
//                userName.setFocusableInTouchMode(true);
//                userName.requestFocus();
//                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(userName, InputMethodManager.SHOW_IMPLICIT);
//            }
//        });
        userName.setText(SharedPrefManager.getInstance(getApplicationContext()).getUsername());

        phone=findViewById(R.id.ed_phone_designPrograming);
        phone.setFocusableInTouchMode(false);
//        phone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                phone.setFocusableInTouchMode(true);
//                phone.setFocusableInTouchMode(true);
//                phone.requestFocus();
//                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(phone, InputMethodManager.SHOW_IMPLICIT);
//            }
//        });
        phone.setText(SharedPrefManager.getInstance(getApplicationContext()).getphone());


        location=findViewById(R.id.ed_location_designPrograming);
        location.setFocusableInTouchMode(true);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                location.setFocusableInTouchMode(true);
//                location.setFocusableInTouchMode(true);
//                location.requestFocus();
//                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(location, InputMethodManager.SHOW_IMPLICIT);
            }
        });
        location.setText(SharedPrefManager.getInstance(getApplicationContext()).getadreess());


        desgin=findViewById(R.id.ed_desgin_designPrograming);
        desgin.setFocusableInTouchMode(false);
        desgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                desgin.setFocusableInTouchMode(true);
                desgin.setFocusableInTouchMode(true);
                desgin.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(desgin, InputMethodManager.SHOW_IMPLICIT);
            }
        });


        materal=findViewById(R.id.ed_materal_designPrograming);
        materal.setFocusableInTouchMode(false);
        materal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materal.setFocusableInTouchMode(true);
                materal.setFocusableInTouchMode(true);
                materal.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(materal, InputMethodManager.SHOW_IMPLICIT);
            }
        });


        dimantion=findViewById(R.id.ed_dimantion_designPrograming);
        dimantion.setFocusableInTouchMode(false);
        dimantion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dimantion.setFocusableInTouchMode(true);
                dimantion.setFocusableInTouchMode(true);
                dimantion.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(dimantion, InputMethodManager.SHOW_IMPLICIT);
            }
        });


        machinUsed=findViewById(R.id.ed_machinUsed_designPrograming);
        machinUsed.setFocusableInTouchMode(false);
        machinUsed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                machinUsed.setFocusableInTouchMode(true);
                machinUsed.setFocusableInTouchMode(true);
                machinUsed.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(machinUsed, InputMethodManager.SHOW_IMPLICIT);
            }
        });


        request=findViewById(R.id.bu_request_designPrograming);

    }

    String nameImage;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {

            //getting the image Uri
            Uri imageUri = data.getData();
            Uri filePath = data.getData();

            String[] projection = {MediaStore.Images.Media.DATA};
            try {
                Cursor cursor = getContentResolver().query(filePath, projection, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(projection[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                Log.d("Picture Path", picturePath);
                Log.d("Picture Path name type", picturePath.split("/").toString());
                Log.d("Picture Path name type1",  picturePath.substring(picturePath.lastIndexOf('/') + 1));
                nameImage=picturePath.substring(picturePath.lastIndexOf('/') + 1).toString();
            }
            catch(Exception e) {
                Log.e("Path Error", e.toString());
            }

            try {
                //getting bitmap object from uri
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);

                //displaying selected image to imageview
//                imageView.setImageBitmap(bitmap);

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                Bitmap lastBitmap = null;
                lastBitmap = bitmap;
                //encoding image to string
                String image = getStringImage(lastBitmap);
                Log.d("image",image);

                canselimage.setVisibility(View.VISIBLE);
                getimage.setVisibility(View.GONE);

                //passing the image to volley
//                SendImage(image);
                //calling the method uploadBitmap to upload image
//                uploadBitmap();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;

    }
//>>>  send image
    private void SendImage( final String image) {
        final StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "http://41.32.95.166:8080/sharp-backend/request-header-images/upload-request-image?serviceRequestId=3",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("uploade", response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                        }

                    }
    },
            new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(DesginAndPrograming.this, "No internet connection", Toast.LENGTH_LONG).show();

        }
    }) {
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {

            Map<String, String> params = new Hashtable<String, String>();

            params.put("image", image);
            return params;
        }
    };
    {
        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}

    private void uploadBitmap(String id) {

        Log.e("uploadBitmap","uploadBitmap>>>>>>>>>>>>>>>>>>");

        final ProgressDialog progressDialog=new ProgressDialog(DesginAndPrograming.this);
        progressDialog.setMessage(" برجاء اﻻنتظار...");
        progressDialog.show();

        progressDialog.setCanceledOnTouchOutside(false);
        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST,
                Urls.api_test+"request-header-images/upload-request-image?serviceRequestId="+id+"&fileName="+nameImage,
//                Urls.api_test+"request-header-images/upload-request-image?serviceRequestId="+id+"&fileName=imagedesign.jpg",
                new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response) {
                        progressDialog.dismiss();
                        try {
                            Log.e("responseimge@@@@>>>>>>>","?????"+response.toString());
                            JSONObject obj = new JSONObject(new String(response.data));

                            Log.e("<<respon",""+obj.getString("errorStatus"));
                            boolean errprstates= Boolean.parseBoolean(obj.getString("errorStatus"));

                            if (obj.getString("errorStatus").equals(false)|| errprstates == false){
//                                Toast.makeText(getApplicationContext(), obj.getString("Upload image"), Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                Log.e("responseimge@@@@>>>>>>>",""+response.toString());
                            }
                        } catch (JSONException e) {
                            progressDialog.dismiss();
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();

//                        Log.e("responseimge>>>>>>>","@@???????????????????????@@@@@@@@");
                        Log.e("<<responseimge_error>>","@@???????????????????????@@@@@@@@"+error.getMessage());
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(getApplicationContext(), "Error Network Time Out", Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {
                            SharedPrefManager.getInstance(getApplicationContext()).logout();
                            startActivity(new Intent(getApplicationContext(), Login.class));
                            finish();
//                        Toast.makeText(getApplicationContext(), "AuthFailureError", Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ServerError) {
                            Toast.makeText(getApplicationContext(), "ServerError", Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof NetworkError) {
                            Toast.makeText(getApplicationContext(), "NetworkError", Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ParseError) {
                            Toast.makeText(getApplicationContext(), "ParseError", Toast.LENGTH_LONG).show();
                            //TODO
                        }
                    }
                }) {

                //            /** Passing some request headers* */

            /*
             * If you want to add more parameters with the image
             * you can do it here
             * here we have only one parameter with the image
             * which is tags
             * */
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("tags", tags);
//                return params;
//            }

            /*
             * Here we are passing image by renaming it with a unique name
             * */
            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
                long imagename = System.currentTimeMillis();
                params.put("multipartFile", new DataPart(imagename + ".png", getFileDataFromDrawable(bitmap)));
                return params;
            }
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Authorization",
                        SharedPrefManager.getInstance(getApplicationContext()).getheader());
                return headers;
            }
        };

        //adding the request to volley
//        volleyMultipartRequest.setRetryPolicy(new DefaultRetryPolicy(
//                1000000,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
////            mRequestQueue.add(stringRequest);
//
//        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
//        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(mRequestQueue.add(volleyMultipartRequest));
        Volley.newRequestQueue(this).add(volleyMultipartRequest);
    }

    public byte[] getFileDataFromDrawable(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }





    private void getdataFromJson(final String i) {
        try {
            ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
                //Toast.makeText(context, "you don't have update "+REGISTER_URL, Toast.LENGTH_SHORT).show();
                final StringRequest stringRequest = new StringRequest(Request.Method.GET,
                        Urls.Seana_get_Offer +i,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                Log.e("seana json>>>>>>>>   ",response);

                                if (response.length() > 0) {

                                    try {
                                        Gson gson = new Gson();
                                        DataOfersResponseService dataDelevery;
                                        dataDelevery = gson.fromJson(response.toString(), DataOfersResponseService.class);



                                        if (dataDelevery.getErrorStatus().equals(false)) {
                                            try {
                                                if (dataDelevery.getResultData().getOfferValue() !=null){
                                                    price_offer.setText("قيمه العرض   "+dataDelevery.getResultData().getOfferValue());
                                                    num_offer_val=""+dataDelevery.getResultData().getId();
                                                }

                                            }catch (Exception e){
                                                price_offer.setVisibility(View.GONE);
                                            }
                                        }
                                    }catch (Exception e){

                                    }
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //progressDialog.dismiss();
                                try {


                                    if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                        Toast.makeText(getApplicationContext(), "Error Network Time Out", Toast.LENGTH_LONG).show();
                                    } else if (error instanceof AuthFailureError) {
                                        SharedPrefManager.getInstance(getApplicationContext()).logout();
                                        startActivity(new Intent(getApplicationContext(), Login.class));
                                        finish();
                                        //startActivity(new Intent(getApplicationContext(),Log_In.class));
                                    } else if (error instanceof ServerError) {
                                        Toast.makeText(getApplicationContext(), "ServerError", Toast.LENGTH_LONG).show();
                                        //TODO
                                    } else if (error instanceof NetworkError) {
                                        Toast.makeText(getApplicationContext(), "NetworkError", Toast.LENGTH_LONG).show();
                                        //TODO
                                    } else if (error instanceof ParseError) {
                                        Toast.makeText(getApplicationContext(), "ParseError", Toast.LENGTH_LONG).show();
                                        //TODO
                                    }
                                }catch (Exception e){

                                }
                            }
                        }
                )        {
                    //            /** Passing some request headers* */
                    @Override
                    public Map getHeaders() throws AuthFailureError {
                        HashMap headers = new HashMap();
                        headers.put("Authorization",
                                SharedPrefManager.getInstance(getApplicationContext()).getheader());
                        return headers;
                    }
                };;
                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
            } else {
            }
        }catch (Exception r){

        }


    }
}



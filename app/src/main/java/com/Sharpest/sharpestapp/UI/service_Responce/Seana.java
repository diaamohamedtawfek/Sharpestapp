package com.Sharpest.sharpestapp.UI.service_Responce;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
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
import com.Sharpest.sharpestapp.model.DataSeana_Request.Customer;
import com.Sharpest.sharpestapp.model.DataSeana_Request.DataSeanaRequest;
import com.Sharpest.sharpestapp.model.DataSeana_Request.MaintenanceSupportRequest;
import com.Sharpest.sharpestapp.model.DataSeana_Request.Offers;
import com.Sharpest.sharpestapp.model.DataSeana_Request.ServiceRequestHeader;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Seana extends AppCompatActivity {

    EditText name,phone,address,location,typemachen,model,spacework,power,desreption;

    Button request;
    Bitmap bitmap=null;
    TextView getimage,canselimage;
    TextView price_offer;
    Double lat_String=0.0;
    Double long_String=0.0;

    String num_offer_val;


    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seana);

//        getdataFromJson(a);
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


        progressDialog=new ProgressDialog(Seana.this);
        getimage=findViewById(R.id.text_getimagee_designandPrograming);
        canselimage=findViewById(R.id.text_getimagee_hiden_designandPrograming);
        canselimage.setVisibility(View.GONE);
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

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().trim().isEmpty()){
                    name.setFocusableInTouchMode(true);
                    name.requestFocus();
                    name.setError("ادخل البيانات");
                }else if (phone.getText().toString().trim().isEmpty()){
                    phone.setFocusableInTouchMode(true);
                    phone.requestFocus();
                    phone.setError("ادخل البيانات");
                }else if (location.getText().toString().trim().isEmpty()){
                    location.setFocusableInTouchMode(true);
                    location.requestFocus();
                    location.setError("ادخل البيانات");
                }else if (address.getText().toString().trim().isEmpty()){
                    address.setFocusableInTouchMode(true);
                    address.requestFocus();
                    address.setError("ادخل البيانات");
                }else if (typemachen.getText().toString().trim().isEmpty()){
                    typemachen.setFocusableInTouchMode(true);
                    typemachen.requestFocus();
                    typemachen.setError("ادخل البيانات");
                }else if (model.getText().toString().trim().isEmpty()){
                    model.setFocusableInTouchMode(true);
                    model.requestFocus();
                    model.setError("ادخل البيانات");
                }else if (spacework.getText().toString().trim().isEmpty()){
                    spacework.setFocusableInTouchMode(true);
                    spacework.requestFocus();
                    spacework.setError("ادخل البيانات");
                }else if (power.getText().toString().trim().isEmpty()){
                    power.setFocusableInTouchMode(true);
                    power.requestFocus();
                    power.setError("ادخل البيانات");
                }else if (desreption.getText().toString().trim().isEmpty()){
                    desreption.setFocusableInTouchMode(true);
                    desreption.requestFocus();
                    desreption.setError("ادخل البيانات");
                }else{
                    addReqestData();
                }
            }
        });
    }

    private void defineUI() {
        name=findViewById(R.id.text_name_seana);
        name.setFocusableInTouchMode(false);
        name.setText(SharedPrefManager.getInstance(getApplicationContext()).getUsername());
//        name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                name.setFocusableInTouchMode(true);
//                name.setFocusableInTouchMode(true);
//                name.requestFocus();
//                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(name, InputMethodManager.SHOW_IMPLICIT);
//            }
//        });

        phone=findViewById(R.id.text_phone_seana);
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

        address=findViewById(R.id.text_address_seana);
        address.setFocusableInTouchMode(true);
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                address.setFocusableInTouchMode(false);
//                address.setFocusableInTouchMode(true);
//                address.requestFocus();
//                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(address, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        address.setText(SharedPrefManager.getInstance(getApplicationContext()).getadreess());

        location=findViewById(R.id.text_location_seana);
        location.setFocusableInTouchMode(false);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                location.setFocusableInTouchMode(true);
                location.setFocusableInTouchMode(true);
                location.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(location, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        typemachen=findViewById(R.id.text_typemachine_seana);
        typemachen.setFocusableInTouchMode(false);
        typemachen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typemachen.setFocusableInTouchMode(true);
                typemachen.setFocusableInTouchMode(true);
                typemachen.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(typemachen, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        model=findViewById(R.id.text_model_seana);
        model.setFocusableInTouchMode(false);
        model.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setFocusableInTouchMode(true);
                model.setFocusableInTouchMode(true);
                model.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(model, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        spacework=findViewById(R.id.text_space_seana);
        spacework.setFocusableInTouchMode(false);
        spacework.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spacework.setFocusableInTouchMode(true);
                spacework.setFocusableInTouchMode(true);
                spacework.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(spacework, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        power=findViewById(R.id.text_pword_seana);
        power.setFocusableInTouchMode(false);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                power.setFocusableInTouchMode(true);
                power.setFocusableInTouchMode(true);
                power.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(power, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        desreption=findViewById(R.id.text_description_seana);
        desreption.setFocusableInTouchMode(false);
        desreption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                desreption.setFocusableInTouchMode(true);
                desreption.setFocusableInTouchMode(true);
                desreption.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(desreption, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        request=findViewById(R.id.bu_request_seana);
    }


    private void addReqestData(){

        progressDialog.setMessage(" برجاء اﻻنتظار...");
        try{

        }catch (Exception e){
            Log.e("error send request",e.toString());
        }
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();



        final RequestQueue requestQueue = Volley.newRequestQueue(Seana.this);
        Gson gson = new Gson();
        DataSeanaRequest contactsTop=new DataSeanaRequest();

        Customer customer=new Customer();
        customer.setId(Integer.parseInt(SharedPrefManager.getInstance(getApplicationContext()).getid()));
        ServiceRequestHeader serviceRequestHeader=new ServiceRequestHeader();
        serviceRequestHeader.setCustomer(customer);
        serviceRequestHeader.setCustomerAddress(location.getText().toString().trim());
        serviceRequestHeader.setCustomerName(name.getText().toString().trim());
        serviceRequestHeader.setCustomerPhone(phone.getText().toString().trim());


        if (num_offer_val!=null){
            Offers offers=new Offers();
            offers.setId(num_offer_val);
            contactsTop.setOffers(offers);
        }



        MaintenanceSupportRequest maintenanceSupportRequest=new MaintenanceSupportRequest();

        maintenanceSupportRequest.setCustomerAddress(address.getText().toString().trim());
        maintenanceSupportRequest.setLatLocation(Double.valueOf(lat_String));
        maintenanceSupportRequest.setLngLocation(Double.valueOf(long_String));
        maintenanceSupportRequest.setMachineModel(model.getText().toString().trim());
        maintenanceSupportRequest.setMachinePower(power.getText().toString().trim());
        maintenanceSupportRequest.setRequestNote(desreption.getText().toString().trim());
        maintenanceSupportRequest.setWorkingArea(spacework.getText().toString().trim());
        maintenanceSupportRequest.setMachineType(typemachen.getText().toString().trim());



        contactsTop.setMaintenanceSupportRequest(maintenanceSupportRequest);
        contactsTop.setServiceRequestHeader( serviceRequestHeader);

        Log.e("Response -> Seana> ", gson.toJson(contactsTop));

        JSONObject jsonObject = null;
        try {
            jsonObject=new JSONObject(gson.toJson(contactsTop));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Urls.seanaRequest
                , jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.e("response_booking Seana",""+response);
//                finish();
                JSONObject sys = response;//// result

                Gson gson = new Gson();
                DataResposeDesingnAndPrograming dataDelevery;
                dataDelevery = gson.fromJson(response.toString(), DataResposeDesingnAndPrograming.class);

                if (dataDelevery.getErrorStatus().equals(false)||dataDelevery.getErrorStatus() == false){
                    if (bitmap != null) {
                        uploadBitmap("" + dataDelevery.getResultData().getId());
                    }else{
                        progressDialog.dismiss();
                        finish();
                    }

                }
//                Gson gson = new Gson();
//                DataResponseBooking dataDelevery;
//                dataDelevery = gson.fromJson(response.toString(), DataResponseBooking.class);

//                if (dataDelevery.getErrorStatus().equals(true)||dataDelevery.getErrorStatus() == true){
//                    showAlert(image,nameprodectAliaret,"idrequest");
//
//                }
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
        requestQueue.add(jsonObjectRequest);
    }

    String nameImage;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {

            //getting the image Uri
//            Uri imageUri = data.getData();
            Uri filePath = data.getData();

            File f = new File(String.valueOf(filePath));
//            String imageName = f.getPath();
            File myFile = new File(filePath.toString());
            String path = myFile.getAbsolutePath();
            String[] projection = {MediaStore.Images.Media.DATA};
            try {
                Cursor cursor = getContentResolver().query(filePath, projection, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(projection[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                Log.d("Picture Path", picturePath);
                Log.d("Picture name and type ", picturePath.split("/").toString());
                Log.d("Picture name and type 1",  picturePath.substring(picturePath.lastIndexOf('/') + 1));
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
                Log.d("image path ",filePath.toString());
                Log.d("image name >>>> ",path);

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

    private void uploadBitmap(String id) {
        progressDialog.setMessage(" برجاء اﻻنتظار...");
        //our custom volley request
        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST,
                Urls.api_test+"request-header-images/upload-request-image?serviceRequestId="+id+"&fileName="+nameImage,
//                Urls.api_test+"request-header-images/upload-request-image?serviceRequestId="+id+"&fileName=imageseana.jpg",
                new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response) {
                        progressDialog.dismiss();
                        try {
                            Log.e("responseimge>>>>>>>",""+response.toString());
                            JSONObject obj = new JSONObject(new String(response.data));
//                            Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            Log.e("responseimge>>>>>>>",""+obj.getString("errorStatus"));
                            boolean errprstates= Boolean.parseBoolean(obj.getString("errorStatus"));
                            if (obj.getString("errorStatus").equals(false)  || errprstates == false ){
//                                Toast.makeText(getApplicationContext(), obj.getString("Upload image"), Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                finish();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {


                    @Override
                    public void onErrorResponse(VolleyError error) {

                        progressDialog.dismiss();
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
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
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

        Log.e("header Seana ",SharedPrefManager.getInstance(getApplicationContext()).getheader());
        Log.e("url ",Urls.Seana_get_Offer +i);
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

//                                        TextView price_offer=findViewById(R.id.price_offer);

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

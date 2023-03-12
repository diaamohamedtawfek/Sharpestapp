package com.Sharpest.sharpestapp.Home.uiFragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.Sharpest.sharpestapp.Home.uiFragment.model.DataProfile.DataProfile;
import com.Sharpest.sharpestapp.Login_Signup.Login;
import com.Sharpest.sharpestapp.MySingleton;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.SharedPrefManager;
import com.Sharpest.sharpestapp.UI.UpDateProfile;
import com.Sharpest.sharpestapp.Urls;
import com.Sharpest.sharpestapp.VolleyMultipartRequest;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfile extends Fragment {

    public MyProfile() {
        // Required empty public constructor
    }

    TextView username,email,name,phone,phonewhats_profile,address_profile;
    ImageView imageView,image_update_profile;

    View view;

    Bitmap bitmap=null;
    String nav=null;

    String idfirst,idcustomer;

    public MyProfile(String nav) {
        this.nav=nav;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_my_profile, container, false);

        username=view.findViewById(R.id.username_profile);
        email=view.findViewById(R.id.email_profile);
        name=view.findViewById(R.id.name_profile);
        phone=view.findViewById(R.id.phone_profile);
        phonewhats_profile=view.findViewById(R.id.phonewhats_profile);
        address_profile=view.findViewById(R.id.address_profile);

        image_update_profile=view.findViewById(R.id.image_update_profile);
        image_update_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpDateProfile.class);
                intent.putExtra("idfirst",idfirst);
                intent.putExtra("whatsnumber",phonewhats_profile.getText().toString().trim());

                intent.putExtra("idCustomer",idcustomer);
                intent.putExtra("addresscusomer",address_profile.getText().toString().trim());
                intent.putExtra("name",name.getText().toString().trim());
                intent.putExtra("phone",phone.getText().toString().trim());
                startActivity(intent);
            }
        });



        imageView=view.findViewById(R.id.image_profile);




        if (nav == null){
            image_update_profile.setVisibility(View.VISIBLE);
        }else{
            image_update_profile.setVisibility(View.GONE);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(i, 100);
                }
            });
        }

        getjsonprofle();
        return view;
    }

    private void getjsonprofle() {
        ConnectivityManager conMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
            //Toast.makeText(context, "you don't have update "+REGISTER_URL, Toast.LENGTH_SHORT).show();
            final StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    Urls.dataUser,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Log.e("url>>>>>>>>profile ","  "+response);
                            if (response.length() > 0) {
                                //progressDialog.dismiss();
                                try {
                                    Gson gson = new Gson();
                                DataProfile dataDelevery;
                                dataDelevery = gson.fromJson(response.toString(), DataProfile.class);

                                    idfirst=""+dataDelevery.getResultData().getId();
                                    idcustomer=""+dataDelevery.getResultData().getCustomer().getId();

                                username.setText(""+dataDelevery.getResultData().getCustomer().getCustomerNameAr());
                                email.setText(""+dataDelevery.getResultData().getUserName());
                                name.setText(""+dataDelevery.getResultData().getCustomer().getCustomerNameAr());
                                phone.setText(""+dataDelevery.getResultData().getCustomer().getPhoneNumber1());
                                if (dataDelevery.getResultData().getWhatsupPhoneNumber()==null){
                                    phonewhats_profile.setText("");
                                }else{
                                    phonewhats_profile.setText(""+dataDelevery.getResultData().getWhatsupPhoneNumber());
                                }

                                address_profile.setText(""+dataDelevery.getResultData().getCustomer().getAddress());

                                    if (
                                            dataDelevery.getResultData().getCustomer().getProfileImage()==null
                                                    ||dataDelevery.getResultData().getCustomer().getProfileImage().equals(null)
                                                    || dataDelevery.getResultData().getCustomer().getProfileImage().isEmpty()
                                                    || dataDelevery.getResultData().getCustomer().getProfileImage()=="")
                                    {
                                        imageView.setImageResource(R.mipmap.sharpest_logo);
                                    }else {
                                        Picasso.with(getActivity())
                                                .load(dataDelevery.getResultData().getCustomer().getProfileImage())
                                                .error(R.mipmap.sharpest_logo)
                                                .into(imageView);
                                    }
                                }catch (Exception e){
                                    imageView.setImageResource(R.mipmap.sharpest_logo);
                                }

                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //progressDialog.dismiss();
//                            mSwipeRefreshLayout.setRefreshing(false);
                            try {
                                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                    Toast.makeText(getActivity(), "Error Network Time Out", Toast.LENGTH_LONG).show();
                                } else if (error instanceof AuthFailureError) {
                                    SharedPrefManager.getInstance(getActivity()).logout();
                                    startActivity(new Intent(getActivity(), Login.class));
                                    getActivity().finish();
                                    //startActivity(new Intent(getApplicationContext(),Log_In.class));
                                } else if (error instanceof ServerError) {
                                    Toast.makeText(getActivity(), "ServerError", Toast.LENGTH_LONG).show();
                                    //TODO
                                } else if (error instanceof NetworkError) {
                                    Toast.makeText(getActivity(), "NetworkError", Toast.LENGTH_LONG).show();
                                    //TODO
                                } else if (error instanceof ParseError) {
                                    Toast.makeText(getActivity(), "ParseError", Toast.LENGTH_LONG).show();
                                    //TODO
                                }
                            }catch (Exception e){

                            }

                        }
                    }
            ) {
                //            /** Passing some request headers* */
                @Override
                public Map getHeaders() throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Authorization",
                            SharedPrefManager.getInstance(getActivity()).getheader());
                    return headers;
                }
            };;

            MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);
        } else {
        }

    }







    /// uplode image

    String nameImage;
    //    uplode profile
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {

            //getting the image Uri
//            Uri imageUri = data.getData();
            Uri filePath = data.getData();
            String[] projection = {MediaStore.Images.Media.DATA};
            try {
                Cursor cursor = getActivity().getContentResolver().query(filePath, projection, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(projection[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                Log.d("Picture Path", picturePath);
                Log.d("Picture name and type", picturePath.split("/").toString());
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

                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePath);
                Bitmap lastBitmap = null;
                lastBitmap = bitmap;
                //encoding image to string
                String image = getStringImage(lastBitmap);
                Log.d("image",image);
                Log.d(">>>>>>>>>>>>>>>>>>>>  ",data.getDataString());


                uploadBitmap();

                //passing the image to volley
//                SendImage(image);
                //calling the method uploadBitmap to upload image
//                uploadBitmap();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    private void uploadBitmap() {
        final ProgressDialog progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage(" برجاء اﻻنتظار...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        //our custom volley request
        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST,
                Urls.uplodeImageProfile +SharedPrefManager.getInstance(getActivity()).getid_securety()+"&fileName="+nameImage,
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
//                                finish();

                                getjson( SharedPrefManager.getInstance(getActivity()).gettoken(),
                                        SharedPrefManager.getInstance(getActivity()).getid_type(),
                                        SharedPrefManager.getInstance(getActivity()).getheader());

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
                            Toast.makeText(getActivity(), "Error Network Time Out", Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {
                            SharedPrefManager.getInstance(getActivity()).logout();
                            startActivity(new Intent(getActivity(), Login.class));
                            getActivity().finish();
                            //startActivity(new Intent(getApplicationContext(),Log_In.class));
                        } else if (error instanceof ServerError) {
                            Toast.makeText(getActivity(), "ServerError", Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof NetworkError) {
                            Toast.makeText(getActivity(), "NetworkError", Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ParseError) {
                            Toast.makeText(getActivity(), "ParseError", Toast.LENGTH_LONG).show();
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
                        SharedPrefManager.getInstance(getActivity()).getheader());
                return headers;
            }
        };

        //adding the request to volley
        volleyMultipartRequest.setRetryPolicy(new DefaultRetryPolicy(
                1000000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//            mRequestQueue.add(stringRequest);

        RequestQueue mRequestQueue = Volley.newRequestQueue(getActivity());
        MySingleton.getInstance(getActivity()).addToRequestQueue(mRequestQueue.add(volleyMultipartRequest));
//        Volley.newRequestQueue(this).add(volleyMultipartRequest);
    }

    public byte[] getFileDataFromDrawable(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }


    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;

    }


    //  get login again

    private void getjson(final String tokin, final String type, final String authvalue) {
        ConnectivityManager conMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
            //Toast.makeText(context, "you don't have update "+REGISTER_URL, Toast.LENGTH_SHORT).show();
            final StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    Urls.dataUser,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Log.e("url>>>>>>>>profile@@@ ", "  " + response);
                            if (response.length() > 0) {
                                //progressDialog.dismiss();
                                Gson gson = new Gson();
                                DataProfile dataDelevery;
                                dataDelevery = gson.fromJson(response.toString(), DataProfile.class);

                                if (dataDelevery.getErrorStatus().equals(false) || dataDelevery.getErrorStatus() == false) {

                                    SharedPrefManager sharedPrefManager = new SharedPrefManager(getActivity());
                                    sharedPrefManager.userLogin(
                                            tokin,
                                            type,
                                            "" + dataDelevery.getResultData().getCustomer().getId(),
                                            dataDelevery.getResultData().getCustomer().getCustomerNameAr(),
                                            dataDelevery.getResultData().getUserName(),
                                            authvalue,
                                            dataDelevery.getResultData().getCustomer().getPhoneNumber1(),
                                            dataDelevery.getResultData().getCustomer().getAddress(),
                                            dataDelevery.getResultData().getCustomer().getProfileImage(),
                                            ""+dataDelevery.getResultData().getId()
                                    );

//                                    startActivity(new Intent(getActivity(), Home.class));
//                                    getActivity().finish();

                                    getjsonprofle();
                                }

////                                username.setText(""+dataDelevery.getResultData().getCustomer().getCustomerNameAr());
//                                email.setText(""+dataDelevery.getResultData().getUserName());
////                                name.setText(""+dataDelevery.getResultData().getCustomer().getCustomerNameAr());
////                                phone.setText(""+dataDelevery.getResultData().getCustomer().getPhoneNumber1());
//                                try {
//                                    if (
//                                            dataDelevery.getResultData().getCustomer().getProfileImage()==null
//                                                    ||dataDelevery.getResultData().getCustomer().getProfileImage().equals(null)
//                                                    || dataDelevery.getResultData().getCustomer().getProfileImage().isEmpty()
//                                                    || dataDelevery.getResultData().getCustomer().getProfileImage()=="")
//                                    {
////                                        imageView.setImageResource(R.mipmap.sharpest_logo);
//                                    }else {
////                                        Picasso.with(getActivity())
////                                                .load(dataDelevery.getResultData().getCustomer().getProfileImage())
////                                                .error(R.mipmap.sharpest_logo)
////                                                .into(imageView);
//                                    }
//                                }catch (Exception e){
////                                    imageView.setImageResource(R.mipmap.sharpest_logo);
//                                }

                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //progressDialog.dismiss();
//                            mSwipeRefreshLayout.setRefreshing(false);
                            if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                Toast.makeText(getActivity(), "Error Network Time Out", Toast.LENGTH_LONG).show();
                            } else if (error instanceof AuthFailureError) {
                                SharedPrefManager.getInstance(getActivity()).logout();
                                startActivity(new Intent(getActivity(), Login.class));
                                getActivity().finish();
                                //startActivity(new Intent(getApplicationContext(),Log_In.class));
                            } else if (error instanceof ServerError) {
                                Toast.makeText(getActivity(), "ServerError", Toast.LENGTH_LONG).show();
                                //TODO
                            } else if (error instanceof NetworkError) {
                                Toast.makeText(getActivity(), "NetworkError", Toast.LENGTH_LONG).show();
                                //TODO
                            } else if (error instanceof ParseError) {
                                Toast.makeText(getActivity(), "ParseError", Toast.LENGTH_LONG).show();
                                //TODO
                            }
                        }
                    }
            ) {
                //            /** Passing some request headers* */
                @Override
                public Map getHeaders() throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Authorization",
                            authvalue);
                    return headers;
                }
            };
            ;

            MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);
        } else {
        }

    }


}

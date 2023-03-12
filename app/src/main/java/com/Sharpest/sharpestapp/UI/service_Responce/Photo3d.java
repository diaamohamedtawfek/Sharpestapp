package com.Sharpest.sharpestapp.UI.service_Responce;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
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
import com.Sharpest.sharpestapp.Urls;
import com.Sharpest.sharpestapp.model.DataResponseBooking.DataResponseBooking;
import com.Sharpest.sharpestapp.model.DataSeana_Request.Offers;
import com.Sharpest.sharpestapp.model.Data_Photo3d.Customer;
import com.Sharpest.sharpestapp.model.Data_Photo3d.DataPhoto3d;
import com.Sharpest.sharpestapp.model.Data_Photo3d.ServiceRequestHeader;
import com.Sharpest.sharpestapp.model.Data_Photo3d.ThreeDimensionalImaging;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Photo3d extends AppCompatActivity {

    EditText name,phone,address,photoProdect,materia,dimantion,filerequest;
    Button request;
    TextView price_offer;
    String num_offer_val;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo3d);
        price_offer=findViewById(R.id.price_offer);
        defineUI();


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
                }else if (address.getText().toString().trim().isEmpty()){
                    address.setFocusableInTouchMode(true);
                    address.requestFocus();
                    address.setError("ادخل البيانات");
                }else if (photoProdect.getText().toString().trim().isEmpty()){
                    photoProdect.setFocusableInTouchMode(true);
                    photoProdect.requestFocus();
                    photoProdect.setError("ادخل البيانات");
                }else if (materia.getText().toString().trim().isEmpty()){
                    materia.setFocusableInTouchMode(true);
                    materia.requestFocus();
                    materia.setError("ادخل البيانات");
                }else if (dimantion.getText().toString().trim().isEmpty()){
                    dimantion.setFocusableInTouchMode(true);
                    dimantion.requestFocus();
                    dimantion.setError("ادخل البيانات");
                }else if (filerequest.getText().toString().trim().isEmpty()){
                    filerequest.setFocusableInTouchMode(true);
                    filerequest.requestFocus();
                    filerequest.setError("ادخل البيانات");
                }else{
                    addReqestData();
                }
            }
        });

    }

    private void defineUI() {
        name=findViewById(R.id.text_name_3d);
        name.setFocusableInTouchMode(false);
        name.setText(SharedPrefManager.getInstance(getApplicationContext()).getUsername());

        phone=findViewById(R.id.text_phone_3d);
        phone.setFocusableInTouchMode(false);
        phone.setText(SharedPrefManager.getInstance(getApplicationContext()).getphone());

        address=findViewById(R.id.text_location_3d);
        address.setFocusableInTouchMode(true);
        address.setText(SharedPrefManager.getInstance(getApplicationContext()).getadreess());

        photoProdect=findViewById(R.id.text_photo_request_3d);
        materia=findViewById(R.id.text_cualety_3d);
        dimantion=findViewById(R.id.text_dimantion_3d);
        filerequest=findViewById(R.id.text_file_request_3d);

        request=findViewById(R.id.bu_request_3d);
    }


    private void addReqestData(){
        final ProgressDialog progressDialog=new ProgressDialog(Photo3d.this);
        progressDialog.setMessage(" برجاء اﻻنتظار...");
        progressDialog.show();

        progressDialog.setCanceledOnTouchOutside(false);

        final RequestQueue requestQueue = Volley.newRequestQueue(Photo3d.this);
        Gson gson = new Gson();

        DataPhoto3d contactsTop=new DataPhoto3d();

        Customer customer=new Customer();
        customer.setId(Integer.parseInt(SharedPrefManager.getInstance(getApplicationContext()).getid()));
        ServiceRequestHeader serviceRequestHeader=new ServiceRequestHeader();
        serviceRequestHeader.setCustomer(customer);
        serviceRequestHeader.setCustomerAddress(address.getText().toString().trim());
        serviceRequestHeader.setCustomerName(name.getText().toString().trim());
        serviceRequestHeader.setCustomerPhone(phone.getText().toString().trim());

        if (num_offer_val!=null){
            Offers offers=new Offers();
            offers.setId(num_offer_val);
            contactsTop.setOffers(offers);
        }

        ThreeDimensionalImaging threeDimensionalImaging=new ThreeDimensionalImaging();
        threeDimensionalImaging.setCustomerAddress(address.getText().toString().trim());
        threeDimensionalImaging.setCustomerPhoneNumber(phone.getText().toString().trim());

        threeDimensionalImaging.setImagingArea(dimantion.getText().toString().trim());
        threeDimensionalImaging.setPrintingProduct( photoProdect.getText().toString().trim());

        threeDimensionalImaging.setRequestFileExtention(filerequest.getText().toString().trim());
        threeDimensionalImaging.setUsedMaterial(materia.getText().toString().trim());

        contactsTop.setServiceRequestHeader(serviceRequestHeader);
        contactsTop.setThreeDimensionalImaging( threeDimensionalImaging);

        Log.e("Volley:Response ", gson.toJson(contactsTop));

        JSONObject jsonObject = null;
        try {
            jsonObject=new JSONObject(gson.toJson(contactsTop));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Urls.photo3dRequest
                , jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Log.e("response_booking",""+response);
                finish();
                JSONObject sys = response;//// result

                Gson gson = new Gson();
                DataResponseBooking dataDelevery;
                dataDelevery = gson.fromJson(response.toString(), DataResponseBooking.class);

//                if (dataDelevery.getErrorStatus().equals(true)||dataDelevery.getErrorStatus() == true){
//                    showAlert(image,nameprodectAliaret,"idrequest");
//
//                }
//
                if (dataDelevery.getErrorStatus().equals(false)||dataDelevery.getErrorStatus() == false){
                    finish();

                }



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
        requestQueue.add(jsonObjectRequest);

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

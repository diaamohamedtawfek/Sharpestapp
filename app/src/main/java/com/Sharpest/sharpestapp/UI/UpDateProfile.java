package com.Sharpest.sharpestapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.android.volley.toolbox.Volley;
import com.Sharpest.sharpestapp.Home.Home;
import com.Sharpest.sharpestapp.Home.uiFragment.model.DataProfile.dataUpdateProfile.Customer;
import com.Sharpest.sharpestapp.Home.uiFragment.model.DataProfile.dataUpdateProfile.DataUpdateProfile;
import com.Sharpest.sharpestapp.Home.uiFragment.model.DataProfile.dataresponseupdate.DataREsponseUpdateProfile;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.SharedPrefManager;
import com.Sharpest.sharpestapp.Urls;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UpDateProfile extends AppCompatActivity {

    String idfirst,idCustomer;

    EditText name,address,phone,phonewhats;

    Button add_cinnatUsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_date_profile);

        name=findViewById(R.id.ed_name_updateprofile);
        address=findViewById(R.id.ed_address_updateprofile);
        phone=findViewById(R.id.ed_phone_updateprofile);
        phonewhats=findViewById(R.id.ed_phonewhats_updateprofile);


        Bundle extras = getIntent().getExtras(); // to get move intent
        if (extras != null) {

            String idfirstss = extras.getString("idfirst");
            String idCustomersss = extras.getString("idCustomer");

            String whatsnumber = extras.getString("whatsnumber");

            String addresscusomersss = extras.getString("addresscusomer");
            String phonesss = extras.getString("phone");
            String namess = extras.getString("name");
            if (idfirstss != null) {
                idfirst=idfirstss;
                idCustomer=idCustomersss;

                name.setText(namess);
                address.setText(addresscusomersss);
                phone.setText(phonesss);
                phonewhats.setText(whatsnumber);

//                getdataFromfilebase();
            }
        }

        add_cinnatUsData=findViewById(R.id.bu_add_conttactus);
        add_cinnatUsData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().toString().isEmpty()){
                    name.setError("ادخل البيانات");
                }else  if (address.getText().toString().toString().isEmpty()){
                    address.setError("ادخل البيانات");
                }else  if (phone.getText().toString().toString().isEmpty()){
                    phone.setError("ادخل البيانات");
                }else  if (phonewhats.getText().toString().toString().isEmpty()){
                    phonewhats.setError("ادخل البيانات");
                }else {
                    addReqestData();
                }
            }
        });


    }

    private void addReqestData(){
        final ProgressDialog progressDialog=new ProgressDialog(UpDateProfile.this);
        progressDialog.setMessage("Waite...");
        progressDialog.show();

        final RequestQueue requestQueue = Volley.newRequestQueue(UpDateProfile.this);
        Gson gson = new Gson();
        DataUpdateProfile contactsTop=new DataUpdateProfile();
        contactsTop.setId(Integer.valueOf(idfirst));
        contactsTop.setWhatsupPhoneNumber(phonewhats.getText().toString().trim());

        Customer customer=new Customer();
        customer.setId(Integer.valueOf(idCustomer));
        customer.setAddress(address.getText().toString().trim());
        customer.setCustomerNameAr(name.getText().toString().trim());
        customer.setPhoneNumber1(phone.getText().toString().trim());

        contactsTop.setCustomer(customer);


        Log.e("Volley:Response ", gson.toJson(contactsTop));
        Log.e("URl ", Urls.sendUpdateprofile);

        JSONObject jsonObject = null;
        try {
            jsonObject=new JSONObject(gson.toJson(contactsTop));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, Urls.sendUpdateprofile
                , jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Log.e("response_contactUs",""+response);

                JSONObject sys = response;//// result

                Gson gson = new Gson();
                DataREsponseUpdateProfile dataDelevery;
                dataDelevery = gson.fromJson(response.toString(), DataREsponseUpdateProfile.class);
                if (dataDelevery.getErrorStatus().equals(false) || dataDelevery.getErrorStatus() ==false  ){
//                    //namelocationSale.setText("");
//
                    Intent intent=new Intent(getApplicationContext(), Home.class);
                    intent.putExtra("test","profilehome");
                    startActivity(intent);
                    finish();
//                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "لم تم الاضافه  ", Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                try {
                    if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                        Toast.makeText(getApplicationContext(), "Error Network Time Out", Toast.LENGTH_LONG).show();
                    } else if (error instanceof AuthFailureError) {
//                    startActivity(new Intent(getApplicationContext(), LogIn.class));
//                    finish();
                        Toast.makeText(getApplicationContext(), "AuthFailureError", Toast.LENGTH_LONG).show();
                        //TODO
                    } else if (error instanceof ServerError) {
                        Toast.makeText(getApplicationContext(), "يرجي التاكد من ادخال البيانات", Toast.LENGTH_LONG).show();
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

}
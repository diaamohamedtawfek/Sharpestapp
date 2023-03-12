package com.Sharpest.sharpestapp.Login_Signup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
import com.android.volley.toolbox.Volley;
import com.Sharpest.sharpestapp.Home.Home;
import com.Sharpest.sharpestapp.Login_Signup.models.responceSignupError.DataResponseSignUpError;
import com.Sharpest.sharpestapp.Login_Signup.models.responsesignup.DataResponseSignUpDone;
import com.Sharpest.sharpestapp.Login_Signup.models.sendSignUp.Customer;
import com.Sharpest.sharpestapp.Login_Signup.models.sendSignUp.DataSendSignUp;
import com.Sharpest.sharpestapp.Login_Signup.models.sendSignUp.Role;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.Urls;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Collections;

public class SignUp extends AppCompatActivity {

    EditText name,email,phone,password,repassword,addrees;

    Button login;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        defineUi();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
                    //Toast.makeText(SignUp.this, "true", Toast.LENGTH_SHORT).show();

                    if (name.getText().toString().trim().isEmpty()){
                        name.setError("ادخل الاسم ");
                    }else if (email.getText().toString().trim().isEmpty()){
                        email.setError("ادخل اميل ");
                    }else if (phone.getText().toString().trim().isEmpty()){
                        phone.setError("ادخل رقم التليفون ");
                    }else if (password.getText().toString().trim().isEmpty()){
                        password.setError("ادخل الرقم السري ");
                    }else if (addrees.getText().toString().trim().isEmpty()){
                        addrees.setError("ادخل العنوان ");
                    }else{
                        if (password.getText().toString().trim().equals(repassword.getText().toString().trim())){
                            if (validateEmail()){
                            addReqestData();
                            }
                        }else{
                            password.setError("ادخل الرقم السري ");
                            repassword.setError("ادخل الرقم السري ");
                        }

//                        startActivity(new Intent(getApplicationContext(),All_LocationAndService_Sico.class));
                    }

                }else{
                    Toast.makeText(SignUp.this, "Check Your Network", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void defineUi() {

        password=findViewById(R.id.ed_password_login);
        password.setFocusableInTouchMode(false);
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password.setFocusableInTouchMode(true);
                password.setFocusableInTouchMode(true);
                password.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(password, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        repassword=findViewById(R.id.ed_repassword_login);
        repassword.setFocusableInTouchMode(false);
        repassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repassword.setFocusableInTouchMode(true);
                repassword.setFocusableInTouchMode(true);
                repassword.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(repassword, InputMethodManager.SHOW_IMPLICIT);
            }
        });



        addrees=findViewById(R.id.ed_address_login);
        addrees.setFocusableInTouchMode(false);
        addrees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addrees.setFocusableInTouchMode(true);
                addrees.setFocusableInTouchMode(true);
                addrees.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(addrees, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        email=findViewById(R.id.ed_email_login);
        email.setFocusableInTouchMode(false);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.setFocusableInTouchMode(true);
                email.setFocusableInTouchMode(true);
                email.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(email, InputMethodManager.SHOW_IMPLICIT);
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateEmail();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        name=findViewById(R.id.ed_name_login);
        name.setFocusableInTouchMode(false);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setFocusableInTouchMode(true);
                name.setFocusableInTouchMode(true);
                name.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(name, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        phone=findViewById(R.id.ed_phone_login);
        phone.setFocusableInTouchMode(false);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone.setFocusableInTouchMode(true);
                phone.setFocusableInTouchMode(true);
                phone.requestFocus();
                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(phone, InputMethodManager.SHOW_IMPLICIT);
            }
        });


        signup=findViewById(R.id.text_dignup_login);
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });


        login=findViewById(R.id.bu_start_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Home.class));
            }
        });

    }


    private void addReqestData(){
        final ProgressDialog progressDialog=new ProgressDialog(SignUp.this);
        progressDialog.setMessage("Waite...");
        progressDialog.show();

        final RequestQueue requestQueue = Volley.newRequestQueue(SignUp.this);
        Gson gson = new Gson();

        DataSendSignUp contactsTop=new DataSendSignUp();

        contactsTop.setPassword(password.getText().toString().trim());
//        contactsTop.setUsername(name.getText().toString().trim());
        contactsTop.setEmail(email.getText().toString().trim());

        Customer customer=new Customer();
        customer.setAddress(addrees.getText().toString().trim());
        customer.setCustomerName(name.getText().toString().trim());
        customer.setPhoneNumber(phone.getText().toString().trim());

        contactsTop.setCustomer(customer);

        Role role=new Role();
        role.setId(1);
        contactsTop.setRole(Collections.singletonList(role));


        Log.e("Volley:Response ", gson.toJson(contactsTop));

        JSONObject jsonObject = null;
        try {
            jsonObject=new JSONObject(gson.toJson(contactsTop));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Urls.siginUp
                , jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Log.e("response_booking",""+response);

                JSONObject sys = response;//// result

                Gson gson = new Gson();
                DataResponseSignUpDone dataDelevery;
                dataDelevery = gson.fromJson(response.toString(), DataResponseSignUpDone.class);

                    if (dataDelevery.getErrorStatus().equals(true)){
//                        Toast.makeText(SignUp.this, "true", Toast.LENGTH_SHORT).show();
                        Gson gsonerror = new Gson();
                        DataResponseSignUpError dataDeleveryerror;
                        dataDeleveryerror = gsonerror.fromJson(response.toString(), DataResponseSignUpError.class);
                        email.setError(""+dataDeleveryerror.getErrorResponsePayloadList().get(0).getArabicMessage());

                    }else{
                        Toast.makeText(SignUp.this, "تم التسجيل بنجاح ", Toast.LENGTH_LONG).show();
                        finish();
                    }



//                Log.e("?>>>response",dataDelevery.getArabicMessage());
//                if (dataDelevery.getKeyMessage().trim().equals("USER_REGISTERED_SUCCESSFULLY")){
//                    finish();
//                    Toast.makeText(getApplicationContext(), "تم التسجيل بنجاح ", Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(getApplicationContext(), dataDelevery.getArabicMessage(), Toast.LENGTH_LONG).show();
//                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String body;
                //get status code here
                String statusCode = String.valueOf(error.networkResponse.statusCode);
                //get response body and parse with appropriate encoding
                if(error.networkResponse.data!=null) {
                    try {
                        body = new String(error.networkResponse.data,"UTF-8");
                        try {
                            Gson gson = new Gson();
                            DataResponseSignUpError dataDelevery;
                            dataDelevery = gson.fromJson(new String(error.networkResponse.data, "UTF-8"), DataResponseSignUpError.class);

//                            Log.e("massage",dataDelevery.getArabicMessage());
                            if (dataDelevery.getErrorResponsePayloadList().get(0).getArabicMessage().trim().equals("اﻻسم مستخدم سابقا")) {
                                name.setError("اﻻسم مستخدم سابقا");
                            }else if (dataDelevery.getErrorResponsePayloadList().get(0).getArabicMessage().trim().equals("اﻻيميل مستخدم من قبل")) {
                                email.setError("اﻻيميل مستخدم من قبل");
                            }
                            Toast.makeText(getApplicationContext(), ""+dataDelevery.getErrorResponsePayloadList().get(0).getArabicMessage(), Toast.LENGTH_LONG).show();
                        }catch (Exception e){}
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

                progressDialog.dismiss();
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    Toast.makeText(getApplicationContext(), "Error Network Time Out", Toast.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {
//                    startActivity(new Intent(getApplicationContext(), LogIn.class));
//                    finish();
                    Toast.makeText(getApplicationContext(), "AuthFailureError", Toast.LENGTH_LONG).show();
                    //TODO
                } else if (error instanceof ServerError) {


//                    Toast.makeText(getApplicationContext(), "يرجي التاكد من ادخال البيانات", Toast.LENGTH_LONG).show();
                    //TODO
                } else if (error instanceof NetworkError) {
                    Toast.makeText(getApplicationContext(), "NetworkError", Toast.LENGTH_LONG).show();
                    //TODO
                } else if (error instanceof ParseError) {
                    Toast.makeText(getApplicationContext(), "ParseError", Toast.LENGTH_LONG).show();
                    //TODO
                }
            }

        });
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



    private boolean validateEmail() {
        String emailInput = email.getText().toString().trim();

        if (emailInput.isEmpty()) {
            email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Please enter a valid email email Like ex@gmail.com");
            return false;
        } else {
//            checkEmail_Is_Esxist(emailInput);
            email.setError(null);
            return true;
        }
    }
}

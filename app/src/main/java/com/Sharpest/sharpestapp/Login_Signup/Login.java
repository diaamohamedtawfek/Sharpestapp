package com.Sharpest.sharpestapp.Login_Signup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.Sharpest.sharpestapp.Home.Home;
import com.Sharpest.sharpestapp.Home.uiFragment.model.DataProfile.DataProfile;
import com.Sharpest.sharpestapp.Login_Signup.models.DataSendLogin;
import com.Sharpest.sharpestapp.Login_Signup.models.responselogin.DataResposeLogin;
import com.Sharpest.sharpestapp.MySingleton;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.SharedPrefManager;
import com.Sharpest.sharpestapp.Urls;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText email, password;

    Button login;
    TextView signup;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);


        Log.e("><><???//??",""+(month+1));
        Date d = new Date(year, (month+1), day);

        Calendar c = Calendar.getInstance();



        c.setTime(d);

        int weekOfYear = c.get(Calendar.WEEK_OF_YEAR);
        Log.e("><><?????",""+weekOfYear);
        Log.e("><><????:::?",""+year);
        Log.e("><><???//??",""+(month+1));

        if (SharedPrefManager.getInstance(getApplicationContext()).isLoggedIn()) {

            Intent intent = new Intent(getApplicationContext(), Home.class);

            startActivity(intent);
            finish();
        } else {

        }

        defineUi();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
                    //Toast.makeText(SignUp.this, "true", Toast.LENGTH_SHORT).show();

                    if (password.getText().toString().trim().isEmpty()) {
                        password.setError("ادخل الرقم السري ");
                    } else if (email.getText().toString().trim().isEmpty()) {
                        email.setError("ادخل اميل ");
                    } else {
                        addReqestData();
//                        startActivity(new Intent(getApplicationContext(),All_LocationAndService_Sico.class));
                    }

                } else {
                    Toast.makeText(Login.this, "Check Your Network", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void defineUi() {

        password = findViewById(R.id.ed_password_login);
//        password.setText("123456");
        password.setFocusableInTouchMode(false);
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password.setFocusableInTouchMode(true);
                password.setFocusableInTouchMode(true);
                password.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(password, InputMethodManager.SHOW_IMPLICIT);
            }
        });
        email = findViewById(R.id.ed_email_login);
//        email.setText("diaa@gmail.com");

        email.setFocusableInTouchMode(false);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.setFocusableInTouchMode(true);
                email.setFocusableInTouchMode(true);
                email.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(email, InputMethodManager.SHOW_IMPLICIT);
            }
        });


        signup = findViewById(R.id.text_dignup_login);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp.class));
            }
        });


        login = findViewById(R.id.bu_start_login);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), Home.class));
//            }
//        });


    }


    private void addReqestData() {
        final ProgressDialog progressDialog = new ProgressDialog(Login.this);
        progressDialog.setMessage("Waite...");
        progressDialog.show();

        final RequestQueue requestQueue = Volley.newRequestQueue(Login.this);
        Gson gson = new Gson();
        DataSendLogin contactsTop = new DataSendLogin();
        contactsTop.setPassword(password.getText().toString().trim());
        contactsTop.setUsername(email.getText().toString().trim());

        Log.e("Volley:Response ", gson.toJson(contactsTop));
        Log.e(">>>>login URL ", Urls.login);

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(gson.toJson(contactsTop));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Urls.login
                , jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();

                Log.e(">>>>>>>>>", ">>>>>>>>>@>>>>>>>>>>>>>");
                Log.e("response_booking", "" + response);

                Log.e(">>>>>>>>>", "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

                JSONObject sys = response;//// result

                Gson gson = new Gson();
                DataResposeLogin dataDelevery;
                dataDelevery = gson.fromJson(response.toString(), DataResposeLogin.class);
                if (dataDelevery.getErrorStatus().equals(true)) {

                    email.setError("يرجي التاكد من الاميل");
                    password.setError("يرجي التاكد من الباسورد");

                } else {
                    getjson(dataDelevery.getResultData().getToken(), dataDelevery.getResultData().getType(), dataDelevery.getResultData().getAuthValue());
                }

//                Log.e("?>>>response",dataDelevery.getToken());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
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


    private void getjson(final String tokin, final String type, final String authvalue) {
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
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

                                    SharedPrefManager sharedPrefManager = new SharedPrefManager(Login.this);
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

                                    startActivity(new Intent(getApplicationContext(), Home.class));
                                }
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //progressDialog.dismiss();
//                            mSwipeRefreshLayout.setRefreshing(false);
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

            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        } else {
        }

    }
}

package com.Sharpest.sharpestapp.Home.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.Sharpest.sharpestapp.Home.model.DataChangePassword;
import com.Sharpest.sharpestapp.Home.model.response_chamgePassword.DataResponseChangePassword;
import com.Sharpest.sharpestapp.Login_Signup.Login;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.SharedPrefManager;
import com.Sharpest.sharpestapp.Urls;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangePassword extends Fragment {

    public ChangePassword() {
        // Required empty public constructor
    }

    EditText currentPassword,password,repassword;
    Button addChangePassword;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_change_password, container, false);


        currentPassword=view.findViewById(R.id.ed_curentpaassowd_login);
        password=view.findViewById(R.id.ed_password_login);
        repassword=view.findViewById(R.id.ed_repassword_login);
        addChangePassword=view.findViewById(R.id.bu_changepassword);

        addChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPassword.getText().toString().trim().isEmpty()){
                    currentPassword.setFocusableInTouchMode(true);
                    currentPassword.requestFocus();
                    currentPassword.setError("ادخل البيانات");
                }else if (password.getText().toString().trim().isEmpty()){
                    password.setFocusableInTouchMode(true);
                    password.requestFocus();
                    password.setError("ادخل البيانات");
                }else if (repassword.getText().toString().trim().isEmpty()){
                    repassword.setFocusableInTouchMode(true);
                    repassword.requestFocus();
                    repassword.setError("ادخل البيانات");
                }else if (password.getText().toString().trim().length()<9){
                    password.setFocusableInTouchMode(true);
                    password.requestFocus();
                    password.setError("ادخل البيانات");
                }else if (repassword.getText().toString().trim().isEmpty() != password.getText().toString().trim().isEmpty()){
                    repassword.setError("ادخل البيانات");
                    password.setError("ادخل البيانات");
                    repassword.setFocusableInTouchMode(true);
                    repassword.requestFocus();
                    password.setFocusableInTouchMode(true);
                    password.requestFocus();

                }else{
                    addReqestData();
                }
            }
        });

        return view;
    }

    private void addReqestData(){
        final ProgressDialog progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Waite...");
        progressDialog.show();

        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        Gson gson = new Gson();

        DataChangePassword contactsTop=new DataChangePassword();

        contactsTop.setCurrentPassword(currentPassword.getText().toString().trim());
        contactsTop.setConfirmPassword( repassword.getText().toString().trim());
        contactsTop.setNewPassword( password.getText().toString().trim());

        Log.e("Volley:Response ", gson.toJson(contactsTop));

        JSONObject jsonObject = null;
        try {
            jsonObject=new JSONObject(gson.toJson(contactsTop));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Urls.changepassword
                , jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Log.e("response_booking",""+response);
                //finish();
                JSONObject sys = response;//// result

                Gson gson = new Gson();
                DataResponseChangePassword dataDelevery;
                dataDelevery = gson.fromJson(response.toString(), DataResponseChangePassword.class);

                if (dataDelevery.getErrorStatus().equals(true)||dataDelevery.getErrorStatus() == true){
                   if (dataDelevery.getErrorResponsePayloadList().get(0).getArabicMessage().equals(" اسم المستخدم او الرقم السرى خطا") ||
                           dataDelevery.getErrorResponsePayloadList().get(0).getArabicMessage()==" اسم المستخدم او الرقم السرى خطا"){

                       Toast.makeText(getActivity(), "اسم المستخدم او الرقم السرى خطا", Toast.LENGTH_LONG).show();
                   }

                }else if (dataDelevery.getErrorStatus().equals(false)||dataDelevery.getErrorStatus() == false){
                    Toast.makeText(getActivity(), "تم التعديل بنجاح", Toast.LENGTH_SHORT).show();
                    currentPassword.setText("");
                    password.setText("");
                    repassword.setText("");
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
                    Toast.makeText(getActivity(), "Error Network Time Out", Toast.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {
                    SharedPrefManager.getInstance(getActivity()).logout();
                    startActivity(new Intent(getActivity(), Login.class));
                    getActivity().finish();
//                        Toast.makeText(getApplicationContext(), "AuthFailureError", Toast.LENGTH_LONG).show();
                    //TODO
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

        }){
            //            /** Passing some request headers* */
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Authorization",
                        SharedPrefManager.getInstance(getActivity()).getheader());
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

}

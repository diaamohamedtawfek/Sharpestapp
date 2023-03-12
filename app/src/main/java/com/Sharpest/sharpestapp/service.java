package com.Sharpest.sharpestapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class service extends IntentService {
    public static volatile boolean shouldStop = false;
    public service() {
        super(service.class.getSimpleName());
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    protected void onHandleIntent(Intent intent) {

//        final RequestQueue requestQueue = Volley.newRequestQueue(Login.this);
//        Gson gson = new Gson();
//        DataSendLogin contactsTop = new DataSendLogin();
//        contactsTop.setPassword(password.getText().toString().trim());
//        contactsTop.setUsername(email.getText().toString().trim());
//
//        Log.e("Volley:Response ", gson.toJson(contactsTop));
//
//        JSONObject jsonObject = null;
//        try {
//            jsonObject = new JSONObject(gson.toJson(contactsTop));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Urls.login
//                , jsonObject, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                progressDialog.dismiss();
//
//                Log.e(">>>>>>>>>", ">>>>>>>>>@>>>>>>>>>>>>>");
//                Log.e("response_booking", "" + response);
//
//                Log.e(">>>>>>>>>", "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//
//                JSONObject sys = response;//// result
//
//                Gson gson = new Gson();
//                DataResposeLogin dataDelevery;
//                dataDelevery = gson.fromJson(response.toString(), DataResposeLogin.class);
//                if (dataDelevery.getErrorStatus().equals(true)) {
//
////                    email.setError("يرجي التاكد من الاميل");
////                    password.setError("يرجي التاكد من الباسورد");
//
//                } else {
//                    getjson(dataDelevery.getResultData().getToken(), dataDelevery.getResultData().getType(), dataDelevery.getResultData().getAuthValue());
//                }
//
////                Log.e("?>>>response",dataDelevery.getToken());
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//               // progressDialog.dismiss();
//                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
//                    Toast.makeText(getApplicationContext(), "Error Network Time Out", Toast.LENGTH_LONG).show();
//                } else if (error instanceof AuthFailureError) {
////                    startActivity(new Intent(getApplicationContext(), LogIn.class));
////                    finish();
//                    Toast.makeText(getApplicationContext(), "AuthFailureError", Toast.LENGTH_LONG).show();
//                    //TODO
//                } else if (error instanceof ServerError) {
//                    Toast.makeText(getApplicationContext(), "يرجي التاكد من ادخال البيانات", Toast.LENGTH_LONG).show();
//                    //TODO
//                } else if (error instanceof NetworkError) {
//                    Toast.makeText(getApplicationContext(), "NetworkError", Toast.LENGTH_LONG).show();
//                    //TODO
//                } else if (error instanceof ParseError) {
//                    Toast.makeText(getApplicationContext(), "ParseError", Toast.LENGTH_LONG).show();
//                    //TODO
//                }
//            }
//
//        });
////        {
////            /** Passing some request headers* */
////            @Override
////            public Map getHeaders() throws AuthFailureError {
////                HashMap headers = new HashMap();
////                headers.put("Authorization",
////                        SharedPrefManager_Login.getInstance(getApplicationContext()).getaccessType()+" "+
////                                SharedPrefManager_Login.getInstance(getApplicationContext()).getjwt());
////                return headers;
////            }
////        };;
//        requestQueue.add(jsonObjectRequest);


        Intent intent1 = new Intent("com.example.sharpestapp");
        intent1.putExtra("someName", "Tutorialspoint.com");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent1);
        if(shouldStop){
            stopSelf();
            return;
        }
    }
}
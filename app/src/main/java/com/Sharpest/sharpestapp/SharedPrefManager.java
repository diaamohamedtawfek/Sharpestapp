package com.Sharpest.sharpestapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by egy10 on 7/26/18.
 */

public class SharedPrefManager {


    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";//>>>>>>>>>>>>>>>>>>>>>>>>
    // ,,,,,,,,,
    private static final String KEY_token = "token";
    private static final String KEY_type = "type";
    private static final String KEY_id = "id";
    private static final String KEY_id_securety = "id_securety";

    private static final String KEY_username = "username";

    private static final String KEY_email = "email";

    private static final String KEY_authValue = "authValue";
    private static final String KEY_phone = "phone";

    private static final String KEY_address = "address";
    private static final String KEY_image = "image";


    public SharedPrefManager(Context context) {
        mCtx = context;

    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(
            String token, String type, String id
            , String username, String email, String authValue, String phone, String address, String image, String id_securety) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_token, token);
        editor.putString(KEY_type, type);
        editor.putString(KEY_username, username);
        editor.putString(KEY_authValue, authValue);
        editor.putString(KEY_email, email);
        editor.putString(KEY_id, id);
        editor.putString(KEY_phone, phone);
        editor.putString(KEY_address, address);
        editor.putString(KEY_image, image);
        editor.putString(KEY_id_securety, id_securety);
        editor.apply();

        return true;
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_email, null) != null) {
            return true;
        }
        return false;
    }

    public boolean logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }

    //
    public String getUsername() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_username, null);
    }

    public String getimage() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_image, null);
    }

//    public String getImage(){
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        return sharedPreferences.getString(KEY_Image, null);
//    }

    //
    public String getheader() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_authValue, null);
    }

    public String getid() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_id, null);
    }

    public String getemail() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_email, null);
    }

    public String getadreess() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_address, null);
    }

    public String getphone() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_phone, null);
    }

    public String getid_securety() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_id_securety, null);
    }


    public String getid_type() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_type, null);
    }

    public String gettoken() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_token, null);
    }
}

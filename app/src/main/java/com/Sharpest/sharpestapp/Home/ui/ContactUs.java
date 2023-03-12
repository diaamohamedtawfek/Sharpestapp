package com.Sharpest.sharpestapp.Home.ui;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import com.Sharpest.sharpestapp.Login_Signup.Login;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.SharedPrefManager;
import com.Sharpest.sharpestapp.Urls;
import com.Sharpest.sharpestapp.model.contactuss.DataResponseContactUs;
import com.Sharpest.sharpestapp.model.contactuss.DataSendContactUs;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUs extends Fragment {

    public ContactUs() {
        // Required empty public constructor
    }

    View view;
    private int STORAGE_PERMISSION_CODE = 1;

    TextView locationCairo,phone1Cairo,phone2Cairo,locationCairoEN,phone1CairoEN,phone2CairoEN;

    TextView locationDamietta,phone1Damietta,locationDamiettaEN,phone1DamiettaEN;

    TextView locationAlex,phone1Alex,phone2Alex,phone3Alex,locationAlexEN,phone1AlexEN,phone2AlexEN,phone3AlexEN;


    LinearLayout linearWebsite,linearWhatsapp,linearInstegram,linearTwitter,linearYouTube,linear_Ehotline;

    EditText name,email,phone,massage;
    Button add_cinnatUsData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_contact_us, container, false);

        defineContactUs();

        defineUI_TEXTCAIRO();
        defineUI_TEXTAlex();

        defineUI_LinearWEBSITE();

        defineUI_TEXTDamietta();


        defineUI_INSTEGRAM_Twitter_YouTube_Ehotline();

        return view;
    }

    private void defineContactUs() {
        name=view.findViewById(R.id.ed_name_conttactus);
        email=view.findViewById(R.id.ed_email_conttactus);
        phone=view.findViewById(R.id.ed_phone_conttactus);
        massage=view.findViewById(R.id.ed_massage_conttactus);
        add_cinnatUsData=view.findViewById(R.id.bu_add_conttactus);
        add_cinnatUsData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().toString().isEmpty()){
                    name.setError("ادخل البيانات");
                }else  if (email.getText().toString().toString().isEmpty()){
                    email.setError("ادخل البيانات");
                }else  if (phone.getText().toString().toString().isEmpty()){
                    phone.setError("ادخل البيانات");
                }else  if (massage.getText().toString().toString().isEmpty()){
                    massage.setError("ادخل البيانات");
                }else {
                    addReqestData();
                }
            }
        });
    }

    private void defineUI_INSTEGRAM_Twitter_YouTube_Ehotline() {
        linearInstegram=view.findViewById(R.id.linear_Instagram);
        linearInstegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/sharpestlaser/")));
//                    String url = "www.alsafarpartners.com";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    startActivity(i);
                }catch (Exception e){

                }

            }
        });




        linearTwitter=view.findViewById(R.id.linear_Twitter);
        linearTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/sharpestlaser")));
//                    String url = "www.alsafarpartners.com";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    startActivity(i);
                }catch (Exception e){

                }

            }
        });


        linearYouTube=view.findViewById(R.id.linear_YouTube);
        linearYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/smtlaser")));
//                    String url = "www.alsafarpartners.com";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    startActivity(i);
                }catch (Exception e){

                }

            }
        });


        linear_Ehotline=view.findViewById(R.id.linear_Ehotline);
        linear_Ehotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.45000.tel/")));
//                    String url = "www.alsafarpartners.com";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    startActivity(i);
                }catch (Exception e){

                }

            }
        });
    }

    private void defineUI_LinearWEBSITE() {
        linearWebsite=view.findViewById(R.id.liner_webSite);
        linearWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://sharpestlaser.com/")));
//                    String url = "www.alsafarpartners.com";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    startActivity(i);
                }catch (Exception e){

                }

            }
        });

        linearWhatsapp=view.findViewById(R.id.linear_Whatsapp);
        linearWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ERROR WHATSAPP","e.toString())");
                try {
                    try{
                        PackageManager packageManager = getActivity().getPackageManager();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        String url = "https://api.whatsapp.com/send?phone=+201144000680";
                        i.setPackage("com.whatsapp");
                        i.setData(Uri.parse(url));
                        if (i.resolveActivity(packageManager) != null) {
                            startActivity(i);
                        }else {
                            Log.e("ERROR WHATSAPP","e.toString())");
                            Toast.makeText(getActivity(), "لا يوجد لديك واتس اب علي الهاتف", Toast.LENGTH_SHORT).show();
//                            KToast.errorToast(getActivity(), getString(R.string.no_whatsapp), Gravity.BOTTOM, KToast.LENGTH_SHORT);
                        }
                    } catch(Exception e) {
                        Log.e("ERROR WHATSAPP",e.toString());
//                        KToast.errorToast(getActivity(), getString(R.string.no_whatsapp), Gravity.BOTTOM, KToast.LENGTH_SHORT);
                    }
                }catch (Exception e){
                    Log.e("ERROR WHATSAPP",e.toString());
                }

            }
        });
    }

    private void defineUI_TEXTCAIRO() {

        locationCairo=view.findViewById(R.id.text_locationCairo);
        locationCairo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String strUri = "http://maps.google.com/maps?q=loc:" + lat + "," + lng + " (" + "Label which you want" + ")";
                Log.e("cairo","http://maps.google.com/maps?daddr=30.0549946,31.2483316");

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?daddr=30.0549946,31.2483316"));
//                            Uri.parse("google.navigation:q=٤٥ شارع نجیب الریحاني الازبكیة وسط البلد القاهرة"));
//                            Uri.parse("google.navigation:q=٤٥ شارع نجیب الریحاني الازبكیة وسط البلد القاهرة"));
                    startActivity(intent);
                }catch (Exception e){

                    try {
                        Log.e(">",e.toString());
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=30.0549946,31.2483316"));
//                                Uri.parse("geo:0,0?q=٤٥ شارع نجیب الریحاني الازبكیة وسط البلد القاهرة"));
                        startActivity(intent);
                    }catch (Exception ex){
                        Log.e(">",ex.toString());
                    }

                }

            }
        });

        phone1Cairo=view.findViewById(R.id.phone1Cairo);
        phone1Cairo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(ProfilLawer.this, "You have already granted this permission!",
//                            Toast.LENGTH_SHORT).show();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "01144000684"));
                    startActivity(callIntent);
                } else {
                    requestStoragePermission();
                }

            }
        });


        phone2Cairo=view.findViewById(R.id.phone2Cairo);
        phone2Cairo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(ProfilLawer.this, "You have already granted this permission!",
//                            Toast.LENGTH_SHORT).show();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "01144000685"));
                    startActivity(callIntent);
                } else {
                    requestStoragePermission();
                }

            }
        });

        locationCairoEN=view.findViewById(R.id.text_locationCairo);
        locationCairoEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?daddr=30.0549946,31.2483316"));
//                            Uri.parse("google.navigation:q=٤٥ شارع نجیب الریحاني الازبكیة وسط البلد القاهرة"));
//                            Uri.parse("google.navigation:q=٤٥ شارع نجیب الریحاني الازبكیة وسط البلد القاهرة"));
                    startActivity(intent);
                }catch (Exception e){

                    try {
                        Log.e(">",e.toString());
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=30.0549946,31.2483316"));
//                                Uri.parse("geo:0,0?q=٤٥ شارع نجیب الریحاني الازبكیة وسط البلد القاهرة"));
                        startActivity(intent);
                    }catch (Exception ex){
                        Log.e(">",ex.toString());
                    }

                }

            }
        });

        phone1CairoEN=view.findViewById(R.id.phone1Cairo);
        phone1CairoEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(ProfilLawer.this, "You have already granted this permission!",
//                            Toast.LENGTH_SHORT).show();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "01144000684"));
                    startActivity(callIntent);
                } else {
                    requestStoragePermission();
                }

            }
        });


        phone2CairoEN=view.findViewById(R.id.phone2Cairo);
        phone2CairoEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(ProfilLawer.this, "You have already granted this permission!",
//                            Toast.LENGTH_SHORT).show();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "01144000685"));
                    startActivity(callIntent);
                } else {
                    requestStoragePermission();
                }

            }
        });

    }

    private void defineUI_TEXTDamietta() {



        locationDamietta=view.findViewById(R.id.text_locationDamietta);
        locationDamietta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uri.parse("http://maps.google.com/maps?saddr=30.0549946&daddr=31.2483316"));
                //"geo:0,0?q=30.0549946,31.2483316"
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?daddr=31.417846,31.813523"));
//                            Uri.parse("google.navigation:q=8 Ibn-Marwan st from ElGalaa st "));
                    startActivity(intent);
                }catch (Exception e){

                    try {
                        Log.e(">",e.toString());
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=31.417846,31.813523"));
                        startActivity(intent);
                    }catch (Exception ex){
                        Log.e(">",ex.toString());
                    }

                }



            }
        });

        phone1Damietta=view.findViewById(R.id.phone1Damietta);
        phone1Damietta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(ProfilLawer.this, "You have already granted this permission!",
//                            Toast.LENGTH_SHORT).show();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "+201144000682"));
                    startActivity(callIntent);
                } else {
                    requestStoragePermission();
                }

            }
        });


        locationDamiettaEN=view.findViewById(R.id.text_locationDamiettaEN);
        locationDamiettaEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?daddr=31.417846,31.813523"));
//                            Uri.parse("google.navigation:q=8 Ibn-Marwan st from ElGalaa st "));
                    startActivity(intent);
                }catch (Exception e){

                    try {
                        Log.e(">",e.toString());
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=31.417846,31.813523"));
                        startActivity(intent);
                    }catch (Exception ex){
                        Log.e(">",ex.toString());
                    }

                }



            }
        });

        phone1DamiettaEN=view.findViewById(R.id.phone1DamiettaEN);
        phone1DamiettaEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(ProfilLawer.this, "You have already granted this permission!",
//                            Toast.LENGTH_SHORT).show();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "+201144000682"));
                    startActivity(callIntent);
                } else {
                    requestStoragePermission();
                }

            }
        });

    }



    private void defineUI_TEXTAlex() {

        locationAlex=view.findViewById(R.id.text_locationAlex);
        locationAlex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?daddr=31.219037,29.958927"));
//                            Uri.parse("http://maps.google.com/maps?saddr=31.219037&daddr=29.958927"));
//                            Uri.parse("google.navigation:q=8 Ibn-Marwan st from ElGalaa st "));
                    startActivity(intent);
                }catch (Exception e){

                    try {
                        Log.e(">",e.toString());
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=31.219037,29.958927"));
                        startActivity(intent);
                    }catch (Exception ex){
                        Log.e(">",ex.toString());
                    }

                }
            }
        });

        phone1Alex=view.findViewById(R.id.phone1Alex);
        phone1Alex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(ProfilLawer.this, "You have already granted this permission!",
//                            Toast.LENGTH_SHORT).show();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "+201144000686"));
                    startActivity(callIntent);
                } else {
                    requestStoragePermission();
                }

            }
        });


        phone2Alex=view.findViewById(R.id.phone2Alex);
        phone2Alex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(ProfilLawer.this, "You have already granted this permission!",
//                            Toast.LENGTH_SHORT).show();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "+201140709925"));
                    startActivity(callIntent);
                } else {
                    requestStoragePermission();
                }

            }
        });


        phone3Alex=view.findViewById(R.id.phone2Alex);
        phone3Alex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(ProfilLawer.this, "You have already granted this permission!",
//                            Toast.LENGTH_SHORT).show();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "+2034269518"));
                    startActivity(callIntent);
                } else {
                    requestStoragePermission();
                }

            }
        });



        locationAlexEN=view.findViewById(R.id.text_locationAlexEN);
        locationAlexEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?daddr=31.219037,29.958927"));
//                            Uri.parse("http://maps.google.com/maps?saddr=31.219037&daddr=29.958927"));
//                            Uri.parse("google.navigation:q=8 Ibn-Marwan st from ElGalaa st "));
                    startActivity(intent);
                }catch (Exception e){

                    try {
                        Log.e(">",e.toString());
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=31.219037,29.958927"));
                        startActivity(intent);
                    }catch (Exception ex){
                        Log.e(">",ex.toString());
                    }

                }

            }
        });

        phone1AlexEN=view.findViewById(R.id.phone1AlexEN);
        phone1AlexEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(ProfilLawer.this, "You have already granted this permission!",
//                            Toast.LENGTH_SHORT).show();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "+201144000686"));
                    startActivity(callIntent);
                } else {
                    requestStoragePermission();
                }

            }
        });


        phone2AlexEN=view.findViewById(R.id.phone2AlexEN);
        phone2AlexEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(ProfilLawer.this, "You have already granted this permission!",
//                            Toast.LENGTH_SHORT).show();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "+201140709925"));
                    startActivity(callIntent);
                } else {
                    requestStoragePermission();
                }

            }
        });


        phone3AlexEN=view.findViewById(R.id.phone2AlexEN);
        phone3AlexEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(ProfilLawer.this, "You have already granted this permission!",
//                            Toast.LENGTH_SHORT).show();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "+2034269518"));
                    startActivity(callIntent);
                } else {
                    requestStoragePermission();
                }

            }
        });


    }







    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.CALL_PHONE)) {

            new android.app.AlertDialog.Builder(getActivity())
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed because of this and that")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(getActivity(),
                                    new String[] {Manifest.permission.CALL_PHONE}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[] {Manifest.permission.CALL_PHONE}, STORAGE_PERMISSION_CODE);
        }
    }





    private void addReqestData(){
        final ProgressDialog progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Waite...");
        progressDialog.show();

        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        Gson gson = new Gson();
        DataSendContactUs contactsTop=new DataSendContactUs();
        contactsTop.setEmail(email.getText().toString().trim());
        contactsTop.setFullName(name.getText().toString().trim());
        contactsTop.setMessage(massage.getText().toString().trim());
        contactsTop.setPhoneNumber(phone.getText().toString().trim());


        Log.e("Volley:Response ", gson.toJson(contactsTop));

        JSONObject jsonObject = null;
        try {
            jsonObject=new JSONObject(gson.toJson(contactsTop));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Urls.sendConntactUs
                , jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Log.e("response_contactUs",""+response);

                JSONObject sys = response;//// result

                Gson gson = new Gson();
                DataResponseContactUs dataDelevery;
                dataDelevery = gson.fromJson(response.toString(), DataResponseContactUs.class);
                if (dataDelevery.getErrorStatus().equals(false) || dataDelevery.getErrorStatus() ==false  ){
//                    //namelocationSale.setText("");
//
                    Toast.makeText(getActivity(), "شكرا لتواصلك معانا سيتم التواصل من قبل الاداره ", Toast.LENGTH_LONG).show();
                    name.setText("");
                    email.setText("");
                    phone.setText("");
                    massage.setText("");
//                    finish();
                }else{
                    Toast.makeText(getActivity(), "لم تم الاضافه  ", Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                try {
                    if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                        Toast.makeText(getActivity(), "Error Network Time Out", Toast.LENGTH_LONG).show();
                    } else if (error instanceof AuthFailureError) {
                        SharedPrefManager.getInstance(getActivity()).logout();
                        startActivity(new Intent(getActivity(), Login.class));
                        getActivity().finish();
                        //TODO
                    } else if (error instanceof ServerError) {
                        Toast.makeText(getActivity(), "يرجي التاكد من ادخال البيانات", Toast.LENGTH_LONG).show();
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

        requestQueue.add(jsonObjectRequest);

    }
}

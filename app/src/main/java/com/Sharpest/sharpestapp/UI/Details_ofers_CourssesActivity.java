package com.Sharpest.sharpestapp.UI;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.Sharpest.sharpestapp.UI.DataCourseSEND.Course;
import com.Sharpest.sharpestapp.UI.DataCourseSEND.DataSendReqestCoursePROMOCODE;
import com.Sharpest.sharpestapp.UI.DataCourseSEND.Offers;
import com.Sharpest.sharpestapp.UI.DataCourseSEND.responsePromcode.DataResultDataPromocode;
import com.Sharpest.sharpestapp.Urls;
import com.Sharpest.sharpestapp.adaptor.ContentCourse_DetlesCours_viewHolder;
import com.Sharpest.sharpestapp.adaptor.DetilesCource_Course_DetlesCours_viewHolder;
import com.Sharpest.sharpestapp.adaptor.Learn_Course_DetlesCours_viewHolder;
import com.Sharpest.sharpestapp.model.DataDetaliesCoursess.CourseContent;
import com.Sharpest.sharpestapp.model.DataDetaliesCoursess.CourseOutline;
import com.Sharpest.sharpestapp.model.DataDetaliesCoursess.CourseRoundDetail;
import com.Sharpest.sharpestapp.model.DataDetaliesCoursess.DataDetilesCourse;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Details_ofers_CourssesActivity extends AppCompatActivity {

    ImageView imageView;
//    TextView onlineor,time_dateCourse,description;
    TextView description,promoCode,must_addphone;
    String id,offers_id;

    CardView card_detales;


    /// list detels cource
    //>>> RecyclerView content course
    RecyclerView recyclerView_contentCource;
    private ContentCourse_DetlesCours_viewHolder recyclerView_dAdapter;

    // list detiles cource
    RecyclerView recyclerView_DetilesCource;
    private DetilesCource_Course_DetlesCours_viewHolder recyclerView_dAdapter_DetilesCource;

    // list what do you learn
    RecyclerView recyclerView_learnCource;
    LinearLayout addrequest;

    private Learn_Course_DetlesCours_viewHolder recyclerView_learn_dAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_details__coursses);
        defineUi();

        must_addphone=findViewById(R.id.text_mustaddphone);
        card_detales=findViewById(R.id.card_detales);
        Bundle extras = getIntent().getExtras(); // to get move intent
        if (extras != null) {
            String a = extras.getString("id_product");
            String test = extras.getString("test");
            if (a!=null){
                id= a;
            }
            if (test!=null){
                addrequest.setVisibility(View.GONE);
//                description.setVisibility(View.GONE);
                promoCode.setVisibility(View.GONE);
                must_addphone.setVisibility(View.GONE);
                card_detales.setVisibility(View.GONE);

            }
        }


        getjson();
    }

    public void defineUi(){

        addrequest=findViewById(R.id.addrequest_curce);
        addrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(Details_ofers_CourssesActivity.this, "String msg");
            }
        });

        promoCode=findViewById(R.id.promocode_cource);
        promoCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(Details_ofers_CourssesActivity.this, "promo");
            }
        });


        imageView=findViewById(R.id.image_detiless_coursses);
//        onlineor=findViewById(R.id.text_type_onlineor_detilesCourse);
//        time_dateCourse=findViewById(R.id.text_timedateCourse);
//
        description=findViewById(R.id.text_description_detielse_corsess);

        ///define recycal
        recyclerView_contentCource=(RecyclerView) findViewById(R.id.recycal_contentCourses_detielscorce);
        recyclerView_learnCource=(RecyclerView) findViewById(R.id.recycal_youlearn_detielscorce);
        recyclerView_DetilesCource=(RecyclerView) findViewById(R.id.recycal_detilelsCource_detielscorce);

    }


    private void getjson() {
        Log.e("curssesD",Urls.Details_Coursess+id);
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
            //Toast.makeText(context, "you don't have update "+REGISTER_URL, Toast.LENGTH_SHORT).show();
            final StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    Urls.Details_Coursess+id ,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response>>>>",response.toString());

                            if (response.length() > 0) {
                                //progressDialog.dismiss();
                                try {

                                Gson gson = new Gson();
                                DataDetilesCourse dataDelevery;
                                dataDelevery = gson.fromJson(response.toString(), DataDetilesCourse.class);


                                if (dataDelevery.getErrorStatus().equals(false)){

                                    try {
                                        //Detiles course
                                        List<CourseRoundDetail> arrayList_detiles_course= dataDelevery.getResultData().getCourseRoundDetails();
//                                recyclerView_contentCource.setLayoutManager(gridLayoutManager);
                                        LinearLayoutManager horizontalLayoutManagaer_content_course_detiles_course
                                                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                                        recyclerView_DetilesCource.setLayoutManager(horizontalLayoutManagaer_content_course_detiles_course);
                                        recyclerView_dAdapter_DetilesCource= new DetilesCource_Course_DetlesCours_viewHolder(arrayList_detiles_course, Details_ofers_CourssesActivity.this, getApplicationContext(),"deirection");
                                        recyclerView_DetilesCource.setAdapter(recyclerView_dAdapter_DetilesCource);
                                        recyclerView_dAdapter_DetilesCource.notifyDataSetChanged();


                                        //content course
                                        List<CourseContent> arrayList_content_course= dataDelevery.getResultData().getCourseContents();
//                                recyclerView_contentCource.setLayoutManager(gridLayoutManager);
                                        LinearLayoutManager horizontalLayoutManagaer_content_course
                                                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                                        recyclerView_contentCource.setLayoutManager(horizontalLayoutManagaer_content_course);
                                        recyclerView_dAdapter = new ContentCourse_DetlesCours_viewHolder(arrayList_content_course, Details_ofers_CourssesActivity.this, getApplicationContext(),"deirection");
                                        recyclerView_contentCource.setAdapter(recyclerView_dAdapter);
                                        recyclerView_dAdapter.notifyDataSetChanged();


                                        //learn_course
                                        List<CourseOutline> arrayList_learn_course= dataDelevery.getResultData().getCourseOutlines();
//                                recyclerView_contentCource.setLayoutManager(gridLayoutManager);
                                        LinearLayoutManager horizontalLayoutManagaer_learn_course
                                                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                                        recyclerView_learnCource.setLayoutManager(horizontalLayoutManagaer_learn_course);
                                        recyclerView_learn_dAdapter = new Learn_Course_DetlesCours_viewHolder(arrayList_learn_course, Details_ofers_CourssesActivity.this, getApplicationContext(),"deirection");
                                        recyclerView_learnCource.setAdapter(recyclerView_learn_dAdapter);
                                        recyclerView_learn_dAdapter.notifyDataSetChanged();
                                    }catch (Exception e){

                                    }



                                    try {
                                        description.setText(""+dataDelevery.getResultData().getCourseDescription());

                                    }catch (Exception e){
                                        description.setVisibility(View.GONE);
                                    }




                                    try {

                                        if (
                                                dataDelevery.getResultData().getImageBanarPath()==null
                                                        || dataDelevery.getResultData().getImageBanarPath().equals(null)
                                                        || dataDelevery.getResultData().getImageBanarPath().isEmpty()
                                                        || dataDelevery.getResultData().getImageBanarPath()=="")
                                        {
                                            imageView.setVisibility(View.GONE);
//                                            imageView.setImageResource(R.mipmap.sharpest_logo);
                                        }else {
                                            Picasso.with(getApplicationContext())
                                                    .load(dataDelevery.getResultData().getImageBanarPath())
                                                    .error(R.mipmap.sharpest_logo)
                                                    .into(imageView);
                                        }
                                    }catch (Exception e){
                                        imageView.setVisibility(View.GONE);
                                        imageView.setImageResource(R.mipmap.sharpest_logo);
                                    }

                                }

                                    CardView linearLayout=findViewById(R.id.linear_ofer);
                                    View view=findViewById(R.id.linear_ofer_view);
                                    TextView oferprice=findViewById(R.id.offer_price_detalesProdect);
                                    if (dataDelevery.getResultData().getOffersMobileDto() ==null ||
                                            dataDelevery.getResultData().getOffersMobileDto().equals(null)||
                                            dataDelevery.getResultData().getOffersMobileDto().equals("")){
                                        oferprice.setText("لا يوجد بيانات");


                                        linearLayout.setVisibility(View.GONE);
                                        view.setVisibility(View.GONE);

                                    }else{
                                        if (dataDelevery.getResultData().getOffersMobileDto().getOfferValue() ==null ||
                                                dataDelevery.getResultData().getOffersMobileDto().getOfferValue().equals(null)||
                                                dataDelevery.getResultData().getOffersMobileDto().getOfferValue().equals("")){
                                            oferprice.setText("لا يوجد بيانات");
                                            linearLayout.setVisibility(View.GONE);
                                            view.setVisibility(View.GONE);
                                        }else{
                                            offers_id=dataDelevery.getResultData().getOffersMobileDto().getId().toString();
                                            oferprice.setText(""+dataDelevery.getResultData().getOffersMobileDto().getOfferValue());
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
            ) {
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

    }



//    public class ViewDialog {

        public void showDialog(Activity activity, final String msg){
            final Dialog dialog = new Dialog(activity);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dilog_customdilog_reqest_cource);

//            TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
//            text.setText(msg);
            final EditText phoneDilog = (EditText) dialog.findViewById(R.id.ed_phone_dilog_course);
            final EditText promocode_Dilog = (EditText) dialog.findViewById(R.id.ed_promoCode_dilog_course);
            if (msg=="promo"){
                promocode_Dilog.setVisibility(View.VISIBLE);
            }else{
                promocode_Dilog.setVisibility(View.GONE);
            }


            Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog_cansel);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });


            Button dialogButton_OK = (Button) dialog.findViewById(R.id.btn_dialog_ok);
            dialogButton_OK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String phoneNumber=phoneDilog.getText().toString().trim();
                    String promoCodeNumber=promocode_Dilog.getText().toString().trim();


                    if (msg=="promo"){
                        if (phoneNumber.equals(null) || phoneNumber.equals("") || phoneNumber == null || phoneNumber == "") {
                            phoneDilog.setError("يجب اضافه رقم هاتف به واتس اب ");
                        }else  if (promoCodeNumber.equals(null) || promoCodeNumber.equals("") || promoCodeNumber == null || promoCodeNumber == "") {
                            promocode_Dilog.setError("ادخل البرومو كود  ");
                        }else{


                            addrequestCource_Promocode(phoneNumber,promoCodeNumber,promocode_Dilog,dialog);
                        }
                    }else{


                        if (phoneNumber.equals(null) || phoneNumber.equals("") || phoneNumber == null || phoneNumber == "") {
                            phoneDilog.setError("يجب اضافه رقم هاتف به واتس اب ");
                        }else{
                            addrequestCource(phoneNumber,promoCodeNumber,promocode_Dilog,dialog);
                        }
                    }

                }
            });



            dialog.show();

        }

//    }


    private void addrequestCource_Promocode(String phoneNumber, String promoCodeNumber, final EditText promocode_Dilog, final Dialog dialog){
        final ProgressDialog progressDialog=new ProgressDialog(Details_ofers_CourssesActivity.this);
        progressDialog.setMessage("Waite...");
        progressDialog.show();

        final RequestQueue requestQueue = Volley.newRequestQueue(Details_ofers_CourssesActivity.this);
        Gson gson = new Gson();
        DataSendReqestCoursePROMOCODE contactsTop=new DataSendReqestCoursePROMOCODE();

        Course course=new Course();
        course.setId(Integer.valueOf(id));
        contactsTop.setPromoCode(promoCodeNumber);
        contactsTop.setWhatsupPhoneNumber(phoneNumber);
        contactsTop.setCourse(course);

        Offers offer=new Offers();;
        if (offers_id!=null) {
            offer.setId(offers_id);
            contactsTop.setCourse(course);
        }

        Log.e("Volley:Response ", gson.toJson(contactsTop));

        JSONObject jsonObject = null;
        try {
            jsonObject=new JSONObject(gson.toJson(contactsTop));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Urls.send_reqestCours_promocde
                , jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Log.e("response_booking",""+response);

                JSONObject sys = response;//// result

                try {
                    Gson gson = new Gson();
                    DataResultDataPromocode dataDelevery;
                    dataDelevery = gson.fromJson(response.toString(), DataResultDataPromocode.class);
                    if (dataDelevery.getErrorStatus().equals(true)){
                        promocode_Dilog.setError(""+dataDelevery.getErrorResponsePayloadList().get(0).getArabicMessage());
//                        Toast.makeText(Details_CourssesActivity.this,
//                                ""+dataDelevery.getErrorResponsePayloadList().get(0).getArabicMessage(),
//                                Toast.LENGTH_LONG).show();
                    }else if (dataDelevery.getErrorStatus().equals(false)){
                                                Toast.makeText(Details_ofers_CourssesActivity.this,
                                "تم الاضافه بنجاح وستم التواصل معك عن طريق الواتس اب ",
                                Toast.LENGTH_LONG).show();
//                        Toast toast = Toast.makeText(getApplicationContext(),"تم الاضافه بنجاح وستم التواصل معك عن طريق الواتس اب ", Toast.LENGTH_LONG);
//                        View view = toast.getView();
//                        view.setBackgroundResource(R.color.colorApp);
//                        TextView text = (TextView) view.findViewById(android.R.id.message);
//                        try {
//                            text.setTextColor(Color.parseColor("#000000"));
//                        }catch (Exception r){
//
//                        }
//
//                        /*Here you can do anything with above textview like text.setTextColor(Color.parseColor("#000000"));*/
//                        toast.show();
                        dialog.dismiss();
                    }
                }catch (Exception r){
                    Log.e("Exception",""+r);
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

        }) {
            //            /** Passing some request headers* */
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Authorization",
                        SharedPrefManager.getInstance(getApplicationContext()).getheader());
                return headers;
            }
        };
        requestQueue.add(jsonObjectRequest);

    }


    private void addrequestCource(String phoneNumber, String promoCodeNumber, final EditText promocode_Dilog, final Dialog dialog){
        final ProgressDialog progressDialog=new ProgressDialog(Details_ofers_CourssesActivity.this);
        progressDialog.setMessage("Waite...");
        progressDialog.show();

        final RequestQueue requestQueue = Volley.newRequestQueue(Details_ofers_CourssesActivity.this);
        Gson gson = new Gson();
        DataSendReqestCoursePROMOCODE contactsTop=new DataSendReqestCoursePROMOCODE();

        Course course=new Course();
        course.setId(Integer.valueOf(id));
//        contactsTop.setPromoCode(promoCodeNumber);
        contactsTop.setWhatsupPhoneNumber(phoneNumber);
        contactsTop.setCourse(course);
        Offers offer=new Offers();;
        if (offers_id!=null) {
            offer.setId(offers_id);
            contactsTop.setOffers(offer);
        }

        Log.e("Volley:Response ", gson.toJson(contactsTop).toString());

        JSONObject jsonObject = null;
        try {
            jsonObject=new JSONObject(gson.toJson(contactsTop));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Urls.send_reqestCours_promocde
                , jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Log.e("response_booking",""+response);

                JSONObject sys = response;//// result

                try {
                    Gson gson = new Gson();
                    DataResultDataPromocode dataDelevery;
                    dataDelevery = gson.fromJson(response.toString(), DataResultDataPromocode.class);
                    Log.e("-------Exception-----",""+dataDelevery.getErrorStatus());
                    if (dataDelevery.getErrorStatus().equals(true)){
                        promocode_Dilog.setError(""+dataDelevery.getErrorResponsePayloadList().get(0).getArabicMessage());
//                        Toast.makeText(Details_CourssesActivity.this,
//                                ""+dataDelevery.getErrorResponsePayloadList().get(0).getArabicMessage(),
//                                Toast.LENGTH_LONG).show();
                    }else if (dataDelevery.getErrorStatus().equals(false)){
                                                Toast.makeText(Details_ofers_CourssesActivity.this,
                                "تم الاضافه بنجاح وستم التواصل معك عن طريق الواتس اب ",
                                Toast.LENGTH_LONG).show();
//                        Toast toast = Toast.makeText(getApplicationContext(),"تم الاضافه بنجاح وستم التواصل معك عن طريق الواتس اب ", Toast.LENGTH_LONG);
//                        View view = toast.getView();
//                        view.setBackgroundResource(R.color.colorApp);
//                        TextView text = (TextView) view.findViewById(android.R.id.message);
//                        try {
//                            text.setTextColor(Color.parseColor("#ffffff"));
//                        }catch (Exception r){
//                            Log.e("-------Exception-----",""+r);
//                        }

                        /*Here you can do anything with above textview like text.setTextColor(Color.parseColor("#000000"));*/
//                        toast.show();
                        dialog.dismiss();
                        finish();
                    }
                }catch (Exception r){
                    Log.e("-------Exception-----",""+r);
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

        }) {
            //            /** Passing some request headers* */
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Authorization",
                        SharedPrefManager.getInstance(getApplicationContext()).getheader());
                return headers;
            }
        };
        requestQueue.add(jsonObjectRequest);

    }

}

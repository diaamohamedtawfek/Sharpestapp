package com.Sharpest.sharpestapp.UI;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.Sharpest.sharpestapp.Home.Home;
import com.Sharpest.sharpestapp.Login_Signup.Login;
import com.Sharpest.sharpestapp.MySingleton;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.SharedPrefManager;
import com.Sharpest.sharpestapp.UI.Data_ofersDetales.DataOfersDetales;
import com.Sharpest.sharpestapp.Urls;
import com.Sharpest.sharpestapp.adaptor.Table_DetileItem_ViewHolder;
import com.Sharpest.sharpestapp.model.DataResponseBooking.DataResponseBooking;
import com.Sharpest.sharpestapp.model.DetalsProdect.ItemDetail;
import com.Sharpest.sharpestapp.model.addRequestData.Customer;
import com.Sharpest.sharpestapp.model.addRequestData.DataAddRequser;
import com.Sharpest.sharpestapp.model.addRequestData.Item;
import com.Sharpest.sharpestapp.model.addRequestData.Offers;
import com.Sharpest.sharpestapp.model.addRequestData.OrderStatusLookup;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Details_Ofers_ProductActivity extends AppCompatActivity {

    String id;
    SliderLayout mDemoSlider;

    String offer_price_id;

    LinearLayout linearLayout,addRequest;
    LinearLayout linear_datamachine;

    TextView textbu;

    TextView nameProduct,nameModel,pwearProduct,colling,charge,height,width,price;
    LinearLayout pwearProductlinear,collinglinear,chargelinear,heightlinear,widthlinear;
    View viewline_powr,viewline_colling,viewline_charge,viewline_height,viewline_width;
    TextView oferprice;
    String image,nameprodectAliaret;

    TextView namemodel1,workingArea,power,functionmactin,workingtaple,inpotVolt,support,wightmachen,technical_Specifications,name;

    //>>> RecyclerView
    RecyclerView recyclerView;
    private Table_DetileItem_ViewHolder recyclerView_dAdapter;
//    public List<Data_list_Color_DetilesProdeuct> listItems = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__product);

        defineUi();

        Bundle extras = getIntent().getExtras(); // to get move intent
        if (extras != null) {
            String a = extras.getString("id_product");
            String test = extras.getString("test");
            if (a!=null){
                id= a;
            }
            if (test!=null){
                if (test.equals("Pice_machine")){
                    linear_datamachine.setVisibility(View.GONE);
                }

                if (test.equals("Pice_machine_myorder")){
                    linear_datamachine.setVisibility(View.GONE);
                    addRequest.setVisibility(View.GONE);
                }
                if (test.equals("machine_myorder")){
                    linear_datamachine.setVisibility(View.VISIBLE);
                    addRequest.setVisibility(View.GONE);
                }
            }
        }


        getjson();


        addRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addReqestData();
            }
        });


        ///define recycal
        recyclerView=(RecyclerView) findViewById(R.id.recycal_allcatigry);


    }

    private void defineUi() {

        textbu=findViewById(R.id.textbu);
        textbu.setText("طلب العرض");
        linearLayout=findViewById(R.id.linear_detailes_Product);

        linear_datamachine=findViewById(R.id.linear_data_machine);

        addRequest=findViewById(R.id.linaer_addRequest_detaliesProduct);

        mDemoSlider = findViewById(R.id.slider);

        nameProduct=findViewById(R.id.nameProduct_DetalesProduct);
        nameModel=findViewById(R.id.name_model_detalesProdect);
        oferprice=findViewById(R.id.offer_price_detalesProdect);
        pwearProduct=findViewById(R.id.power_detalesProduct);
        pwearProductlinear=findViewById(R.id.linear_power_detalsProduct);
        viewline_powr=findViewById(R.id.view_power);

        colling=findViewById(R.id.text_colling);
        collinglinear=findViewById(R.id.linearColing);
        viewline_colling=findViewById(R.id.text_colling);

        charge=findViewById(R.id.text_charge);
        chargelinear=findViewById(R.id.linearcharge);
        viewline_charge=findViewById(R.id.text_charge);

        height=findViewById(R.id.text_height);
        heightlinear=findViewById(R.id.linearheight);
        viewline_height=findViewById(R.id.text_height);

        width=findViewById(R.id.text_width);
        widthlinear=findViewById(R.id.linearwidth);
        viewline_width=findViewById(R.id.text_width);

        namemodel1=findViewById(R.id.name_model1_detalesProdect);
        price=findViewById(R.id.price_detalesProdect);

        workingArea=findViewById(R.id.workingArea_detalesProdect);
        power=findViewById(R.id.powar_detalesProdect);
        functionmactin=findViewById(R.id.function_detalesProdect);
        workingtaple=findViewById(R.id.workingtable_detalesProdect);
        inpotVolt=findViewById(R.id.inpoutVolt_detalesProdect);
        support=findViewById(R.id.support_detalesProdect);
        wightmachen=findViewById(R.id.wight_detalesProdect);
        technical_Specifications=findViewById(R.id.Technical_Specifications_detalesProdect);
        name=findViewById(R.id.name_detalesProdect);
    }


    private void getjson() {

        Log.e("url Product",Urls.Details_Product +id);
        Log.e("token auth","Authorization");
        Log.e("token",  SharedPrefManager.getInstance(getApplicationContext()).getheader());
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
            //Toast.makeText(context, "you don't have update "+REGISTER_URL, Toast.LENGTH_SHORT).show();
            final StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    Urls.Details_Product +id,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            Log.e("Detiles_Prodect",response.toString());
                            try {
                                Gson gson = new Gson();
                                DataOfersDetales dataDelevery;
                                dataDelevery = gson.fromJson(response.toString(), DataOfersDetales.class);

                                try {
                                    if (dataDelevery.resultData.getSparePartsFlag()==1 ||dataDelevery.resultData.getSparePartsFlag().equals(1)){
                                        linear_datamachine.setVisibility(View.GONE);
                                    }

                                    if (dataDelevery.resultData.getSparePartsFlag()==0||dataDelevery.resultData.getSparePartsFlag().equals(0)){
                                        linear_datamachine.setVisibility(View.VISIBLE);
                                    }

                                }catch (Exception e){
                                }

                                try {
                                    Log.e(">>>>>>>>>>",""+dataDelevery.getResultData().getItemImagesList().size());
                                    HashMap<String, String> file_maps = new HashMap<>();
                                    if (dataDelevery.getResultData().getItemImagesList().size()>0){
                                        for (int i=0 ; i<dataDelevery.getResultData().getItemImagesList().size();i++){

//                                                urlbaner.add(dataDelevery.getResultData().getItemImagesList().get(i).getItemImagePath());

                                            Log.e("test",""+dataDelevery.getResultData().getItemImagesList().get(i).getItemImagePath());
                                            file_maps.put("Hannibal",""+dataDelevery.getResultData().getItemImagesList().get(i).getItemImagePath());

                                            for(String name : file_maps.keySet()){
                                                TextSliderView textSliderView = new TextSliderView(getApplicationContext());
                                                // initialize a SliderLayout
                                                try {
                                                    textSliderView
                                                            //.description(name)
                                                            .image(file_maps.get(name))
                                                            .setScaleType(BaseSliderView.ScaleType.Fit);

                                                    textSliderView.bundle(new Bundle());
                                                    textSliderView.getBundle()
                                                            .putString("extra",name);
                                                    mDemoSlider.addSlider(textSliderView);
                                                }catch (Exception e){
                                                    mDemoSlider.stopAutoCycle();
//                                                    mDemoSlider.setVisibility(View.GONE);
                                                }
                                            }
                                            mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Tablet);
                                            mDemoSlider.setCustomAnimation(new DescriptionAnimation());
                                            mDemoSlider.setDuration(50000);
                                        }
                                    }else {
                                        mDemoSlider.setVisibility(View.GONE);
                                    }

                                }catch (Exception e){
                                    Log.e("error slider >> ",e.toString());
                                }



                            linearLayout.setVisibility(View.VISIBLE);
                                if (dataDelevery.getErrorStatus().equals(false)){

                                    if (dataDelevery.getResultData().getMachineModel() ==null ||
                                            dataDelevery.getResultData().getMachineModel().equals(null)||
                                            dataDelevery.getResultData().getMachineModel().equals("")){
                                        namemodel1.setText("لا يوجد بيانات");
                                    }else{
                                        namemodel1.setText(""+dataDelevery.getResultData().getMachineModel());
                                    }


                                    LinearLayout linearLayout=findViewById(R.id.linear_ofer);
                                    View view=findViewById(R.id.linear_ofer_view);
                                    if (dataDelevery.getResultData().getOffersDto() ==null ||
                                            dataDelevery.getResultData().getOffersDto().equals(null)||
                                            dataDelevery.getResultData().getOffersDto().equals("")){
                                        oferprice.setText("لا يوجد بيانات");


                                        linearLayout.setVisibility(View.GONE);
                                        view.setVisibility(View.GONE);
                                        textbu.setText("طلب عرض سعر");
                                    }else{
                                        if (dataDelevery.getResultData().getOffersDto().getOfferValue() ==null ||
                                                dataDelevery.getResultData().getOffersDto().getOfferValue().equals(null)||
                                                dataDelevery.getResultData().getOffersDto().getOfferValue().equals("")){
                                            oferprice.setText("لا يوجد بيانات");
                                            linearLayout.setVisibility(View.GONE);
                                            view.setVisibility(View.GONE);
                                            textbu.setText("طلب عرض سعر");
                                        }else{

//                                            TextView textbu;

                                            offer_price_id=dataDelevery.getResultData().getOffersDto().getId().toString();
                                            oferprice.setText(""+dataDelevery.getResultData().getOffersDto().getOfferValue());
                                        }
                                    }



                                    if (dataDelevery.getResultData().getItemPrice() ==null ||
                                            dataDelevery.getResultData().getItemPrice().equals(null)||
                                            dataDelevery.getResultData().getItemPrice().equals("")){
                                        price.setText("لا يوجد بيانات");
                                    }else{

                                        price.setText(""+dataDelevery.getResultData().getItemPrice());
                                    }

                                    if (dataDelevery.getResultData().getWorkingErea() ==null ||
                                            dataDelevery.getResultData().getWorkingErea().equals(null)||
                                            dataDelevery.getResultData().getWorkingErea().equals("")
                                    ){
                                        workingArea.setText("لا يوجد بيانات");
                                    }else{

                                        workingArea.setText(""+dataDelevery.getResultData().getWorkingErea());
                                    }
//                                    //<<
                                    if (dataDelevery.getResultData().getMachinePower() ==null ||
                                            dataDelevery.getResultData().getMachinePower().equals(null)||
                                            dataDelevery.getResultData().getMachinePower().equals("")
                                    ){
                                        power.setText("لا يوجد بيانات");
                                    }else{
                                        power.setText(""+dataDelevery.getResultData().getMachinePower());
                                    }
//
                                    if (dataDelevery.getResultData().getMachineFunction() ==null ||
                                            dataDelevery.getResultData().getMachineFunction().equals(null)||
                                            dataDelevery.getResultData().getMachineFunction().equals("")
                                    ){
                                        functionmactin.setText("لا يوجد بيانات");
                                    }else{
                                        functionmactin.setText(""+dataDelevery.getResultData().getMachineFunction());

                                    }
//
                                    if (dataDelevery.getResultData().getWorkingTable() ==null ||
                                            dataDelevery.getResultData().getWorkingTable().equals(null)||
                                            dataDelevery.getResultData().getWorkingTable().equals("")){
                                        workingtaple.setText("لا يوجد بيانات");
                                    }else{
                                        workingtaple.setText(""+dataDelevery.getResultData().getWorkingTable());
                                    }
//
                                    if (dataDelevery.getResultData().getInputVoltage() ==null ||
                                            dataDelevery.getResultData().getInputVoltage().equals(null)||
                                            dataDelevery.getResultData().getInputVoltage().equals("")){
                                        inpotVolt.setText("لا يوجد بيانات");
                                    }else{
                                        inpotVolt.setText(""+dataDelevery.getResultData().getInputVoltage());
                                    }
//
                                    if (dataDelevery.getResultData().getGraphicFormatSupported() ==null ||
                                            dataDelevery.getResultData().getGraphicFormatSupported().equals(null)||
                                            dataDelevery.getResultData().getGraphicFormatSupported().equals("")){
                                        support.setText("لا يوجد بيانات");
                                    }else{

                                        support.setText(""+dataDelevery.getResultData().getGraphicFormatSupported());
                                    }
//
                                    if (dataDelevery.getResultData().getMachineNetWeight() ==null ||
                                            dataDelevery.getResultData().getMachineNetWeight().equals(null)||
                                            dataDelevery.getResultData().getMachineNetWeight().equals("")){
                                        wightmachen.setText("لا يوجد بيانات");
                                    }else{
                                        wightmachen.setText(""+dataDelevery.getResultData().getMachineNetWeight());
                                    }
//
                                    if (dataDelevery.getResultData().getTechnicalSpecifications() ==null ||
                                            dataDelevery.getResultData().getTechnicalSpecifications().equals(null)||
                                            dataDelevery.getResultData().getTechnicalSpecifications().equals("")){
                                        technical_Specifications.setText("لا يوجد بيانات");
                                    }else{
//
                                        technical_Specifications.setText(""+dataDelevery.getResultData().getTechnicalSpecifications());
                                    }
//
                                    if (dataDelevery.getResultData().getItemNameAr() ==null ||
                                            dataDelevery.getResultData().getItemNameAr().equals(null)||
                                            dataDelevery.getResultData().getItemNameAr().equals("")){
                                        name.setText("لا يوجد بيانات");
                                    }else{
                                        name.setText(dataDelevery.getResultData().getItemNameAr());
                                    }

                                    image=dataDelevery.getResultData().getBanarImagePath();
                                    nameprodectAliaret=dataDelevery.getResultData().getItemNameAr();

                                    nameProduct.setText(""+dataDelevery.getResultData().getItemNameAr());
                                    nameModel.setText(""+dataDelevery.getResultData().getItemModelCode());

                                    try {
                                        if (!dataDelevery.getResultData().getItemHorse().equals(null) ||
                                                dataDelevery.getResultData().getItemHorse()!= null){
                                            pwearProduct.setText(""+dataDelevery.getResultData().getItemHorse());
                                        } else {
                                            viewline_powr.setVisibility(View.GONE);
                                            pwearProductlinear.setVisibility(View.GONE);
                                        }
                                    }catch (Exception e){
                                        viewline_powr.setVisibility(View.GONE);
                                        pwearProductlinear.setVisibility(View.GONE);
                                    }

                                    try {
                                        if (!dataDelevery.getResultData().getItemColling().equals(null) ||
                                                dataDelevery.getResultData().getItemColling()!= null){
                                            colling.setText(""+dataDelevery.getResultData().getItemColling().getItemCollingAr());
                                        } else {
                                            collinglinear.setVisibility(View.GONE);
                                            viewline_colling.setVisibility(View.GONE);
                                        }
                                    }catch (Exception e){
                                        collinglinear.setVisibility(View.GONE);
                                        viewline_colling.setVisibility(View.GONE);
                                    }



                                    try {
                                        if (!dataDelevery.getResultData().getItemCharge().equals(null) ||
                                                dataDelevery.getResultData().getItemCharge()!= null){
                                            charge.setText(""+dataDelevery.getResultData().getItemCharge());
                                        } else {
                                            chargelinear.setVisibility(View.GONE);
                                            viewline_charge.setVisibility(View.GONE);
                                        }
                                    }catch (Exception e){
                                        chargelinear.setVisibility(View.GONE);
                                        viewline_charge.setVisibility(View.GONE);
                                    }

                                    try {
                                        if (!dataDelevery.getResultData().getItemHight().equals(null) ||
                                                dataDelevery.getResultData().getItemHight()!= null){
                                            height.setText(""+dataDelevery.getResultData().getItemHight());
                                        } else {
                                            heightlinear.setVisibility(View.GONE);
                                            viewline_height.setVisibility(View.GONE);
                                        }
                                    }catch (Exception e){
                                        heightlinear.setVisibility(View.GONE);
                                        viewline_height.setVisibility(View.GONE);
                                    }

                                    try {
                                        if (!dataDelevery.getResultData().getItemWidth().equals(null) ||
                                                dataDelevery.getResultData().getItemWidth()!= null){
                                            width.setText(""+dataDelevery.getResultData().getItemWidth());
                                        } else {
                                            widthlinear.setVisibility(View.GONE);
                                            viewline_width.setVisibility(View.GONE);
                                        }
                                    }catch (Exception e){
                                        Log.e("error slider >> ",e.toString());
                                        widthlinear.setVisibility(View.GONE);
                                        viewline_width.setVisibility(View.GONE);
                                    }


                                    List<ItemDetail> arrayList= dataDelevery.getResultData().getItemDetails();
                                    recyclerView.setLayoutManager(gridLayoutManager);

                                    LinearLayoutManager horizontalLayoutManagaer
                                            = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

                                    recyclerView.setLayoutManager(horizontalLayoutManagaer);

                                    recyclerView_dAdapter = new Table_DetileItem_ViewHolder(arrayList, Details_Ofers_ProductActivity.this, getApplicationContext(),"deirection");

                                    recyclerView.setAdapter(recyclerView_dAdapter);

                                    recyclerView_dAdapter.notifyDataSetChanged();

                                    recyclerView_dAdapter.notifyDataSetChanged();

                            }
                        }catch (Exception e){
                        }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            linearLayout.setVisibility(View.GONE);
                            //progressDialog.dismiss();
                            if (error instanceof TimeoutError || error instanceof NoConnectionError) {
//                                Toast.makeText(getApplicationContext(), "Error Network Time Out", Toast.LENGTH_LONG).show();
                            } else if (error instanceof AuthFailureError) {
                                SharedPrefManager.getInstance(getApplicationContext()).logout();
                                startActivity(new Intent(getApplicationContext(), Login.class));
                                finish();
                                //startActivity(new Intent(getApplicationContext(),Log_In.class));
                            } else if (error instanceof ServerError) {
//                                Toast.makeText(getApplicationContext(), "ServerError", Toast.LENGTH_LONG).show();
                                //TODO
                            } else if (error instanceof NetworkError) {
//                                Toast.makeText(getApplicationContext(), "NetworkError", Toast.LENGTH_LONG).show();
                                //TODO
                            } else if (error instanceof ParseError) {
//                                Toast.makeText(getApplicationContext(), "ParseError", Toast.LENGTH_LONG).show();
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
                            SharedPrefManager.getInstance(getApplicationContext()).getheader());
                    return headers;
                }
            };;

            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        } else {
        }

    }


    private void addReqestData(){
        final ProgressDialog progressDialog=new ProgressDialog(Details_Ofers_ProductActivity.this);
        progressDialog.setMessage("Waite...");
        progressDialog.show();

        final RequestQueue requestQueue = Volley.newRequestQueue(Details_Ofers_ProductActivity.this);
        Gson gson = new Gson();
        DataAddRequser contactsTop=new DataAddRequser();

        Customer customer=new Customer();
        customer.setId(Integer.parseInt(SharedPrefManager.getInstance(getApplicationContext()).getid()));

        Item item=new Item();
        item.setId(Integer.valueOf(id));

        OrderStatusLookup orderStatusLookup=new OrderStatusLookup();
        orderStatusLookup.setId(1);

        Offers offers = new Offers();

        if ( offer_price_id != null) {
            offers.setId(String.valueOf(offer_price_id));
            contactsTop.setOffers(offers);
        }
        contactsTop.setCustomer(customer);
        contactsTop.setItem(item);
        contactsTop.setOrderStatusLookup(orderStatusLookup);

        Log.e("Volley:Response ", gson.toJson(contactsTop));

        JSONObject jsonObject = null;
        try {
            jsonObject=new JSONObject(gson.toJson(contactsTop));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Urls.Booking_Item
                , jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Log.e("response_booking",""+response);

                JSONObject sys = response;//// result

                Gson gson = new Gson();
                DataResponseBooking dataDelevery;
                dataDelevery = gson.fromJson(response.toString(), DataResponseBooking.class);

                if (dataDelevery.getErrorStatus().equals(true)||dataDelevery.getErrorStatus() == true){
                    showAlert(image,nameprodectAliaret,"idrequest");

                }

                if (dataDelevery.getErrorStatus().equals(false)||dataDelevery.getErrorStatus() == false){
                    showAlert(image,nameprodectAliaret,""+dataDelevery.getResultData().getId());

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

                }catch (Exception e){

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


    public void showAlert(String image,String nameprodecuct,String idrequest){

        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(Details_Ofers_ProductActivity.this);
        LayoutInflater inflater = Details_Ofers_ProductActivity.this.getLayoutInflater();
        View alertView = inflater.inflate(R.layout.done_add_request, null);
        alertDialog.setView(alertView);

        final android.app.AlertDialog show = alertDialog.show();

        ImageView imageprodects=show.findViewById(R.id.image_aliert_detalesProdect);
        try {
            if (
                   image ==null
                            ||image.equals(null)
                            || image.isEmpty()
                            || image =="")
            {
                imageprodects.setImageResource(R.mipmap.sharpest_logo);
            }else {
                Picasso.with(getApplicationContext())
                        .load(image)
                        .into(imageprodects);
            }
        }catch (Exception e){
            imageprodects.setImageResource(R.mipmap.sharpest_logo);
        }
        TextView nameProd=show.findViewById(R.id.name_aliert_detalesProdect);
        nameProd.setText(nameprodecuct);

        TextView massage=show.findViewById(R.id.massage_alirt);


        Button doneADD=show.findViewById(R.id.bu_done_addAdvice2);
        doneADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                show.dismiss();
            }
        });

        if (id.equals("") || id ==""){
            doneADD.setVisibility(View.GONE);
            massage.setText("لم تم ارسال الطلب " +
                    "");
//            massage.setText("لم تم ارسال الطلب \n" +
//                    "وسيتم التواصل معك في اسرع وقت");
        }else{
            doneADD.setVisibility(View.VISIBLE);
            massage.setText("تم ارسال الطلب\n" +
                    "وسيتم التواصل معك في اسرع وقت");
        }


    }

}
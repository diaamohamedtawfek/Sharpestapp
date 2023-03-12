package com.Sharpest.sharpestapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.Sharpest.sharpestapp.Login_Signup.Login;
import com.Sharpest.sharpestapp.MySingleton;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.SharedPrefManager;
import com.Sharpest.sharpestapp.Urls;
import com.Sharpest.sharpestapp.adaptor.Produect_Category_viewHolder;
import com.Sharpest.sharpestapp.model.Data_ProdectCategory_final;
import com.Sharpest.sharpestapp.model.ProductCategory.DataProductCategory;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Produect_Categry extends AppCompatActivity  implements SwipeRefreshLayout.OnRefreshListener{

    //عرض قطع الغيار

    String id;

    RecyclerView recycal_deliverys;
    private Produect_Category_viewHolder recyclerView_dAdapter;
    public List<Data_ProdectCategory_final> listItems = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    int REGISTER_URL=0;
    int REGISTER_URL_mareds;
    Boolean isScrolling = false;
//    boolean isLoading = false;
    int currentItems, totalItems, scrollOutItems;
    SwipeRefreshLayout mSwipeRefreshLayout;

    String deirection;
    ImageView changeList;

    TextView namecategry_text;
//
//    LinearLayoutManager horizontalLayoutManagaer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produect__categry);

        namecategry_text=findViewById(R.id.text_name_partlist_Home);
        Bundle extras = getIntent().getExtras(); // to get move intent
        if (extras != null) {
            String a = extras.getString("id_product");
            String name_categry = extras.getString("name_categry");
            if (a!=null){
                id= a;
                namecategry_text.setText(name_categry);
            }

        }


        changeList=findViewById(R.id.image_changeList_prodect_category);
        changeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deirection.equals("hor")){
                    deirection="ver";
                    startUI();
                }else{
                    deirection="hor";
                    startUI();
                }
            }
        });

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                // Fetching data from server
                deirection="hor";
                startUI();
            }
        });

    }

    @Override
    public void onRefresh() {
        startUI();
    }
    private void startUI() {
        listItems.clear();
        REGISTER_URL=0;
        recycal_deliverys = findViewById(R.id.recycal_allcatigry);
        recycal_deliverys.setHasFixedSize(true);

        if (deirection.equals("hor")){
            gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
//            horizontalLayoutManagaer
//                    = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        }
        if (deirection.equals("ver")){
            gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        }
        recycal_deliverys.setLayoutManager(gridLayoutManager);
//        recycal_deliverys.setLayoutManager(horizontalLayoutManagaer);

        recyclerView_dAdapter = new Produect_Category_viewHolder(listItems,Produect_Categry.this, getApplicationContext(),deirection);
        recycal_deliverys.setAdapter(recyclerView_dAdapter);

        getjson(0);

        recycal_deliverys.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                isScrolling=true;
                currentItems = gridLayoutManager.getChildCount();
                totalItems = gridLayoutManager.getItemCount();
                scrollOutItems = gridLayoutManager.findFirstVisibleItemPosition();
                if (gridLayoutManager.findLastCompletelyVisibleItemPosition() == listItems.size() - 1) {
                    if (REGISTER_URL<=REGISTER_URL_mareds) {
                        isScrolling = false;
                        getjson(REGISTER_URL);
                    }

                }
                //

            }
        });
    }

    private void getjson(final int i) {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
            //Toast.makeText(context, "you don't have update "+REGISTER_URL, Toast.LENGTH_SHORT).show();
            final StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    Urls.Product_Categry +id+"&page="+i+"&size=5",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Log.e("url>>>>>>>> ",REGISTER_URL+"  "+response);
                            if (response.length() > 0) {
                                mSwipeRefreshLayout.setRefreshing(false);
                                //progressDialog.dismiss();
                                try {
                                Gson gson = new Gson();
                                DataProductCategory dataDelevery;
                                dataDelevery = gson.fromJson(response.toString(), DataProductCategory.class);


                                if (dataDelevery.getErrorStatus().equals(false)){
                                    REGISTER_URL++;
                                    float x = dataDelevery.getResultData().getTotalItemsCount() / 5;
                                    int x_tkreb = (int) x;
                                    REGISTER_URL_mareds = x_tkreb + 1;


                                    int lengt_for = dataDelevery.getResultData().getResultData().size();
                                    if (lengt_for > 0) {

                                        for (int I = 0; I < lengt_for; I++) {
                                            listItems.add(new Data_ProdectCategory_final(
                                                    ""+dataDelevery.getResultData().getResultData().get(I).getId(),
                                                    ""+dataDelevery.getResultData().getResultData().get(I).getItemNameAr() ,
                                                    ""+dataDelevery.getResultData().getResultData().get(I).getItemNameEn(),
                                                    dataDelevery.getResultData().getResultData().get(I).getBannarImagePath()
                                            ));
                                            recyclerView_dAdapter.notifyDataSetChanged();
                                        }
                                    } else {
                                        mSwipeRefreshLayout.setRefreshing(false);
                                        // progressDialog.dismiss();
                                        Log.e("test", "no");
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
                            mSwipeRefreshLayout.setRefreshing(false);
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
                            SharedPrefManager.getInstance(getApplicationContext()).getheader());
                    return headers;
                }
            };;

            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        } else {
        }

    }
}

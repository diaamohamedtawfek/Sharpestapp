package com.Sharpest.sharpestapp.Home.uiFragment.frament_myoder;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.Sharpest.sharpestapp.Home.uiFragment.adaptor_fragment_myprder.myoderfragment_viewHolder;
import com.Sharpest.sharpestapp.Home.uiFragment.model.machine.DataMachenFrgmentRequest;
import com.Sharpest.sharpestapp.Home.uiFragment.model.machine.DataMachenFrgmentRequestFinal;
import com.Sharpest.sharpestapp.Login_Signup.Login;
import com.Sharpest.sharpestapp.MySingleton;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.SharedPrefManager;
import com.Sharpest.sharpestapp.Urls;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Pice_machine_fragment extends Fragment  implements SwipeRefreshLayout.OnRefreshListener{

    public Pice_machine_fragment() {
        // Required empty public constructor
    }

    RecyclerView recycal_deliverys;
    private myoderfragment_viewHolder recyclerView_dAdapter;
    public List<DataMachenFrgmentRequestFinal> listItems = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    int REGISTER_URL=0;
    int REGISTER_URL_mareds;
    Boolean isScrolling = false;
    //    boolean isLoading = false;
    int currentItems, totalItems, scrollOutItems;
    SwipeRefreshLayout mSwipeRefreshLayout;

    String deirection;
    ImageView changeList;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_pice_machine_fragment, container, false);



        view= inflater.inflate(R.layout.fragment_pice_machine_fragment, container, false);



        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
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

        return view;
    }

    @Override
    public void onRefresh() {
        startUI();
    }
    private void startUI() {
        listItems.clear();
        REGISTER_URL=0;
        recycal_deliverys = view.findViewById(R.id.recycal_allcatigry);
        recycal_deliverys.setHasFixedSize(true);
        gridLayoutManager = new GridLayoutManager(getActivity(), 1);
//        if (deirection.equals("hor")){
//            gridLayoutManager = new GridLayoutManager(getActivity(), 1);
////            horizontalLayoutManagaer
////                    = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
//
//        }
//        if (deirection.equals("ver")){
//            gridLayoutManager = new GridLayoutManager(getActivity(), 2);
//        }
        recycal_deliverys.setLayoutManager(gridLayoutManager);
//        recycal_deliverys.setLayoutManager(horizontalLayoutManagaer);
        deirection="Pice_machine_myorder";
        recyclerView_dAdapter = new myoderfragment_viewHolder(listItems, getActivity(), getActivity(),deirection);
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
        ConnectivityManager conMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
            //Toast.makeText(context, "you don't have update "+REGISTER_URL, Toast.LENGTH_SHORT).show();
            final StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    Urls.pice_machen_myrequest+i+"&size=10",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Log.e("url>>>>>>>>pice ",REGISTER_URL+"  "+response);
                            if (response.length() > 0) {
                                mSwipeRefreshLayout.setRefreshing(false);
                                //progressDialog.dismiss();
                                try {
                                Gson gson = new Gson();
                                DataMachenFrgmentRequest dataDelevery;
                                dataDelevery = gson.fromJson(response.toString(), DataMachenFrgmentRequest.class);


                                if (dataDelevery.getErrorStatus().equals(false)){
                                    REGISTER_URL++;
                                    float x = dataDelevery.getResultData().getTotalItemsCount() / 10;
                                    int x_tkreb = (int) x;
                                    REGISTER_URL_mareds = x_tkreb + 1;


                                    int lengt_for = dataDelevery.getResultData().getResultData().size();
                                    if (lengt_for > 0) {

                                        for (int I = 0; I < lengt_for; I++) {
                                            listItems.add(new DataMachenFrgmentRequestFinal(
                                                    dataDelevery.getResultData().getResultData().get(I).getId()
                                                    , ""+dataDelevery.getResultData().getResultData().get(I).getItemNameAr()
                                                    , ""+dataDelevery.getResultData().getResultData().get(I).getBannarImagePath()
                                                    , ""+dataDelevery.getResultData().getResultData().get(I).getOrderDate()
                                                    , ""+dataDelevery.getResultData().getResultData().get(I).getOrderStatusNameAr()
                                                    , dataDelevery.getResultData().getResultData().get(I).getCouponValue()
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
                            try {
                            if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                Toast.makeText(getActivity(), "Error Network Time Out", Toast.LENGTH_LONG).show();
                            } else if (error instanceof AuthFailureError) {
                                SharedPrefManager.getInstance(getActivity()).logout();
                                startActivity(new Intent(getActivity(), Login.class));
                                getActivity().finish();
                                //startActivity(new Intent(getApplicationContext(),Log_In.class));
                            } else if (error instanceof ServerError) {
//                                Toast.makeText(getActivity(), "Final pice", Toast.LENGTH_LONG).show();
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
                    }
            ) {
                //            /** Passing some request headers* */
                @Override
                public Map getHeaders() throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Authorization",
                            SharedPrefManager.getInstance(getActivity()).getheader());
                    return headers;
                }
            };;

            MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);
        } else {
        }

    }
}

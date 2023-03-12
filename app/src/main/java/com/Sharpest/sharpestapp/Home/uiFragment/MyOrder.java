package com.Sharpest.sharpestapp.Home.uiFragment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.Sharpest.sharpestapp.Home.model.toatelCouponValur.DataTotalCouponValue;
import com.Sharpest.sharpestapp.Home.uiFragment.frament_myoder.MyService_myOrder_Fragment;
import com.Sharpest.sharpestapp.Home.uiFragment.frament_myoder.Pice_machine_fragment;
import com.Sharpest.sharpestapp.Home.uiFragment.frament_myoder.Show_CoursesFragment;
import com.Sharpest.sharpestapp.Home.uiFragment.frament_myoder.Show_Machine_Fragment;
import com.Sharpest.sharpestapp.Login_Signup.Login;
import com.Sharpest.sharpestapp.MySingleton;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.SharedPrefManager;
import com.Sharpest.sharpestapp.Urls;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrder extends Fragment {

    public MyOrder() {
        // Required empty public constructor
    }

    TextView toatelcopun;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_my_order, container, false);



        View view = inflater.inflate(R.layout.fragment_my_order, container, false);


        toatelcopun=view.findViewById(R.id.text_toatelcopoun);
        getjsonprofle();

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Arrrr"));
        tabLayout.addTab(tabLayout.newTab().setText("B"));
        tabLayout.addTab(tabLayout.newTab().setText("C"));
        tabLayout.addTab(tabLayout.newTab().setText("C"));
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        // mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //mRecyclerView.setLayoutManager(mLayoutManager);
        viewPager.setAdapter(new PagerAdapter(getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }



        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new Show_Machine_Fragment();
                case 1:
                    return new Pice_machine_fragment();
                case 2:
                    return new MyService_myOrder_Fragment();

                case 3:
                    return new Show_CoursesFragment();
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "الماكينات";
                case 1:
                    return "قطع غيار";
                case 2:
                    return "الخدمات ";

                case 3:
                    return "الدورات التدريبية ";


            }
            return null;
        }


        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }


    private void getjsonprofle() {
        ConnectivityManager conMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
            //Toast.makeText(context, "you don't have update "+REGISTER_URL, Toast.LENGTH_SHORT).show();
            final StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    Urls.totalCouponValue,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Log.e("myordr_totalCouponValue","  "+response);
                            if (response.length() > 0) {
                                //progressDialog.dismiss();

                                try {

                                    Gson gson = new Gson();
                                    DataTotalCouponValue dataDelevery;
                                    dataDelevery = gson.fromJson(response.toString(), DataTotalCouponValue.class);

                                    if (dataDelevery.getErrorStatus().equals(false)){
                                        if(
                                                dataDelevery.getResultData().getTotalCouponValue() != null
                                        ){
                                            toatelcopun.setText(" مجموع النقاط  "+dataDelevery.getResultData().getTotalCouponValue().toString());
                                        }else{
                                            toatelcopun.setText(" مجموع النقاط  "+"0");
                                        }

                                    }


                                }catch (Exception r){

                                }

                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //progressDialog.dismiss();
//                            mSwipeRefreshLayout.setRefreshing(false);
                            try {
                                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                    Toast.makeText(getActivity(), "Error Network Time Out", Toast.LENGTH_LONG).show();
                                } else if (error instanceof AuthFailureError) {
                                    SharedPrefManager.getInstance(getActivity()).logout();
                                    startActivity(new Intent(getActivity(), Login.class));
                                    getActivity().finish();
                                    //startActivity(new Intent(getApplicationContext(),Log_In.class));
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

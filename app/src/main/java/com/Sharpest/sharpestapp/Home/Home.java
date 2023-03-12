package com.Sharpest.sharpestapp.Home;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.Sharpest.sharpestapp.Home.ui.ChangePassword;
import com.Sharpest.sharpestapp.Home.ui.ContactUs;
import com.Sharpest.sharpestapp.Home.ui.CoursesFragment;
import com.Sharpest.sharpestapp.Home.ui.HomeFragment;
import com.Sharpest.sharpestapp.Home.ui.OffersFragment;
import com.Sharpest.sharpestapp.Home.ui.PartsFragment;
import com.Sharpest.sharpestapp.Home.ui.ProdectFragment;
import com.Sharpest.sharpestapp.Home.ui.ProfileFragment;
import com.Sharpest.sharpestapp.Home.uiFragment.AboutUs;
import com.Sharpest.sharpestapp.Home.uiFragment.MyOrder;
import com.Sharpest.sharpestapp.Home.uiFragment.MyProfile;
import com.Sharpest.sharpestapp.Home.uiFragment.frament_myoder.Show_CoursesFragment;
import com.Sharpest.sharpestapp.Home.uiFragment.model.DataProfile.DataProfile;
import com.Sharpest.sharpestapp.Login_Signup.Login;
import com.Sharpest.sharpestapp.MySingleton;
import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.SharedPrefManager;
import com.Sharpest.sharpestapp.Urls;
import com.Sharpest.sharpestapp.VolleyMultipartRequest;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home extends AppCompatActivity   implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    TextView titiel;
    int backButtonCount =0;

    Bitmap bitmap=null;


     BottomNavigationView bottomNav;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_home);
        }catch (Exception e){
//            finish();
            Intent intent= new Intent(getApplicationContext(), Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();

        }


        Log.e("token>>",SharedPrefManager.getInstance(getApplicationContext()).getheader());


        // to botton nav bar
        try {
            Intent intent= new Intent(getApplicationContext(), Login.class);

            bottomNav = findViewById(R.id.nav_view_home);
            bottomNav.setOnNavigationItemSelectedListener(navListener);
            bottomNav.getMenu().findItem(R.id.navigation_home).setChecked(true);
        }catch (Exception e){
            Intent intent= new Intent(getApplicationContext(), Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }




        // inside menu
        try {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
//        navigationView.setNI
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);









        titiel=findViewById(R.id.title);
//        titiel.setText("dddddddddd");


        try {
            NavigationView navigationView1 = (NavigationView) findViewById(R.id.nav_view);
            View headerView = navigationView1.getHeaderView(0);
            TextView navUsername = (TextView) headerView.findViewById(R.id.textView_nameUser);
            navUsername.setText(""+SharedPrefManager.getInstance(getApplicationContext()).getUsername());

            navUsername.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setTitle("الصفحه الشخصيه");
                    titiel.setText("الصفحه الشخصيه");
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                            new MyProfile("nav")).commit();

                    drawer.closeDrawers();
                }
            });

            CircleImageView imageView=headerView.findViewById(R.id.imageView);
            try {
//            imageView.setImageURI(Uri.parse(SharedPrefManager.getInstance(getApplicationContext()).getimage()));

                Picasso.with(getApplicationContext())
                        .load(SharedPrefManager.getInstance(getApplicationContext()).getimage())
                        .error(R.drawable.ic_person)
                        .into(imageView);
            }catch (Exception e){
                imageView.setImageResource(R.drawable.ic_person);
            }


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    startActivityForResult(i, 100);
                    setTitle("الصفحه الشخصيه");
                    titiel.setText("الصفحه الشخصيه");
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                            new MyProfile("nav")).commit();
                    drawer.closeDrawers();
                }
            });

        }catch (Exception e){

        }



        }catch (Exception r){

        }


        try {


            if (savedInstanceState == null) {
                // to show fragment
                Bundle extras = getIntent().getExtras(); // to get move intent
                if (extras != null) {
                    String a = extras.getString("test");
                    Log.e("Bundle extras  >>",a);
                    if (a!=null){
                        backButtonCount =0;
                        if (a.equals("picemachine")){
                            setTitle("قطع الغيار");
                            titiel.setText("قطع الغيار");
                            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                                    new PartsFragment()).commit();

                            bottomNav.setSelectedItemId(R.id.navigation_notificaytion);
                        }

                        else if (a.equals("machine")){
                            setTitle("الماكينات");
                            titiel.setText("الماكينات");
                            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                                    new ProdectFragment()).commit();

                            bottomNav.setSelectedItemId(R.id.navigation_chat);
                        }

                        else if (a.equals("profilehome")){
                            setTitle("الصفحه الشخصيه ");
                            titiel.setText("الصفحه الشخصيه ");
                            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                                    new MyProfile()).commit();


                            bottomNav.getMenu().setGroupCheckable(0, false, true);

//                            bottomNav.setSelectedItemId(R.id.navigation_chat);
                        }
                        else if (a.equals("service")){
                            setTitle("الخدمات");
                            titiel.setText("الخدمات");
                            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                                    new ProfileFragment()).commit();
                            bottomNav.setSelectedItemId(R.id.navigation_profile);
                        }
                        else if (a.equals("courses")){
                            setTitle("الدورات التدريبية");
                            titiel.setText("الدورات التدريبية");
                            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                                    new CoursesFragment()).commit();

                            bottomNav.setSelectedItemId(R.id.navigation_save);
                        }
                        else {
                            setTitle("الرئيسية");
                            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                                    new HomeFragment()).commit();

                            bottomNav.setSelectedItemId(R.id.navigation_home);
//                            bottomNav.sets
                        }
                    }

                } else {
                    setTitle("الرئيسية");
                    titiel.setText("الرئيسية");
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                            new HomeFragment()).commit();
                    bottomNav.setSelectedItemId(R.id.navigation_home);
//                    bottomNav.
//                    bottomNav.getMenu().findItem(R.id.navigation_home).setChecked(false);

                }

            }
//


            ///>>>


        }catch (Exception e){
//            startActivity(new Intent(getApplicationContext(),Home.class));
            finish();
        }





        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
//                .setDrawerLayout(drawer)
//                .build();

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }


    @Override
    public void onBackPressed()
    {
        if(backButtonCount >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_LONG).show();
            backButtonCount++;
        }
    }


    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_notification:
                setTitle("العروض");
                titiel.setText("العروض");
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                        new OffersFragment()).commit();
                //your code
                // EX : call intent if you want to swich to other activity
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragmentall=null;
        Class frclass=null;

//        case R.id.action_notification:
//        backButtonCount =0;
//        selectedFragment = new OffersFragment();
//        setTitle("العروض");
//        titiel.setText("العروض");
//        bottomNav.getMenu().setGroupCheckable(0, true, true);
//        bottomNav.getMenu().findItem(R.id.navigation_home).setChecked(true);
////                    remove_slect_drawer();
//        break;
        if (id == R.id.nav_home) {
            backButtonCount =0;
            frclass= HomeFragment.class;
            setTitle("الرئيسية");
            titiel.setText("الرئيسية");
            bottomNav.setSelectedItemId(R.id.navigation_home);

        } else if (id == R.id.action_notification) {
            backButtonCount =0;
            frclass= OffersFragment.class;
            setTitle("العروض");
            titiel.setText("العروض");
            bottomNav.getMenu().setGroupCheckable(0, false, true);
//            bottomNav.setSelectedItemId(R.id.navigation_remveEfect);

        }else if (id == R.id.notification_muOrder) {
            backButtonCount =0;
            frclass= OffersFragment.class;
            setTitle("العروض");
            titiel.setText("العروض");
            bottomNav.getMenu().setGroupCheckable(0, false, true);
//            bottomNav.setSelectedItemId(R.id.navigation_remveEfect);

        }else if (id == R.id.nav_muOrder) {
            backButtonCount =0;
            frclass= MyOrder.class;
            setTitle("سجل التعاملات");
            titiel.setText("سجل التعاملات");
            bottomNav.getMenu().setGroupCheckable(0, false, true);
//            bottomNav.setSelectedItemId(R.id.navigation_remveEfect);

        } else if (id == R.id.nav_myCources) {
            backButtonCount =0;
            frclass= Show_CoursesFragment.class;
            setTitle("الدورات التدريبية ");
            titiel.setText("الدورات التدريبية ");
            bottomNav.getMenu().setGroupCheckable(0, false, true);

        } else if (id == R.id.nav_aboutUs) {
            backButtonCount =0;
            titiel.setText("من نحن");
            setTitle("من نحن");
            frclass= AboutUs.class;
            bottomNav.setSelected(false);
            bottomNav.getMenu().setGroupCheckable(0, false, true);
        }
        else if (id == R.id.nav_profile) {
            backButtonCount =0;
            frclass= MyProfile.class;
            setTitle("اعدادات الصفحه الشخصيه ");
            titiel.setText("اعدادات الصفحه الشخصيه ");
            bottomNav.setSelected(false);
            bottomNav.getMenu().setGroupCheckable(0, false, true);

        }
        else if (id == R.id.nav_ConnectUs) {
            backButtonCount =0;

            frclass= ContactUs.class;
            setTitle("اتصل بنا  ");
            titiel.setText("اتصل بنا  ");
//            setTitle("تواصل معنا ");
//            titiel.setText("تواصل معنا ");
            bottomNav.setSelected(false);
            bottomNav.getMenu().setGroupCheckable(0, false, true);

        }
        else if (id == R.id.nav_ChangePassword) {
            backButtonCount =0;
            frclass= ChangePassword.class;
            setTitle("تغيير الرقم السري ");
            titiel.setText("تغيير الرقم السري ");
            bottomNav.getMenu().setGroupCheckable(0, false, true);

        }else if (id == R.id.nav_logout) {

            frclass= HomeFragment.class;
            setTitle("الصفحه الشخصيه ");
            titiel.setText("الصفحه الشخصيه ");
            SharedPrefManager.getInstance(getApplicationContext()).logout();
//            startActivity(new Intent(getApplicationContext(), Login.class));
            Intent intent= new Intent(getApplicationContext(), Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            bottomNav.getMenu().setGroupCheckable(0, false, true);
        }

        try {
            fragmentall= (Fragment) frclass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                fragmentall).commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            Fragment selectedFragment = null;


            switch (item.getItemId()) {

                case R.id.navigation_home:
                    backButtonCount =0;
                    selectedFragment = new HomeFragment();
                    setTitle("الرئيسية");
                    titiel.setText("الرئيسية");
                    bottomNav.getMenu().setGroupCheckable(0, true, true);
                    bottomNav.getMenu().findItem(R.id.navigation_home).setChecked(true);
//                    remove_slect_drawer();
                    break;

                case R.id.navigation_chat:
                    backButtonCount =0;
                    selectedFragment = new ProdectFragment();
                    setTitle("الماكينات");
                    titiel.setText("الماكينات");
                    bottomNav.getMenu().setGroupCheckable(0, true, true);
                    bottomNav.getMenu().findItem(R.id.navigation_chat).setChecked(true);
//                    remove_slect_drawer();
                    break;


                case R.id.navigation_notificaytion:
                    backButtonCount =0;
                    setTitle("قطع الغيار");
                    titiel.setText("قطع الغيار");
                    selectedFragment = new PartsFragment();
                    bottomNav.getMenu().setGroupCheckable(0, true, true);
                    bottomNav.getMenu().findItem(R.id.navigation_notificaytion).setChecked(true);
//                    remove_slect_drawer();
                    break;
//


                case R.id.navigation_profile:
                    backButtonCount =0;
                    selectedFragment = new ProfileFragment();
                    setTitle("الخدمات");
                    titiel.setText("الخدمات");
                    bottomNav.getMenu().setGroupCheckable(0, true, true);
                    bottomNav.getMenu().findItem(R.id.navigation_profile).setChecked(true);
//                    remove_slect_drawer();
                    break;

                case R.id.navigation_save:
                    backButtonCount =0;
                    setTitle("الدورات التدريبية");
                    titiel.setText("الدورات التدريبية");
                    selectedFragment = new CoursesFragment();
                    bottomNav.getMenu().setGroupCheckable(0, true, true);
                    bottomNav.getMenu().findItem(R.id.navigation_save).setChecked(true);

//                    remove_slect_drawer();

                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                    selectedFragment).commit();
            return true;
        }
    };


    protected void remove_slect_drawer(){
        navigationView.getMenu().getItem(0).setChecked(false);
        navigationView.getMenu().getItem(1).setChecked(false);
        navigationView.getMenu().getItem(2).setChecked(false);
        navigationView.getMenu().getItem(3).setChecked(false);
        navigationView.getMenu().getItem(4).setChecked(false);
        navigationView.getMenu().getItem(5).setChecked(false);
        navigationView.getMenu().getItem(6).setChecked(false);
        navigationView.getMenu().getItem(7).setChecked(false);
    }





    //>>>>>>>>>>>>
//    uplode profile
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {

            //getting the image Uri
            Uri imageUri = data.getData();
            Uri filePath = data.getData();
            try {
                //getting bitmap object from uri
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);

                //displaying selected image to imageview
//                imageView.setImageBitmap(bitmap);

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                Bitmap lastBitmap = null;
                lastBitmap = bitmap;
                //encoding image to string
                String image = getStringImage(lastBitmap);
                Log.d("image",image);


                uploadBitmap();

                //passing the image to volley
//                SendImage(image);
                //calling the method uploadBitmap to upload image
//                uploadBitmap();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





    private void uploadBitmap() {
        final ProgressDialog progressDialog=new ProgressDialog(Home.this);
        progressDialog.setMessage(" برجاء اﻻنتظار...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        //our custom volley request
        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST,
                Urls.uplodeImageProfile +SharedPrefManager.getInstance(getApplicationContext()).getid_securety(),
                new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response) {
                        progressDialog.dismiss();
                        try {
                            Log.e("responseimge>>>>>>>",""+response.toString());
                            JSONObject obj = new JSONObject(new String(response.data));
//                            Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            Log.e("responseimge>>>>>>>",""+obj.getString("errorStatus"));
                            boolean errprstates= Boolean.parseBoolean(obj.getString("errorStatus"));
                            if (obj.getString("errorStatus").equals(false)  || errprstates == false ){
//                                Toast.makeText(getApplicationContext(), obj.getString("Upload image"), Toast.LENGTH_SHORT).show();
//                                finish();

                                getjson( SharedPrefManager.getInstance(getApplicationContext()).gettoken(),
                                        SharedPrefManager.getInstance(getApplicationContext()).getid_type(),
                                        SharedPrefManager.getInstance(getApplicationContext()).getheader());

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {


                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
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
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {

            //            /** Passing some request headers* */

            /*
             * If you want to add more parameters with the image
             * you can do it here
             * here we have only one parameter with the image
             * which is tags
             * */
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("tags", tags);
//                return params;
//            }

            /*
             * Here we are passing image by renaming it with a unique name
             * */
            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
                long imagename = System.currentTimeMillis();
                params.put("multipartFile", new DataPart(imagename + ".png", getFileDataFromDrawable(bitmap)));
                return params;
            }
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Authorization",
                        SharedPrefManager.getInstance(getApplicationContext()).getheader());
                return headers;
            }
        };

        //adding the request to volley
        volleyMultipartRequest.setRetryPolicy(new DefaultRetryPolicy(
                    1000000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//            mRequestQueue.add(stringRequest);

        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(mRequestQueue.add(volleyMultipartRequest));
//        Volley.newRequestQueue(this).add(volleyMultipartRequest);
    }

    public byte[] getFileDataFromDrawable(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }


    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;

    }





    //  get login again

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

                                    SharedPrefManager sharedPrefManager = new SharedPrefManager(Home.this);
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
                                    finish();
                                }

////                                username.setText(""+dataDelevery.getResultData().getCustomer().getCustomerNameAr());
//                                email.setText(""+dataDelevery.getResultData().getUserName());
////                                name.setText(""+dataDelevery.getResultData().getCustomer().getCustomerNameAr());
////                                phone.setText(""+dataDelevery.getResultData().getCustomer().getPhoneNumber1());
//                                try {
//                                    if (
//                                            dataDelevery.getResultData().getCustomer().getProfileImage()==null
//                                                    ||dataDelevery.getResultData().getCustomer().getProfileImage().equals(null)
//                                                    || dataDelevery.getResultData().getCustomer().getProfileImage().isEmpty()
//                                                    || dataDelevery.getResultData().getCustomer().getProfileImage()=="")
//                                    {
////                                        imageView.setImageResource(R.mipmap.sharpest_logo);
//                                    }else {
////                                        Picasso.with(getActivity())
////                                                .load(dataDelevery.getResultData().getCustomer().getProfileImage())
////                                                .error(R.mipmap.sharpest_logo)
////                                                .into(imageView);
//                                    }
//                                }catch (Exception e){
////                                    imageView.setImageResource(R.mipmap.sharpest_logo);
//                                }

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

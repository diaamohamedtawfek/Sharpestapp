 package com.Sharpest.sharpestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.Sharpest.sharpestapp.Home.Home;
import com.Sharpest.sharpestapp.Login_Signup.Login;

 public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SharedPrefManager.getInstance(getApplicationContext()).logout();
        if (SharedPrefManager.getInstance(getApplicationContext()).isLoggedIn()){
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();
        }else {

        }
//        new SpotsDialog.Builder()
//                .setContext(this)
//                .setMessage("Custom message")
//                .build()
//                .show();
        Button start=findViewById(R.id.bu_start_main);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });
    }
}

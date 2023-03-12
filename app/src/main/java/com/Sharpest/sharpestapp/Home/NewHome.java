package com.Sharpest.sharpestapp.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.SharedPrefManager;

public class NewHome extends AppCompatActivity {

    CardView pice_macine,machine,service,courses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_home);

        Log.e("Id User", SharedPrefManager.getInstance(getApplicationContext()).getid()+" " );
        pice_macine=findViewById(R.id.card_picemachine);
        machine=findViewById(R.id.card_machine);
        courses=findViewById(R.id.card_courses);
        service=findViewById(R.id.card_service);



        pice_macine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Home.class);
                intent.putExtra("test","picemachine");
                startActivity(intent);
            }
        });


        machine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Home.class);
                intent.putExtra("test","machine");
                startActivity(intent);
            }
        });




        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Home.class);
                intent.putExtra("test","service");
                startActivity(intent);
            }
        });




        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Home.class);
                intent.putExtra("test","courses");
                startActivity(intent);
            }
        });



    }
}

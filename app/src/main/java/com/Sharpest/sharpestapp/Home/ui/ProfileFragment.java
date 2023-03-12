package com.Sharpest.sharpestapp.Home.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.Sharpest.sharpestapp.R;
import com.Sharpest.sharpestapp.UI.service_Responce.DesginAndPrograming;
import com.Sharpest.sharpestapp.UI.service_Responce.Photo3d;
import com.Sharpest.sharpestapp.UI.service_Responce.Seana;


public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    View view;

    RelativeLayout relativeLayout_seana,relativeLayout_desginprograming,relativeLayout_photo3d;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile, container, false);


//        Intent intent_service = new Intent(getActivity(), LocationMonitoringService.class);
//        getActivity().startService(intent_service);

        relativeLayout_seana=view.findViewById(R.id.rel_seana);
        relativeLayout_seana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Seana.class));
            }
        });
        relativeLayout_desginprograming=view.findViewById(R.id.rel_desgin_programing);
        relativeLayout_desginprograming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DesginAndPrograming.class));
            }
        });
        relativeLayout_photo3d=view.findViewById(R.id.rel_photo3d);
        relativeLayout_photo3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Photo3d.class));
            }
        });

        return view;
    }
}

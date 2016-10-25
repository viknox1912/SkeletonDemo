package com.example.viknox.skeletondemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by x230 on 10/25/2016.
 */
public class HomeFrg extends Fragment implements View.OnClickListener{
    FragmentComms fcom ;
    ImageButton bt_search,bt_settings,bt_groups,bt_chat;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fcom = (FragmentComms)getActivity();
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        bt_chat = (ImageButton)getActivity().findViewById(R.id.btn_chat);
        bt_groups = (ImageButton)getActivity().findViewById(R.id.btn_groups);
        bt_settings = (ImageButton)getActivity().findViewById(R.id.btn_settings);
        bt_search = (ImageButton)getActivity().findViewById(R.id.btn_search);
        bt_search.setOnClickListener(this);
        bt_settings.setOnClickListener(this);
        bt_groups.setOnClickListener(this);
        bt_chat.setOnClickListener(this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_chat:
                Log.w("Viknox","Go to Chat");
            break;
            case  R.id.btn_groups:
                Log.w("Viknox","Go to Groups");
                break;
            case R.id.btn_search:
                Log.w("Viknox","Go to Search");

                break;
            case R.id.btn_settings:
                Log.w("Viknox","Go to Settings");
                break;
        }
        //

    }
}

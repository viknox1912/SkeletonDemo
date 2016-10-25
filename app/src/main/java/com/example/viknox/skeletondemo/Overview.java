package com.example.viknox.skeletondemo;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.FacebookSdk;

public class Overview extends AppCompatActivity implements View.OnClickListener, FragmentComms {
    private ImageButton btn_search, btn_groups, btn_chat, btn_settings;
    android.app.FragmentManager manager = getFragmentManager();
    android.app.FragmentTransaction transaction = manager.beginTransaction();
    SettingsFrg frg = new SettingsFrg();
    ChatFrg chfrg = new ChatFrg();
    GrouFrg grpfrg = new GrouFrg();
    SearchFrg srchfrg = new SearchFrg();
    HomeFrg hmfrg = new HomeFrg();
    LinearLayout nav_pane;

    public void switchFragment(final Fragment fragment, final String tag) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (fragment != null) {
                    manager.beginTransaction().replace(R.id.frg_holder,
                    fragment, tag).addToBackStack(null).commitAllowingStateLoss();

                }
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_overview);
        loadUI();
        transaction.add(R.id.frg_holder,hmfrg,"STNGFRG");
        transaction.commit();

    }

    @Override
    protected void onResume() {
        nav_pane.setVisibility(View.GONE);//Bug to fix: Remove pane whenever Home pane is resumed
                                            //Solution: Button to navigate to home fragment

        super.onResume();
    }

    private void loadUI() {
        nav_pane = (LinearLayout)findViewById(R.id.nav_bar);
        nav_pane.setVisibility(View.GONE);
        btn_chat = (ImageButton) findViewById(R.id.chatBtn);
        btn_search = (ImageButton)findViewById(R.id.searchBtn);
        btn_settings = (ImageButton)findViewById(R.id.settingsBtn);
        btn_groups = (ImageButton) findViewById(R.id.groupsBtn);
        btn_chat.setOnClickListener(this);
        btn_groups.setOnClickListener(this);
        btn_settings.setOnClickListener(this);
        btn_search.setOnClickListener(this);

    }


    public void onClick(View view){

    switch (view.getId()){
        case R.id.chatBtn:
            switchFragment(chfrg,"CHTFRG");
            Toast.makeText(Overview.this, "go to chat", Toast.LENGTH_SHORT).show();
            break;
        case R.id.searchBtn:
            switchFragment(srchfrg,"SRCHFRG");
            Toast.makeText(Overview.this, "go to search", Toast.LENGTH_SHORT).show();
            break;
        case R.id.settingsBtn:
            switchFragment(frg, "STNGFRG");
            Toast.makeText(Overview.this, "go to settings", Toast.LENGTH_SHORT).show();
            break;
        case R.id.groupsBtn:
            switchFragment(grpfrg,"GRPFRG");
            Toast.makeText(Overview.this, "go to groups", Toast.LENGTH_SHORT).show();
            break;
    }
    }
    @Override
    public void respond(String data1) {
        nav_pane.setVisibility(View.VISIBLE);
        switch(data1){
            case "Chat":
                 switchFragment(chfrg,"CHTFRG");
                break;
            case "Group":
                switchFragment(grpfrg,"GRPFRG");
                break;
            case "Search":
                  switchFragment(srchfrg,"SRCHFRG");
                break;
            case "Settings":
                  switchFragment(frg, "STNGFRG");
                break;
        }
    }
 }
package com.example.viknox.skeletondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Overview extends AppCompatActivity implements View.OnClickListener{
    ImageButton btn_search, btn_groups, btn_chat, btn_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        loadUI();
    }

    private void loadUI() {
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
            Toast.makeText(Overview.this, "go to chat", Toast.LENGTH_SHORT).show();
            break;
        case R.id.searchBtn:
            Toast.makeText(Overview.this, "go to search", Toast.LENGTH_SHORT).show();
            break;
        case R.id.settingsBtn:
            Toast.makeText(Overview.this, "go to settings", Toast.LENGTH_SHORT).show();
            break;
        case R.id.groupsBtn:
            Toast.makeText(Overview.this, "go to groups", Toast.LENGTH_SHORT).show();
            break;

    }

    }
}
package com.example.viknox.skeletondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyMain extends AppCompatActivity {
    Button btn_nav;
    TextView tv_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);
        loadUI();
    }


    private void loadUI() {
        btn_nav = (Button) findViewById(R.id.nvBtn);
        tv_nav = (TextView) findViewById(R.id.textView);
        btn_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyMain.this,Overview.class));

                //go to next screen

            }
        });
    }

}

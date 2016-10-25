package com.example.viknox.skeletondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

public class MyMain extends AppCompatActivity {
    String[] permissions = { "public_profile", "user_friends", "email", "user_birthday" };
    Button btn_nav;
    TextView tv_nav;
    LoginButton fb_login;


    private CallbackManager callbackManager;
    private FacebookCallback<LoginResult> fbcall = new FacebookCallback<LoginResult>(){

        @Override
        public void onSuccess(LoginResult loginResult) {
            GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject object, GraphResponse response) {
                            Log.d("FacebookLogin", response.toString());


                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email,gender,birthday,picture");
            request.setParameters(parameters);
            request.executeAsync();




        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_my_main);
        loadUI();
    }


    private void loadUI() {
        fb_login = (LoginButton) findViewById(R.id.bt_login);
        fb_login.setReadPermissions(permissions);
        fb_login.registerCallback(callbackManager,fbcall);
        btn_nav = (Button) findViewById(R.id.nvBtn);
        tv_nav = (TextView) findViewById(R.id.textView);
        btn_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyMain.this,Overview.class));

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}

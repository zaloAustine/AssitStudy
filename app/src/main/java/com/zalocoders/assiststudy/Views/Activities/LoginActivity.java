package com.zalocoders.assiststudy.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.zalocoders.assiststudy.R;

import in.codeshuffle.typewriterview.TypeWriterView;

public class LoginActivity extends AppCompatActivity {

    TextView link_to_register;
    MaterialButton login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        link_to_register = findViewById(R.id.link_to_register);
        link_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,Signup_activity.class));
            }
        });

        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

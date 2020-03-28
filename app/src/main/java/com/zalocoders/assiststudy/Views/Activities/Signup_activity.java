package com.zalocoders.assiststudy.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.zalocoders.assiststudy.R;

import in.codeshuffle.typewriterview.TypeWriterView;

public class Signup_activity extends AppCompatActivity {

    TextView link_to_login;
    MaterialButton next;
    TypeWriterView signuptext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activity);

        link_to_login = findViewById(R.id.link_to_login);
        link_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup_activity.this,LoginActivity.class));
            }
        });

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup_activity.this,NextSignUpActivity.class));
            }
        });


        signuptext = findViewById(R.id.signuptext);
        //Setting each character animation delay
        signuptext.setDelay(20);

        //Setting music effect On/Off
        signuptext.setWithMusic(false);

        //Animating Text
        String tt = signuptext.getText().toString();
        signuptext.animateText(tt);

    }

}

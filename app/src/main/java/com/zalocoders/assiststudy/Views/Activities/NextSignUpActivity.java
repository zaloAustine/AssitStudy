package com.zalocoders.assiststudy.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.zalocoders.assiststudy.R;

import in.codeshuffle.typewriterview.TypeWriterView;

public class NextSignUpActivity extends AppCompatActivity {
TypeWriterView signuptext;
MaterialButton finish,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_sign_up);


        signuptext = findViewById(R.id.signuptext);
        //Setting each character animation delay
        signuptext.setDelay(20);

        //Setting music effect On/Off
        signuptext.setWithMusic(false);

        //Animating Text
        String tt = signuptext.getText().toString();
        signuptext.animateText(tt);


        finish = findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NextSignUpActivity.this,MainActivity.class));
                finish();
            }
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NextSignUpActivity.this,Signup_activity.class));
            }
        });
    }
}

package com.zalocoders.assiststudy.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.zalocoders.assiststudy.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();
    }



    class LogoLauncher extends Thread{
        @Override
        public void run() {

            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            super.run();


            startActivity(new Intent(SplashScreen.this, LoginActivity.class));
            finish();
        }
    }
}

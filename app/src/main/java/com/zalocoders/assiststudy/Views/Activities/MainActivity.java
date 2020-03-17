package com.zalocoders.assiststudy.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.zalocoders.assiststudy.R;

public class MainActivity extends AppCompatActivity {
MaterialToolbar materialToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materialToolbar = findViewById(R.id.materialToolbar);
        setSupportActionBar(materialToolbar);
    }
}

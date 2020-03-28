package com.zalocoders.assiststudy.Views.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zalocoders.assiststudy.R;
import com.zalocoders.assiststudy.Views.Fragements.Qa_fragment;
import com.zalocoders.assiststudy.Views.Fragements.explore_frgment;
import com.zalocoders.assiststudy.Views.Fragements.home_fragment;
import com.zalocoders.assiststudy.Views.Fragements.library_fragment;

public class MainActivity extends AppCompatActivity {
MaterialToolbar materialToolbar;
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materialToolbar = findViewById(R.id.materialToolbar);
        setSupportActionBar(materialToolbar);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);





        if(savedInstanceState == null){

            Intent iin= getIntent();
            int val = iin.getIntExtra("transaction",0);

            if(val==3){
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new library_fragment()).commit();

            }else{
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new home_fragment()).commit();

            }
        }



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new home_fragment();
                        break;
                    case R.id.library:
                        fragment = new library_fragment();
                        break;
                    case R.id.post:
                        fragment = new explore_frgment();
                        break;
                    case R.id.qa:
                        fragment = new Qa_fragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

                return true;
            }
        });
    }


}

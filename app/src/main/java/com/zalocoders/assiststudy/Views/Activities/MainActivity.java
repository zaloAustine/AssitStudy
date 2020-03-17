package com.zalocoders.assiststudy.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.zalocoders.assiststudy.Adapters.RecentViewCoursesAdapter;
import com.zalocoders.assiststudy.Models.RecentViewCourses;
import com.zalocoders.assiststudy.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
MaterialToolbar materialToolbar;
List<RecentViewCourses>  recentViewCourses;
RecentViewCoursesAdapter adapter;
RecyclerView recentRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materialToolbar = findViewById(R.id.materialToolbar);
        setSupportActionBar(materialToolbar);
        recentRecyclerview = findViewById(R.id.recentRecyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recentRecyclerview.setLayoutManager(gridLayoutManager);

        recentViewCourses = new ArrayList<>();
        fake();
        adapter = new RecentViewCoursesAdapter(recentViewCourses,this);
        recentRecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    public void fake(){
        for(int i=0;i<4;i++){
            RecentViewCourses courses = new RecentViewCourses();
            courses.setDescription("This is a beginner Kotlin android course");
            courses.setName("Koltin Android");
            recentViewCourses.add(courses);

        }

    }

}

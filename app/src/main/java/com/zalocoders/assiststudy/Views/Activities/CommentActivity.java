package com.zalocoders.assiststudy.Views.Activities;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.zalocoders.assiststudy.Adapters.CommentAdapter;
import com.zalocoders.assiststudy.Adapters.NotesAdapter2;
import com.zalocoders.assiststudy.Models.CommentModel;
import com.zalocoders.assiststudy.Models.NoteModel;
import com.zalocoders.assiststudy.R;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {

    List<CommentModel> recentViewCourses;
    CommentAdapter adapter;
    RecyclerView recentRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        recentRecyclerview = findViewById(R.id.recentRecyclerview);
        recentRecyclerview.setNestedScrollingEnabled(false);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CommentActivity.this);

        recentRecyclerview.setLayoutManager(linearLayoutManager);

        recentViewCourses = new ArrayList<>();
        fake();
        adapter = new CommentAdapter(recentViewCourses,CommentActivity.this);
        recentRecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    public void fake(){
        for(int i=0;i<10;i++){
            CommentModel courses = new CommentModel();
            courses.setComment("This is a beginner Kotlin android course"+ i);
            courses.setCreated_at("Theory Of Computing");
            recentViewCourses.add(courses);

        }

    }
}

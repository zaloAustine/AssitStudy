package com.zalocoders.assiststudy.Views.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.zalocoders.assiststudy.Adapters.NotesAdapter2;
import com.zalocoders.assiststudy.Adapters.RecentViewCoursesAdapter2;
import com.zalocoders.assiststudy.Models.NoteModel;
import com.zalocoders.assiststudy.Models.UnitModel;
import com.zalocoders.assiststudy.R;

import java.util.ArrayList;
import java.util.List;

public class UnitNotesActivity extends AppCompatActivity {
    MaterialToolbar materialToolbar;
    List<NoteModel> recentViewCourses;
    NotesAdapter2 adapter;
    RecyclerView recentRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_notes);


        recentRecyclerview = findViewById(R.id.recentRecyclerview);
        recentRecyclerview.setNestedScrollingEnabled(false);
        materialToolbar = findViewById(R.id.materialToolbar);
        setSupportActionBar(materialToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(UnitNotesActivity.this);

        recentRecyclerview.setLayoutManager(linearLayoutManager);

        recentViewCourses = new ArrayList<>();
        fake();
        adapter = new NotesAdapter2(recentViewCourses,UnitNotesActivity.this);
        recentRecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void fake(){
        for(int i=0;i<10;i++){
            NoteModel courses = new NoteModel();
            courses.setDescription("This is a beginner Kotlin android course"+ i);
            courses.setName("Theory Of Computing");
            recentViewCourses.add(courses);

        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
               Intent i = new Intent(UnitNotesActivity.this,MainActivity.class);
               i.putExtra("transaction",3);
               startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

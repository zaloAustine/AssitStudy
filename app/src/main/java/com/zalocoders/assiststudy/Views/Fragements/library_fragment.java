package com.zalocoders.assiststudy.Views.Fragements;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.zalocoders.assiststudy.Adapters.RecentViewCoursesAdapter;
import com.zalocoders.assiststudy.Adapters.RecentViewCoursesAdapter2;
import com.zalocoders.assiststudy.Models.UnitModel;
import com.zalocoders.assiststudy.R;
import com.zalocoders.assiststudy.Views.Activities.PlanActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class library_fragment extends Fragment {
    Context context;
    MaterialToolbar materialToolbar;
    List<UnitModel> recentViewCourses;
    RecentViewCoursesAdapter2 adapter;
    RecyclerView recentRecyclerview;


    public library_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_library_fragment, container, false);
        context = container.getContext();

        recentRecyclerview = v.findViewById(R.id.recentRecyclerview);
        recentRecyclerview.setNestedScrollingEnabled(false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

        recentRecyclerview.setLayoutManager(linearLayoutManager);

        recentViewCourses = new ArrayList<>();
        fake();
        adapter = new RecentViewCoursesAdapter2(recentViewCourses,context);
        recentRecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return v;
    }

    public void fake(){
        for(int i=0;i<10;i++){
            UnitModel courses = new UnitModel();
            courses.setDescription("This is a beginner Kotlin android course"+ i);
            courses.setName("Theory Of Computing");
            recentViewCourses.add(courses);

        }

    }
}

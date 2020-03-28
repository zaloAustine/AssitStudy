package com.zalocoders.assiststudy.Views.Fragements;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.MaterialToolbar;
import com.zalocoders.assiststudy.Adapters.PostAdapter;
import com.zalocoders.assiststudy.Adapters.RecentViewCoursesAdapter2;
import com.zalocoders.assiststudy.Models.PostModel;
import com.zalocoders.assiststudy.Models.UnitModel;
import com.zalocoders.assiststudy.R;

import java.util.ArrayList;
import java.util.List;


public class Qa_fragment extends Fragment {

    Context context;
    MaterialToolbar materialToolbar;
    List<PostModel> recentViewCourses;
    PostAdapter adapter;
    RecyclerView recentRecyclerview;


    public Qa_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_qa_fragment, container, false);
        context = container.getContext();

        recentRecyclerview = v.findViewById(R.id.recentRecyclerview);
        recentRecyclerview.setNestedScrollingEnabled(false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

        recentRecyclerview.setLayoutManager(linearLayoutManager);

        recentViewCourses = new ArrayList<>();
        fake();
        adapter = new PostAdapter(recentViewCourses,context);
        recentRecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return v;
    }


    public void fake(){
        for(int i=0;i<10;i++){
            PostModel courses = new PostModel();
            courses.setDescription("Playfair Display is a serif font. This font takes influence from the designs of typeface designer John Baskerville. As the name indicates, Playfair Display is well suited for titling and headlines. It has an extra large x-height and short descenders. It can be set for instance in news headlines, or for stylistic effect in titles.\n" +
                    "\n" +
                    "Best used for: Stylised, elegant and sophisticated Websites & Mobile Apps. This stylistic font is best used in agency, portfolio websites, travel and fashion blogs. Great for headings and quotes. Try 34–38px for main Content and 84–92px for Headings."+ i);
            courses.setTitle("Theory Of Computing");
            recentViewCourses.add(courses);

        }

    }
}

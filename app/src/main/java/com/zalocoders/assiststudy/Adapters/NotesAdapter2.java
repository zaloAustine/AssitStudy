package com.zalocoders.assiststudy.Adapters;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.zalocoders.assiststudy.Models.NoteModel;
import com.zalocoders.assiststudy.R;
import com.zalocoders.assiststudy.Views.Activities.NoteItemActivity;
import com.zalocoders.assiststudy.Views.Activities.UnitNotesActivity;

import java.util.List;

public class NotesAdapter2 extends RecyclerView.Adapter<NotesAdapter2.ViewHolder> {
    List<NoteModel> recentViewCoursesList;
    Context context;
    public boolean on_attach = true;
    NoteModel recentViewCourse;


    public NotesAdapter2(List<NoteModel> recentViewCoursesList, Context context) {
        this.recentViewCoursesList = recentViewCoursesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recent_item3, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        recentViewCourse = recentViewCoursesList.get(position);
        holder.name.setText(recentViewCourse.getName());
        holder.description.setText(recentViewCourse.getDescription());

        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, NoteItemActivity.class));
            }
        });

        setAnimation(holder.itemView,position);

    }
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                on_attach = false;
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        super.onAttachedToRecyclerView(recyclerView);

    }

    @Override
    public int getItemCount() {
        return recentViewCoursesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        MaterialTextView description,name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            name = itemView.findViewById(R.id.name);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
    public void RightLeft(View itemview, int i) {
        if (!on_attach) {
            i = -1;
        }

        boolean isNotFirst = i == -1;
        i = i + 1;
        itemview.setTranslationX(itemview.getX() + 400);
        itemview.setAlpha(0.f);
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(itemview, "translationX", itemview.getX(), +400,0);
        ObjectAnimator animatorx = ObjectAnimator.ofFloat(itemview, "alpha", 1.f);
        ObjectAnimator.ofFloat(itemview, "alpha", 0.f).start();
        animatorY.setStartDelay(isNotFirst ? 150 : (i * 150));
        animatorY.setDuration((isNotFirst ? 2 : 1) * 150);
        set.playTogether(animatorY, animatorx);
        set.start();

    }

    public void setAnimation(View itemview, int i) {

        if (!on_attach) {
            i = -1;
        }


        boolean isNotFirst = i == -1;
        i++;

        itemview.setAlpha(0.f);
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator = ObjectAnimator.ofFloat(itemview, "alpha", 0.f, 0.5f, 1.0f);
        animator.setStartDelay(isNotFirst ? 500 / 2 : (i * 500 / 3));
        animator.setDuration(500);
        set.play(animator);
        animator.start();


    }
}

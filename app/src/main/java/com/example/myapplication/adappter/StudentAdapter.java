package com.example.myapplication.adappter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.Student;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private ArrayList<Student> alStudent;
    private Context context;

    public StudentAdapter(ArrayList<Student> alStudent, Context context) {
        this.alStudent = alStudent;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_item, parent, false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtStudentID.setText(String.valueOf(alStudent.get(position).getStudentID()));
        holder.txtStudentName.setText(alStudent.get(position).getFullName());

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_recycler_view);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return alStudent.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtStudentName, txtStudentID;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtStudentName = itemView.findViewById(R.id.txtStudentName);
            txtStudentID = itemView.findViewById(R.id.txtStudentID);
        }
    }
}

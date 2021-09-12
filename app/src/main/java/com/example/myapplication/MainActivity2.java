package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.adappter.StudentAdapter;
import com.example.myapplication.model.Student;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private Button btnActivity;
    private ArrayList<Student> alStudents;

    private RecyclerView rclStudentList;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnActivity = findViewById(R.id.btnActivity);
        rclStudentList = findViewById(R.id.rclStudentList);

        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
                overridePendingTransition(R.anim.anim_activity_enter, R.anim.anim_activity_exit);
            }
        });

        //data mẫu
        alStudents = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            alStudents.add(new Student(i, "Student " + i, "Address " + i, "098xxx"));
        }
        rclStudentList.setHasFixedSize(true);
        studentAdapter = new StudentAdapter(alStudents, MainActivity2.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rclStudentList.setLayoutManager(linearLayoutManager);
        rclStudentList.setAdapter(studentAdapter);
    }
}
package com.example.studentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homeactivity extends AppCompatActivity {


    Button exitApp , Add_students , view_student;
    DatabaseHelper databaseHelper;

    public  void initview(){
        exitApp = findViewById(R.id.exit_app);
        Add_students = findViewById(R.id.add_students_details);
        view_student = findViewById(R.id.view_all_students);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        databaseHelper = new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

        initview();

        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Add_students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeactivity.this , Add_studentActivity.class));

            }
        });

        view_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeactivity.this,viewbylist.class);
                startActivity(intent);
            }
        });


    }
}

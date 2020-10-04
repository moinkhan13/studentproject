package com.example.studentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_studentActivity extends AppCompatActivity {


    EditText student_year, Project_name,Member1_name,Member2_name,Member3_name,Member4_name,Member5_name,Software_used,Roll_numbers;
    Button add_details;
    DatabaseHelper databaseHelper;

    public  void initview(){
       student_year = findViewById(R.id.Student_year);
       Project_name = findViewById(R.id.Project_name);
       Member1_name = findViewById(R.id.Member1_name);
       Member2_name = findViewById(R.id.Member2_name);
       Member3_name = findViewById(R.id.Member3_name);
       Member4_name = findViewById(R.id.Member4_name);
       Member5_name = findViewById(R.id.Member5_name);
       Software_used = findViewById(R.id.Software_used);
       Roll_numbers = findViewById(R.id.Roll_numbers);
       add_details = findViewById(R.id.Add_details);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        databaseHelper = new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

        initview();


        add_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (student_year.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Insert Student Year First",Toast.LENGTH_SHORT).show();
                }else if (Project_name.getText().toString().isEmpty())  {
                    Toast.makeText(getApplicationContext(),"Insert Project Name First",Toast.LENGTH_SHORT).show();
                }else if (Member1_name.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Insert Member1 Name First",Toast.LENGTH_SHORT).show();
                }else if (Member2_name.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Insert Member1 Name First",Toast.LENGTH_SHORT).show();
                }else if (Member3_name.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Insert Member1 Name First",Toast.LENGTH_SHORT).show();
                }else if (Member4_name.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Insert Member1 Name First",Toast.LENGTH_SHORT).show();
                }else if (Member5_name.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Insert Member1 Name First",Toast.LENGTH_SHORT).show();
                }else if (Software_used .getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Insert Software Details first",Toast.LENGTH_SHORT).show();
                }else if (Roll_numbers.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Insert Roll numbers",Toast.LENGTH_SHORT).show();

                }else {
                    boolean insert = databaseHelper.insertStudent(student_year.getText().toString(), Project_name.getText().toString(), Member1_name.getText().toString(), Member2_name.getText().toString(), Member3_name.getText().toString(), Member4_name.getText().toString(), Member5_name.getText().toString(), Software_used.getText().toString(), Roll_numbers.getText().toString());
                    if (insert == true) {

                        Toast.makeText(getApplicationContext(),"Student Data Inserted Successfully",Toast.LENGTH_SHORT).show();


                    }else if (insert == false) {
                        Toast.makeText(getApplicationContext(),"Data Inserted Failed",Toast.LENGTH_SHORT).show();
                    }


                    }
                }
        });
    }
}

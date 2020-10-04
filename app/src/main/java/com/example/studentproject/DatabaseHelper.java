package com.example.studentproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String database_name = "students.db";
    public static final String table_name = "stud.db";



        public static final String student_id = "Student_id";
        public static final String student_year = "Student_year";
        public static final String project_name = "Project_name";
        public static final String member1_name = "member1_name";
        public static final String member2_name = "member2_name";
        public static final String member3_name = "member3_name";
        public static final String member4_name = "member4_name";
        public static final String member5_name = "member5_name";
        public static final String software_used = "Software_used";
        public static final String roll_numbers = "roll_numbers";






    public DatabaseHelper(@Nullable Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + table_name + "(student_id INTEGER PRIMARY KEY AUTOINCREMENT , Student_year text , Project_name text , member1_name text , member2_name text,member3_name text ,member4_name text ,member5_name text,Software_used text ,roll_numbers INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + table_name +"'");
        onCreate(sqLiteDatabase);

    }

    public boolean insertStudent(String student_year_s,String Project_name_s, String member1_name_s, String member2_name_s, String member3_name_s, String member4_name_s, String member5_name_s, String software_used_s , String roll_numbers_s){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(student_year,student_year_s);
        contentValues.put(project_name,Project_name_s);
        contentValues.put(member1_name,member1_name_s);
        contentValues.put(member2_name,member2_name_s);
        contentValues.put(member3_name,member3_name_s);
        contentValues.put(member4_name,member4_name_s);
        contentValues.put(member5_name,member5_name_s);
        contentValues.put(software_used,software_used_s);
        contentValues.put(roll_numbers,roll_numbers_s);

        Long success = sqLiteDatabase.insert(table_name,null,contentValues);

        if (success == -1){
            return false;
        }else {
            return true;
        }


    }

    public Cursor viewData(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "Select * from "+ table_name;
        Cursor cursor = database.rawQuery(query,null);

        return cursor;
    }
}

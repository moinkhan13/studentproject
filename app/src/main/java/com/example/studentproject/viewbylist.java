package com.example.studentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class viewbylist extends AppCompatActivity {

    private static final String TAG = "ListDataActivity";
    DatabaseHelper mDatabaseHelper ;

    private ListView eListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewbylist);
        eListView = (ListView) findViewById(R.id.users_list);
        mDatabaseHelper = new DatabaseHelper(this);
        populatedListView();
    }

    private void populatedListView(){
        Log.d(TAG,"PopulatedlistView : Displaying data in the Listview");
        Cursor cursor = mDatabaseHelper.viewData();
        ArrayList<String> listData = new ArrayList<>();
        while (cursor.moveToNext()){
            listData.add(cursor.getString(1));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        eListView.setAdapter(adapter);

        eListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on "+ name);

            }
        });
    }
    private  void  toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}

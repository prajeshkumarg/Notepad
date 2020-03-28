package com.example.notepad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> arr=new ArrayList<>();
    public static ArrayList<String>cont=new ArrayList<>();
    public static ArrayList<Integer>indices=new ArrayList<>();
    public static ArrayAdapter adapter;

    public void newActivity(View view){

        Intent i1=new Intent(this,Main2Activity.class);
        startActivity(i1);
    }


    SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferences1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ListView lv=findViewById(R.id.listview);
        sharedPreferences=getApplicationContext().getSharedPreferences("package com.example.notepad",MODE_PRIVATE);
        HashSet<String> set= (HashSet<String>) sharedPreferences.getStringSet("titles",null);
        sharedPreferences1=getSharedPreferences("package com.example.notepad",MODE_PRIVATE);
        HashSet<String> c= (HashSet<String>) sharedPreferences1.getStringSet("contents",null);


        if(set!=null){
            arr=new ArrayList<>(set);
            cont=new ArrayList<>(c);
        }


        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i2=new Intent(getApplicationContext(),Main3Activity.class);
                i2.putExtra("pos",position);
                startActivity(i2);
            }
        });



    }
}

package com.example.notepad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;

public class Main2Activity extends AppCompatActivity {
    int i;
    public void mainPage(View view){
        Intent i1=new Intent(this,MainActivity.class);
        startActivity(i1);
    }

    public void mainSave(View view) {

        if (i != -1) {
            MainActivity.arr.add(e.getText().toString());
            MainActivity.cont.add(c.getText().toString());
            MainActivity.adapter.notifyDataSetChanged();
            SharedPreferences sharedPreferences=getSharedPreferences("package com.example.notepad",MODE_PRIVATE);
            HashSet<String> ARR=new HashSet<>(MainActivity.arr);
            sharedPreferences.edit().putStringSet("titles",ARR).apply();
            SharedPreferences sharedPreferences1=getSharedPreferences("package com.example.notepad",MODE_PRIVATE);
            HashSet<String> CONT=new HashSet<>(MainActivity.cont);
            sharedPreferences.edit().putStringSet("contents",CONT).apply();
            Intent i1 = new Intent(this, MainActivity.class);
            startActivity(i1);
            Toast.makeText(this, "SAVED", Toast.LENGTH_LONG).show();
        }
    }

    EditText e,c;
    Button s,ed,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();


        e=findViewById(R.id.editText);
        c=findViewById(R.id.editText2);
        c.setImeOptions(EditorInfo.IME_ACTION_DONE);
        c.setRawInputType(InputType.TYPE_CLASS_TEXT);
        Intent i1=getIntent();
        i=i1.getIntExtra("loop",0);
    }
}

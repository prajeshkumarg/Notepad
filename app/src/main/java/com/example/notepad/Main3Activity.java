package com.example.notepad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;

public class Main3Activity extends AppCompatActivity {

    public void mainPage(View view){
        Intent i1=new Intent(this,MainActivity.class);
        startActivity(i1);
    }
    public void removeTitle(View view){
        MainActivity.arr.remove(i);
        MainActivity.cont.remove(i);
        MainActivity.adapter.notifyDataSetChanged();
        SharedPreferences sharedPreferences=getSharedPreferences("package com.example.notepad",MODE_PRIVATE);
        HashSet<String> ARR=new HashSet<>(MainActivity.arr);
        sharedPreferences.edit().putStringSet("titles",ARR).apply();
        SharedPreferences sharedPreferences1=getSharedPreferences("package com.example.notepad",MODE_PRIVATE);
        HashSet<String> CONT=new HashSet<>(MainActivity.cont);
        sharedPreferences.edit().putStringSet("contents",CONT).apply();
        Intent i1=new Intent(this,MainActivity.class);
        startActivity(i1);

    }
    public void onEdit(View view){
        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.VISIBLE);

    }
    public void onSave(View view){
        String a,b;
        a=x.getText().toString();
        b=y.getText().toString();
        MainActivity.arr.set(i,a);
        MainActivity.cont.set(i,b);
        b2.setVisibility(View.INVISIBLE);
        MainActivity.adapter.notifyDataSetChanged();
        SharedPreferences sharedPreferences=getSharedPreferences("package com.example.notepad",MODE_PRIVATE);
        HashSet<String> ARR=new HashSet<>(MainActivity.arr);
        sharedPreferences.edit().putStringSet("titles",ARR).apply();
        SharedPreferences sharedPreferences1=getSharedPreferences("package com.example.notepad",MODE_PRIVATE);
        HashSet<String> CONT=new HashSet<>(MainActivity.cont);
        sharedPreferences.edit().putStringSet("contents",CONT).apply();
        Intent i1=new Intent(this,MainActivity.class);
        startActivity(i1);

    }
    String s1,s2;
    Button b1,b2;
    EditText x,y;
    SharedPreferences sp,sp1;
    HashSet<String> str,str1;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();
        x=findViewById(R.id.editText);
        y=findViewById(R.id.editText2);
        b1=findViewById(R.id.button3);
        b2=findViewById(R.id.button4);
        b2.setVisibility(View.INVISIBLE);
        b1.setVisibility(View.VISIBLE);
        y.setImeOptions(EditorInfo.IME_ACTION_DONE);
        y.setRawInputType(InputType.TYPE_CLASS_TEXT);
        Bundle b=getIntent().getExtras();
        if(b!=null){
            i=b.getInt("pos");
        }
        sp=getSharedPreferences("package com.example.notepad",MODE_PRIVATE);
        sp1=getSharedPreferences("package com.example.notepad",MODE_PRIVATE);
        str= (HashSet<String>) sp.getStringSet("titles",null);
        str1= (HashSet<String>) sp1.getStringSet("contents",null);

        String[] tit=new String[str.size()];
        str.toArray(tit);

        String[] des=new String[str1.size()];
        str1.toArray(des);

        s1=tit[i];
        s2=des[i];

            x.setText(s1);
            y.setText(s2);

    }
}

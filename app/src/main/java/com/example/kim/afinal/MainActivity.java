package com.example.kim.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText uname;
    String abc="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.start);
        uname = (EditText) findViewById(R.id.name);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                abc=uname.getText().toString();
                if (abc.equals(""))
                    Toast.makeText(MainActivity.this,"請輸入姓名",Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent();
                    i.setClass(MainActivity.this, MainActivity1.class);
                    Bundle b = new Bundle();
                    b.putString("name", abc);
                    i.putExtras(b);
                    startActivity(i);
                }
            }
        });
    }
    }
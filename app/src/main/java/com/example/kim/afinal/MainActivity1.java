package com.example.kim.afinal;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity1 extends AppCompatActivity {
    ImageView dice;
    Button play;
    TextView status,result;
    Bundle b;
    int compd,i;
    String id="",uname="";
    int p=0,c=0,t=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dice=(ImageView)findViewById(R.id.dicep);
        play=(Button)findViewById(R.id.play);
        status=(TextView)findViewById(R.id.status);
        result=(TextView)findViewById(R.id.res);
        b=this.getIntent().getExtras();
        compd=(int)(Math.random()*6+1);
        uname=b.getString("name").toString();
        id=uname;
        status.setText(id+"的回合");
        dice.setImageResource(R.drawable.dice2);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDice();
            }
        });
    }

     private void setDice(){
        new AsyncTask<Void,Integer,Boolean>(){
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
            }
            @Override
            protected Boolean doInBackground(Void...voids){
                i=30;
                do{
                    SystemClock.sleep(i);
                    compd=(int)(Math.random()*6+1);
                    publishProgress(compd);
                    i=i+30;
                }while(i<300);
                return true;
            }
            @Override
            protected void onProgressUpdate(Integer... values){
                super.onProgressUpdate(values);
                switch(values[0]){
                    case 1:
                        dice.setImageResource(R.drawable.one);
                        status.setText(id+"擲的點數是"+compd);
                        break;
                    case 2:
                        dice.setImageResource(R.drawable.two);
                        status.setText(id+"擲的點數是"+compd);
                        break;
                    case 3:
                        dice.setImageResource(R.drawable.three);
                        status.setText(id+"擲的點數是"+compd);
                        break;
                    case 4:
                        dice.setImageResource(R.drawable.four);
                        status.setText(id+"擲的點數是"+compd);
                        break;
                    case 5:
                        dice.setImageResource(R.drawable.five);
                        status.setText(id+"擲的點數是"+compd);
                        break;
                    default:
                        dice.setImageResource(R.drawable.six);
                        status.setText(id+"擲的點數是"+compd);
                        break;
                }
            }
            @Override
            protected void onPostExecute(Boolean boo){
                Toast.makeText(MainActivity1.this,id+"的點數是"+compd,Toast.LENGTH_SHORT).show();
                if(t%2==0) {
                    p = compd;
                    id = "電腦";
                    result.setText("您的點數是"+p);
                }else {
                    c = compd;
                    id = uname;
                    if((c!=0)&&(p!=0))
                        if(p>c)
                            result.setText("您的點數是"+p+",電腦的點數是"+c+"，您是贏家");
                        else if(p<c)
                            result.setText("您的點數是"+p+",電腦的點數是"+c+"，電腦是贏家");
                        else
                             result.setText("您的點數是"+p+",電腦的點數是"+c+"，平手");
                }
                t=t+1;
                play.setText(id+"的回合");

            }
        }.execute();
    }
}
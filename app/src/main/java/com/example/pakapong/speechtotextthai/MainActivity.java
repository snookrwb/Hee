package com.example.pakapong.speechtotextthai;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    TextView txvResult1,txvResult2,txvResult3,txvResult4,txvResult5,txvResult6,txvResult7,txvResult8;
   // boolean w1=false,w2=false,w3=false,w4=false;
    //String []a;
    int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        txvResult1 = (TextView) findViewById(R.id.txvResult1);
        txvResult2 = (TextView) findViewById(R.id.txvResult2);
        txvResult3 = (TextView) findViewById(R.id.txvResult3);
        txvResult4 = (TextView) findViewById(R.id.txvResult4);
        txvResult5 = (TextView) findViewById(R.id.txvResult5);
        txvResult6 = (TextView) findViewById(R.id.txvResult6);
        txvResult7 = (TextView) findViewById(R.id.txvResult7);
        txvResult8 = (TextView) findViewById(R.id.txvResult8);
        btn1 = (Button) findViewById(R.id.btnspeak1);
        btn2 = (Button) findViewById(R.id.btnspeak2);
        btn3 = (Button) findViewById(R.id.btnspeak3);
        btn4 = (Button) findViewById(R.id.btnspeak4);
        btn5 = (Button) findViewById(R.id.btnspeak5);
        btn6 = (Button) findViewById(R.id.btnspeak6);
        btn7 = (Button) findViewById(R.id.btnspeak7);
        btn8 = (Button) findViewById(R.id.btnspeak8);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            switch (requestCode) {
                case 1:
                    txvResult1.setText(result.get(0));
                    break;
                case 2:
                    txvResult2.setText(result.get(0));
                    break;
                case 3:
                    txvResult3.setText(result.get(0));
                    break;
                case 4:
                    txvResult4.setText(result.get(0));
                    break;
                case 5:
                    txvResult5.setText(result.get(0));
                    break;
                case 6:
                    txvResult6.setText(result.get(0));
                    break;
                case 7:
                    txvResult7.setText(result.get(0));
                    break;
                case 8:
                    txvResult8.setText(result.get(0));
                    break;
            }

        }
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "th-TH");
        switch (v.getId()){
            case R.id.btnspeak1:
                num = 1;
                break;
            case R.id.btnspeak2:
                num = 2;
                break;
            case R.id.btnspeak3:
                num = 3;
                break;
            case R.id.btnspeak4:
                num = 4;
                break;
            case R.id.btnspeak5:
                num = 5;
                break;
            case R.id.btnspeak6:
                num = 6;
                break;
            case R.id.btnspeak7:
                num = 7;
                break;
            case R.id.btnspeak8:
                num = 8;
                break;
        }
        try {
            startActivityForResult(intent,num);
        }catch (ActivityNotFoundException e){
            Toast.makeText(getApplicationContext(), "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }
}

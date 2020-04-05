package com.example.truco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private int placar1;
    private int placar2;
    private int trucoM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button btnAdd1 = findViewById(R.id.button);
        final Button btnnAdd2 = findViewById(R.id.button2);
        Button Truco = findViewById(R.id.TrucoBtn);
        final TextView tv1 = findViewById(R.id.textView3);
        final TextView tv2 = findViewById(R.id.textView2);
        final Intent win = new Intent(this, WinActivity.class);
        final Button btnMenos1 = findViewById(R.id.button3);
        final Button btnMenos2 = findViewById(R.id.button4);
        trucoM = 1;


        btnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int teste = trucoM + placar1;
                if(teste < 12) {
                    if (placar1 < 11) {
                        placar1 = placar1 + trucoM;
                        tv1.setText("" + placar1);

                    } else {
                        tv1.setText(""+12);
                        startActivity(win);



                    }
                }else{
                    tv1.setText(""+12);
                    startActivity(win);

                }
                btnnAdd2.setText("+1");
                btnAdd1.setText("+1");
                trucoM =1;
            }
        });

        btnnAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int teste2 = trucoM + placar2;
                if(teste2 < 12) {
                    if (placar2 < 11) {
                        placar2 = placar2 + trucoM;
                        tv2.setText("" + placar2);

                    } else {
                        tv2.setText(""+12);
                        startActivity(win);


                    }
                }else{
                    tv2.setText(""+12);
                    startActivity(win);
                }
                btnAdd1.setText("+1");
                btnnAdd2.setText("+1");
                trucoM = 1;
            }
        });

        Truco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(btnnAdd2.getText() == "+3" && btnAdd1.getText() == "+3"){
                  btnnAdd2.setText("+6");
                  btnAdd1.setText("+6");
              }else if(btnnAdd2.getText() == "+6" && btnAdd1.getText() == "+6"){
                  btnnAdd2.setText("+9");
                  btnAdd1.setText("+9");
                }
              else if(btnnAdd2.getText() == "+9" && btnAdd1.getText() == "+9"){
                  btnnAdd2.setText("+12");
                  btnAdd1.setText("+12");
              }
              else{
                  btnAdd1.setText("+3");
                  btnnAdd2.setText("+3");
              }
                if(trucoM == 1){
                trucoM = trucoM + 2;
                }else{
                    if(trucoM >= 12){
                        trucoM = 0;
                    }
                    if(trucoM < 11){
                    trucoM = trucoM + 3;
                    }
                }


            }
        });

        btnMenos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(placar1 >= 1) {
                    placar1 = placar1 - 1;
                    tv1.setText("" + placar1);
                }
            }
        });

        btnMenos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(placar2 >= 1) {
                    placar2 = placar2 - 1;
                    tv2.setText("" + placar2);
                }

            }
        });

    }
}

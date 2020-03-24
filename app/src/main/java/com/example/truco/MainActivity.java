package com.example.truco;

import androidx.appcompat.app.AppCompatActivity;
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
        final Button btnAdd1 = findViewById(R.id.button);
        final Button btnnAdd2 = findViewById(R.id.button2);
        Button Truco = findViewById(R.id.TrucoBtn);
        trucoM = 1;

        btnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = findViewById(R.id.textView3);
                int teste = trucoM + placar1;
                if(teste < 12) {
                    if (placar1 < 11) {
                        placar1 = placar1 + trucoM;
                        tv.setText("" + placar1);

                    } else {
                        tv.setText("temos um vencedor");
                    }
                }else{
                    tv.setText("tomos um vencedor");
                }
                btnnAdd2.setText("+1");
                btnAdd1.setText("+1");
                trucoM =1;
            }
        });

        btnnAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = findViewById(R.id.textView2);
                int teste2 = trucoM + placar2;
                if(teste2 < 12) {
                    if (placar2 < 11) {
                        placar2 = placar2 + trucoM;
                        tv.setText("" + placar2);

                    } else {
                        tv.setText("temos um vencedor");
                        placar1 = 0;
                        placar2 = 0;
                    }
                }else{
                    tv.setText("temos um vencedor");
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
              }else{
                  btnAdd1.setText("+3");
                  btnnAdd2.setText("+3");
              }
                if(trucoM == 1){
                trucoM = trucoM + 2;
                }else{
                    if(trucoM < 11)
                    trucoM = trucoM + 3;
                }
            }
        });

    }
}

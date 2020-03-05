package com.example.truco;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int placar1;
    private int placar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd1 = findViewById(R.id.button);
        Button btnnAdd2 = findViewById(R.id.button2);

        btnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = findViewById(R.id.textView3);
                if(placar1 < 11) {
                    placar1 = placar1 + 1;
                    tv.setText("" + placar1);

                }else{
                    tv.setText("temos um vencedor");
                }


            }
        });

        btnnAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
}

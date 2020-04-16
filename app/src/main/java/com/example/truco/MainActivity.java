package com.example.truco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements ExempleDialog.ExampleDialogListener {

    private TextView name1;
    private TextView name2;

    private int placar1;
    private int placar2;
    private int trucoM;
    private int tipotime;

    public int getTipotime() {
        return tipotime;
    }

    public void setTipotime(int tipotime) {
        this.tipotime = tipotime;
    }

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
        name1 = (TextView) findViewById(R.id.tvTimeName);
        name2 = (TextView) findViewById(R.id.tvTimeName2);

        trucoM = 1;

        //abrir modal quando o texto de nome for clicado
        name1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTipotime(1);
                openDialog();
            }
        });

        //abrir modal quando o texto de nome for clicado
        name2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTipotime(2);
                openDialog();
            }
        });


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
                        win.putExtra("win1", name1.getText());
                        startActivity(win);



                    }
                }else{
                    tv1.setText(""+12);
                    win.putExtra("win1", name1.getText());
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
                        win.putExtra("win1", name2.getText());
                        startActivity(win);


                    }
                }else{
                    tv2.setText(""+12);
                    win.putExtra("win1", name2.getText());
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



    public void openDialog(){
        ExempleDialog exampleDialog = new ExempleDialog();
        exampleDialog.show(getSupportFragmentManager(),"exemple dialog");
    }


    @Override
    public void applyTexts(String name) {
        if(getTipotime() == 1) {
            name1.setText(name);
        }
        else{
            name2.setText(name);

        }
    }

    //tratamento backButton

    @Override
    public void onBackPressed() {
        
    }
}

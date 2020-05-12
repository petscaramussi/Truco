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

        final Button Truco = findViewById(R.id.TrucoBtn);
        final Intent win = new Intent(this, WinActivity.class);
        final Button btnMenos1 = findViewById(R.id.button3);
        final Button btnMenos2 = findViewById(R.id.button4);
        name1 = (TextView) findViewById(R.id.tvTimeName);
        name2 = (TextView) findViewById(R.id.tvTimeName2);
        final Button pl = findViewById(R.id.button5);
        final Button pl2 = findViewById(R.id.button6);

        trucoM = 1;

        pl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int teste2 = trucoM + placar2;
                if(teste2 < 12) {
                    if (placar2 < 11) {
                        placar2 = placar2 + trucoM;
                        pl2.setText("" + placar2);

                    } else {
                        pl2.setText(""+12);
                        win.putExtra("win1", name2.getText());
                        startActivity(win);


                    }
                }else{
                    pl2.setText(""+12);
                    win.putExtra("win1", name2.getText());
                    startActivity(win);
                }
                Truco.setText("Truco");
                trucoM = 1;
            }
        });

        pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int teste = trucoM + placar1;
                if(teste < 12) {
                    if (placar1 < 11) {
                        placar1 = placar1 + trucoM;
                        pl.setText(""+placar1);

                    } else {
                        pl.setText(""+12);
                        win.putExtra("win1", name1.getText());
                        startActivity(win);



                    }
                }else{
                    pl.setText(""+12);
                    win.putExtra("win1", name1.getText());
                    startActivity(win);


                }
                Truco.setText("Truco");
                trucoM =1;

            }
        });

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





        Truco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Truco.getText() == "Truco 9"){
                    Truco.setText("Truco 12");
                }
                else if(Truco.getText() == "Truco 6"){
                    Truco.setText("Truco 9");
                }
                else if(Truco.getText() == "Truco 3"){
                    Truco.setText("Truco 6");
                }else {
                    Truco.setText("Truco 3");
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
                    pl.setText("" + placar1);
                }
            }
        });

        btnMenos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(placar2 >= 1) {
                    placar2 = placar2 - 1;
                    pl2.setText("" + placar2);
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

package com.example.truco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        //toolbar configs
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get Intent
        tv = findViewById(R.id.tvTimeVitoria);
        String win1 = getIntent().getStringExtra("win1");
        tv.setText(win1);

    }

    //tratamento backButton

    @Override
    public void onBackPressed() {
        Intent home = new Intent(this,MainActivity.class);
        startActivity(home);

    }
}

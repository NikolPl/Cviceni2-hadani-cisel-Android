package com.example.nikol.ukol2;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @SuppressLint("StringFormatInvalid")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView vysledek = findViewById(R.id.vysledekTextView);
        vysledek.setText(getString(R.string.cisloJe, getIntent().getIntExtra(Constants.NUMBER,0)));
    }
}

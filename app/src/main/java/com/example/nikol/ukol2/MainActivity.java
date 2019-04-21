package com.example.nikol.ukol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView hlavniObrazovka;
    private int cislo;
    private EditText hodnota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hlavniObrazovka = findViewById(R.id.text);
        hlavniObrazovka.setText("zkus uhádnout číslo");

        hodnota = findViewById(R.id.vstup);
        Button tlacitkoOdesli = findViewById(R.id.tlacitko);



        tlacitkoOdesli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Integer odhad = Integer.parseInt(hodnota.getText().toString()); // převede číslo na int, bere hodnotu z edittextu, která se před parsování převede na string
                    if (cislo > odhad){
                        Toast.makeText(MainActivity.this, getString(R.string.higher),Toast.LENGTH_SHORT).show();
                    }
                    else if (cislo < odhad){
                        Toast.makeText(MainActivity.this, getString(R.string.less),Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                        intent.putExtra(Constants.NUMBER,cislo); //Constants musí být nová třída
                        startActivity(intent);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, getString(R.string.input_not_a_number),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Random rn = new Random();
        cislo = rn.nextInt(10) + 1;
        hodnota.getText().clear();
    }
}

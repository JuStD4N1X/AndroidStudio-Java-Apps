package com.example.czcionkaseekbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button btn;
    SeekBar progressBar;
    TextView sizeTxtv, helloTxtv;

    String[] helloTab = {"Dzień dobry", "Good morning", "Buenos dias"};
    int check = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        progressBar = findViewById(R.id.seekBar);
        sizeTxtv = findViewById(R.id.sizeTxt);
        helloTxtv = findViewById(R.id.helloTxt);

        btn.setOnClickListener(view -> {
            if(check==3){
                check=0;
            }
            helloTxtv.setText(helloTab[check]);
            check++;

        });

        progressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                sizeTxtv.setText("Size: " + i);
                helloTxtv.setTextSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


}
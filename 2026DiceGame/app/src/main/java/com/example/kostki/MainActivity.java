package com.example.kostki;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView dice1,dice2,dice3,dice4,dice5;
    Button btn;
    TextView result;
    boolean isAvailable1 = true;
    boolean isAvailable2 = true;
    boolean isAvailable3 = true;
    boolean isAvailable4 = true;
    boolean isAvailable5 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dice1 = findViewById(R.id.imageView1);
        dice2 = findViewById(R.id.imageView2);
        dice3 = findViewById(R.id.imageView3);
        dice4 = findViewById(R.id.imageView4);
        dice5 = findViewById(R.id.imageView5);
        btn = findViewById(R.id.button);
        result = findViewById(R.id.sumTxtV);

        dice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAvailable1){
                    dice1.setImageAlpha(127);
                    isAvailable1 = false;
                } else if (isAvailable1==false) {
                    dice1.setImageAlpha(255);
                    isAvailable1 = true;
                }
            }
        });
        dice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAvailable2){
                    dice2.setImageAlpha(127);
                    isAvailable2 = false;
                } else if (isAvailable2==false) {
                    dice2.setImageAlpha(255);
                    isAvailable2 = true;
                }
            }
        });
        dice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAvailable3){
                    dice3.setImageAlpha(127);
                    isAvailable3 = false;
                } else if (isAvailable3==false) {
                    dice3.setImageAlpha(255);
                    isAvailable3 = true;
                }
            }
        });
        dice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAvailable4){
                    dice4.setImageAlpha(127);
                    isAvailable4 = false;
                } else if (isAvailable4==false) {
                    dice4.setImageAlpha(255);
                    isAvailable4 = true;
                }
            }
        });
        dice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAvailable5){
                    dice5.setImageAlpha(127);
                    isAvailable5 = false;
                } else if (isAvailable5==false) {
                    dice5.setImageAlpha(255);
                    isAvailable5 = true;
                }
            }
        });

        btn.setOnClickListener(view -> {

            ArrayList<ImageView> availableDice = new ArrayList<>();

            if(isAvailable1) availableDice.add(dice1);
            if(isAvailable2) availableDice.add(dice2);
            if(isAvailable3) availableDice.add(dice3);
            if(isAvailable4) availableDice.add(dice4);
            if(isAvailable5) availableDice.add(dice5);

            Random random = new Random();
            int sum = 0;

            for(int i=0;i<availableDice.size();i++){
                int dieValue = random.nextInt(6)+1;
                ImageView currentDie = availableDice.get(i);
                if(dieValue==1) currentDie.setImageResource(R.drawable.die1);
                if(dieValue==2) currentDie.setImageResource(R.drawable.die2);
                if(dieValue==3) currentDie.setImageResource(R.drawable.die3);
                if(dieValue==4) currentDie.setImageResource(R.drawable.die4);
                if(dieValue==5) currentDie.setImageResource(R.drawable.die5);
                if(dieValue==6) currentDie.setImageResource(R.drawable.die6);
                sum+=dieValue;
            }
            result.setText(String.valueOf(sum));
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
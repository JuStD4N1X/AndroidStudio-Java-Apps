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

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnReset, btnThrow;
    ImageView die1,die2,die3,die4,die5;
    TextView currentRoll,overallRolls;
    int rememberScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnReset = findViewById(R.id.btnReset);
        btnThrow = findViewById(R.id.btnThrow);
        currentRoll = findViewById(R.id.currentScoreTxtv);
        overallRolls = findViewById(R.id.gameScoreTxtv);
        die1 = findViewById(R.id.imageView1);
        die2 = findViewById(R.id.imageView2);
        die3 = findViewById(R.id.imageView3);
        die4 = findViewById(R.id.imageView4);
        die5 = findViewById(R.id.imageView5);


        ImageView[] dice = {die1,die2,die3,die4,die5};
        int[] results = new int[dice.length];

        btnThrow.setOnClickListener(view -> {
            Random random = new Random();
            for(int i=0;i<dice.length;i++)
            {
                int randomValue = random.nextInt(6)+1;
                results[i] = randomValue;
                switch (randomValue){
                    case 1:
                        dice[i].setImageResource(R.drawable.k1);
                        break;
                    case 2:
                        dice[i].setImageResource(R.drawable.k2);
                        break;
                    case 3:
                        dice[i].setImageResource(R.drawable.k3);
                        break;
                    case 4:
                        dice[i].setImageResource(R.drawable.k4);
                        break;
                    case 5:
                        dice[i].setImageResource(R.drawable.k5);
                        break;
                    case 6:
                        dice[i].setImageResource(R.drawable.k6);
                        break;
                }

            }

            Arrays.sort(results);

            int counter = 1;
            int sum = 0;
            for(int i=1;i<results.length;i++){
                if(results[i]==results[i-1]){
                    counter+=1;
                }
                else {
                    if(counter>1){
                        sum+=counter*results[i-1];
                    }
                    counter = 1;
                }
            }
            if(counter>1){
                sum+=counter*results[results.length-1];
            }
            rememberScore += sum;
            currentRoll.setText("Score for this roll: " + sum);
            overallRolls.setText("Game score: " + rememberScore);


            /* python project which this project was based on
                def countPoints(self):
        self.tab.sort()
        counter = 1
        print(self.tab)
        for i in range(1, len(self.tab)): # you had it wrong, you used -1
            if self.tab[i]==self.tab[i-1]:
                counter +=1
            else:
                if counter > 1: #
                    self.sum += counter*self.tab[i-1]
                counter = 1
        if counter > 1: #
            self.sum += counter*self.tab[-1]
        print(f"Points scored: {self.sum}")
             */
        });

        btnReset.setOnClickListener(view -> {
            die1.setImageResource(R.drawable.question);
            die2.setImageResource(R.drawable.question);
            die3.setImageResource(R.drawable.question);
            die4.setImageResource(R.drawable.question);
            die5.setImageResource(R.drawable.question);
            currentRoll.setText("Score for this roll: 0");
            overallRolls.setText("Game score: 0");
            rememberScore=0;
        });
    }
}
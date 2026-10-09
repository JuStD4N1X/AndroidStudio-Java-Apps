package com.example.odkurzaczpralka;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnWash, btnVacuum;
    TextView vacuumOnOff, washNumberTxt;
    EditText washNumberInput;

    boolean isOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnWash = findViewById(R.id.btnWash);
        btnVacuum = findViewById(R.id.btnVacuum);
        vacuumOnOff = findViewById(R.id.vacuumOnOffTxtv);
        washNumberTxt = findViewById(R.id.washNumberTxtv);
        washNumberInput = findViewById(R.id.washNumberInput);

        btnWash.setOnClickListener(view -> {
            String washNumberString = washNumberInput.getText().toString().trim();

            if(washNumberString.isEmpty()){
                washNumberInput.setError("This field cannot be empty!");
                return;
            }
            try {
                int washNumber = Integer.parseInt(washNumberString);
                if(washNumber>=1 && washNumber<=12){
                    washNumberTxt.setText("Wash number: " + washNumber);
                }
            } catch (NumberFormatException e){
                washNumberInput.setError("Enter a valid number!");
            }


        });

        btnVacuum.setOnClickListener(view -> {
            if(isOn) {
                btnVacuum.setText("Turn on");
                vacuumOnOff.setText("Vacuum cleaner off");
                isOn = false;
            } else{
                btnVacuum.setText("Turn off");
                vacuumOnOff.setText("Vacuum cleaner on");
                isOn = true;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
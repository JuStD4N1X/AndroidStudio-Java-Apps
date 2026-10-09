package com.example.vet;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    SeekBar progressBar;
    TextView messageTxt, yearsTxt;
    EditText ownerData, issueData, timeData;
    ListView list;
    String clickedItem = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        progressBar = findViewById(R.id.seekBar);
        messageTxt = findViewById(R.id.messageTxtV);
        yearsTxt = findViewById(R.id.yearsTxTv);
        ownerData = findViewById(R.id.ownerDataTxtv);
        issueData = findViewById(R.id.visitReasonEditTxt);
        timeData = findViewById(R.id.editTextTime);
        list = findViewById(R.id.list);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                clickedItem = adapterView.getItemAtPosition(i).toString();
                int maxAge = 20;
                if(clickedItem.equals("Dog")){
                    maxAge = 18;
                } else if (clickedItem.equals("Cat")) {

                    maxAge = 20;
                } else if (clickedItem.equals("Guinea pig")) {
                    maxAge = 9;
                }
                progressBar.setMax(maxAge);

                if(progressBar.getProgress()>maxAge){
                    progressBar.setProgress(maxAge);
                }

                yearsTxt.setText("How old is it? " + progressBar.getProgress());
            }
        });

        progressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                yearsTxt.setText("How old is it? " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageTxt.setText(ownerData.getText().toString() + ", " + clickedItem + ", " + progressBar.getProgress() + ", " + issueData.getText().toString() + ", " + timeData.getText().toString());
            }
        });

    }
}
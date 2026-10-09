package com.example.info;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnPrev,btnNext;
    EditText etImageNumber;
    LinearLayout mainLayout;
    androidx.appcompat.widget.SwitchCompat switchColor;
    ImageView cats;
    int currentImage = 0;
    int[] images = {
      R.drawable.kot1,
      R.drawable.kot2,
      R.drawable.kot3,
      R.drawable.kot4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main);
        etImageNumber = findViewById(R.id.inputWhichPic);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        switchColor = findViewById(R.id.switch1);
        cats = findViewById(R.id.imgView);


        etImageNumber.addTextChangedListener(new TextWatcher() { // numbers from 1 to 4 change pictures
            @Override
            public void afterTextChanged(Editable editable) {
                String imageNumberInput = editable.toString();
                int ImageNumber;
                try {
                    ImageNumber = Integer.parseInt(imageNumberInput);
                } catch (NumberFormatException ex){
                    return;
                }

                if(ImageNumber >=1 && ImageNumber <= images.length){
                    currentImage = ImageNumber - 1;
                    cats.setImageResource(images[currentImage]);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
        });

        switchColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                if(b){
                    mainLayout.setBackgroundResource(R.color.blue);
                }
                else
                    mainLayout.setBackgroundResource(R.color.green);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() { // Skips to previous pic
            @Override
            public void onClick(View view) {
                currentImage = currentImage - 1;
                if(currentImage <0){
                    currentImage +=images.length;
                }
                cats.setImageResource(images[currentImage]);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() { // Skips to next pic
            @Override
            public void onClick(View view) {
                currentImage = (currentImage + 1) % images.length;
                cats.setImageResource(images[currentImage]);
            }
        });
        // #1565c0 Blue background
    }
}
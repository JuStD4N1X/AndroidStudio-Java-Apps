package com.example.domek;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnLike, btnRemove;
    TextView likes;
    private int likeCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnLike = findViewById(R.id.btnLike);
        btnRemove = findViewById(R.id.btnRemove);
        likes = findViewById(R.id.like);


        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeCount++;
                if(likeCount==1) likes.setText(likeCount + " like");
                else likes.setText(likeCount + " likes");

            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(likeCount==0){
                    Toast.makeText(MainActivity.this, "Likes can't go below 0", Toast.LENGTH_SHORT).show();
                }
                else {
                    likeCount--;
                    if(likeCount==1) likes.setText(likeCount + " like");
                    else likes.setText(likeCount + " likes");
                }
            }
        });

    }
}
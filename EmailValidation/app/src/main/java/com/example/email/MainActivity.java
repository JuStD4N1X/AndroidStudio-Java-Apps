package com.example.email;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText etEmail, etPassword, etPasswordRepeat;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.finalString);
        btn = findViewById(R.id.button);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPasswordRepeat = findViewById(R.id.etPasswordRepeat);

        Toast.makeText(this, "Author 00000000000", Toast.LENGTH_LONG).show();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String pass = etPassword.getText().toString();
                String repeatedPass = etPasswordRepeat.getText().toString();
                boolean validEmail = false;
                boolean passwordCheck = false;
                if(email.contains("@")){
                    validEmail = true;
                }
                else {
                    Toast.makeText(MainActivity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                }
                if(!repeatedPass.equals(pass)){
                    Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
                else {
                    passwordCheck = true;
                }

                if(validEmail&&passwordCheck){
                    result.setText("Welcome, " + email);
                }
            }
        });
    }
}
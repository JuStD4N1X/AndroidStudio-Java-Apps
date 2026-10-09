package com.example.todolist;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ListView list;
    EditText newItem;

    ArrayList<String> noteList;
    ArrayAdapter<String> arrayAdapter; // ADAPTER IMPORTANT

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        list = findViewById(R.id.list);
        newItem = findViewById(R.id.newItem);

        noteList = new ArrayList<>(); // IMPORTANT
        noteList.add("Shopping: bread, butter, cheese");
        noteList.add("To do: dinner, mop the floors");
        noteList.add("weekend: cinema, walk the dog");

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,noteList);  // DON'T FORGET THE MIDDLE ONE

        list.setAdapter(arrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String note = newItem.getText().toString();
                noteList.add(note);
                arrayAdapter.notifyDataSetChanged(); // IMPORTANT
            }
        });
    }
}
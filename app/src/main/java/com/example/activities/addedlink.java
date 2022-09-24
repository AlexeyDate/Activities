package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addedlink extends AppCompatActivity {

    Button save;
    EditText link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addedlink);

        save = findViewById(R.id.bsave);
        link = findViewById(R.id.name);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(addedlink.this, MainActivity.class);
                String save_link = link.getText().toString();
                intent.putExtra("hello", save_link);
                startActivity(intent);
            }
        });
    }
}
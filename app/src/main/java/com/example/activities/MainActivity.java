package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button link;
    Button start;

    String name_link = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        link = findViewById(R.id.blink);
        start = findViewById(R.id.bstart);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            name_link = data.getString("hello");
            Toast.makeText(getApplicationContext(), "Link saved successfully", Toast.LENGTH_LONG).show();
        }

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, addedlink.class);
                startActivity(intent);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name_link.length() > 0) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse(name_link));
                    browserIntent.addCategory(Intent.CATEGORY_BROWSABLE);

                    if (browserIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(browserIntent);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Please enter the link", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}






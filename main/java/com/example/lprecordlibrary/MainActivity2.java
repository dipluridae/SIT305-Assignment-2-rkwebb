package com.example.lprecordlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button addRecordButton = findViewById(R.id.addRecordButton);
        Button addOwnerButton = findViewById(R.id.addOwnerButton);
        Button searchAlbumButton = findViewById(R.id.searchAlbumButton);
        Button searchOwnerButton = findViewById(R.id.searchOwnerButton);

        // Takes user to add Record screen
        addRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addRecordIntent = new Intent(MainActivity2.this, AddRecord.class);
                startActivity(addRecordIntent);
            }
        });

        // Takes user to add Owner screen
        addOwnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addOwnerIntent = new Intent(MainActivity2.this, AddOwner.class);
                startActivity(addOwnerIntent);
            }
        });

        // Takes user to search for Album screen
        searchAlbumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(MainActivity2.this, FindRecord.class);
                startActivity(searchIntent);
            }
        });

        // Takes user to search for Owner screen
        searchOwnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(MainActivity2.this, FindOwner.class);
                startActivity(searchIntent);
            }
        });
    }
}
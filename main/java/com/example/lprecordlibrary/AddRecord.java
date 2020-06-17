package com.example.lprecordlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecord extends AppCompatActivity
{
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        final EditText albumNameEditText = findViewById(R.id.albumNameEditText);
        final EditText artistNameEditText = findViewById(R.id.artistNameEditText);
        final EditText recordLabelEditText = findViewById(R.id.recordLabelEditText);
        final EditText yearEditText = findViewById(R.id.yearEditText);
        final EditText ownerEditText = findViewById(R.id.ownerEditText);
        Button saveRecordButton = findViewById(R.id.saveRecordButton);
        db = new DatabaseHelper(this);

        saveRecordButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String albumName = albumNameEditText.getText().toString().trim();
                String artistName = artistNameEditText.getText().toString().trim();
                String recordLabel = recordLabelEditText.getText().toString().trim();
                String year = yearEditText.getText().toString().trim();
                String owner = ownerEditText.getText().toString().trim();

                // Adds new record details by calling method in DatabaseHelper
                long result = db.insert2(albumName, artistName, recordLabel, year, owner);

                // If successful indicates using Toast
                if (result > 0)
                {
                    Toast.makeText(AddRecord.this, "Album added successfully", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(AddRecord.this, "Album not added", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
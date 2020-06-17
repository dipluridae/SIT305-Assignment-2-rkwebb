package com.example.lprecordlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FindOwner extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_owner);

        final EditText searchOwnerNameEditText = findViewById(R.id.searchOwnerNameEditText);

        Button searchOwnerButton = findViewById(R.id.searchOwnerButton);

        db = new DatabaseHelper(this);

        searchOwnerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // uses method from DatabaseHelper
                boolean result = db.fetchOwner(searchOwnerNameEditText.getText().toString());
                if (result) {
                    Toast.makeText(FindOwner.this, "Owner found in Database", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(FindOwner.this, "Owner not found in Databasey", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
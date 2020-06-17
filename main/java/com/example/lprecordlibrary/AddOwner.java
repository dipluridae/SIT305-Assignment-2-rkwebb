package com.example.lprecordlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddOwner extends AppCompatActivity
{
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_owner);

        final EditText ownerNameEditText = findViewById(R.id.ownerNameEditText);
        final EditText ownerAddressEditText = findViewById(R.id.ownerAddressEditText);
        final EditText ownerSuburbEditText = findViewById(R.id.ownerSuburbEditText);
        final EditText ownerPostCodeEditText = findViewById(R.id.ownerPostCodeEditText);
        final EditText ownerStateEditText = findViewById(R.id.ownerStateEditText);
        final EditText ownerPhoneEditText = findViewById(R.id.ownerPhoneEditText);
        final EditText ownerDaysEditText = findViewById(R.id.ownerDaysEditText);
        final EditText ownerTimesEditText = findViewById(R.id.ownerTimesEditText);

        Button saveOwnerButton = findViewById(R.id.saveOwnerButton);

        db = new DatabaseHelper(this);

        saveOwnerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String ownerName = ownerNameEditText.getText().toString().trim();
                String ownerAddress = ownerAddressEditText.getText().toString().trim();
                String ownerSuburb = ownerSuburbEditText.getText().toString().trim();
                String ownerPostCode = ownerPostCodeEditText.getText().toString().trim();
                String ownerState = ownerStateEditText.getText().toString().trim();
                String ownerPhone = ownerPhoneEditText.getText().toString().trim();
                String ownerDays = ownerDaysEditText.getText().toString().trim();
                String ownerTimes = ownerTimesEditText.getText().toString().trim();

                // Adds new owner details by calling method in DatabaseHelper
                long result = db.insert3(ownerName, ownerAddress, ownerSuburb, ownerPostCode, ownerState, ownerPhone, ownerDays, ownerTimes);

                // If successful indicates using Toast
                if (result > 0)
                {
                    Toast.makeText(AddOwner.this, "Owner added successfully", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(AddOwner.this, "Owner not added", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
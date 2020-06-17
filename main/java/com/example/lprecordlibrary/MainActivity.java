package com.example.lprecordlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText nameEditText = findViewById(R.id.nameEditText);
        final EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.register1Button);
        db = new DatabaseHelper(this);

        // Check to see if user is registered and has given correct password - method called from DatabaseHelper
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean result = db.fetchUser(nameEditText.getText().toString(), passwordEditText.getText().toString());
                if (result)
                {
                   // Toast.makeText(MainActivity.this, "Successfully logged in", Toast.LENGTH_LONG).show();
                    Intent intentFirst1 = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intentFirst1);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "The user does nor exist", Toast.LENGTH_LONG).show();
                }

                }
        });

        // takes user to registration screen
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

    }
}
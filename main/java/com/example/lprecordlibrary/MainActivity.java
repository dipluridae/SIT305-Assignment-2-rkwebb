package com.example.lprecordlibrary;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText userEditText = findViewById(R.id.userEditText);
        final EditText passwordEditText = findViewById(R.id.password1EditText);
        Button loginButton = findViewById(R.id.userLoginButton);
        Button signupButton = findViewById(R.id.registerButton);
        db= new DatabaseHelper(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean result = db.fetchUser(userEditText.getText().toString(), passwordEditText.getText().toString());
                if (result == true)
                {
                    Toast.makeText(MainActivity.this, "Successfully logged in!", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(MainActivity.this, "THe user does not exist!", Toast.LENGTH_LONG).show();
                }

            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

    }
}

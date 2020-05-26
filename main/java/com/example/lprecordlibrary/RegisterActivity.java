package com.example.lprecordlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText userEditText = findViewById(R.id.userEditText);
        final EditText password1EditText = findViewById(R.id.password1EditText);
        final EditText password2EditText = findViewById(R.id.password2EditText);
        Button registerButton = findViewById(R.id.registerButton);
        db = new DatabaseHelper(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userEditText.getText().toString().trim();
                String pwd = password1EditText.getText().toString().trim();
                String confirmed_pwd = password2EditText.getText().toString().trim();
                if (pwd.equals(confirmed_pwd))
                {
                    long result = db.insert(user, pwd);
                    if (result >0)
                    {
                        Toast.makeText(RegisterActivity.this, "Registered successfully!", Toast.LENGTH_LONG).show();
                        Intent backIntent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(backIntent);
                    }
                    else
                    {Toast.makeText(RegisterActivity.this, "Registration error!", Toast.LENGTH_LONG).show();}

                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Two passwords do not match!!", Toast.LENGTH_LONG).show();
                }


            }
        });


    }












}

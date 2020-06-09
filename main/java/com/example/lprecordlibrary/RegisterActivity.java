package com.example.lprecordlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText nameRegisterEditText = findViewById(R.id.nameRegisterEditText);
        final EditText password1EditText = findViewById(R.id.password1EditText);
        final EditText password2EditText = findViewById(R.id.password2EditText);
        Button register2Button = findViewById(R.id.register2Button);
        db = new DatabaseHelper(this);

        register2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = nameRegisterEditText.getText().toString().trim();
                String pwd1 = password1EditText.getText().toString().trim();
                String pwd2 = password2EditText.getText().toString().trim();
                if (pwd1.equals(pwd2))
                {
                    long result = db.insert(user, pwd1);
                    if (result > 0)
                    {
                        Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, "The passwords do not match", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
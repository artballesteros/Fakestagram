package com.example.fakestagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegistrationActivity extends AppCompatActivity {

    public static final String TAG = "RegistrationActivity";
    private EditText etNewUsername;
    private EditText etNewPassword;
    private Button btnSignUp;
    private Button btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etNewUsername = findViewById(R.id.etNewUsername);
        etNewPassword = findViewById(R.id.etNewPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogIn = findViewById(R.id.btnLogIn);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etNewUsername.getText().toString();
                String password = etNewPassword.getText().toString();
                registerUser(username, password);
            }
        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLoginActivity();
            }
        });
    }

    private void registerUser(String username, String password) {
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Toast.makeText(RegistrationActivity.this, "Failed to Register your credentials", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Issue with signing up", e);
                    return;
                }
                Toast.makeText(RegistrationActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                goMainActivity();
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void goLoginActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

}
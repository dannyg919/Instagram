package com.example.instagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private EditText etPasswordConfirm;
    private EditText etEmail;
    private Button btnRegister;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etDescription);
        etPasswordConfirm = findViewById(R.id.etPasswordConfirm);
        etEmail = findViewById(R.id.etEmail);
        btnRegister = findViewById(R.id.btnRegister);
        tvLogin = findViewById(R.id.tvLogin);

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String passwordConfirm = etPasswordConfirm.getText().toString();
                String email = etEmail.getText().toString();

                if (password.length() < 8 ) {
                    Toast.makeText(RegisterActivity.this,"Password must be at least 8 characters!",Toast.LENGTH_SHORT).show();
                } else if (!(password.equals(passwordConfirm))) {
                    Toast.makeText(RegisterActivity.this,"Passwords must match!",Toast.LENGTH_SHORT).show();
                } else {
                    ParseUser user = new ParseUser();
                    // Set core properties
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);

                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e != null) {
                                Toast.makeText(RegisterActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                                return;
                            } else {
                                Intent i = new Intent(RegisterActivity.this,MainActivity.class);
                                startActivity(i);
                                finish();
                                Toast.makeText(RegisterActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

    }
}
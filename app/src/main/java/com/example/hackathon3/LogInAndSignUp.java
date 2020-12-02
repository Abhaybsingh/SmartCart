package com.example.hackathon3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInAndSignUp extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private Button Signup;
    private ProgressBar progressBar;

    FirebaseAuth fAuth;



    public void signUpFunc(View view) {
//        Intent intent = new Intent(LogInAndSignUp.this, SignUpForm.class);
        Intent intent = new Intent(getApplicationContext(), SignUpForm.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_log_in_and_sign_up);

        Name = (EditText) findViewById(R.id.NameInput);
        Password = (EditText) findViewById(R.id.userPassword);
        Login = (Button) findViewById(R.id.scanQrCodeBtn);
        Signup = (Button) findViewById(R.id.SignupBtn);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
    }

    public void validate(View view) {
        String email = Name.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if(TextUtils.isEmpty(email)) {
            Name.setError("Email is required");
            return;
        }

        if(TextUtils.isEmpty(password)) {
            Password.setError("Password is required");
            return;
        }

        if(password.length() < 6) {
            Password.setError("Password must be more than 6 characters");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LogInAndSignUp.this,"Logged In SuccessFully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),LocationDetails.class));
                }
                else {
                    Toast.makeText(LogInAndSignUp.this, "Error ! " + task.getException().getMessage() ,Toast.LENGTH_SHORT).show();
                }
            }
        });

//        String userName = Name.getText().toString();
//        String userPassword = Password.getText().toString();
//
//        if(userName.trim().isEmpty() ) {
//            Toast.makeText(LogInAndSignUp.this, "Enter your name", Toast.LENGTH_SHORT).show();
//        }
//        else if(userPassword.trim().isEmpty()) {
//            Toast.makeText(LogInAndSignUp.this, "Enter your password", Toast.LENGTH_SHORT).show();
//        }
//        else if ((userName.equals("Admin")) && (userPassword.equals("1234"))) {
//                    Intent intent = new Intent(LogInAndSignUp.this, LocationDetails.class);
//                    startActivity(intent);
//        }
//        else {
//            Toast.makeText(LogInAndSignUp.this, "Invalid name or password", Toast.LENGTH_SHORT).show();
//        }

    }

}
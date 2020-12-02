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

public class SignUpForm extends AppCompatActivity {

    private EditText userName, userPassword, userEmail, userPhoneNumber;
    private Button regButton;
    private Button backButton;

    //firebase authentication
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    public void registerForNew(View view)  {

        String email = userEmail.getText().toString().trim();
        String password = userPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)) {
            userEmail.setError("Email is required");
            return;
        }

        if(TextUtils.isEmpty(password)) {
            userPassword.setError("Password is required");
            return;
        }

        if(password.length() < 6) {
            userPassword.setError("Password must be more than 6 characters");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(SignUpForm.this, "New User Created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), LogInAndSignUp.class));
                }
                else {
                    Toast.makeText(SignUpForm.this, "Error ! " + task.getException().getMessage() ,Toast.LENGTH_SHORT).show();
                }
            }
        });
//        if(validate()){
//            //upload data to the database
//            Intent intent = new Intent(SignUpForm.this, LogInAndSignUp.class);
//            startActivity(intent);
//        }

    }

    public void goBack(View view) {
        Intent intent = new Intent(SignUpForm.this, LogInAndSignUp.class);
        startActivity(intent);
    }

//    private void setupUIViews(){
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_form);
//        setupUIViews();

        userName  =  (EditText) findViewById(R.id.userName);
        userPassword  =  (EditText) findViewById(R.id.userPassword);
        userEmail  =   (EditText) findViewById(R.id.userEmailId);
        userPhoneNumber = (EditText) findViewById(R.id.userPhoneNumber);
        regButton  =  (Button) findViewById(R.id.scanQrCodeBtn);
        backButton = (Button) findViewById(R.id.goToCartBtn);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar2);

        //to check if user had already logged in
        if(fAuth.getCurrentUser() == null) {
            startActivity(new Intent(getApplicationContext(), LogInAndSignUp.class));
            finish();
        }
    }

    private Boolean validate() {
        Boolean result  =  false;

        String name  =  userName.getText() .toString();
        String password  =  userPassword.getText() .toString();
        String email  =  userEmail.getText() .toString();

        if(name.isEmpty()  ||  password.isEmpty() ||  email.isEmpty() ) {
            Toast.makeText(this,  "please  enter  all  the  details", Toast.LENGTH_SHORT).show();
        }
        else if( // check if the name is unique
                true
        ){
            Toast.makeText(this,  "Choose a different username!", Toast.LENGTH_SHORT).show();
            return result;
        }
        else  {
            result  =  true;
        }
        return result;

    }
}
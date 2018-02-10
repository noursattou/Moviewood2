package com.example.tcc.moviewood;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail= findViewById(R.id.editTextEmail);
         editTextPassword= findViewById(R.id.editTextPassword);
         buttonSignIn= findViewById(R.id.buttonSignin);
         textViewSignup= findViewById(R.id.textViewSignUp);
       progressDialog =new ProgressDialog(this);

        buttonSignIn.setOnClickListener(this);
textViewSignup.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
if(firebaseAuth.getCurrentUser()!= null){
    //profile activity here
    finish();
    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));

}

     }
     private  void userLogin() {
         String email = editTextEmail.getText().toString().trim();
         String password = editTextPassword.getText().toString().trim();
         //checking if email&password are empty
         if (TextUtils.isEmpty(email)) {
             Toast.makeText(this, "please enter your eamil", Toast.LENGTH_LONG).show();
             return;
         }
         if (TextUtils.isEmpty(password)) {
             Toast.makeText(this, "please enter your password", Toast.LENGTH_LONG).show();
             return;
         }
         //if email&pass not empty ddisplaying progress dialog
         progressDialog.setMessage("Signin ..Please wait..");
         progressDialog.show();
         firebaseAuth.signInWithEmailAndPassword(email, password)
                 .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 progressDialog.dismiss();
                 if (task.isSuccessful()) {
                     //  start the profile activity here
                     finish();
                     startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                 }
             }
         });
     }

    @Override
    public  void onClick(View view){
         if(view==buttonSignIn){
             userLogin();
         }
         if(view==textViewSignup){
             finish();
             startActivity(new Intent(this,MainActivity.class));
         }
     }
}

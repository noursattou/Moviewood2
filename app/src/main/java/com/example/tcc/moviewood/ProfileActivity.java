package com.example.tcc.moviewood;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
private FirebaseAuth firebaseAuth;
private TextView textViewUserEmail;
private Button buttonLogout;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
textViewUserEmail= findViewById(R.id.textViewUserEmail);
buttonLogout= findViewById(R.id.buttonLogout);
buttonLogout.setOnClickListener(this);
firebaseAuth=FirebaseAuth.getInstance();
if(firebaseAuth.getCurrentUser()== null){
    finish();
    startActivity(new Intent(this,LoginActivity.class));
}
        FirebaseUser user=firebaseAuth.getCurrentUser();
textViewUserEmail= findViewById(R.id.textViewUserEmail);
        assert user != null;
        textViewUserEmail.setText("welcome"+user.getEmail());
buttonLogout= findViewById(R.id.buttonLogout);
buttonLogout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));

        }
    }
}

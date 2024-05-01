package com.example.taskmasterapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    public static final String FILENAME = "fn";
    FragmentManager manager;
    Fragment loginfrag,signupfrag;
    View loginView,signupView;
    TextInputEditText etEmail,etUsername,etPassword,etCPassword;
    Button btnSignup,btnCancel;
    TextView tvSignup;




    TextInputEditText etlUsername,etlPassword;
    Button btnLogin,btnlCancel;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction()
                        .show(loginfrag)
                        .hide(signupfrag)
                        .commit();
            }
        });
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction()
                        .show(signupfrag)
                        .hide(loginfrag)
                        .commit();
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=etEmail.getText().toString();
                String Username=etUsername.getText().toString().trim();
                String Passwword=etPassword.getText().toString();
                String CPasswword=etCPassword.getText().toString();
                if (Email.isEmpty() || Username.isEmpty() ||Passwword.isEmpty() || CPasswword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please provide complete information", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (Passwword.equals(CPasswword)) {
                        SharedPreferences spref=getSharedPreferences(FILENAME,MODE_PRIVATE);
                        SharedPreferences.Editor editor = spref.edit();
                        editor.putString("key_username",Username);
                        editor.putString("key_password",Passwword);
                        editor.apply();
                        manager.beginTransaction()
                                .show(loginfrag)
                                .hide(signupfrag)
                                .commit();
                        Toast.makeText(MainActivity.this, "Register Succesfull", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Passowrd and Confirm Password mismatched", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Password=etlPassword.getText().toString();
                String Username=etlUsername.getText().toString().trim();
                if(Username.isEmpty()||Password.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please fill both Text fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences spref=getSharedPreferences(FILENAME,MODE_PRIVATE);
                    String FileName= spref.getString("key_username","");
                    String FilePassword= spref.getString("key_password","");
                    if(FileName.equals(Username) && FilePassword.equals(Password))
                    {
                        SharedPreferences.Editor editor=spref.edit();
                        editor.putBoolean("isLogin",true);
                        editor.apply();
                        startActivity(new Intent(MainActivity.this, HOME.class));
                        finish();

                    }
                    else {
                        Toast.makeText(MainActivity.this, "invalid username or pass", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    private void init()
    {
        manager=getSupportFragmentManager();
        loginfrag=manager.findFragmentById(R.id.loginFrag);
        signupfrag=manager.findFragmentById(R.id.signupFrag);
        loginView=loginfrag.getView();
        signupView=signupfrag.getView();


        etEmail=signupView.findViewById(R.id.etEmail);
        etUsername=signupView.findViewById(R.id.etUsername);
        etPassword=signupView.findViewById(R.id.etPassword);
        etCPassword=signupView.findViewById(R.id.etCPassword);
        btnSignup=signupView.findViewById(R.id.btnSingup);
        btnCancel=signupView.findViewById(R.id.btnCancel);
        tvLogin=signupView.findViewById(R.id.tvLogin);
        tvSignup=loginView.findViewById(R.id.tvlSignup);

        etlUsername=loginView.findViewById(R.id.etlUsername);
        etlPassword=loginView.findViewById(R.id.etlPassword);
        btnlCancel=loginView.findViewById(R.id.btnlCancel);
        btnLogin=loginView.findViewById(R.id.btnLogin);




    }
}
package com.example.taskmasterapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HOME extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btnlogout,btnManageact;
        TextView tvtitle=findViewById(R.id.tvtitle);
        btnlogout=findViewById(R.id.btnLogout);
        btnManageact=findViewById(R.id.btnManageact);
        SharedPreferences sPref = getSharedPreferences(MainActivity.FILENAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        String FName=sPref.getString("key_username","");
        tvtitle.setText("Welcome"+FName);


        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.clear();
                editor.apply();
                startActivity(new Intent(HOME.this, MainActivity.class));
                finish();
            }

        });
        btnManageact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HOME.this, CREATEACTIVITY.class));
            }
        });



    }
}

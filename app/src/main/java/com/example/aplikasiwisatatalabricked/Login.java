package com.example.aplikasiwisatatalabricked;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.example.aplikasiwisatatalabricked.R.layout.login;

public class Login extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(login);

        Button masuk = findViewById(R.id.login1);
        masuk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login1) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}

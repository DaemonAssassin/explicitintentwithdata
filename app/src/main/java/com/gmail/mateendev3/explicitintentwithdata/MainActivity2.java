package com.gmail.mateendev3.explicitintentwithdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tvUsername, tvPassword;
    Button btnGoTo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvUsername = findViewById(R.id.tv_username);
        tvPassword = findViewById(R.id.tv_password);
        btnGoTo1 = findViewById(R.id.btn_go_to_1);

        String fistName = getIntent().getExtras().getString("FNAME");
        String lastName = getIntent().getExtras().getString("LNAME");

        tvUsername.setText(fistName);
        tvPassword.setText(lastName);

        btnGoTo1.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setData(Uri.parse(fistName + " " + lastName));
            setResult(RESULT_OK, intent);
            finish();
        });


    }
}
package com.gmail.mateendev3.explicitintentwithdata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String USER_NAME_TEXT = "com.gmail.mateendev3.explicitintentwithdata.username.text";
    public static final String PASSWORD_NUMBER = "com.gmail.mateendev3.explicitintentwithdata.password.number";
    public static final int REQUEST_CODE = 0;

    Button btnGoTo2;
    EditText etUsername, etPassword;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoTo2 = findViewById(R.id.btn_go_to_2);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        tvResult = findViewById(R.id.tv_result);

        btnGoTo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstName = etUsername.getText().toString();
                String lastName = etPassword.getText().toString();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("FNAME", firstName);
                intent.putExtra("LNAME", lastName);

                startActivityForResult(intent, REQUEST_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {

            if (data.getData() != null) {
                tvResult.setText("FName: " + data.getData());
            }
        }
    }
}
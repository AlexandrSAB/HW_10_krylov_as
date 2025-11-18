package com.example.hw_10_krylov_as;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements Constants{

    private EditText txtName;
    private EditText txtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();
    }

    private void initView() {
        txtName = findViewById(R.id.textName);
        txtAge = findViewById(R.id.textAge);
        Button btnCongratulations = findViewById(R.id.btnCongratulations);

        btnCongratulations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent runCongratulations = new Intent(MainActivity.this, CongratulationsActivity.class);
                runCongratulations.putExtra(YOUR_NAME, (" " + txtName.getText().toString()));
                runCongratulations.putExtra(YOUR_AGE, (" " + txtAge.getText().toString())+ " ");
                startActivity(runCongratulations);
            }
        });
    }
}


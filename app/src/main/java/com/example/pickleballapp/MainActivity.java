package com.example.pickleballapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button reset;
    Button outputTable;
    EditText playerInput;
    EditText courtInput;
    EditText gameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_robin_chart_generator);

        reset = (Button) findViewById(R.id.clear);
        playerInput = (EditText) findViewById(R.id.playerInput);
        courtInput = (EditText) findViewById(R.id.courtInput);
        gameInput = (EditText) findViewById(R.id.gameInput);
        outputTable = (Button) findViewById(R.id.createRRChart);
    }
}
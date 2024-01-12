package com.example.pickleballapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button clear;
    Button createRRChart;
    EditText playerInput;
    EditText courtInput;
    EditText gameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_robin_chart_generator);

        clear = (Button) findViewById(R.id.clear);
        playerInput = (EditText) findViewById(R.id.playerInput);
        courtInput = (EditText) findViewById(R.id.courtInput);
        gameInput = (EditText) findViewById(R.id.gameInput);
        createRRChart = (Button) findViewById(R.id.createRRChart);

        playerInput.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(!hasFocus) {
                    checkPlayerInput();
                }
            }

            private void checkPlayerInput() {
                String strNumOfPlayers = playerInput.getText().toString();
                if(!strNumOfPlayers.isEmpty()){
                    try {
                        int intNumOfPlayers = Integer.parseInt(strNumOfPlayers);
                        if (intNumOfPlayers < 8 || intNumOfPlayers > 40){
                            playerInput.setText("");
                            showToast("Please input a number between 8 and 40.");
                        }
                    }catch (NumberFormatException e){
                        playerInput.setText("");
                        showToast("Please input a number.");
                    }
                }
            }

            private void showToast(String notice) {
                Toast.makeText(getApplicationContext(), notice, Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerInput.setText("");
                courtInput.setText("");
                gameInput.setText("");
            }
        });

        createRRChart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent output = new Intent(MainActivity.this, TablePage.class);
                startActivity(output);
            }
        });
    }
}
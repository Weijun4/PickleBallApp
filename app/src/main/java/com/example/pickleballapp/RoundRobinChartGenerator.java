package com.example.pickleballapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RoundRobinChartGenerator extends AppCompatActivity {
    Button clear;
    Button createRRChart;
    EditText gameInput;
    EditText courtInput;
    EditText playerInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_robin_chart_generator_land);

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

        courtInput.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(!hasFocus) {
                    checkCourtInput();
                }
            }

            private void checkCourtInput() {
                String strNumOfCourts = courtInput.getText().toString();
                if(!strNumOfCourts.isEmpty()){
                    try {
                        int intNumOfCourts = Integer.parseInt(strNumOfCourts);
                        if (intNumOfCourts <= 0){
                            courtInput.setText("");
                            showToast("Please input a number greater than 0.");
                        }
                    }catch (NumberFormatException e){
                        courtInput.setText("");
                        showToast("Please input a number.");
                    }
                }
            }

            private void showToast(String notice) {
                Toast.makeText(getApplicationContext(), notice, Toast.LENGTH_SHORT).show();
            }
        });

        gameInput.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(!hasFocus) {
                    checkGameInput();
                }
            }

            private void checkGameInput() {
                String strNumOfGames = gameInput.getText().toString();
                if(!strNumOfGames.isEmpty()){
                    try {
                        int intNumOfGames = Integer.parseInt(strNumOfGames);
                        if (intNumOfGames <= 0){
                            gameInput.setText("");
                            showToast("Please input a number greater than 0.");
                        }
                    }catch (NumberFormatException e){
                        gameInput.setText("");
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
                gameInput.setText("");
                courtInput.setText("");
                gameInput.setText("");
            }
        });

        createRRChart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent output = new Intent(RoundRobinChartGenerator.this, CreatedChartPage.class);
                startActivity(output);
            }
        });
    }
}
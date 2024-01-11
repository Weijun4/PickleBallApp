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
        setContentView(R.layout.sign_up_page);

        reset = (Button) findViewById(R.id.reset);
        playerInput = (EditText) findViewById(R.id.playerInput);
        courtInput = (EditText) findViewById(R.id.courtInput);
        gameInput = (EditText) findViewById(R.id.gameInput);
        outputTable = (Button) findViewById(R.id.outputTable);

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

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerInput.setText("");
                courtInput.setText("");
                gameInput.setText("");
            }
        });

        outputTable.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent output = new Intent(MainActivity.this, TablePage.class);
                startActivity(output);
            }
        });
    }
}
package com.example.darrell.easterquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.darrell.easterquiz.R.id.Q1;
import static com.example.darrell.easterquiz.R.id.Q2;
import static com.example.darrell.easterquiz.R.id.Q3;
import static com.example.darrell.easterquiz.R.id.Q5;
import static com.example.darrell.easterquiz.R.id.checkQ3Cright;
import static com.example.darrell.easterquiz.R.id.checkQ6Aright;
import static com.example.darrell.easterquiz.R.id.checkQ6Bright;
import static com.example.darrell.easterquiz.R.id.checkQ6Cright;
import static com.example.darrell.easterquiz.R.id.checkQ6Dright;
import static com.example.darrell.easterquiz.R.id.numberinput;
import static com.example.darrell.easterquiz.R.id.radioQ5Cright;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Check for correct answer in Question 4, check how many right answers are entered and increment score for each

    public void CountAnswers(View view) {
        EditText myEditText = findViewById(numberinput);
        String myEditTextValue = myEditText.getText().toString();
        if (myEditTextValue.matches("120")) {
            score = score + 1;
        }

        int[] radios = new int[]{R.id.radioQ1Aright, R.id.radioQ2Bright, R.id.radioQ5Cright};
        RadioButton[] arrayButton = new RadioButton[radios.length];
        int[] checks = new int[]{R.id.checkQ3Aright, R.id.checkQ3Cright, checkQ6Aright, checkQ6Bright, checkQ6Cright, checkQ6Dright};
        CheckBox[] arrayChecks = new CheckBox[checks.length];

        for (int i = 0; i < arrayButton.length; i++) {
            arrayButton[i] = findViewById(radios[i]);
        }

        for (int i = 0; i < arrayChecks.length; i++) {
            arrayChecks[i] = findViewById(checks[i]);
        }

        for (RadioButton button : arrayButton) {
            if (button.isChecked()) {
                score += 1;
            }
        }

        for (CheckBox box : arrayChecks) {
            if (box.isChecked()) {
                score += 1;
            }
        }

        // Pop up a message with score out of 10

        Toast.makeText(this, "You scored " + String.valueOf(score) + " out of 10!", Toast.LENGTH_LONG).show();

        // Restart app after SUNMIT button is clicked

        Intent intent = getIntent();
        finish();
        startActivity(intent);


    }


}

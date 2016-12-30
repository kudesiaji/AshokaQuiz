package com.example.android.ashokaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void calculateScore(){
        calculateScoreQ1();
        calculateScoreQ2();
        calculateScoreQ3();
        calculateScoreQ4();
        calculateScoreQ5();
    }

    private void calculateScoreQ1(){
        EditText textField = (EditText)findViewById(R.id.A1);
        String userAnswer = textField.getText().toString();
        if (userAnswer.equalsIgnoreCase(getString(R.string.Answer1)))
            score++;
    }

    private void calculateScoreQ2(){
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.A2);
        int selectedButtonID = radioGroup.getCheckedRadioButtonId();

        int answerID = R.id.A2b;

        if (answerID == selectedButtonID)
            score++;
    }

    private void calculateScoreQ3(){
        CheckBox cb1 = (CheckBox)findViewById(R.id.A3a);
        CheckBox cb2 = (CheckBox)findViewById(R.id.A3b);
        CheckBox cb3 = (CheckBox)findViewById(R.id.A3c);

        boolean cb1State = cb1.isChecked();
        boolean cb2State = cb2.isChecked();
        boolean cb3State = cb3.isChecked();

        if (cb1State == true && cb2State == false && cb3State == true)
            score++;
    }

    private void calculateScoreQ4(){
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.A4);
        int selectedButtonID = radioGroup.getCheckedRadioButtonId();
        if (selectedButtonID != -1)
            score++;
    }

    private void calculateScoreQ5(){
        EditText textField = (EditText)findViewById(R.id.A5);
        String userAnswer = textField.getText().toString();
        if (userAnswer.equals(getString(R.string.Answer5)))
            score++;
    }

    private void reset(){
        resetQ1();
        resetQ2();
        resetQ3();
        resetQ4();
        resetQ5();
    }

    private void resetQ1(){
        EditText textField = (EditText)findViewById(R.id.A1);
        textField.setText("");
    }

    private void resetQ2(){
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.A2);
        radioGroup.clearCheck();
    }

    private void resetQ3(){
        CheckBox cb1 = (CheckBox)findViewById(R.id.A3a);
        CheckBox cb2 = (CheckBox)findViewById(R.id.A3b);
        CheckBox cb3 = (CheckBox)findViewById(R.id.A3c);

        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
    }

    private void resetQ4(){
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.A4);
        radioGroup.clearCheck();
    }

    private void resetQ5(){
        EditText textField = (EditText)findViewById(R.id.A5);
        textField.setText("");
    }

    public void displayScore(View view) {
        calculateScore();
        Toast toast = Toast.makeText(getApplicationContext(), ("Your score is : " + Integer.toString(score)), Toast.LENGTH_SHORT);
        toast.show();
        score = 0;
        reset();
    }
}

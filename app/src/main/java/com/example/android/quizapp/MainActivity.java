package com.example.android.quizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quizapp.R.id.q1;
import static com.example.android.quizapp.R.id.q2AnswerA;
import static com.example.android.quizapp.R.id.q2AnswerB;
import static com.example.android.quizapp.R.id.q5;
import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {

    private RadioButton q1Answer;
    private CheckBox q2AnswerA;
    private CheckBox q2AnswerB;
    private RadioButton q3Answer;
    private CheckBox q4AnswerA;
    private CheckBox q4AnswerB;
    private EditText nameInfo;
    private TextView q5CorrectAns;
    private EditText q5Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize all necessary views
        q1Answer = (RadioButton) findViewById(R.id.q1AnswerA);
        q2AnswerA = (CheckBox) findViewById(R.id.q2AnswerA);
        q2AnswerB = (CheckBox) findViewById(R.id.q2AnswerD);
        q3Answer = (RadioButton) findViewById(R.id.q3AnswerB);
        q4AnswerA = (CheckBox) findViewById(R.id.q4AnswerB);
        q4AnswerB = (CheckBox) findViewById(R.id.q4AnswerC);
        nameInfo = (EditText) findViewById(R.id.name);
        q5CorrectAns = (TextView) findViewById(R.id.q5CorrectAnswer);
        q5Answer = (EditText) findViewById(R.id.q5Answer);
    }

    //Function that grades the user and displays toast message
    public void SubmitGrade(View view) {
        //Set final grade for user
        int finalGrade = GradeLogic();


        //Check if name has been entered
        if (nameInfo.getText().toString().trim().equals("")) {
            Toast errorToast = Toast.makeText(getApplicationContext(), "Please Enter Name", Toast.LENGTH_SHORT);
            errorToast.show();
        } else {
            //Create Toast with grade info to be displayed
            Toast submitGrade = Toast.makeText(getApplicationContext(),
                    nameInfo.getText() + " Your grade is " + finalGrade + "/5", Toast.LENGTH_LONG);

            //Show Toast
            submitGrade.show();

            //Hightlight All Answers
            q1Answer.setBackgroundColor(Color.GREEN);
            q2AnswerA.setBackgroundColor(Color.GREEN);
            q2AnswerB.setBackgroundColor(Color.GREEN);
            q3Answer.setBackgroundColor(Color.GREEN);
            q4AnswerA.setBackgroundColor(Color.GREEN);
            q4AnswerB.setBackgroundColor(Color.GREEN);

            q5CorrectAns.setVisibility(View.VISIBLE);
            q5CorrectAns.setBackgroundColor(Color.GREEN);
        }

    }

    //Calculate grade
    private int GradeLogic() {
        int grade = 0;

        //If an answer is correct increment grade counter
        if (q1Answer.isChecked()) {
            grade++;
        }

        if (q2AnswerA.isChecked() && q2AnswerB.isChecked()) {
            grade++;
        }

        if (q3Answer.isChecked()) {
            grade++;
        }

        if (q4AnswerA.isChecked() && q4AnswerB.isChecked()) {
            grade++;
        }

        if (q5Answer.getText().toString().trim().equals("19")) {
            grade++;
        }

        return grade;
    }

    public void Reset(View view) {

        //Reset All Highlighted Answers
        q1Answer.setBackgroundColor(NULL);
        q2AnswerA.setBackgroundColor(NULL);
        q2AnswerB.setBackgroundColor(NULL);
        q3Answer.setBackgroundColor(NULL);
        q4AnswerA.setBackgroundColor(NULL);
        q4AnswerB.setBackgroundColor(NULL);

        q5CorrectAns.setVisibility(View.GONE);
        q5CorrectAns.setBackgroundColor(NULL);


        //Reset Name
        nameInfo.setText("");
    }
}

package com.example.quizeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] question = {"Java is a person?", "Java was introduce in 1233?", "Java was created using Python?",
    "Java has abstract classes?", "Java supports interface?", "Java was created by Shubham Dabhi"}; //Creating an array for question

    private boolean[] answers = {false, false, false, true, true, false}; //Creating boolean for answers
    private int score = 0;
    private int index = 0;

    Button yes;
    Button no;
    TextView questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        questions = findViewById(R.id.questions);
        questions.setText(question[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If your array is not going out of bound
                if (index <= question.length - 1){
                    //If you have given correct answer
                    if (answers[index] == true){
                        score ++;
                    }
                    //Go to the next question
                    index ++;
                    if (index <= question.length - 1){
                        questions.setText(question[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + question.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the quiz again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If the array is not going out of bounds
                if (index <= question.length - 1){
                    //If you have given correct answer
                    if (answers[index] == false){
                        score ++;
                    }
                    //Go to the next question
                    index ++;
                    if (index <= question.length - 1){
                        questions.setText(question[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + question.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the quiz again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
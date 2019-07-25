package com.example.guesswho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    TextView t2;
    public static int x=0;
    @ Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        if(QuestionActivity.score>x)
            x=QuestionActivity.score;
        Toast.makeText(this,Integer.toString(QuestionActivity.score), Toast.LENGTH_SHORT).show();
        t2=findViewById(R.id.txtView2);
        t2.setText("Your Score - "+Integer.toString(QuestionActivity.score));
    }


    public void restart(View view) {
        QuestionActivity.count=0;
        QuestionActivity.score=0;
        QuestionActivity.guess=5;
        startActivity(new Intent(ResultActivity.this,MainActivity.class));
    }

    public void dead(View view) {
        finishAffinity();
        QuestionActivity.count=0;
        QuestionActivity.score=0;
        QuestionActivity.guess=5;
    }
}

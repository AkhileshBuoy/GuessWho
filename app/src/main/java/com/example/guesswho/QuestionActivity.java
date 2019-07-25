package com.example.guesswho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.IntegerRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class QuestionActivity extends AppCompatActivity {
    public static int score = 0,guess=5;
    private int flag = 0;
    public static int count=0;
    ImageView img;
    Button b1,b2,b3,b4;
    String[] choice = {"animal", "flower"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);
        img=findViewById(R.id.q_img);
        b1=findViewById(R.id.btn_opt1);
        b2=findViewById(R.id.btn_opt2);
        b3=findViewById(R.id.btn_opt3);
        b4=findViewById(R.id.btn_opt4);

        flag = getIntent().getIntExtra("living",0);
        if(flag==1){
            String path = choice[flag-1]+"_"+Animal.ani[count].toLowerCase();
            img.setImageResource(getResources().getIdentifier(path,"drawable",this.getPackageName()));
            b1.setText(new Animal().arr[count][0]);
            b2.setText(new Animal().arr[count][1]);
            b3.setText(new Animal().arr[count][2]);
            b4.setText(new Animal().arr[count][3]);
            count++;
        }

        else if(flag==2){
            String path = choice[flag-1]+"_"+Flower.flow[count].toLowerCase();
            img.setImageResource(getResources().getIdentifier(path,"drawable",this.getPackageName()));
            b1.setText(new Flower().flower[count][0]);
            b2.setText(new Flower().flower[count][1]);
            b3.setText(new Flower().flower[count][2]);
            b4.setText(new Flower().flower[count][3]);
            count++;
        }
    }

    public void refresh(View view) {
        if(guess==1)
            startActivity(new Intent(QuestionActivity.this,ResultActivity.class));
        switch (view.getId()){
            case R.id.btn_opt1:
                if(flag==2 && b1.getText().toString().equalsIgnoreCase(Flower.flow[count-1]))
                    score++;
                    else if(flag==1 && b1.getText().toString().equalsIgnoreCase(Animal.ani[count-1]))
                        score++;
                    else
                        guess--;
                break;
            case R.id.btn_opt2:
                if(flag==2 && b2.getText().toString().equalsIgnoreCase(Flower.flow[count-1]))score++;
                else if(flag==1 && b2.getText().toString().equalsIgnoreCase(Animal.ani[count-1]))score++;
                else
                    guess--;
                break;
            case R.id.btn_opt3:
                if(flag==2 && b3.getText().toString().equalsIgnoreCase(Flower.flow[count-1]))score++;
                else if(flag==1 && b3.getText().toString().equalsIgnoreCase(Animal.ani[count-1]))score++;
                else
                    guess--;
                break;
            case R.id.btn_opt4:
                if(flag==2 && b4.getText().toString().equalsIgnoreCase(Flower.flow[count-1]))score++;
                else if(flag==1 && b4.getText().toString().equalsIgnoreCase(Animal.ani[count-1]))score++;
                else
                    guess--;
                break;
        }

        if(count==25){
            startActivity(new Intent(this, ResultActivity.class));
        }
        if (count <= 24) {
            if (flag == 1) {
                String path = choice[flag - 1] + "_" + Animal.ani[count].toLowerCase();
                img.setImageResource(getResources().getIdentifier(path, "drawable", this.getPackageName()));
                b1.setText(new Animal().arr[count][0]);
                b2.setText(new Animal().arr[count][1]);
                b3.setText(new Animal().arr[count][2]);
                b4.setText(new Animal().arr[count][3]);
                count++;
            }
            else if (flag == 2) {
                String path = choice[flag - 1] + "_" + Flower.flow[count].toLowerCase();
                img.setImageResource(getResources().getIdentifier(path, "drawable", this.getPackageName()));
                b1.setText(new Flower().flower[count][0]);
                b2.setText(new Flower().flower[count][1]);
                b3.setText(new Flower().flower[count][2]);
                b4.setText(new Flower().flower[count][3]);
                count++;
            }
        }
    }
}

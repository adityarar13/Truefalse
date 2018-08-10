package com.example.rizkyadityar.truefalse;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class ResultActivity extends AppCompatActivity {

    TextView mGrade, mFinalScore;
    Button mRetryButton;
    KonfettiView viewKonfetti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mGrade = (TextView)findViewById(R.id.grade);
        mFinalScore = (TextView)findViewById(R.id.outOf);
        mRetryButton = (Button)findViewById(R.id.retry);
        viewKonfetti = (KonfettiView)findViewById(R.id.viewKonfetti);

        //viewKonfetti = findViewById(R.id.viewKonfetti);
        viewKonfetti.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1.5f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(5000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12, 5f))
                .setPosition(-100f, viewKonfetti.getWidth() + 800f, -100f, -100f)
                .stream(100, 5000L);



        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        mFinalScore.setText(score + " / " + QuizDatabase.questions.length);

        if (score == 15){
            mGrade.setText("Perfect");
        }else if (score == 14){
            mGrade.setText("Awesome");
        }else if (score == 13){
            mGrade.setText("Awesome");
        }else if (score == 12){
            mGrade.setText("Good job");
        }else if (score == 11){
            mGrade.setText("Good job");
        }else if (score == 10){
            mGrade.setText("Good");
        }else if (score == 9){
            mGrade.setText("Good");
        }else if (score == 8){
            mGrade.setText("BELAJAR LAGI");
        }else if (score == 7){
            mGrade.setText("YAELAH CUMA 7");
        }else if (score == 6){
            mGrade.setText("CUKUP!");
        }else if (score == 5){
            mGrade.setText("OH MY GOD!");
        }else {
            mGrade.setText("KAMU TOLOL!");
        }

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this, QuizActivity.class));
                ResultActivity.this.finish();
            }
        });

       /* private void konfetti(); {
            viewKonfetti = findViewById(R.id.viewKonfetti);
            viewKonfetti.build()
                    .addColors(Color.RED, Color.GREEN, Color.MAGENTA)
                    .setDirection(0.0, 359.0)
                    .setSpeed(1.5f, 5f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(5000L)
                    .addShapes(Shape.RECT, Shape.CIRCLE)
                    .addSizes(new Size(12, 5f))
                    .setPosition(-100f, viewKonfetti.getWidth() + 800f, -100f, -100f)
                    .stream(100, 5000L);
        }*/
    }


}





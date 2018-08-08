package com.example.rizkyadityar.truefalse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private TextView mScoreView, mQuestion;
    private ImageView mImageView;
    private Button mTrueButton, mFalseButton;

    private boolean mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = (TextView) findViewById(R.id.points);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mQuestion = (TextView) findViewById(R.id.question);
        mTrueButton = (Button) findViewById(R.id.trueButton);
        mFalseButton = (Button) findViewById(R.id.falseButton);

        updateQuestion();

        //logika untuk true button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mAnswer == true) {
                    mScore++; //buat update score int variable
                    updateScore(mScore);//mengubah score int variable ke string dan menambahkan mscoreview

                    //perform this cek before update question
                    if (mQuestionNumber == QuizDatabase.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    //jika jawaban pengguna salah
                    if (mQuestionNumber == QuizDatabase.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });
        //logika untuk false button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mAnswer == false){
                    mScore++; //buat update score int variable
                    updateScore(mScore);//mengubah score int variable ke string dan menambahkan mscoreview

                    //perform this cek before update question
                    if (mQuestionNumber == QuizDatabase.questions.length){
                        Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }
                else {
                    //jika jawaban pengguna salah
                    if (mQuestionNumber == QuizDatabase.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });
    }

    private void updateQuestion(){
        mImageView.setImageResource(QuizDatabase.images[mQuestionNumber]);
        mQuestion.setText(QuizDatabase.questions[mQuestionNumber]);
        mAnswer = QuizDatabase.answers[mQuestionNumber];
        mQuestionNumber++;
    }

    public void updateScore(int points ){
        mScoreView.setText("" + mScore);
    }
}

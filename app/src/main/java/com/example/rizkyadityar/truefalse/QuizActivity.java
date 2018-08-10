package com.example.rizkyadityar.truefalse;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sackcentury.shinebuttonlib.ShineButton;

public class QuizActivity extends AppCompatActivity {

    private TextView mQuestion;
    private ImageView mImageView;
    private ShineButton mTrueButton, mFalseButton;

    private boolean mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //mScoreView = (TextView) findViewById(R.id.points);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mQuestion = (TextView) findViewById(R.id.question);
        mTrueButton = (ShineButton) findViewById(R.id.benar);
        mFalseButton = (ShineButton) findViewById(R.id.salah);

        updateQuestion();

        //logika untuk true button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFalseButton.setChecked(false);
                mTrueButton.setChecked(false);
                if (mAnswer == true) {
                    mScore++; //buat update score int variable
                    //updateScore(mScore);//mengubah score int variable ke string dan menambahkan mscoreview

                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();

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
                } else {
                    mTrueButton.setAnimDuration(1);
                    mFalseButton.setAnimDuration(1);

                    Toast.makeText(QuizActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
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
                mFalseButton.setChecked(false);
                mTrueButton.setChecked(false);
                if (mAnswer == false) {
                    mScore++; //buat update score int variable
                    //updateScore(mScore);//mengubah score int variable ke string dan menambahkan mscoreview

                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
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
                } else {
                    mTrueButton.setAnimDuration(1);
                    mFalseButton.setAnimDuration(1);

                    Toast.makeText(QuizActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
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

    private void updateQuestion() {
        mImageView.setImageResource(QuizDatabase.images[mQuestionNumber]);
        mQuestion.setText(QuizDatabase.questions[mQuestionNumber]);
        mAnswer = QuizDatabase.answers[mQuestionNumber];
        mQuestionNumber++;

    }

    /*public void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }*/

    public void clickExit(View view) {
        askToClose();
    }


    @Override
    public void onBackPressed() {
        askToClose();
    }

    private void askToClose() {
        AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
        builder.setMessage("Apakah kamu mau keluar ?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}

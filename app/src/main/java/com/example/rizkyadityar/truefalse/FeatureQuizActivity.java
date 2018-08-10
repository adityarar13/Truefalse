package com.example.rizkyadityar.truefalse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sackcentury.shinebuttonlib.ShineButton;

public class FeatureQuizActivity extends AppCompatActivity {

    private TextView mPertanyaan;
    private ShineButton mTruButton, mFalsButton;
    //private Button mLanjut;

    private boolean mAnswer;
    //private int mScore = 0;
    private int mQuestionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_quiz);

        mPertanyaan = (TextView) findViewById(R.id.question);
        mTruButton = (ShineButton) findViewById(R.id.benar);
        mFalsButton = (ShineButton) findViewById(R.id.salah);
        //mLanjut = (Button)findViewById(R.id.lanjut);
    }

}

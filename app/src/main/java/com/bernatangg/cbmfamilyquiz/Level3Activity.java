package com.bernatangg.cbmfamilyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Level3Activity extends AppCompatActivity {

    TextView tvJwb1, tvJwb2, tvJwb3, tvJwb4, tvJwb5, tvAsk, tvSkor, tvLive;
    EditText etAnswer;
    Button btnSubmit;
    ImageView ivRight, ivWrong;

    String jwb1, jwb2, jwb3, jwb4, jwb5, ans1, ans2, ans3, ans4, ans5;
    Integer skor, mstk;

    LinearLayout layoutJwb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);

        tvJwb1 = findViewById(R.id.jwb_1);
        tvJwb2 = findViewById(R.id.jwb_2);
        tvJwb3 = findViewById(R.id.jwb_3);
        tvJwb4 = findViewById(R.id.jwb_4);
        tvJwb5 = findViewById(R.id.jwb_5);
        tvAsk = findViewById(R.id.tv_ask);
        tvSkor = findViewById(R.id.tv_skor);
        tvLive = findViewById(R.id.tv_live);

        ivRight = findViewById(R.id.iv_right);
        ivWrong = findViewById(R.id.iv_wrong);

        etAnswer = findViewById(R.id.et_answer);

        btnSubmit = findViewById(R.id.btn_submit);

        layoutJwb = findViewById(R.id.layout_answer);

        tvAsk.setText("Buah favorit orang Indonesia?");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check();
            }
        });

        jwb1 = "MANGGA";
        jwb2 = "DURIAN";
        jwb3 = "PISANG";
        jwb4 = "JERUK";
        jwb5 = "MANGGIS";

        ans1 = "mangga";
        ans2 = "durian";
        ans3 = "pisang";
        ans4 = "jeruk";
        ans5 = "manggis";

        mstk = 0;

    }

    private void check() {
        String answer = etAnswer.getText().toString();
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.right);

        String firstScore = tvSkor.getText().toString();
        skor = Integer.parseInt(firstScore);

        if (jwb1.equals(answer) || ans1.equals(answer)) {
            tvJwb1.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb1.setText(jwb1);
            etAnswer.setText(null);

            Integer skors = skor + 40;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);

            showRight();
            mediaPlayer.start();
        } else if (jwb2.equals(answer) || ans2.equals(answer)) {
            tvJwb2.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb2.setText(jwb2);
            etAnswer.setText(null);

            Integer skors = skor + 29;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);

            showRight();
            mediaPlayer.start();
        } else if (jwb3.equals(answer) || ans3.equals(answer)) {
            tvJwb3.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb3.setText(jwb3);
            etAnswer.setText(null);

            Integer skors = skor + 15;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);

            showRight();
            mediaPlayer.start();
        } else if (jwb4.equals(answer) || ans4.equals(answer)) {
            tvJwb4.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb4.setText(jwb4);
            etAnswer.setText(null);

            Integer skors = skor + 10;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);

            showRight();
            mediaPlayer.start();
        } else if (jwb5.equals(answer) || ans5.equals(answer)) {
            tvJwb5.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb5.setText(jwb5);
            etAnswer.setText(null);
            Integer skors = skor + 6;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);

            showRight();
            mediaPlayer.start();
        } else {
            MediaPlayer wrongAns = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
            wrongAns.start();
            etAnswer.setText(null);

            if (mstk == 0) {
                tvLive.setText("X");
                mstk = 1;
            } else if (mstk == 1) {
                tvLive.setText("XX");
                mstk = 2;
            } else if (mstk == 2) {
                tvLive.setText("XXX");
                mstk = 0;
                showMistake();
            }

            Integer skors = skor;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);
            showWrong();
        }
    }

    private void showMistake() {
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                tvLive.setText("");
            }
        }.start();
    }

    private void showRight() {
        new CountDownTimer(2000, 1000) {

            public void onTick(long millisUntilFinished) {
                layoutJwb.setVisibility(View.GONE);
                ivRight.setVisibility(View.VISIBLE);
            }

            public void onFinish() {
                layoutJwb.setVisibility(View.VISIBLE);
                ivRight.setVisibility(View.GONE);
            }
        }.start();
    }

    private void showWrong() {
        new CountDownTimer(2000, 1000) {

            public void onTick(long millisUntilFinished) {
                layoutJwb.setVisibility(View.GONE);
                ivWrong.setVisibility(View.VISIBLE);
            }

            public void onFinish() {
                layoutJwb.setVisibility(View.VISIBLE);
                ivWrong.setVisibility(View.GONE);
            }
        }.start();
    }
}
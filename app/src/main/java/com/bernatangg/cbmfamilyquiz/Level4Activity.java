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
import android.widget.TextView;

public class Level4Activity extends AppCompatActivity {

    TextView tvJwb1, tvJwb2, tvJwb3, tvJwb4, tvJwb5, tvAsk, tvSkor, tvLive;
    EditText etAnswer;
    Button btnSubmit;
    ImageView ivRight, ivWrong;

    String jwb1, jwb2, jwb3, jwb4, jwb5, ans1, ans2, ans3, ans4, ans5;
    Integer skor, live;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);

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

        tvAsk.setText("Hal apa yang paling disukai di kantor?");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check();
            }
        });

        jwb1 = "MAKAN BERSAMA";
        jwb2 = "NGOBROL BERSAMA";
        jwb3 = "OLAHRAGA";
        jwb4 = "SPIRIT MORNING";
        jwb5 = "MAIN GAME ONLINE";

        ans1 = "makan bersama";
        ans2 = "ngobrol bersama";
        ans3 = "olahraga";
        ans4 = "spirit morning";
        ans5 = "main game online";

        ImageButton btnHome = findViewById(R.id.btn_back);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
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

            Integer skors = skor + 44;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);

            showRight();
            mediaPlayer.start();
        } else if (jwb2.equals(answer) || ans2.equals(answer)) {
            tvJwb2.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb2.setText(jwb2);
            etAnswer.setText(null);

            Integer skors = skor + 28;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);

            showRight();
            mediaPlayer.start();
        } else if (jwb3.equals(answer) || ans3.equals(answer)) {
            tvJwb3.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb3.setText(jwb3);
            etAnswer.setText(null);

            Integer skors = skor + 22;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);

            showRight();
            mediaPlayer.start();
        } else if (jwb4.equals(answer) || ans4.equals(answer)) {
            tvJwb4.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb4.setText(jwb4);
            etAnswer.setText(null);

            Integer skors = skor + 4;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);

            showRight();
            mediaPlayer.start();
        } else if (jwb5.equals(answer) || ans5.equals(answer)) {
            tvJwb5.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb5.setText(jwb5);

            Integer skors = skor + 2;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);

            showRight();
            mediaPlayer.start();
        } else {
            MediaPlayer wrongAns = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
            wrongAns.start();
            etAnswer.setText(null);

            String mistake = tvLive.getText().toString();
            StringBuilder sb = new StringBuilder(mistake);
            sb.deleteCharAt(0);
            String result = sb.toString();
            tvLive.setText(result);

            Integer skors = skor;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);
            showWrong();
        }
    }

    private void showRight() {
        new CountDownTimer(2000, 1000) {

            public void onTick(long millisUntilFinished) {
                ivRight.setVisibility(View.VISIBLE);
            }

            public void onFinish() {
                ivRight.setVisibility(View.GONE);
            }
        }.start();
    }

    private void showWrong() {
        new CountDownTimer(2000, 1000) {

            public void onTick(long millisUntilFinished) {
                ivWrong.setVisibility(View.VISIBLE);
            }

            public void onFinish() {
                ivWrong.setVisibility(View.GONE);
            }
        }.start();
    }
}
package com.bernatangg.cbmfamilyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Level1Activity extends AppCompatActivity {

    TextView tvJwb1, tvJwb2, tvJwb3, tvJwb4, tvAsk, tvSkor, tvLive;
    EditText etAnswer;
    Button btnSubmit;
    ImageView ivRight, ivWrong;

    String jwb1, jwb2, jwb3, jwb4;
    Integer skor, live;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_level);

        tvJwb1 = findViewById(R.id.jwb_1);
        tvJwb2 = findViewById(R.id.jwb_2);
        tvJwb3 = findViewById(R.id.jwb_3);
        tvJwb4 = findViewById(R.id.jwb_4);
        tvAsk = findViewById(R.id.tv_ask);
        tvSkor = findViewById(R.id.tv_skor);
        tvLive = findViewById(R.id.tv_live);

        ivRight = findViewById(R.id.iv_right);
        ivWrong = findViewById(R.id.iv_wrong);

        etAnswer = findViewById(R.id.et_answer);

        btnSubmit = findViewById(R.id.btn_submit);

        tvAsk.setText("Sebutkan cabang CBM");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check();
            }
        });

        jwb1 = "JAKARTA";
        jwb2 = "BANDUNG";
        jwb3 = "SURABAYA";
        jwb4 = "SEMARANG";

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

        String nyawa = tvLive.getText().toString();
        live = Integer.parseInt(nyawa);


        if (jwb1.equals(answer)) {
            tvJwb1.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb1.setText(jwb1);
            etAnswer.setText(null);

            Integer skors = skor + 60;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);

            Integer hidup = live - 1;
            String live = String.valueOf(hidup);
            tvLive.setText(live);

            showRight();
            mediaPlayer.start();
        } else if (jwb2.equals(answer)) {
            tvJwb2.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb2.setText(jwb2);
            etAnswer.setText(null);

            Integer skors = skor + 20;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);

            Integer hidup = live - 1;
            String live = String.valueOf(hidup);
            tvLive.setText(live);

            showRight();
            mediaPlayer.start();
        } else if (jwb3.equals(answer)) {
            tvJwb3.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb3.setText(jwb3);
            etAnswer.setText(null);

            Integer skors = skor + 15;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);

            Integer hidup = live - 1;
            String live = String.valueOf(hidup);
            tvLive.setText(live);

            showRight();
            mediaPlayer.start();
        } else if (jwb4.equals(answer)) {
            tvJwb4.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb4.setText(jwb4);
            etAnswer.setText(null);
            Integer skors = skor + 15;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);
            showRight();
            mediaPlayer.start();
        } else {
            MediaPlayer wrongAns = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
            wrongAns.start();
            etAnswer.setText(null);

            Integer skors = skor;

            Integer hidup = live - 1;
            String live = String.valueOf(hidup);
            tvLive.setText(live);

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
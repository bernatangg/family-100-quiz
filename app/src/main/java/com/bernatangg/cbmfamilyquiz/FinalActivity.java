package com.bernatangg.cbmfamilyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    TextView tvJwb1, tvJwb2, tvJwb3, tvJwb4, tvJwb5, tvAsk, tvSkor, tvLive;
    EditText etAnswer;
    Button btnSubmit, btnKunci;
    ImageView ivRight, ivWrong;

    String jwb1, jwb2, jwb3, jwb4, jwb5, ans1, ans2, ans3, ans4, ans5;
    Integer skor, mstk, rebutan;

    LinearLayout layoutJwb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

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
        btnKunci = findViewById(R.id.btn_kunci);

        layoutJwb = findViewById(R.id.layout_answer);

        tvAsk.setText("Apa reaksi orang jika dipeluk artis idolanya?");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check();
            }
        });
        btnKunci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showKey();
            }
        });

        jwb1 = "MENJERIT";
        jwb2 = "PELUK BALIK";
        jwb3 = "KAGET";
        jwb4 = "MENANGIS";
        jwb5 = "PINGSAN";

        ans1 = "menjerit";
        ans2 = "peluk balik";
        ans3 = "kaget";
        ans4 = "menangis";
        ans5 = "pingsan";

        mstk = 0;
        rebutan = 1;
    }

    private void showKey() {
        tvJwb1.setBackgroundColor(Color.parseColor("#51C273"));
        tvJwb1.setText(jwb1);
        tvJwb2.setBackgroundColor(Color.parseColor("#51C273"));
        tvJwb2.setText(jwb2);
        tvJwb3.setBackgroundColor(Color.parseColor("#51C273"));
        tvJwb3.setText(jwb3);
        tvJwb4.setBackgroundColor(Color.parseColor("#51C273"));
        tvJwb4.setText(jwb4);
        tvJwb5.setBackgroundColor(Color.parseColor("#51C273"));
        tvJwb5.setText(jwb5);

    }

    private void check() {
        String answer = etAnswer.getText().toString();
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.right);

        String firstScore = tvSkor.getText().toString();
        skor = Integer.parseInt(firstScore);

        if (jwb1.toLowerCase().contains(answer.toLowerCase())) {
            tvJwb1.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb1.setText(jwb1);
            etAnswer.setText(null);

            Integer skors = skor + 49;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);
            rebutan = 0;

            showRight();
            mediaPlayer.start();
        } else if (jwb2.toLowerCase().contains(answer.toLowerCase())) {
            tvJwb2.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb2.setText(jwb2);
            etAnswer.setText(null);

            Integer skors = skor + 31;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);
            rebutan = 0;

            showRight();
            mediaPlayer.start();
        } else if (jwb3.toLowerCase().contains(answer.toLowerCase())) {
            tvJwb3.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb3.setText(jwb3);
            etAnswer.setText(null);

            Integer skors = skor + 11;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);
            rebutan = 0;

            showRight();
            mediaPlayer.start();
        } else if (jwb4.toLowerCase().contains(answer.toLowerCase())) {
            tvJwb4.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb4.setText(jwb4);
            etAnswer.setText(null);

            Integer skors = skor + 6;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);
            rebutan = 0;

            showRight();
            mediaPlayer.start();
        } else if (jwb5.toLowerCase().contains(answer.toLowerCase())) {
            tvJwb5.setBackgroundColor(Color.parseColor("#51C273"));
            tvJwb5.setText(jwb5);
            etAnswer.setText(null);
            Integer skors = skor + 3;
            String skor = String.valueOf(skors);
            tvSkor.setText(skor);
            rebutan = 0;

            showRight();
            mediaPlayer.start();
        } else {
            MediaPlayer wrongAns = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
            wrongAns.start();
            etAnswer.setText(null);

            if (rebutan == 1) {
                rebutan = 0;
                if (mstk == 0) {
                    tvLive.setText("");
                    mstk = 1;
                } else if (mstk == 1) {
                    tvLive.setText("X");
                    mstk = 2;
                } else if (mstk == 2) {
                    tvLive.setText("XX");
                    mstk = 3;
                } else if (mstk == 3) {
                    tvLive.setText("XXX");
                    mstk = 0;
                    showMistake();
                }
            } else if (rebutan == 0) {
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

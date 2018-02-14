package com.example.kazim.teampup;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by kazim on 15-Feb-18.
 */

public class TossActivity extends AppCompatActivity{

    GifImageView toss;

    Button flip;

    TextView result;

    Random r;

    List<String> chance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);


        chance = new ArrayList<String>();
        chance.add(0,"Shapla");
        chance.add(1,"Man");

        r = new Random();

        toss = findViewById(R.id.toss);

        flip =findViewById(R.id.btn_flip);

        result = findViewById(R.id.result);

        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toss.setVisibility(View.VISIBLE);

                new CountDownTimer(2000, 1000) { // 5000 = 5 sec


                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {

                        toss.setVisibility(View.GONE);

                        int x = r.nextInt(2);

                        if(x == 1){

                            result.setText("Man");
                        }
                        else{
                            result.setText("Shapla");
                        }
                    }
                }.start();
            }
        });
    }
}

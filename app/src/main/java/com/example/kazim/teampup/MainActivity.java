package com.example.kazim.teampup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText expert, medium, beginner;
    String strExpert,strMedium,strBeginner;
    Button teamUp,toss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expert = findViewById(R.id.expert);

        medium = findViewById(R.id.medium);

        beginner = findViewById(R.id.beginner);

        teamUp = findViewById(R.id.button);

        toss = findViewById(R.id.btn_toss);

        teamUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                strExpert = expert.getText().toString();
                strMedium = medium.getText().toString();
                strBeginner = beginner.getText().toString();


                Intent team = new Intent(MainActivity.this,TeamUp.class);
                team.putExtra("expert",strExpert);
                team.putExtra("medium",strMedium);
                team.putExtra("beginner",strBeginner);
                startActivity(team);


            }
        });



        toss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toss = new Intent(MainActivity.this,TossActivity.class);
                startActivity(toss);
            }
        });


    }



}

package com.example.kazim.teampup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by kazim on 03-Feb-18.
 */

public class TeamUp extends AppCompatActivity {

    TextView teamA,teamB;



    List<String> expertList, mediumList, beginnerList,teamAList,teamBList;

    String str_expert,str_medium,str_beginner,str_teamA,str_teamB;

    Integer gNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team);

        Intent intent = getIntent();

        str_expert = intent.getExtras().getString("expert");
        str_medium =intent.getExtras().getString("medium");
        str_beginner= intent.getExtras().getString("beginner");



        expertList = Arrays.asList(str_expert.split(","));

        mediumList = Arrays.asList(str_medium.split(","));

        beginnerList = Arrays.asList(str_beginner.split(","));

        Collections.shuffle(expertList);

        Collections.shuffle(mediumList);

        Collections.shuffle(beginnerList);

        teamAList = new ArrayList<String>();
        teamBList = new ArrayList<String>();

        for(int i = 0 ; i< expertList.size(); i++){

            if(gNumber % 2 == 0)
                teamAList.add(expertList.get(i));
            else
                teamBList.add(expertList.get(i));
            gNumber++;
        }

        for(int i = 0; i< mediumList.size(); i++){

            if(gNumber % 2 == 0)
                teamAList.add(mediumList.get(i));
            else
                teamBList.add(mediumList.get(i));

            gNumber++;
        }

        for(int i = 0 ; i< beginnerList.size(); i++){

            if(gNumber % 2 == 0)
                teamAList.add(beginnerList.get(i));
            else
                teamBList.add(beginnerList.get(i));

            gNumber++;
        }



        str_teamA = TextUtils.join("\n",teamAList);
        str_teamB = TextUtils.join("\n",teamBList);


        teamA =findViewById(R.id.t_teamA);
        teamB = findViewById(R.id.t_teamB);

        teamA.setText(str_teamA);
        teamB.setText(str_teamB);


    }
}

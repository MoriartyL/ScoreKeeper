package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int teamAscore = 0;
    int teamBscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.end_of_game);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (teamAscore > teamBscore) {
                    Toast.makeText(MainActivity.this, "Team A wins!", Toast.LENGTH_SHORT).show();
                } else if (teamAscore < teamBscore) {
                    Toast.makeText(MainActivity.this, "Team B wins!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Draw!", Toast.LENGTH_SHORT).show();
                }
                teamAscore = 0;
                teamBscore = 0;
                displayAscore(teamAscore);
                displayBscore(teamAscore);
            }
        });
    }

    public void teamAtouchDown(View view) {
        teamAscore += 6;
        displayAscore(teamAscore);
    }

    public void teamAfiledGoal(View view) {
        teamAscore += 3;
        displayAscore(teamAscore);
    }

    public void teamAsafety(View view) {
        teamAscore += 2;
        displayAscore(teamAscore);
    }

    public void teamBtouchDown(View view) {
        teamBscore += 6;
        displayBscore(teamBscore);
    }

    public void teamBfiledGoal(View view) {
        teamBscore += 3;
        displayBscore(teamBscore);
    }

    public void teamBsafety(View view) {
        teamBscore += 2;
        displayBscore(teamBscore);
    }


    public void displayAscore(int score) {
        TextView textView = (TextView) findViewById(R.id.team_a_score);
        textView.setText(String.valueOf(score));
    }

    public void displayBscore(int score) {
        TextView textView = (TextView) findViewById(R.id.team_b_score);
        textView.setText(String.valueOf(score));
    }


    public void reset(View view) {
        teamAscore = 0;
        teamBscore = 0;
        displayAscore(teamAscore);
        displayBscore(teamBscore);
    }

}

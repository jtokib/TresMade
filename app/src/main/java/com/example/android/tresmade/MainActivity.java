package com.example.android.tresmade;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
    }

    private int teamOneMade = 0;
    private int teamOneTotalShot = 0;
    private int teamTwoMade = 0;
    private int teamTwoTotalShot = 0;

    /**
     * Displays Three Point Shots Made for Team One.
     */
    private void displayTeamOneMade(int teamOneMake) {
        TextView scoreView = findViewById(R.id.teamOneMade);
        scoreView.setText(String.valueOf(teamOneMake));
    }
    /**
     * Displays Three Point Shooting Percentage for Team One.
     * @param teamOneMade three pointers made
     * @param teamOneTotalShot total shots attempted (misses plus makes)
     */
    private void displayTeamOnePercentage(int teamOneMade, int teamOneTotalShot) {
        TextView scoreView = findViewById(R.id.teamOnePercentage);
        String teamOneShooting = String.valueOf(teamOneMade) + "/" + String.valueOf(teamOneTotalShot);
        //Make sure inputs are greater than 0 because you can't divide by 0. Help calculating percentages in Java provided by https://stackoverflow.com/questions/7855387/percentage-of-two-int
        int teamOneShootingAvg = teamOneMade > 0 && teamOneTotalShot > 0 ? (teamOneMade * 100 )/teamOneTotalShot : 0;
        scoreView.setText(String.format("%s %s%%", teamOneShooting, String.valueOf(teamOneShootingAvg)));
    }
    /**
     * Team One Three Point Make
     */
    public void teamOneMake(View view) {
        teamOneMade += 1;
        teamOneTotalShot += 1;
        displayTeamOneMade(teamOneMade);
        displayTeamOnePercentage(teamOneMade, teamOneTotalShot);
    }
    /**
     * Team One Three Point Miss
     */
    public void teamOneMiss(View view) {
        teamOneTotalShot += 1;
        displayTeamOnePercentage(teamOneMade, teamOneTotalShot);
    }
    /**
     * Team One - Undo a Three Point Make (because sometimes the referees will review shots after the play)
     */
    public void teamOneUndoMake(View view) {
        if (teamOneMade <= 0) {
            Toast.makeText(this, "You can't have less than 0 shots made", Toast.LENGTH_LONG).show();
        } else {
            teamOneMade -= 1;
            teamOneTotalShot -= 1;
            displayTeamOneMade(teamOneMade);
            displayTeamOnePercentage(teamOneMade, teamOneTotalShot);
        }
    }
    /**
     * Team One - Undo a Three Point Miss (because sometimes the referees will review shots after the play)
     */
    public void teamOneUndoMiss(View view) {
        if (teamOneTotalShot <= 0) {
            Toast.makeText(this, "You can't have less than 0 shots attempted", Toast.LENGTH_LONG).show();
        } else if (teamOneMade >= teamOneTotalShot) {
            Toast.makeText(this, "You can't have more shots made than attempted", Toast.LENGTH_LONG).show();
        } else {
            teamOneTotalShot -= 1;
            displayTeamOnePercentage(teamOneMade, teamOneTotalShot);
        }
    }

    /**
     * Displays Three Point Shots Made for Team Two.
     */
    private void displayTeamTwoMade(int teamTwoMake) {
        TextView scoreView = findViewById(R.id.teamTwoMade);
        scoreView.setText(String.valueOf(teamTwoMake));
    }
    /**
     * Displays Three Point Shooting Percentage for Team One.
     * @param teamTwoMade three pointers made
     * @param teamTwoTotalShot total shots attempted (misses plus makes)
     */
    private void displayTeamTwoPercentage(int teamTwoMade, int teamTwoTotalShot) {
        TextView scoreView = findViewById(R.id.teamTwoPercentage);
        String teamTwoShooting = String.valueOf(teamTwoMade) + "/" + String.valueOf(teamTwoTotalShot);
        //Make sure inputs are greater than 0 because you can't divide by 0. Help calculating percentages in Java provided by https://stackoverflow.com/questions/7855387/percentage-of-two-int
        int teamTwoShootingAvg = teamTwoMade > 0 && teamTwoTotalShot > 0 ? (teamTwoMade * 100)/teamTwoTotalShot : 0;
        scoreView.setText(MessageFormat.format("{0} {1}%", teamTwoShooting, String.valueOf(teamTwoShootingAvg)));
    }
    /**
     * Team One Three Point Make
     */
    public void teamTwoMake(View view) {
        teamTwoMade += 1;
        teamTwoTotalShot += 1;
        displayTeamTwoMade(teamTwoMade);
        displayTeamTwoPercentage(teamTwoMade, teamTwoTotalShot);
    }
    /**
     * Team One Three Point Miss
     */
    public void teamTwoMiss(View view) {
        teamTwoTotalShot += 1;
        displayTeamTwoPercentage(teamTwoMade, teamTwoTotalShot);
    }
    /**
     * Team One - Undo a Three Point Make (because sometimes the referees will review shots after the play)
     */
    public void teamTwoUndoMake(View view) {
        if (teamTwoMade <= 0) {
            Toast.makeText(this, "You can't have less than 0 shots made", Toast.LENGTH_LONG).show();
        } else {
            teamTwoMade -= 1;
            teamTwoTotalShot -= 1;
            displayTeamTwoMade(teamTwoMade);
            displayTeamTwoPercentage(teamTwoMade, teamTwoTotalShot);
        }
    }
    /**
     * Team One - Undo a Three Point Miss (because sometimes the referees will review shots after the play)
     */
    public void teamTwoUndoMiss(View view) {
        if (teamTwoTotalShot <= 0) {
            Toast.makeText(this, "You can't have less than 0 shots attempted", Toast.LENGTH_LONG).show();
        } else if (teamTwoMade >= teamTwoTotalShot) {
            Toast.makeText(this, "You can't have more shots made than attempted", Toast.LENGTH_LONG).show();
        } else {
            teamTwoTotalShot -= 1;
            displayTeamTwoPercentage(teamTwoMade, teamTwoTotalShot);
        }
    }

    /**
     * Reset it everything
     */
    public void reset(View view) {
        teamOneMade = 0;
        teamOneTotalShot = 0;
        teamTwoMade = 0;
        teamTwoTotalShot = 0;

        displayTeamOneMade(0);
        displayTeamOnePercentage(0,0);
        displayTeamTwoMade(0);
        displayTeamTwoPercentage(0,0);
    }
}

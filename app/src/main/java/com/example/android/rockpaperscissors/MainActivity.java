package com.example.android.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String player1Weapon;
    String player2Weapon;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;
    static final String ROCK = "Rock";
    static final String PAPER = "Paper";
    static final String SCISSORS = "Scissors";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button_1);
        btn2 = (Button) findViewById(R.id.button_2);
        btn3 = (Button) findViewById(R.id.button_3);
        btn4 = (Button) findViewById(R.id.button_4);
        btn5 = (Button) findViewById(R.id.button_5);
        btn6 = (Button) findViewById(R.id.button_6);
        player1Weapon = getString(R.string.fight);
        player2Weapon = getString(R.string.fight);
    }

    public void displayPlayer1Weapon(String WeaponPlayer1) {
        TextView ScoreTeamAView = (TextView) findViewById(R.id.player1_weapon);
        ScoreTeamAView.setText(String.valueOf(WeaponPlayer1));
    }

    public void displayPlayer2Weapon(String WeaponPlayer2) {
        TextView ScoreTeamAView = (TextView) findViewById(R.id.player2_weapon);
        ScoreTeamAView.setText(String.valueOf(WeaponPlayer2));
    }

    public void deactivateAllButtonsForPlayer1() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
    }

    public void deactivateAllButtonsForPlayer2() {
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
    }

    public void activateAllButtons(View view) {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        resetWeapons();
        displayPlayer1Weapon(player1Weapon);
        displayPlayer2Weapon(player2Weapon);
    }

    public void resetWeapons() {
        player1Weapon = "Fight!";
        player2Weapon = "Fight!";
    }

    public void resetScores() {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
    }

    public void reset(View view) {
        activateAllButtons(null);
        resetScores();
        displayPlayer1Score(scorePlayer1);
        displayPlayer2Score(scorePlayer2);
    }

    public void takeRockPlayer1 (View view) {
        player1Weapon = getString(R.string.rock);
        deactivateAllButtonsForPlayer1();
    }

    public void takePaperPlayer1 (View view) {
        player1Weapon = getString(R.string.paper);
        deactivateAllButtonsForPlayer1();
    }

    public void takeScissorsPlayer1 (View view) {
        player1Weapon = getString(R.string.scissors);
        deactivateAllButtonsForPlayer1();
    }

    public void takeRockPlayer2 (View view) {
        player2Weapon = getString(R.string.rock);
        deactivateAllButtonsForPlayer2();
    }

    public void takePaperPlayer2 (View view) {
        player2Weapon = getString(R.string.paper);
        deactivateAllButtonsForPlayer2();
    }

    public void takeScissorsPlayer2 (View view) {
        player2Weapon = getString(R.string.scissors);
        deactivateAllButtonsForPlayer2();
    }

    public void displayPlayer1Score(int player1Score) {
        TextView ScoreTeamAView = (TextView) findViewById(R.id.player1_score);
        ScoreTeamAView.setText(String.valueOf(player1Score));
    }

    public void displayPlayer2Score(int player2Score) {
        TextView ScoreTeamAView = (TextView) findViewById(R.id.player2_score);
        ScoreTeamAView.setText(String.valueOf(player2Score));
    }

    public void addScore(View view) {
        if ((! player1Weapon.equals(player2Weapon))
                && ((! player1Weapon.equals("Fight!")) && (! player2Weapon.equals("Fight!")) )) {
            if ((player1Weapon.equals(ROCK) && player2Weapon.equals(SCISSORS))
                    || (player1Weapon.equals(PAPER) && player2Weapon.equals(ROCK))
                    || (player1Weapon.equals(SCISSORS) && player2Weapon.equals(PAPER))) {
                scorePlayer1 = scorePlayer1 + 1;
                displayPlayer1Score(scorePlayer1);
            } else {
                scorePlayer2 = scorePlayer2 + 1;
                displayPlayer2Score(scorePlayer2);
            }
        }
        displayPlayer1Weapon(player1Weapon);
        displayPlayer2Weapon(player2Weapon);
        resetWeapons();

    }
}

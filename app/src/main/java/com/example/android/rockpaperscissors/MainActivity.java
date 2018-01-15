package com.example.android.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String player1Attack;
    String player2Attack;
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
    static final String PLAYER1_SCORE = "player1Score";
    static final String PLAYER2_SCORE = "player2Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        player1Attack = getString(R.string.fight);
        player2Attack = getString(R.string.fight);
        scorePlayer1 = Integer.parseInt(getString(R.string.player_1_score));
        scorePlayer2 = Integer.parseInt(getString(R.string.player_2_score));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current score state for both players
        savedInstanceState.putInt(PLAYER1_SCORE, scorePlayer1);
        savedInstanceState.putInt(PLAYER2_SCORE, scorePlayer2);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);


        // Restore score states from saved instance and display them
        scorePlayer1 = savedInstanceState.getInt(PLAYER1_SCORE);
        scorePlayer2 = savedInstanceState.getInt(PLAYER2_SCORE);
        displayPlayer1Score(scorePlayer1);
        displayPlayer2Score(scorePlayer2);
    }

    public void displayPlayer1Attack(String WeaponPlayer1) {
        TextView ScoreTeamAView = findViewById(R.id.player1_weapon);
        ScoreTeamAView.setText(String.valueOf(WeaponPlayer1));
    }

    public void displayPlayer2Attack(String WeaponPlayer2) {
        TextView ScoreTeamAView = findViewById(R.id.player2_weapon);
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
        displayPlayer1Attack(player1Attack);
        displayPlayer2Attack(player2Attack);
    }

    public void resetWeapons() {
        player1Attack = "Fight!";
        player2Attack = "Fight!";
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
        player1Attack = getString(R.string.rock);
        deactivateAllButtonsForPlayer1();
    }

    public void takePaperPlayer1 (View view) {
        player1Attack = getString(R.string.paper);
        deactivateAllButtonsForPlayer1();
    }

    public void takeScissorsPlayer1 (View view) {
        player1Attack = getString(R.string.scissors);
        deactivateAllButtonsForPlayer1();
    }

    public void takeRockPlayer2 (View view) {
        player2Attack = getString(R.string.rock);
        deactivateAllButtonsForPlayer2();
    }

    public void takePaperPlayer2 (View view) {
        player2Attack = getString(R.string.paper);
        deactivateAllButtonsForPlayer2();
    }

    public void takeScissorsPlayer2 (View view) {
        player2Attack = getString(R.string.scissors);
        deactivateAllButtonsForPlayer2();
    }

    public void displayPlayer1Score(int player1Score) {
        TextView ScoreTeamAView = findViewById(R.id.player1_score);
        ScoreTeamAView.setText(String.valueOf(player1Score));
    }

    public void displayPlayer2Score(int player2Score) {
        TextView ScoreTeamAView = findViewById(R.id.player2_score);
        ScoreTeamAView.setText(String.valueOf(player2Score));
    }

    public void addScore(View view) {
        if ((! player1Attack.equals(player2Attack))
                && ((! player1Attack.equals("Fight!")) && (! player2Attack.equals("Fight!")) )) {
            if ((player1Attack.equals(ROCK) && player2Attack.equals(SCISSORS))
                    || (player1Attack.equals(PAPER) && player2Attack.equals(ROCK))
                    || (player1Attack.equals(SCISSORS) && player2Attack.equals(PAPER))) {
                scorePlayer1 = scorePlayer1 + 1;
                displayPlayer1Score(scorePlayer1);
            } else {
                scorePlayer2 = scorePlayer2 + 1;
                displayPlayer2Score(scorePlayer2);
            }
        }
        displayPlayer1Attack(player1Attack);
        displayPlayer2Attack(player2Attack);
        resetWeapons();

    }
}

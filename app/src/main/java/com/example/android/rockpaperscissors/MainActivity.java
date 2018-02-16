package com.example.android.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    static final String ROCK = "Rock";
    static final String PAPER = "Paper";
    static final String SCISSORS = "Scissors";
    static final String PLAYER1_SCORE = "player1Score";
    static final String PLAYER2_SCORE = "player2Score";
    static final String PLAYER1_ATTACK = "player1Attack";
    static final String PLAYER2_ATTACK = "player2Attack";
    static final String RESULT_BTN_STATE = "resultBtnState";
    static final String PLAYER1_BTNS_STATE = "player1BtnsState";
    static final String PLAYER2_BTNS_STATE = "player2BtnsState";
    String player1Attack, player2Attack;
    Button btn1, btn2, btn3, btn4, btn5, btn6, resultBtn;
    int scorePlayer1, scorePlayer2;
    Hashtable<String, Integer> attackValues = new Hashtable<>();

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
        resultBtn = findViewById(R.id.result_button);
        player1Attack = getString(R.string.fight);
        player2Attack = getString(R.string.fight);
        scorePlayer1 = Integer.parseInt(getString(R.string.player_1_score));
        scorePlayer2 = Integer.parseInt(getString(R.string.player_2_score));
        attackValues.put(SCISSORS, 3);
        attackValues.put(ROCK, 2);
        attackValues.put(PAPER, 1);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(PLAYER1_SCORE, scorePlayer1);
        savedInstanceState.putInt(PLAYER2_SCORE, scorePlayer2);
        savedInstanceState.putBoolean(PLAYER1_BTNS_STATE, btn1.isEnabled());
        savedInstanceState.putBoolean(PLAYER2_BTNS_STATE, btn4.isEnabled());
        savedInstanceState.putBoolean(RESULT_BTN_STATE, resultBtn.isEnabled());
        savedInstanceState.putString(PLAYER1_ATTACK, player1Attack);
        savedInstanceState.putString(PLAYER2_ATTACK, player2Attack);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore score, attack and button states from saved instance and display them
        scorePlayer1 = savedInstanceState.getInt(PLAYER1_SCORE);
        scorePlayer2 = savedInstanceState.getInt(PLAYER2_SCORE);
        player1Attack = savedInstanceState.getString(PLAYER1_ATTACK);
        player2Attack = savedInstanceState.getString(PLAYER2_ATTACK);
        displayPlayersScores(scorePlayer1, scorePlayer2);
        displayPlayersAttacks(player1Attack, player2Attack);
        setButtonsStateForPlayer1(savedInstanceState.getBoolean(PLAYER1_BTNS_STATE));
        setButtonsStateForPlayer2(savedInstanceState.getBoolean(PLAYER2_BTNS_STATE));
        resultBtn.setEnabled(savedInstanceState.getBoolean(RESULT_BTN_STATE));
    }

    public void displayPlayersAttacks(String WeaponPlayer1, String WeaponPlayer2) {
        TextView ScorePLayer1View = findViewById(R.id.player1_weapon);
        TextView ScorePlayer2View = findViewById(R.id.player2_weapon);
        ScorePLayer1View.setText(String.valueOf(WeaponPlayer1));
        ScorePlayer2View.setText(String.valueOf(WeaponPlayer2));
    }

    public void setButtonsStateForPlayer1(boolean state) {
        btn1.setEnabled(state);
        btn2.setEnabled(state);
        btn3.setEnabled(state);
    }

    public void setButtonsStateForPlayer2(boolean state) {
        btn4.setEnabled(state);
        btn5.setEnabled(state);
        btn6.setEnabled(state);
    }

    public void activateAllButtons(View view) {
        setButtonsStateForPlayer1(true);
        setButtonsStateForPlayer2(true);
        resultBtn.setEnabled(true);
        resetWeapons();
        displayPlayersAttacks(player1Attack, player2Attack);
    }

    public void resetWeapons() {
        player1Attack = getString(R.string.fight);
        player2Attack = getString(R.string.fight);
    }

    public void resetScores() {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
    }

    public void reset(View view) {
        activateAllButtons(null);
        resetScores();
        displayPlayersScores(scorePlayer1, scorePlayer2);
    }

    public void setPlayer1Attack(View view) {
        Button btn = (Button) view;
        player1Attack = btn.getText().toString();
        setButtonsStateForPlayer1(false);
    }

    public void setPlayer2Attack(View view) {
        Button btn = (Button) view;
        player2Attack = btn.getText().toString();
        setButtonsStateForPlayer2(false);
    }

    public void displayPlayersScores(int player1Score, int player2Score) {
        TextView ScorePlayer1View = findViewById(R.id.player1_score);
        TextView ScorePlayer2View = findViewById(R.id.player2_score);
        ScorePlayer1View.setText(String.valueOf(player1Score));
        ScorePlayer2View.setText(String.valueOf(player2Score));
    }

    public void addScore(View view) {
        if ((!player1Attack.equals(player2Attack))
                && ((!player1Attack.equals("Fight!")) && (!player2Attack.equals("Fight!")))) {
            if ((player1Attack.equals(ROCK) && player2Attack.equals(SCISSORS))
                    || (player1Attack.equals(PAPER) && player2Attack.equals(ROCK))
                    || (player1Attack.equals(SCISSORS) && player2Attack.equals(PAPER))) {
                scorePlayer1 += attackValues.get(player1Attack);
                scorePlayer2 -= attackValues.get(player2Attack);
                displayPlayersScores(scorePlayer1, scorePlayer2);
            } else {
                scorePlayer1 -= attackValues.get(player1Attack);
                scorePlayer2 += attackValues.get(player2Attack);
                displayPlayersScores(scorePlayer1, scorePlayer2);
            }
        }
        displayPlayersAttacks(player1Attack, player2Attack);
        resultBtn.setEnabled(false);
    }
}

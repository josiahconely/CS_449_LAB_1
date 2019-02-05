package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;





public class MainActivity extends AppCompatActivity {

    private Button strike_main_button;
    private Button ball_main_button;
    private TextView strike_main_display;
    private TextView ball_main_display;

    int strike_int = 0;
    int ball_int = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    strike_main_button =  (Button) findViewById(R.id.ball_button);
    ball_main_button = (Button) findViewById(R.id.ball_button);
    strike_main_display = (TextView) findViewById(R.id.strike_display);
    ball_main_display = (TextView) findViewById(R.id.ball_display);
    }


    public void updateBallDisplay(String toThis) {
        TextView textView = (TextView) findViewById(R.id.ball_display);
        textView.setText(toThis);
    }
    public void updateStrikeDisplay(String toThis) {
        TextView textView = (TextView) findViewById(R.id.strike_display);
        textView.setText(toThis);
    }

    public void push_ball (android.view.View v){
        if (ball_int< 3){
            ball_int++;
        }
        else if (ball_int >=3) {
            ball_int = 0;
            strike_int = 0;
        }
        ball_main_display.setText(String.valueOf(ball_int));
        strike_main_display.setText(String.valueOf(strike_int));
    }
    public void push_strike (android.view.View v){
        if (strike_int< 2){
            strike_int++;
        }
        else if (strike_int >=2) {
            ball_int = 0;
            strike_int = 0;
        }

        ball_main_display.setText(String.valueOf(ball_int));
        strike_main_display.setText(String.valueOf(strike_int));
    }


}

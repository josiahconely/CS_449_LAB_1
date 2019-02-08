package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static int strike_int = 0;
    static int ball_int = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void push_ball(View v){

        ball_int++;
        if (ball_int > 3) {
            ball_int = 0;
            strike_int = 0;
        }
        final TextView ballCount_display = (TextView) findViewById(R.id.ball_display);
        ballCount_display.setText(Integer.toString(ball_int));
        final TextView strikeCount_display = (TextView) findViewById(R.id.strike_display);
        strikeCount_display.setText(Integer.toString(strike_int));
    }
    public void push_strike(View v){
        final TextView ballCount_display = (TextView) findViewById(R.id.ball_display);
        final TextView strikeCount_display = (TextView) findViewById(R.id.strike_display);
        strike_int++;
        if (strike_int >2) {
            ball_int = 0;
            strike_int = 0;
        }
        ballCount_display.setText(Integer.toString(ball_int));
        strikeCount_display.setText(Integer.toString(strike_int));
    }


}

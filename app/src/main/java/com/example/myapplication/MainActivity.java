package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    static int strike_int = 0;
    static int ball_int = 0;

    public void push_ball(View v){
        ball_int++;
        final TextView ballCount_display = (TextView) findViewById(R.id.ball_display);
        ballCount_display.setText(Integer.toString(ball_int));
        final TextView strikeCount_display = (TextView) findViewById(R.id.strike_display);
        strikeCount_display.setText(Integer.toString(strike_int));
        if (ball_int > 3) {
            show_reset(v, false);
        }

    }
    public void push_strike(View v){
        final TextView ballCount_display = (TextView) findViewById(R.id.ball_display);
        final TextView strikeCount_display = (TextView) findViewById(R.id.strike_display);
        strike_int++;
        ballCount_display.setText(Integer.toString(ball_int));
        strikeCount_display.setText(Integer.toString(strike_int));
        if (strike_int >2) {
            show_reset(v,true);
        }
    }

    public void show_reset (View v,boolean is_strike_out){
        findViewById(R.id.strike_button).setVisibility(View.GONE);
        findViewById(R.id.ball_button).setVisibility(View.GONE);
        findViewById(R.id.clear_button).setVisibility(View.VISIBLE);
        final TextView reset_message = (TextView) findViewById(R.id.reset_message);
        if (is_strike_out) {
            reset_message.setText("You're Out!!!");
        }
        else {
            reset_message.setText("Take a Free Walk!!!");
        }
        reset_message.setVisibility(View.VISIBLE);
    }

    public void reset(View v) {
        ball_int = 0;
        strike_int = 0;
        final TextView ballCount_display = (TextView) findViewById(R.id.ball_display);
        ballCount_display.setText(Integer.toString(ball_int));
        final TextView strikeCount_display = (TextView) findViewById(R.id.strike_display);
        strikeCount_display.setText(Integer.toString(strike_int));
        findViewById(R.id.strike_button).setVisibility(View.VISIBLE);
        findViewById(R.id.ball_button).setVisibility(View.VISIBLE);
        findViewById(R.id.clear_button).setVisibility(View.GONE);
        findViewById(R.id.reset_message).setVisibility(View.GONE);

    }


}

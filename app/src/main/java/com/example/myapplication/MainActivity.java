package com.example.myapplication;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    static int strike_int;
    static int ball_int;
    static int strike_outs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mainToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mainToolBar);

        //Sets up persistant variables if they exsist
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        //SharedPreferences.Editor editor = pref.edit();
        strike_int = pref.getInt("strikes", 0);
        ball_int = pref.getInt("balls", 0);
        strike_outs = pref.getInt("strike_outs", 0);

        final TextView ballCount_display = (TextView) findViewById(R.id.ball_display);
        ballCount_display.setText(Integer.toString(ball_int));
        final TextView strikeCount_display = (TextView) findViewById(R.id.strike_display);
        strikeCount_display.setText(Integer.toString(strike_int));
        final TextView strikeOut_display = (TextView) findViewById(R.id.strike_out_count);
        strikeOut_display.setText(Integer.toString(strike_outs));

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main_menu_options,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_reset:

                ball_int = 0;
                strike_int = 0;
                strike_outs = 0;

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("strikes", strike_int);
                editor.putInt("strike_outs",strike_outs);
                editor.putInt("balls", ball_int);
                editor.commit();

                final TextView ballCount_display = (TextView) findViewById(R.id.ball_display);
                ballCount_display.setText(Integer.toString(ball_int));
                final TextView strikeCount_display = (TextView) findViewById(R.id.strike_display);
                strikeCount_display.setText(Integer.toString(strike_int));
                final TextView strikeOut_display = (TextView) findViewById(R.id.strike_out_count);
                strikeOut_display.setText(Integer.toString(strike_outs));
                findViewById(R.id.strike_button).setVisibility(View.VISIBLE);
                findViewById(R.id.ball_button).setVisibility(View.VISIBLE);
                findViewById(R.id.clear_button).setVisibility(View.GONE);
                findViewById(R.id.reset_message).setVisibility(View.GONE);
                return true;

            case R.id.menu_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void push_ball(View v){
        ball_int++;
        final TextView ballCount_display = (TextView) findViewById(R.id.ball_display);
        ballCount_display.setText(Integer.toString(ball_int));
        final TextView strikeCount_display = (TextView) findViewById(R.id.strike_display);
        strikeCount_display.setText(Integer.toString(strike_int));
        if (ball_int > 3) {
            show_reset(v, false);
        }

        //saves for persistance
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("balls", ball_int);
        editor.commit();
    }

    public void push_strike(View v){

        final TextView strikeCount_display = (TextView) findViewById(R.id.strike_display);

        strike_int++;
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("strikes", strike_int);

        strikeCount_display.setText(Integer.toString(strike_int));


        if (strike_int >2) {
            show_reset(v,true);
            strike_outs++;
            editor.putInt("strike_outs",strike_outs);
            final TextView strikeOut_display = (TextView) findViewById(R.id.strike_out_count);
            strikeOut_display.setText(Integer.toString(strike_outs));
        }
        editor.commit();
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

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("strikes", strike_int);
        editor.putInt("balls",ball_int);


        final TextView ballCount_display = (TextView) findViewById(R.id.ball_display);
        ballCount_display.setText(Integer.toString(ball_int));
        final TextView strikeCount_display = (TextView) findViewById(R.id.strike_display);
        strikeCount_display.setText(Integer.toString(strike_int));
        findViewById(R.id.strike_button).setVisibility(View.VISIBLE);
        findViewById(R.id.ball_button).setVisibility(View.VISIBLE);
        findViewById(R.id.clear_button).setVisibility(View.GONE);
        findViewById(R.id.reset_message).setVisibility(View.GONE);
        editor.commit();
    }
}

package com.example.lab_1_umpire_buddy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button strike_button;
    private Button ball_button;
    private TextView strike_text;
    private TextView ball_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strike_button = (Button) findViewById(R.id.strike);
        ball_button = (Button) findViewById(R.id.ball);
        strike_text = (TextView) findViewById(R.id.strike_count);
        ball_text = (TextView) findViewById(R.id.ball_count);
    }
}
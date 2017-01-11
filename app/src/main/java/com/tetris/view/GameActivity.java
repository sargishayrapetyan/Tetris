package com.tetris.view;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import com.tetris.controller.GameController;
import com.tetris.data.Game;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    GameView m_gameView;
    Game m_game;
    GameController m_controller;
    Button m_startGameButton;
    Button m_rightButton;
    Button m_leftButton;
    Button m_upButton;
    protected Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            m_gameView.getAdapter().notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        m_gameView = new GameView(getApplicationContext());
        m_game = new Game();
        m_controller = new GameController(m_gameView, m_game);
        m_game.setController(m_controller);
        m_gameView.setController(m_controller);

        TextView textView = new TextView(getApplicationContext());
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundColor(Color.GREEN);
        m_controller.setTextView(textView);
        m_controller.updateScore();


        m_leftButton = new Button(this);
        m_leftButton.setBackgroundColor(Color.YELLOW);
        m_leftButton.setText("LEFT");
        m_leftButton.setMinimumHeight(5);
        m_leftButton.setMinimumWidth(5);
        m_leftButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                left();

            }
        });

        m_rightButton = new Button(this);
        m_rightButton.setBackgroundColor(Color.YELLOW);
        m_rightButton.setText("RIGHT");
        m_rightButton.setMinimumHeight(5);
        m_rightButton.setMinimumWidth(5);
        m_rightButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                right();

            }
        });
        m_upButton = new Button(this);
        m_upButton.setBackgroundColor(Color.YELLOW);
        m_upButton.setText("TURN");
       // m_upButton.setMinimumHeight(5);
       // m_upButton.setMinimumWidth(5);
        m_upButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                rotate();

            }
        });

        m_startGameButton = new Button(this);
        m_startGameButton.setBackgroundColor(Color.RED);
        m_startGameButton.setText("Start");
        //m_startGameButton.setPadding(0, 0, 2, 0);
        m_startGameButton.setMinimumWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        m_startGameButton.setMinimumHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        m_startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();

            }
        });

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                             LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(m_upButton, 0);

        LinearLayout h_layout = new LinearLayout(this);
        h_layout.setOrientation(LinearLayout.HORIZONTAL);
        h_layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                               LinearLayout.LayoutParams.WRAP_CONTENT));

        h_layout.addView(m_startGameButton, 0);
        h_layout.addView(m_leftButton, 1);
        h_layout.addView(m_rightButton, 2);
        h_layout.addView(textView, 3);
        //h_layout.setPadding(0, 3, 0, 0);

        LinearLayout v_layout = new LinearLayout(this);
        v_layout.setOrientation(LinearLayout.VERTICAL);
        v_layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                              LinearLayout.LayoutParams.WRAP_CONTENT));

        v_layout.addView(h_layout, 0);
        v_layout.addView(layout, 1);
        v_layout.addView(m_gameView, 2);
        setContentView(v_layout);
    }

    private void start()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!m_game.gameOver()) {
                    m_gameView.onDownClicked();
                    handler.sendEmptyMessage(0);
                    SystemClock.sleep(500);
                }
            }
        }).start();

    }
    private void left()
    {
        m_gameView.onLeftClicked();
    }

    private void right()
    {
        m_gameView.onRightClicked();
    }

    private void rotate()
    {
        m_gameView.onRotateClicked();
    }
}

package com.tetris.controller;


import com.tetris.data.Field;
import com.tetris.data.Game;
import com.tetris.view.GameView;
import android.widget.TextView;


/**
 * Created by Sargis on 11.08.2016.
 */
public class GameController implements GameChangeListener, ViewEventListener {

    public GameController(GameView view, Game game)
    {
        m_view = view;
        m_game = game;
    }

    @Override
    public boolean gameOver()
    {
        return(m_game.gameOver());
    }

    @Override
    public void update(Field field)
    {
        m_view.updateField(field);
    }

   @Override
    public void updateScore()
    {
         final int score = m_game.getScore();
        textView.post(new Runnable() {
            @Override
            public void run() {
                textView.setText("Score = " + score);
            }
        });



    }

    public void setTextView(TextView view)
    {
        textView = view;
    }

    @Override
    public void onRightClick()
    {
        m_game.right();
    }

    @Override
    public void onLeftClick()
    {
        m_game.left();
    }

    @Override
    public void onRotateClick()
    {
        m_game.rotate();
    }

    @Override
    public void onDownClick()
    {
        m_game.down();
    }

    private TextView textView;
    private Game m_game;
    private GameView m_view;
}

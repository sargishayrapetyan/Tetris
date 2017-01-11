package com.tetris.controller;


import com.tetris.data.Field;

/**
 * Created by Sargis on 11.08.2016.
 */
public interface GameChangeListener {
    public boolean gameOver();
    public void update(Field field);

}

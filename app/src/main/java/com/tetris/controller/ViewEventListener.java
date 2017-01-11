package com.tetris.controller;

/**
 * Created by Sargis on 11.08.2016.
 */
public interface  ViewEventListener {
    public void onRightClick();
    public void onLeftClick();
    public void onRotateClick();
    public void onDownClick();
    //public int updateScore();
    public void updateScore();

}

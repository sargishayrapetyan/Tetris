package com.tetris.data;


import com.tetris.controller.GameController;

import java.util.Random;
import java.util.Vector;

/**
 * Created by Sargis on 07.08.2016.
 */
public class Game {

    public Game() {
        m_field = new Field();
        m_shape = createShape();
    }

    public void right() {
        if (m_field.checkRight(m_shape)) {
            Field tmpfield = new Field(m_field);
            m_shape.right();
            tmpfield.setTrue(m_shape);
            m_controller.update(tmpfield);
        }
    }

    public void left() {
        if (m_field.checkLeft(m_shape)) {
            Field tmpfield = new Field(m_field);
            m_shape.left();
            tmpfield.setTrue(m_shape);
            m_controller.update(tmpfield);
        }
    }

    public void rotate() {
        if (m_field.checkCanRotate(m_shape)) {
            Field tmpfield = new Field(m_field);
            m_shape.rotate();
            tmpfield.setTrue(m_shape);
            m_controller.update(tmpfield);
        }
    }

    public boolean gameOver() {
        Vector<Vector<Integer>> cord = m_shape.shapeCoordinate();
        for (int i = 0; i < cord.size(); ++i) {
            int x = cord.get(i).get(0);
            int y = cord.get(i).get(1);
            if (m_field.isFull(y, x)) {
                return true;
            }
        }
        return false;
    }

    public void down() {
        if (gameOver()) {
            return;
        }
        if (m_field.checkDown(m_shape)) {
            m_shape.down();
            Field tmpfield = new Field(m_field);
            tmpfield.setTrue(m_shape);
            m_controller.update(tmpfield);
        } else {
            m_field.setTrue(m_shape);
            for (int i = 0; i < 21; ++i) {
                if (m_field.checkComplateCow(i)) {
                    m_field.deleteRow(i);
                    m_field.moveLineDown(i);
                   score = score + 10;
                    m_controller.updateScore();
                }
                m_controller.update(m_field);
                m_shape = createShape();

            }
        }
    }

    public int getScore()
    {
        return score;
    }

    public void setController(GameController controller)
    {
        this.m_controller = controller;
    }




    private Shape createShape()
    {
        Shape shape = null;
        Random rand = new Random();
        int shapenumber = rand.nextInt(6) + 1;
        if(shapenumber == 1) {
            shape = new SquareShape();
        }
        else if(shapenumber == 2){
            shape = new LineShape();
        }
        else if(shapenumber == 3){
         shape = new LShape();
        }
        else if(shapenumber == 4){
            shape = new MirroredLShape();
        }
        else if(shapenumber == 5){
            shape = new SShape();
        }
        else if(shapenumber == 6){
            shape = new TShape();
         }
        else if(shapenumber == 7) {
           shape = new ZShape();
        }
        return shape;
    }

    private GameController m_controller;
    private Field m_field;
    private Shape m_shape;
    private int score;
}


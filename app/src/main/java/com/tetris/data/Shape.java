package com.tetris.data;

import java.util.Vector;

/**
 * Created by Sargis on 07.08.2016.
 */
public abstract class Shape {
    public Shape(int x, int y)
    {
        m_x = x;
        m_y = y;
        rotated_angle = 0;
    }

    abstract public void right();
    abstract public void left() ;
    abstract public void down() ;
    abstract public void rotate();
    abstract public Vector<Vector<Integer>> getRotatedPoints();
    abstract public Vector<Vector<Integer>> shapeCoordinate();
    abstract public Vector<Vector<Integer>> shapeLeftCoordinate();
    abstract public Vector<Vector<Integer>> shapeRightCoordinate();
    abstract public Vector<Vector<Integer>> shapeLowerCoordinate();


    public int get_x() //ashkis petq chen
    {
       return m_x;
    }
    public int get_y() //ashkis petq chen
    {
       return m_y;
    }

    protected int m_x;
    protected int m_y;
    protected int rotated_angle;
}

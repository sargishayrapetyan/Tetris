package com.tetris.data;

import java.util.Vector;

/**
 * Created by Sargis on 09.08.2016.
 */
public class LineShape extends Shape {

    public LineShape()
    {
        super(3, 0);
    }

    public LineShape(LineShape lineShape)
    {
        super(lineShape.m_x, lineShape.m_y);
    }


    @Override
    public void right()
    {
        //rotated_angle = rotated_angle + 90;
        if(rotated_angle == 90){
            if(m_x!= 9)
            ++m_x;
        }
        if(rotated_angle == 0) {
            if (m_x + 3 != 9)
                ++m_x;
        }
    }

    @Override
    public void left()
    {
        if(m_x  != 0)
            --m_x;
    }

    @Override
    public void down()
    {
        if(rotated_angle == 0) {
            if (m_y != 21)
                ++m_y;
        }
        if(rotated_angle == 90){
            if(m_y != 21)
                ++m_y;
        }
    }

    @Override
    public void rotate()
    {
        rotated_angle = rotated_angle + 90;
        if(rotated_angle == 90) {
            m_x = m_x + 2;
            m_y = m_y + 3;
            return;
        }
        if(rotated_angle == 180){
            m_x = m_x - 2;
            m_y = m_y - 3;
            rotated_angle = 0;
        }

    }

    @Override
    public Vector<Vector<Integer>> getRotatedPoints()
    {
        LineShape lineShape = new LineShape(this);
        lineShape.rotate();
        return lineShape.shapeCoordinate();
    }


    @Override
    public Vector<Vector<Integer>> shapeCoordinate()
    {
        Vector<Vector<Integer>> cord = new Vector<Vector<Integer>>();
        for(int i = 0; i < 4; ++i) {
            cord.add(new Vector<Integer>());
        }
        if(rotated_angle == 0) {
            cord.get(0).add(0, m_x);
            cord.get(0).add(1, m_y);
            cord.get(1).add(0, m_x + 1);
            cord.get(1).add(1, m_y);
            cord.get(2).add(0, m_x + 2);
            cord.get(2).add(1, m_y);
            cord.get(3).add(0, m_x + 3);
            cord.get(3).add(1, m_y);
        }
        if(rotated_angle == 90) {
            cord.get(0).add(0, m_x);
            cord.get(0).add(1, m_y);
            cord.get(1).add(0, m_x);
            cord.get(1).add(1, m_y - 1);
            cord.get(2).add(0, m_x);
            cord.get(2).add(1, m_y - 2);
            cord.get(3).add(0, m_x);
            cord.get(3).add(1, m_y - 3);
        }
        return cord;
    }


    @Override
    public Vector<Vector<Integer>> shapeLeftCoordinate()
    {
        Vector<Vector<Integer>> cord = new Vector<Vector<Integer>>();
        cord.add(new Vector<Integer>());
        if(rotated_angle == 0) {
            cord.get(0).add(0, m_x);
            cord.get(0).add(1, m_y);
        }
        if(rotated_angle == 90) {
            cord.add(new Vector<Integer>());
            cord.add(new Vector<Integer>());
            cord.add(new Vector<Integer>());
            cord.get(0).add(0, m_x);
            cord.get(0).add(1, m_y);
            cord.get(1).add(0, m_x);
            cord.get(1).add(1, m_y - 1);
            cord.get(2).add(0, m_x);
            cord.get(2).add(1, m_y - 2);
            cord.get(3).add(0, m_x);
            cord.get(3).add(1, m_y - 3);
        }
        return cord;

    }

    @Override
    public Vector<Vector<Integer>> shapeRightCoordinate()
    {
        Vector<Vector<Integer>> cord = new Vector<Vector<Integer>>();
        cord.add(new Vector<Integer>());
        if(rotated_angle == 0) {
            cord.get(0).add(0, m_x + 3);
            cord.get(0).add(1, m_y);
        }
        if(rotated_angle == 90){
            cord.add(new Vector<Integer>());
            cord.add(new Vector<Integer>());
            cord.add(new Vector<Integer>());
            cord.get(0).add(0, m_x);
            cord.get(0).add(1, m_y);
            cord.get(1).add(0, m_x);
            cord.get(1).add(1, m_y - 1);
            cord.get(2).add(0, m_x);
            cord.get(2).add(1, m_y - 2);
            cord.get(3).add(0, m_x);
            cord.get(3).add(1, m_y - 3);
        }
        return cord;
    }

    @Override
    public Vector<Vector<Integer>> shapeLowerCoordinate()
    {
        Vector<Vector<Integer>> cord = new Vector<Vector<Integer>>();
        cord.add(new Vector<Integer>());
        if(rotated_angle == 90){
            cord.get(0).add(0, m_x);
            cord.get(0).add(1, m_y);
        }
        if(rotated_angle == 0) {
                cord.add(new Vector<Integer>());
            cord.add(new Vector<Integer>());
            cord.add(new Vector<Integer>());
            cord.get(0).add(0, m_x);
            cord.get(0).add(1, m_y);
            cord.get(1).add(0, m_x + 1);
            cord.get(1).add(1, m_y);
            cord.get(2).add(0, m_x + 2);
            cord.get(2).add(1, m_y);
            cord.get(3).add(0, m_x + 3);
            cord.get(3).add(1, m_y);
        }

        return cord;
    }
}

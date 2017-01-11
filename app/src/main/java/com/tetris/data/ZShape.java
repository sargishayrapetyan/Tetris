package com.tetris.data;

import java.util.Vector;

/**
 * Created by Sargis on 08.08.2016.
 */
public class ZShape extends Shape {

    public ZShape()
    {
        super(4, 2);
    }

    public ZShape(ZShape zShape)
    {
        super(zShape.m_x, zShape.m_y);
    }

    @Override
    public void right()
    {
        if(m_x + 1 != 9)
            ++m_x;
    }

    @Override
    public void left()
    {
        if(rotated_angle == 0) {
            if (m_x - 1 != 0)
                --m_x;
            return;
        }
        if(rotated_angle == 90){
            if(m_x != 0)
                --m_x;
        }
    }

    @Override
    public void down()
    {
        if(rotated_angle == 0) {
            if (m_y != 21)
                ++m_y;
        }
        if(rotated_angle ==90){
            if(m_y + 1 != 21)
                ++m_y;
        }
    }

    @Override
    public void rotate()
    {
        rotated_angle = rotated_angle + 90;
        if(rotated_angle == 180){
            rotated_angle = 0;
        }

    }

    @Override
    public Vector<Vector<Integer>> getRotatedPoints()
    {
        ZShape zShape = new ZShape(this);
        zShape.rotate();
        return zShape.shapeCoordinate();
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
            cord.get(2).add(0, m_x - 1);
            cord.get(2).add(1, m_y - 1);
            cord.get(3).add(0, m_x);
            cord.get(3).add(1, m_y - 1);
        }
        if(rotated_angle == 90){
            cord.get(0).add(0, m_x);
            cord.get(0).add(1, m_y);
            cord.get(1).add(0, m_x);
            cord.get(1).add(1, m_y + 1);
            cord.get(2).add(0, m_x + 1);
            cord.get(2).add(1, m_y);
            cord.get(3).add(0, m_x + 1);
            cord.get(3).add(1, m_y - 1);

        }
        return cord;
    }

    @Override
    public Vector<Vector<Integer>>  shapeLeftCoordinate()
    {
        Vector<Vector<Integer>> cord = new Vector<Vector<Integer>>();
        cord.add(new Vector<Integer>());
        cord.add(new Vector<Integer>());
        if(rotated_angle == 0) {
            cord.get(0).add(0, m_x -1);
            cord.get(0).add(1, m_y -1);
            cord.get(1).add(0, m_x);
            cord.get(1).add(1, m_y);
        }
        if(rotated_angle == 90){
            cord.add(new Vector<Integer>());
            cord.get(0).add(0, m_x);
            cord.get(0).add(1, m_y + 1);
            cord.get(1).add(0, m_x);
            cord.get(1).add(1, m_y);
            cord.get(2).add(0, m_x + 1);
            cord.get(2).add(1, m_y - 1);
        }
        return cord;
    }
    public Vector<Vector<Integer>> shapeRightCoordinate()
    {
        Vector<Vector<Integer>> cord = new Vector<Vector<Integer>>();
        cord.add(new Vector<Integer>());
        cord.add(new Vector<Integer>());
        if(rotated_angle == 0) {
            cord.get(0).add(0, m_x);
            cord.get(0).add(1, m_y - 1);
            cord.get(1).add(0, m_x + 1);
            cord.get(1).add(1, m_y);
        }
        if(rotated_angle == 90){
            cord.add(new Vector<Integer>());;
            cord.get(0).add(0, m_x);
            cord.get(0).add(1, m_y + 1);
            cord.get(1).add(0, m_x + 1);
            cord.get(1).add(1, m_y);
            cord.get(2).add(0, m_x + 1);
            cord.get(2).add(1, m_y - 1);


        }
        return cord;
    }
    public Vector<Vector<Integer>> shapeLowerCoordinate()
    {
        Vector<Vector<Integer>> cord = new Vector<Vector<Integer>>();
        cord.add(new Vector<Integer>());
        cord.add(new Vector<Integer>());
        if(rotated_angle == 90){
            cord.get(0).add(0, m_x);
            cord.get(0).add(1, m_y + 1);
            cord.get(1).add(0, m_x + 1);
            cord.get(1).add(1, m_y);
        }
        if(rotated_angle == 0) {
            cord.add(new Vector<Integer>());
            cord.get(0).add(0, m_x);
            cord.get(0).add(1, m_y);
            cord.get(1).add(0, m_x + 1);
            cord.get(1).add(1, m_y);
            cord.get(2).add(0, m_x - 1);
            cord.get(2).add(1, m_y - 1);
        }
        return  cord;
    }
}

package com.tetris.data; /**
 * Created by Sargis on 07.08.2016.
 */
import java.util.Vector;

public class SquareShape extends Shape {

    public SquareShape()
    {
        super(4, 2);
    }

    @Override
    public void right()
    {
        if (m_x + 1 != 9)
            ++m_x;
    }

    @Override
    public void left()
    {
        if (m_x != 0)
            --m_x;
    }

    @Override
    public void down()
    {
        if(m_y != 21)
            ++m_y;
    }

    @Override
    public void rotate()
    {

    }

    @Override
    public Vector<Vector<Integer>> getRotatedPoints()
    {
        return shapeCoordinate();
    }

    @Override
    public Vector<Vector<Integer>> shapeCoordinate()
    {
        Vector<Vector<Integer>> cord = new Vector<Vector<Integer>>();
        for(int i = 0; i < 4; ++i) {
            cord.add(new Vector<Integer>());
        }
        cord.get(0).add(0, m_x);
        cord.get(0).add(1, m_y);
        cord.get(1).add(0, m_x);
        cord.get(1).add(1, m_y - 1);
        cord.get(2).add(0, m_x + 1);
        cord.get(2).add(1, m_y);
        cord.get(3).add(0, m_x + 1);
        cord.get(3).add(1, m_y - 1);
        return cord;

    }

    @Override
    public Vector<Vector<Integer>> shapeLeftCoordinate()
    {
        Vector<Vector<Integer>> cord = new Vector<Vector<Integer>>();
        cord.add(new Vector<Integer>());
        cord.add(new Vector<Integer>());
        cord.get(0).add(0, m_x + 1);
        cord.get(0).add(1, m_y - 1);
        cord.get(1).add(0, m_x + 1);
        cord.get(1).add(1,m_y);
        return cord;
    }

    @Override
    public Vector<Vector<Integer>> shapeRightCoordinate()
    {
        Vector<Vector<Integer>> cord = new Vector<Vector<Integer>>();
        cord.add(new Vector<Integer>());
        cord.add(new Vector<Integer>());
        cord.get(0).add(0, m_x);
        cord.get(0).add(1, m_y - 1);
        cord.get(1).add(0, m_x);
        cord.get(1).add(1, m_y);
        return cord;

    }

    @Override
    public Vector<Vector<Integer>> shapeLowerCoordinate()
    {
        Vector<Vector<Integer>> cord = new Vector<Vector<Integer>>();
        cord.add(new Vector<Integer>());
        cord.add(new Vector<Integer>());
        cord.get(0).add(0, m_x);
        cord.get(0).add(1, m_y);
        cord.get(1).add(0, m_x + 1);
        cord.get(1).add(1, m_y);
        return cord;
    }
}

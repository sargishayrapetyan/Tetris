package com.tetris.data; /**
 * Created by Sargis on 07.08.2016.
 */

import java.util.Vector;

public class Field {
    public Field()
    {
        m_field = new Vector<Vector<Boolean>>(21);
        for (int i = 0; i < 21; ++i) {
            m_field.add(new Vector<Boolean>(10));
            for (int j = 0; j < 10; ++j) {
                m_field.get(i).add(j, false);
            }
        }
    }

    public Field(Field field)
    {

        m_field = new Vector<Vector<Boolean>>(21);
        for (int i = 0; i < 21; ++i) {
            m_field.add(new Vector<Boolean>());
            for (int j = 0; j < 10; ++j) {
                m_field.get(i).add(j, field.getCellCordinate(i, j));
            }
        }
    }

    public boolean getCellCordinate(int i, int j)
    {
        return m_field.get(i).get(j);
    }

    public boolean checkComplateCow(int i)
    {
        for (int j = 0; j < 10; ++j) {
            if (!m_field.get(i).get(j))
                return false;
        }
        return true;
    }
   /* public boolean checkComplate(Shape shape)
    {

    }*/

    public void deleteRow(int i)
    {
        //if(check_complate_row(i)){
        for (int j = 0; j < 10; ++j){
            m_field.get(i).set(j, false);
        }
    //}
    }

    public boolean checkLeft(Shape shape)
    {
        Vector<Vector<Integer>> cord = shape.shapeLeftCoordinate();
        for(int i = 0; i < cord.size(); ++i) {
            if (isFull(cord.get(i).get(1) - 1, cord.get(i).get(0))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRight(Shape shape)
    {
        Vector<Vector<Integer>> cord = shape.shapeRightCoordinate();
        for(int i = 0; i < cord.size(); ++i){
            if(cord.get(i).get(0) == 9 || isFull((cord.get(i).get(1) + 1), cord.get(i).get(0))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDown(Shape shape)
    {
        Vector<Vector<Integer>> cord = shape.shapeLowerCoordinate();
        for(int i = 0; i < cord.size(); ++i){
            if(cord.get(i).get(1) == 20 || isFull((cord.get(i).get(1) + 1), cord.get(i).get(0))){
                return false;
            }
        }
        return true;
    }


    public void moveLineDown(int i)
    {
        for(; i > 0; --i) {
            for (int j = 0; j < 10; ++j) {
                if (isFull(i - 1, j)) {
                    m_field.get(i).set(j, true);
                    m_field.get(i - 1).set(j, false);

                }
            }
        }
    }

    public boolean isFull(int i, int j)
    {
        return (m_field.get(i).get(j));
    }

    public boolean checkCanRotate(Shape shape)
    {
        Vector<Vector<Integer>> cord = shape.getRotatedPoints();
        for(int i = 0; i < cord.size(); ++i){
            int x = cord.get(i).get(0);
            int y = cord.get(i).get(1);
            if(isFull(y, x)){
                return false;
            }
        }
        return true;
    }

    public void setTrue(Shape shape)
    {
        Vector<Vector<Integer>> cord = shape.shapeCoordinate();
        for (int i = 0; i < 4; ++i) {
            int x = cord.get(i).get(0);
            int y = cord.get(i).get(1);
            m_field.get(y).set(x, true);
        }
    }

    public void setFalse(Shape shape)
    {
        Vector<Vector<Integer>> cord = shape.shapeCoordinate();
        for (int i = 0; i < 4; ++i) {
            int x = cord.get(i).get(0);
            int y = cord.get(i).get(1);
            m_field.get(y).add(x, false);
        }
    }

    private Vector<Vector<Boolean>> m_field;
}

package com.tetris.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import com.tetris.controller.GameController;
import com.tetris.controller.ViewEventListener;
import com.tetris.data.Field;
import android.widget.GridView;

/**
 * Created by Sargis on 18.08.2016.
 */
public class GameView extends GridView {

    public GameView(Context context)
    {
        super(context);
        m_adapter = new GameViewAdapter(context);
        setNumColumns(10);
        setColumnWidth(10);
        setMinimumWidth(ActionBar.LayoutParams.MATCH_PARENT);
        setMinimumHeight(ActionBar.LayoutParams.MATCH_PARENT);
        setBackgroundColor(Color.BLACK);
        setHorizontalSpacing(5);
        setVerticalSpacing(5);
        setActivated(false);
        setClickable(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setAdapter(m_adapter);
    }

    public GameViewAdapter getAdapter()
    {
        return m_adapter;
    }

    public void updateField(Field field)
    {
        m_adapter.updateField(field);
    }


    public void setController(GameController controller)
    {
        m_controller = controller;
    }

    public void onRightClicked()
    {
        m_controller.onRightClick();
    }

    public void onLeftClicked()
    {
        m_controller.onLeftClick();
    }

    public void onDownClicked()
    {
        m_controller.onDownClick();
    }

    public void onRotateClicked()
    {
        m_controller.onRotateClick();
    }


    private ViewEventListener m_controller;
    private GameViewAdapter m_adapter;
}

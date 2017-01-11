package com.tetris.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;

import com.testris.R;
import com.tetris.data.Field;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Vector;

/**
 * Created by Sargis on 16.08.2016.
 */
public class GameViewAdapter<F> extends BaseAdapter {
    private LayoutInflater m_inflater = null;
    private Context context;
    //private Field m_field;
   // private Shape m_shape;
    private Vector<Boolean> m_field;

    public GameViewAdapter(Context context)
    {
        this.context = context;
        m_inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        m_field = new Vector<Boolean>();
        for(int i = 0; i < 21; ++i)
            for(int j = 0; j < 10; ++j){
                m_field.add(false);
            }
    }

    public void updateField(Field f)
    {
        m_field.clear();
        for(int i = 0; i < 21; ++i)
            for(int j = 0; j < 10; ++j) {
                m_field.add(f.getCellCordinate(i, j));
            }
//       notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
       return m_field.size();
    }

    @Override
    public Object getItem(int position)
    {
        return m_field.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        super.unregisterDataSetObserver(observer);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View rowView = m_inflater.inflate(R.layout.cell_view, null);
        View cellView = rowView.findViewById(R.id.cell_view);
        if (m_field.get(position)) {
            cellView.setBackgroundColor(Color.RED);
        } else {
            cellView.setBackgroundColor(Color.GRAY);
        }
        return rowView;
    }

}

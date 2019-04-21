package com.test0.pwing.prac_sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class Myadapter extends ArrayAdapter {
    private Context mContext;
    private ArrayList<MyBlock> myBlockArrayList;
    private int mLayout;

    public Myadapter(Context context, int layout, ArrayList<MyBlock> myBlockArrayList) {
        super(context, layout, myBlockArrayList);
        this.myBlockArrayList = myBlockArrayList;
        this.mContext = context;
        this.mLayout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            view = inflater.inflate(mLayout, parent, false);
        }

        MyBlock block = myBlockArrayList.get(position);

//            ImageView img = (ImageView) view.findViewById(R.id.LocationImageView);
//            img.setImageResource(block.getImage);

        TextView tvName = (TextView) view.findViewById(R.id.NameTextView);
        tvName.setText(block.getName());

        TextView tvDesc = (TextView) view.findViewById(R.id.DescTextView);
        tvDesc.setText(block.getDescrip());

        return view;
    }
}
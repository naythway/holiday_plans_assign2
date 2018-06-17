package com.example.naythway.holidayplans;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] title;
    private final String[] para;
    private final Integer[] imageId;
    public CustomList(Activity context,
                      String[] title, String[] paragraph, Integer[] imageId) {
        super(context, R.layout.list_single, title);
        this.context = context;
        this.title = title;
        this.para = paragraph;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.title);
        TextView txtPara = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(title[position]);
        txtPara.setText(para[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}

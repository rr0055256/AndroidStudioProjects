package com.helloworld.raman.customizablelistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by raman on 24/10/15.
 */
public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] players;
    private final Integer[] imageId;

    public CustomList(Activity context, String[] players,Integer[] imageId) {
        super(context, R.layout.list_view,players);
        this.context = context;
        this.players = players;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //inflating the custom layout
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_view, null, true);

        //object of textview
        TextView textView = (TextView) view.findViewById(R.id.playerName);

        //object of imageview
        ImageView imageView = (ImageView) view.findViewById(R.id.playerImage);

        textView.setText(players[position]);

        imageView.setImageResource(imageId[position]);

        return view;
    }
}

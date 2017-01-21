package com.example.sridevi.multiscreen.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sridevi.multiscreen.ModelClasses.word;
import com.example.sridevi.multiscreen.R;

import java.util.ArrayList;

/**
 * Created by Sridevi on 12/24/2016.
 */
public class wordAdapter extends ArrayAdapter<word>{


    public wordAdapter(Context context, ArrayList<word> wordArrayList) {
        super(context,0,wordArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
       // android:background="#F44336"
        word currentwod = getItem(position);
        TextView tv1 = (TextView)listItemView.findViewById(R.id.capsid);
        tv1.setText(currentwod.getMcaptialletters());
        TextView tv2 = (TextView)listItemView.findViewById(R.id.smallid);
        tv2.setText(currentwod.getMsmallletters());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageid);


        LinearLayout linearLayout = (LinearLayout)listItemView.findViewById(R.id.textcolorcontainer);
        linearLayout.setBackgroundColor(Color.parseColor("#F44336"));


        if(currentwod.hasImage()) {

            imageView.setImageResource(currentwod.getMimageresource());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }
        return listItemView;
    }
}

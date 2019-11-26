package com.example.almafiesta2k20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class listArrayAdapter extends ArrayAdapter<eventData> {
    private Context mContext;
    private int mResource;
    private List<eventData> mEventList;
    public listArrayAdapter(Context context, int resource, List<eventData> list){
        super(context,0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        eventData currentEventData=getItem(position);
        View listItemView=convertView;
        if(listItemView==null)
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_layout,parent,false);

        TextView eventHead=listItemView.findViewById(R.id.listText);
        eventHead.setText(currentEventData.getHead());
        ImageView icon=listItemView.findViewById(R.id.icon);
        icon.setImageResource(currentEventData.getImage2());
        return listItemView;
    }
}


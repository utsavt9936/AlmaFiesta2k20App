package com.example.almafiesta2k20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class musicfragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.musicfragment, container, false);




        ArrayList<eventData> musicData=new ArrayList<>();
       /* musicData.add(new eventData(R.drawable.smdr1,getResources().getString(R.string.smd1),getResources().getString(R.string.smh1),getResources().getString(R.string.euphony)));
        musicData.add(new eventData(R.drawable.smdr2,getResources().getString(R.string.smd2),getResources().getString(R.string.smh2),getResources().getString(R.string.upbeat)));
        musicData.add(new eventData(R.drawable.smdr3,getResources().getString(R.string.smd3),getResources().getString(R.string.smh3),getResources().getString(R.string.track)));
        musicData.add(new eventData(R.drawable.smdr4,getResources().getString(R.string.smd4),getResources().getString(R.string.smh4),getResources().getString(R.string.duetto)));
        musicData.add(new eventData(R.drawable.smdr5,getResources().getString(R.string.smd5),getResources().getString(R.string.smh5),getResources().getString(R.string.unplugged)));
*/


        listArrayAdapter lar=new listArrayAdapter(getContext(),0,musicData);
        final ListView list= rootView.findViewById(R.id.musicList);
        list.setAdapter(lar);





        return rootView;
    }
}

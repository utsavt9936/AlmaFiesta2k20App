package com.example.almafiesta2k20;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class musicfragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.musicfragment, container, false);




        final ArrayList<eventData> musicData=new ArrayList<>();
        musicData.add(new eventData(R.drawable.amlogo,R.drawable.uepho,getResources().getString(R.string.smd1),getResources().getString(R.string.smh1),getResources().getString(R.string.smr1)));
        musicData.add(new eventData(R.drawable.amlogo,R.drawable.upbeat,getResources().getString(R.string.smd2),getResources().getString(R.string.smh2),getResources().getString(R.string.smr2)));
        musicData.add(new eventData(R.drawable.amlogo,R.drawable.track,getResources().getString(R.string.smd3),getResources().getString(R.string.smh3),getResources().getString(R.string.smr3)));
        musicData.add(new eventData(R.drawable.amlogo,R.drawable.duetto,getResources().getString(R.string.smd4),getResources().getString(R.string.smh4),getResources().getString(R.string.smr4)));
        musicData.add(new eventData(R.drawable.amlogo,R.drawable.unpll,getResources().getString(R.string.smd5),getResources().getString(R.string.smh5),getResources().getString(R.string.smr5)));



        listArrayAdapter lar=new listArrayAdapter(getContext(),0,musicData);
        final ListView list= rootView.findViewById(R.id.musicList);
        list.setAdapter(lar);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent=new Intent(getActivity(),listOpener.class);
                intent.putExtra("Text",musicData.get(i).getText());
                intent.putExtra("Head",musicData.get(i).getHead());
                intent.putExtra("Image ID",musicData.get(i).getImage());
                intent.putExtra("Rules",musicData.get(i).getRule());
                startActivity(intent);


            }
        });
        return rootView;
    }
}

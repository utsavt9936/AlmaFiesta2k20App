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

public class dancefragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedDataInstanceState) {
        View rootView= inflater.inflate(R.layout.dancefragment, container, false);



       final ArrayList<eventData> danceData=new ArrayList<>();
        danceData.add(new eventData(R.drawable.img4,R.drawable.ripout,getResources().getString(R.string.sdd1),getResources().getString(R.string.sdh1),getResources().getString(R.string.sdr1)));
        danceData.add(new eventData(R.drawable.img4,R.drawable.topsyturvey,getResources().getString(R.string.sdd2),getResources().getString(R.string.sdh2),getResources().getString(R.string.sdr2)));
        danceData.add(new eventData(R.drawable.img4,R.drawable.rabne,getResources().getString(R.string.sdd3),getResources().getString(R.string.sdh3),getResources().getString(R.string.sdr3)));


        listArrayAdapter lar=new listArrayAdapter(getContext(),0,danceData);
        final ListView list = rootView.findViewById(R.id.danceList);
        list.setAdapter(lar);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                Intent intent=new Intent(getActivity(),listOpener.class);
                intent.putExtra("Text",danceData.get(i).getText());
                intent.putExtra("Head",danceData.get(i).getHead());
                intent.putExtra("Image ID",danceData.get(i).getImage());
                intent.putExtra("Rules",danceData.get(i).getRule());
                startActivity(intent);


            }
        });





        return rootView;
    }
}

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

public class photofragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_photofragment, container, false);



        final ArrayList<eventData> photoData=new ArrayList<>();
        photoData.add(new eventData(R.drawable.img4,getResources().getString(R.string.spd1),getResources().getString(R.string.sph1),getResources().getString(R.string.spr1)));
        photoData.add(new eventData(R.drawable.img4,getResources().getString(R.string.spd2),getResources().getString(R.string.sph2),getResources().getString(R.string.spr2)));
        photoData.add(new eventData(R.drawable.img4,getResources().getString(R.string.spd3),getResources().getString(R.string.sph3),getResources().getString(R.string.spr3)));



        listArrayAdapter lar=new listArrayAdapter(getContext(),0,photoData);
        final ListView list= rootView.findViewById(R.id.photoList);
        list.setAdapter(lar);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                Intent intent=new Intent(getActivity(),listOpener.class);
                intent.putExtra("Text",photoData.get(i).getText());
                intent.putExtra("Head",photoData.get(i).getHead());
                intent.putExtra("Image ID",photoData.get(i).getImage());
                intent.putExtra("Rules",photoData.get(i).getRule());
                startActivity(intent);


            }
        });


        return rootView;
    }
}

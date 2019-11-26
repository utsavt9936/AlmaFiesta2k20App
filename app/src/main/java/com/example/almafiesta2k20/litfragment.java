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

public class litfragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_litfragment, container, false);





        final ArrayList<eventData> litData=new ArrayList<>();
        litData.add(new eventData(R.drawable.img4,R.drawable.mun,getResources().getString(R.string.sld1),getResources().getString(R.string.slh1),getResources().getString(R.string.slr1)));
        litData.add(new eventData(R.drawable.img4,R.drawable.seedha,getResources().getString(R.string.sld2),getResources().getString(R.string.slh2),getResources().getString(R.string.slr2)));
        litData.add(new eventData(R.drawable.img4,R.drawable.drishti,getResources().getString(R.string.sld3),getResources().getString(R.string.slh3),getResources().getString(R.string.slr3)));
        litData.add(new eventData(R.drawable.img4,R.drawable.poetry,getResources().getString(R.string.sld4),getResources().getString(R.string.slh4),getResources().getString(R.string.slr4)));

        listArrayAdapter lar=new listArrayAdapter(getContext(),0,litData);
        final ListView list= rootView.findViewById(R.id.litList);
        list.setAdapter(lar);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                Intent intent=new Intent(getActivity(),listOpener.class);
                intent.putExtra("Text",litData.get(i).getText());
                intent.putExtra("Head",litData.get(i).getHead());
                intent.putExtra("Image ID",litData.get(i).getImage());
                intent.putExtra("Rules",litData.get(i).getRule());
                startActivity(intent);


            }
        });



        return rootView;
    }
}

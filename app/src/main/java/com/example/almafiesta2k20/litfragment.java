package com.example.almafiesta2k20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class litfragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_litfragment, container, false);





        ArrayList<eventData> litData=new ArrayList<>();
       /* litData.add(new eventData(R.drawable.sldr1,getResources().getString(R.string.sld1),getResources().getString(R.string.slh1),getResources().getString(R.string.mun)));
        litData.add(new eventData(R.drawable.sldr2,getResources().getString(R.string.sld2),getResources().getString(R.string.slh2),getResources().getString(R.string.samvad)));
        litData.add(new eventData(R.drawable.sldr3,getResources().getString(R.string.sld3),getResources().getString(R.string.slh3),getResources().getString(R.string.drishtikon)));
        litData.add(new eventData(R.drawable.sldr4,getResources().getString(R.string.sld4),getResources().getString(R.string.slh4),getResources().getString(R.string.poetry)));
*/
        listArrayAdapter lar=new listArrayAdapter(getContext(),0,litData);
        final ListView list= rootView.findViewById(R.id.litList);
        list.setAdapter(lar);














        return rootView;
    }
}

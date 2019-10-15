package com.example.almafiesta2k20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class photofragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_photofragment, container, false);



        ArrayList<eventData> photoData=new ArrayList<>();
        /*photoData.add(new eventData(R.drawable.spdr1,getResources().getString(R.string.spd1),getResources().getString(R.string.sph1),getResources().getString(R.string.pic)));
        photoData.add(new eventData(R.drawable.spdr2,getResources().getString(R.string.spd2),getResources().getString(R.string.sph2),getResources().getString(R.string.shortf)));
        photoData.add(new eventData(R.drawable.spdr3,getResources().getString(R.string.spd3),getResources().getString(R.string.sph3),getResources().getString(R.string.docu)));
*/


        listArrayAdapter lar=new listArrayAdapter(getContext(),0,photoData);
        final ListView list= rootView.findViewById(R.id.photoList);
        list.setAdapter(lar);





        return rootView;
    }
}

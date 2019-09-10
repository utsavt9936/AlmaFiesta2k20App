package com.example.almafiesta2k20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class finefragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_finefragment, container, false);



        ArrayList<eventData> fineDta=new ArrayList<>();
        fineDta.add(new eventData(R.drawable.sfdr1,getResources().getString(R.string.sfd1),getResources().getString(R.string.sfh1),getResources().getString(R.string.shadez)));
        fineDta.add(new eventData(R.drawable.sfdr2,getResources().getString(R.string.sfd2),getResources().getString(R.string.sfh2),getResources().getString(R.string.facepainting)));


        listArrayAdapter lar=new listArrayAdapter(getContext(),0,fineDta);
        final ListView list= rootView.findViewById(R.id.fineList);
        list.setAdapter(lar);





        return rootView;
    }
}

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

public class finefragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_finefragment, container, false);



        final ArrayList<eventData> fineData=new ArrayList<>();
        fineData.add(new eventData(R.drawable.img4,R.drawable.shaezd,getResources().getString(R.string.sfd1),getResources().getString(R.string.sfh1),getResources().getString(R.string.sfr1)));
        fineData.add(new eventData(R.drawable.img4,R.drawable.facepaint,getResources().getString(R.string.sfd2),getResources().getString(R.string.sfh2),getResources().getString(R.string.sfr2)));


        listArrayAdapter lar=new listArrayAdapter(getContext(),0,fineData);
        final ListView list= rootView.findViewById(R.id.fineList);
        list.setAdapter(lar);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                Intent intent=new Intent(getActivity(),listOpener.class);
                intent.putExtra("Text",fineData.get(i).getText());
                intent.putExtra("Head",fineData.get(i).getHead());
                intent.putExtra("Image ID",fineData.get(i).getImage());
                intent.putExtra("Rules",fineData.get(i).getRule());
                startActivity(intent);


            }
        });





        return rootView;
    }
}

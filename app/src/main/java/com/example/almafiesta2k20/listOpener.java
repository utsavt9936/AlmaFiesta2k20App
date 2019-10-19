package com.example.almafiesta2k20;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class listOpener extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_data_layout);
        String passedText = getIntent().getStringExtra("Text");
        String passedHead = getIntent().getStringExtra("Head");
        String passedRule = getIntent().getStringExtra("Rules");
        int passedImageID = getIntent().getIntExtra("Image ID",0);

        TextView text=findViewById(R.id.eventText);
        text.setText(passedText+"\n\n"+passedRule);
        TextView head=findViewById(R.id.eventHead);
        head.setText(passedHead);
        ImageView image=findViewById(R.id.eventImage);
        image.setImageResource(passedImageID);

    }
}

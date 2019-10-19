package com.example.almafiesta2k20;

//Setting a Class to store data of different events to show in Layout.

public class eventData {
    private int mImageID;
    private String mText;
    private String mHead;
    private String mRule;

    public  eventData(int imageID,String data,String head,String rule)
    {
        mImageID=imageID;
        mText=data;
        mHead=head;
       mRule=rule;
    }
    public String getRule(){
        return mRule;
   }
    public int getImage(){
        return mImageID;
    }
    public String getText(){
        return mText;
    }
    public String getHead(){
        return mHead;
    }
}

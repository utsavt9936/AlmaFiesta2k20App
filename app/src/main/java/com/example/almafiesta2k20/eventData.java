package com.example.almafiesta2k20;

//Setting a Class to store data of different events to show in Layout.

public class eventData {
    private int mImageID;
    private int mImageID2;
    private String mText;
    private String mHead;
    private String mRule;

    public  eventData(int imageID,int imageID2,String data,String head,String rule)
    {
        mImageID=imageID;
        mImageID2=imageID2;
        mText=data;
        mHead=head;
       mRule=rule;
    }
    public String getRule(){
        return mRule;
   }
    public int getImage2(){
        return mImageID2;
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

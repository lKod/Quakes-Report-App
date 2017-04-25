package com.example.android.quakereport;

import java.util.logging.StreamHandler;

/**
 * Created by Thal Marc on 2/10/2017.
 */

public class EarthQuake {

    private String mLocation ;
    private String mProximityLocation;
    private String mDate;
    private String mMagnitude;
    private String mTime;
    private String mUrl;

    EarthQuake(String mLocation, String mProximityLocation, String mDate, String mMagnitude, String mTime,String mUrl){
        this.mLocation = mLocation;
        this.mDate = mDate;
        this.mMagnitude = mMagnitude;
        this.mTime = mTime;
        this.mProximityLocation = mProximityLocation;
        this.mUrl = mUrl;
    }

    public String getLocation(){
        return mLocation;
    }

    public String getmDate(){
        return mDate;
    }

    public String getmMagnitude(){
        return mMagnitude;
    }

    public String getmTime(){
        return mTime;
    }

    public String getmProximityLocation(){
        return mProximityLocation;
    }

    public String getmUrl(){
        return mUrl;
    }

}

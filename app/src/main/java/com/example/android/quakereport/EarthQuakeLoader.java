package com.example.android.quakereport;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thal Marc on 3/7/2017.
 */

public class EarthQuakeLoader extends AsyncTaskLoader<CustomArrayAdapter> {

    public static ArrayList<EarthQuake> earthQuakes12;
    Context mContext ;

    //Constructor.- Wel let the superclass do the job
   public EarthQuakeLoader(Context context){

        super(context);
        mContext = context;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    // Job doing in background
    @Override
    public CustomArrayAdapter loadInBackground() {

         CustomArrayAdapter adapter = new CustomArrayAdapter(mContext,QueryUtils.extractEarthquakes());
         earthQuakes12 = QueryUtils.extractEarthquakes();


        return adapter;
    }

}

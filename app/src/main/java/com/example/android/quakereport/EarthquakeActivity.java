/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.data;

public class  EarthquakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<CustomArrayAdapter>, SwipeRefreshLayout.OnRefreshListener {

    private ListView earthquakeListView;
    private CustomArrayAdapter adapter;
    private ArrayList<EarthQuake> earthQuakes12;
    private TextView emptyTextview;
    private ProgressBar spinner;
    private SwipeRefreshLayout swipeRefresh;
    private final int LOADER_ID = 0;

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        emptyTextview = (TextView) findViewById(R.id.empty);
        emptyTextview.setVisibility(View.GONE);

        spinner = (ProgressBar) findViewById(R.id.loading_spinner);
        spinner.isIndeterminate();
        spinner.setVisibility(View.VISIBLE);

        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        swipeRefresh.setOnRefreshListener(this);

       /** adapter = new CustomArrayAdapter(EarthquakeActivity.this,QueryUtils.extractEarthquakes());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter); **/
       getSupportLoaderManager().initLoader(LOADER_ID,null,this);

    }
//------------------ Inflate the menu -----------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


//---------------------- Manage the loader ------------------------------------------------
    @Override
    public void onLoadFinished(Loader<CustomArrayAdapter> loader, CustomArrayAdapter adapter1) {

        swipeRefresh.setRefreshing(false);

        spinner.setVisibility(View.GONE);
        // Find a reference to the {@link ListView} in the layout
        earthquakeListView = (ListView) findViewById(R.id.list);

        //Create a Click listener
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                EarthQuake earthQuake = EarthQuakeLoader.earthQuakes12.get(i);
                String url = earthQuake.getmUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interfacesp





            earthquakeListView.setAdapter(adapter1);


            earthquakeListView.setEmptyView(emptyTextview);


    }

    @Override
    public Loader<CustomArrayAdapter> onCreateLoader(int id, Bundle args) {
        EarthQuakeLoader earthQuakeLoader  = new EarthQuakeLoader(EarthquakeActivity.this);

        return earthQuakeLoader;
    }
    @Override
    public void onLoaderReset( Loader<CustomArrayAdapter> loader) {
        //clear
    }

    //-----------------------Manage the swipe gesture ---------------------------------------------------

    @Override
    public void onRefresh() {
        //do the refresh
        doUpdate();
    }

    public void doUpdate(){
       getSupportLoaderManager().restartLoader(LOADER_ID,null,this);
    }
}


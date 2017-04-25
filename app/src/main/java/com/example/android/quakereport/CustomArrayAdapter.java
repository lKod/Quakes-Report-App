package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.shapes.Shape;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.android.quakereport.R.id.date;

/**
 * Created by Thal Marc on 2/10/2017.
 */

public class CustomArrayAdapter extends ArrayAdapter<EarthQuake> {

    CustomArrayAdapter(Context context, ArrayList<EarthQuake> EarthQuake){
        super(context,0,EarthQuake);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EarthQuake earthQuake = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne, parent, false);
        }

        TextView magnitude = (TextView) convertView.findViewById(R.id.magnitude);
        TextView location = (TextView) convertView.findViewById(R.id.location);
        TextView proximityLocation = (TextView) convertView.findViewById(R.id.proximityLocation);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView time = (TextView) convertView.findViewById(R.id.time);
        String url = earthQuake.getmUrl();

        magnitude.setText(earthQuake.getmMagnitude());
        location.setText(earthQuake.getLocation());
        date.setText(earthQuake.getmDate());
        time.setText(earthQuake.getmTime());
        proximityLocation.setText(earthQuake.getmProximityLocation());



 //***********************************************************************************//
        //Change the background color depending of the intensity of the magnitude
        GradientDrawable shape = (GradientDrawable) magnitude.getBackground();
        double magnitudeDouble = Double.parseDouble(earthQuake.getmMagnitude());
        if(magnitudeDouble >= 10){
            int myColor = ContextCompat.getColor(getContext(),R.color.magnitude10plus);
            shape.setColor(myColor);
        }else if(magnitudeDouble >=9&& magnitudeDouble<10){
            int myColor = ContextCompat.getColor(getContext(),R.color.magnitude9);
            shape.setColor(myColor);
        }else if(magnitudeDouble >=8&& magnitudeDouble<9){
            int myColor = ContextCompat.getColor(getContext(),R.color.magnitude8);
            shape.setColor(myColor);
        }else if(magnitudeDouble >=7&& magnitudeDouble<8){
            int myColor = ContextCompat.getColor(getContext(),R.color.magnitude7);
            shape.setColor(myColor);
        }else if(magnitudeDouble >=6&& magnitudeDouble<7){
            int myColor = ContextCompat.getColor(getContext(),R.color.magnitude6);
            shape.setColor(myColor);
        }else if(magnitudeDouble >=5&& magnitudeDouble<6){
            int myColor = ContextCompat.getColor(getContext(),R.color.magnitude5);
            shape.setColor(myColor);
        }else if(magnitudeDouble >=4&& magnitudeDouble<5){
            int myColor = ContextCompat.getColor(getContext(),R.color.magnitude4);
            shape.setColor(myColor);
        }else if(magnitudeDouble >=3&& magnitudeDouble<4){
            int myColor = ContextCompat.getColor(getContext(),R.color.magnitude3);
            shape.setColor(myColor);
        }else if(magnitudeDouble >=2&& magnitudeDouble<3){
            int myColor = ContextCompat.getColor(getContext(),R.color.magnitude2);
            shape.setColor(myColor);
        }else if(magnitudeDouble<2){
            int myColor = ContextCompat.getColor(getContext(),R.color.magnitude1);
            shape.setColor(myColor);
        }
//*******************************************************************************************//




        return convertView;
    }
}

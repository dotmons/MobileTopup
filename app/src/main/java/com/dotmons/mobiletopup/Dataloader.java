package com.dotmons.mobiletopup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;

/**
 * Created by ess on 11/25/2015.
 */
public class Dataloader extends android.support.v4.app.Fragment implements AdapterView.OnItemSelectedListener{

    View rootViewer;
    Spinner spinnerserviceprovider, spinnerdataoption;

    ArrayAdapter<CharSequence> dataAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootViewer = inflater.inflate(R.layout.dataloader,  container, false);

        spinnerserviceprovider = (Spinner) rootViewer.findViewById(R.id.spinnerserviceprovider);
        spinnerdataoption = (Spinner) rootViewer.findViewById(R.id.spinnerdataoption);



        spinnerdataoption.setOnItemSelectedListener(this);
        spinnerserviceprovider.setOnItemSelectedListener(this);

        return rootViewer;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Log.d("wishing0", String.valueOf(view.getId()));
        Log.d("wishing1", String.valueOf(R.id.spinnerserviceprovider));
        Log.d("wishing2", String.valueOf(R.id.spinnerdataoption));


        Log.d("selectedvalsDotmons",String.valueOf(spinnerserviceprovider.getSelectedItemPosition()));

        if (view.getId() == R.id.spinnerserviceprovider) {

            Log.d("onItemSelected", "spinnerserviceprovider");

            switch (spinnerserviceprovider.getSelectedItemPosition()) {
                case 0:
                    Log.d("onItemSelected", "0Reading");
                  //  dataAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.gloday, android.R.layout.simple_spinner_item);
                   // dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                  //  spinnerdataoption.setAdapter(dataAdapter);
                case 1:
                    Log.d("onItemSelected", "1Reading");
                   // dataAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.gloweek, android.R.layout.simple_spinner_item);
                   // dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    //spinnerdataoption.setAdapter(dataAdapter);
                case 2:

                case 3:

                default:
                    Log.d("Default content", "No selected item");
            }
        }

    }

    private void loadSpinnerDataLoader(int n)
    {
        if (n==0)
        {
            //spinnerdataoption.add
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

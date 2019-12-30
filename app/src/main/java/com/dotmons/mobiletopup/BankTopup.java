package com.dotmons.mobiletopup;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by ess on 11/21/2015.
 */
public class BankTopup extends android.support.v4.app.Fragment implements AdapterView.OnItemSelectedListener, Button.OnClickListener{

    View rootView;
    Button btn;
    EditText Amount;
    Spinner bankSpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.banktopup, container, false);

        Amount = (EditText) rootView.findViewById(R.id.Amount);
        bankSpinner = (Spinner) rootView.findViewById(R.id.spinnerBank);
        btn = (Button) rootView.findViewById(R.id.button);

        bankSpinner.setOnItemSelectedListener(this);
        btn.setOnClickListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


/*
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
*/


        return rootView;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.button)
        {
            int selectedBank = bankSpinner.getSelectedItemPosition();
            executeTransaction(getUUID(selectedBank));
        }
    }

    public void executeTransaction(String query)
    {
        String encodedHash = Uri.encode("#");
        String ussd = query + encodedHash;
        Log.d("Executed Query", ussd);
        startActivityForResult(new Intent("android.intent.action.CALL", Uri.parse("tel:" + ussd)), 1);
    }

    public String getUUID(int n)
    {
        switch (n){
            case 0:
                return "*894*"+Amount.getText();
            case 1:
                return "*302*"+Amount.getText();
            case 2:
                return "*901*"+Amount.getText();
            case 3:
                return "*770*"+Amount.getText();
            case 4:
                return "*389*214*"+Amount.getText();
            case 5:
                return "*909*"+Amount.getText();
            case 6:
                return "*326*"+Amount.getText();
            case 7:
                return "*737*"+Amount.getText();
            case 8:
                return "*822*"+Amount.getText();
            default:
                return "*894*"+Amount.getText();
        }
    }
/*    AllNetwork	FirstMonie	*894*Amount#	To register <>
    AllNetwork	ZenithBank	*302*Amount#
    AllNetwork 	Access Bank  	*901*Amount#
    AllNetwork	Fidelity	*770*Amount#
    AllNetwork	FCMB		*389*214*Amount#
    AllNetwork	Stanbic IBTC	*909*Amount#
    AllNetwork	EcoBank		*326*Amount#
    AllNetwork	GTBank		*737*Amount# or *737*Amount*Phoneno#
    AllNetwork	SterlingBnk	*822*Amount#*/

}

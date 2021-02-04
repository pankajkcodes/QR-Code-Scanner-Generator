package com.pankajkcodes.qrcodescannergenerator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

            IntentIntegrator intentIntegrator;
            intentIntegrator = new IntentIntegrator(this);
            intentIntegrator.initiateScan();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result==null){
            super.onActivityResult(requestCode, resultCode, data);
        }else {
            String mResult = result.getContents();
            if (mResult ==null){
                // Code
            }else {
                showBox(mResult);
            }
        }
    }

    private void showBox(String mResult) {
        // Start Code Generating Alert Box
        AlertDialog.Builder Abl = new AlertDialog.Builder(this);
        Abl.setTitle("Scan Result");
        Abl.setMessage(mResult);
        Abl.setPositiveButton("ok", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        Abl.create().show();
        // End Code Alert Box
    }
}
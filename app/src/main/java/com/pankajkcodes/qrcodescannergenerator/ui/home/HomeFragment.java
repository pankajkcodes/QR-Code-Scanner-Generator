package com.pankajkcodes.qrcodescannergenerator.ui.home;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.number.IntegerWidth;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.pankajkcodes.qrcodescannergenerator.GenerateActivity;
import com.pankajkcodes.qrcodescannergenerator.R;
import com.pankajkcodes.qrcodescannergenerator.ScanActivity;

public class HomeFragment extends Fragment {

    private Button scanBtn, genBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        scanBtn = root.findViewById(R.id.scanBtn);
        genBtn = root.findViewById(R.id.geneBtn);
        //Start to  check permission
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_DENIED){
            requestPermissions(new String[]{Manifest.permission.CAMERA},101); }
        // End Permission Code

        // Set On nClickListener on Btn1
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scanIntent = new Intent((getContext()), ScanActivity.class);
                startActivity(scanIntent);
            }


        });
        genBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent genIntent = new Intent((getContext()), GenerateActivity.class);
                startActivity(genIntent);
            }
        });
        return root;
    }

}
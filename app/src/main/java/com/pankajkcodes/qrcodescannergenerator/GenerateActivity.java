package com.pankajkcodes.qrcodescannergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerateActivity extends AppCompatActivity {
    Button GenerateCodeBtn , shareBtn;
    ImageView CodeImg;
    EditText contentField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        getSupportActionBar().setTitle("Generate QR Code");
        GenerateCodeBtn = findViewById(R.id.generateBtn);
        CodeImg = findViewById(R.id.CodeImg);
        contentField = findViewById(R.id.genText);
        shareBtn =findViewById(R.id.shareBtn);
        GenerateCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateCode();
            }

            private void generateCode() {
                String content = contentField.getText().toString().trim();
                BarcodeEncoder encoder = new BarcodeEncoder();
                try {
                    Bitmap bitmap = encoder.encodeBitmap(content, BarcodeFormat.QR_CODE,400,400);
                    CodeImg.setImageBitmap(bitmap);
                    CodeImg.setVisibility(View.VISIBLE);
                    shareBtn.setVisibility(View.VISIBLE);

                } catch (WriterException e) {
                    e.printStackTrace();
                    Toast.makeText(GenerateActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        });
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void shareBitmap(Bitmap image) {

    }
}

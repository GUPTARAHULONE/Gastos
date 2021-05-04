package com.example.gastos.home_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.hardware.camera2.CameraDevice;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;

import com.budiyev.android.codescanner.AutoFocusMode;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ScanMode;
import com.example.gastos.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

import java.io.IOException;


public class NewPaymentScreenScanner extends AppCompatActivity {
    private CodeScanner mCodeScanner;
    private boolean isPermissionGranted = false;
    private final int RequestCameraPermissionId = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_payment_screen_scanner);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(this, scannerView);

        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(NewPaymentScreenScanner.this , new String[]{Manifest.permission.CAMERA}
                    , RequestCameraPermissionId);
            return;
        }

        try
        {
            isPermissionGranted = true;
            startScanner();

        } catch (Exception e) {
            e.printStackTrace();
        }




    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RequestCameraPermissionId:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    try {
                        isPermissionGranted = true;
                       startScanner();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isPermissionGranted)
        startScanner();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        sendBroadcast(new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
        super.onPause();
    }

    public void startScanner()
    {
        mCodeScanner.startPreview();
        mCodeScanner.setCamera(CodeScanner.CAMERA_BACK);// or CAMERA_FRONT or specific camera id
        mCodeScanner.setFormats(CodeScanner.ALL_FORMATS); // list of type BarcodeFormat,
        // ex. listOf(BarcodeFormat.QR_CODE)
        mCodeScanner.setAutoFocusMode(AutoFocusMode.SAFE); // or CONTINUOUS
        mCodeScanner.setScanMode(ScanMode.SINGLE); // or CONTINUOUS or PREVIEW
        mCodeScanner.setAutoFocusEnabled(true); // Whether to enable auto focus or not
        mCodeScanner.setFlashEnabled(false);// Whether to enable flash or not
        mCodeScanner.setDecodeCallback (new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(500);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(NewPaymentScreenScanner.this, result.getText(), Toast.LENGTH_SHORT).show();
                        mCodeScanner.stopPreview();
                        mCodeScanner.releaseResources();
                    }
                });
            }
        });
    }
}
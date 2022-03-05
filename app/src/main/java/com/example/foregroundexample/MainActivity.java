package com.example.foregroundexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Dialog myDialog;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast2(this, "App is launched ................");

        if(!foregroundServiceRunning()){
            Intent serviceIntent = new Intent(this, MyForegroundService.class);
            startForegroundService(serviceIntent);

        }

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_STATE},1);

        }


    }

    public  boolean foregroundServiceRunning(){
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        for(ActivityManager.RunningServiceInfo service: activityManager.getRunningServices(Integer.MAX_VALUE)){
            if(MyForegroundService.class.getName().equals(service.service.getClassName())){
                return true;
            }
        }

            return false;
    }

    public void showNotify(){

        Toast.makeText(this,"This is a popup notification toast",Toast.LENGTH_SHORT).show();
    }

    public void openShowup(View view){

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Toast.makeText(this,"Hellow there",Toast.LENGTH_SHORT).show();
        myDialog.show();
    }


    public void showToast2 (Context context, String message){
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        //toast.setGravity(Gravity.CENTER, 80, 80);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }


}
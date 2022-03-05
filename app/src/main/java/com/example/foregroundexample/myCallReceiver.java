package com.example.foregroundexample;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class myCallReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            showToast(context, "Call Started.... FROM FORE GROUND SERVICE");



            showToast(context, "Popup not showed ah ?.... FROM FORE GROUND SERVICE");


        } else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_IDLE)) {

            showToast(context, "Call Ended....FROM FORE GROUND SERVICE");




        }


        }
    public void showToast (Context context, String message){
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 80, 80);
        toast.show();

    }
}

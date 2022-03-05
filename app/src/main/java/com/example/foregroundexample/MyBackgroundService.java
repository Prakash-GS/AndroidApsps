package com.example.foregroundexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyBackgroundService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while(true){
                            Log.e("Service","My Background Service is running");
                            ///Toast.makeText(this, "This is background task", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(MyBackgroundService.this,"Hello",Toast.LENGTH_SHORT).show();
                            try{
                                Thread.sleep(2000);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

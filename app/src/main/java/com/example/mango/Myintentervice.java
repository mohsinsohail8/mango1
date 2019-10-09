package com.example.mango;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import org.joda.time.DateTime;

import java.util.Calendar;

public class Myintentervice extends IntentService {
    NotificationChannel followers;
    NotificationCompat.Builder osd;
    String NOTIFICATION_ID="my_channel_id_01";
    NotificationManager nm;
    public Button b1;
    private static final int NotificationID= 40213;
    private static  final String TAG="com.example.mango";

    public Myintentervice() {
        super("Myintentervice");
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        long Futuretime=vosler.getInstance().Ftime;
            Calendar dol= Calendar.getInstance();
            int FutureTime=vosler.getInstance().seconds;
        int hhg=vosler.getInstance().no.get(Calendar.SECOND);

        Log.i(TAG,"Loop started");
        while (System.currentTimeMillis()>-1){
              Log.i(TAG,"loop running");
            DateTime posal= new DateTime();
            if (FutureTime==posal.getSecondOfMinute()){
                Log.i(TAG,"loop applied");
                followers= new NotificationChannel(NOTIFICATION_ID,"followers", NotificationManager.IMPORTANCE_HIGH);
                followers.setLightColor(Color.BLUE);
                followers.enableLights(true);
                followers.enableVibration(true);

                nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nm.createNotificationChannel(followers);

                osd= new NotificationCompat.Builder(this,NOTIFICATION_ID);
                osd.setAutoCancel(true);
                osd.setWhen(System.currentTimeMillis());

                osd.setSmallIcon(R.drawable.ic_launcher_background);
                osd.setTicker("olala");
                osd.setContentTitle("lulla");
                osd.setWhen(System.currentTimeMillis());
                osd.setContentText("ye mera notification ha");
                osd.setContentInfo("info");
                Intent intenti= new Intent(this,MainActivity.class);
                PendingIntent pintent=PendingIntent.getActivity(this,0,intenti,PendingIntent.FLAG_UPDATE_CURRENT);
                osd.setContentIntent(pintent);
                nm.notify(NotificationID,osd.build());



            }


        }

    }
}

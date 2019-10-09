package com.example.mango;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import org.joda.time.DateTime;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    NotificationChannel followers;
    NotificationCompat.Builder osd;
    String NOTIFICATION_ID="my_channel_id_01";
    NotificationManager nm;
    public Button b1;
    public long ttime;
    private static final int NotificationID= 40213;
    public long ntime;
    public Calendar cal;
    public int sec;
    DateTime hhp;
    public int gosa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttime=System.currentTimeMillis()+10000;
        vosler.getInstance().Ftime=ttime;
        hhp=new DateTime();
        gosa= hhp.getSecondOfMinute()+5;
        vosler.getInstance().seconds=gosa;

        cal=Calendar.getInstance();
        sec=cal.get(Calendar.SECOND);
        vosler.getInstance().no=cal;
       // vosler.getInstance().seconds=sec+10;

    }
    public void newnoti(View view){
        Intent it= new Intent(MainActivity.this,Myintentervice.class);
           //it.putExtra("ballay",ttime);
        startService(it);
    }

public void vulcar(View view){
        Intent iti=new Intent(MainActivity.this,Main2Activity.class);

        iti.putExtra("sulla",ttime);
        startActivity(iti);

}

}

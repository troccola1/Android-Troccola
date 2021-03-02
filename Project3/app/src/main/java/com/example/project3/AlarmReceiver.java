package com.example.project3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Toi Trong Receiver,", "Xin Chào");
        Intent myIntent = new Intent(context,Music.class);
        context.startService(myIntent);
    }
}

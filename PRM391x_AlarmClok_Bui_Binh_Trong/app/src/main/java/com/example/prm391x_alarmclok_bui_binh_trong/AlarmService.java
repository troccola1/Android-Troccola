package com.example.prm391x_alarmclok_bui_binh_trong;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import androidx.annotation.Nullable;

public class AlarmService  extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
        String on_off = Object.requireNonNull(intent.getExtras()).getString("ON_OFF");
        assert on_off != null;
        switch (on_off) {
            case Constants.ADD_INTENT:
                Uri uri = Settings.System.DEFAULT_ALARM_ALERT_URI;
                onTrimMemory.start();
                break;
            case Constants.OFF_INTENT:
                int alarmId = intent.getExtras().getInt("AlarmId");
                if (mMediaPlayer != null && mMediaPlayer.isPlaying() && alarmId == AlarmReceiver.sPendingId) {
                    mMediaPlayer.stop();
                    mMediaPlayer.reset();
                }
                break;
        }
        return START_STICKY;
    }

    // TODO: Logic processing to turn off the ringtone
    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.stop();
        mMediaPlayer.reset();
    }
}


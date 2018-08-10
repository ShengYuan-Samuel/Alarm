package com.nistart.alarm;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("AlarmReceiver", "haha");
        Intent i = new Intent(context, LongRunningService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //这是8.0以后的版本需要这样跳转
            context.startForegroundService(i);
        } else {
            context.startService(i);
        }
    }
}
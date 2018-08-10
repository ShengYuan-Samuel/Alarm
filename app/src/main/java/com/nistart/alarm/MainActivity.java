package com.nistart.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startBtn;
    private Button stopBtn;
    private AlarmReceiver alarmReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);

        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startBtn:

                Intent intent = new Intent(this, LongRunningService.class);
                startService(intent);
                break;
            case R.id.stopBtn:
                AlarmManager manager = (AlarmManager) this
                        .getSystemService(Context.ALARM_SERVICE);
                Intent intent1 = new Intent(this, AlarmReceiver.class);
                PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent1, 0);
                //取消正在执行的服务
                manager.cancel(pi);
                break;
        }
    }
}

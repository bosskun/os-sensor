package com.akihitoq.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccActivity extends AppCompatActivity implements SensorEventListener {

    TextView tv_x, tv_y, tv_z;

    SensorManager sensorManager;
    Sensor sensor_acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);

        tv_x = (TextView) findViewById(R.id.txt_x);
        tv_y = (TextView) findViewById(R.id.txt_y);
        tv_z = (TextView) findViewById(R.id.txt_z);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor_acc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor_acc, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        tv_x.setText("X : " + event.values[0]); // x
        tv_y.setText("Y : " + event.values[1]); // y
        tv_z.setText("Z : " + event.values[2]); // z

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

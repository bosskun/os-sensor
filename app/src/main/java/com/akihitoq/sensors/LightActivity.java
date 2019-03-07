package com.akihitoq.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LightActivity extends AppCompatActivity implements SensorEventListener {
    TextView tv_light;

    SensorManager sensorManager;
    Sensor sensor_light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        tv_light = (TextView) findViewById(R.id.txt_light);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor_light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(this, sensor_light, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        tv_light.setText("LX : " + event.values[0] );

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

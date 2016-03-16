package com.apkmarvel.cameraview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getName();
    protected CameraSurfaceView cameraView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cast();
    }
    private void cast() {
        cameraView = new CameraSurfaceView(this);
        ((FrameLayout) findViewById(R.id.frame_containter)).addView(cameraView);
    }
}


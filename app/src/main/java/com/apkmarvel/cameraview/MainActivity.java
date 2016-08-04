package com.apkmarvel.cameraview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getName();
    protected CameraTextureView cameraView;
    private ImageView imgv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cast();
    }
    private void cast() {
        cameraView = new CameraTextureView(this);
        ((FrameLayout) findViewById(R.id.frame_containter)).addView(cameraView);
        imgv = (ImageView)findViewById(R.id.imgv);
    }
    public void add(View v){
        imgv.setImageBitmap(cameraView.getBitmap());
    }
}


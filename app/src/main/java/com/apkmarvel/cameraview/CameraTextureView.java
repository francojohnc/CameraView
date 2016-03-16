package com.apkmarvel.cameraview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.Gravity;
import android.view.TextureView;
import android.widget.FrameLayout;

import java.io.IOException;


/**
 * Created by JCF on 3/13/2016.
 */
public class CameraTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    public static final String TAG = CameraTextureView.class.getSimpleName();
    private Context context;
    private Camera camera;
    public CameraTextureView(Context context) {
        super(context);
        Log.e(TAG, "CameraView");
        this.context=context;
        setSurfaceTextureListener(this);
    }
    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        Log.e(TAG, "onSurfaceTextureAvailable");
        camera = Camera.open();
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        setLayoutParams(new FrameLayout.LayoutParams(previewSize.width, previewSize.height, Gravity.CENTER));
        try {
            camera.setPreviewTexture(surface);
        } catch (IOException exception) {
            camera.release();
            camera = null;
        }
        camera.startPreview();
        setAlpha(1.0f);
    }
    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        Log.e(TAG, "onSurfaceTextureSizeChanged");
    }
    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        Log.e(TAG, "onSurfaceTextureDestroyed");
        camera.stopPreview();
        camera.release();
        return false;
    }
    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        Log.i(TAG, "onSurfaceTextureUpdated");
    }
}

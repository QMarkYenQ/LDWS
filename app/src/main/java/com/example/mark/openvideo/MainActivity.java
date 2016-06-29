package com.example.mark.openvideo;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements CvCameraViewListener2 {

    //A Tag to filter the log messages
    private static final String TAG = ":Activity";
    //A class used to implement the interaction between OpenCV and the
//device camera.

    myNDK jnifunc = new myNDK();

    private CameraBridgeViewBase mOpenCvCameraView =null;


    private BaseLoaderCallback opencvLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {

            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                {
                    Log.d(TAG, "Loaded OpenCV successfully");
                    // Init camera and start preview.
                    mOpenCvCameraView.enableView();
                } break;

                default:
                    super.onManagerConnected(status);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.cameraview);
        mOpenCvCameraView.setVisibility(SurfaceView.VISIBLE);
        mOpenCvCameraView.setCvCameraViewListener(this);

    }
    @Override
    public void onResume() {
        super.onResume();

        // Load the OpenCV library asynchronously. The callback object
        // opencvLoaderCallback will be notified when this is complete.
       OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, opencvLoaderCallback);

        jnifunc.iniProcess(0);

    }


    @Override
    public void onPause() {
        super.onPause();

        // Release the camera.
        if (mOpenCvCameraView != null) {
            mOpenCvCameraView.disableView();
        }
    }
    @Override
    public void onCameraViewStarted(int width, int height) {

    }

    @Override
    public void onCameraViewStopped() {

    }

    @Override
    public Mat onCameraFrame(CvCameraViewFrame frame)
    {
        Mat im =  new Mat();
        im = frame.rgba();
        jnifunc.imgProcess( 0, im.getNativeObjAddr() );
        return im;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }
}

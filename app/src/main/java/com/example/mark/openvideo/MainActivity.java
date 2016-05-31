package com.example.mark.openvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;

import android.util.Log;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import org.opencv.android.*;
import org.opencv.core.*;
import org.opencv.imgproc.*;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.util.Log;
public class MainActivity extends AppCompatActivity implements CvCameraViewListener2 {

    //A Tag to filter the log messages
    private static final String TAG =
            ":Activity";
    //A class used to implement the interaction between OpenCV and the
//device camera.
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

    //    requestWindowFeature(Window.FEATURE_NO_TITLE);
     //   getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
      //  setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
      //  setContentView(R.layout.activity_main);

       // mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.cameraview);
       // mOpenCvCameraView.setCvCameraViewListener(this);


      //  mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.cameraview);
       // mOpenCvCameraView.setVisibility(SurfaceView.VISIBLE);
        //mOpenCvCameraView.setCvCameraViewListener(this);

       // getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
     //   setContentView(R.layout.activity_main);
     //   mOpenCvCameraView = (CameraBridgeViewBase)
         //       findViewById(R.id.cameraview);
//Set the view as visible
      //  mOpenCvCameraView.setVisibility(SurfaceView.VISIBLE);
//Register your activity as the callback object to handle //camera frames
     //   mOpenCvCameraView.setCvCameraViewListener(this);
    }
    @Override
    public void onResume() {
        super.onResume();

        // Load the OpenCV library asynchronously. The callback object
        // opencvLoaderCallback will be notified when this is complete.
       OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, opencvLoaderCallback);



    }


    @Override
    public void onPause() {
        super.onPause();

        // Release the camera.
        if (mOpenCvCameraView != null) {
            mOpenCvCameraView.disableView();
            mOpenCvCameraView = null;
        }
    }
    @Override
    public void onCameraViewStarted(int width, int height) {

    }

    @Override
    public void onCameraViewStopped() {

    }

    @Override
    public Mat onCameraFrame(CvCameraViewFrame frame) {

        return frame.gray();
    }
}

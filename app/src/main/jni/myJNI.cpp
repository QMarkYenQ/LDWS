//
// Created by Mark on 2016/5/6.
//
#include <opencv2/opencv.hpp>
#include <android/log.h>
#include "com_example_mark_openvideo_myNDK.h"
//#include "EDLineDetector.h"

#define LOG "Demo_JNI"
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,LOG,__VA_ARGS__) // 定义LOGD类型

using namespace cv;

JNIEXPORT jint JNICALL Java_com_example_mark_openvideo_myNDK_imgProcess
    (JNIEnv *, jobject, jlong, jlong img){
 Mat* mgray = (Mat*) img;
  Mat mgray2;

   cvtColor( *mgray,*mgray,CV_RGBA2GRAY);

   //*mgray = mgray2;
/*
   EDLineDetector Ed;

   Ed.EDline( mgray2 );

    std::vector <cv::Matx23f> lineTwoPoints;
     lineTwoPoints.clear();
       cv::Matx23f line;
       for (int i = 0; i < Ed.lineEndpoints_.size(); i++) {
           line = cv::Matx23f(
                   Ed.lineEndpoints_[i][0], Ed.lineEndpoints_[i][1], 1.0, Ed.lineEndpoints_[i][2],
                   Ed.lineEndpoints_[i][3], 1.0);
           lineTwoPoints.push_back(line);
       }

       for( int i = 0; i < lineTwoPoints.size(); i++ ){
           cv::Matx23f ln = lineTwoPoints[i];
           cv::line( *mgray,
                     cv::Point( ln(0,0), ln(0,1)  ),
                     cv::Point( ln(1,0), ln(1,1)), cv::Scalar(0,0,255), 5, CV_AA);
       }
 //std::vector<cv::Matx23f> lineTwoPoints;
 //LineSegment(*mgray,&lineTwoPoints);

    LOGD("Rows %d \n",mgray->rows);
    LOGD("Rows %d \n",mgray->rows);
*/
      return 0;
}

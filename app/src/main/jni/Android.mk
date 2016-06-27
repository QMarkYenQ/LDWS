# OpenCV path setting

LOCAL_PATH := $(call my-dir)
OPENCV_SDK_PATH := D:\Users\Mark\OpenCV-android-sdk
OPENCV_INC_PATH := $(OPENCV_SDK_PATH)/sdk/native/jni/include

# Specify OpenCV.so location


# Build our library

OpenCV_INSTALL_MODULES := on
OpenCV_CAMERA_MODULES := off

OPENCV_LIB_TYPE := STATIC

include $(CLEAR_VARS)

include $(OPENCV_SDK_PATH)/sdk/native/jni/OpenCV.mk

LOCAL_MODULE := myJNI
LOCAL_CPPFLAGS := -std=c++11
LOCAL_LDLIBS     += -llog -ldl


LOCAL_SRC_FILES := myJNI.cpp
#LOCAL_SRC_FILES += \
#        += EDLineDetector.cpp

LOCAL_C_INCLUDES += $(LOCAL_PATH) \
                  $(OPENCV_INC_PATH)

include $(BUILD_SHARED_LIBRARY)

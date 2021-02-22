#include <jni.h>
#include <string>
#include <android/log.h>
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, "keymatch", __VA_ARGS__)


extern "C" JNIEXPORT jstring JNICALL
Java_com_hyperfd_ndkdemo_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    //jnienv：代表VM里面的环境，本地代买可以通过该参数与java代码进行操作
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_hyperfd_ndkdemo_MainActivity_stringFromText(JNIEnv *env, jobject instance) {
    // TODO: implement stringFromText()

    jclass  clazz=env->GetObjectClass(instance);
    jmethodID mid=env->GetMethodID(clazz,"callNullPointException","()V");
    env->CallVoidMethod(instance,mid);
    jthrowable exc=env->ExceptionOccurred();
    if(exc){
        LOGD("============");
        env->ExceptionDescribe();
        LOGD("+++++++++++++");
        env->ExceptionClear();
        jclass newExcCls=env->FindClass("java/lang/IllegalArgumentException");
        env->ThrowNew(newExcCls,"throw form JNI");
    }
}


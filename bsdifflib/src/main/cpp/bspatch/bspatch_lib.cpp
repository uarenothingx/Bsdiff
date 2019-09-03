#include <jni.h>
#include <string>
#include <android/log.h>

#define LOG_TAG "sll_debug"

#define LOGD(...) ((void)__android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__))

extern "C" {
extern int main(int argc, const char *argv[]);
}

extern "C" JNIEXPORT void JNICALL
Java_com_sll_bsdifflib_BsPatchUtils_bsPatchNative(
        JNIEnv *env,
        jobject /* this */,
        jstring oldPath,
        jstring patch,
        jstring out) {
    const char *oldPath_ = env->GetStringUTFChars(oldPath, nullptr);
    const char *patch_ = env->GetStringUTFChars(patch, nullptr);
    const char *out_ = env->GetStringUTFChars(out, nullptr);
    const char *argv[] = {"", oldPath_, out_, patch_};

    LOGD("Java_com_sll_bsdifflib_BsPatchUtils_bsPatch oldPath = %s ,path = %s ,out = %s",
         oldPath_, out_, patch_);
    main(4, argv);

    env->ReleaseStringUTFChars(oldPath, oldPath_);
    env->ReleaseStringUTFChars(patch, patch_);
    env->ReleaseStringUTFChars(out, out_);
}
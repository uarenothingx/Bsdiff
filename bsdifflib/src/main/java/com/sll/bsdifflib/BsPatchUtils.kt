package com.sll.bsdifflib

import java.io.File

object BsPatchUtils {

    fun bsPatch(oldApkPath: String, patchPath: String, outFilePath: String) {
        if (oldApkPath.isEmpty() || patchPath.isEmpty() || outFilePath.isEmpty()) {
            return
        }
        val oldApkFile = File(oldApkPath)
        val patchFile = File(patchPath)
        if (!oldApkFile.exists() || !patchFile.exists()) {
            return
        }
        bsPatchNative(oldApkPath, patchPath, outFilePath)
    }

    private external fun bsPatchNative(oldApkPath: String, patchPath: String, outFilePath: String)

    init {
        System.loadLibrary("bspatch-lib")
    }
}
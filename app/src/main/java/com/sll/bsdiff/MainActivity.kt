package com.sll.bsdiff

import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sll.bsdifflib.BsPatchUtils
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvVersionName = findViewById<TextView>(R.id.tv_version_name)
        val btnUpdate = findViewById<Button>(R.id.btn_update)

        tvVersionName.text = BuildConfig.VERSION_NAME

        val downloadDir =
            Environment.getExternalStorageDirectory().absolutePath + File.separator +
                    Environment.DIRECTORY_DOWNLOADS + File.separator

        val oldApkPath = applicationInfo.sourceDir
        val patchFilePath = downloadDir + "patch"
        val outFile = File(downloadDir, "new.apk")

        if (outFile.exists()) {
            outFile.delete()
        }
        outFile.createNewFile()

        btnUpdate.setOnClickListener {
            Thread {
                BsPatchUtils.bsPatch(oldApkPath, patchFilePath, outFile.absolutePath)
            }.start()
        }
    }
}

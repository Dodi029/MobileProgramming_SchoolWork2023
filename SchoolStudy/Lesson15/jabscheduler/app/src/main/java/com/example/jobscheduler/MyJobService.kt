package com.example.jobscheduler

import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.widget.Toast

class MyJobService : JobService() {

    var bStop = false
    override fun onCreate() {
        super.onCreate()
        Toast.makeText(applicationContext, "MyJobService-onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "MyJobService-onDestroy", Toast.LENGTH_SHORT).show()
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        Toast.makeText(applicationContext, "MyJobService-onStartJob", Toast.LENGTH_SHORT).show()

        Thread(Runnable {
            val intent = Intent("SEND_RESULT")
            intent.putExtra("RESULT_TITLE", params!!.extras.getString("TITLE"))

            for (i in 1..20){
                SystemClock.sleep(1000)

                if(bStop) break
                intent.putExtra("RESULT", i)
                sendBroadcast(intent)
            }

            jobFinished(params, false)
        }).start()

        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Toast.makeText(applicationContext, "MyJobService-onStopJob", Toast.LENGTH_SHORT).show()
        bStop = true
        return false
    }
}
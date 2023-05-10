package com.example.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
// import android.app.RemoteInput
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import com.example.notification.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "메인화면"

        binding.notification.setOnClickListener {
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder: NotificationCompat.Builder
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val channelId = "one-channel"
                val channelName = "My Channel One"
                val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT).apply{
                    description = "My Channel One EventLogTags.Description"
                    setShowBadge(true)
                    val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                    val audioAttributes = AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build()
                    setSound(uri, audioAttributes)
                    enableVibration(true)
                }
                // 채널을 NotificationManager에 등록
                manager.createNotificationChannel(channel)
                // 채널을 이용하여 builder 생성
                builder = NotificationCompat.Builder(this, channelId)}
            else {
                builder = NotificationCompat.Builder(this)
            }
            builder.run{
                // 알림의 기본 정보
                setSmallIcon(R.drawable.small)
                setWhen(System.currentTimeMillis())
                setContentTitle("홍길동")
                setContentText("안녕하세요")
                setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.big))

                val bigPicture = BitmapFactory.decodeResource(resources, R.drawable.big)
                val bigStyle = NotificationCompat.BigPictureStyle()
                bigStyle.bigPicture(bigPicture)
                setStyle(bigStyle)
        }
            val KEY_TEXT_REPLY = "key_text_reply"
            var replyLabel: String = "답장"
            var remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run{
                setLabel(replyLabel)
                build()
            }
            val replyIntent = Intent(this, MainActivity2::class.java)
            val replyPendingIntent = PendingIntent.getActivity(
                this, 30, replyIntent, PendingIntent.FLAG_MUTABLE)
            builder.setContentIntent(replyPendingIntent)

            builder.addAction(
                NotificationCompat.Action.Builder(R.drawable.send, "답장",
                    replyPendingIntent).addRemoteInput(remoteInput).build()
            )
            builder.addAction(
                NotificationCompat.Action.Builder(R.drawable.send, "Go Activity",
                    replyPendingIntent).build()
            )

            builder.setProgress(100, 0, false)
            manager.notify(11, builder.build())

            thread{
                for(i in 1..100){
                    builder.setProgress(100, i, false)
                    manager.notify(11, builder.build())
                    SystemClock.sleep(100)}
                }
            }
        }
    }

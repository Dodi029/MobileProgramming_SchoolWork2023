package com.example.basicapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.basicapp.databinding.ActivityMainBinding
import java.io.File
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestGalleryLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            try {
                // inSampleSize 비율 계산, 지정
                val calRatio = calculateInSampleSize(it.data!!.data!!,
                    resources.getDimensionPixelSize(R.dimen.imgSize),
                    resources.getDimensionPixelSize(R.dimen.imgSize))
                val options = BitmapFactory.Options()
                options.inSampleSize = calRatio

                var inputStream = contentResolver.openInputStream(it.data!!.data!!)
                val bitmap = BitmapFactory.decodeStream(inputStream, null, options)
                inputStream!!.close()
                if (bitmap != null) binding.userImageView.setImageBitmap(bitmap)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        binding.galleryButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            requestGalleryLauncher.launch(intent)
        }

        val requestCameraThumbnailLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            val bitmap = it?.data?.extras?.get("data") as Bitmap
            binding.userImageView.setImageBitmap(bitmap)
        }
        binding.cameraButtonByData.setOnClickListener {
            requestCameraThumbnailLauncher.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }

        lateinit var filePath: String
        val requestCameraFileLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            val calRatio = calculateInSampleSize(
                Uri.fromFile(File(filePath)),
                resources.getDimensionPixelSize(R.dimen.imgSize),
                resources.getDimensionPixelSize(R.dimen.imgSize))
            val options = BitmapFactory.Options()
            option.inSampleSize = calRatio
            val bitmap?.let{
                binding.userImageView.setImageBitmap(bitmap)
            }
        }
        binding.cameraButtonByFile.setOnClickListener {
            val timeStamp: String = SimpleDataFormat("yyyyMMdd_HHmmss").format(Date())
            val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val file = File.createTempFile(
                "JPEG_${timeStamp}_",
                ".jpg",
                storageDir
            )
            filePath = file.absolutePath
            val photoURI: Uri = FileProvider.getUriForFile(
                this,
                "com.example.basicapp.fileprovider", file
            )
        }
    }

    private fun calculateInSampleSize(fileUri: Uri, reqWidth: Int, reqHeight: Int): Int {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        try {
            var inputStream = contentResolver.openInputStream(fileUri)

            BitmapFactory.decodeStream(inputStream, null, options)
            inputStream!!.close()
        } catch (e : Exception){
            e.printStackTrace()
        }

        val (height: Int, width: Int) = options.run{outHeight to outWidth }
        var inSampleSize = 1

        if (height > reqHeight || width > reqWidth) {
            val halfHeight = height / 2
            val halfWidth = width / 2

            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2
            }
        }
        return inSampleSize
    }
}
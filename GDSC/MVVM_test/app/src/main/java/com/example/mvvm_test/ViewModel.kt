package com.example.mvvm_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

package com.example.mvvm_test

import android.R
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.mvvm_test.databinding.ActivityMainBinding
import java.util.logging.Logger


class MainActivity : AppCompatActivity() {
    var binding // 상속 ViewDataBinding
            : ActivityMainBinding? = null
    var viewModel: ViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        Logger.d("Main_onCrete() 실행")
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        ) // Activity Content's View - Layout 연결 & 반환 : ViewDataBinding을 상속하는 제네릭 타입
        viewModel = ViewModel(Database.getInstance())
        binding.setViewModel(viewModel)
        binding.okBtnview.setOnClickListener(object : OnClickListener() {
            fun onClick(view: View?) {
                Logger.d("버튼 클릭")
                viewModel.getUser()
            }
        })
    }
}
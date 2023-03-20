package com.example.hello_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v) {      // 버튼이 눌렸을 때 동작하도록 함
        Toast.makeText(getApplicationContext(),"버튼이 눌렸어요.", Toast.LENGTH_LONG).show();      // 토스트 텍스트가 출력
    }

    public void onButton2Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));            // 네이버 모바일 창 열기
        startActivity(intent);
    }

}
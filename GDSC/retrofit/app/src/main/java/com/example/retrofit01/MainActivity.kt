package com.example.retrofit01

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofit01.ui.theme.Retrofit01Theme
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Retrofit01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}
object DataClass {          // 사이트에서 제공되는 데이터 모델을 코드로 구현한 부분
    data class VaccineBody(
        @SerializedName("currentCount") val currentCount: Int,   // 현재 검색된 데이터 수
        @SerializedName("data") val data: List<Vaccine>,         // 백신 현황 데이터
        @SerializedName("matchCount") val matchCount: Int,       // 검색과 일치하는 데이터 수
        @SerializedName("page") val page: Int,                   // 데이터 페이지
        @SerializedName("perPage") val perPage: Int,             // 한번에 불러올 데이터
        @SerializedName("totalCount") val totalCount: Int        // 데이터 전체 개수
    ) {
        override fun toString(): String {
            return "$data\n\n" +
                    "currentCount : $currentCount\n" +
                    "matchCount : $matchCount\n" +
                    "page : $page\n" +
                    "perPage : $perPage\n" +
                    "totalCount : $totalCount"
        }
        private fun getVaccineStatus() {

            RetrofitObject.getApiService().getInfo(
                1, 10
            ).enqueue(object : Callback<VaccineBody> {
                override fun onResponse(
                    call: Call<DataClass.VaccineBody>,
                    response: Response<DataClass.VaccineBody>
                ) {
                    setResponseText(response.code(), response.body())
                    Toast.makeText(baseContext, "success", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<DataClass.VaccineBody>, t: Throwable) {
                    Log.e("retrofit onFailure", "${t.printStackTrace()}")
                    Toast.makeText(baseContext, "fail", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    data class Vaccine(
        @SerializedName("accumulatedFirstCnt") val accumulatedFirstCnt: Int,     // 전일까지의 누적 통계 1차
        @SerializedName("accumulatedSecondCnt") val accumulatedSecondCnt: Int,   // 전일까지의 누적 통계 2차
        @SerializedName("baseDate") val baseDate: String,                        // 통계 기준일자
        @SerializedName("firstCnt") val firstCnt: Int,                           // 당일 통계 1차
        @SerializedName("secondCnt") val secondCnt: Int,                         // 당일 통계 2차
        @SerializedName("sido") val area: String,                                // 지역명칭
        @SerializedName("totalFirstCnt") val totalFirstCnt: Int,                 // 전체 누적 통계 1차
        @SerializedName("totalSecondCnt") val totalSecondCnt: Int                // 전체 누적 통계 2차
    ) {
        override fun toString(): String {
            return "Vaccine : [\n" +
                    "    accumulatedFirstCnt : ${accumulatedFirstCnt}\n" +
                    "    accumulatedSecondCnt : ${accumulatedSecondCnt}\n" +
                    "    baseDate : ${baseDate}\n" +
                    "    firstCnt : ${firstCnt}\n" +
                    "    secondCnt : ${secondCnt}\n" +
                    "    area : ${area}\n" +
                    "    totalFirstCnt : ${totalFirstCnt}\n" +
                    "    totalSecondCnt : ${totalSecondCnt}]\n\n"
        }
    }
}

interface ApiService {

    @GET("15077756/v1/vaccine-stat")        // @GET("")에 들어가는 부분은 BASE_URL 뒤에 나오는, 즉 데이터를 받아올 URL을 선언
    fun getInfo(
        @Query("page") Page: Int,           // @Query에는 API를 사용하기 위한 Parameter를 선언
        @Query("perPage") PerPage: Int,

        @Query("serviceKey") ServiceKey: String =
            "kigiqUVF/dUWrJa3YwQhUztfv7vGj05wsvDBfcXUH39jcHP7AQwYqD9ey4QcqD3FiApVohgsA53YdV9u2EVEmA=="
    ): Call<DataClass.VaccineBody>
}

object RetrofitObject {         // Retrofit을 사용하기 위해 Retrofit 객체를 생성
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.odcloud.kr/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService(): ApiService {
        return getRetrofit().create(ApiService::class.java)
    }
}\
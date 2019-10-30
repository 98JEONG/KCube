package com.example.kcube

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kcube.Data.User
import kotlinx.android.synthetic.main.activity_main.*

//로그인
class MainActivity : AppCompatActivity() {

    val defaultUser = User("김익명","abc123")
    val defaultPW = "5555"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickLogin(view: View?){
        //로그인 버튼 눌렀을 때
        var id = user_id.text.toString()
        var pw = user_pw.text.toString()
        if(id == defaultUser.id && pw == defaultPW){
            Toast.makeText(this,"환영합니다",Toast.LENGTH_SHORT).show()
            Thread.sleep(1000)//1초 sleep
            var intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)

        }else{
            Toast.makeText(this,"로그인 정보가 틀렸습니다",Toast.LENGTH_SHORT).show()
            user_id.text.clear()
            user_pw.text.clear()
        }
    }
}

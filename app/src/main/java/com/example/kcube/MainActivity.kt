package com.example.kcube

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"HELLO",Toast.LENGTH_SHORT).show()
        Log.d("돼나","ehlsmsrjsrk")
    }
}

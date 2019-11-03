package com.example.k_kube

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.kcube.CalendarActivity
import com.example.kcube.Data.Cube
import com.example.kcube.Data.MyDate
import com.example.kcube.Data.MyTime
import com.example.kcube.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import kotlinx.android.synthetic.main.activity_selection.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class selection : AppCompatActivity() {
    var nroom=0
    var row = 28
    var column = 3
    val tableIdCode = 1234
    var registeration = hashMapOf<Int, Int>()
    val tableLayout by lazy { TableLayout(this) }
    val tz = TimeZone.getTimeZone("Asia/Seoul")
    val gc = GregorianCalendar(tz)
    var hour = gc.get(GregorianCalendar.HOUR_OF_DAY).toString()
    var min = gc.get(GregorianCalendar.MINUTE).toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
        init()

    }
    fun init(){
        if(intent.hasExtra("building")){
           bname.text=intent.getStringExtra("building")
        }
        if(intent.hasExtra("nroom")){
           nroom=intent.getIntExtra("nroom",0)
        }
        val adapter = RoomAdapter(supportFragmentManager,nroom)
        val pager = findViewById<View>(R.id.roomPage) as ViewPager
        pager.adapter=adapter
        btn_register.setOnClickListener {
//            var frag1 = supportFragmentManager.findFragmentById(R.id.roomPage)
//            Log.d("fefefefefef",frag1.toString())
            Toast.makeText(this.applicationContext,"예약이 완료되었습니다.",Toast.LENGTH_SHORT).show()
            val selection = Intent(this,select_building::class.java)
            selection.putExtra("register", Cube("생명과학관", arrayListOf(MyDate(CalendarDay(2019,10,3), MyTime(21,0,21,30),true),MyDate(CalendarDay(2019,10,3), MyTime(22,0,22,30),true))))
            setResult(Activity.RESULT_OK,selection)
            finish()
            //startActivity(selection)
        }
    }

}



package com.example.k_kube

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kcube.CalendarActivity
import com.example.kcube.Data.Cube
import com.example.kcube.Data.MyDate
import com.example.kcube.Data.MyTime
import com.example.kcube.Data.User
import com.example.kcube.R
import com.example.kcube.ReservationActivity
import com.prolificinteractive.materialcalendarview.CalendarDay
import kotlinx.android.synthetic.main.activity_select_building.*

class select_building : AppCompatActivity() {

    lateinit var time:ArrayList<MyTime>
    lateinit var cube:ArrayList<Cube>
    lateinit var day:CalendarDay
    lateinit var user:User
    lateinit var checkCube:ArrayList<Cube>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_building)
        makeData()
    }

    fun makeData(){
        day = intent.getParcelableExtra("DAY") as CalendarDay
        user = intent.getParcelableExtra("USER") as User
        checkCube = arrayListOf()
        time = arrayListOf()
        var date = arrayListOf<MyDate>()
        var hour = 9
        for (i in 0..13){
            time.add(MyTime(hour,0,hour,30))
            if(hour+1!=23){
                time.add(MyTime(hour,30,hour+1,0))
            }
            hour++
        }
        for (i in 0..time.size-1){
            date.add(MyDate(day,time[i],false))
        }
        cube = arrayListOf()
        cube.add(Cube("공학관",date))
        cube.add(Cube("생명과학관",date))
        cube.add(Cube("상허연구관",date))
        cube.add(Cube("상허기념도서관",date))
        cube.add(Cube("상허기념 도서관 C&C Space",date))
        cube.add(Cube("동물생명과학관",date))
        cube.add(Cube("생명과학관 Startup Ground",date))
        cube.add(Cube("생명과학관 BIO Factory",date))
    }

    fun timeSelect(v:View){
        checkCube = arrayListOf()
            if(radiobutton01.isChecked){
                checkCube = cube
            }else {
                if (radiobutton02.isChecked) {
                    checkCube.add(cube[0])
                }
                if (radiobutton03.isChecked) {
                    checkCube.add(cube[1])
                }
                if (radiobutton04.isChecked) {
                    checkCube.add(cube[2])
                }
                if (radiobutton05.isChecked) {
                    checkCube.add(cube[3])
                }
                if (radiobutton06.isChecked) {
                    checkCube.add(cube[4])
                }
                if (radiobutton07.isChecked) {
                    checkCube.add(cube[5])
                }
                if (radiobutton08.isChecked) {
                    checkCube.add(cube[6])
                }
                if (radiobutton09.isChecked) {
                    checkCube.add(cube[7])
                }
            }
        if(checkCube.size <=0){
            //아무것도 선택되지 않았을 때
            Toast.makeText(this,"예약 건물을 체크하세요!",Toast.LENGTH_SHORT).show()
        }else{
            val selection = Intent(this,ReservationActivity::class.java)
               selection.putExtra("CUBE",checkCube)
               selection.putExtra("DAY",day)
              selection.putExtra("USER",user)
               startActivityForResult(selection,6666)
        }
    }
    fun init()
    {

        var user = intent.getParcelableExtra("USER") as User
//        val radio = mutableListOf<RadioButton>()
//        for(i in R.id.radiobutton01..R.id.radiobutton07){
//            radio.add(findViewById(i))
//        }
//        for(i in R.id.radiobutton01..R.id.radiobutton07){
//            val radio = findViewById<RadioButton>(i)
//            var nroom = 0
//            if(radio.text == "공학관") nroom = 8
//            else if(radio.text == "생명과학관") nroom = 7
//            if(radio.text == "상허연구관") nroom = 8
//            if(radio.text == "상허기념도서관") nroom = 6
//            if(radio.text == "상허기념도서관 C Space") nroom = 4
//            if(radio.text == "동물생명과학관") nroom = 5
//            radio.setOnCheckedChangeListener { buttonView, isChecked ->
//                val selection = Intent(this,selection::class.java)
//                selection.putExtra("building",radio.text)
//                selection.putExtra("nroom",nroom)
//                selection.putExtra("DAY",day)
//                selection.putExtra("USER",user)
//                startActivityForResult(selection,6666)
//            }
//        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 6666 && resultCode== Activity.RESULT_OK){
            var intent = Intent(this,CalendarActivity::class.java)
            intent.putExtra("register",data!!.getParcelableExtra("register") as Cube)
            Log.d("데이터",data!!.getParcelableExtra<Cube>("register").name)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}

package com.example.kcube

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.k_kube.select_building
import com.example.kcube.Adapter.ReservePagerAdapter
import com.example.kcube.Data.Cube
import com.example.kcube.Data.MyDate
import com.example.kcube.Data.MyTime
import com.example.kcube.Fragment.ReserveFragment
import com.prolificinteractive.materialcalendarview.CalendarDay
import kotlinx.android.synthetic.main.activity_reservation.*

class ReservationActivity : AppCompatActivity() {

    var MAX_PAGER = 8
    lateinit var mViewPager:ViewPager
    lateinit var fm:FragmentManager
    lateinit var fList:ArrayList<ReserveFragment>
    lateinit var bar:ActionBar
    lateinit var cube:ArrayList<Cube>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)
        init()
    }

    fun init(){
            fm = supportFragmentManager

        cube = arrayListOf()
        cube = intent.getParcelableArrayListExtra("CUBE")
        fList = arrayListOf()

        for(i in 0..cube.size-1){
            fList.add(ReserveFragment(cube[i]))
        }

        val fa = ReservePagerAdapter(fm,fList,cube)
        pager.adapter = fa

        tab.setupWithViewPager(pager)
    }

    fun ReserveOk(view: View){
        val selection = Intent(this,select_building::class.java)
        selection.putExtra("register", Cube("공학관 3호실", arrayListOf(
            MyDate(CalendarDay(2019,11,10), MyTime(12,30,13,0),true),
            MyDate(CalendarDay(2019,11,10), MyTime(13,0,13,30),true)
        )))
        setResult(Activity.RESULT_OK,selection)
        finish()
    }
}


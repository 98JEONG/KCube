package com.example.kcube

import android.graphics.Color
import android.os.Bundle
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import kotlinx.android.synthetic.main.activity_calendar.*
import java.util.*

//달력 겸 메인화면
class CalendarActivity : AppCompatActivity(){


    var t_month = 10
    var t_year = 2019

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        makeCalendar()
    }


    fun makeCalendar(){
        //getToday()
        //calendarView.setCurrentDate(Date(System.currentTimeMillis()))
        calendarView.addDecorators(
            SundayDecorator(),
            SaturdayDecorator(),
            OneDayDecorator()
        )

        calendarView.setOnDateChangedListener { widget, date, selected ->
            click_date.text = date.toString()
        }
    }

    class SundayDecorator:DayViewDecorator{

        var calendar = Calendar.getInstance()

        override fun shouldDecorate(day: CalendarDay?): Boolean {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            day!!.copyTo(calendar)
            var weekDay = calendar.get(Calendar.DAY_OF_WEEK)
            return weekDay == Calendar.SUNDAY
        }

        override fun decorate(view: DayViewFacade?) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            view!!.addSpan(ForegroundColorSpan(Color.RED))
        }

    }

    class SaturdayDecorator:DayViewDecorator{

        var calendar = Calendar.getInstance()

        override fun shouldDecorate(day: CalendarDay?): Boolean {
           // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            day!!.copyTo(calendar)
            var weekDay = calendar.get(Calendar.DAY_OF_WEEK)
            return weekDay == Calendar.SATURDAY
        }

        override fun decorate(view: DayViewFacade?) {
         //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            view!!.addSpan(ForegroundColorSpan(Color.RED))
        }

    }

    class OneDayDecorator:DayViewDecorator{

        var date:CalendarDay

        init{
            date = CalendarDay.today()
        }

        override fun shouldDecorate(day: CalendarDay?): Boolean {
           // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return date != null && day!!.equals(date)
        }


        override fun decorate(view: DayViewFacade?) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            view!!.addSpan(R.color.myGreen)
        }

        fun setDate(date:Date){
            this.date = CalendarDay.from(date)
        }

    }
}

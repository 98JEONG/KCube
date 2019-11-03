package com.example.k_kube

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.kcube.R
import kotlinx.android.synthetic.main.fragment_room_fragment1.*
import java.util.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RoomFragment1 : Fragment() {
    var nroom = 0
    var check = 0
    var row = 28
    var column = 3
    val tableIdCode = 1234
    var register = Array(row, { IntArray(column) })
    var map_register = hashMapOf<Int,Int>()
    val tableLayout by lazy { TableLayout(this.context) }
    val tz = TimeZone.getTimeZone("Asia/Seoul")
    val gc = GregorianCalendar(tz)
    var date = gc.get(GregorianCalendar.DAY_OF_MONTH).toString()
    var hour = gc.get(GregorianCalendar.HOUR_OF_DAY).toString()
    var min = gc.get(GregorianCalendar.MINUTE).toString()

    lateinit var linearLayout: LinearLayout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_room_fragment1, null)
        linearLayout = view.findViewById(R.id.table1)
        createTable(row, column, view)
        fill_table(view)
        return view
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun createTable(rows: Int, cols: Int, view: View) {
        var thour = 0
        var tminute = 0
        for (i in 0 until rows) {
            val row = TableRow(this.context)
            row.layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            for (j in 0 until cols) {
                val textview = TextView(this.context)
                var str: String
                var num = i.toString() + "," + j.toString()
                textview.apply {
                    layoutParams = TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                    )
                    textview.setBackgroundResource(R.drawable.border)
                    textview.width = 380
                    textview.height = 110
                    textview.setBackgroundResource(R.drawable.border)
                    str = "$i$j"
                    textview.setId(str.toInt())
                    Log.d("tvtv1", textview.id.toString())
                    if (i == 0) {
                        if (j == 0) textview.setText("1호실")
                        if (j == 1) textview.setText("2호실")
                        if (j == 2) textview.setText("3호실")
                        textview.textAlignment = View.TEXT_ALIGNMENT_CENTER
                    } else if (i != 0) {
                        if (i % 2 == 0) {
                            textview.text = (9 + i / 2 - 1).toString() + ":30"
                            thour = 9 + i / 2 - 1
                            tminute = 30
                            textview.textAlignment = View.TEXT_ALIGNMENT_CENTER
                        } else if (i % 2 == 1) {
                            textview.text = (9 + i / 2).toString() + ":00"
                            textview.textAlignment = View.TEXT_ALIGNMENT_CENTER
                            thour = 9 + i / 2
                            tminute = 0
                        }
                    }
                    if (thour < hour.toInt() || (thour == hour.toInt() && tminute < min.toInt())) {
                        register[i][j] = 2;
                        if (i != 0) textview.text = "x"
                    }
                }
                row.addView(textview)
            }
            tableLayout.addView(row)
            Toast.makeText(this.context, rows.toString(), Toast.LENGTH_LONG).show()
        }
        linearLayout.addView(tableLayout)
    }


    fun fill_table(view: View) {
        for (i in 0 until row) {
            for (j in 0 until column) {
                var str = "$i$j"
                var textview = view.findViewById<TextView>(str.toInt())
                if (i != 0) {
                    textview.setOnClickListener {
                        if (register[i][j] == 0) {
                            textview.setBackgroundColor(Color.GRAY)
                            register[i][j] = 1;
                            map_register.put(i,j)
                        } else if (register[i][j] == 1) {
                            textview.setBackgroundColor(Color.TRANSPARENT)
                            textview.setBackgroundResource(R.drawable.border)
                            register[i][j] = 0;
                            map_register.remove(i)
                        }
                    }
                }
            }
        }
    }

}





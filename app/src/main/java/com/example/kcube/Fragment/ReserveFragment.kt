package com.example.kcube.Fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kcube.Adapter.TimeTableAdapter
import com.example.kcube.Data.Cube
import com.example.kcube.R

/**
 * A simple [Fragment] subclass.
 */
class ReserveFragment : Fragment {

    var cube: Cube
    lateinit var room:ArrayList<String>
    lateinit var adapter:TimeTableAdapter
    lateinit var list :RecyclerView
    lateinit var v:View
    lateinit var layout:LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_reserve, container, false)
        v  = view
        init()
        makeFragment()

        return view
    }

    constructor(cube: Cube){
            this.cube = cube
        //init()
    }

    fun init(){
        room = arrayListOf()
        //호실 표현해줘야함
        when(cube.name){
            "공학관"->{
                for ( i in 1..8){
                    room.add(i.toString()+"호실")
                }
            }
            "생명과학관"->{
                for (i in 1..7){
                    room.add(i.toString()+"호실")
                }
            }
            "상허연구관"->{
                for (i in 1..8){
                    room.add(i.toString()+"호실")
                }
            }
            "상허기념도서관"->{
                for (i in 1..6){
                    room.add(i.toString()+"호실")
                }
            }
            "상허기념 도서관 C&C Space"->{
                room.add("M Studio")
                room.add("C&C space1")
                room.add("C&C space2")
                room.add("C&C space3")
            }
            "동물생명과학관"->{
                for (i in 1..5){
                    room.add(i.toString()+"호실")
                }
            }
            "생명과학관 Startup Ground"->{
                room.add("1호실")
                room.add("2호실")
                room.add("3호실")
                room.add("6호실")
            }
            "생명과학관 BIO Factory"->{
                room.add("BIO4")
            }
        }

    }


    fun makeFragment(){

        adapter = TimeTableAdapter(cube,v.context,room)
        Log.d("크기",adapter.toString())
        Log.d("크기",room.size.toString())
        list = v.findViewById<RecyclerView>(R.id.rList)
        Log.d("제목",room[0])
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(v.context)
    }
}

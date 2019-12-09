package com.example.kcube.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kcube.Data.Cube
import com.example.kcube.R

class TimeTableAdapter(var items:Cube, val context: Context, var titles:ArrayList<String>):RecyclerView.Adapter<TimeTableAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    //    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val v = LayoutInflater.from(parent.context).inflate(R.layout.timetable,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return titles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
   //     TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.title.text = titles[position]

        Log.d("뭐지","왜안불리지")
    }


    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var title:TextView
        var grid:GridLayout
        init{
            title = itemView.findViewById(R.id.cube_title)
            grid = itemView.findViewById(R.id.timeGrid)
        }
    }


}
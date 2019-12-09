package com.example.kcube.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kcube.Data.Cube
import com.example.kcube.Fragment.ReserveFragment

class ReservePagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    lateinit var cube:ArrayList<Cube>
    lateinit var fList:ArrayList<ReserveFragment>

    constructor(fm: FragmentManager , fList:ArrayList<ReserveFragment>,cube:ArrayList<Cube>) : this(fm) {
        this.cube = cube
        this.fList = fList
    }

    override fun getPageTitle(position: Int): CharSequence {
        return cube[position].name
    }

    override fun getItem(position: Int): Fragment {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        this.fList!!.get(position).rList.adapter = this.fList.get(position).adapter
      //  fList.get(position).makeAdapter()
        return this.fList!!.get(position)
    }

    override fun getCount(): Int {
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return this.fList.size
    }
}
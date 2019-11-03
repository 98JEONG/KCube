package com.example.k_kube

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class RoomAdapter(fm: FragmentManager, roomNumber:Int): FragmentPagerAdapter(fm) {
    var num = roomNumber
    override fun getCount(): Int {
        if (num > 6) return 3
        else return 2
    }

    override fun getItem(position: Int): Fragment {
        if (num > 6) {
            var fragment = RoomFragment3()
            var args = Bundle(1)
            args.putInt("roomNum", num % 3)
            fragment.arguments = args
            when (position) {
                0 -> return RoomFragment1()
                1 -> return RoomFragment2()
                else -> return fragment
            }
        } else {
            var fragment = RoomFragment2()
            var args = Bundle(1)
            args.putInt("roomNum", num % 3)
            fragment.arguments = args
            when (position) {
                0 -> return RoomFragment1()
                else -> return RoomFragment2()
            }
        }
    }
}







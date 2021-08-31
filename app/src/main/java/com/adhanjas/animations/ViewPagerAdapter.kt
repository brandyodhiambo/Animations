package com.adhanjas.animations

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class  ViewPagerAdapter(supportManager: FragmentManager): FragmentPagerAdapter(supportManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    private val fragmentList =ArrayList<Fragment>()
    private val fragmentTitles=ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
       return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitles[position]
    }

     fun addFragments(fragment: Fragment,title:String){
        fragmentList.add(fragment)
        fragmentTitles.add(title)
    }

}
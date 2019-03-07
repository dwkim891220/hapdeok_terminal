package com.example.hapdeok_terminal

import android.os.Bundle
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.app_bar_main.view.*


class MainActivity : BaseActivity(), MainActivityListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setLayouts()
        replaceFragment(SearchFragment.TAG)
    }

    private fun setLayouts(){
        setSupportActionBar(toolbar)
    }

    private fun replaceFragment(tag: String){
        val fragment = when (tag) {
            LineListFragment.TAG -> LineListFragment.newInstance()
            SearchFragment.TAG -> SearchFragment.newInstance()
            else -> return
        }

        showFragment(
            supportFragmentManager,
            R.id.fl_main_container,
            fragment,
            tag
        )
    }

    override fun showDetailFragment(lineId: Int, lineSubId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

interface MainActivityListener{
    fun showDetailFragment(lineId: Int, lineSubId: Int)
}
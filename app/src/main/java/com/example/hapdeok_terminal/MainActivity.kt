package com.example.hapdeok_terminal

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseActivity(), MainActivityListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setLayouts()
        replaceFragment(SearchFragment.TAG)
    }

    private fun setLayouts(){
        setSupportActionBar(toolbar)

        et_tb_search.run {
            addTextChangedListener(
                object : TextWatcher {
                    override fun afterTextChanged(p0: Editable?) {}
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                    override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        charSequence?.run {

                        }
                    }
                }
            )

            setOnFocusChangeListener(
                ({ _, focus ->
                    replaceFragment(
                        if(focus) {
                            SearchFragment.TAG
                        } else {
                            LineListFragment.TAG
                        }
                    )
                })
            )
        }
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
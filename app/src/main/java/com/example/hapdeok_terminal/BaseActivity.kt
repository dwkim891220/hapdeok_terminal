package com.example.hapdeok_terminal

import androidx.appcompat.app.AlertDialog.Builder
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

abstract class BaseActivity: AppCompatActivity(){
    var loadingDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createLoadingDialog()
    }

    private fun createLoadingDialog(){
        if(loadingDialog == null){
            loadingDialog = Builder(this).let { builder ->
                builder.setView(R.layout.layout_progress_bar)
                builder.create()
            }
        }
    }

    fun showLoading(show: Boolean){
        if(!isFinishing || !isDestroyed){
            if(show){
                loadingDialog?.show()
            }else{
                loadingDialog?.dismiss()
            }
        }
    }

    fun showFragment(
        fragmentManager: FragmentManager,
        container: Int,
        fragment: Fragment,
        tag: String? = null
    ){
        fragmentManager
            .beginTransaction()
            .run {
                replace(container, fragment, tag)
                commit()
            }
    }
}
package com.example.hapdeok_terminal

import androidx.appcompat.app.AlertDialog.Builder
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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
}
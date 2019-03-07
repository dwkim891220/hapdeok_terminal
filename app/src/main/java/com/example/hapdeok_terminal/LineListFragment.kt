package com.example.hapdeok_terminal

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class LineListFragment : Fragment() {
    companion object {
        val TAG = LineListFragment::class.java.simpleName

        fun newInstance(): LineListFragment =
            LineListFragment().apply {
                arguments = Bundle()
            }
    }

    private var listener: MainActivityListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MainActivityListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_line_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
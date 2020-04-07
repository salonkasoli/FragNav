package com.ncapdevi.sample.fragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import com.ncapdevi.sample.R

/**
 * Created by niccapdevila on 3/26/16.
 */
class FavoritesFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.wtf("lol", "FAV on create")
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.wtf("lol", "FAV on view created")
        super.onViewCreated(view, savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(
                        android.R.transition.fade
                )
            }
        }

        val et = view.findViewById<EditText>(R.id.edit_text)
        val cb = view.findViewById<CheckBox>(R.id.checkbox)

        val list = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            listOf<Pair<View, String>>(
                    Pair(et, et.transitionName),
                    Pair(cb, cb.transitionName)
            )
        } else {
            listOf()
        }

        btn.setOnClickListener {
            mFragmentNavigation.pushFragment(newInstance(mInt + 1), list)
        }
        btn.text = """${javaClass.simpleName} $mInt"""
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.wtf("lol", "FAV on destroy view created")
    }

    companion object {

        fun newInstance(instance: Int): FavoritesFragment {
            val args = Bundle()
            args.putInt(BaseFragment.ARGS_INSTANCE, instance)
            val fragment = FavoritesFragment()
            fragment.arguments = args
            return fragment
        }
    }
}

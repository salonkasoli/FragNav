package com.ncapdevi.sample.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.sample.activities.BottomTabsActivity
import com.ncapdevi.sample.activities.INDEX_FAVORITES
import com.ncapdevi.sample.activities.MainActivity

/**
 * Created by niccapdevila on 3/26/16.
 */
class NearbyFragment : BaseFragment() {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.wtf("lol", "NEAR on view created")
        val clearButton = Button(requireContext())
        clearButton.text = "Clear FAV stack"
        clearButton.setOnClickListener {
            (activity as BottomTabsActivity).fragNavController.clearStack(FragNavController.TAB2, fullyClearStack = true)
        }
        (view as ViewGroup).addView(clearButton)
        btn.setOnClickListener {
            mFragmentNavigation.pushFragment(NearbyFragment.newInstance(mInt + 1))
        }
        btn.text = """${javaClass.simpleName} $mInt"""
    }

    companion object {

        fun newInstance(instance: Int): NearbyFragment {
            val args = Bundle()
            args.putInt(BaseFragment.ARGS_INSTANCE, instance)
            val fragment = NearbyFragment()
            fragment.arguments = args
            return fragment
        }
    }
}

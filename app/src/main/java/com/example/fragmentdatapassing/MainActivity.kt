package com.example.fragmentdatapassing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), CommunicatorInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpFragmentOne()
        setUpFragmentTwo()
    }

    override fun passData(editTextInput: String) {
        val bundle =Bundle()
        bundle.putString("key_text",editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentTwo = FragmentTwo()
        fragmentTwo.arguments = bundle

        transaction.replace(R.id.fragmentContainerTwo, fragmentTwo)
        // transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit()
    }

    private fun setUpFragmentOne() {
        val fragmentOne = FragmentOne()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerOne, fragmentOne)
            .commit()
    }

    private fun setUpFragmentTwo() {
        val fragmentTwo = FragmentTwo()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerTwo, fragmentTwo)
            .commit()
    }
}
package com.example.fragmentdatapassing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FragmentTwo : Fragment() {

    var uiOutputText: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        uiOutputText = view.findViewById(R.id.uiOutputText)
        uiOutputText?.text = arguments?.getString(KEY_TEXT) ?: ""
    }
    companion object {
        const val KEY_TEXT = "key_text"
    }
}
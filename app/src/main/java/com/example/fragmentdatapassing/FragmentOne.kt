package com.example.fragmentdatapassing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class FragmentOne : Fragment() {

    private var communicator: CommunicatorInterface? = null
    private var uiButtonPass:Button? = null
    private var uiEtInputText: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_one, container, false) as ViewGroup
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi()
        setUpListeners()
    }

    private fun setUpUi() {
        uiButtonPass = view?.findViewById(R.id.uiButtonPass)
        uiEtInputText = view?.findViewById(R.id.uiEtInputText)
        communicator = activity as CommunicatorInterface
    }

    private fun setUpListeners() {
        uiButtonPass?.setOnClickListener {
            passDataToInterface()
        }
    }

    private fun passDataToInterface() {
        communicator?.passData(uiEtInputText?.text.toString())
    }
}
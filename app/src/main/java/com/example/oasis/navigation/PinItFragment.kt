package com.example.oasis.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.oasis.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PinItFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PinItFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pin_it, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageView>(R.id.home_icon_pinIt).setOnClickListener {

            val pinToMainFeed = PinItFragmentDirections.actionPinItFragmentToMainFeedFragment()
            findNavController().navigate(pinToMainFeed)
        }
        view.findViewById<ImageView>(R.id.profile_icon_pinIt).setOnClickListener {

            val pinToProfile = PinItFragmentDirections.actionPinItFragmentToProfileFragment()
            findNavController().navigate(pinToProfile)

        }
    }
}



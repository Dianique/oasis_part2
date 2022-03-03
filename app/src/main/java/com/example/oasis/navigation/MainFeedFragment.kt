package com.example.oasis.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oasis.R
import com.example.oasis.mainFeed.TravelFeedAdapter

import com.example.oasis.mainFeed.TravelStoriesData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFeedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFeedFragment : Fragment() {
    //  private val viewModel: MainFeedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_feed, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<ImageView>(R.id.main_pin_icon).setOnClickListener {

            val mainToPinItFragment =
                MainFeedFragmentDirections.actionMainFeedFragmentToPinItFragment3()
            findNavController().navigate(mainToPinItFragment)


        }

        view.findViewById<ImageView>(R.id.main_profile_icon).setOnClickListener {

            val mainToProfile = MainFeedFragmentDirections.actionMainFeedFragmentToProfileFragment()
            findNavController().navigate(mainToProfile)
        }
        val travelLists = mutableListOf(
            TravelStoriesData(R.drawable.amboseli, "Kenya", "Daniel's Oasis"),
            TravelStoriesData(R.drawable.barcelona, "Barcelona", "Max's Oasis")

        )

        val rV = view.findViewById<RecyclerView>(R.id.recycler_view)
        rV.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TravelFeedAdapter(travelLists)

        }
    }

}

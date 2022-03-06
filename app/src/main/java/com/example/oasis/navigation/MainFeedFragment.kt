package com.example.oasis.navigation

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oasis.R
import com.example.oasis.mainFeed.MainFeedViewModel
import com.example.oasis.mainFeed.TravelFeedAdapter


class MainFeedFragment : Fragment() {
    private val viewModel: MainFeedViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_feed, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<ImageView>(R.id.main_profile_icon).setOnClickListener {

            val mainToProfile =
                MainFeedFragmentDirections.actionMainFeedFragmentToProfileFragment()
            findNavController().navigate(mainToProfile)
        }

        view.findViewById<ImageView>(R.id.main_pin_icon).setOnClickListener {

            val mainToPinItFragment =
                MainFeedFragmentDirections.actionMainFeedFragmentToPinItFragment3()
            findNavController().navigate(mainToPinItFragment)


            val recyclerView =
                view.findViewById<RecyclerView>(R.id.recycler_view) //Find resource ID for recyclerView in display view.
         //   val adapter = TravelFeedAdapter(viewModel.mainList,
                object :
                    TravelFeedAdapter.onClickListner { //In the ItemAdaptor add parameters for the list data saved in the viewModel class and the object ItemAdaptor.

                    override fun itemViewClicked(position: Int) {
                        //   val clickedLineItem = viewModel.imageList[position] //This and following lines allow for each clicked item in the recyclerView list, and saved in the ViewModel, to be elected at a specific position and sent to FragmentTwo.
                        val directionals =
                            MainFeedFragmentDirections.actionMainFeedFragmentToProfileFragment()
                        view.findNavController().navigate(directionals)
                        viewModel.positionClicked = position
                    }
           //     })  //Pass in list to ItemAdapter and assign it to adapter variable.
         //   recyclerView.adapter = adapter //Bind the adapter to recyclerview to fill listed items.
         //   recyclerView.layoutManager = LinearLayoutManager(context) //The layoutManager positions the items correctly.
        //    recyclerView.setHasFixedSize(true)
            //Makes for better run performance when you set recyclerView to fixed size knowing content changes won't change layout size

        //    view.findViewById<Button>(R.id.share_post).setOnClickListener {
               val travelInfo = view.findViewById<EditText>(R.id.travel_info).text.toString()
         //       viewModel.mainList.add(travelInfo)
          //      Log.i("MainActivity", "data type")
          //      adapter.notifyDataSetChanged()//Notify adaptor of changes.

            }

        }

            }


    }




//view.findViewById<Button>(R.id.share_image).setOnClickListener{

//  val userInput = view.findViewById<EditText>(R.id.enter_task).text.toString() //Implement user inputted TO-Do items.
//  Log.i("MainActivity", "data type")
//   viewModel.typeList.add(userInput) //Append typelist list to the viewmodel and add in the user's inputted info.
//     adapter.notifyDataSetChanged()//Notify adaptor of changes.













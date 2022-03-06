package com.example.oasis.navigation

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oasis.R
import com.example.oasis.profileFeed.TravelProfileAdapter
import com.example.oasis.profileFeed.TravelProfileData


class ProfileFragment : Fragment() {
     private val REQUEST_IMAGE_CAPTURE = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<ImageView>(R.id.home_icon).setOnClickListener {
            val profileToMainFeed =
                ProfileFragmentDirections.actionProfileFragmentToMainFeedFragment()
            findNavController().navigate(profileToMainFeed)
        }
        view.findViewById<ImageView>(R.id.pin_icon).setOnClickListener {
            val profileToPinIt =
                ProfileFragmentDirections.actionProfileFragmentToPinItFragment2()
            findNavController().navigate(profileToPinIt)
        }

        val travelLists = mutableListOf(
           TravelProfileData(R.drawable.travelview,"location","description"),
            TravelProfileData(R.drawable.brownies,"location","description"),
            TravelProfileData(R.drawable.hamburger,"location","description"),
            TravelProfileData(R.drawable.italy,"location","description"),
            TravelProfileData(R.drawable.mexico,"location","description"),
            TravelProfileData(R.drawable.nepal,"location","description"),
            TravelProfileData(R.drawable.norway,"location","description"),
            TravelProfileData(R.drawable.phillipines,"location","description"),
            TravelProfileData(R.drawable.playground,"location","description"),
            TravelProfileData(R.drawable.rome,"location","description"),
            TravelProfileData(R.drawable.camping,"location","description"),
            TravelProfileData(R.drawable.amboseli,"location","description"),

            )

      val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.apply{
            layoutManager = GridLayoutManager(context,2)
             adapter = TravelProfileAdapter(travelLists)
             recyclerView.setHasFixedSize(true)
        }

          view.findViewById<ImageView>(R.id.camera_icon).setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
                Log.i("Images", "Camera profile")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            view?.findViewById<ImageView>(R.id.imageCapture)?.setImageBitmap(imageBitmap)
        }

    }

    }




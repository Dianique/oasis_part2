package com.example.oasis.navigation

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
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.oasis.R


class ProfileFragment : Fragment() {
    private val REQUEST_IMAGE_CAPTURE = 10


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

     //   val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)



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

        view.findViewById<ImageView>(R.id.camera_icon).setOnClickListener {
            Log.i("Images", "Pull up camera")
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
                // display error state to the user
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

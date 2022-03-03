package com.example.oasis.profileFeed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.oasis.R

class TravelProfileAdapter(
    private val imageProfileList: MutableList<Int>,
  ):
    RecyclerView.Adapter<TravelProfileAdapter.ImageViewHolder>() {


    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textView: TextView = view.findViewById(R.id.travelTitle)
        var textViewDesc: TextView = view.findViewById(R.id.travelDesc)
        val imageView: ImageView = view.findViewById(R.id.cameraImageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
       // method to setup a new Viewholder and its view - called by the recyclerView.
        val context = parent.context //tells the program what xml layout to use
        val inflater = LayoutInflater.from(context) //inflates the layout of the screen
        val adapterLayout = inflater.inflate(R.layout.profile_gridview, parent, false)
        return ImageViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.textView.text.toString()
        holder.textViewDesc.text.toString()


        holder.imageView.setImageResource(imageProfileList[position])
        }


    override fun getItemCount(): Int {
        return imageProfileList.size
    }
}


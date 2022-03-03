package com.example.oasis.mainFeed

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.oasis.R

class TravelFeedAdapter(private val imageMainList: MutableList<TravelStoriesData>,
  //  private val onClickListener: onClickListner
) :
    RecyclerView.Adapter<TravelFeedAdapter.ItemViewHolder>() {


    //interface onClickListner {
    //  fun itemViewClicked(position: Int)


    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {//create an inner class
        //Each individual element in the list is defined by a view holder object. When the view holder is created, it doesn't have any data associated with it.
        // After the view holder is created, the RecyclerView binds it to its data.
        // You define the view holder by extending RecyclerView.ViewHolder

        val travelName: TextView = view.findViewById(R.id.destination_name)
        val userName: TextView = view.findViewById(R.id.user_name)
        var destinationImage: ImageView = view.findViewById(R.id.destination_image)

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder.
        // Each data item is just an To-Do object.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // method to setup a new Viewholder and its view - called by the recyclerView.
        val context = parent.context //tells the program what xml layout to use
        val inflater = LayoutInflater.from(context) //inflates the layout of the screen
        val adapterLayout = inflater.inflate(R.layout.display_view, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int, ) { //onBindViewHolder called by recyclerView to bind data to Viewholder and fill in layout.

        val travel = imageMainList[position]
        holder.travelName.text = travel.travelLocation
        holder.userName.text = travel.traveler
        holder.destinationImage.setImageResource(travel.travelImage)
        //val resourceImage = getResources()



        //
        //  holder.destinationImage.setImageResource(images)
        Log.i("TravelFeedAdapter", "Prints to travel image")

        //  holder.itemView.setOnClickListener { //WILL NEED TO NAVIGATE FROM TRAVEL FEED TO PIN IT PAGES. When each recycler view line is clicked, the nav controller travels to fragmentTwo.
        //    onClickListener.itemViewClicked(position)
        //must create a holder, which serves as a wrapper for the views and return back To-Do (in its class) item that I named myData
        //typelist[position] helps to find the right TO-DO object from the dataset based on position/order
        // Log.i("ItemAdapter", "Prints to do")

        //   holder.itemView.setOnClickListener { //When each recycler view line is clicked, the nav controller travels to fragmentTwo.
        //       onClickListener.itemViewClicked(position)


    }

    override fun getItemCount(): Int {
        return imageMainList.size
    }
}





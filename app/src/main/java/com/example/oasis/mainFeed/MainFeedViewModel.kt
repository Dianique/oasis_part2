package com.example.oasis.mainFeed

import androidx.lifecycle.ViewModel

class MainFeedViewModel: ViewModel() {
var positionClicked = -1

val imageList = mutableListOf<Int>()

//Create a ViewModel class to save your data in state. The inputted tasks delete when you navigate
//between screens. For this reason ViewModel class is needed.
    //From your FragmentOne screen: Carry each clicked item in the list (typelist val)
    // and the position (positionClicked var) from the recyclerView here to be saved in memory.
}
package com.example.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender


class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
    //Glide is used here to load the images
        CatAdapter(layoutInflater, GlideImageLoader(this), object:
            CatAdapter.OnClickListener {
            //When this is triggered, the pop up dialog will be shown
            override fun onClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter
        //Setup the layout manager for the recycler view
        //A layout manager is used to set the structure of the item views
        //For this tutorial, we're using the vertical linear structure
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        //Add data to the model list in the adapter
        //Instantiate ItemTouchHelper for the swipe to delete callback and
        //attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.BritishShorthair,
                    "Tom",
                    "Lazy but loyal",
                    "https://cdn2.thecatapi.com/images/BborJBuoW.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.AmericanCurl,
                    "Luna",
                    "Loves chasing shadows",
                    "https://cdn2.thecatapi.com/images/kdfcmTWJL.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Simba",
                    "King of the couch",
                    "https://cdn2.thecatapi.com/images/13MkvUreZ.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Sphynx,
                    "Misty",
                    "Always curious",
                    "https://cdn2.thecatapi.com/images/cIFwPWy84.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Oliver",
                    "Purr machine",
                    "https://cdn2.thecatapi.com/images/s_SbQ3Xju.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BritishLonghair,
                    "Nala",
                    "Smart and calm",
                    "https://cdn2.thecatapi.com/images/7isAO4Cav.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.Bengal,
                    "Shadow",
                    "Silent observer",
                    "https://cdn2.thecatapi.com/images/8RsP7Xt3h.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BalineseJavanese,
                    "Dora",
                    "Clingy cat",
                    "https://cdn2.thecatapi.com/images/4ndvXwCiI.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.AmericanCurl,
                    "Bubu",
                    "Brave and playful",
                    "https://cdn2.thecatapi.com/images/ZZmFRKWZZ.jpg"
                )
            )
        )
    }

    //This will create a pop up dialog when one of the items from the recycler view is clicked.
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
    //Set the title for the dialog
            .setTitle("Cat Selected")
    //Set the message for the dialog
            .setMessage("You have selected cat ${cat.name}")
    //Set if the OK button should be enabled
            .setPositiveButton("OK") { _, _ -> }.show()
    }

}

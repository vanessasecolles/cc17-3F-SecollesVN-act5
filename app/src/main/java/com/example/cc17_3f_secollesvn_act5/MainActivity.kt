package com.example.cc17_3f_secollesvn_act5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Array of images and their descriptions
    private val images = arrayOf(
        R.drawable.art_image1,
        R.drawable.art_image2,
        R.drawable.art_image3,
        R.drawable.art_image4,
        R.drawable.art_image5
    )

    private val descriptions = arrayOf(
        "My first Elephant Encounter",
        "My first meeting with Giraffes",
        "Cozy moment bonding with my three affectionate Cats",
        "A delightful moment feeding treats to three eager Corgis",
        "A picture-perfect moment of my two Japanese Spitz dogs posing adorably together"
    )

    private var currentImageIndex = 0  // Keeps track of the current image index

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the ImageView, TextView, and buttons by their IDs
        val imageView: ImageView = findViewById(R.id.imageView)
        val imageDescription: TextView = findViewById(R.id.imageDescription)
        val nextButton: Button = findViewById(R.id.nextButton)
        val prevButton: Button = findViewById(R.id.prevButton)

        // Set initial image and description
        imageView.setImageResource(images[currentImageIndex])
        imageDescription.text = descriptions[currentImageIndex]

        // Set onClickListener for the "Next" button
        nextButton.setOnClickListener {
            val isLastImage = currentImageIndex == images.size - 1  // Boolean to check if it's the last image

            when {
                !isLastImage -> {
                    currentImageIndex++
                    imageView.setImageResource(images[currentImageIndex])
                    imageDescription.text = descriptions[currentImageIndex]
                }
                else -> Toast.makeText(this, "This is the last image", Toast.LENGTH_SHORT).show()
            }
        }

        // Set onClickListener for the "Previous" button
        prevButton.setOnClickListener {
            val isFirstImage = currentImageIndex == 0  // Boolean to check if it's the first image

            when {
                !isFirstImage -> {
                    currentImageIndex--
                    imageView.setImageResource(images[currentImageIndex])
                    imageDescription.text = descriptions[currentImageIndex]
                }
                else -> Toast.makeText(this, "This is the first image", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
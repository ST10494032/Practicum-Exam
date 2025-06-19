package za.co.varsity.st10494032.practicumexam

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivityDetailedViews : AppCompatActivity() {

    private lateinit var playlist: List<MainActivity.Songs>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_detailed_views)

        playlist = intent.getParcelableArrayListExtra("Playlist") ?: emptyList()

        // Buttons and TextView
        val showSongsButton = findViewById<Button>(R.id.showSongsButton)
        val showAverageRatingButton = findViewById<Button>(R.id.averageRatingButton)
        val returnToMainButton = findViewById<Button>(R.id.returnButton)
        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)

        // Display the list of songs
        showSongsButton.setOnClickListener {
            val songDetails = playlist.joinToString("\n") { song ->
                "Title: ${song.title}, Artist: ${song.artist}, Rating: ${song.rating}"
            }
            resultsTextView.text = songDetails
        }

        // Calculate and display the average rating
        showAverageRatingButton.setOnClickListener {
            if (playlist.isNotEmpty()) {
                val totalRating = playlist.sumOf { it.rating }
                val averageRating = totalRating / playlist.size.toDouble()
                resultsTextView.text = "Average Rating: %.2f".format(averageRating)
            } else {
                Toast.makeText(this, "No songs in the playlist", Toast.LENGTH_SHORT).show()
            }
        }

        // Return to the main screen
        returnToMainButton.setOnClickListener {
            finish()  // Finish this activity and return to MainActivity
        }
    }
}
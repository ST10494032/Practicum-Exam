package za.co.varsity.st10494032.practicumexam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {

    data class Songs(
        val title: String,
        val artist: String,
        val rating: Int
    )

    private val playlist = mutableListOf<Songs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge to edge
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_main)

        // finding Buttons
        val addToPlaylistButton = findViewById<Button>(R.id.addToPlaylistButton)
        val detailedViewingButton = findViewById<Button>(R.id.detailedViewingButton)
        val exitAppButton = findViewById<Button>(R.id.exitAppButton)

        // Add songs to playlist
        addToPlaylistButton.setOnClickListener {
            playlist.add(Songs("Shape of You", "Ed Sheeran", 5))
            playlist.add(Songs("Blinding Lights", "The Weekend", 4))
            playlist.add(Songs("Levitating", "Dua Lipa", 5))
            playlist.add(Songs("Stay", "Justin Bieber", 4))
            playlist.add(Songs("Save Your Tears", "The Weekend", 3))

            Toast.makeText(this, "5 Songs added to playlist", Toast.LENGTH_SHORT).show()
        }

        // View detailed song list
        detailedViewingButton.setOnClickListener {
            val intent = Intent(this, MainActivityDetailedViews::class.java)
            startActivity(intent)
        }

        // Exit app
        exitAppButton.setOnClickListener {
            finish() // Close the app
        }
    }
}

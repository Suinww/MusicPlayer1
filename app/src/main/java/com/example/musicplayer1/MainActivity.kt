package com.example.musicplayer1


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicplayer1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlay.setOnClickListener { musicPlay() }
        binding.btnStop.setOnClickListener { musicStop() }
        binding.btnPause.setOnClickListener { musicPause() }
    }
    private fun musicPlay(){
        val intent = Intent(this, MediaPlayerService::class.java)
            .apply { action=MEDIA_PLAYER_PLAY }
        startService(intent)
    }
    private fun musicStop(){
        val intent = Intent(this, MediaPlayerService::class.java)
            .apply { action=MEDIA_PLAYER_STOP }
        startService(intent)
    }
    private fun musicPause(){
        val intent = Intent(this, MediaPlayerService::class.java)
            .apply { action=MEDIA_PLAYER_PAUSE }
        startService(intent)
    }

}
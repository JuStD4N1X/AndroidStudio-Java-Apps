package com.example.audiowideo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer audioPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAudio = findViewById(R.id.btnAudio);
        VideoView videoView = findViewById(R.id.videoView);

        // --- AUDIO HANDLING ---
        btnAudio.setOnClickListener(v -> {
            if (audioPlayer == null) {
                // Load the music.mp3 file from the res/raw folder
                audioPlayer = MediaPlayer.create(this, R.raw.bong);
            }

            // Simple toggle: play / pause
            if (audioPlayer.isPlaying()) {
                audioPlayer.pause();
                btnAudio.setText("🎵 Play Music (MP3)");
            } else {
                audioPlayer.start();
                btnAudio.setText("⏸ Pause Music");
            }
        });

        // --- VIDEO HANDLING ---
        // Build the path to the film.mp4 file in the raw folder
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.prop;
        videoView.setVideoPath(videoPath);

        // Show the first frame without playing
        videoView.setOnPreparedListener(mp -> videoView.seekTo(1));

        MediaController controller = new MediaController(this);
        controller.setAnchorView(videoView);
        videoView.setMediaController(controller);

    }

    // free the memory when the app is stopped
    @Override
    protected void onStop() {
        super.onStop();
        if (audioPlayer != null) {
            audioPlayer.release();
            audioPlayer = null;
        }
    }
}
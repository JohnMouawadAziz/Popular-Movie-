package com.gmail.aziz.mouawad.john.johnmovieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeTrailar extends YouTubeBaseActivity {

    String YOUTUBE;

    YouTubePlayerView youTubePlayerView;
    Button button;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_trailar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        button= (Button) findViewById(R.id.bn);
        youTubePlayerView= (YouTubePlayerView) findViewById(R.id.yutube_player_view);

        Intent intent = getIntent();
        YOUTUBE = intent.getStringExtra("youtube_Key");
        onInitializedListener=new YouTubePlayer.OnInitializedListener(){

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo(YOUTUBE);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {



            }
        };
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(PlayerConfig.API_KEY,onInitializedListener);
            }
        });

    }

}

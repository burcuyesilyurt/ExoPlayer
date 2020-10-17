package com.example.workshop;

//import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;


public class MainActivity extends Activity {

    private PlayerView playerView;
    private TextView resolutionTextView;
    DataSource mediaDataSource;
    DataSource.Factory mediaDataSourceFactory;
    SimpleExoPlayer player;
    private String hlsVideoUri = "https://bitdash-a.akamaihd.net/content/sintel/hls/playlist.m3u8";
    HlsMediaSource mediaSource;
  //  SubtitleView subtitleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        playerView =(PlayerView)findViewById(R.id.playerView);
        player = ExoPlayerFactory.newSimpleInstance(this);


        mediaDataSourceFactory =
                new DefaultDataSourceFactory(this, Util.getUserAgent(this, "ExoPlayerDemo"));

       mediaSource = new HlsMediaSource.Factory(mediaDataSourceFactory).createMediaSource(Uri.parse(hlsVideoUri));

        // player'ı hazır hale getirme
        player.prepare(mediaSource, false, false);

        // play oynatılmaya hazır olduğunda video oynatma islemi
        player.setPlayWhenReady(true);

        // loyout dosyasındaki id degeri eslestirme
        playerView.setPlayer(player);

        // player ekranına focuslanma ozelligi
        playerView.requestFocus();


    }
}

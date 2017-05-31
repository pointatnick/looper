package pointatnick.looper;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class MainActivity extends Activity {

  private RelativeLayout rl;
  private VideoView vv;

  // handler for runnable GifActivity
  final Handler handler = new Handler();

  // runnable GifActivity
  Runnable startGif = new Runnable() {
    public void run() {
      Intent i = new Intent(MainActivity.this, GifActivity.class);
      startActivity(i);
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // attach RelativeLayout from activity_main

    rl = (RelativeLayout) findViewById(R.id.rel_layout);

    // note: VideoView cannot read clicks, so can't use OnLongClickListener
    // track clicks with relative layout instead
    rl.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View v) {
        handler.post(startGif);
        return true;
      }
    });

    // attach VideoView from activity_main
    vv = (VideoView) findViewById(R.id.video_view);

    // set video to loop
    vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
      @Override
      public void onPrepared(MediaPlayer mp) {
        mp.setLooping(true);
      }
    });
  }

  @Override
  public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
    if (hasFocus) {
      // set VideoView to be fullscreen
      vv.setSystemUiVisibility(
              View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                      | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                      | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                      | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                      | View.SYSTEM_UI_FLAG_FULLSCREEN
                      | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

      // grab video file from res/raw and play
      String path = "android.resource://" + getPackageName() + "/" + R.raw.video;
      vv.setVideoURI(Uri.parse(path));
      vv.start();
    }
  }
}
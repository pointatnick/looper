package pointatnick.looper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
    if (hasFocus) {
      // create VideoView
      VideoView vv = (VideoView) findViewById(R.id.video_view);

      // set fullscreen
      vv.setSystemUiVisibility(
              View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                      | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                      | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                      | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                      | View.SYSTEM_UI_FLAG_FULLSCREEN
                      | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

      // create OnLongClickListener
      View.OnLongClickListener listener = new View.OnLongClickListener() {
        public boolean onLongClick(View v) {
          // start GifActivity on long click
          Intent i = new Intent(MainActivity.this, GifActivity.class);
          startActivity(i);
          return true;
        }
      };

      // attach listener to VideoView
      vv.setOnLongClickListener(listener);

      // grab video file from res/raw and play
      String path = "android.resource://" + getPackageName() + "/" + R.raw.video;
      vv.setVideoURI(Uri.parse(path));
      vv.start();
    }
  }
}
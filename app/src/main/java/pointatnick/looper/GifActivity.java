package pointatnick.looper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import pl.droidsonroids.gif.GifImageView;

public class GifActivity extends Activity {

  // set timeout for GifActivity
  private static int TIMEOUT = 5000;
  private GifImageView giv;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_gif);

    giv = (GifImageView) findViewById(R.id.gif_view);
  }

  @Override
  public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
    if (hasFocus) {

      // set gif to be fullscreen
      giv.setSystemUiVisibility(
              View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                      | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                      | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                      | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                      | View.SYSTEM_UI_FLAG_FULLSCREEN
                      | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }
  }
}

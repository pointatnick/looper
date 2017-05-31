package pointatnick.looper;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;
import android.view.View;

import pl.droidsonroids.gif.GifImageView;

public class GifActivity extends Activity {

  // set timeout for GifActivity
  private static int TIMEOUT = 5000;

  private GifImageView giv;

  // handler to finish GifActivity
  final Handler handler = new Handler();
  Runnable finishGif = new Runnable() {
    public void run() {
      finishAfterTransition();
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_gif);
    setupWindowAnimations();
    setupGifImageView();

    // start timer
    handler.postDelayed(finishGif, TIMEOUT);
  }

  /**********
   * Functions to set up activity elements
   **********/

  private void setupWindowAnimations() {
    Fade fade = new Fade();
    fade.setDuration(1000);
    getWindow().setExitTransition(fade);
  }

  private void setupGifImageView() {
    // attach GifImageView from activity_gif
    giv = (GifImageView) findViewById(R.id.gif_view);

    // set GifImageView to be fullscreen
    giv.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
  }
}

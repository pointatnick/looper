package pointatnick.looper;

import android.app.Activity;
import android.os.Bundle;

public class GifActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_gif);
  }

  @Override
  public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
    if (hasFocus) {
      // start timer for 5 seconds, then end activity

    }
  }
}

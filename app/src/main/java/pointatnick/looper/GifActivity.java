package pointatnick.looper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

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
      // create ImageView and set GIF as resource
      ImageView i = (ImageView) findViewById(R.id.gif_view);
      i.setImageResource(R.drawable.cat);
    }
  }
}

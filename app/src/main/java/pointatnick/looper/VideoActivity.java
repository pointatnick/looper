package pointatnick.looper;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_video);

    VideoView v = (VideoView) findViewById(R.id.video_view);
    String path = "android.resource://" + getPackageName() + "/" + R.raw.video;
    v.setVideoURI(Uri.parse(path));
    v.start();
  }
}
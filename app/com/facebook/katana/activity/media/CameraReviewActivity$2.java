package com.facebook.katana.activity.media;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;

class CameraReviewActivity$2
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    CameraReviewActivity.c(this.a).setVisibility(0);
    CameraReviewActivity.c(this.a).bringToFront();
    CameraReviewActivity.d(this.a).setVisibility(0);
    CameraReviewActivity.d(this.a).bringToFront();
    CameraReviewActivity.e(this.a).setVisibility(0);
    CameraReviewActivity.f(this.a).setVisibility(8);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CameraReviewActivity.2
 * JD-Core Version:    0.6.0
 */
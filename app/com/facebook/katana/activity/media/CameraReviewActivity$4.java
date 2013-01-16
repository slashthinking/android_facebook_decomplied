package com.facebook.katana.activity.media;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;
import com.facebook.photos.analytics.PhotoFlowLogger;

class CameraReviewActivity$4
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!CameraReviewActivity.f(this.a).isPlaying())
    {
      CameraReviewActivity.g(this.a).i();
      CameraReviewActivity.f(this.a).setVisibility(0);
      CameraReviewActivity.f(this.a).start();
      CameraReviewActivity.c(this.a).setVisibility(8);
      CameraReviewActivity.e(this.a).setVisibility(8);
    }
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CameraReviewActivity.4
 * JD-Core Version:    0.6.0
 */
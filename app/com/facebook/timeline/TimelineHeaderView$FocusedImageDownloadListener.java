package com.facebook.timeline;

import android.graphics.drawable.Drawable;
import com.facebook.widget.UrlImage;
import com.facebook.widget.UrlImage.OnImageDownloadListener;

class TimelineHeaderView$FocusedImageDownloadListener
  implements UrlImage.OnImageDownloadListener
{
  private final UrlImage a;
  private final int b;
  private final int c;
  private final double d;
  private final double e;

  public TimelineHeaderView$FocusedImageDownloadListener(UrlImage paramUrlImage, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2)
  {
    this.a = paramUrlImage;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramDouble1;
    this.e = paramDouble2;
  }

  public void a(Drawable paramDrawable)
  {
    TimelineHeaderView.a(this.a, this.b, this.c, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), this.d, this.e);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineHeaderView.FocusedImageDownloadListener
 * JD-Core Version:    0.6.0
 */
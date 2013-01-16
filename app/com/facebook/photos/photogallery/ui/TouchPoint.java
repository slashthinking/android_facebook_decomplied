package com.facebook.photos.photogallery.ui;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.widget.ViewTransform;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class TouchPoint extends ImageView
{
  private ViewTransform a;
  private ViewPropertyAnimator b;

  public TouchPoint(Context paramContext)
  {
    this(paramContext, null);
  }

  public TouchPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundResource(2130838992);
    this.a = new ViewTransform(this);
    this.b = ViewPropertyAnimator.a(this);
    this.b.a(200L);
    a(false);
  }

  public void a(PointF paramPointF)
  {
    this.a.setTranslationX(paramPointF.x - getWidth() / 2);
    this.a.setTranslationY(paramPointF.y - getHeight() / 2);
    this.a.setAlpha(1.0F);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      this.b.d(0.0F);
    while (true)
    {
      return;
      this.a.setAlpha(0.0F);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.ui.TouchPoint
 * JD-Core Version:    0.6.0
 */
package com.facebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;

public class GalleryWithSwipingFix extends Gallery
{
  private Runnable a;
  private long b;
  private boolean c;

  public GalleryWithSwipingFix(Context paramContext)
  {
    super(paramContext);
  }

  public GalleryWithSwipingFix(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public GalleryWithSwipingFix(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a()
  {
    if (this.a != null);
    while (true)
    {
      return;
      this.a = new GalleryWithSwipingFix.1(this);
      postDelayed(this.a, 250L);
    }
  }

  private void b()
  {
    if ((System.currentTimeMillis() - this.b > 250L) && (!this.c))
      requestLayout();
    while (true)
    {
      return;
      a();
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((System.currentTimeMillis() - this.b > 250L) && (!this.c))
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    while (true)
    {
      return;
      a();
    }
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = System.currentTimeMillis();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0);
    for (this.c = true; ; this.c = false)
      do
        return super.onTouchEvent(paramMotionEvent);
      while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.GalleryWithSwipingFix
 * JD-Core Version:    0.6.2
 */
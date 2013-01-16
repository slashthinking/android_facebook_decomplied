package com.facebook.photos.photogallery;

import android.content.Context;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

public class ZoomableViewPager extends ViewPager
{
  private boolean a = true;

  public ZoomableViewPager(Context paramContext)
  {
    this(paramContext, null);
  }

  public ZoomableViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnPageChangeListener(new ZoomableViewPager.1(this));
  }

  private PhotoFragment getCurrentPhotoFragment()
  {
    return (PhotoFragment)((FragmentStatePagerAdapter)getAdapter()).a(this, getCurrentItem());
  }

  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ImageViewTouch));
    for (boolean bool = ((ImageViewTouch)paramView).a(paramInt1); ; bool = super.a(paramView, paramBoolean, paramInt1, paramInt2, paramInt3))
      return bool;
  }

  public void j()
  {
    this.a = true;
  }

  public void k()
  {
    this.a = false;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a);
    for (boolean bool = super.onInterceptTouchEvent(paramMotionEvent); ; bool = false)
      return bool;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a);
    for (boolean bool = super.onTouchEvent(paramMotionEvent); ; bool = false)
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.ZoomableViewPager
 * JD-Core Version:    0.6.0
 */
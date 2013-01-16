package com.facebook.orca.common.ui.util;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;

public class CompoundTouchDelegate extends TouchDelegate
{
  private final TouchDelegate[] a;

  public CompoundTouchDelegate(View paramView, TouchDelegate[] paramArrayOfTouchDelegate)
  {
    super(new Rect(), paramView);
    this.a = paramArrayOfTouchDelegate;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    TouchDelegate[] arrayOfTouchDelegate = this.a;
    int i = arrayOfTouchDelegate.length;
    for (int j = 0; ; j++)
    {
      int k = 0;
      if (j < i)
      {
        if (!arrayOfTouchDelegate[j].onTouchEvent(paramMotionEvent))
          continue;
        k = 1;
      }
      return k;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.util.CompoundTouchDelegate
 * JD-Core Version:    0.6.0
 */
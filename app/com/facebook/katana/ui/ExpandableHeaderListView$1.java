package com.facebook.katana.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.common.util.HeightAnimation;

class ExpandableHeaderListView$1
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = ExpandableHeaderListView.a(this.a);
    int i = 0;
    if (!bool);
    while (true)
    {
      return i;
      switch (paramMotionEvent.getAction())
      {
      default:
        i = 0;
        break;
      case 0:
        ExpandableHeaderListView.b(this.a).clearAnimation();
        ExpandableHeaderListView.c(this.a).reset();
        i = 0;
        break;
      case 1:
        ExpandableHeaderListView.a(this.a, -1.0F);
        int i2 = ExpandableHeaderListView.b(this.a).getHeight();
        int i3 = ExpandableHeaderListView.d(this.a);
        i = 0;
        if (i2 <= i3)
          continue;
        ExpandableHeaderListView.b(this.a).startAnimation(ExpandableHeaderListView.c(this.a));
        i = 0;
        break;
      case 2:
        int j = this.a.getFirstVisiblePosition();
        i = 0;
        if (j != 0)
          continue;
        int k = ExpandableHeaderListView.b(this.a).getTop();
        i = 0;
        if (k != 0)
          continue;
        if (ExpandableHeaderListView.e(this.a) < 0.0F)
          ExpandableHeaderListView.a(this.a, paramMotionEvent.getRawY());
        float f1 = paramMotionEvent.getRawY() - ExpandableHeaderListView.e(this.a);
        float f2 = 0.6F + 0.4F * ((ExpandableHeaderListView.f(this.a) - f1) / ExpandableHeaderListView.f(this.a));
        float f3 = ExpandableHeaderListView.d(this.a) + f1 * f2;
        int m = (int)Math.max(ExpandableHeaderListView.d(this.a), Math.min(f3, ExpandableHeaderListView.f(this.a)));
        int n = ExpandableHeaderListView.b(this.a).getHeight();
        ExpandableHeaderListView.b(this.a).getLayoutParams().height = m;
        ExpandableHeaderListView.b(this.a).requestLayout();
        if (m > ExpandableHeaderListView.d(this.a))
        {
          if (n == ExpandableHeaderListView.d(this.a))
          {
            MotionEvent localMotionEvent2 = MotionEvent.obtain(paramMotionEvent);
            localMotionEvent2.setAction(3);
            this.a.onTouchEvent(localMotionEvent2);
          }
          i = 1;
          continue;
        }
        int i1 = ExpandableHeaderListView.d(this.a);
        i = 0;
        if (m != i1)
          continue;
        i = 0;
        if (m >= n)
          continue;
        MotionEvent localMotionEvent1 = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent1.setAction(0);
        this.a.onTouchEvent(localMotionEvent1);
        i = 0;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.ExpandableHeaderListView.1
 * JD-Core Version:    0.6.0
 */
package com.facebook.feed.ui;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;

public class ScrollerRunnable
  implements Runnable
{
  private ListView a;
  private int b;
  private int c;
  private int d;
  private int e;
  private final int f;

  public ScrollerRunnable(ListView paramListView)
  {
    this.a = paramListView;
    this.f = ViewConfiguration.get(this.a.getContext()).getScaledFadingEdgeLength();
  }

  public void a()
  {
    this.a.removeCallbacks(this);
  }

  public void a(int paramInt)
  {
    a();
    int i = this.a.getFirstVisiblePosition();
    int j = -1 + (i + this.a.getChildCount());
    int k;
    if (paramInt <= i)
    {
      k = 1 + (i - paramInt);
      this.b = 2;
      if (k <= 0)
        break label96;
    }
    label96: for (this.e = (400 / k); ; this.e = 400)
    {
      this.c = paramInt;
      this.d = -1;
      this.a.post(this);
      do
        return;
      while (paramInt < j);
      k = 1 + (paramInt - j);
      this.b = 1;
      break;
    }
  }

  public void run()
  {
    int i = this.a.getHeight();
    int j = this.a.getFirstVisiblePosition();
    switch (this.b)
    {
    default:
    case 1:
    case 2:
    }
    View localView1;
    do
    {
      while (true)
      {
        return;
        int n = -1 + this.a.getChildCount();
        int i1 = j + n;
        if (n < 0)
          continue;
        if (i1 == this.d)
        {
          this.a.post(this);
          continue;
        }
        View localView2 = this.a.getChildAt(n);
        int i2 = localView2.getHeight();
        int i3 = i - localView2.getTop();
        if (i1 < -1 + this.a.getCount());
        for (int i4 = this.f; ; i4 = this.a.getPaddingBottom())
        {
          this.a.smoothScrollBy(i4 + (i2 - i3), this.e);
          this.d = i1;
          if (i1 >= this.c)
            break;
          this.a.post(this);
          break;
        }
        if (j != this.d)
          break;
        this.a.post(this);
      }
      localView1 = this.a.getChildAt(0);
    }
    while (localView1 == null);
    int k = localView1.getTop();
    if (j > 0);
    for (int m = this.f; ; m = this.a.getPaddingTop())
    {
      this.a.smoothScrollBy(k - m, this.e);
      this.d = j;
      if (j <= this.c)
        break;
      this.a.post(this);
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.ScrollerRunnable
 * JD-Core Version:    0.6.0
 */
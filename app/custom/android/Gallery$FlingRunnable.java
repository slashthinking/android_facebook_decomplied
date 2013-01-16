package custom.android;

import android.widget.Scroller;

class Gallery$FlingRunnable
  implements Runnable
{
  private Scroller b;
  private int c;

  public Gallery$FlingRunnable(Gallery paramGallery)
  {
    this.b = new Scroller(paramGallery.getContext());
  }

  private void a()
  {
    this.a.removeCallbacks(this);
  }

  private void b(boolean paramBoolean)
  {
    this.b.forceFinished(true);
    if (paramBoolean)
      Gallery.c(this.a);
  }

  public void a(int paramInt)
  {
    if (paramInt == 0)
      return;
    a();
    if (paramInt < 0);
    for (int i = 2147483647; ; i = 0)
    {
      this.c = i;
      this.b.fling(i, 0, paramInt, 0, 0, 2147483647, 0, 2147483647);
      this.a.post(this);
      break;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.a.removeCallbacks(this);
    b(paramBoolean);
  }

  public void b(int paramInt)
  {
    if (paramInt == 0);
    while (true)
    {
      return;
      a();
      this.c = 0;
      this.b.startScroll(0, 0, -paramInt, 0, Gallery.b(this.a));
      this.a.post(this);
    }
  }

  public void run()
  {
    if (this.a.A == 0)
      b(true);
    while (true)
    {
      return;
      Gallery.b(this.a, false);
      Scroller localScroller = this.b;
      boolean bool = localScroller.computeScrollOffset();
      int i = localScroller.getCurrX();
      int j = this.c - i;
      int k = this.a.getPaddingLeft();
      int m = this.a.getPaddingRight();
      if (j > 0)
        Gallery.a(this.a, this.a.k);
      for (int i1 = Math.min(-1 + (this.a.getWidth() - k - m), j); ; i1 = Math.max(-(-1 + (this.a.getWidth() - m - k)), j))
      {
        this.a.b(i1);
        if ((!bool) || (Gallery.d(this.a)))
          break label206;
        this.c = i;
        this.a.post(this);
        break;
        int n = -1 + this.a.getChildCount();
        Gallery.a(this.a, n + this.a.k);
      }
      label206: b(true);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     custom.android.Gallery.FlingRunnable
 * JD-Core Version:    0.6.0
 */
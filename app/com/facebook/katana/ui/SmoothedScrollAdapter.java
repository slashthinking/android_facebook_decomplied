package com.facebook.katana.ui;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public abstract class SmoothedScrollAdapter
  implements AbsListView.OnScrollListener
{
  private int a = -1;
  protected final int b;
  private int c = -1;
  private int d = -1;
  private long e;
  private int f;
  private boolean g = false;
  private boolean h = false;
  private final Handler i = new SmoothedScrollAdapter.1(this);

  public SmoothedScrollAdapter()
  {
    this(200);
  }

  public SmoothedScrollAdapter(int paramInt)
  {
    this.b = paramInt;
  }

  protected abstract void a(int paramInt1, int paramInt2, int paramInt3);

  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    if (!this.h)
      a(this.a, this.c, this.d);
    while (true)
    {
      this.e = SystemClock.elapsedRealtime();
      return;
      if ((this.b <= 0) || (this.f == 2))
        continue;
      if (SystemClock.elapsedRealtime() - this.e > this.b)
      {
        a(this.a, this.c, this.d);
        continue;
      }
      if (this.g)
        continue;
      this.g = true;
      this.i.sendMessageDelayed(Message.obtain(), this.b);
    }
  }

  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (!this.h)
      this.h = true;
    this.f = paramInt;
    if (paramInt == 0)
      a(this.a, this.c, this.d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.SmoothedScrollAdapter
 * JD-Core Version:    0.6.0
 */
package com.facebook.widget.listeners;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.orca.common.util.ArraySet;

public class BetterViewOnScrollListener
{
  private final ArraySet<AbsListView.OnScrollListener> a = new ArraySet();
  private AbsListView.OnScrollListener b = new BetterViewOnScrollListener.1(this);
  private AbsListView.OnScrollListener c;

  private void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.c != null)
      this.c.onScrollStateChanged(paramAbsListView, paramInt);
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((AbsListView.OnScrollListener)this.a.a(j)).onScrollStateChanged(paramAbsListView, paramInt);
  }

  private void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.c != null)
      this.c.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((AbsListView.OnScrollListener)this.a.a(j)).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }

  public AbsListView.OnScrollListener a()
  {
    return this.b;
  }

  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.c = paramOnScrollListener;
  }

  public void b(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.add(paramOnScrollListener);
  }

  public void c(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.remove(paramOnScrollListener);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.listeners.BetterViewOnScrollListener
 * JD-Core Version:    0.6.2
 */
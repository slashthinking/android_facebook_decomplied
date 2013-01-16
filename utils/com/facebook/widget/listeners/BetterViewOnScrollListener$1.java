package com.facebook.widget.listeners;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class BetterViewOnScrollListener$1
  implements AbsListView.OnScrollListener
{
  BetterViewOnScrollListener$1(BetterViewOnScrollListener paramBetterViewOnScrollListener)
  {
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    BetterViewOnScrollListener.a(this.a, paramAbsListView, paramInt1, paramInt2, paramInt3);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    BetterViewOnScrollListener.a(this.a, paramAbsListView, paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.listeners.BetterViewOnScrollListener.1
 * JD-Core Version:    0.6.2
 */
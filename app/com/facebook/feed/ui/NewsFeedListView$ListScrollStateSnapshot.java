package com.facebook.feed.ui;

import android.view.View;

class NewsFeedListView$ListScrollStateSnapshot
{
  private int b;
  private int c;
  private int d;

  public NewsFeedListView$ListScrollStateSnapshot(NewsFeedListView paramNewsFeedListView)
  {
    a();
  }

  public void a()
  {
    View localView = this.a.getChildAt(0);
    if (localView != null)
    {
      this.b = this.a.getFirstVisiblePosition();
      this.c = localView.getHeight();
    }
    for (this.d = (-localView.getTop()); ; this.d = 0)
    {
      return;
      this.b = 0;
      this.c = 0;
    }
  }

  public void a(ListScrollStateSnapshot paramListScrollStateSnapshot)
  {
    this.b = paramListScrollStateSnapshot.b();
    this.c = paramListScrollStateSnapshot.c();
    this.d = paramListScrollStateSnapshot.d();
  }

  public int b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public int d()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedListView.ListScrollStateSnapshot
 * JD-Core Version:    0.6.0
 */
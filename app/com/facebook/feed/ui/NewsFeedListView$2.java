package com.facebook.feed.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class NewsFeedListView$2
  implements AbsListView.OnScrollListener
{
  private int b = 0;

  private boolean a()
  {
    if ((NewsFeedListView.g(this.a) == NewsFeedListView.FeedChromeVisibility.VISIBLE) && (NewsFeedListView.h(this.a) < -NewsFeedListView.i(this.a)))
      this.a.a(false);
    while (true)
    {
      NewsFeedListView.a(this.a, 0.0F);
      NewsFeedListView.a(this.a).a(NewsFeedListView.f(this.a));
      int i = 1;
      boolean bool;
      do
      {
        NewsFeedListView.FeedChromeVisibility localFeedChromeVisibility1;
        NewsFeedListView.FeedChromeVisibility localFeedChromeVisibility2;
        do
        {
          return i;
          localFeedChromeVisibility1 = NewsFeedListView.g(this.a);
          localFeedChromeVisibility2 = NewsFeedListView.FeedChromeVisibility.HIDDEN;
          i = 0;
        }
        while (localFeedChromeVisibility1 != localFeedChromeVisibility2);
        bool = NewsFeedListView.h(this.a) < NewsFeedListView.i(this.a);
        i = 0;
      }
      while (!bool);
      this.a.a(true);
    }
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    NewsFeedListView.f(this.a).a();
    if (this.b == 0)
      return;
    int i;
    int j;
    if ((this.b != 2) || (!a()))
    {
      i = NewsFeedListView.f(this.a).b() - NewsFeedListView.a(this.a).b();
      if (NewsFeedListView.g(this.a) != NewsFeedListView.FeedChromeVisibility.VISIBLE)
        break label200;
      if (Math.abs(i) >= 2)
        break label184;
      j = NewsFeedListView.d(this.a) - (NewsFeedListView.f(this.a).d() - NewsFeedListView.a(this.a).d());
      if (i != 1)
        break label160;
      j -= NewsFeedListView.a(this.a).c();
      label130: NewsFeedListView.a(this.a, j, 0);
    }
    while (true)
    {
      NewsFeedListView.a(this.a).a(NewsFeedListView.f(this.a));
      break;
      break;
      label160: if (i != -1)
        break label130;
      j += NewsFeedListView.f(this.a).c();
      break label130;
      label184: if (i <= 0)
        continue;
      this.a.a(false);
      continue;
      label200: if ((NewsFeedListView.d(this.a) == 0) || (NewsFeedListView.f(this.a).b() != 0))
        continue;
      NewsFeedListView.a(this.a, -NewsFeedListView.f(this.a).d(), 0);
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.b = paramInt;
    if (this.b == 0)
    {
      if ((NewsFeedListView.d(this.a) <= NewsFeedListView.e(this.a) / 2) && (this.a.getFirstVisiblePosition() != 0))
        break label50;
      this.a.a(true);
    }
    while (true)
    {
      return;
      label50: this.a.a(false);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedListView.2
 * JD-Core Version:    0.6.0
 */
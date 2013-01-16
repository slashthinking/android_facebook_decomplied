package com.facebook.nearby.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class SplitHideableListView$2
  implements AbsListView.OnScrollListener
{
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.post(SplitHideableListView.b(this.a));
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.ui.SplitHideableListView.2
 * JD-Core Version:    0.6.0
 */
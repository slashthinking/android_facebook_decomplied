package com.facebook.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class ListViewPreloader$1
  implements AbsListView.OnScrollListener
{
  ListViewPreloader$1(ListViewPreloader paramListViewPreloader)
  {
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ListViewPreloader.a(this.a, paramInt1, paramInt2, paramInt3);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ListViewPreloader.1
 * JD-Core Version:    0.6.2
 */
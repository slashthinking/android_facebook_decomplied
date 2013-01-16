package com.facebook.photos.grid;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class UrlImageGrid$ScrollListener
  implements AbsListView.OnScrollListener
{
  private UrlImageGrid$ScrollListener(UrlImageGrid paramUrlImageGrid)
  {
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > 0)
      this.a.b.a(paramInt1, paramInt2);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.grid.UrlImageGrid.ScrollListener
 * JD-Core Version:    0.6.0
 */
package com.facebook.orca.threadlist;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class ThreadListFragment$MyOnScrollListener
  implements AbsListView.OnScrollListener
{
  private ThreadListFragment$MyOnScrollListener(ThreadListFragment paramThreadListFragment)
  {
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ThreadListFragment.b(this.a, paramInt1 + paramInt2);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      ThreadListFragment.c(this.a);
      ThreadListFragment.d(this.a);
    }
    if (ThreadListFragment.e(this.a) != null)
      ThreadListFragment.e(this.a).a(paramAbsListView, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListFragment.MyOnScrollListener
 * JD-Core Version:    0.6.0
 */
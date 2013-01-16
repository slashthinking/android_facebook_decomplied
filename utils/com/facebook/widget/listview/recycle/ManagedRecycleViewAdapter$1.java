package com.facebook.widget.listview.recycle;

import android.view.View;
import android.widget.AbsListView.RecyclerListener;

class ManagedRecycleViewAdapter$1
  implements AbsListView.RecyclerListener
{
  ManagedRecycleViewAdapter$1(ManagedRecycleViewAdapter paramManagedRecycleViewAdapter)
  {
  }

  public void onMovedToScrapHeap(View paramView)
  {
    if (paramView == null);
    while (true)
    {
      return;
      if ((paramView instanceof RecycleViewWrapper))
        ManagedRecycleViewAdapter.b(this.a).a(ManagedRecycleViewAdapter.a(this.a).getClass(), (RecycleViewWrapper)paramView);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.listview.recycle.ManagedRecycleViewAdapter.1
 * JD-Core Version:    0.6.2
 */
package com.facebook.widget.listview.recycle;

import android.database.DataSetObserver;

class ManagedRecycleViewAdapter$2 extends DataSetObserver
{
  ManagedRecycleViewAdapter$2(ManagedRecycleViewAdapter paramManagedRecycleViewAdapter)
  {
  }

  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }

  public void onInvalidated()
  {
    this.a.notifyDataSetInvalidated();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.listview.recycle.ManagedRecycleViewAdapter.2
 * JD-Core Version:    0.6.2
 */
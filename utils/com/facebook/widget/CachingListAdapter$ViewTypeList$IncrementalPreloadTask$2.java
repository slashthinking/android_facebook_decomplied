package com.facebook.widget;

import com.facebook.task.IncrementalSingleTask;

class CachingListAdapter$ViewTypeList$IncrementalPreloadTask$2 extends IncrementalSingleTask
{
  CachingListAdapter$ViewTypeList$IncrementalPreloadTask$2(CachingListAdapter.ViewTypeList.IncrementalPreloadTask paramIncrementalPreloadTask, CachingListAdapter.ViewTypeList paramViewTypeList)
  {
  }

  protected void a()
  {
    if ((this.b.c.b != null) && (CachingListAdapter.b(this.b.f.c) != null))
    {
      CachingListAdapter.b(this.b.f.c).a(this.b.c.b, this.b.e);
      this.b.c.e = CachingListAdapter.ViewState.Measured;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.CachingListAdapter.ViewTypeList.IncrementalPreloadTask.2
 * JD-Core Version:    0.6.2
 */
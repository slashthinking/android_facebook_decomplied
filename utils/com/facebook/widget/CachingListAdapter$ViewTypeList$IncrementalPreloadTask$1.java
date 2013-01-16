package com.facebook.widget;

import com.facebook.task.IncrementalSingleTask;

class CachingListAdapter$ViewTypeList$IncrementalPreloadTask$1 extends IncrementalSingleTask
{
  CachingListAdapter$ViewTypeList$IncrementalPreloadTask$1(CachingListAdapter.ViewTypeList.IncrementalPreloadTask paramIncrementalPreloadTask, CachingListAdapter.ViewTypeList paramViewTypeList)
  {
  }

  protected void a()
  {
    if ((this.b.e >= 0) && (this.b.c.b == null))
    {
      this.b.c.b = this.b.f.c.a(this.b.e, this.b.b, this.b.d);
      this.b.c.e = CachingListAdapter.ViewState.Created;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.CachingListAdapter.ViewTypeList.IncrementalPreloadTask.1
 * JD-Core Version:    0.6.2
 */
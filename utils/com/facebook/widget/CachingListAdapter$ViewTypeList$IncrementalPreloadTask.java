package com.facebook.widget;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.task.IncrementalCompositeTask;
import com.facebook.task.IncrementalSingleTask;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.ImmutableList;

public class CachingListAdapter$ViewTypeList$IncrementalPreloadTask extends IncrementalSingleTask
{
  final IncrementalCompositeTask<IncrementalSingleTask> a;
  View b;
  CachingListAdapter.CachedViewNode c;
  ViewGroup d;
  int e;

  public CachingListAdapter$ViewTypeList$IncrementalPreloadTask(CachingListAdapter.ViewTypeList paramViewTypeList)
  {
    this.a = new IncrementalCompositeTask(ImmutableList.a(new CachingListAdapter.ViewTypeList.IncrementalPreloadTask.1(this, paramViewTypeList), new CachingListAdapter.ViewTypeList.IncrementalPreloadTask.2(this, paramViewTypeList), new CachingListAdapter.ViewTypeList.IncrementalPreloadTask.3(this, paramViewTypeList)));
  }

  protected void a()
  {
    this.a.b();
    b(this.a);
  }

  public void a(int paramInt, View paramView, ViewGroup paramViewGroup, CachingListAdapter.CachedViewNode paramCachedViewNode)
  {
    this.e = paramInt;
    this.b = paramView;
    this.c = paramCachedViewNode;
    this.d = paramViewGroup;
  }

  public void a(int paramInt, ViewGroup paramViewGroup, CachingListAdapter.CachedViewNode paramCachedViewNode)
  {
    this.e = paramInt;
    this.b = null;
    this.c = paramCachedViewNode;
    this.d = paramViewGroup;
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("position", Integer.valueOf(this.e)).add("view", this.c.b).toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.CachingListAdapter.ViewTypeList.IncrementalPreloadTask
 * JD-Core Version:    0.6.2
 */
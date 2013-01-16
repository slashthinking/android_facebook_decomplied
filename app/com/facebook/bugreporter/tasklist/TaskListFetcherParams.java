package com.facebook.bugreporter.tasklist;

import com.google.common.collect.ImmutableList;

public class TaskListFetcherParams
{
  private final ImmutableList<Long> a;

  public TaskListFetcherParams(ImmutableList<Long> paramImmutableList)
  {
    this.a = paramImmutableList;
  }

  public ImmutableList<Long> a()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.TaskListFetcherParams
 * JD-Core Version:    0.6.0
 */
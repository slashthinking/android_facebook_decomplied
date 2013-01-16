package com.facebook.bugreporter.tasklist;

import android.util.Log;
import com.facebook.bugreporter.BugReporterConfig;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;

public class TaskListFetcher
{
  private static final String a = TaskListFetcher.class.getSimpleName();
  private final BugReporterConfig b;
  private final SingleMethodRunner c;
  private final TaskListFetcherMethod d;
  private final ListeningExecutorService e;

  public TaskListFetcher(BugReporterConfig paramBugReporterConfig, SingleMethodRunner paramSingleMethodRunner, TaskListFetcherMethod paramTaskListFetcherMethod, ListeningExecutorService paramListeningExecutorService)
  {
    this.b = paramBugReporterConfig;
    this.c = paramSingleMethodRunner;
    this.d = paramTaskListFetcherMethod;
    this.e = paramListeningExecutorService;
  }

  private ImmutableList<Task> b(ImmutableList<Long> paramImmutableList)
  {
    try
    {
      ImmutableList.Builder localBuilder = ImmutableList.e();
      localBuilder.b(paramImmutableList);
      localBuilder.b(this.b.d());
      TaskListFetcherParams localTaskListFetcherParams = new TaskListFetcherParams(localBuilder.b());
      localImmutableList = (ImmutableList)this.c.a(this.d, localTaskListFetcherParams);
      if (localImmutableList != null)
        return localImmutableList;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.e(a, "Exception caught running SingleMethodRunner: " + localException);
        ImmutableList localImmutableList = ImmutableList.d();
      }
    }
  }

  public ListenableFuture<ImmutableList<Task>> a(ImmutableList<Long> paramImmutableList)
  {
    return this.e.a(new TaskListFetcher.1(this, paramImmutableList));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.TaskListFetcher
 * JD-Core Version:    0.6.0
 */
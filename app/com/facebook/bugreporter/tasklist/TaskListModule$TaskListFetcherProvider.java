package com.facebook.bugreporter.tasklist;

import com.facebook.bugreporter.BugReporterConfig;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.google.common.util.concurrent.ListeningExecutorService;

class TaskListModule$TaskListFetcherProvider extends AbstractProvider<TaskListFetcher>
{
  private TaskListModule$TaskListFetcherProvider(TaskListModule paramTaskListModule)
  {
  }

  public TaskListFetcher a()
  {
    return new TaskListFetcher((BugReporterConfig)b(BugReporterConfig.class), (SingleMethodRunner)b(SingleMethodRunner.class), (TaskListFetcherMethod)b(TaskListFetcherMethod.class), (ListeningExecutorService)b(ListeningExecutorService.class, DefaultExecutorService.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.TaskListModule.TaskListFetcherProvider
 * JD-Core Version:    0.6.0
 */
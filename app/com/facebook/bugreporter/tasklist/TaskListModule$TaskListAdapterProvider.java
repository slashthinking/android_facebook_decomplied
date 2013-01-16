package com.facebook.bugreporter.tasklist;

import android.content.Context;
import com.facebook.orca.inject.AbstractProvider;

class TaskListModule$TaskListAdapterProvider extends AbstractProvider<TaskListAdapter>
{
  private TaskListModule$TaskListAdapterProvider(TaskListModule paramTaskListModule)
  {
  }

  public TaskListAdapter a()
  {
    return new TaskListAdapter((Context)b(Context.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.TaskListModule.TaskListAdapterProvider
 * JD-Core Version:    0.6.0
 */
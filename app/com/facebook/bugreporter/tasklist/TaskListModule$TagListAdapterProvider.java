package com.facebook.bugreporter.tasklist;

import android.content.Context;
import com.facebook.orca.inject.AbstractProvider;

class TaskListModule$TagListAdapterProvider extends AbstractProvider<TagListAdapter>
{
  private TaskListModule$TagListAdapterProvider(TaskListModule paramTaskListModule)
  {
  }

  public TagListAdapter a()
  {
    return new TagListAdapter((Context)b(Context.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.TaskListModule.TagListAdapterProvider
 * JD-Core Version:    0.6.0
 */
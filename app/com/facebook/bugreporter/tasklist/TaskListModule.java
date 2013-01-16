package com.facebook.bugreporter.tasklist;

import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;

public class TaskListModule extends AbstractModule
{
  protected void a()
  {
    a(TaskListFetcher.class).a(new TaskListModule.TaskListFetcherProvider(this, null));
    a(TaskListFetcherMethod.class).a(new TaskListModule.TaskListFetcherMethodProvider(this, null));
    a(TagListAdapter.class).a(new TaskListModule.TagListAdapterProvider(this, null));
    a(TaskListAdapter.class).a(new TaskListModule.TaskListAdapterProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.TaskListModule
 * JD-Core Version:    0.6.0
 */
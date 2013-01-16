package com.facebook.bugreporter.tasklist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.debug.Assert;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class TaskListAdapter extends BaseAdapter
{
  private static final Class<?> a = TaskListAdapter.class;
  private final Context b;
  private List<Task> c = ImmutableList.d();

  public TaskListAdapter(Context paramContext)
  {
    this.b = paramContext;
  }

  public Task a(int paramInt)
  {
    if (paramInt < this.c.size());
    for (Task localTask = (Task)this.c.get(paramInt); ; localTask = null)
      return localTask;
  }

  public void a(List<Task> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.c.size();
  }

  public long getItemId(int paramInt)
  {
    long l;
    if (paramInt < this.c.size())
      l = Long.parseLong(((Task)this.c.get(paramInt)).taskId);
    while (true)
    {
      return l;
      l = -9223372036854775808L;
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TaskListItemView localTaskListItemView = (TaskListItemView)paramView;
    if (paramInt <= this.c.size());
    for (boolean bool = true; ; bool = false)
    {
      Assert.b("index is a list index", bool);
      if (localTaskListItemView == null)
        localTaskListItemView = new TaskListItemView(this.b);
      localTaskListItemView.setTask(a(paramInt));
      return localTaskListItemView;
    }
  }

  public boolean hasStableIds()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.TaskListAdapter
 * JD-Core Version:    0.6.0
 */
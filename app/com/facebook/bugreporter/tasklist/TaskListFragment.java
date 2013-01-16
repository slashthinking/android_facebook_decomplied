package com.facebook.bugreporter.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Toaster;
import com.facebook.fragment.NavigableFragment;
import com.facebook.fragment.NavigableFragment.Listener;
import com.facebook.orca.activity.FbNestedFragment;
import com.facebook.orca.annotations.ForUiThread;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;

public class TaskListFragment extends FbNestedFragment
  implements NavigableFragment
{
  private static final Class<?> a = TaskListFragment.class;
  private TaskListFetcher b;
  private TaskListAdapter c;
  private Executor d;
  private NavigableFragment.Listener e;
  private FbTitleBar f;
  private ListView g;
  private EmptyListViewItem h;
  private Intent i;

  private void a(ImmutableList<Task> paramImmutableList)
  {
    this.h.a(false);
    this.h.setVisibility(8);
    if ((paramImmutableList == null) || (paramImmutableList.size() == 0))
    {
      this.i.putExtra("task_number", -1);
      Toaster.a(p(), "Matching tasks were not found. Please report a bug.");
      this.e.a(this, this.i);
    }
    while (true)
    {
      return;
      ImmutableList.Builder localBuilder = ImmutableList.e();
      localBuilder.b(paramImmutableList);
      localBuilder.b(new Task("-1", "-1", "No Match", "None of the tasks above match my issue."));
      this.f.setTitle("Is this your bug?");
      this.c.a(localBuilder.b());
    }
  }

  private void a(Throwable paramThrowable)
  {
    this.i.putExtra("task_number", -1);
    Toaster.a(p(), "Failed to search existing tasks. Please report a bug.");
    this.e.a(this, this.i);
  }

  private void g(int paramInt)
  {
    Task localTask = this.c.a(paramInt);
    int j = Integer.parseInt(localTask.taskNumber);
    this.i.putExtra("task_number", j);
    this.i.putExtra("task_desc", localTask.taskDesc);
    this.i.putExtra("task_id", Long.parseLong(localTask.taskId));
    if (j == -1)
      this.e.a(this, this.i);
    while (true)
    {
      return;
      Intent localIntent = new Intent(p(), ViewTaskActivity.class);
      localIntent.putExtra("task", localTask);
      a(localIntent, 1005);
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903579, paramViewGroup, false);
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default:
      BLog.d(a, "unexpected request code" + paramInt1);
    case 1005:
    }
    while (true)
    {
      return;
      switch (paramInt2)
      {
      case 0:
      default:
        ErrorReporting.a("Task List Activity", "unexpected result code from View Task: " + paramInt2);
        break;
      case -1:
        this.e.a(this, this.i);
      }
    }
  }

  public void a(NavigableFragment.Listener paramListener)
  {
    this.e = paramListener;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    FbInjector localFbInjector = a();
    this.b = ((TaskListFetcher)localFbInjector.a(TaskListFetcher.class));
    this.c = ((TaskListAdapter)localFbInjector.a(TaskListAdapter.class));
    this.d = ((Executor)localFbInjector.a(Executor.class, ForUiThread.class));
    this.i = new Intent();
    this.g = ((ListView)f(16908298));
    this.h = ((EmptyListViewItem)f(2131297872));
    this.g.setAdapter(this.c);
    FbTitleBarUtil.a(A());
    this.f = ((FbTitleBar)f(2131296299));
    this.f.setTitle("Loading...");
    this.h.setVisibility(0);
    this.h.a(true);
    this.h.setMessage("Loading...");
    ImmutableList localImmutableList = ImmutableList.a(Longs.a(m().getLongArray("checked_tags")));
    Futures.a(this.b.a(localImmutableList), new TaskListFragment.1(this), this.d);
    this.g.setOnItemClickListener(new TaskListFragment.2(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.TaskListFragment
 * JD-Core Version:    0.6.0
 */
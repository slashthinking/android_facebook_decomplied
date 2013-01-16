package com.facebook.bugreporter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.annotations.IsMeUserAnEmployee;
import com.facebook.bugreporter.tasklist.TagListFragment;
import com.facebook.bugreporter.tasklist.TaskListFragment;
import com.facebook.common.util.Toaster;
import com.facebook.common.util.TriState;
import com.facebook.fragment.NavigableFragment;
import com.facebook.fragment.NavigableFragment.Listener;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.annotations.AuthNotRequired;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Longs;
import java.util.List;

@AuthNotRequired
public class BugReportActivity extends FbFragmentActivity
  implements BugReporterRelated
{
  private static final Class<?> n = BugReportActivity.class;
  private BugReporterConfig o;
  private BugReporterFileUtil p;
  private TriState q;
  private NavigableFragment.Listener r;
  private BugReportBuilder s;

  private void a(NavigableFragment paramNavigableFragment, Intent paramIntent)
  {
    if (paramIntent == null)
      finish();
    while (true)
    {
      return;
      if ((paramNavigableFragment instanceof TagListFragment))
      {
        long[] arrayOfLong = paramIntent.getLongArrayExtra("checked_tags");
        if ((arrayOfLong != null) && (arrayOfLong.length > 0))
          this.s.a(Longs.a(arrayOfLong));
        if (this.q == TriState.YES)
        {
          a(true, arrayOfLong);
          continue;
        }
        a(true, this.s.i());
        continue;
      }
      if (!(paramNavigableFragment instanceof TaskListFragment))
        continue;
      if (paramIntent.getIntExtra("task_number", -1) != -1)
      {
        this.p.a(this.s.a());
        Toaster.a(this, 2131362006);
        finish();
        continue;
      }
      a(true, this.s.i());
    }
  }

  private void a(boolean paramBoolean, BugReport paramBugReport)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("report", paramBugReport);
    BugReportFragment localBugReportFragment = new BugReportFragment();
    localBugReportFragment.f(localBundle);
    localBugReportFragment.a(this.r);
    FragmentTransaction localFragmentTransaction = g().a();
    localFragmentTransaction.a(2131296431, localBugReportFragment, "bugReport");
    if (paramBoolean)
      localFragmentTransaction.a(null);
    localFragmentTransaction.a();
  }

  private void a(boolean paramBoolean, long[] paramArrayOfLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLongArray("checked_tags", paramArrayOfLong);
    TaskListFragment localTaskListFragment = new TaskListFragment();
    localTaskListFragment.f(localBundle);
    localTaskListFragment.a(this.r);
    FragmentTransaction localFragmentTransaction = g().a();
    localFragmentTransaction.a(2131296431, localTaskListFragment, "taskList");
    if (paramBoolean)
      localFragmentTransaction.a(null);
    localFragmentTransaction.a();
  }

  private void b(boolean paramBoolean)
  {
    TagListFragment localTagListFragment = new TagListFragment();
    localTagListFragment.a(this.r);
    FragmentTransaction localFragmentTransaction = g().a();
    localFragmentTransaction.a(2131296431, localTagListFragment, "tagList");
    if (paramBoolean)
      localFragmentTransaction.a(null);
    localFragmentTransaction.a();
  }

  private void i()
  {
    if (!this.s.f().isEmpty())
      a(false, this.s.i());
    while (true)
    {
      return;
      if (!this.o.c().isEmpty())
      {
        b(false);
        continue;
      }
      if (TriState.YES.equals(this.q))
      {
        a(false, new long[0]);
        continue;
      }
      a(false, this.s.i());
    }
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = C();
    this.o = ((BugReporterConfig)localFbInjector.a(BugReporterConfig.class));
    this.p = ((BugReporterFileUtil)localFbInjector.a(BugReporterFileUtil.class));
    this.q = ((TriState)localFbInjector.a(TriState.class, IsMeUserAnEmployee.class));
    setContentView(2130903080);
    BugReport localBugReport = (BugReport)getIntent().getParcelableExtra("report");
    if (localBugReport == null)
    {
      BLog.d(n, "Missing bug report in intent");
      finish();
    }
    while (true)
    {
      return;
      this.s = BugReport.newBuilder().a(localBugReport);
      this.r = new BugReportActivity.1(this);
      FragmentManager localFragmentManager = g();
      TagListFragment localTagListFragment = (TagListFragment)localFragmentManager.a("tagList");
      if (localTagListFragment != null)
        localTagListFragment.a(this.r);
      TaskListFragment localTaskListFragment = (TaskListFragment)localFragmentManager.a("taskList");
      if (localTaskListFragment != null)
        localTaskListFragment.a(this.r);
      BugReportFragment localBugReportFragment = (BugReportFragment)localFragmentManager.a("bugReport");
      if (localBugReportFragment != null)
        localBugReportFragment.a(this.r);
      if (paramBundle != null);
      for (boolean bool = true; ; bool = getIntent().getBooleanExtra("retry", false))
      {
        if ((bool) || (!this.o.a()))
          break label252;
        new BugReportActivity.OldVersionDialog(this, null).a(localFragmentManager, "oldVersionDialog");
        break;
      }
      label252: i();
    }
  }

  public void onBackPressed()
  {
    if (!g().e())
    {
      this.p.a(this.s.a());
      finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReportActivity
 * JD-Core Version:    0.6.0
 */
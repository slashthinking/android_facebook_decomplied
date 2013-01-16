package com.facebook.katana.activity;

import android.app.Activity;
import com.facebook.orca.activity.AbstractFbActivityListener;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.threadlist.ThreadListActivity;
import com.facebook.widget.listview.recycle.ViewPoolCleaner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ActivityCleaner extends AbstractFbActivityListener
{
  private final Clock a;
  private final List<ActivityCleaner.Entry> b;
  private final Map<Activity, ActivityCleaner.Entry> c;
  private final int d;
  private final boolean e;

  public ActivityCleaner(Clock paramClock, int paramInt)
  {
    this(paramClock, paramInt, 8);
  }

  ActivityCleaner(Clock paramClock, int paramInt1, int paramInt2)
  {
    this.a = paramClock;
    if (paramInt1 <= 33);
    for (boolean bool = true; ; bool = false)
    {
      this.e = bool;
      if (this.e)
        paramInt2 = 2;
      this.d = paramInt2;
      this.b = Lists.a();
      this.c = new MapMaker().f().n();
      return;
    }
  }

  private void a()
  {
    Collections.sort(this.b, ActivityCleaner.Entry.a());
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      if (ActivityCleaner.Entry.b((ActivityCleaner.Entry)localIterator.next()) != null)
        continue;
      localIterator.remove();
    }
  }

  private int b()
  {
    Iterator localIterator = this.b.iterator();
    int i = 0;
    if (localIterator.hasNext())
      if (!q(ActivityCleaner.Entry.b((ActivityCleaner.Entry)localIterator.next())))
        break label50;
    label50: for (int j = i + 1; ; j = i)
    {
      i = j;
      break;
      return i;
    }
  }

  private void n(Activity paramActivity)
  {
    if ((paramActivity instanceof ViewPoolCleaner));
    for (int i = -1 + this.b.size(); ; i--)
    {
      if (i >= 0)
      {
        Activity localActivity = ActivityCleaner.Entry.b((ActivityCleaner.Entry)this.b.get(i));
        if ((localActivity == paramActivity) || (!(localActivity instanceof ViewPoolCleaner)))
          continue;
        ((ViewPoolCleaner)localActivity).i();
      }
      return;
    }
  }

  private ActivityCleaner.Entry o(Activity paramActivity)
  {
    ActivityCleaner.Entry localEntry = (ActivityCleaner.Entry)this.c.get(paramActivity);
    if (localEntry == null)
    {
      localEntry = new ActivityCleaner.Entry(paramActivity, null);
      this.c.put(paramActivity, localEntry);
      this.b.add(localEntry);
    }
    return localEntry;
  }

  private void p(Activity paramActivity)
  {
    ActivityCleaner.Entry localEntry = (ActivityCleaner.Entry)this.c.get(paramActivity);
    if (localEntry != null)
    {
      this.b.remove(localEntry);
      this.c.remove(paramActivity);
    }
  }

  private static boolean q(Activity paramActivity)
  {
    if (((paramActivity instanceof FbFragmentChromeActivity)) || ((paramActivity instanceof ThreadListActivity)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void a(Activity paramActivity)
  {
    int i = b() - this.d;
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator1 = this.b.iterator();
    for (int j = i; ; j = j)
    {
      if ((!localIterator1.hasNext()) || (j <= 0))
      {
        Iterator localIterator2 = localBuilder.b().iterator();
        while (localIterator2.hasNext())
          p((Activity)localIterator2.next());
      }
      ActivityCleaner.Entry localEntry = (ActivityCleaner.Entry)localIterator1.next();
      Activity localActivity = ActivityCleaner.Entry.b(localEntry);
      if (localActivity == null)
        continue;
      localActivity.finish();
      if (ActivityCleaner.Entry.c(localEntry))
        j--;
      localBuilder.b(localActivity);
    }
    ActivityCleaner.Entry.a(o(paramActivity), this.a.a());
    a();
  }

  public void c(Activity paramActivity)
  {
    if (this.e)
    {
      n(paramActivity);
      if ((paramActivity instanceof ViewPoolCleaner))
        ((ViewPoolCleaner)paramActivity).i();
    }
  }

  public void g(Activity paramActivity)
  {
    n(paramActivity);
  }

  public void h(Activity paramActivity)
  {
    p(paramActivity);
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.ActivityCleaner
 * JD-Core Version:    0.6.0
 */
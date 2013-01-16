package com.facebook.katana.activity;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Comparator;

class ActivityCleaner$Entry
{
  private static final Comparator<Entry> a = new ActivityCleaner.Entry.1();
  private final WeakReference<Activity> b;
  private final boolean c;
  private long d;

  private ActivityCleaner$Entry(Activity paramActivity)
  {
    this.b = new WeakReference(paramActivity);
    this.c = ActivityCleaner.i(paramActivity);
    this.d = -9223372036854775808L;
  }

  private void a(long paramLong)
  {
    this.d = paramLong;
  }

  private long b()
  {
    return this.d;
  }

  private Activity c()
  {
    return (Activity)this.b.get();
  }

  private boolean d()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.ActivityCleaner.Entry
 * JD-Core Version:    0.6.0
 */
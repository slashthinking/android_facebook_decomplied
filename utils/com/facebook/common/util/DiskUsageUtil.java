package com.facebook.common.util;

import android.content.Context;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.base.Stopwatch;

public class DiskUsageUtil
{
  StatFsHelper a;
  private Stopwatch b;
  private Context c;
  private AndroidThreadUtil d;

  public DiskUsageUtil(Context paramContext, AndroidThreadUtil paramAndroidThreadUtil, StatFsHelper paramStatFsHelper)
  {
    this.a = paramStatFsHelper;
    this.c = paramContext;
    this.d = paramAndroidThreadUtil;
    this.b = new Stopwatch();
    this.b.reset();
  }

  private void a()
  {
    try
    {
      if ((!this.b.isRunning()) || (this.b.elapsedMillis() > 3600000L))
      {
        this.d.b(new DiskUsageUtil.1(this));
        this.b.reset().start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean a(long paramLong)
  {
    boolean bool = this.a.a(paramLong);
    if (bool)
      a();
    return bool;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.DiskUsageUtil
 * JD-Core Version:    0.6.2
 */
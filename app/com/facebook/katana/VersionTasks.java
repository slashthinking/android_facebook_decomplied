package com.facebook.katana;

import android.content.Context;

class VersionTasks
{
  private static VersionTasks a;
  private final Context b;
  private final FB4AVersion c;
  private boolean d;

  private VersionTasks(Context paramContext)
  {
    this.b = paramContext;
    this.c = FB4AVersion.a(paramContext);
    this.d = false;
  }

  public static VersionTasks a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (a == null)
        a = new VersionTasks(paramContext.getApplicationContext());
      VersionTasks localVersionTasks = a;
      monitorexit;
      return localVersionTasks;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a()
  {
    monitorenter;
    try
    {
      boolean bool = this.d;
      if (bool);
      while (true)
      {
        return;
        this.d = true;
        if (!this.c.a())
          continue;
        new VersionTasks.1(this).start();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.VersionTasks
 * JD-Core Version:    0.6.0
 */
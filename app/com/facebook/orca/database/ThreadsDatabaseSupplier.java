package com.facebook.orca.database;

import android.content.Context;
import com.facebook.orca.common.sqlite.AbstractDatabaseSupplier;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.collect.ImmutableList;

public class ThreadsDatabaseSupplier extends AbstractDatabaseSupplier
{
  private static final ImmutableList<String> a = ImmutableList.a("threads_db");
  private final ThreadsDbSchemaPart b;

  public ThreadsDatabaseSupplier(Context paramContext, AndroidThreadUtil paramAndroidThreadUtil, ThreadsDbSchemaPart paramThreadsDbSchemaPart)
  {
    super(paramContext, paramAndroidThreadUtil, ImmutableList.a(paramThreadsDbSchemaPart), "threads_db2", a);
    this.b = paramThreadsDbSchemaPart;
  }

  public void a()
  {
    monitorenter;
    try
    {
      this.b.b(b());
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void c()
  {
    monitorenter;
    try
    {
      this.b.c(b());
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.ThreadsDatabaseSupplier
 * JD-Core Version:    0.6.0
 */
package com.facebook.orca.common.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.debug.WtfToken;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

public class AbstractDatabaseSupplier
  implements Supplier<SQLiteDatabase>
{
  private static final Class<?> a = AbstractDatabaseSupplier.class;
  private static final WtfToken b = new WtfToken();
  private final Context c;
  private final AndroidThreadUtil d;
  private final ImmutableList<? extends SharedSQLiteSchemaPart> e;
  private final String f;
  private final ImmutableList<String> g;
  private SQLiteDatabase h;

  protected AbstractDatabaseSupplier(Context paramContext, AndroidThreadUtil paramAndroidThreadUtil, ImmutableList<? extends SharedSQLiteSchemaPart> paramImmutableList, String paramString, ImmutableList<String> paramImmutableList1)
  {
    this.c = paramContext;
    this.d = paramAndroidThreadUtil;
    this.e = paramImmutableList;
    this.f = paramString;
    this.g = paramImmutableList1;
  }

  private void a()
  {
    monitorenter;
    while (true)
    {
      Tracer localTracer;
      try
      {
        this.d.b();
        SQLiteDatabase localSQLiteDatabase = this.h;
        if (localSQLiteDatabase != null)
          return;
        localTracer = Tracer.a("ensureDatabase");
        try
        {
          Iterator localIterator = this.g.iterator();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            this.c.deleteDatabase(str);
            continue;
          }
        }
        finally
        {
          localTracer.a();
        }
      }
      finally
      {
        monitorexit;
      }
      try
      {
        this.h = c();
        localTracer.a();
      }
      catch (SQLiteException localSQLiteException)
      {
        while (true)
        {
          BLog.a(b, a, "Possible database corruption", localSQLiteException);
          this.c.deleteDatabase(this.f);
          this.h = c();
        }
      }
    }
  }

  private SQLiteDatabase c()
  {
    return new SharedSQLiteOpenHelper(this.c, this.f, this.e).getWritableDatabase();
  }

  public SQLiteDatabase b()
  {
    monitorenter;
    try
    {
      a();
      SQLiteDatabase localSQLiteDatabase = this.h;
      monitorexit;
      return localSQLiteDatabase;
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
 * Qualified Name:     com.facebook.orca.common.sqlite.AbstractDatabaseSupplier
 * JD-Core Version:    0.6.0
 */
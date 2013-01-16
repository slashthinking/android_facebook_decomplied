package com.facebook.analytics;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDiskIOException;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.inject.FbInjector;
import java.util.UUID;
import org.acra.ErrorReporter;

class AnalyticsSession
{
  private final Context a;
  private final AnalyticsPropertyUtil b;
  private final AnalyticsDatabaseSupplier c;
  private final AnalyticsStorage d;
  private String e;
  private String f;
  private long g;
  private long h;
  private boolean i = false;
  private long j = 0L;
  private long k = 0L;

  public AnalyticsSession(Context paramContext, AnalyticsPropertyUtil paramAnalyticsPropertyUtil, AnalyticsDatabaseSupplier paramAnalyticsDatabaseSupplier, AnalyticsStorage paramAnalyticsStorage)
  {
    this.a = paramContext;
    this.b = paramAnalyticsPropertyUtil;
    this.c = paramAnalyticsDatabaseSupplier;
    this.d = paramAnalyticsStorage;
  }

  private void a(String paramString, Throwable paramThrowable)
  {
    FbErrorReporter localFbErrorReporter = (FbErrorReporter)FbInjector.a(this.a).a(FbErrorReporter.class);
    if (localFbErrorReporter != null)
      localFbErrorReporter.a("AnalyticsSession", paramString, paramThrowable);
  }

  private void k()
  {
    this.e = null;
    this.f = null;
    this.g = 0L;
    this.h = 0L;
    this.j = 0L;
    this.i = false;
    this.k = 0L;
    l();
  }

  private void l()
  {
    try
    {
      ErrorReporter localErrorReporter = ErrorReporter.getInstance();
      if (a())
      {
        localErrorReporter.putCustomData("marauder_session_id", this.e);
        localErrorReporter.putCustomData("marauder_batch_id", String.valueOf(this.j));
      }
      while (true)
      {
        return;
        localErrorReporter.removeCustomData("marauder_session_id");
        localErrorReporter.removeCustomData("marauder_batch_id");
      }
    }
    finally
    {
    }
  }

  public void a(long paramLong)
  {
    this.g = paramLong;
  }

  public void a(AnalyticsEvent paramAnalyticsEvent)
  {
    if (!this.i)
    {
      this.j = (1L + this.j);
      this.k = 0L;
      this.d.a(h(), this.e, this.f, this.j, paramAnalyticsEvent.b());
      g();
      this.i = true;
      l();
    }
  }

  public void a(String paramString)
  {
    if (a())
      j();
    k();
    this.e = UUID.randomUUID().toString();
    this.f = paramString;
    l();
    g();
  }

  public boolean a()
  {
    if (this.e != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public String b()
  {
    return this.f;
  }

  public void b(long paramLong)
  {
    this.h = paramLong;
  }

  public long c()
  {
    return this.g;
  }

  public long d()
  {
    return this.k;
  }

  public void e()
  {
    this.k = (1L + this.k);
  }

  public void f()
  {
    try
    {
      localSQLiteDatabase = this.c.b();
      localSQLiteDatabase.beginTransaction();
    }
    catch (SQLiteDiskIOException localSQLiteDiskIOException)
    {
      try
      {
        this.e = this.b.a(AnalyticsDbProperties.c);
        this.f = this.b.a(AnalyticsDbProperties.d);
        this.g = this.b.a(AnalyticsDbProperties.b, 0L);
        this.j = this.b.a(AnalyticsDbProperties.e, 0L);
        l();
        return;
        localSQLiteDiskIOException = localSQLiteDiskIOException;
        a("Cannot load AnalyticsSession from database", localSQLiteDiskIOException);
        k();
      }
      finally
      {
        SQLiteDatabase localSQLiteDatabase;
        localSQLiteDatabase.endTransaction();
      }
    }
  }

  public void g()
  {
    try
    {
      localSQLiteDatabase = this.c.b();
      localSQLiteDatabase.beginTransaction();
    }
    catch (SQLiteDiskIOException localSQLiteDiskIOException)
    {
      try
      {
        this.b.a(AnalyticsDbProperties.c, this.e);
        this.b.a(AnalyticsDbProperties.d, this.f);
        this.b.b(AnalyticsDbProperties.b, this.g);
        this.b.b(AnalyticsDbProperties.e, this.j);
        localSQLiteDatabase.setTransactionSuccessful();
        return;
        localSQLiteDiskIOException = localSQLiteDiskIOException;
        a("Cannot save AnalyticsSession to database", localSQLiteDiskIOException);
      }
      finally
      {
        SQLiteDatabase localSQLiteDatabase;
        localSQLiteDatabase.endTransaction();
      }
    }
  }

  public String h()
  {
    return this.e + "_" + Long.toString(this.j);
  }

  public void i()
  {
    this.d.a();
    this.i = false;
    this.k = 0L;
  }

  public void j()
  {
    i();
    k();
    g();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsSession
 * JD-Core Version:    0.6.2
 */
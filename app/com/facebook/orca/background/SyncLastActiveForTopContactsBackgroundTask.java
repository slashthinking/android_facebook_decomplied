package com.facebook.orca.background;

import android.os.Bundle;
import com.facebook.background.AbstractBackgroundTask;
import com.facebook.background.BackgroundResult;
import com.facebook.background.SimpleBackgroundResultFutureCallback;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.database.DbProperties;
import com.facebook.orca.database.DbUsersPropertyUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Provider;

public class SyncLastActiveForTopContactsBackgroundTask extends AbstractBackgroundTask
{
  private static final Class<?> a = SyncLastActiveForTopContactsBackgroundTask.class;
  private final MeUserAuthDataStore b;
  private final Provider<Boolean> c;
  private final DbUsersPropertyUtil d;
  private final OrcaServiceOperationFactory e;

  public SyncLastActiveForTopContactsBackgroundTask(MeUserAuthDataStore paramMeUserAuthDataStore, Provider<Boolean> paramProvider, DbUsersPropertyUtil paramDbUsersPropertyUtil, OrcaServiceOperationFactory paramOrcaServiceOperationFactory)
  {
    super("SYNC_LAST_ACTIVE_FOR_TOP_CONTACTS");
    this.b = paramMeUserAuthDataStore;
    this.c = paramProvider;
    this.d = paramDbUsersPropertyUtil;
    this.e = paramOrcaServiceOperationFactory;
  }

  public boolean b()
  {
    boolean bool1 = this.b.d();
    int i = 0;
    if (!bool1);
    boolean bool2;
    do
    {
      return i;
      bool2 = ((Boolean)this.c.b()).booleanValue();
      i = 0;
    }
    while (!bool2);
    long l = this.d.a(DbProperties.h, 0L);
    if (System.currentTimeMillis() - l > 10800000L);
    for (int j = 1; ; j = 0)
    {
      i = j;
      break;
    }
  }

  public ListenableFuture<BackgroundResult> c()
  {
    BLog.c(a, "Starting SyncTopLastActive");
    ListenableFuture localListenableFuture = this.e.a("sync_top_last_active", new Bundle()).d();
    SimpleBackgroundResultFutureCallback localSimpleBackgroundResultFutureCallback = new SimpleBackgroundResultFutureCallback(a);
    Futures.a(localListenableFuture, localSimpleBackgroundResultFutureCallback);
    return localSimpleBackgroundResultFutureCallback;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.SyncLastActiveForTopContactsBackgroundTask
 * JD-Core Version:    0.6.0
 */
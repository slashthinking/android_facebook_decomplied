package com.facebook.orca.database;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.contacts.data.DbContactsProperties;
import com.facebook.contacts.data.DbContactsPropertyUtil;
import com.facebook.orca.app.IHaveUserData;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

public class AddressBookPeriodicRunner
  implements IHaveUserData
{
  private static final Class<?> a = AddressBookPeriodicRunner.class;
  private final Context b;
  private final AlarmManager c;
  private final DbUsersPropertyUtil d;
  private final DbContactsPropertyUtil e;
  private final MeUserAuthDataStore f;
  private final OrcaServiceOperationFactory g;
  private final AddressBookPeriodicRunner.Hook h;
  private final Clock i;
  private final ExecutorService j;
  private final Provider<Boolean> k;
  private final Provider<Boolean> l;
  private final Provider<Boolean> m;
  private ListenableFuture<OperationResult> n;
  private ListenableFuture<OperationResult> o;
  private long p;
  private long q = -1L;
  private PendingIntent r;
  private volatile boolean s;
  private AddressBookPeriodicRunner.DownloadOrder t;

  @Inject
  public AddressBookPeriodicRunner(Context paramContext, AlarmManager paramAlarmManager, DbUsersPropertyUtil paramDbUsersPropertyUtil, DbContactsPropertyUtil paramDbContactsPropertyUtil, MeUserAuthDataStore paramMeUserAuthDataStore, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, Clock paramClock, ExecutorService paramExecutorService, Provider<Boolean> paramProvider1, Provider<Boolean> paramProvider2, Provider<Boolean> paramProvider3)
  {
    this.b = paramContext;
    this.c = paramAlarmManager;
    this.d = paramDbUsersPropertyUtil;
    this.e = paramDbContactsPropertyUtil;
    this.f = paramMeUserAuthDataStore;
    this.g = paramOrcaServiceOperationFactory;
    this.i = paramClock;
    this.j = paramExecutorService;
    this.k = paramProvider1;
    this.l = paramProvider2;
    this.m = paramProvider3;
    this.h = new AddressBookPeriodicRunner.Hook(this);
  }

  private void a(boolean paramBoolean)
  {
    this.j.submit(new AddressBookPeriodicRunner.1(this, paramBoolean));
  }

  private void b(boolean paramBoolean)
  {
    monitorenter;
    try
    {
      PendingIntent localPendingIntent = this.r;
      if ((localPendingIntent != null) && (!paramBoolean));
      while (true)
      {
        return;
        if ((this.s) || (!((Boolean)this.k.b()).booleanValue()) || (!h()))
          continue;
        if (paramBoolean)
          this.p = 0L;
        Intent localIntent = new Intent(this.b, AddressBookPeriodicRunner.LocalBroadcastReceiver.class);
        localIntent.setAction("com.facebook.orca.database.ACTION_ALARM");
        this.r = PendingIntent.getBroadcast(this.b, -1, localIntent, 0);
        long l1 = this.i.a() + this.p;
        this.c.set(1, l1, this.r);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private boolean h()
  {
    int i1;
    if (this.f.g() == null)
      i1 = 0;
    while (true)
    {
      return i1;
      long l2;
      if (this.q == -1L)
      {
        l2 = this.d.a(DbProperties.c, -1L);
        if (!((Boolean)this.l.b()).booleanValue())
          break label155;
      }
      label155: for (this.q = Math.min(l2, this.e.a(DbContactsProperties.a, -1L)); ; this.q = l2)
      {
        long l1 = this.i.a() - this.q;
        if ((this.q == -1L) || (l1 >= 3600000L))
          break label164;
        BLog.b(a, "Last sync was " + l1 / 60000L + " minutes ago, not syncing again.");
        i1 = 0;
        break;
      }
      label164: BLog.b(a, "Should sync friends/contacts.");
      i1 = 1;
    }
  }

  private void i()
  {
    monitorenter;
    try
    {
      this.n = null;
      if (this.t == AddressBookPeriodicRunner.DownloadOrder.FRIENDS_THEN_CONTACTS)
      {
        BLog.b(a, "Downloading friends complete, downloading contacts..");
        n();
      }
      while (true)
      {
        return;
        BLog.b(a, "Downloading friends complete.");
        k();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void j()
  {
    monitorenter;
    try
    {
      this.o = null;
      if (this.t == AddressBookPeriodicRunner.DownloadOrder.CONTACTS_THEN_FRIENDS)
      {
        BLog.b(a, "Downloading contacts complete, downloading friends..");
        m();
      }
      while (true)
      {
        return;
        BLog.b(a, "Downloading contacts complete.");
        k();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void k()
  {
    this.q = this.i.a();
    this.p = 0L;
    b(false);
  }

  private void l()
  {
    monitorenter;
    try
    {
      this.n = null;
      this.o = null;
      if (this.p == 0L);
      for (this.p = 30000L; ; this.p = (2L * this.p))
      {
        this.p = Math.min(this.p, 3600000L);
        b(false);
        return;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void m()
  {
    if (this.n == null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      Bundle localBundle = new Bundle();
      this.n = this.g.a("sync_address_book", localBundle).d();
      Futures.a(this.n, new AddressBookPeriodicRunner.3(this));
      return;
    }
  }

  private void n()
  {
    if (this.o == null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      Bundle localBundle = new Bundle();
      this.o = this.g.a("sync_contacts_partial", localBundle).d();
      Futures.a(this.o, new AddressBookPeriodicRunner.4(this));
      return;
    }
  }

  public AddressBookPeriodicRunner.Hook a()
  {
    return this.h;
  }

  public void b()
  {
    a(true);
  }

  public void c()
  {
    a(false);
  }

  void d()
  {
    this.j.submit(new AddressBookPeriodicRunner.2(this));
  }

  void e()
  {
    monitorenter;
    try
    {
      if (this.r != null)
        this.c.cancel(this.r);
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

  public void f()
  {
    monitorenter;
    try
    {
      BLog.b(a, "Clearing cached user data.");
      if (this.n != null)
      {
        this.n.cancel(false);
        this.n = null;
      }
      if (this.o != null)
      {
        this.o.cancel(false);
        this.o = null;
      }
      e();
      this.p = 0L;
      this.q = -1L;
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

  void g()
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (!h())
          continue;
        if ((this.n == null) && (this.o == null))
          continue;
        BLog.b(a, "Not processing address book (operation in progress)");
        return;
        if (!((Boolean)this.l.b()).booleanValue())
          break label110;
        if (((Boolean)this.m.b()).booleanValue())
        {
          this.t = AddressBookPeriodicRunner.DownloadOrder.CONTACTS_THEN_FRIENDS;
          if (this.t != AddressBookPeriodicRunner.DownloadOrder.CONTACTS_THEN_FRIENDS)
            break label120;
          n();
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      this.t = AddressBookPeriodicRunner.DownloadOrder.FRIENDS_THEN_CONTACTS;
      continue;
      label110: this.t = AddressBookPeriodicRunner.DownloadOrder.FRIENDS_ONLY;
      continue;
      label120: m();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.AddressBookPeriodicRunner
 * JD-Core Version:    0.6.0
 */
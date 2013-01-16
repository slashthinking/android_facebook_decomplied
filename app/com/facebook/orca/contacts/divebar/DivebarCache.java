package com.facebook.orca.contacts.divebar;

import com.facebook.orca.common.util.Clock;
import com.facebook.orca.prefs.PayForPlayPresence;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

public class DivebarCache
{
  private final Clock a;
  private final PresenceManager b;
  private final Provider<PayForPlayPresence> c;
  private ImmutableList<User> d;
  private long e;
  private ImmutableList<User> f;
  private long g;
  private boolean h;
  private boolean i;
  private ImmutableList<User> j;
  private long k;
  private ImmutableList<User> l;
  private long m;

  public DivebarCache(Clock paramClock, PresenceManager paramPresenceManager, Provider<PayForPlayPresence> paramProvider)
  {
    this.a = paramClock;
    this.b = paramPresenceManager;
    this.c = paramProvider;
  }

  private void f()
  {
    if ((this.d != null) && (this.a.a() - this.e > 3600000L))
      this.d = null;
    if (this.f != null)
    {
      if (((PayForPlayPresence)this.c.b()).shouldShowPresence())
        break label130;
      this.f = null;
    }
    while (true)
    {
      if ((this.j != null) && (this.a.a() - this.k > 3600000L))
        this.j = null;
      if ((this.l != null) && (this.a.a() - this.m > 3600000L))
        this.l = null;
      return;
      label130: if (this.a.a() - this.g <= 300000L)
        continue;
      this.f = null;
    }
  }

  public ImmutableList<User> a()
  {
    monitorenter;
    try
    {
      f();
      ImmutableList localImmutableList = this.d;
      monitorexit;
      return localImmutableList;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a(ImmutableList<User> paramImmutableList)
  {
    monitorenter;
    try
    {
      this.d = paramImmutableList;
      this.e = this.a.a();
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

  public ImmutableList<User> b()
  {
    monitorenter;
    try
    {
      f();
      ImmutableList localImmutableList = this.l;
      monitorexit;
      return localImmutableList;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void b(ImmutableList<User> paramImmutableList)
  {
    monitorenter;
    try
    {
      boolean bool = ((PayForPlayPresence)this.c.b()).shouldShowPresence();
      if (!bool);
      while (true)
      {
        return;
        this.f = paramImmutableList;
        this.g = this.a.a();
        this.h = false;
        if (this.i)
          continue;
        this.b.a(new DivebarCache.1(this));
        this.i = true;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public ImmutableList<User> c()
  {
    monitorenter;
    try
    {
      f();
      ImmutableList localImmutableList = this.f;
      monitorexit;
      return localImmutableList;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void c(ImmutableList<User> paramImmutableList)
  {
    monitorenter;
    try
    {
      this.l = paramImmutableList;
      this.m = this.a.a();
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

  public ImmutableList<User> d()
  {
    monitorenter;
    try
    {
      f();
      ImmutableList localImmutableList = this.j;
      monitorexit;
      return localImmutableList;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void d(ImmutableList<User> paramImmutableList)
  {
    monitorenter;
    try
    {
      this.j = paramImmutableList;
      this.k = this.a.a();
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

  public void e()
  {
    monitorenter;
    try
    {
      this.d = null;
      this.f = null;
      this.j = null;
      this.l = null;
      this.e = 0L;
      this.g = 0L;
      this.k = 0L;
      this.m = 0L;
      this.h = true;
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
 * Qualified Name:     com.facebook.orca.contacts.divebar.DivebarCache
 * JD-Core Version:    0.6.0
 */
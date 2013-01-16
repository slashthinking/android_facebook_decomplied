package com.facebook.orca.contacts.favorites;

import com.facebook.orca.common.util.Clock;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;

public class FavoriteContactsCache
{
  private ImmutableList<User> a;
  private long b;
  private final Clock c;

  public FavoriteContactsCache(Clock paramClock)
  {
    this.c = paramClock;
    this.b = 0L;
  }

  private void d()
  {
    monitorenter;
    try
    {
      if (this.c.a() - this.b > 3600000L)
        this.a = null;
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

  public void a()
  {
    this.a = null;
    this.b = 0L;
  }

  public void a(ImmutableList<User> paramImmutableList)
  {
    monitorenter;
    try
    {
      this.a = paramImmutableList;
      this.b = this.c.a();
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
      d();
      ImmutableList localImmutableList = this.a;
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

  public long c()
  {
    monitorenter;
    try
    {
      long l = this.b;
      monitorexit;
      return l;
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
 * Qualified Name:     com.facebook.orca.contacts.favorites.FavoriteContactsCache
 * JD-Core Version:    0.6.0
 */
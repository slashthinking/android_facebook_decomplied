package com.facebook.orca.contacts.favorites;

import com.facebook.orca.debug.BLog;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;

public class MobileAppDataCache
{
  private static final Class<?> a = MobileAppDataCache.class;
  private ImmutableList<User> b;
  private ImmutableList<User> c;

  public ImmutableList<User> a()
  {
    return this.b;
  }

  public void a(ImmutableList<User> paramImmutableList)
  {
    this.b = paramImmutableList;
    BLog.b(a, "mobile app data cache updated");
  }

  public ImmutableList<User> b()
  {
    return this.c;
  }

  public void b(ImmutableList<User> paramImmutableList)
  {
    this.c = paramImmutableList;
  }

  public void c()
  {
    this.b = null;
    this.c = null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.MobileAppDataCache
 * JD-Core Version:    0.6.0
 */
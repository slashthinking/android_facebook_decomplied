package com.facebook.orca.contacts.favorites;

import com.facebook.orca.debug.BLog;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;

public class TopLastActiveCache
{
  private static final Class<?> a = TopLastActiveCache.class;
  private ImmutableList<User> b;

  public ImmutableList<User> a()
  {
    return this.b;
  }

  public void a(ImmutableList<User> paramImmutableList)
  {
    this.b = paramImmutableList;
    BLog.b(a, "last actice data cache updated");
  }

  public void b()
  {
    this.b = null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.TopLastActiveCache
 * JD-Core Version:    0.6.0
 */
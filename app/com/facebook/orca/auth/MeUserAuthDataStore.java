package com.facebook.orca.auth;

import com.facebook.orca.users.User;

public abstract interface MeUserAuthDataStore extends AuthDataStore
{
  public abstract void a(User paramUser);

  public abstract void b(User paramUser);

  public abstract boolean d();

  public abstract void f();

  public abstract User g();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.auth.MeUserAuthDataStore
 * JD-Core Version:    0.6.0
 */
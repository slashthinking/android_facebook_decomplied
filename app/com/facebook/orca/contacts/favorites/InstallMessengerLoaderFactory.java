package com.facebook.orca.contacts.favorites;

import javax.inject.Provider;

public class InstallMessengerLoaderFactory
{
  private final Provider<InstallMessengerLoader> a;

  public InstallMessengerLoaderFactory(Provider<InstallMessengerLoader> paramProvider)
  {
    this.a = paramProvider;
  }

  public InstallMessengerLoader a()
  {
    return (InstallMessengerLoader)this.a.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.InstallMessengerLoaderFactory
 * JD-Core Version:    0.6.0
 */
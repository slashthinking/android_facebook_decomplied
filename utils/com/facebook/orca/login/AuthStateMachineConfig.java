package com.facebook.orca.login;

import com.facebook.orca.auth.AuthDataStore;
import com.google.common.collect.ImmutableMap;

public class AuthStateMachineConfig
{
  private final ImmutableMap<String, AuthFragmentConfig> a;
  private final LogoutFragment.Config b;
  private final AuthDataStore c;

  public AuthDataStore a()
  {
    return this.c;
  }

  public AuthFragmentConfig a(Class<? extends AuthFragmentBase> paramClass)
  {
    return (AuthFragmentConfig)this.a.get(paramClass.getCanonicalName());
  }

  public LogoutFragment.Config b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.AuthStateMachineConfig
 * JD-Core Version:    0.6.2
 */
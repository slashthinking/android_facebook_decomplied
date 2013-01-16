package com.facebook.orca.inject;

import javax.inject.Provider;

public abstract interface ProviderWithInjector<T> extends Provider<T>
{
  public abstract void a(FbInjector paramFbInjector);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.ProviderWithInjector
 * JD-Core Version:    0.6.0
 */
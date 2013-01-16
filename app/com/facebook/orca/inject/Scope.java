package com.facebook.orca.inject;

import javax.inject.Provider;

public abstract interface Scope extends javax.inject.Scope
{
  public abstract <T> Provider<T> a(Provider<T> paramProvider);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.Scope
 * JD-Core Version:    0.6.0
 */
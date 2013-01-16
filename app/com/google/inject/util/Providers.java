package com.google.inject.util;

import javax.inject.Provider;

public final class Providers
{
  public static <T> Provider<T> a(T paramT)
  {
    return new Providers.1(paramT);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.util.Providers
 * JD-Core Version:    0.6.0
 */
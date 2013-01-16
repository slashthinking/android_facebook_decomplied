package com.facebook.orca.inject;

import com.google.inject.Key;
import javax.inject.Provider;

public class RedirectProvider<T> extends AbstractProvider<T>
{
  private final Key<? extends T> a;
  private volatile Provider<? extends T> b;

  public RedirectProvider(Key<? extends T> paramKey)
  {
    this.a = paramKey;
  }

  public T b()
  {
    if (this.b == null)
      this.b = a(this.a);
    return this.b.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.RedirectProvider
 * JD-Core Version:    0.6.0
 */
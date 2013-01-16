package com.facebook.orca.inject;

import java.lang.annotation.Annotation;
import javax.inject.Provider;
import javax.inject.Singleton;

public class SingletonScope
  implements Scope
{
  private static SingletonScope a = new SingletonScope();

  public static SingletonScope get()
  {
    return a;
  }

  public <T> Provider<T> a(Provider<T> paramProvider)
  {
    return new SingletonProvider(paramProvider);
  }

  public Class<? extends Annotation> annotationType()
  {
    return Singleton.class;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.SingletonScope
 * JD-Core Version:    0.6.0
 */
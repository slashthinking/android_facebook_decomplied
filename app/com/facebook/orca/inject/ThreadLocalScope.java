package com.facebook.orca.inject;

import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class ThreadLocalScope
  implements Scope
{
  private static ThreadLocalScope a = new ThreadLocalScope();

  public static ThreadLocalScope get()
  {
    return a;
  }

  public <T> Provider<T> a(Provider<T> paramProvider)
  {
    return new ThreadLocalProvider(paramProvider);
  }

  public Class<? extends Annotation> annotationType()
  {
    return ThreadLocalScoped.class;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.ThreadLocalScope
 * JD-Core Version:    0.6.0
 */
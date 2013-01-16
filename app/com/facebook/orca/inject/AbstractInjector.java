package com.facebook.orca.inject;

import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.util.Set;
import javax.inject.Provider;

public abstract class AbstractInjector extends FbInjector
{
  public <T> T a(Key<T> paramKey)
  {
    return b(paramKey).b();
  }

  public <T> T a(Class<T> paramClass)
  {
    return b(paramClass).b();
  }

  public <T> T a(Class<T> paramClass, Class<? extends Annotation> paramClass1)
  {
    return b(Key.a(paramClass, paramClass1)).b();
  }

  public abstract <T> Provider<T> b(Key<T> paramKey);

  public <T> Provider<T> b(Class<T> paramClass)
  {
    return b(Key.a(paramClass));
  }

  public <T> Provider<T> b(Class<T> paramClass, Class<? extends Annotation> paramClass1)
  {
    return b(Key.a(paramClass, paramClass1));
  }

  public <T> Set<T> c(Class<T> paramClass)
  {
    return (Set)a(e(paramClass, null));
  }

  public <T> Set<T> c(Class<T> paramClass, Class<? extends Annotation> paramClass1)
  {
    return (Set)a(e(paramClass, paramClass1));
  }

  public <T> Provider<Set<T>> d(Class<T> paramClass)
  {
    return b(e(paramClass, null));
  }

  public <T> Provider<Set<T>> d(Class<T> paramClass, Class<? extends Annotation> paramClass1)
  {
    return b(e(paramClass, paramClass1));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.AbstractInjector
 * JD-Core Version:    0.6.0
 */
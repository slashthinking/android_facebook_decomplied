package com.facebook.orca.inject;

import com.google.common.collect.Sets;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.util.Set;

public class MultiBinding<T>
{
  private final Key<T> a;
  private final Set<Key<? extends T>> b;

  public MultiBinding(Key<T> paramKey)
  {
    this.a = paramKey;
    this.b = Sets.b();
  }

  public MultiBinding<T> a(Key<? extends T> paramKey)
  {
    this.b.add(paramKey);
    return this;
  }

  public MultiBinding<T> a(Class<? extends T> paramClass)
  {
    this.b.add(Key.a(paramClass));
    return this;
  }

  public MultiBinding<T> a(Class<? extends T> paramClass, Class<? extends Annotation> paramClass1)
  {
    return a(Key.a(paramClass, paramClass1));
  }

  public Set<Key<? extends T>> a()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.MultiBinding
 * JD-Core Version:    0.6.0
 */
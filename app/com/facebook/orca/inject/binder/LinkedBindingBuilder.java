package com.facebook.orca.inject.binder;

import java.lang.annotation.Annotation;
import javax.inject.Provider;

public abstract interface LinkedBindingBuilder<T> extends ScopedBindingBuilder
{
  public abstract ScopedBindingBuilder a(Class<? extends T> paramClass, Class<? extends Annotation> paramClass1);

  public abstract ScopedBindingBuilder a(Provider<? extends T> paramProvider);

  public abstract void a(T paramT);

  public abstract ScopedBindingBuilder b(Class<? extends T> paramClass);

  public abstract ScopedBindingBuilder c(Class<? extends Provider<? extends T>> paramClass);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.binder.LinkedBindingBuilder
 * JD-Core Version:    0.6.0
 */
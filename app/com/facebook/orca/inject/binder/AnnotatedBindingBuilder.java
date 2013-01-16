package com.facebook.orca.inject.binder;

import java.lang.annotation.Annotation;

public abstract interface AnnotatedBindingBuilder<T> extends LinkedBindingBuilder<T>
{
  public abstract LinkedBindingBuilder<T> a(Class<? extends Annotation> paramClass);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.binder.AnnotatedBindingBuilder
 * JD-Core Version:    0.6.0
 */
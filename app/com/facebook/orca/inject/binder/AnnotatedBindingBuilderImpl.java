package com.facebook.orca.inject.binder;

import com.facebook.orca.inject.Binding;
import com.google.inject.Key;
import java.lang.annotation.Annotation;

public class AnnotatedBindingBuilderImpl<T> extends LinkedBindingBuilderImpl<T>
  implements AnnotatedBindingBuilder<T>
{
  public AnnotatedBindingBuilderImpl(Binding<T> paramBinding)
  {
    super(paramBinding);
  }

  public LinkedBindingBuilder<T> a(Class<? extends Annotation> paramClass)
  {
    this.a.a(Key.a(this.a.a().a(), paramClass));
    return new LinkedBindingBuilderImpl(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.binder.AnnotatedBindingBuilderImpl
 * JD-Core Version:    0.6.0
 */
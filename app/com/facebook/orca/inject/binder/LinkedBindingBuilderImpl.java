package com.facebook.orca.inject.binder;

import com.facebook.orca.inject.Binding;
import com.facebook.orca.inject.InstanceProvider;
import com.facebook.orca.inject.RedirectProvider;
import com.facebook.orca.inject.ReflectionProviderPassThrough;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class LinkedBindingBuilderImpl<T> extends ScopedBindingBuilderImpl<T>
  implements LinkedBindingBuilder<T>
{
  public LinkedBindingBuilderImpl(Binding<T> paramBinding)
  {
    super(paramBinding);
  }

  public ScopedBindingBuilder a(Key<? extends T> paramKey)
  {
    this.a.a(new RedirectProvider(paramKey));
    return new ScopedBindingBuilderImpl(this.a);
  }

  public ScopedBindingBuilder a(Class<? extends T> paramClass, Class<? extends Annotation> paramClass1)
  {
    return a(Key.a(paramClass, paramClass1));
  }

  public ScopedBindingBuilder a(Provider<? extends T> paramProvider)
  {
    this.a.a(paramProvider);
    return new ScopedBindingBuilderImpl(this.a);
  }

  public void a(T paramT)
  {
    this.a.a(new InstanceProvider(paramT));
  }

  public ScopedBindingBuilder b(Class<? extends T> paramClass)
  {
    this.a.a(new RedirectProvider(Key.a(paramClass)));
    return new ScopedBindingBuilderImpl(this.a);
  }

  public ScopedBindingBuilder c(Class<? extends Provider<? extends T>> paramClass)
  {
    this.a.a(new ReflectionProviderPassThrough(paramClass));
    return new ScopedBindingBuilderImpl(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.binder.LinkedBindingBuilderImpl
 * JD-Core Version:    0.6.0
 */
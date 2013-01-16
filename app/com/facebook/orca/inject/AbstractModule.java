package com.facebook.orca.inject;

import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.google.inject.Key;
import java.lang.annotation.Annotation;

public abstract class AbstractModule
  implements Module
{
  private Binder a;

  protected <T> MultiBinding<T> a(Class<T> paramClass, Class<? extends Annotation> paramClass1)
  {
    return this.a.c(Key.a(paramClass, paramClass1));
  }

  protected <T> AnnotatedBindingBuilder<T> a(Class<T> paramClass)
  {
    return this.a.a(paramClass);
  }

  protected <T> LinkedBindingBuilder<T> a(Key<T> paramKey)
  {
    return this.a.a(paramKey);
  }

  protected abstract void a();

  public final void a(Binder paramBinder)
  {
    this.a = paramBinder;
    a();
  }

  public void a(FbInjector paramFbInjector)
  {
  }

  protected void a(Module paramModule)
  {
    this.a.a(paramModule);
  }

  protected void a(Class<? extends Annotation> paramClass, Scope paramScope)
  {
    this.a.a(paramClass, paramScope);
  }

  protected <T> AnnotatedBindingBuilder<T> b(Class<T> paramClass)
  {
    return this.a.b(paramClass);
  }

  protected <T> LinkedBindingBuilder<T> b(Key<T> paramKey)
  {
    return this.a.b(paramKey);
  }

  protected <T> MultiBinding<T> c(Key<T> paramKey)
  {
    return this.a.c(paramKey);
  }

  protected <T> MultiBinding<T> c(Class<T> paramClass)
  {
    return this.a.c(paramClass);
  }

  protected <T> void d(Class<T> paramClass)
  {
    this.a.d(paramClass);
  }

  protected void e(Class<? extends Module> paramClass)
  {
    this.a.e(paramClass);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.AbstractModule
 * JD-Core Version:    0.6.0
 */
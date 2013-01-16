package com.facebook.orca.inject;

import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract interface Binder
{
  public abstract <T> AnnotatedBindingBuilder<T> a(Class<T> paramClass);

  public abstract <T> LinkedBindingBuilder<T> a(Key<T> paramKey);

  public abstract List<Binding> a();

  public abstract void a(Module paramModule);

  public abstract void a(Class<? extends Annotation> paramClass, Scope paramScope);

  public abstract <T> AnnotatedBindingBuilder<T> b(Class<T> paramClass);

  public abstract <T> LinkedBindingBuilder<T> b(Key<T> paramKey);

  public abstract Map<Key, MultiBinding> b();

  public abstract <T> MultiBinding<T> c(Key<T> paramKey);

  public abstract <T> MultiBinding<T> c(Class<T> paramClass);

  public abstract Set<Key> c();

  public abstract Set<Class<? extends Module>> d();

  public abstract <T> void d(Class<T> paramClass);

  public abstract List<Module> e();

  public abstract void e(Class<? extends Module> paramClass);

  public abstract Map<Class<? extends Annotation>, Scope> f();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.Binder
 * JD-Core Version:    0.6.0
 */
package com.facebook.orca.inject;

import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilderImpl;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BinderImpl
  implements Binder
{
  private final List<Binding> a = Lists.a();
  private final Map<Key, MultiBinding> b = Maps.a();
  private final List<Module> c = Lists.a();
  private Set<Key> d;
  private Set<Class<? extends Module>> e;
  private Map<Class<? extends Annotation>, Scope> f;

  private <T> Binding<T> d(Key<T> paramKey)
  {
    Binding localBinding = new Binding();
    localBinding.a(paramKey);
    this.a.add(localBinding);
    return localBinding;
  }

  private <T> MultiBinding<T> e(Key<T> paramKey)
  {
    MultiBinding localMultiBinding = (MultiBinding)this.b.get(paramKey);
    if (localMultiBinding == null)
    {
      localMultiBinding = new MultiBinding(paramKey);
      this.b.put(paramKey, localMultiBinding);
    }
    return localMultiBinding;
  }

  public <T> AnnotatedBindingBuilder<T> a(Class<T> paramClass)
  {
    return new AnnotatedBindingBuilderImpl(d(Key.a(paramClass)));
  }

  public <T> LinkedBindingBuilder<T> a(Key<T> paramKey)
  {
    return new AnnotatedBindingBuilderImpl(d(paramKey));
  }

  public List<Binding> a()
  {
    return this.a;
  }

  public void a(Module paramModule)
  {
    this.c.add(paramModule);
  }

  public void a(Class<? extends Annotation> paramClass, Scope paramScope)
  {
    if (this.f == null)
      this.f = Maps.a();
    this.f.put(paramClass, paramScope);
  }

  public <T> AnnotatedBindingBuilder<T> b(Class<T> paramClass)
  {
    Binding localBinding = d(Key.a(paramClass));
    localBinding.a(true);
    return new AnnotatedBindingBuilderImpl(localBinding);
  }

  public <T> LinkedBindingBuilder<T> b(Key<T> paramKey)
  {
    Binding localBinding = d(paramKey);
    localBinding.a(true);
    return new AnnotatedBindingBuilderImpl(localBinding);
  }

  public Map<Key, MultiBinding> b()
  {
    return this.b;
  }

  public <T> MultiBinding<T> c(Key<T> paramKey)
  {
    return e(paramKey);
  }

  public <T> MultiBinding<T> c(Class<T> paramClass)
  {
    return e(Key.a(paramClass));
  }

  public Set<Key> c()
  {
    if (this.d != null);
    for (Object localObject = this.d; ; localObject = ImmutableSet.d())
      return localObject;
  }

  public Set<Class<? extends Module>> d()
  {
    if (this.e != null);
    for (Object localObject = this.e; ; localObject = ImmutableSet.d())
      return localObject;
  }

  public <T> void d(Class<T> paramClass)
  {
    if (this.d == null)
      this.d = Sets.a();
    this.d.add(Key.a(paramClass));
  }

  public List<Module> e()
  {
    return this.c;
  }

  public void e(Class<? extends Module> paramClass)
  {
    if (this.e == null)
      this.e = Sets.a();
    this.e.add(paramClass);
  }

  public Map<Class<? extends Annotation>, Scope> f()
  {
    if (this.f == null);
    for (Object localObject = ImmutableMap.j(); ; localObject = this.f)
      return localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.BinderImpl
 * JD-Core Version:    0.6.0
 */
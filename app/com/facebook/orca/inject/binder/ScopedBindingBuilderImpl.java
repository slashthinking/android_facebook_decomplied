package com.facebook.orca.inject.binder;

import com.facebook.orca.inject.Binding;
import com.facebook.orca.inject.ContextScoped;
import com.facebook.orca.inject.ThreadLocalScoped;
import javax.inject.Singleton;

public class ScopedBindingBuilderImpl<T>
  implements ScopedBindingBuilder
{
  protected final Binding<T> a;

  public ScopedBindingBuilderImpl(Binding<T> paramBinding)
  {
    this.a = paramBinding;
  }

  public void a()
  {
    this.a.a(Singleton.class);
  }

  public void b()
  {
    this.a.a(Singleton.class);
    this.a.e();
  }

  public void c()
  {
    this.a.a(ThreadLocalScoped.class);
  }

  public void d()
  {
    this.a.a(Singleton.class);
    this.a.g();
  }

  public void e()
  {
    this.a.a(ContextScoped.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.binder.ScopedBindingBuilderImpl
 * JD-Core Version:    0.6.0
 */
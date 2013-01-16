package com.facebook.orca.inject;

import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class Binding<T>
{
  private Key<T> a;
  private Provider<? extends T> b;
  private Class<? extends Annotation> c;
  private boolean d;
  private boolean e;
  private boolean f;

  public Key<T> a()
  {
    return this.a;
  }

  public void a(Key<T> paramKey)
  {
    this.a = paramKey;
  }

  public void a(Class<? extends Annotation> paramClass)
  {
    this.c = paramClass;
  }

  public void a(Provider<? extends T> paramProvider)
  {
    this.b = paramProvider;
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public Provider<? extends T> b()
  {
    return this.b;
  }

  public Class<? extends Annotation> c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.d;
  }

  public void e()
  {
    this.d = true;
  }

  public boolean f()
  {
    return this.e;
  }

  public void g()
  {
    this.e = true;
  }

  public boolean h()
  {
    return this.f;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.Binding
 * JD-Core Version:    0.6.0
 */
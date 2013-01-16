package com.facebook.orca.inject;

import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.util.Set;
import javax.inject.Provider;

public abstract class AbstractProvider<T>
  implements ProviderWithInjector<T>
{
  private FbInjector a;

  protected <S> Provider<S> a(Key<S> paramKey)
  {
    return this.a.b(paramKey);
  }

  protected <S> Provider<S> a(Class<S> paramClass)
  {
    return this.a.b(paramClass);
  }

  protected <S> Provider<S> a(Class<S> paramClass, Class<? extends Annotation> paramClass1)
  {
    return this.a.b(paramClass, paramClass1);
  }

  public void a(FbInjector paramFbInjector)
  {
    this.a = paramFbInjector;
  }

  protected <S> S b(Key<S> paramKey)
  {
    return this.a.a(paramKey);
  }

  protected <S> S b(Class<S> paramClass)
  {
    return this.a.a(paramClass);
  }

  protected <S> S b(Class<S> paramClass, Class<? extends Annotation> paramClass1)
  {
    return this.a.a(paramClass, paramClass1);
  }

  protected <S> Set<S> c(Class<S> paramClass)
  {
    return this.a.c(paramClass);
  }

  protected <S> Set<S> c(Class<S> paramClass, Class<? extends Annotation> paramClass1)
  {
    return this.a.c(paramClass, paramClass1);
  }

  protected FbInjector d()
  {
    return this.a;
  }

  protected <S> Provider<Set<S>> d(Class<S> paramClass)
  {
    return this.a.d(paramClass);
  }

  protected <S> Provider<Set<S>> d(Class<S> paramClass, Class<? extends Annotation> paramClass1)
  {
    return this.a.d(paramClass, paramClass1);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.AbstractProvider
 * JD-Core Version:    0.6.0
 */
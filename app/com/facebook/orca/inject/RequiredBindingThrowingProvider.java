package com.facebook.orca.inject;

import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class RequiredBindingThrowingProvider<T>
  implements Provider<T>
{
  private final Key<T> a;

  public RequiredBindingThrowingProvider(Key<T> paramKey)
  {
    this.a = paramKey;
  }

  public static <T> RequiredBindingThrowingProvider<T> a(Class<T> paramClass, Class<? extends Annotation> paramClass1)
  {
    return new RequiredBindingThrowingProvider(Key.a(paramClass, paramClass1));
  }

  public T b()
  {
    throw new RuntimeException("Application did not provide a binding for " + this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.RequiredBindingThrowingProvider
 * JD-Core Version:    0.6.0
 */
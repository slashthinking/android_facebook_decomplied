package com.facebook.orca.inject;

import android.content.Context;
import com.google.common.collect.MapMaker;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.MoreTypes.ParameterizedTypeImpl;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import javax.inject.Provider;

public abstract class FbInjector
{
  private static ConcurrentMap<Context, ContextAwareInjector> a = new MapMaker().f().h().n();

  public static FbInjector a(Context paramContext)
  {
    Object localObject = (ContextAwareInjector)a.get(paramContext);
    if (localObject == null)
    {
      FbInjector localFbInjector = ((FbInjectorProvider)paramContext.getApplicationContext()).d();
      if (localFbInjector == null)
        throw new IllegalStateException("Can NOT get FbInjector instance! Probably because this method was called in ContentProvider's onCreate.");
      ContextAwareInjector localContextAwareInjector = new ContextAwareInjector(localFbInjector, (ContextScope)localFbInjector.a(ContextScope.class), paramContext);
      a.put(paramContext, localContextAwareInjector);
      localObject = localContextAwareInjector;
    }
    return (FbInjector)localObject;
  }

  public static FbInjector a(List<? extends Module> paramList)
  {
    return new FbInjectorImpl(paramList, true);
  }

  public abstract <T> T a(Key<T> paramKey);

  public abstract <T> T a(Class<T> paramClass);

  public abstract <T> T a(Class<T> paramClass, Class<? extends Annotation> paramClass1);

  public abstract <T> Provider<T> b(Key<T> paramKey);

  public abstract <T> Provider<T> b(Class<T> paramClass);

  public abstract <T> Provider<T> b(Class<T> paramClass, Class<? extends Annotation> paramClass1);

  public abstract <T> Set<T> c(Class<T> paramClass);

  public abstract <T> Set<T> c(Class<T> paramClass, Class<? extends Annotation> paramClass1);

  public abstract <T> Provider<Set<T>> d(Class<T> paramClass);

  public abstract <T> Provider<Set<T>> d(Class<T> paramClass, Class<? extends Annotation> paramClass1);

  protected <T> Key<Set<T>> e(Class<T> paramClass, Class<? extends Annotation> paramClass1)
  {
    TypeLiteral localTypeLiteral = TypeLiteral.a(new MoreTypes.ParameterizedTypeImpl(null, Set.class, new Type[] { paramClass }));
    if (paramClass1 != null);
    for (Key localKey = Key.a(localTypeLiteral, paramClass1); ; localKey = Key.a(localTypeLiteral))
      return localKey;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.FbInjector
 * JD-Core Version:    0.6.0
 */
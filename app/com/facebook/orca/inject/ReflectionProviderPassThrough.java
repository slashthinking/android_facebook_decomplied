package com.facebook.orca.inject;

import android.util.Pair;
import com.google.common.collect.Lists;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.Annotations;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Constructor<Ljavax.inject.Provider<TT;>;>;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

public class ReflectionProviderPassThrough<T> extends AbstractProvider<T>
{
  private static ThreadLocal<Boolean> a = new ReflectionProviderPassThrough.1();
  private final Class<? extends Provider<? extends T>> b;
  private Provider<T> c;

  public ReflectionProviderPassThrough(Class<? extends Provider<? extends T>> paramClass)
  {
    this.b = paramClass;
    e();
  }

  public static boolean a()
  {
    return ((Boolean)a.get()).booleanValue();
  }

  private Provider<T> c()
  {
    Constructor localConstructor = e();
    Type[] arrayOfType = localConstructor.getGenericParameterTypes();
    Annotation[][] arrayOfAnnotation = localConstructor.getParameterAnnotations();
    ArrayList localArrayList1 = Lists.c(arrayOfType.length);
    int i = 0;
    Type localType;
    Object localObject1;
    TypeLiteral localTypeLiteral1;
    boolean bool;
    if (i < arrayOfType.length)
    {
      localType = arrayOfType[i];
      Annotation[] arrayOfAnnotation1 = arrayOfAnnotation[i];
      localObject1 = null;
      int j = arrayOfAnnotation1.length;
      int k = 0;
      while (k < j)
      {
        Object localObject2 = arrayOfAnnotation1[k];
        if (Annotations.b(((Annotation)localObject2).annotationType()))
        {
          if (localObject1 != null)
            throw new RuntimeException("Parameter " + i + " for constructor of " + this.b.getName() + " has multiple binding annotations");
        }
        else
          localObject2 = localObject1;
        k++;
        localObject1 = localObject2;
      }
      localTypeLiteral1 = TypeLiteral.a(localType);
      bool = Provider.class.isAssignableFrom(localTypeLiteral1.a());
      if (!bool)
        break label394;
    }
    label394: for (TypeLiteral localTypeLiteral2 = TypeLiteral.a(((java.lang.reflect.ParameterizedType)localType).getActualTypeArguments()[0]); ; localTypeLiteral2 = localTypeLiteral1)
    {
      if (localObject1 != null);
      for (Key localKey2 = Key.a(localTypeLiteral2, localObject1); ; localKey2 = Key.a(localTypeLiteral2))
      {
        localArrayList1.add(Pair.create(localKey2, Boolean.valueOf(bool)));
        i++;
        break;
      }
      ArrayList localArrayList2 = Lists.c(localArrayList1.size());
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        Key localKey1 = (Key)localPair.first;
        if (((Boolean)localPair.second).booleanValue())
        {
          localArrayList2.add(a(localKey1));
          continue;
        }
        localArrayList2.add(b(localKey1));
      }
      try
      {
        Provider localProvider = (Provider)localConstructor.newInstance(localArrayList2.toArray());
        return localProvider;
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new RuntimeException(localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException(localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException);
      }
    }
  }

  private Constructor<Provider<T>> e()
  {
    Constructor[] arrayOfConstructor = this.b.getConstructors();
    Object localObject1 = null;
    int i = arrayOfConstructor.length;
    int j = 0;
    while (j < i)
    {
      Object localObject2 = arrayOfConstructor[j];
      if (((Constructor)localObject2).getAnnotation(Inject.class) != null)
      {
        if (localObject1 != null)
          throw new RuntimeException(this.b.getName() + " has multiple constructors with @Inject");
      }
      else
        localObject2 = localObject1;
      j++;
      localObject1 = localObject2;
    }
    if (localObject1 == null)
      throw new RuntimeException(this.b.getName() + " does not have a constructor with @Inject");
    return (Constructor<Provider<T>>)localObject1;
  }

  public T b()
  {
    monitorenter;
    try
    {
      boolean bool;
      if (this.c == null)
      {
        bool = ((Boolean)a.get()).booleanValue();
        a.set(Boolean.valueOf(true));
      }
      try
      {
        this.c = c();
        a.set(Boolean.valueOf(bool));
        Object localObject2 = this.c.b();
        monitorexit;
        return localObject2;
      }
      finally
      {
        localObject3 = finally;
        a.set(Boolean.valueOf(bool));
        throw localObject3;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.ReflectionProviderPassThrough
 * JD-Core Version:    0.6.0
 */
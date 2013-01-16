package com.facebook.dex_tricks;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class SystemClassLoaderAdder
{
  private Object a(BaseDexClassLoader paramBaseDexClassLoader)
  {
    return a(paramBaseDexClassLoader, BaseDexClassLoader.class, "pathList");
  }

  private Object a(Object paramObject)
  {
    return a(paramObject, paramObject.getClass(), "dexElements");
  }

  private Object a(Object paramObject, Class<?> paramClass, String paramString)
  {
    Field localField = paramClass.getDeclaredField(paramString);
    localField.setAccessible(true);
    return localField.get(paramObject);
  }

  private void a(Object paramObject1, Class<?> paramClass, String paramString, Object paramObject2)
  {
    Field localField = paramClass.getDeclaredField(paramString);
    localField.setAccessible(true);
    localField.set(paramObject1, paramObject2);
  }

  private void a(Object paramObject1, Object paramObject2)
  {
    a(paramObject1, paramObject1.getClass(), "dexElements", paramObject2);
  }

  private Object b(Object paramObject1, Object paramObject2)
  {
    Class localClass = paramObject1.getClass().getComponentType();
    int i = Array.getLength(paramObject1);
    int j = i + Array.getLength(paramObject2);
    Object localObject = Array.newInstance(localClass, j);
    int k = 0;
    if (k < j)
    {
      if (k < i)
        Array.set(localObject, k, Array.get(paramObject1, k));
      while (true)
      {
        k++;
        break;
        Array.set(localObject, k, Array.get(paramObject2, k - i));
      }
    }
    return localObject;
  }

  private void b(DexClassLoader paramDexClassLoader, PathClassLoader paramPathClassLoader)
  {
    Object localObject = b(a(a(paramPathClassLoader)), a(a(paramDexClassLoader)));
    a(a(paramPathClassLoader), localObject);
  }

  private Object c(Object paramObject1, Object paramObject2)
  {
    Class localClass = paramObject1.getClass().getComponentType();
    int i = Array.getLength(paramObject1);
    int j = i + 1;
    Object localObject = Array.newInstance(localClass, j);
    int k = 0;
    if (k < j)
    {
      if (k < i)
        Array.set(localObject, k, Array.get(paramObject1, k));
      while (true)
      {
        k++;
        break;
        Array.set(localObject, k, paramObject2);
      }
    }
    return localObject;
  }

  private void c(DexClassLoader paramDexClassLoader, PathClassLoader paramPathClassLoader)
  {
    try
    {
      paramDexClassLoader.loadClass("foo");
      label7: a(paramPathClassLoader, PathClassLoader.class, "mPaths", c(a(paramPathClassLoader, PathClassLoader.class, "mPaths"), a(paramDexClassLoader, DexClassLoader.class, "mRawDexPath")));
      a(paramPathClassLoader, PathClassLoader.class, "mFiles", b(a(paramPathClassLoader, PathClassLoader.class, "mFiles"), a(paramDexClassLoader, DexClassLoader.class, "mFiles")));
      a(paramPathClassLoader, PathClassLoader.class, "mZips", b(a(paramPathClassLoader, PathClassLoader.class, "mZips"), a(paramDexClassLoader, DexClassLoader.class, "mZips")));
      a(paramPathClassLoader, PathClassLoader.class, "mDexs", b(a(paramPathClassLoader, PathClassLoader.class, "mDexs"), a(paramDexClassLoader, DexClassLoader.class, "mDexs")));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label7;
    }
  }

  void a(DexClassLoader paramDexClassLoader, PathClassLoader paramPathClassLoader)
  {
    try
    {
      try
      {
        Class.forName("dalvik.system.BaseDexClassLoader");
        i = 1;
        if (i != 0)
          b(paramDexClassLoader, paramPathClassLoader);
        else
          c(paramDexClassLoader, paramPathClassLoader);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        throw new RuntimeException(localNoSuchFieldException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException(localIllegalAccessException);
      }
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        int i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.dex_tricks.SystemClassLoaderAdder
 * JD-Core Version:    0.6.0
 */
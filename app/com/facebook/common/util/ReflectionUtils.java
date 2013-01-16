package com.facebook.common.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtils
{
  public static <T> Map<? extends AccessibleObject, T> a(Class<?> paramClass, ReflectionUtils.Filter<T> paramFilter, EnumSet<ReflectionUtils.IncludeFlags> paramEnumSet)
  {
    HashMap localHashMap = new HashMap();
    a(paramClass, paramFilter, paramEnumSet, localHashMap);
    return localHashMap;
  }

  protected static <T> void a(Class<?> paramClass, ReflectionUtils.Filter<T> paramFilter, EnumSet<ReflectionUtils.IncludeFlags> paramEnumSet, Map<AccessibleObject, T> paramMap)
  {
    int i = 0;
    if (paramEnumSet.contains(ReflectionUtils.IncludeFlags.INCLUDE_SUPERCLASSES))
    {
      Class localClass = paramClass.getSuperclass();
      if (localClass != null)
        a(localClass, paramFilter, paramEnumSet, paramMap);
    }
    if (paramEnumSet.contains(ReflectionUtils.IncludeFlags.INCLUDE_CONSTRUCTORS))
    {
      Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
      for (int k = 0; k < arrayOfConstructor.length; k++)
      {
        Object localObject3 = paramFilter.b(arrayOfConstructor[k]);
        if (localObject3 == null)
          continue;
        paramMap.put(arrayOfConstructor[k], localObject3);
      }
    }
    if (paramEnumSet.contains(ReflectionUtils.IncludeFlags.INCLUDE_METHODS))
    {
      Method[] arrayOfMethod = paramClass.getDeclaredMethods();
      for (int j = 0; j < arrayOfMethod.length; j++)
      {
        Object localObject2 = paramFilter.b(arrayOfMethod[j]);
        if (localObject2 == null)
          continue;
        paramMap.put(arrayOfMethod[j], localObject2);
      }
    }
    if (paramEnumSet.contains(ReflectionUtils.IncludeFlags.INCLUDE_FIELDS))
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      while (i < arrayOfField.length)
      {
        Object localObject1 = paramFilter.b(arrayOfField[i]);
        if (localObject1 != null)
          paramMap.put(arrayOfField[i], localObject1);
        i++;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.ReflectionUtils
 * JD-Core Version:    0.6.0
 */
package com.facebook.common.json.jsonmirror.types;

import com.facebook.common.json.jsonmirror.JMDictDestination;
import com.facebook.common.json.jsonmirror.JMException;
import com.facebook.common.json.jsonmirror.JMFatalException;
import com.facebook.common.util.Tuple;
import com.facebook.orca.debug.BLog;
import com.google.common.collect.Maps;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JMStaticKeysDict extends JMDict
{
  protected static final Map<Class<? extends JMDictDestination>, Map<String, Field>> h;
  private static final Class<?> i = JMStaticKeysDict.class;
  public final boolean g;
  private final Map<String, Tuple<String, JMBase>> j;
  private final Constructor<? extends JMDictDestination> k;

  static
  {
    h = Maps.a();
  }

  public JMStaticKeysDict(Class<? extends JMDictDestination> paramClass, Map<String, Tuple<String, JMBase>> paramMap, boolean paramBoolean)
  {
    try
    {
      this.k = paramClass.getDeclaredConstructor(new Class[0]);
      this.k.setAccessible(true);
      this.j = paramMap;
      this.g = paramBoolean;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    throw new JMFatalException("You need to add a no-argument constructor to class " + b(paramClass) + " to use it with jsonmirror.");
  }

  public static Field a(JMDictDestination paramJMDictDestination, String paramString)
  {
    Class localClass1 = paramJMDictDestination.getClass();
    Map localMap = (Map)h.get(localClass1);
    Object localObject;
    Field localField1;
    if (localMap != null)
    {
      Field localField2 = (Field)localMap.get(paramString);
      localObject = localMap;
      localField1 = localField2;
    }
    while (true)
    {
      Class localClass2;
      if (localField1 == null)
      {
        localClass2 = localClass1;
        label49: if ((localClass2 == null) || (localField1 != null));
      }
      try
      {
        localField1 = localClass2.getDeclaredField(paramString);
        localField1.setAccessible(true);
        ((Map)localObject).put(paramString, localField1);
        label84: localClass2 = localClass2.getSuperclass();
        break label49;
        HashMap localHashMap = Maps.a();
        h.put(localClass1, localHashMap);
        localObject = localHashMap;
        localField1 = null;
        continue;
        if (localField1 == null)
          throw new JMException("cannot find field " + paramString + " in class " + localClass1.getName());
        return localField1;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label84;
      }
    }
  }

  public static void a(JMDictDestination paramJMDictDestination, String paramString, Object paramObject)
  {
    Field localField = a(paramJMDictDestination, paramString);
    int m = 0;
    if (localField != null);
    try
    {
      localField.set(paramJMDictDestination, paramObject);
      m = 1;
      if (m == 0)
        BLog.e(i, "Unable to write to field " + paramString);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        m = 0;
    }
  }

  private static String b(Class<?> paramClass)
  {
    String str = paramClass.getName();
    int m = str.lastIndexOf(".");
    if (m != -1)
      str = str.substring(m + 1);
    return str;
  }

  public Tuple<String, JMBase> a(String paramString)
  {
    return (Tuple)this.j.get(paramString);
  }

  public Map<String, Tuple<String, JMBase>> a()
  {
    return this.j;
  }

  public void a(JMDictDestination paramJMDictDestination, String paramString, double paramDouble)
  {
    Field localField = a(paramJMDictDestination, paramString);
    int m = 0;
    Class localClass1;
    if (localField != null)
      localClass1 = localField.getType();
    try
    {
      if ((localClass1 == Double.class) || (localClass1 == Double.TYPE))
      {
        localField.setDouble(paramJMDictDestination, paramDouble);
        m = 1;
      }
      while (true)
      {
        if (m == 0)
          BLog.e(i, "Unable to write to field " + paramString);
        return;
        if (localClass1 != Float.class)
        {
          Class localClass2 = Float.TYPE;
          m = 0;
          if (localClass1 != localClass2)
            continue;
        }
        localField.setFloat(paramJMDictDestination, (float)paramDouble);
        m = 1;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        m = 0;
    }
  }

  public void a(JMDictDestination paramJMDictDestination, String paramString, long paramLong)
  {
    Field localField = a(paramJMDictDestination, paramString);
    int m = 0;
    Class localClass1;
    if (localField != null)
      localClass1 = localField.getType();
    try
    {
      if ((localClass1 == Long.class) || (localClass1 == Long.TYPE))
      {
        localField.setLong(paramJMDictDestination, paramLong);
        m = 1;
      }
      while (true)
      {
        if (m == 0)
          BLog.e(i, "Unable to write to field " + paramString);
        return;
        if (localClass1 != Integer.class)
        {
          Class localClass2 = Integer.TYPE;
          m = 0;
          if (localClass1 != localClass2)
            continue;
        }
        localField.setInt(paramJMDictDestination, (int)paramLong);
        m = 1;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        m = 0;
    }
  }

  public void a(JMDictDestination paramJMDictDestination1, String paramString, JMDictDestination paramJMDictDestination2)
  {
    a(paramJMDictDestination1, paramString, paramJMDictDestination2);
  }

  public void a(JMDictDestination paramJMDictDestination, String paramString1, String paramString2)
  {
    a(paramJMDictDestination, paramString1, paramString2);
  }

  public void a(JMDictDestination paramJMDictDestination, String paramString, List<Object> paramList)
  {
    a(paramJMDictDestination, paramString, paramList);
  }

  public void a(JMDictDestination paramJMDictDestination, String paramString, Map<String, Object> paramMap)
  {
    a(paramJMDictDestination, paramString, paramMap);
  }

  public void a(JMDictDestination paramJMDictDestination, String paramString, boolean paramBoolean)
  {
    Field localField = a(paramJMDictDestination, paramString);
    int m = 0;
    if (localField != null);
    try
    {
      localField.setBoolean(paramJMDictDestination, paramBoolean);
      m = 1;
      if (m == 0)
        BLog.e(i, "Unable to write to field " + paramString);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        m = 0;
    }
  }

  public JMDictDestination b()
  {
    try
    {
      localJMDictDestination = (JMDictDestination)this.k.newInstance(new Object[0]);
      return localJMDictDestination;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
      {
        BLog.e(i, "Illegal argument exception", localIllegalArgumentException);
        JMDictDestination localJMDictDestination = null;
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      while (true)
        BLog.e(i, "Instantiation exception", localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        BLog.e(i, "Illegal access exception", localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        BLog.e(i, "Invocation target exception", localInvocationTargetException);
    }
  }

  public boolean c()
  {
    return this.g;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = "JMStaticKeysDict";
    arrayOfObject[1] = b(this.k.getDeclaringClass());
    arrayOfObject[2] = this.j.toString();
    return String.format("%s<%s, %s>", arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.types.JMStaticKeysDict
 * JD-Core Version:    0.6.0
 */
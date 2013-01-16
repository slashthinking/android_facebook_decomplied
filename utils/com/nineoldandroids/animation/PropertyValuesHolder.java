package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class PropertyValuesHolder
  implements Cloneable
{
  private static final TypeEvaluator i = new IntEvaluator();
  private static final TypeEvaluator j = new FloatEvaluator();
  private static Class[] k;
  private static Class[] l;
  private static Class[] m = arrayOfClass3;
  private static final HashMap<Class, HashMap<String, Method>> n = new HashMap();
  private static final HashMap<Class, HashMap<String, Method>> o = new HashMap();
  String a;
  protected Property b;
  Method c = null;
  Class d;
  KeyframeSet e = null;
  final ReentrantReadWriteLock f = new ReentrantReadWriteLock();
  final Object[] g = new Object[1];
  private Method h = null;
  private TypeEvaluator p;
  private Object q;

  static
  {
    Class[] arrayOfClass1 = new Class[6];
    arrayOfClass1[0] = Float.TYPE;
    arrayOfClass1[1] = Float.class;
    arrayOfClass1[2] = Double.TYPE;
    arrayOfClass1[3] = Integer.TYPE;
    arrayOfClass1[4] = Double.class;
    arrayOfClass1[5] = Integer.class;
    k = arrayOfClass1;
    Class[] arrayOfClass2 = new Class[6];
    arrayOfClass2[0] = Integer.TYPE;
    arrayOfClass2[1] = Integer.class;
    arrayOfClass2[2] = Float.TYPE;
    arrayOfClass2[3] = Double.TYPE;
    arrayOfClass2[4] = Float.class;
    arrayOfClass2[5] = Double.class;
    l = arrayOfClass2;
    Class[] arrayOfClass3 = new Class[6];
    arrayOfClass3[0] = Double.TYPE;
    arrayOfClass3[1] = Double.class;
    arrayOfClass3[2] = Float.TYPE;
    arrayOfClass3[3] = Integer.TYPE;
    arrayOfClass3[4] = Float.class;
    arrayOfClass3[5] = Integer.class;
  }

  private PropertyValuesHolder(Property paramProperty)
  {
    this.b = paramProperty;
    if (paramProperty != null)
      this.a = paramProperty.a();
  }

  private PropertyValuesHolder(String paramString)
  {
    this.a = paramString;
  }

  public static <V> PropertyValuesHolder a(Property paramProperty, TypeEvaluator<V> paramTypeEvaluator, V[] paramArrayOfV)
  {
    PropertyValuesHolder localPropertyValuesHolder = new PropertyValuesHolder(paramProperty);
    localPropertyValuesHolder.a(paramArrayOfV);
    localPropertyValuesHolder.a(paramTypeEvaluator);
    return localPropertyValuesHolder;
  }

  public static PropertyValuesHolder a(Property<?, Float> paramProperty, float[] paramArrayOfFloat)
  {
    return new PropertyValuesHolder.FloatPropertyValuesHolder(paramProperty, paramArrayOfFloat);
  }

  public static PropertyValuesHolder a(Property<?, Integer> paramProperty, int[] paramArrayOfInt)
  {
    return new PropertyValuesHolder.IntPropertyValuesHolder(paramProperty, paramArrayOfInt);
  }

  public static PropertyValuesHolder a(String paramString, TypeEvaluator paramTypeEvaluator, Object[] paramArrayOfObject)
  {
    PropertyValuesHolder localPropertyValuesHolder = new PropertyValuesHolder(paramString);
    localPropertyValuesHolder.a(paramArrayOfObject);
    localPropertyValuesHolder.a(paramTypeEvaluator);
    return localPropertyValuesHolder;
  }

  public static PropertyValuesHolder a(String paramString, float[] paramArrayOfFloat)
  {
    return new PropertyValuesHolder.FloatPropertyValuesHolder(paramString, paramArrayOfFloat);
  }

  public static PropertyValuesHolder a(String paramString, int[] paramArrayOfInt)
  {
    return new PropertyValuesHolder.IntPropertyValuesHolder(paramString, paramArrayOfInt);
  }

  public static PropertyValuesHolder a(String paramString, Keyframe[] paramArrayOfKeyframe)
  {
    KeyframeSet localKeyframeSet = KeyframeSet.a(paramArrayOfKeyframe);
    Object localObject;
    if ((localKeyframeSet instanceof IntKeyframeSet))
      localObject = new PropertyValuesHolder.IntPropertyValuesHolder(paramString, (IntKeyframeSet)localKeyframeSet);
    while (true)
    {
      return localObject;
      if ((localKeyframeSet instanceof FloatKeyframeSet))
      {
        localObject = new PropertyValuesHolder.FloatPropertyValuesHolder(paramString, (FloatKeyframeSet)localKeyframeSet);
      }
      else
      {
        PropertyValuesHolder localPropertyValuesHolder = new PropertyValuesHolder(paramString);
        localPropertyValuesHolder.e = localKeyframeSet;
        localPropertyValuesHolder.d = paramArrayOfKeyframe[0].e();
        localObject = localPropertyValuesHolder;
      }
    }
  }

  static String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0));
    while (true)
    {
      return paramString1;
      char c1 = Character.toUpperCase(paramString2.charAt(0));
      String str = paramString2.substring(1);
      paramString1 = paramString1 + c1 + str;
    }
  }

  private Method a(Class paramClass1, String paramString, Class paramClass2)
  {
    Method localMethod1 = null;
    String str = a(paramString, this.a);
    if (paramClass2 == null);
    while (true)
    {
      Object localObject;
      try
      {
        Method localMethod3 = paramClass1.getMethod(str, null);
        localObject = localMethod3;
        return localObject;
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
      }
      try
      {
        Method localMethod2 = paramClass1.getDeclaredMethod(str, null);
        localObject = localMethod2;
        try
        {
          ((Method)localObject).setAccessible(true);
        }
        catch (NoSuchMethodException localNoSuchMethodException5)
        {
        }
        Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.a + ": " + localNoSuchMethodException3);
        continue;
        Class[] arrayOfClass1 = new Class[1];
        Class[] arrayOfClass2;
        label123: int i1;
        int i2;
        if (this.d.equals(Float.class))
        {
          arrayOfClass2 = k;
          i1 = arrayOfClass2.length;
          i2 = 0;
        }
        while (true)
          while (true)
          {
            if (i2 >= i1)
              break label270;
            Class localClass = arrayOfClass2[i2];
            arrayOfClass1[0] = localClass;
            try
            {
              localMethod1 = paramClass1.getMethod(str, arrayOfClass1);
              this.d = localClass;
              localObject = localMethod1;
              break;
              if (this.d.equals(Integer.class))
              {
                arrayOfClass2 = l;
                break label123;
              }
              if (this.d.equals(Double.class))
              {
                arrayOfClass2 = m;
                break label123;
              }
              arrayOfClass2 = new Class[1];
              arrayOfClass2[0] = this.d;
            }
            catch (NoSuchMethodException localNoSuchMethodException1)
            {
              try
              {
                localMethod1 = paramClass1.getDeclaredMethod(str, arrayOfClass1);
                localMethod1.setAccessible(true);
                this.d = localClass;
                localObject = localMethod1;
              }
              catch (NoSuchMethodException localNoSuchMethodException2)
              {
                i2++;
              }
            }
          }
        label270: Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.a + " with value type " + this.d);
        localObject = localMethod1;
      }
      catch (NoSuchMethodException localNoSuchMethodException4)
      {
        while (true)
          localObject = null;
      }
    }
  }

  private Method a(Class paramClass1, HashMap<Class, HashMap<String, Method>> paramHashMap, String paramString, Class paramClass2)
  {
    try
    {
      this.f.writeLock().lock();
      HashMap localHashMap = (HashMap)paramHashMap.get(paramClass1);
      Method localMethod1 = null;
      if (localHashMap != null)
        localMethod1 = (Method)localHashMap.get(this.a);
      if (localMethod1 == null)
      {
        localMethod1 = a(paramClass1, paramString, paramClass2);
        if (localHashMap == null)
        {
          localHashMap = new HashMap();
          paramHashMap.put(paramClass1, localHashMap);
        }
        localHashMap.put(this.a, localMethod1);
      }
      Method localMethod2 = localMethod1;
      return localMethod2;
    }
    finally
    {
      this.f.writeLock().unlock();
    }
  }

  private void b(Class paramClass)
  {
    this.h = a(paramClass, o, "get", null);
  }

  public PropertyValuesHolder a()
  {
    try
    {
      localPropertyValuesHolder = (PropertyValuesHolder)super.clone();
      localPropertyValuesHolder.a = this.a;
      localPropertyValuesHolder.b = this.b;
      localPropertyValuesHolder.e = this.e.b();
      localPropertyValuesHolder.p = this.p;
      return localPropertyValuesHolder;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (true)
        PropertyValuesHolder localPropertyValuesHolder = null;
    }
  }

  void a(float paramFloat)
  {
    this.q = this.e.a(paramFloat);
  }

  public void a(TypeEvaluator paramTypeEvaluator)
  {
    this.p = paramTypeEvaluator;
    this.e.a(paramTypeEvaluator);
  }

  public void a(Property paramProperty)
  {
    this.b = paramProperty;
  }

  void a(Class paramClass)
  {
    this.c = a(paramClass, n, "set", this.d);
  }

  void a(Object paramObject)
  {
    if (this.b != null)
    {
      try
      {
        this.b.a(paramObject);
        Iterator localIterator2 = this.e.e.iterator();
        while (localIterator2.hasNext())
        {
          Keyframe localKeyframe2 = (Keyframe)localIterator2.next();
          if (!localKeyframe2.a())
            localKeyframe2.a(this.b.a(paramObject));
        }
      }
      catch (ClassCastException localClassCastException)
      {
        Log.e("PropertyValuesHolder", "No such property (" + this.b.a() + ") on target object " + paramObject + ". Trying reflection instead");
        this.b = null;
      }
    }
    else
    {
      Class localClass = paramObject.getClass();
      if (this.c == null)
        a(localClass);
      Iterator localIterator1 = this.e.e.iterator();
      while (localIterator1.hasNext())
      {
        Keyframe localKeyframe1 = (Keyframe)localIterator1.next();
        if (!localKeyframe1.a())
        {
          if (this.h == null)
            b(localClass);
          try
          {
            localKeyframe1.a(this.h.invoke(paramObject, new Object[0]));
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
          }
        }
      }
    }
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public void a(float[] paramArrayOfFloat)
  {
    this.d = Float.TYPE;
    this.e = KeyframeSet.a(paramArrayOfFloat);
  }

  public void a(int[] paramArrayOfInt)
  {
    this.d = Integer.TYPE;
    this.e = KeyframeSet.a(paramArrayOfInt);
  }

  public void a(Object[] paramArrayOfObject)
  {
    this.d = paramArrayOfObject[0].getClass();
    this.e = KeyframeSet.a(paramArrayOfObject);
  }

  void b()
  {
    TypeEvaluator localTypeEvaluator;
    if (this.p == null)
    {
      if (this.d != Integer.class)
        break label44;
      localTypeEvaluator = i;
    }
    while (true)
    {
      this.p = localTypeEvaluator;
      if (this.p != null)
        this.e.a(this.p);
      return;
      label44: if (this.d == Float.class)
        localTypeEvaluator = j;
      else
        localTypeEvaluator = null;
    }
  }

  void b(Object paramObject)
  {
    if (this.b != null)
      this.b.a(paramObject, d());
    if (this.c != null);
    try
    {
      this.g[0] = d();
      this.c.invoke(paramObject, this.g);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
    }
  }

  public String c()
  {
    return this.a;
  }

  Object d()
  {
    return this.q;
  }

  public String toString()
  {
    return this.a + ": " + this.e.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.PropertyValuesHolder
 * JD-Core Version:    0.6.2
 */
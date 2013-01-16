package com.facebook.common.json.jsonmirror;

import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.json.jsonmirror.types.JMBase;
import com.facebook.common.json.jsonmirror.types.JMDict;
import com.facebook.common.json.jsonmirror.types.JMDynamicKeysDict;
import com.facebook.common.json.jsonmirror.types.JMEscaped;
import com.facebook.common.json.jsonmirror.types.JMList;
import com.facebook.common.json.jsonmirror.types.JMStaticKeysDict;
import com.facebook.common.util.ReflectionUtils;
import com.facebook.common.util.ReflectionUtils.IncludeFlags;
import com.facebook.common.util.Tuple;
import com.facebook.debug.Assert;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.debug.BLog;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JMAutogen
{
  protected static Map<Class<? extends JMDictDestination>, JMDict> a;
  private static Class<?> b = JMAutogen.class;

  static
  {
    a = Maps.a();
  }

  protected static JMDict a(JMAutogen.DynamicKeyDictType paramDynamicKeyDictType)
  {
    HashSet localHashSet = Sets.a();
    Class localClass = paramDynamicKeyDictType.valueElementType();
    localHashSet.add(c(localClass));
    return new JMDynamicKeysDict(localClass, paramDynamicKeyDictType.a());
  }

  public static JMDict a(Class<? extends JMDictDestination> paramClass)
  {
    monitorenter;
    while (true)
    {
      HashMap localHashMap;
      int j;
      JMStaticKeysDict localJMStaticKeysDict;
      Field localField;
      Annotation localAnnotation;
      String str2;
      Object localObject4;
      try
      {
        localObject2 = (JMDict)a.get(paramClass);
        if (localObject2 != null)
          break label573;
        localHashMap = Maps.a();
        Annotation[] arrayOfAnnotation = paramClass.getDeclaredAnnotations();
        int i = arrayOfAnnotation.length;
        j = 0;
        if (j >= i)
          break label585;
        if ((arrayOfAnnotation[j] instanceof JMAutogen.IgnoreUnexpectedJsonFields))
        {
          bool = true;
          localJMStaticKeysDict = new JMStaticKeysDict(paramClass, localHashMap, bool);
          a.put(paramClass, localJMStaticKeysDict);
          Iterator localIterator = d(paramClass).entrySet().iterator();
          if (!localIterator.hasNext())
            break label565;
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localField = (Field)localEntry.getKey();
          localAnnotation = (Annotation)localEntry.getValue();
          if ((!(localAnnotation instanceof JMAutogen.InferredType)) && (!(localAnnotation instanceof JMAutogen.ExplicitType)) && (!(localAnnotation instanceof JMAutogen.EscapedObjectType)))
            break label421;
          if (!(localAnnotation instanceof JMAutogen.InferredType))
            break label319;
          String str3 = ((JMAutogen.InferredType)localAnnotation).jsonFieldName();
          localClass = localField.getType();
          localObject3 = str3;
          str2 = localField.getName();
          localObject4 = JMBase.a(localClass);
          if (localObject4 != null)
            continue;
          if (!JMDictDestination.class.isAssignableFrom(localClass))
            break label381;
          localObject4 = a(localClass);
          if (!(localAnnotation instanceof JMAutogen.EscapedObjectType))
            break label578;
          localObject5 = new JMEscaped((JMBase)localObject4, FBJsonFactory.a);
          Assert.a(StringLocaleUtil.b("json field [%s] is defined multiple times in the model", new Object[] { localObject3 }), localHashMap.containsKey(localObject3));
          localHashMap.put(localObject3, new Tuple(str2, localObject5));
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      j++;
      continue;
      label319: if ((localAnnotation instanceof JMAutogen.ExplicitType))
      {
        JMAutogen.ExplicitType localExplicitType = (JMAutogen.ExplicitType)localAnnotation;
        localObject3 = localExplicitType.jsonFieldName();
        localClass = localExplicitType.type();
        continue;
      }
      String str1 = ((JMAutogen.EscapedObjectType)localAnnotation).jsonFieldName();
      Class localClass = localField.getType();
      Object localObject3 = str1;
      continue;
      label381: throw new JMFatalException("could not infer type for " + paramClass.getName() + ":" + str2);
      label421: if ((localAnnotation instanceof JMAutogen.ListType))
      {
        JMAutogen.ListType localListType = (JMAutogen.ListType)localAnnotation;
        String str6 = localField.getName();
        String str7 = localListType.jsonFieldName();
        JMList localJMList = a(localListType);
        Assert.a(localHashMap.containsKey(str7));
        localHashMap.put(str7, new Tuple(str6, localJMList));
        continue;
      }
      if (!(localAnnotation instanceof JMAutogen.DynamicKeyDictType))
        continue;
      JMAutogen.DynamicKeyDictType localDynamicKeyDictType = (JMAutogen.DynamicKeyDictType)localAnnotation;
      String str4 = localField.getName();
      String str5 = localDynamicKeyDictType.jsonFieldName();
      JMDict localJMDict = a(localDynamicKeyDictType);
      Assert.a(localHashMap.containsKey(str5));
      localHashMap.put(str5, new Tuple(str4, localJMDict));
      continue;
      label565: a(paramClass, localHashMap);
      Object localObject2 = localJMStaticKeysDict;
      label573: monitorexit;
      return localObject2;
      label578: Object localObject5 = localObject4;
      continue;
      label585: boolean bool = false;
    }
  }

  protected static JMList a(JMAutogen.ListType paramListType)
  {
    HashSet localHashSet1 = Sets.a();
    Class[] arrayOfClass = paramListType.b();
    int i = arrayOfClass.length;
    for (int j = 0; j < i; j++)
      localHashSet1.add(c(arrayOfClass[j]));
    JMList localJMList = new JMList(localHashSet1);
    for (int k = paramListType.a(); k > 0; k--)
    {
      HashSet localHashSet2 = new HashSet();
      localHashSet2.add(localJMList);
      localJMList = new JMList(localHashSet2);
    }
    return localJMList;
  }

  private static void a(Class<? extends JMDictDestination> paramClass, Map<String, ? extends Object> paramMap)
  {
    try
    {
      Method localMethod = paramClass.getDeclaredMethod("postprocessJMAutogenFields", new Class[] { Map.class });
      if (localMethod != null)
      {
        localMethod.setAccessible(true);
        localMethod.invoke(null, new Object[] { paramMap });
      }
      label43: return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
      {
        Class localClass2 = b;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = "postprocessJMAutogenFields";
        arrayOfObject2[1] = paramClass.getName();
        BLog.e(localClass2, "Can't access %s in %s", arrayOfObject2);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
      {
        Class localClass1 = b;
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = "postprocessJMAutogenFields";
        arrayOfObject1[1] = paramClass.getName();
        BLog.e(localClass1, "InvocationTargetException while invoking %s on %s", arrayOfObject1);
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label43;
    }
  }

  public static Set<String> b(Class<? extends JMDictDestination> paramClass)
  {
    Map localMap = d(paramClass);
    HashMap localHashMap = Maps.a();
    Iterator localIterator = localMap.values().iterator();
    while (localIterator.hasNext())
    {
      Annotation localAnnotation = (Annotation)localIterator.next();
      if ((localAnnotation instanceof JMAutogen.InferredType))
      {
        localHashMap.put(((JMAutogen.InferredType)localAnnotation).jsonFieldName(), null);
        continue;
      }
      if ((localAnnotation instanceof JMAutogen.ExplicitType))
      {
        localHashMap.put(((JMAutogen.ExplicitType)localAnnotation).jsonFieldName(), null);
        continue;
      }
      if ((localAnnotation instanceof JMAutogen.ListType))
      {
        localHashMap.put(((JMAutogen.ListType)localAnnotation).jsonFieldName(), null);
        continue;
      }
      if ((localAnnotation instanceof JMAutogen.DynamicKeyDictType))
      {
        localHashMap.put(((JMAutogen.DynamicKeyDictType)localAnnotation).jsonFieldName(), null);
        continue;
      }
      throw new JMFatalException("Got a class with unexpected JMAutogen annotations");
    }
    a(paramClass, localHashMap);
    return localHashMap.keySet();
  }

  public static JMBase c(Class<?> paramClass)
  {
    Object localObject = JMBase.a(paramClass);
    if (localObject == null)
    {
      if (JMDictDestination.class.isAssignableFrom(paramClass))
        localObject = a(paramClass);
    }
    else
      return localObject;
    throw new JMFatalException("could not infer type for " + paramClass.getName());
  }

  private static Map<Field, Annotation> d(Class<?> paramClass)
  {
    return ReflectionUtils.a(paramClass, new JMAutogen.1(paramClass), EnumSet.of(ReflectionUtils.IncludeFlags.INCLUDE_SUPERCLASSES, ReflectionUtils.IncludeFlags.INCLUDE_FIELDS));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.JMAutogen
 * JD-Core Version:    0.6.0
 */
package com.facebook.common.json.jsonmirror;

import com.facebook.common.json.jsonmirror.types.JMBase;
import com.facebook.common.json.jsonmirror.types.JMDict;
import com.facebook.common.json.jsonmirror.types.JMStaticKeysDict;
import com.facebook.common.util.ReflectionUtils;
import com.facebook.common.util.ReflectionUtils.IncludeFlags;
import com.facebook.common.util.Tuple;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JMStaticKeysDictDestination$Encoder
{
  protected static JsonFactory a = new JsonFactory();

  public static <T extends JMStaticKeysDictDestination> JMStaticKeysDictDestination a(String paramString, Class<T> paramClass)
  {
    HashMap localHashMap = Maps.a();
    JSONObject localJSONObject;
    JMStaticKeysDictDestination localJMStaticKeysDictDestination;
    try
    {
      localJSONObject = new JSONObject(paramString);
      Iterator localIterator1 = a(paramClass).entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
        String str1 = ((JMStaticKeysDictDestination.Encoder.SerializableJsonObject)localEntry2.getValue()).jsonFieldName();
        if (!localJSONObject.has(str1))
          continue;
        try
        {
          String str2 = localJSONObject.get(str1).toString();
          Field localField2 = (Field)localEntry2.getKey();
          JMStaticKeysDictDestination.Encoder.SerializableJsonObject localSerializableJsonObject = (JMStaticKeysDictDestination.Encoder.SerializableJsonObject)localEntry2.getValue();
          localHashMap.put(localField2, localSerializableJsonObject.type().cast(a(str2, localSerializableJsonObject.type())));
          localJSONObject.remove(str1);
        }
        catch (JSONException localJSONException1)
        {
        }
      }
    }
    catch (JSONException localJSONException2)
    {
      localJMStaticKeysDictDestination = null;
    }
    while (true)
    {
      return localJMStaticKeysDictDestination;
      try
      {
        JMDict localJMDict = JMAutogen.a(paramClass);
        localJMStaticKeysDictDestination = (JMStaticKeysDictDestination)a(localJSONObject.toString(), localJMDict);
        Iterator localIterator2 = localHashMap.entrySet().iterator();
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
          Field localField1 = (Field)localEntry1.getKey();
          try
          {
            localField1.setAccessible(true);
            localField1.set(localJMStaticKeysDictDestination, localEntry1.getValue());
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
          }
        }
      }
      catch (JMException localJMException)
      {
        localJMStaticKeysDictDestination = null;
      }
      catch (IOException localIOException)
      {
        localJMStaticKeysDictDestination = null;
      }
    }
  }

  protected static JsonParser a(String paramString)
  {
    StringReader localStringReader = new StringReader(paramString);
    try
    {
      localJsonParser = a.createJsonParser(localStringReader);
      localJsonParser.nextToken();
      return localJsonParser;
    }
    catch (JsonParseException localJsonParseException)
    {
      while (true)
        localJsonParser = null;
    }
    catch (IOException localIOException)
    {
      while (true)
        JsonParser localJsonParser = null;
    }
  }

  private static Object a(String paramString, JMBase paramJMBase)
  {
    return JMParser.a(a(paramString), paramJMBase);
  }

  public static String a(JMStaticKeysDictDestination paramJMStaticKeysDictDestination)
  {
    Object localObject1 = null;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Iterator localIterator1 = JMAutogen.a(paramJMStaticKeysDictDestination.getClass()).a().entrySet().iterator();
      while (true)
      {
        String str3;
        Tuple localTuple;
        if (localIterator1.hasNext())
        {
          Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
          str3 = (String)localEntry2.getKey();
          localTuple = (Tuple)localEntry2.getValue();
        }
        try
        {
          Field localField2 = JMStaticKeysDict.a(paramJMStaticKeysDictDestination, (String)localTuple.a);
          if ((localField2.get(paramJMStaticKeysDictDestination) instanceof Collection))
          {
            Collection localCollection = (Collection)localField2.get(paramJMStaticKeysDictDestination);
            JSONArray localJSONArray = new JSONArray();
            Iterator localIterator3 = localCollection.iterator();
            while (localIterator3.hasNext())
            {
              Object localObject2 = localIterator3.next();
              if ((localObject2 instanceof JMStaticKeysDictDestination))
              {
                String str5 = a((JMStaticKeysDictDestination)localObject2);
                if (str5 == null)
                  continue;
                localJSONArray.put(new JSONObject(str5));
                continue;
              }
              localJSONArray.put(localObject2);
            }
            localJSONObject.put(str3, localJSONArray);
            continue;
          }
          if ((localField2.get(paramJMStaticKeysDictDestination) instanceof Map))
          {
            localJSONObject.put(str3, new JSONObject((Map)localField2.get(paramJMStaticKeysDictDestination)));
            continue;
          }
          if ((localField2.get(paramJMStaticKeysDictDestination) instanceof JMStaticKeysDictDestination))
          {
            String str4 = a((JMStaticKeysDictDestination)localField2.get(paramJMStaticKeysDictDestination));
            if (str4 == null)
              continue;
            localJSONObject.put(str3, new JSONObject(str4));
            continue;
          }
          localJSONObject.put(str3, localField2.get(paramJMStaticKeysDictDestination));
          continue;
          Iterator localIterator2 = a(paramJMStaticKeysDictDestination.getClass()).entrySet().iterator();
          String str2;
          Field localField1;
          if (localIterator2.hasNext())
          {
            Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
            str2 = ((JMStaticKeysDictDestination.Encoder.SerializableJsonObject)localEntry1.getValue()).jsonFieldName();
            localField1 = (Field)localEntry1.getKey();
            localField1.setAccessible(true);
          }
          while (true)
          {
            try
            {
              while (true)
              {
                JMStaticKeysDictDestination localJMStaticKeysDictDestination = (JMStaticKeysDictDestination)localField1.get(paramJMStaticKeysDictDestination);
                if (localJMStaticKeysDictDestination == null)
                  break;
                try
                {
                  localJSONObject.put(str2, new JSONObject(a(localJMStaticKeysDictDestination)));
                }
                catch (JSONException localJSONException2)
                {
                  localObject1 = null;
                  break label478;
                }
              }
              if (localJSONObject.length() <= 0)
                break label465;
              str1 = localJSONObject.toString();
              localObject1 = str1;
            }
            catch (IllegalAccessException localIllegalAccessException1)
            {
            }
            break;
            label465: String str1 = null;
          }
        }
        catch (IllegalAccessException localIllegalAccessException2)
        {
        }
      }
    }
    catch (JMException localJMException)
    {
      return localObject1;
    }
    catch (JSONException localJSONException1)
    {
      while (true)
        label478: localObject1 = null;
    }
  }

  static Map<Field, JMStaticKeysDictDestination.Encoder.SerializableJsonObject> a(Class<?> paramClass)
  {
    return ReflectionUtils.a(paramClass, new JMStaticKeysDictDestination.Encoder.1(), EnumSet.of(ReflectionUtils.IncludeFlags.INCLUDE_SUPERCLASSES, ReflectionUtils.IncludeFlags.INCLUDE_FIELDS));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder
 * JD-Core Version:    0.6.0
 */
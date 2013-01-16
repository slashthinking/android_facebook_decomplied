package com.facebook.orca.common.util;

import android.os.Bundle;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtil
{
  public static double a(JsonNode paramJsonNode, double paramDouble)
  {
    if (paramJsonNode == null);
    while (true)
    {
      return paramDouble;
      if (paramJsonNode.isNull())
        continue;
      if (paramJsonNode.isTextual());
      try
      {
        double d = Double.parseDouble(paramJsonNode.textValue());
        paramDouble = d;
        continue;
        if (!paramJsonNode.isNumber())
          continue;
        paramDouble = paramJsonNode.doubleValue();
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
  }

  public static int a(JsonNode paramJsonNode, int paramInt)
  {
    if (paramJsonNode == null);
    while (true)
    {
      return paramInt;
      if (paramJsonNode.isNull())
        continue;
      if (paramJsonNode.isTextual());
      try
      {
        int i = Integer.parseInt(paramJsonNode.textValue());
        paramInt = i;
        continue;
        if (!paramJsonNode.isNumber())
          continue;
        paramInt = paramJsonNode.intValue();
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
  }

  public static long a(JsonNode paramJsonNode, long paramLong)
  {
    if (paramJsonNode == null);
    while (true)
    {
      return paramLong;
      if (paramJsonNode.isNull())
        continue;
      if (paramJsonNode.isTextual());
      try
      {
        long l = Long.parseLong(paramJsonNode.textValue());
        paramLong = l;
        continue;
        if (!paramJsonNode.isNumber())
          continue;
        paramLong = paramJsonNode.longValue();
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
  }

  public static Bundle a(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.get(str);
      if ((localObject instanceof String))
      {
        localBundle.putString(str, (String)localObject);
        continue;
      }
      if ((localObject instanceof Integer))
      {
        localBundle.putInt(str, ((Integer)localObject).intValue());
        continue;
      }
      if ((localObject instanceof Float))
      {
        localBundle.putFloat(str, ((Float)localObject).floatValue());
        continue;
      }
      if ((localObject instanceof Double))
      {
        localBundle.putDouble(str, ((Double)localObject).doubleValue());
        continue;
      }
      if ((localObject instanceof JSONArray))
      {
        JSONArray localJSONArray = (JSONArray)localObject;
        if (localJSONArray.length() == 0)
        {
          localBundle.putParcelableArrayList(str, Lists.a());
          continue;
        }
        if ((localJSONArray.get(0) instanceof JSONObject))
        {
          localBundle.putParcelableArrayList(str, a(localJSONArray));
          continue;
        }
        if (!(localJSONArray.get(0) instanceof String))
          continue;
        localBundle.putStringArrayList(str, b(localJSONArray));
        continue;
      }
      if (!(localObject instanceof JSONObject))
        continue;
      localBundle.putBundle(str, a((JSONObject)localObject));
    }
    return localBundle;
  }

  public static String a(JsonNode paramJsonNode, String paramString)
  {
    if (paramJsonNode == null);
    while (true)
    {
      return paramString;
      if (paramJsonNode.isNull())
        continue;
      if (paramJsonNode.isTextual())
      {
        paramString = paramJsonNode.textValue();
        continue;
      }
      if (!paramJsonNode.isNumber())
        continue;
      paramString = paramJsonNode.numberValue().toString();
    }
  }

  public static ArrayList<Bundle> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = Lists.a();
    for (int i = 0; i < paramJSONArray.length(); i++)
      localArrayList.add(a(paramJSONArray.getJSONObject(i)));
    return localArrayList;
  }

  public static boolean a(JsonNode paramJsonNode)
  {
    if ((paramJsonNode != null) && (!paramJsonNode.isNull()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(JsonNode paramJsonNode, boolean paramBoolean)
  {
    boolean bool1 = true;
    if (paramJsonNode == null);
    do
      while (true)
      {
        return paramBoolean;
        if (paramJsonNode.isNull())
          continue;
        if (paramJsonNode.isBoolean())
        {
          paramBoolean = paramJsonNode.booleanValue();
          continue;
        }
        if (!paramJsonNode.isTextual())
          break;
        String str = paramJsonNode.textValue();
        boolean bool2;
        if ((!"on".equals(str)) && (!"1".equals(str)))
        {
          boolean bool3 = "true".equals(str);
          bool2 = false;
          if (!bool3);
        }
        else
        {
          bool2 = bool1;
        }
        paramBoolean = bool2;
      }
    while (!paramJsonNode.isNumber());
    if (paramJsonNode.intValue() != 0);
    while (true)
    {
      paramBoolean = bool1;
      break;
      bool1 = false;
    }
  }

  public static String b(JsonNode paramJsonNode)
  {
    return a(paramJsonNode, null);
  }

  public static ArrayList<String> b(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = Lists.a();
    for (int i = 0; i < paramJSONArray.length(); i++)
      localArrayList.add(paramJSONArray.getString(i));
    return localArrayList;
  }

  public static long c(JsonNode paramJsonNode)
  {
    return a(paramJsonNode, 0L);
  }

  public static int d(JsonNode paramJsonNode)
  {
    return a(paramJsonNode, 0);
  }

  public static double e(JsonNode paramJsonNode)
  {
    return a(paramJsonNode, 0.0D);
  }

  public static boolean f(JsonNode paramJsonNode)
  {
    return a(paramJsonNode, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.JSONUtil
 * JD-Core Version:    0.6.0
 */
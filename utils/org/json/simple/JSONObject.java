package org.json.simple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JSONObject extends HashMap
  implements Map, JSONAware
{
  private static final long serialVersionUID = -503443796854799292L;

  private static String a(String paramString, Object paramObject, StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append('"');
    if (paramString == null)
      paramStringBuffer.append("null");
    while (true)
    {
      paramStringBuffer.append('"').append(':');
      paramStringBuffer.append(JSONValue.a(paramObject));
      return paramStringBuffer.toString();
      JSONValue.a(paramString, paramStringBuffer);
    }
  }

  public static String a(Map paramMap)
  {
    if (paramMap == null);
    StringBuffer localStringBuffer;
    for (String str = "null"; ; str = localStringBuffer.toString())
    {
      return str;
      localStringBuffer = new StringBuffer();
      int i = 1;
      Iterator localIterator = paramMap.entrySet().iterator();
      localStringBuffer.append('{');
      if (localIterator.hasNext())
      {
        if (i != 0);
        for (int j = 0; ; j = i)
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          a(String.valueOf(localEntry.getKey()), localEntry.getValue(), localStringBuffer);
          i = j;
          break;
          localStringBuffer.append(',');
        }
      }
      localStringBuffer.append('}');
    }
  }

  public String a()
  {
    return a(this);
  }

  public String toString()
  {
    return a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     org.json.simple.JSONObject
 * JD-Core Version:    0.6.2
 */
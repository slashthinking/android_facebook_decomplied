package org.json.simple;

import java.util.List;
import java.util.Map;

public class JSONValue
{
  public static String a(Object paramObject)
  {
    String str;
    if (paramObject == null)
      str = "null";
    while (true)
    {
      return str;
      if ((paramObject instanceof String))
        str = "\"" + a((String)paramObject) + "\"";
      else if ((paramObject instanceof Double))
      {
        if ((((Double)paramObject).isInfinite()) || (((Double)paramObject).isNaN()))
          str = "null";
        else
          str = paramObject.toString();
      }
      else if ((paramObject instanceof Float))
      {
        if ((((Float)paramObject).isInfinite()) || (((Float)paramObject).isNaN()))
          str = "null";
        else
          str = paramObject.toString();
      }
      else if ((paramObject instanceof Number))
        str = paramObject.toString();
      else if ((paramObject instanceof Boolean))
        str = paramObject.toString();
      else if ((paramObject instanceof JSONAware))
        str = ((JSONAware)paramObject).a();
      else if ((paramObject instanceof Map))
        str = JSONObject.a((Map)paramObject);
      else if ((paramObject instanceof List))
        str = JSONArray.a((List)paramObject);
      else
        str = paramObject.toString();
    }
  }

  public static String a(String paramString)
  {
    if (paramString == null);
    StringBuffer localStringBuffer;
    for (String str = null; ; str = localStringBuffer.toString())
    {
      return str;
      localStringBuffer = new StringBuffer();
      a(paramString, localStringBuffer);
    }
  }

  static void a(String paramString, StringBuffer paramStringBuffer)
  {
    int i = 0;
    if (i < paramString.length())
    {
      int j = paramString.charAt(i);
      String str;
      int k;
      switch (j)
      {
      default:
        if (((j >= 0) && (j <= 31)) || ((j >= 127) && (j <= 159)) || ((j >= 8192) && (j <= 8447)))
        {
          str = Integer.toHexString(j);
          paramStringBuffer.append("\\u");
          k = 0;
        }
        break;
      case 34:
        while (k < 4 - str.length())
        {
          paramStringBuffer.append('0');
          k++;
          continue;
          paramStringBuffer.append("\\\"");
        }
      case 92:
      case 8:
      case 12:
      case 10:
      case 13:
      case 9:
      case 47:
      }
      while (true)
      {
        i++;
        break;
        paramStringBuffer.append("\\\\");
        continue;
        paramStringBuffer.append("\\b");
        continue;
        paramStringBuffer.append("\\f");
        continue;
        paramStringBuffer.append("\\n");
        continue;
        paramStringBuffer.append("\\r");
        continue;
        paramStringBuffer.append("\\t");
        continue;
        paramStringBuffer.append("\\/");
        continue;
        paramStringBuffer.append(str.toUpperCase());
        continue;
        paramStringBuffer.append(j);
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     org.json.simple.JSONValue
 * JD-Core Version:    0.6.2
 */
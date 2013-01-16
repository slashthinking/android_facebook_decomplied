package com.jayway.jsonpath.eval;

public class ExpressionEvaluator
{
  public static <T> boolean a(T paramT, String paramString1, String paramString2)
  {
    int i = 1;
    String str1 = paramString1.trim();
    Long localLong1;
    Long localLong2;
    if ((paramT instanceof Long))
    {
      localLong1 = (Long)paramT;
      localLong2 = Long.valueOf(Long.parseLong(paramString2.trim()));
      if ("=".equals(str1))
        if (localLong1.longValue() != localLong2.longValue());
    }
    while (true)
    {
      return i;
      i = 0;
      continue;
      if (("!=".equals(str1)) || ("<>".equals(str1)))
      {
        if (localLong1.longValue() != localLong2.longValue())
          continue;
        i = 0;
        continue;
      }
      if (">".equals(str1))
      {
        if (localLong1.longValue() > localLong2.longValue())
          continue;
        i = 0;
        continue;
      }
      if (">=".equals(str1))
      {
        if (localLong1.longValue() >= localLong2.longValue())
          continue;
        i = 0;
        continue;
      }
      if ("<".equals(str1))
      {
        if (localLong1.longValue() < localLong2.longValue())
          continue;
        i = 0;
        continue;
      }
      if ("<=".equals(str1))
      {
        if (localLong1.longValue() <= localLong2.longValue())
          continue;
        i = 0;
        continue;
        if ((paramT instanceof Integer))
        {
          Integer localInteger1 = (Integer)paramT;
          Integer localInteger2 = Integer.valueOf(Integer.parseInt(paramString2.trim()));
          if ("=".equals(str1))
          {
            if (localInteger1.intValue() == localInteger2.intValue())
              continue;
            i = 0;
            continue;
          }
          if (("!=".equals(str1)) || ("<>".equals(str1)))
          {
            if (localInteger1.intValue() != localInteger2.intValue())
              continue;
            i = 0;
            continue;
          }
          if (">".equals(str1))
          {
            if (localInteger1.intValue() > localInteger2.intValue())
              continue;
            i = 0;
            continue;
          }
          if (">=".equals(str1))
          {
            if (localInteger1.intValue() >= localInteger2.intValue())
              continue;
            i = 0;
            continue;
          }
          if ("<".equals(str1))
          {
            if (localInteger1.intValue() < localInteger2.intValue())
              continue;
            i = 0;
            continue;
          }
          if ("<=".equals(str1))
          {
            if (localInteger1.intValue() <= localInteger2.intValue())
              continue;
            i = 0;
            continue;
          }
        }
        else if ((paramT instanceof Double))
        {
          Double localDouble1 = (Double)paramT;
          Double localDouble2 = Double.valueOf(Double.parseDouble(paramString2.trim()));
          if ("=".equals(str1))
          {
            if (localDouble1.doubleValue() == localDouble2.doubleValue())
              continue;
            i = 0;
            continue;
          }
          if (("!=".equals(str1)) || ("<>".equals(str1)))
          {
            if (localDouble1.doubleValue() != localDouble2.doubleValue())
              continue;
            i = 0;
            continue;
          }
          if (">".equals(str1))
          {
            if (localDouble1.doubleValue() > localDouble2.doubleValue())
              continue;
            i = 0;
            continue;
          }
          if (">=".equals(str1))
          {
            if (localDouble1.doubleValue() >= localDouble2.doubleValue())
              continue;
            i = 0;
            continue;
          }
          if ("<".equals(str1))
          {
            if (localDouble1.doubleValue() < localDouble2.doubleValue())
              continue;
            i = 0;
            continue;
          }
          if ("<=".equals(str1))
          {
            if (localDouble1.doubleValue() <= localDouble2.doubleValue())
              continue;
            i = 0;
            continue;
          }
        }
        else if ((paramT instanceof String))
        {
          String str2 = (String)paramT;
          String str3 = paramString2.trim();
          if (str3.startsWith("'"))
            str3 = str3.substring(i);
          if (str3.endsWith("'"))
            str3 = str3.substring(0, -1 + str3.length());
          if ("=".equals(str1))
          {
            bool = str2.equals(str3);
            continue;
          }
          if (("!=".equals(str1)) || ("<>".equals(str1)))
          {
            if (!str2.equals(str3))
              continue;
            bool = false;
            continue;
          }
        }
      }
      boolean bool = false;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.eval.ExpressionEvaluator
 * JD-Core Version:    0.6.0
 */
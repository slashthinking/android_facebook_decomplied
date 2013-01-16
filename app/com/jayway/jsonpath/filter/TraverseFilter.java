package com.jayway.jsonpath.filter;

import com.jayway.jsonpath.JsonUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;

public class TraverseFilter extends JsonPathFilterBase
{
  public static final Pattern a = Pattern.compile("\\.\\.");

  private void a(Object paramObject, List<Object> paramList)
  {
    if (JsonUtil.c(paramObject))
    {
      paramList.add(paramObject);
      Iterator localIterator2 = JsonUtil.e(paramObject).values().iterator();
      while (localIterator2.hasNext())
      {
        Object localObject2 = localIterator2.next();
        if (!JsonUtil.a(localObject2))
          continue;
        a(localObject2, paramList);
      }
    }
    if (JsonUtil.b(paramObject))
    {
      Iterator localIterator1 = JsonUtil.d(paramObject).iterator();
      while (localIterator1.hasNext())
      {
        Object localObject1 = localIterator1.next();
        if (!JsonUtil.a(localObject1))
          continue;
        a(localObject1, paramList);
      }
    }
  }

  public FilterOutput a(FilterOutput paramFilterOutput)
  {
    JSONArray localJSONArray = new JSONArray();
    a(paramFilterOutput.b(), localJSONArray);
    return new FilterOutput(localJSONArray);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.filter.TraverseFilter
 * JD-Core Version:    0.6.0
 */
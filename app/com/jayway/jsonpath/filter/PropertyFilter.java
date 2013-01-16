package com.jayway.jsonpath.filter;

import com.jayway.jsonpath.JsonUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;

public class PropertyFilter extends JsonPathFilterBase
{
  public static final Pattern a = Pattern.compile("(.*)|\\['(.*?)'\\]");
  private final String b;

  public PropertyFilter(String paramString)
  {
    this.b = paramString;
  }

  public FilterOutput a(FilterOutput paramFilterOutput)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramFilterOutput.a())
    {
      Iterator localIterator = paramFilterOutput.c().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (!JsonUtil.e(localObject2).containsKey(this.b))
          continue;
        Object localObject3 = JsonUtil.e(localObject2).get(this.b);
        if (JsonUtil.b(localObject3))
        {
          localJSONArray.addAll(JsonUtil.d(localObject3));
          continue;
        }
        localJSONArray.add(JsonUtil.e(localObject2).get(this.b));
      }
    }
    Object localObject1;
    for (FilterOutput localFilterOutput = new FilterOutput(localJSONArray); ; localFilterOutput = new FilterOutput(localObject1))
    {
      return localFilterOutput;
      boolean bool = JsonUtil.e(paramFilterOutput.b()).containsKey(this.b);
      localObject1 = null;
      if (!bool)
        continue;
      localObject1 = JsonUtil.e(paramFilterOutput.b()).get(this.b);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.filter.PropertyFilter
 * JD-Core Version:    0.6.0
 */
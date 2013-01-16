package com.jayway.jsonpath.filter;

import com.jayway.jsonpath.JsonUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;

public class WildcardPropertyFilter extends JsonPathFilterBase
{
  public static final Pattern a = Pattern.compile("\\*");

  public FilterOutput a(FilterOutput paramFilterOutput)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramFilterOutput.a())
    {
      Iterator localIterator2 = paramFilterOutput.c().iterator();
      while (localIterator2.hasNext())
      {
        Iterator localIterator3 = JsonUtil.e(localIterator2.next()).values().iterator();
        while (localIterator3.hasNext())
          localJSONArray.add(localIterator3.next());
      }
    }
    Iterator localIterator1 = JsonUtil.e(paramFilterOutput.b()).values().iterator();
    while (localIterator1.hasNext())
      localJSONArray.add(localIterator1.next());
    return new FilterOutput(localJSONArray);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.filter.WildcardPropertyFilter
 * JD-Core Version:    0.6.0
 */
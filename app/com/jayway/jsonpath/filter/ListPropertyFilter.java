package com.jayway.jsonpath.filter;

import com.jayway.jsonpath.JsonUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;

public class ListPropertyFilter extends JsonPathFilterBase
{
  public static final Pattern a = Pattern.compile("\\[\\s?\\?\\s?\\(\\s?@\\.(\\w+)\\s?\\)\\s?\\]");
  private final String b;

  public ListPropertyFilter(String paramString)
  {
    this.b = paramString;
  }

  private String a()
  {
    Matcher localMatcher = a.matcher(this.b);
    if (localMatcher.matches())
      return localMatcher.group(1);
    throw new IllegalArgumentException("invalid list filter property");
  }

  public FilterOutput a(FilterOutput paramFilterOutput)
  {
    JSONArray localJSONArray = new JSONArray();
    String str = a();
    Iterator localIterator = paramFilterOutput.c().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!JsonUtil.c(localObject)) || (!JsonUtil.e(localObject).containsKey(str)))
        continue;
      localJSONArray.add(localObject);
    }
    return new FilterOutput(localJSONArray);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.filter.ListPropertyFilter
 * JD-Core Version:    0.6.0
 */
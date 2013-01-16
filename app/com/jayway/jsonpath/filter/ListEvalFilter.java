package com.jayway.jsonpath.filter;

import com.jayway.jsonpath.JsonUtil;
import com.jayway.jsonpath.eval.ExpressionEvaluator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;

public class ListEvalFilter extends JsonPathFilterBase
{
  public static final Pattern a = Pattern.compile("\\[\\s?\\?\\s?\\(\\s?@.(\\w+)\\s?([=<>]+)\\s?(.*)\\s?\\)\\s?\\]");
  private final String b;

  public ListEvalFilter(String paramString)
  {
    this.b = paramString;
  }

  private boolean a(Object paramObject)
  {
    Matcher localMatcher = a.matcher(this.b);
    boolean bool1 = localMatcher.matches();
    boolean bool2 = false;
    String str1;
    String str2;
    String str3;
    if (bool1)
    {
      str1 = localMatcher.group(1);
      str2 = localMatcher.group(2);
      str3 = localMatcher.group(3);
      boolean bool3 = JsonUtil.c(paramObject);
      bool2 = false;
      if (bool3)
        break label61;
    }
    while (true)
    {
      return bool2;
      label61: Map localMap = JsonUtil.e(paramObject);
      boolean bool4 = localMap.containsKey(str1);
      bool2 = false;
      if (!bool4)
        continue;
      Object localObject = localMap.get(str1);
      boolean bool5 = JsonUtil.a(localObject);
      bool2 = false;
      if (bool5)
        continue;
      new StringBuilder().append(localObject).append(" ").append(str2).append(" ").append(str3).toString();
      bool2 = ExpressionEvaluator.a(localObject, str2, str3);
    }
  }

  public FilterOutput a(FilterOutput paramFilterOutput)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramFilterOutput.c().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!a(localObject))
        continue;
      localJSONArray.add(localObject);
    }
    return new FilterOutput(localJSONArray);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.filter.ListEvalFilter
 * JD-Core Version:    0.6.0
 */
package com.jayway.jsonpath.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonPathFilterFactory
{
  public static JsonPathFilterBase a(String paramString)
  {
    Object localObject;
    if (RootFilter.a.matcher(paramString).matches())
      localObject = new RootFilter();
    while (true)
    {
      return localObject;
      if (ListIndexFilter.a.matcher(paramString).matches())
      {
        localObject = new ListIndexFilter(paramString);
        continue;
      }
      if (ListFrontFilter.a.matcher(paramString).matches())
      {
        localObject = new ListFrontFilter(paramString);
        continue;
      }
      if (ListWildcardFilter.a.matcher(paramString).matches())
      {
        localObject = new ListWildcardFilter();
        continue;
      }
      if (ListTailFilter.a.matcher(paramString).matches())
      {
        localObject = new ListTailFilter(paramString);
        continue;
      }
      if (ListPropertyFilter.a.matcher(paramString).matches())
      {
        localObject = new ListPropertyFilter(paramString);
        continue;
      }
      if (ListEvalFilter.a.matcher(paramString).matches())
      {
        localObject = new ListEvalFilter(paramString);
        continue;
      }
      if (TraverseFilter.a.matcher(paramString).matches())
      {
        localObject = new TraverseFilter();
        continue;
      }
      if (WildcardPropertyFilter.a.matcher(paramString).matches())
      {
        localObject = new WildcardPropertyFilter();
        continue;
      }
      if (PropertyFilter.a.matcher(paramString).matches())
      {
        localObject = new PropertyFilter(paramString);
        continue;
      }
      localObject = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.filter.JsonPathFilterFactory
 * JD-Core Version:    0.6.0
 */
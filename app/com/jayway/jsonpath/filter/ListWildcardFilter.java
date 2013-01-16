package com.jayway.jsonpath.filter;

import java.util.regex.Pattern;

public class ListWildcardFilter extends JsonPathFilterBase
{
  public static final Pattern a = Pattern.compile("\\[\\*\\]");

  public FilterOutput a(FilterOutput paramFilterOutput)
  {
    return new FilterOutput(paramFilterOutput.c());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.filter.ListWildcardFilter
 * JD-Core Version:    0.6.0
 */
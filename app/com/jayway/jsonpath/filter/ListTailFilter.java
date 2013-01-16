package com.jayway.jsonpath.filter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListTailFilter extends JsonPathFilterBase
{
  public static final Pattern a;
  private static final Pattern b = Pattern.compile("\\[\\s*-\\s*(\\d+):\\s*\\]");
  private static final Pattern c = Pattern.compile("\\[\\s*\\(\\s*@\\.length\\s*-\\s*(\\d+)\\s*\\)\\s*\\]");
  private final String d;

  static
  {
    a = Pattern.compile("(" + b.pattern() + "|" + c.pattern() + ")");
  }

  public ListTailFilter(String paramString)
  {
    this.d = paramString;
  }

  private int a(int paramInt)
  {
    Matcher localMatcher1 = b.matcher(this.d);
    if (localMatcher1.matches());
    Matcher localMatcher2;
    for (int i = paramInt - Integer.parseInt(localMatcher1.group(1)); ; i = paramInt - Integer.parseInt(localMatcher2.group(1)))
    {
      return i;
      localMatcher2 = c.matcher(this.d);
      if (!localMatcher2.matches())
        break;
    }
    throw new IllegalArgumentException("invalid list index");
  }

  public FilterOutput a(FilterOutput paramFilterOutput)
  {
    int i = a(paramFilterOutput.c().size());
    return new FilterOutput(paramFilterOutput.c().get(i));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.filter.ListTailFilter
 * JD-Core Version:    0.6.0
 */
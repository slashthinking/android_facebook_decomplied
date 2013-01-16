package com.jayway.jsonpath.filter;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;

public class ListFrontFilter extends JsonPathFilterBase
{
  public static final Pattern a = Pattern.compile("\\[\\s?:(\\d+)\\s?\\]");
  private final String b;

  public ListFrontFilter(String paramString)
  {
    this.b = paramString;
  }

  private boolean a(List paramList, int paramInt)
  {
    int i = 0;
    if (paramInt < 0);
    while (true)
    {
      return i;
      int j = -1 + paramList.size();
      i = 0;
      if (paramInt > j)
        continue;
      i = 1;
    }
  }

  private Integer[] a()
  {
    Matcher localMatcher = a.matcher(this.b);
    if (localMatcher.matches())
    {
      int i = Integer.parseInt(localMatcher.group(1));
      LinkedList localLinkedList = new LinkedList();
      for (int j = 0; j < i; j++)
        localLinkedList.add(Integer.valueOf(j));
      return (Integer[])localLinkedList.toArray(new Integer[0]);
    }
    throw new IllegalArgumentException("invalid list index");
  }

  public FilterOutput a(FilterOutput paramFilterOutput)
  {
    JSONArray localJSONArray = new JSONArray();
    Integer[] arrayOfInteger = a();
    int i = arrayOfInteger.length;
    for (int j = 0; j < i; j++)
    {
      int k = arrayOfInteger[j].intValue();
      if (!a(paramFilterOutput.c(), k))
        continue;
      localJSONArray.add(paramFilterOutput.c().get(k));
    }
    return new FilterOutput(localJSONArray);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.filter.ListFrontFilter
 * JD-Core Version:    0.6.0
 */
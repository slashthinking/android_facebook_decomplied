package com.jayway.jsonpath.filter;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;

public class ListIndexFilter extends JsonPathFilterBase
{
  public static final Pattern a = Pattern.compile("\\[(\\s?\\d+\\s?,?)+\\]");
  private final String b;

  public ListIndexFilter(String paramString)
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
    String str1 = this.b.replaceAll(" ", "");
    String str2 = str1.substring(1, -1 + str1.length());
    LinkedList localLinkedList = new LinkedList();
    String[] arrayOfString = str2.split(",");
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
      localLinkedList.add(Integer.valueOf(Integer.parseInt(arrayOfString[j])));
    return (Integer[])localLinkedList.toArray(new Integer[0]);
  }

  public FilterOutput a(FilterOutput paramFilterOutput)
  {
    int i = 0;
    Integer[] arrayOfInteger = a();
    if (arrayOfInteger.length > 1)
    {
      localObject = new JSONArray();
      int j = arrayOfInteger.length;
      while (i < j)
      {
        int k = arrayOfInteger[i].intValue();
        if (a(paramFilterOutput.c(), k))
          ((List)localObject).add(paramFilterOutput.c().get(k));
        i++;
      }
    }
    boolean bool = a(paramFilterOutput.c(), arrayOfInteger[0].intValue());
    Object localObject = null;
    if (bool)
      localObject = paramFilterOutput.c().get(arrayOfInteger[0].intValue());
    return (FilterOutput)new FilterOutput(localObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.filter.ListIndexFilter
 * JD-Core Version:    0.6.0
 */
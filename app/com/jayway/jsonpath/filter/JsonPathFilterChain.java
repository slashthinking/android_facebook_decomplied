package com.jayway.jsonpath.filter;

import com.jayway.jsonpath.InvalidPathException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class JsonPathFilterChain
{
  private List<JsonPathFilterBase> a = a(paramList);

  public JsonPathFilterChain(List<String> paramList)
  {
  }

  private List<JsonPathFilterBase> a(List<String> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localLinkedList.add(JsonPathFilterFactory.a((String)localIterator.next()));
    return localLinkedList;
  }

  public FilterOutput a(Object paramObject)
  {
    FilterOutput localFilterOutput1 = new FilterOutput(paramObject);
    Iterator localIterator = this.a.iterator();
    JsonPathFilterBase localJsonPathFilterBase;
    for (FilterOutput localFilterOutput2 = localFilterOutput1; ; localFilterOutput2 = localJsonPathFilterBase.a(localFilterOutput2))
    {
      if (localIterator.hasNext())
      {
        localJsonPathFilterBase = (JsonPathFilterBase)localIterator.next();
        if (localJsonPathFilterBase == null)
          throw new InvalidPathException();
        if (localFilterOutput2.b() != null)
          continue;
        localFilterOutput2 = null;
      }
      return localFilterOutput2;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.filter.JsonPathFilterChain
 * JD-Core Version:    0.6.0
 */
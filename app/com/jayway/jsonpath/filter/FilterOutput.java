package com.jayway.jsonpath.filter;

import java.util.List;

public class FilterOutput
{
  private final Object a;

  public FilterOutput(Object paramObject)
  {
    this.a = paramObject;
  }

  public boolean a()
  {
    return this.a instanceof List;
  }

  public Object b()
  {
    return this.a;
  }

  public List<Object> c()
  {
    if (!a())
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.a.getClass().getName();
      arrayOfObject[1] = List.class.getName();
      throw new RuntimeException(String.format("Can not convert a %s to a %s", arrayOfObject));
    }
    return (List)this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.filter.FilterOutput
 * JD-Core Version:    0.6.0
 */
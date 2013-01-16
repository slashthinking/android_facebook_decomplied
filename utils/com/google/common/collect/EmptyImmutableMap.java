package com.google.common.collect;

import java.util.Map;
import java.util.Map.Entry;

final class EmptyImmutableMap extends ImmutableMap<Object, Object>
{
  static final EmptyImmutableMap a = new EmptyImmutableMap();
  private static final long serialVersionUID;

  public ImmutableSet<Map.Entry<Object, Object>> a()
  {
    return ImmutableSet.d();
  }

  public ImmutableSet<Object> b()
  {
    return ImmutableSet.d();
  }

  public ImmutableCollection<Object> c()
  {
    return ImmutableCollection.c;
  }

  public boolean containsKey(Object paramObject)
  {
    return false;
  }

  public boolean containsValue(Object paramObject)
  {
    return false;
  }

  boolean d()
  {
    return false;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Map));
    for (boolean bool = ((Map)paramObject).isEmpty(); ; bool = false)
      return bool;
  }

  public Object get(Object paramObject)
  {
    return null;
  }

  public int hashCode()
  {
    return 0;
  }

  public boolean isEmpty()
  {
    return true;
  }

  Object readResolve()
  {
    return a;
  }

  public int size()
  {
    return 0;
  }

  public String toString()
  {
    return "{}";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.EmptyImmutableMap
 * JD-Core Version:    0.6.2
 */
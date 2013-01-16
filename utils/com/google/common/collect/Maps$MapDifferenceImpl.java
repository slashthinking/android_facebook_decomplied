package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Map;

class Maps$MapDifferenceImpl<K, V>
  implements MapDifference<K, V>
{
  final boolean a;
  final Map<K, V> b;
  final Map<K, V> c;
  final Map<K, V> d;
  final Map<K, MapDifference.ValueDifference<V>> e;

  Maps$MapDifferenceImpl(boolean paramBoolean, Map<K, V> paramMap1, Map<K, V> paramMap2, Map<K, V> paramMap3, Map<K, MapDifference.ValueDifference<V>> paramMap)
  {
    this.a = paramBoolean;
    this.b = paramMap1;
    this.c = paramMap2;
    this.d = paramMap3;
    this.e = paramMap;
  }

  public Map<K, V> a()
  {
    return this.b;
  }

  public Map<K, V> b()
  {
    return this.c;
  }

  public Map<K, V> c()
  {
    return this.d;
  }

  public Map<K, MapDifference.ValueDifference<V>> d()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this);
    while (true)
    {
      return bool;
      if ((paramObject instanceof MapDifference))
      {
        MapDifference localMapDifference = (MapDifference)paramObject;
        if ((!a().equals(localMapDifference.a())) || (!b().equals(localMapDifference.b())) || (!c().equals(localMapDifference.c())) || (!d().equals(localMapDifference.d())))
          bool = false;
      }
      else
      {
        bool = false;
      }
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = a();
    arrayOfObject[1] = b();
    arrayOfObject[2] = c();
    arrayOfObject[3] = d();
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    if (this.a);
    StringBuilder localStringBuilder;
    for (String str = "equal"; ; str = localStringBuilder.toString())
    {
      return str;
      localStringBuilder = new StringBuilder("not equal");
      if (!this.b.isEmpty())
        localStringBuilder.append(": only on left=").append(this.b);
      if (!this.c.isEmpty())
        localStringBuilder.append(": only on right=").append(this.c);
      if (!this.e.isEmpty())
        localStringBuilder.append(": value differences=").append(this.e);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Maps.MapDifferenceImpl
 * JD-Core Version:    0.6.2
 */
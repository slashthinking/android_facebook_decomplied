package com.google.common.collect;

import com.google.common.base.Objects;

class Maps$ValueDifferenceImpl<V>
  implements MapDifference.ValueDifference<V>
{
  private final V a;
  private final V b;

  private Maps$ValueDifferenceImpl(V paramV1, V paramV2)
  {
    this.a = paramV1;
    this.b = paramV2;
  }

  static <V> MapDifference.ValueDifference<V> a(V paramV1, V paramV2)
  {
    return new ValueDifferenceImpl(paramV1, paramV2);
  }

  public V a()
  {
    return this.a;
  }

  public V b()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof MapDifference.ValueDifference;
    boolean bool2 = false;
    if (bool1)
    {
      MapDifference.ValueDifference localValueDifference = (MapDifference.ValueDifference)paramObject;
      boolean bool3 = Objects.equal(this.a, localValueDifference.a());
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = Objects.equal(this.b, localValueDifference.b());
        bool2 = false;
        if (bool4)
          bool2 = true;
      }
    }
    return bool2;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = this.b;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return "(" + this.a + ", " + this.b + ")";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Maps.ValueDifferenceImpl
 * JD-Core Version:    0.6.2
 */
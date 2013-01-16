package com.google.common.collect;

import com.google.common.base.Objects;

abstract class Multisets$AbstractEntry<E>
  implements Multiset.Entry<E>
{
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Multiset.Entry;
    boolean bool2 = false;
    if (bool1)
    {
      Multiset.Entry localEntry = (Multiset.Entry)paramObject;
      int i = b();
      int j = localEntry.b();
      bool2 = false;
      if (i == j)
      {
        boolean bool3 = Objects.equal(a(), localEntry.a());
        bool2 = false;
        if (bool3)
          bool2 = true;
      }
    }
    return bool2;
  }

  public int hashCode()
  {
    Object localObject = a();
    if (localObject == null);
    for (int i = 0; ; i = localObject.hashCode())
      return i ^ b();
  }

  public String toString()
  {
    String str = String.valueOf(a());
    int i = b();
    if (i == 1);
    while (true)
    {
      return str;
      str = str + " x " + i;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multisets.AbstractEntry
 * JD-Core Version:    0.6.2
 */
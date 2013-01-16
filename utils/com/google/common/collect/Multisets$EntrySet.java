package com.google.common.collect;

import java.util.AbstractSet;
import java.util.Set;

abstract class Multisets$EntrySet<E> extends AbstractSet<Multiset.Entry<E>>
{
  abstract Multiset<E> a();

  public void clear()
  {
    a().clear();
  }

  public boolean contains(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Multiset.Entry;
    boolean bool2 = false;
    Multiset.Entry localEntry;
    if (bool1)
    {
      localEntry = (Multiset.Entry)paramObject;
      int i = localEntry.b();
      bool2 = false;
      if (i > 0)
        break label35;
    }
    while (true)
    {
      return bool2;
      label35: int j = a().a(localEntry.a());
      int k = localEntry.b();
      bool2 = false;
      if (j == k)
        bool2 = true;
    }
  }

  public boolean remove(Object paramObject)
  {
    if ((contains(paramObject)) && (a().f().remove(((Multiset.Entry)paramObject).a())));
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multisets.EntrySet
 * JD-Core Version:    0.6.2
 */
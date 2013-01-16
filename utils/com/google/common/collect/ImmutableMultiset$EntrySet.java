package com.google.common.collect;

import java.util.Iterator;

class ImmutableMultiset$EntrySet<E> extends ImmutableSet<Multiset.Entry<E>>
{
  private static final long serialVersionUID;
  final transient ImmutableMultiset<E> a;

  public ImmutableMultiset$EntrySet(ImmutableMultiset<E> paramImmutableMultiset)
  {
    this.a = paramImmutableMultiset;
  }

  public UnmodifiableIterator<Multiset.Entry<E>> b()
  {
    return this.a.d();
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
      label35: int j = this.a.a(localEntry.a());
      int k = localEntry.b();
      bool2 = false;
      if (j == k)
        bool2 = true;
    }
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  boolean l_()
  {
    return this.a.l_();
  }

  public int size()
  {
    return this.a.e();
  }

  public Object[] toArray()
  {
    return toArray(new Object[size()]);
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    int i = size();
    if (paramArrayOfT.length < i)
      paramArrayOfT = ObjectArrays.a(paramArrayOfT, i);
    while (true)
    {
      Iterator localIterator = iterator();
      int k;
      for (int j = 0; localIterator.hasNext(); j = k)
      {
        Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
        k = j + 1;
        paramArrayOfT[j] = localEntry;
      }
      if (paramArrayOfT.length > i)
        paramArrayOfT[i] = null;
    }
    return paramArrayOfT;
  }

  Object writeReplace()
  {
    return new ImmutableMultiset.EntrySet.EntrySetSerializedForm(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultiset.EntrySet
 * JD-Core Version:    0.6.2
 */
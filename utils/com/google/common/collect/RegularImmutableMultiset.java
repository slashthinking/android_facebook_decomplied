package com.google.common.collect;

class RegularImmutableMultiset<E> extends ImmutableMultiset<E>
{
  private final transient ImmutableMap<E, Integer> a;
  private final transient int b;

  RegularImmutableMultiset(ImmutableMap<E, Integer> paramImmutableMap, int paramInt)
  {
    this.a = paramImmutableMap;
    this.b = paramInt;
  }

  public int a(Object paramObject)
  {
    Integer localInteger = (Integer)this.a.get(paramObject);
    if (localInteger == null);
    for (int i = 0; ; i = localInteger.intValue())
      return i;
  }

  public ImmutableSet<E> c()
  {
    return this.a.b();
  }

  public boolean contains(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }

  UnmodifiableIterator<Multiset.Entry<E>> d()
  {
    return new RegularImmutableMultiset.1(this, this.a.a().b());
  }

  int e()
  {
    return this.a.size();
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  boolean l_()
  {
    return this.a.d();
  }

  public int size()
  {
    return this.b;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableMultiset
 * JD-Core Version:    0.6.2
 */
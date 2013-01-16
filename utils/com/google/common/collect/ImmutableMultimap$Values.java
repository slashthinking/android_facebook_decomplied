package com.google.common.collect;

class ImmutableMultimap$Values<V> extends ImmutableCollection<V>
{
  private static final long serialVersionUID;
  final ImmutableMultimap<?, V> multimap;

  ImmutableMultimap$Values(ImmutableMultimap<?, V> paramImmutableMultimap)
  {
    this.multimap = paramImmutableMultimap;
  }

  public UnmodifiableIterator<V> b()
  {
    return new ImmutableMultimap.Values.1(this, this.multimap.n().b());
  }

  boolean l_()
  {
    return true;
  }

  public int size()
  {
    return this.multimap.d();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultimap.Values
 * JD-Core Version:    0.6.2
 */
package com.google.common.collect;

class ImmutableSet$TransformedImmutableSet$1 extends AbstractIndexedListIterator<E>
{
  ImmutableSet$TransformedImmutableSet$1(ImmutableSet.TransformedImmutableSet paramTransformedImmutableSet, int paramInt)
  {
    super(paramInt);
  }

  protected E a(int paramInt)
  {
    return this.a.a(this.a.source[paramInt]);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSet.TransformedImmutableSet.1
 * JD-Core Version:    0.6.2
 */
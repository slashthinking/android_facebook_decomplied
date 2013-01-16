package com.google.common.collect;

class TransformedImmutableList$1 extends AbstractIndexedListIterator<E>
{
  TransformedImmutableList$1(TransformedImmutableList paramTransformedImmutableList, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }

  protected E a(int paramInt)
  {
    return this.a.get(paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.TransformedImmutableList.1
 * JD-Core Version:    0.6.2
 */
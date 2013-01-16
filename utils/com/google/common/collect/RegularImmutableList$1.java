package com.google.common.collect;

class RegularImmutableList$1 extends AbstractIndexedListIterator<E>
{
  RegularImmutableList$1(RegularImmutableList paramRegularImmutableList, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }

  protected E a(int paramInt)
  {
    return RegularImmutableList.a(this.a)[(paramInt + RegularImmutableList.b(this.a))];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableList.1
 * JD-Core Version:    0.6.2
 */
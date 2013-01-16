package com.google.common.collect;

class RegularImmutableMap$Values$1 extends AbstractIndexedListIterator<V>
{
  RegularImmutableMap$Values$1(RegularImmutableMap.Values paramValues, int paramInt)
  {
    super(paramInt);
  }

  protected V a(int paramInt)
  {
    return RegularImmutableMap.a(this.a.map)[paramInt].getValue();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableMap.Values.1
 * JD-Core Version:    0.6.2
 */
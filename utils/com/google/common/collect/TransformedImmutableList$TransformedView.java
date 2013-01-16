package com.google.common.collect;

class TransformedImmutableList$TransformedView extends TransformedImmutableList<D, E>
{
  TransformedImmutableList$TransformedView(ImmutableList<D> paramImmutableList)
  {
    super(localImmutableList);
  }

  E b(D paramD)
  {
    return this.this$0.b(paramD);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.TransformedImmutableList.TransformedView
 * JD-Core Version:    0.6.2
 */
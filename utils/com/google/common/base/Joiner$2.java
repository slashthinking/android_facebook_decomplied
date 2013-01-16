package com.google.common.base;

import java.util.Iterator;

class Joiner$2 extends Joiner
{
  Joiner$2(Joiner paramJoiner1, Joiner paramJoiner2)
  {
    super(paramJoiner2, null);
  }

  public <A extends Appendable> A appendTo(A paramA, Iterable<?> paramIterable)
  {
    Preconditions.checkNotNull(paramA, "appendable");
    Preconditions.checkNotNull(paramIterable, "parts");
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      if (localObject2 != null)
        paramA.append(this.this$0.toString(localObject2));
    }
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (localObject1 != null)
      {
        paramA.append(Joiner.access$100(this.this$0));
        paramA.append(this.this$0.toString(localObject1));
      }
    }
    return paramA;
  }

  public Joiner.MapJoiner withKeyValueSeparator(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    throw new UnsupportedOperationException("can't use .skipNulls() with maps");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Joiner.2
 * JD-Core Version:    0.6.2
 */
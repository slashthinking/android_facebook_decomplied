package com.google.common.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class Joiner$MapJoiner
{
  private final Joiner joiner;
  private final String keyValueSeparator;

  private Joiner$MapJoiner(Joiner paramJoiner, String paramString)
  {
    this.joiner = paramJoiner;
    this.keyValueSeparator = ((String)Preconditions.checkNotNull(paramString));
  }

  public <A extends Appendable> A appendTo(A paramA, Iterable<? extends Map.Entry<?, ?>> paramIterable)
  {
    Preconditions.checkNotNull(paramA);
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator.next();
      paramA.append(this.joiner.toString(localEntry1.getKey()));
      paramA.append(this.keyValueSeparator);
      paramA.append(this.joiner.toString(localEntry1.getValue()));
      while (localIterator.hasNext())
      {
        paramA.append(Joiner.access$100(this.joiner));
        Map.Entry localEntry2 = (Map.Entry)localIterator.next();
        paramA.append(this.joiner.toString(localEntry2.getKey()));
        paramA.append(this.keyValueSeparator);
        paramA.append(this.joiner.toString(localEntry2.getValue()));
      }
    }
    return paramA;
  }

  public StringBuilder appendTo(StringBuilder paramStringBuilder, Iterable<? extends Map.Entry<?, ?>> paramIterable)
  {
    try
    {
      appendTo(paramStringBuilder, paramIterable);
      return paramStringBuilder;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }

  public StringBuilder appendTo(StringBuilder paramStringBuilder, Map<?, ?> paramMap)
  {
    return appendTo(paramStringBuilder, paramMap.entrySet());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Joiner.MapJoiner
 * JD-Core Version:    0.6.2
 */
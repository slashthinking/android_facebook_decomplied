package com.google.common.base;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class Joiner
{
  private final String separator;

  private Joiner(Joiner paramJoiner)
  {
    this.separator = paramJoiner.separator;
  }

  private Joiner(String paramString)
  {
    this.separator = ((String)Preconditions.checkNotNull(paramString));
  }

  private static Iterable<Object> iterable(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    Preconditions.checkNotNull(paramArrayOfObject);
    return new Joiner.3(paramArrayOfObject, paramObject1, paramObject2);
  }

  public static Joiner on(char paramChar)
  {
    return new Joiner(String.valueOf(paramChar));
  }

  public static Joiner on(String paramString)
  {
    return new Joiner(paramString);
  }

  public <A extends Appendable> A appendTo(A paramA, Iterable<?> paramIterable)
  {
    Preconditions.checkNotNull(paramA);
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext())
    {
      paramA.append(toString(localIterator.next()));
      while (localIterator.hasNext())
      {
        paramA.append(this.separator);
        paramA.append(toString(localIterator.next()));
      }
    }
    return paramA;
  }

  public final StringBuilder appendTo(StringBuilder paramStringBuilder, Iterable<?> paramIterable)
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

  public final StringBuilder appendTo(StringBuilder paramStringBuilder, Object[] paramArrayOfObject)
  {
    return appendTo(paramStringBuilder, Arrays.asList(paramArrayOfObject));
  }

  public final String join(Iterable<?> paramIterable)
  {
    return appendTo(new StringBuilder(), paramIterable).toString();
  }

  public final String join(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    return join(iterable(paramObject1, paramObject2, paramArrayOfObject));
  }

  public final String join(Object[] paramArrayOfObject)
  {
    return join(Arrays.asList(paramArrayOfObject));
  }

  public Joiner skipNulls()
  {
    return new Joiner.2(this, this);
  }

  CharSequence toString(Object paramObject)
  {
    Preconditions.checkNotNull(paramObject);
    if ((paramObject instanceof CharSequence));
    for (Object localObject = (CharSequence)paramObject; ; localObject = paramObject.toString())
      return localObject;
  }

  public Joiner.MapJoiner withKeyValueSeparator(String paramString)
  {
    return new Joiner.MapJoiner(this, paramString, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Joiner
 * JD-Core Version:    0.6.2
 */
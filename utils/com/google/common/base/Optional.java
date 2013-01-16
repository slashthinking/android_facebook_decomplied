package com.google.common.base;

import java.io.Serializable;

public abstract class Optional<T>
  implements Serializable
{
  private static final long serialVersionUID;

  public static <T> Optional<T> absent()
  {
    return Optional.Absent.access$000();
  }

  public static <T> Optional<T> fromNullable(T paramT)
  {
    if (paramT == null);
    for (Object localObject = absent(); ; localObject = new Optional.Present(paramT))
      return localObject;
  }

  public static <T> Optional<T> of(T paramT)
  {
    return new Optional.Present(Preconditions.checkNotNull(paramT));
  }

  public abstract T get();

  public abstract boolean isPresent();

  public abstract T or(T paramT);

  public abstract T orNull();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Optional
 * JD-Core Version:    0.6.2
 */
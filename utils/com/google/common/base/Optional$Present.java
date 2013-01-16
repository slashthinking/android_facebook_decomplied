package com.google.common.base;

final class Optional$Present<T> extends Optional<T>
{
  private static final long serialVersionUID;
  private final T reference;

  Optional$Present(T paramT)
  {
    super(null);
    this.reference = paramT;
  }

  public boolean equals(Object paramObject)
  {
    Present localPresent;
    if ((paramObject instanceof Present))
      localPresent = (Present)paramObject;
    for (boolean bool = this.reference.equals(localPresent.reference); ; bool = false)
      return bool;
  }

  public T get()
  {
    return this.reference;
  }

  public int hashCode()
  {
    return 1502476572 + this.reference.hashCode();
  }

  public boolean isPresent()
  {
    return true;
  }

  public T or(T paramT)
  {
    Preconditions.checkNotNull(paramT, "use orNull() instead of or(null)");
    return this.reference;
  }

  public T orNull()
  {
    return this.reference;
  }

  public String toString()
  {
    return "Optional.of(" + this.reference + ")";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Optional.Present
 * JD-Core Version:    0.6.2
 */
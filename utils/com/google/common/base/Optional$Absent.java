package com.google.common.base;

final class Optional$Absent extends Optional<Object>
{
  private static final Absent INSTANCE = new Absent();
  private static final long serialVersionUID;

  private Optional$Absent()
  {
    super(null);
  }

  private Object readResolve()
  {
    return INSTANCE;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public Object get()
  {
    throw new IllegalStateException("value is absent");
  }

  public int hashCode()
  {
    return 1502476572;
  }

  public boolean isPresent()
  {
    return false;
  }

  public Object or(Object paramObject)
  {
    return Preconditions.checkNotNull(paramObject, "use orNull() instead of or(null)");
  }

  public Object orNull()
  {
    return null;
  }

  public String toString()
  {
    return "Optional.absent()";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Optional.Absent
 * JD-Core Version:    0.6.2
 */
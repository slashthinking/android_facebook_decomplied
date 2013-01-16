package com.nineoldandroids.util;

public abstract class Property<T, V>
{
  private final String a;
  private final Class<V> b;

  public Property(Class<V> paramClass, String paramString)
  {
    this.a = paramString;
    this.b = paramClass;
  }

  public abstract V a(T paramT);

  public String a()
  {
    return this.a;
  }

  public void a(T paramT, V paramV)
  {
    throw new UnsupportedOperationException("Property " + a() + " is read-only");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.util.Property
 * JD-Core Version:    0.6.2
 */
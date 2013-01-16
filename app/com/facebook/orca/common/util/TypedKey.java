package com.facebook.orca.common.util;

import com.google.common.base.Preconditions;

public abstract class TypedKey<T extends TypedKey>
  implements Comparable<T>
{
  private final String a;

  protected TypedKey(String paramString)
  {
    this.a = paramString;
  }

  public String a()
  {
    return this.a;
  }

  public boolean a(T paramT)
  {
    return this.a.startsWith(paramT.a());
  }

  protected abstract T b(String paramString);

  public String b(T paramT)
  {
    Preconditions.checkArgument(this.a.startsWith(paramT.a()));
    return this.a.substring(paramT.a().length());
  }

  public int c(T paramT)
  {
    return this.a.compareTo(paramT.a());
  }

  public T c(String paramString)
  {
    return b(this.a + paramString);
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    TypedKey localTypedKey;
    do
    {
      while (true)
      {
        return i;
        if ((paramObject != null) && (getClass() == paramObject.getClass()))
          break;
        i = 0;
      }
      localTypedKey = (TypedKey)paramObject;
      if (this.a == null)
        break;
    }
    while (this.a.equals(localTypedKey.a()));
    while (true)
    {
      i = 0;
      break;
      if (localTypedKey.a() == null)
        break;
    }
  }

  public int hashCode()
  {
    if (this.a != null);
    for (int i = this.a.hashCode(); ; i = 0)
      return i;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.TypedKey
 * JD-Core Version:    0.6.0
 */
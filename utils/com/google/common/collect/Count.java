package com.google.common.collect;

import java.io.Serializable;

final class Count
  implements Serializable
{
  private int value;

  Count()
  {
    this(0);
  }

  Count(int paramInt)
  {
    this.value = paramInt;
  }

  public int a()
  {
    return this.value;
  }

  public int a(int paramInt)
  {
    int i = this.value;
    this.value = (i + paramInt);
    return i;
  }

  public int b(int paramInt)
  {
    int i = paramInt + this.value;
    this.value = i;
    return i;
  }

  public void c(int paramInt)
  {
    this.value = paramInt;
  }

  public int d(int paramInt)
  {
    int i = this.value;
    this.value = paramInt;
    return i;
  }

  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof Count)) && (((Count)paramObject).value == this.value));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int hashCode()
  {
    return this.value;
  }

  public String toString()
  {
    return Integer.toString(this.value);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Count
 * JD-Core Version:    0.6.2
 */
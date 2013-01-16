package com.facebook.orca.common.util;

import com.google.common.base.Preconditions;

public class RingBuffer<T>
{
  private final T[] a;
  private int b = 0;
  private int c = 0;
  private int d = 0;

  public RingBuffer(int paramInt)
  {
    this.a = ((Object[])new Object[paramInt]);
  }

  public T a()
  {
    if (this.b > 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Underflow");
      Object localObject = this.a[this.c];
      this.a[this.c] = null;
      this.c = ((1 + this.c) % this.a.length);
      this.b = (-1 + this.b);
      return localObject;
    }
  }

  public T a(int paramInt)
  {
    if (this.b <= paramInt)
      throw new IndexOutOfBoundsException();
    int i = (paramInt + this.c) % this.a.length;
    return this.a[i];
  }

  public void a(T paramT)
  {
    if (this.b < this.a.length);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Overflow");
      this.a[this.d] = paramT;
      this.d = ((1 + this.d) % this.a.length);
      this.b = (1 + this.b);
      return;
    }
  }

  public boolean b()
  {
    if (this.b == this.a.length);
    for (int i = 1; ; i = 0)
      return i;
  }

  public int c()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.RingBuffer
 * JD-Core Version:    0.6.0
 */
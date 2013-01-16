package android.support.v4.util;

public class SparseArrayCompat<E>
{
  private static final Object a = new Object();
  private boolean b = false;
  private int[] c;
  private Object[] d;
  private int e;

  public SparseArrayCompat()
  {
    this(10);
  }

  public SparseArrayCompat(int paramInt)
  {
    int i = h(paramInt);
    this.c = new int[i];
    this.d = new Object[i];
    this.e = 0;
  }

  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1 + paramInt2;
    int j = paramInt1 - 1;
    int k = i;
    while (k - j > 1)
    {
      int m = (k + j) / 2;
      if (paramArrayOfInt[m] < paramInt3)
      {
        j = m;
        continue;
      }
      k = m;
    }
    if (k == paramInt1 + paramInt2)
      k = 0xFFFFFFFF ^ paramInt1 + paramInt2;
    while (true)
    {
      return k;
      if (paramArrayOfInt[k] == paramInt3)
        continue;
      k ^= -1;
    }
  }

  private void c()
  {
    int i = this.e;
    int[] arrayOfInt = this.c;
    Object[] arrayOfObject = this.d;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      Object localObject = arrayOfObject[j];
      if (localObject != a)
      {
        if (j != k)
        {
          arrayOfInt[k] = arrayOfInt[j];
          arrayOfObject[k] = localObject;
        }
        k++;
      }
      j++;
    }
    this.b = false;
    this.e = k;
  }

  static int g(int paramInt)
  {
    for (int i = 4; ; i++)
    {
      if (i < 32)
      {
        if (paramInt > -12 + (1 << i))
          continue;
        paramInt = -12 + (1 << i);
      }
      return paramInt;
    }
  }

  static int h(int paramInt)
  {
    return g(paramInt * 4) / 4;
  }

  public int a()
  {
    if (this.b)
      c();
    return this.e;
  }

  public E a(int paramInt)
  {
    return a(paramInt, null);
  }

  public E a(int paramInt, E paramE)
  {
    int i = a(this.c, 0, this.e, paramInt);
    if ((i < 0) || (this.d[i] == a));
    while (true)
    {
      return paramE;
      paramE = this.d[i];
    }
  }

  public void b()
  {
    int i = this.e;
    Object[] arrayOfObject = this.d;
    for (int j = 0; j < i; j++)
      arrayOfObject[j] = null;
    this.e = 0;
    this.b = false;
  }

  public void b(int paramInt)
  {
    int i = a(this.c, 0, this.e, paramInt);
    if ((i >= 0) && (this.d[i] != a))
    {
      this.d[i] = a;
      this.b = true;
    }
  }

  public void b(int paramInt, E paramE)
  {
    int i = a(this.c, 0, this.e, paramInt);
    if (i >= 0)
      this.d[i] = paramE;
    while (true)
    {
      return;
      int j = i ^ 0xFFFFFFFF;
      if ((j < this.e) && (this.d[j] == a))
      {
        this.c[j] = paramInt;
        this.d[j] = paramE;
        continue;
      }
      if ((this.b) && (this.e >= this.c.length))
      {
        c();
        j = 0xFFFFFFFF ^ a(this.c, 0, this.e, paramInt);
      }
      if (this.e >= this.c.length)
      {
        int k = h(1 + this.e);
        int[] arrayOfInt = new int[k];
        Object[] arrayOfObject = new Object[k];
        System.arraycopy(this.c, 0, arrayOfInt, 0, this.c.length);
        System.arraycopy(this.d, 0, arrayOfObject, 0, this.d.length);
        this.c = arrayOfInt;
        this.d = arrayOfObject;
      }
      if (this.e - j != 0)
      {
        System.arraycopy(this.c, j, this.c, j + 1, this.e - j);
        System.arraycopy(this.d, j, this.d, j + 1, this.e - j);
      }
      this.c[j] = paramInt;
      this.d[j] = paramE;
      this.e = (1 + this.e);
    }
  }

  public void c(int paramInt)
  {
    b(paramInt);
  }

  public void d(int paramInt)
  {
    if (this.d[paramInt] != a)
    {
      this.d[paramInt] = a;
      this.b = true;
    }
  }

  public int e(int paramInt)
  {
    if (this.b)
      c();
    return this.c[paramInt];
  }

  public E f(int paramInt)
  {
    if (this.b)
      c();
    return this.d[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.util.SparseArrayCompat
 * JD-Core Version:    0.6.0
 */
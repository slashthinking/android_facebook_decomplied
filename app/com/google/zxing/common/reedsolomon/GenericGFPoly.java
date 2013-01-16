package com.google.zxing.common.reedsolomon;

final class GenericGFPoly
{
  private final GenericGF a;
  private final int[] b;

  GenericGFPoly(GenericGF paramGenericGF, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0)
      throw new IllegalArgumentException();
    this.a = paramGenericGF;
    int j = paramArrayOfInt.length;
    if ((j > i) && (paramArrayOfInt[0] == 0))
    {
      while ((i < j) && (paramArrayOfInt[i] == 0))
        i++;
      if (i == j)
        this.b = paramGenericGF.a().b;
    }
    while (true)
    {
      return;
      this.b = new int[j - i];
      System.arraycopy(paramArrayOfInt, i, this.b, 0, this.b.length);
      continue;
      this.b = paramArrayOfInt;
    }
  }

  int a(int paramInt)
  {
    return this.b[(-1 + this.b.length - paramInt)];
  }

  GenericGFPoly a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      throw new IllegalArgumentException();
    if (paramInt2 == 0);
    int[] arrayOfInt;
    for (GenericGFPoly localGenericGFPoly = this.a.a(); ; localGenericGFPoly = new GenericGFPoly(this.a, arrayOfInt))
    {
      return localGenericGFPoly;
      int i = this.b.length;
      arrayOfInt = new int[i + paramInt1];
      for (int j = 0; j < i; j++)
        arrayOfInt[j] = this.a.c(this.b[j], paramInt2);
    }
  }

  GenericGFPoly a(GenericGFPoly paramGenericGFPoly)
  {
    if (!this.a.equals(paramGenericGFPoly.a))
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    if (c());
    while (true)
    {
      return paramGenericGFPoly;
      if (!paramGenericGFPoly.c())
        break;
      paramGenericGFPoly = this;
    }
    Object localObject1 = this.b;
    Object localObject2 = paramGenericGFPoly.b;
    if (localObject1.length > localObject2.length);
    while (true)
    {
      int[] arrayOfInt = new int[localObject1.length];
      int i = localObject1.length - localObject2.length;
      System.arraycopy(localObject1, 0, arrayOfInt, 0, i);
      for (int j = i; j < localObject1.length; j++)
        arrayOfInt[j] = GenericGF.b(localObject2[(j - i)], localObject1[j]);
      paramGenericGFPoly = new GenericGFPoly(this.a, arrayOfInt);
      break;
      Object localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }

  int[] a()
  {
    return this.b;
  }

  int b()
  {
    return -1 + this.b.length;
  }

  int b(int paramInt)
  {
    int i = 0;
    int k;
    if (paramInt == 0)
      k = a(0);
    while (true)
    {
      return k;
      int j = this.b.length;
      if (paramInt == 1)
      {
        int[] arrayOfInt = this.b;
        int i1 = arrayOfInt.length;
        int i2;
        for (k = 0; i < i1; k = i2)
        {
          i2 = GenericGF.b(k, arrayOfInt[i]);
          i++;
        }
        continue;
      }
      k = this.b[0];
      int m = 1;
      while (m < j)
      {
        int n = GenericGF.b(this.a.c(paramInt, k), this.b[m]);
        m++;
        k = n;
      }
    }
  }

  GenericGFPoly b(GenericGFPoly paramGenericGFPoly)
  {
    if (!this.a.equals(paramGenericGFPoly.a))
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    if ((c()) || (paramGenericGFPoly.c()));
    int[] arrayOfInt3;
    for (GenericGFPoly localGenericGFPoly = this.a.a(); ; localGenericGFPoly = new GenericGFPoly(this.a, arrayOfInt3))
    {
      return localGenericGFPoly;
      int[] arrayOfInt1 = this.b;
      int i = arrayOfInt1.length;
      int[] arrayOfInt2 = paramGenericGFPoly.b;
      int j = arrayOfInt2.length;
      arrayOfInt3 = new int[-1 + (i + j)];
      for (int k = 0; k < i; k++)
      {
        int m = arrayOfInt1[k];
        for (int n = 0; n < j; n++)
          arrayOfInt3[(k + n)] = GenericGF.b(arrayOfInt3[(k + n)], this.a.c(m, arrayOfInt2[n]));
      }
    }
  }

  GenericGFPoly c(int paramInt)
  {
    if (paramInt == 0)
      this = this.a.a();
    while (true)
    {
      return this;
      if (paramInt == 1)
        continue;
      int i = this.b.length;
      int[] arrayOfInt = new int[i];
      for (int j = 0; j < i; j++)
        arrayOfInt[j] = this.a.c(this.b[j], paramInt);
      this = new GenericGFPoly(this.a, arrayOfInt);
    }
  }

  boolean c()
  {
    int i = this.b[0];
    int j = 0;
    if (i == 0)
      j = 1;
    return j;
  }

  GenericGFPoly[] c(GenericGFPoly paramGenericGFPoly)
  {
    if (!this.a.equals(paramGenericGFPoly.a))
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    if (paramGenericGFPoly.c())
      throw new IllegalArgumentException("Divide by 0");
    GenericGFPoly localGenericGFPoly1 = this.a.a();
    int i = paramGenericGFPoly.a(paramGenericGFPoly.b());
    int j = this.a.c(i);
    GenericGFPoly localGenericGFPoly2 = localGenericGFPoly1;
    GenericGFPoly localGenericGFPoly4;
    for (GenericGFPoly localGenericGFPoly3 = this; (localGenericGFPoly3.b() >= paramGenericGFPoly.b()) && (!localGenericGFPoly3.c()); localGenericGFPoly3 = localGenericGFPoly3.a(localGenericGFPoly4))
    {
      int k = localGenericGFPoly3.b() - paramGenericGFPoly.b();
      int m = this.a.c(localGenericGFPoly3.a(localGenericGFPoly3.b()), j);
      localGenericGFPoly4 = paramGenericGFPoly.a(k, m);
      localGenericGFPoly2 = localGenericGFPoly2.a(this.a.a(k, m));
    }
    return new GenericGFPoly[] { localGenericGFPoly2, localGenericGFPoly3 };
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(8 * b());
    int i = b();
    if (i >= 0)
    {
      int j = a(i);
      label48: int k;
      if (j != 0)
      {
        if (j >= 0)
          break label101;
        localStringBuilder.append(" - ");
        j = -j;
        if ((i == 0) || (j != 1))
        {
          k = this.a.b(j);
          if (k != 0)
            break label118;
          localStringBuilder.append('1');
        }
        label79: if (i != 0)
        {
          if (i != 1)
            break label151;
          localStringBuilder.append('x');
        }
      }
      while (true)
      {
        i--;
        break;
        label101: if (localStringBuilder.length() <= 0)
          break label48;
        localStringBuilder.append(" + ");
        break label48;
        label118: if (k == 1)
        {
          localStringBuilder.append('a');
          break label79;
        }
        localStringBuilder.append("a^");
        localStringBuilder.append(k);
        break label79;
        label151: localStringBuilder.append("x^");
        localStringBuilder.append(i);
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.GenericGFPoly
 * JD-Core Version:    0.6.0
 */
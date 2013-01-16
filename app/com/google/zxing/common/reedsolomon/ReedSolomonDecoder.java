package com.google.zxing.common.reedsolomon;

public final class ReedSolomonDecoder
{
  private final GenericGF a;

  public ReedSolomonDecoder(GenericGF paramGenericGF)
  {
    this.a = paramGenericGF;
  }

  private int[] a(GenericGFPoly paramGenericGFPoly)
  {
    int i = 0;
    int j = 1;
    int k = paramGenericGFPoly.b();
    int[] arrayOfInt2;
    if (k == j)
    {
      arrayOfInt2 = new int[j];
      arrayOfInt2[0] = paramGenericGFPoly.a(j);
    }
    int[] arrayOfInt1;
    for (Object localObject = arrayOfInt2; ; localObject = arrayOfInt1)
    {
      return localObject;
      arrayOfInt1 = new int[k];
      while ((j < this.a.c()) && (i < k))
      {
        if (paramGenericGFPoly.b(j) == 0)
        {
          arrayOfInt1[i] = this.a.c(j);
          i++;
        }
        j++;
      }
      if (i == k)
        continue;
      throw new ReedSolomonException("Error locator degree does not match number of roots");
    }
  }

  private int[] a(GenericGFPoly paramGenericGFPoly, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i];
    int j = 0;
    int k;
    int m;
    int n;
    label39: int i2;
    int i3;
    if (j < i)
    {
      k = this.a.c(paramArrayOfInt[j]);
      m = 1;
      n = 0;
      if (n < i)
      {
        if (j == n)
          break label173;
        i2 = this.a.c(paramArrayOfInt[n], k);
        if ((i2 & 0x1) == 0)
          i3 = i2 | 0x1;
      }
    }
    label81: for (int i1 = this.a.c(m, i3); ; i1 = m)
    {
      n++;
      m = i1;
      break label39;
      i3 = i2 & 0xFFFFFFFE;
      break label81;
      arrayOfInt[j] = this.a.c(paramGenericGFPoly.b(k), this.a.c(m));
      if (paramBoolean)
        arrayOfInt[j] = this.a.c(arrayOfInt[j], k);
      j++;
      break;
      return arrayOfInt;
    }
  }

  private GenericGFPoly[] a(GenericGFPoly paramGenericGFPoly1, GenericGFPoly paramGenericGFPoly2, int paramInt)
  {
    if (paramGenericGFPoly1.b() < paramGenericGFPoly2.b());
    while (true)
    {
      Object localObject1 = this.a.a();
      Object localObject2 = this.a.b();
      while (paramGenericGFPoly1.b() >= paramInt / 2)
      {
        if (paramGenericGFPoly1.c())
          throw new ReedSolomonException("r_{i-1} was zero");
        GenericGFPoly localGenericGFPoly2 = this.a.a();
        int k = paramGenericGFPoly1.a(paramGenericGFPoly1.b());
        int m = this.a.c(k);
        GenericGFPoly localGenericGFPoly3 = localGenericGFPoly2;
        int n;
        int i1;
        for (GenericGFPoly localGenericGFPoly4 = paramGenericGFPoly2; (localGenericGFPoly4.b() >= paramGenericGFPoly1.b()) && (!localGenericGFPoly4.c()); localGenericGFPoly4 = localGenericGFPoly4.a(paramGenericGFPoly1.a(n, i1)))
        {
          n = localGenericGFPoly4.b() - paramGenericGFPoly1.b();
          i1 = this.a.c(localGenericGFPoly4.a(localGenericGFPoly4.b()), m);
          localGenericGFPoly3 = localGenericGFPoly3.a(this.a.a(n, i1));
        }
        GenericGFPoly localGenericGFPoly5 = localGenericGFPoly3.b((GenericGFPoly)localObject2).a((GenericGFPoly)localObject1);
        paramGenericGFPoly2 = paramGenericGFPoly1;
        paramGenericGFPoly1 = localGenericGFPoly4;
        Object localObject3 = localObject2;
        localObject2 = localGenericGFPoly5;
        localObject1 = localObject3;
      }
      int i = ((GenericGFPoly)localObject2).a(0);
      if (i == 0)
        throw new ReedSolomonException("sigmaTilde(0) was zero");
      int j = this.a.c(i);
      return new GenericGFPoly[] { ((GenericGFPoly)localObject2).c(j), paramGenericGFPoly1.c(j) };
      GenericGFPoly localGenericGFPoly1 = paramGenericGFPoly2;
      paramGenericGFPoly2 = paramGenericGFPoly1;
      paramGenericGFPoly1 = localGenericGFPoly1;
    }
  }

  public void a(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    GenericGFPoly localGenericGFPoly1 = new GenericGFPoly(this.a, paramArrayOfInt);
    int[] arrayOfInt1 = new int[paramInt];
    boolean bool = this.a.equals(GenericGF.f);
    int j = 0;
    int k = 1;
    int n;
    if (j < paramInt)
    {
      GenericGF localGenericGF = this.a;
      if (bool)
      {
        n = j + 1;
        label62: int i1 = localGenericGFPoly1.b(localGenericGF.a(n));
        arrayOfInt1[(-1 + arrayOfInt1.length - j)] = i1;
        if (i1 == 0)
          break label246;
      }
    }
    label246: for (int i2 = 0; ; i2 = k)
    {
      j++;
      k = i2;
      break;
      n = j;
      break label62;
      if (k != 0);
      while (true)
      {
        return;
        GenericGFPoly localGenericGFPoly2 = new GenericGFPoly(this.a, arrayOfInt1);
        GenericGFPoly[] arrayOfGenericGFPoly = a(this.a.a(paramInt, 1), localGenericGFPoly2, paramInt);
        GenericGFPoly localGenericGFPoly3 = arrayOfGenericGFPoly[0];
        GenericGFPoly localGenericGFPoly4 = arrayOfGenericGFPoly[1];
        int[] arrayOfInt2 = a(localGenericGFPoly3);
        int[] arrayOfInt3 = a(localGenericGFPoly4, arrayOfInt2, bool);
        while (i < arrayOfInt2.length)
        {
          int m = -1 + paramArrayOfInt.length - this.a.b(arrayOfInt2[i]);
          if (m < 0)
            throw new ReedSolomonException("Bad error location");
          paramArrayOfInt[m] = GenericGF.b(paramArrayOfInt[m], arrayOfInt3[i]);
          i++;
        }
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.ReedSolomonDecoder
 * JD-Core Version:    0.6.0
 */
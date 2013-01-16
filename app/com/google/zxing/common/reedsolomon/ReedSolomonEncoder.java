package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

public final class ReedSolomonEncoder
{
  private final GenericGF a;
  private final List<GenericGFPoly> b;

  public ReedSolomonEncoder(GenericGF paramGenericGF)
  {
    if (!GenericGF.e.equals(paramGenericGF))
      throw new IllegalArgumentException("Only QR Code is supported at this time");
    this.a = paramGenericGF;
    this.b = new ArrayList();
    this.b.add(new GenericGFPoly(paramGenericGF, new int[] { 1 }));
  }

  private GenericGFPoly a(int paramInt)
  {
    if (paramInt >= this.b.size())
    {
      GenericGFPoly localGenericGFPoly1 = (GenericGFPoly)this.b.get(-1 + this.b.size());
      int i = this.b.size();
      GenericGFPoly localGenericGFPoly2 = localGenericGFPoly1;
      for (int j = i; j <= paramInt; j++)
      {
        GenericGF localGenericGF = this.a;
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = 1;
        arrayOfInt[1] = this.a.a(j - 1);
        localGenericGFPoly2 = localGenericGFPoly2.b(new GenericGFPoly(localGenericGF, arrayOfInt));
        this.b.add(localGenericGFPoly2);
      }
    }
    return (GenericGFPoly)this.b.get(paramInt);
  }

  public void a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt == 0)
      throw new IllegalArgumentException("No error correction bytes");
    int i = paramArrayOfInt.length - paramInt;
    if (i <= 0)
      throw new IllegalArgumentException("No data bytes provided");
    GenericGFPoly localGenericGFPoly = a(paramInt);
    int[] arrayOfInt1 = new int[i];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt1, 0, i);
    int[] arrayOfInt2 = new GenericGFPoly(this.a, arrayOfInt1).a(paramInt, 1).c(localGenericGFPoly)[1].a();
    int j = paramInt - arrayOfInt2.length;
    for (int k = 0; k < j; k++)
      paramArrayOfInt[(i + k)] = 0;
    System.arraycopy(arrayOfInt2, 0, paramArrayOfInt, i + j, arrayOfInt2.length);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.ReedSolomonEncoder
 * JD-Core Version:    0.6.0
 */
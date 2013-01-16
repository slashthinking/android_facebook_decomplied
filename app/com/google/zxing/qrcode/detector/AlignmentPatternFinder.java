package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class AlignmentPatternFinder
{
  private final BitMatrix a;
  private final List<AlignmentPattern> b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final float g;
  private final int[] h;
  private final ResultPointCallback i;

  AlignmentPatternFinder(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, ResultPointCallback paramResultPointCallback)
  {
    this.a = paramBitMatrix;
    this.b = new ArrayList(5);
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
    this.g = paramFloat;
    this.h = new int[3];
    this.i = paramResultPointCallback;
  }

  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = (0.0F / 0.0F);
    BitMatrix localBitMatrix = this.a;
    int j = localBitMatrix.d();
    int[] arrayOfInt = this.h;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    for (int k = paramInt1; (k >= 0) && (localBitMatrix.a(paramInt2, k)) && (arrayOfInt[1] <= paramInt3); k--)
      arrayOfInt[1] = (1 + arrayOfInt[1]);
    if ((k < 0) || (arrayOfInt[1] > paramInt3));
    while (true)
    {
      return f1;
      while ((k >= 0) && (!localBitMatrix.a(paramInt2, k)) && (arrayOfInt[0] <= paramInt3))
      {
        arrayOfInt[0] = (1 + arrayOfInt[0]);
        k--;
      }
      if (arrayOfInt[0] > paramInt3)
        continue;
      for (int m = paramInt1 + 1; (m < j) && (localBitMatrix.a(paramInt2, m)) && (arrayOfInt[1] <= paramInt3); m++)
        arrayOfInt[1] = (1 + arrayOfInt[1]);
      if ((m == j) || (arrayOfInt[1] > paramInt3))
        continue;
      while ((m < j) && (!localBitMatrix.a(paramInt2, m)) && (arrayOfInt[2] <= paramInt3))
      {
        arrayOfInt[2] = (1 + arrayOfInt[2]);
        m++;
      }
      if ((arrayOfInt[2] > paramInt3) || (5 * Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] - paramInt4) >= paramInt4 * 2) || (!a(arrayOfInt)))
        continue;
      f1 = a(arrayOfInt, m);
    }
  }

  private static float a(int[] paramArrayOfInt, int paramInt)
  {
    return paramInt - paramArrayOfInt[2] - paramArrayOfInt[1] / 2.0F;
  }

  private AlignmentPattern a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int j = paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2];
    float f1 = a(paramArrayOfInt, paramInt2);
    float f2 = a(paramInt1, (int)f1, 2 * paramArrayOfInt[1], j);
    float f3;
    AlignmentPattern localAlignmentPattern3;
    if (!Float.isNaN(f2))
    {
      f3 = (paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2]) / 3.0F;
      Iterator localIterator = this.b.iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        localAlignmentPattern3 = (AlignmentPattern)localIterator.next();
      }
      while (!localAlignmentPattern3.a(f3, f2, f1));
    }
    for (AlignmentPattern localAlignmentPattern1 = localAlignmentPattern3.b(f2, f1, f3); ; localAlignmentPattern1 = null)
    {
      return localAlignmentPattern1;
      AlignmentPattern localAlignmentPattern2 = new AlignmentPattern(f1, f2, f3);
      this.b.add(localAlignmentPattern2);
      if (this.i == null)
        continue;
      this.i.a(localAlignmentPattern2);
    }
  }

  private boolean a(int[] paramArrayOfInt)
  {
    float f1 = this.g;
    float f2 = f1 / 2.0F;
    int j = 0;
    int k;
    if (j < 3)
    {
      boolean bool = Math.abs(f1 - paramArrayOfInt[j]) < f2;
      k = 0;
      if (bool);
    }
    while (true)
    {
      return k;
      j++;
      break;
      k = 1;
    }
  }

  AlignmentPattern a()
  {
    int j = this.c;
    int k = this.f;
    int m = j + this.e;
    int n = this.d + (k >> 1);
    int[] arrayOfInt = new int[3];
    int i1 = 0;
    int i3;
    int i6;
    label164: AlignmentPattern localAlignmentPattern;
    if (i1 < k)
    {
      if ((i1 & 0x1) == 0);
      int i4;
      for (int i2 = i1 + 1 >> 1; ; i2 = -(i1 + 1 >> 1))
      {
        i3 = n + i2;
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        arrayOfInt[2] = 0;
        for (i4 = j; (i4 < m) && (!this.a.a(i4, i3)); i4++);
      }
      int i5 = i4;
      i6 = 0;
      while (true)
      {
        if (i5 >= m)
          break label271;
        if (this.a.a(i5, i3))
        {
          if (i6 == 1)
          {
            arrayOfInt[i6] = (1 + arrayOfInt[i6]);
            i5++;
            continue;
          }
          if (i6 == 2)
          {
            if (!a(arrayOfInt))
              break;
            localAlignmentPattern = a(arrayOfInt, i3, i5);
            if (localAlignmentPattern == null)
              break;
          }
        }
      }
    }
    while (true)
    {
      return localAlignmentPattern;
      arrayOfInt[0] = arrayOfInt[2];
      arrayOfInt[1] = 1;
      arrayOfInt[2] = 0;
      i6 = 1;
      break label164;
      i6++;
      arrayOfInt[i6] = (1 + arrayOfInt[i6]);
      break label164;
      if (i6 == 1)
        i6++;
      arrayOfInt[i6] = (1 + arrayOfInt[i6]);
      break label164;
      label271: if (a(arrayOfInt))
      {
        localAlignmentPattern = a(arrayOfInt, i3, m);
        if (localAlignmentPattern != null)
          continue;
      }
      i1++;
      break;
      if (this.b.isEmpty())
        break label332;
      localAlignmentPattern = (AlignmentPattern)this.b.get(0);
    }
    label332: throw NotFoundException.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.AlignmentPatternFinder
 * JD-Core Version:    0.6.0
 */
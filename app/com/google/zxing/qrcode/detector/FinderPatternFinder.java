package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder
{
  private final BitMatrix a;
  private final List<FinderPattern> b;
  private boolean c;
  private final int[] d;
  private final ResultPointCallback e;

  public FinderPatternFinder(BitMatrix paramBitMatrix, ResultPointCallback paramResultPointCallback)
  {
    this.a = paramBitMatrix;
    this.b = new ArrayList();
    this.d = new int[5];
    this.e = paramResultPointCallback;
  }

  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = (0.0F / 0.0F);
    BitMatrix localBitMatrix = this.a;
    int i = localBitMatrix.d();
    int[] arrayOfInt = a();
    for (int j = paramInt1; (j >= 0) && (localBitMatrix.a(paramInt2, j)); j--)
      arrayOfInt[2] = (1 + arrayOfInt[2]);
    if (j < 0);
    while (true)
    {
      return f;
      while ((j >= 0) && (!localBitMatrix.a(paramInt2, j)) && (arrayOfInt[1] <= paramInt3))
      {
        arrayOfInt[1] = (1 + arrayOfInt[1]);
        j--;
      }
      if ((j < 0) || (arrayOfInt[1] > paramInt3))
        continue;
      while ((j >= 0) && (localBitMatrix.a(paramInt2, j)) && (arrayOfInt[0] <= paramInt3))
      {
        arrayOfInt[0] = (1 + arrayOfInt[0]);
        j--;
      }
      if (arrayOfInt[0] > paramInt3)
        continue;
      for (int k = paramInt1 + 1; (k < i) && (localBitMatrix.a(paramInt2, k)); k++)
        arrayOfInt[2] = (1 + arrayOfInt[2]);
      if (k == i)
        continue;
      while ((k < i) && (!localBitMatrix.a(paramInt2, k)) && (arrayOfInt[3] < paramInt3))
      {
        arrayOfInt[3] = (1 + arrayOfInt[3]);
        k++;
      }
      if ((k == i) || (arrayOfInt[3] >= paramInt3))
        continue;
      while ((k < i) && (localBitMatrix.a(paramInt2, k)) && (arrayOfInt[4] < paramInt3))
      {
        arrayOfInt[4] = (1 + arrayOfInt[4]);
        k++;
      }
      if ((arrayOfInt[4] >= paramInt3) || (5 * Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) >= paramInt4 * 2) || (!a(arrayOfInt)))
        continue;
      f = a(arrayOfInt, k);
    }
  }

  private static float a(int[] paramArrayOfInt, int paramInt)
  {
    return paramInt - paramArrayOfInt[4] - paramArrayOfInt[3] - paramArrayOfInt[2] / 2.0F;
  }

  protected static boolean a(int[] paramArrayOfInt)
  {
    int i = 1;
    int j = 0;
    int k = 0;
    int i2;
    int m;
    if (j < 5)
    {
      i2 = paramArrayOfInt[j];
      m = 0;
      if (i2 != 0);
    }
    do
    {
      return m;
      k += i2;
      j++;
      break;
      m = 0;
    }
    while (k < 7);
    int n = (k << 8) / 7;
    int i1 = n / 2;
    if ((Math.abs(n - (paramArrayOfInt[0] << 8)) < i1) && (Math.abs(n - (paramArrayOfInt[i] << 8)) < i1) && (Math.abs(n * 3 - (paramArrayOfInt[2] << 8)) < i1 * 3) && (Math.abs(n - (paramArrayOfInt[3] << 8)) < i1) && (Math.abs(n - (paramArrayOfInt[4] << 8)) < i1));
    while (true)
    {
      m = i;
      break;
      i = 0;
    }
  }

  private int[] a()
  {
    this.d[0] = 0;
    this.d[1] = 0;
    this.d[2] = 0;
    this.d[3] = 0;
    this.d[4] = 0;
    return this.d;
  }

  private float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = (0.0F / 0.0F);
    BitMatrix localBitMatrix = this.a;
    int i = localBitMatrix.c();
    int[] arrayOfInt = a();
    for (int j = paramInt1; (j >= 0) && (localBitMatrix.a(j, paramInt2)); j--)
      arrayOfInt[2] = (1 + arrayOfInt[2]);
    if (j < 0);
    while (true)
    {
      return f;
      while ((j >= 0) && (!localBitMatrix.a(j, paramInt2)) && (arrayOfInt[1] <= paramInt3))
      {
        arrayOfInt[1] = (1 + arrayOfInt[1]);
        j--;
      }
      if ((j < 0) || (arrayOfInt[1] > paramInt3))
        continue;
      while ((j >= 0) && (localBitMatrix.a(j, paramInt2)) && (arrayOfInt[0] <= paramInt3))
      {
        arrayOfInt[0] = (1 + arrayOfInt[0]);
        j--;
      }
      if (arrayOfInt[0] > paramInt3)
        continue;
      for (int k = paramInt1 + 1; (k < i) && (localBitMatrix.a(k, paramInt2)); k++)
        arrayOfInt[2] = (1 + arrayOfInt[2]);
      if (k == i)
        continue;
      while ((k < i) && (!localBitMatrix.a(k, paramInt2)) && (arrayOfInt[3] < paramInt3))
      {
        arrayOfInt[3] = (1 + arrayOfInt[3]);
        k++;
      }
      if ((k == i) || (arrayOfInt[3] >= paramInt3))
        continue;
      while ((k < i) && (localBitMatrix.a(k, paramInt2)) && (arrayOfInt[4] < paramInt3))
      {
        arrayOfInt[4] = (1 + arrayOfInt[4]);
        k++;
      }
      if ((arrayOfInt[4] >= paramInt3) || (5 * Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) >= paramInt4) || (!a(arrayOfInt)))
        continue;
      f = a(arrayOfInt, k);
    }
  }

  private int b()
  {
    int i;
    if (this.b.size() <= 1)
    {
      i = 0;
      return i;
    }
    Object localObject1 = null;
    Iterator localIterator = this.b.iterator();
    label29: Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (FinderPattern)localIterator.next();
      if (((FinderPattern)localObject2).d() < 2)
        break label112;
      if (localObject1 != null);
    }
    while (true)
    {
      localObject1 = localObject2;
      break label29;
      this.c = true;
      i = (int)(Math.abs(localObject1.a() - ((FinderPattern)localObject2).a()) - Math.abs(localObject1.b() - ((FinderPattern)localObject2).b())) / 2;
      break;
      i = 0;
      break;
      label112: localObject2 = localObject1;
    }
  }

  private boolean c()
  {
    float f1 = 0.0F;
    int i = this.b.size();
    Iterator localIterator1 = this.b.iterator();
    float f2 = 0.0F;
    int j = 0;
    int n;
    float f4;
    if (localIterator1.hasNext())
    {
      FinderPattern localFinderPattern = (FinderPattern)localIterator1.next();
      if (localFinderPattern.d() < 2)
        break label176;
      n = j + 1;
      f4 = f2 + localFinderPattern.c();
    }
    for (int m = n; ; m = j)
    {
      j = m;
      f2 = f4;
      break;
      int k = 0;
      if (j < 3);
      while (true)
      {
        return k;
        float f3 = f2 / i;
        Iterator localIterator2 = this.b.iterator();
        while (localIterator2.hasNext())
          f1 += Math.abs(((FinderPattern)localIterator2.next()).c() - f3);
        boolean bool = f1 < 0.05F * f2;
        k = 0;
        if (bool)
          continue;
        k = 1;
      }
      label176: f4 = f2;
    }
  }

  private FinderPattern[] d()
  {
    float f1 = 0.0F;
    int i = this.b.size();
    if (i < 3)
      throw NotFoundException.a();
    if (i > 3)
    {
      Iterator localIterator2 = this.b.iterator();
      float f3 = 0.0F;
      float f4 = 0.0F;
      while (localIterator2.hasNext())
      {
        float f8 = ((FinderPattern)localIterator2.next()).c();
        f4 += f8;
        f3 += f8 * f8;
      }
      float f5 = f4 / i;
      float f6 = (float)Math.sqrt(f3 / i - f5 * f5);
      Collections.sort(this.b, new FinderPatternFinder.FurthestFromAverageComparator(f5, null));
      float f7 = Math.max(0.2F * f5, f6);
      for (int j = 0; (j < this.b.size()) && (this.b.size() > 3); j++)
      {
        if (Math.abs(((FinderPattern)this.b.get(j)).c() - f5) <= f7)
          continue;
        this.b.remove(j);
        j--;
      }
    }
    if (this.b.size() > 3)
    {
      Iterator localIterator1 = this.b.iterator();
      while (localIterator1.hasNext())
        f1 += ((FinderPattern)localIterator1.next()).c();
      float f2 = f1 / this.b.size();
      Collections.sort(this.b, new FinderPatternFinder.CenterComparator(f2, null));
      this.b.subList(3, this.b.size()).clear();
    }
    FinderPattern[] arrayOfFinderPattern = new FinderPattern[3];
    arrayOfFinderPattern[0] = ((FinderPattern)this.b.get(0));
    arrayOfFinderPattern[1] = ((FinderPattern)this.b.get(1));
    arrayOfFinderPattern[2] = ((FinderPattern)this.b.get(2));
    return arrayOfFinderPattern;
  }

  final FinderPatternInfo a(Map<DecodeHintType, ?> paramMap)
  {
    int i;
    int j;
    int k;
    int m;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.TRY_HARDER)))
    {
      i = 1;
      j = this.a.d();
      k = this.a.c();
      m = j * 3 / 228;
      if ((m >= 3) && (i == 0))
        break label502;
    }
    label117: label502: for (int n = 3; ; n = m)
    {
      int[] arrayOfInt = new int[5];
      int i1 = n - 1;
      boolean bool1 = false;
      int i2 = n;
      int i3;
      int i4;
      boolean bool2;
      int i7;
      int i6;
      if ((i1 < j) && (!bool1))
      {
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        arrayOfInt[2] = 0;
        arrayOfInt[3] = 0;
        arrayOfInt[4] = 0;
        i3 = 0;
        i4 = 0;
        if (i3 < k)
        {
          if (this.a.a(i3, i1))
          {
            if ((i4 & 0x1) == 1)
              i4++;
            arrayOfInt[i4] = (1 + arrayOfInt[i4]);
          }
          while (true)
          {
            i3++;
            break label117;
            i = 0;
            break;
            if ((i4 & 0x1) != 0)
              break label405;
            if (i4 != 4)
              break label387;
            if (!a(arrayOfInt))
              break label347;
            if (!a(arrayOfInt, i1, i3))
              break label307;
            if (!this.c)
              break label257;
            bool2 = c();
            arrayOfInt[0] = 0;
            arrayOfInt[1] = 0;
            arrayOfInt[2] = 0;
            arrayOfInt[3] = 0;
            arrayOfInt[4] = 0;
            bool1 = bool2;
            i2 = 2;
            i4 = 0;
          }
          int i5 = b();
          if (i5 <= arrayOfInt[2])
            break label491;
          i7 = i1 + (i5 - arrayOfInt[2] - 2);
          i6 = k - 1;
        }
      }
      while (true)
      {
        i1 = i7;
        i3 = i6;
        bool2 = bool1;
        break label219;
        arrayOfInt[0] = arrayOfInt[2];
        arrayOfInt[1] = arrayOfInt[3];
        arrayOfInt[2] = arrayOfInt[4];
        arrayOfInt[3] = 1;
        arrayOfInt[4] = 0;
        i4 = 3;
        break label161;
        arrayOfInt[0] = arrayOfInt[2];
        arrayOfInt[1] = arrayOfInt[3];
        arrayOfInt[2] = arrayOfInt[4];
        arrayOfInt[3] = 1;
        arrayOfInt[4] = 0;
        i4 = 3;
        break label161;
        i4++;
        arrayOfInt[i4] = (1 + arrayOfInt[i4]);
        break label161;
        arrayOfInt[i4] = (1 + arrayOfInt[i4]);
        break label161;
        if ((a(arrayOfInt)) && (a(arrayOfInt, i1, k)))
        {
          i2 = arrayOfInt[0];
          if (this.c)
            bool1 = c();
        }
        i1 += i2;
        break;
        FinderPattern[] arrayOfFinderPattern = d();
        ResultPoint.a(arrayOfFinderPattern);
        return new FinderPatternInfo(arrayOfFinderPattern);
        i6 = i3;
        i7 = i1;
      }
    }
  }

  protected final boolean a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2] + paramArrayOfInt[3] + paramArrayOfInt[4];
    float f1 = a(paramArrayOfInt, paramInt2);
    float f2 = a(paramInt1, (int)f1, paramArrayOfInt[2], i);
    boolean bool1 = Float.isNaN(f2);
    int j = 0;
    float f3;
    float f4;
    if (!bool1)
    {
      f3 = b((int)f1, (int)f2, paramArrayOfInt[2], i);
      boolean bool2 = Float.isNaN(f3);
      j = 0;
      if (!bool2)
        f4 = i / 7.0F;
    }
    for (int k = 0; ; k++)
    {
      int m = this.b.size();
      int n = 0;
      if (k < m)
      {
        FinderPattern localFinderPattern2 = (FinderPattern)this.b.get(k);
        if (!localFinderPattern2.a(f4, f2, f3))
          continue;
        this.b.set(k, localFinderPattern2.b(f2, f3, f4));
        n = 1;
      }
      if (n == 0)
      {
        FinderPattern localFinderPattern1 = new FinderPattern(f3, f2, f4);
        this.b.add(localFinderPattern1);
        if (this.e != null)
          this.e.a(localFinderPattern1);
      }
      j = 1;
      return j;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPatternFinder
 * JD-Core Version:    0.6.0
 */
package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

public class Detector
{
  private final BitMatrix a;
  private ResultPointCallback b;

  public Detector(BitMatrix paramBitMatrix)
  {
    this.a = paramBitMatrix;
  }

  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    float f1 = b(paramInt1, paramInt2, paramInt3, paramInt4);
    int j = paramInt1 - (paramInt3 - paramInt1);
    float f2;
    int k;
    if (j < 0)
    {
      f2 = paramInt1 / (paramInt1 - j);
      k = 0;
    }
    while (true)
    {
      int m = (int)(paramInt2 - f2 * (paramInt4 - paramInt2));
      float f3;
      if (m < 0)
        f3 = paramInt2 / (paramInt2 - m);
      while (true)
      {
        return f1 + b(paramInt1, paramInt2, (int)(paramInt1 + f3 * (k - paramInt1)), i) - 1.0F;
        if (j < this.a.c())
          break label204;
        float f4 = (-1 + this.a.c() - paramInt1) / (j - paramInt1);
        int n = -1 + this.a.c();
        f2 = f4;
        k = n;
        break;
        if (m >= this.a.d())
        {
          f3 = (-1 + this.a.d() - paramInt2) / (m - paramInt2);
          i = -1 + this.a.d();
          continue;
        }
        i = m;
        f3 = 1.0F;
      }
      label204: k = j;
      f2 = 1.0F;
    }
  }

  private float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    float f1 = a((int)paramResultPoint1.a(), (int)paramResultPoint1.b(), (int)paramResultPoint2.a(), (int)paramResultPoint2.b());
    float f2 = a((int)paramResultPoint2.a(), (int)paramResultPoint2.b(), (int)paramResultPoint1.a(), (int)paramResultPoint1.b());
    float f3;
    if (Float.isNaN(f1))
      f3 = f2 / 7.0F;
    while (true)
    {
      return f3;
      if (Float.isNaN(f2))
      {
        f3 = f1 / 7.0F;
        continue;
      }
      f3 = (f1 + f2) / 14.0F;
    }
  }

  private static int a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, float paramFloat)
  {
    int i = 7 + (MathUtils.a(ResultPoint.a(paramResultPoint1, paramResultPoint2) / paramFloat) + MathUtils.a(ResultPoint.a(paramResultPoint1, paramResultPoint3) / paramFloat) >> 1);
    switch (i & 0x3)
    {
    case 1:
    default:
    case 0:
    case 2:
      while (true)
      {
        return i;
        i++;
        continue;
        i--;
      }
    case 3:
    }
    throw NotFoundException.a();
  }

  private static BitMatrix a(BitMatrix paramBitMatrix, PerspectiveTransform paramPerspectiveTransform, int paramInt)
  {
    return GridSampler.a().a(paramBitMatrix, paramInt, paramInt, paramPerspectiveTransform);
  }

  private static PerspectiveTransform a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt)
  {
    float f1 = paramInt - 3.5F;
    float f2;
    float f3;
    float f4;
    float f5;
    if (paramResultPoint4 != null)
    {
      f2 = paramResultPoint4.a();
      f3 = paramResultPoint4.b();
      f4 = f1 - 3.0F;
      f5 = f4;
    }
    while (true)
    {
      return PerspectiveTransform.a(3.5F, 3.5F, f1, 3.5F, f5, f4, 3.5F, f1, paramResultPoint1.a(), paramResultPoint1.b(), paramResultPoint2.a(), paramResultPoint2.b(), f2, f3, paramResultPoint3.a(), paramResultPoint3.b());
      f2 = paramResultPoint2.a() - paramResultPoint1.a() + paramResultPoint3.a();
      f3 = paramResultPoint2.b() - paramResultPoint1.b() + paramResultPoint3.b();
      f4 = f1;
      f5 = f1;
    }
  }

  private float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if (Math.abs(paramInt4 - paramInt2) > Math.abs(paramInt3 - paramInt1))
    {
      i = 1;
      if (i == 0)
        break label311;
    }
    while (true)
    {
      int m = Math.abs(paramInt4 - paramInt2);
      int n = Math.abs(paramInt3 - paramInt1);
      int i1 = -m >> 1;
      int i2;
      label57: int i3;
      label65: int i4;
      int i6;
      int i7;
      int i8;
      int i10;
      label101: int i11;
      if (paramInt2 < paramInt4)
      {
        i2 = 1;
        if (paramInt1 >= paramInt3)
          break label167;
        i3 = 1;
        i4 = 0;
        int i5 = paramInt4 + i2;
        i6 = paramInt2;
        i7 = i1;
        i8 = paramInt1;
        if (i6 == i5)
          break label304;
        if (i == 0)
          break label173;
        i10 = i8;
        if (i == 0)
          break label180;
        i11 = i6;
        label110: if (i4 != 1)
          break label187;
      }
      float f;
      label152: label167: label173: label180: label187: for (int i12 = 1; ; i12 = 0)
      {
        if (i12 != this.a.a(i10, i11))
          break label297;
        if (i4 != 2)
          break label193;
        f = MathUtils.a(i6, i8, paramInt2, paramInt1);
        return f;
        i = 0;
        break;
        i2 = -1;
        break label57;
        i3 = -1;
        break label65;
        i10 = i6;
        break label101;
        i11 = i8;
        break label110;
      }
      label193: int i13 = i4 + 1;
      label199: int i14 = i7 + n;
      if (i14 > 0)
        if (i8 != paramInt3);
      label297: label304: for (int i9 = i13; ; i9 = i4)
      {
        int i15;
        if (i9 == 2)
        {
          f = MathUtils.a(paramInt4 + i2, paramInt3, paramInt2, paramInt1);
          break label152;
          i15 = i8 + i3;
        }
        for (int i16 = i14 - m; ; i16 = i14)
        {
          i6 += i2;
          i4 = i13;
          i7 = i16;
          i8 = i15;
          break;
          f = (0.0F / 0.0F);
          break label152;
          i15 = i8;
        }
        i13 = i4;
        break label199;
      }
      label311: int j = paramInt4;
      paramInt4 = paramInt3;
      paramInt3 = j;
      int k = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = k;
    }
  }

  protected final float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3)
  {
    return (a(paramResultPoint1, paramResultPoint2) + a(paramResultPoint1, paramResultPoint3)) / 2.0F;
  }

  protected final DetectorResult a(FinderPatternInfo paramFinderPatternInfo)
  {
    FinderPattern localFinderPattern1 = paramFinderPatternInfo.b();
    FinderPattern localFinderPattern2 = paramFinderPatternInfo.c();
    FinderPattern localFinderPattern3 = paramFinderPatternInfo.a();
    float f1 = a(localFinderPattern1, localFinderPattern2, localFinderPattern3);
    if (f1 < 1.0F)
      throw NotFoundException.a();
    int i = a(localFinderPattern1, localFinderPattern2, localFinderPattern3, f1);
    Version localVersion = Version.a(i);
    int j = -7 + localVersion.d();
    int k = localVersion.b().length;
    Object localObject = null;
    int m;
    int n;
    int i1;
    float f5;
    if (k > 0)
    {
      float f2 = localFinderPattern2.a() - localFinderPattern1.a() + localFinderPattern3.a();
      float f3 = localFinderPattern2.b() - localFinderPattern1.b() + localFinderPattern3.b();
      float f4 = 1.0F - 3.0F / j;
      m = (int)(localFinderPattern1.a() + f4 * (f2 - localFinderPattern1.a()));
      n = (int)(localFinderPattern1.b() + f4 * (f3 - localFinderPattern1.b()));
      i1 = 4;
      localObject = null;
      if (i1 <= 16)
        f5 = i1;
    }
    while (true)
    {
      try
      {
        AlignmentPattern localAlignmentPattern = a(f1, m, n, f5);
        localObject = localAlignmentPattern;
        PerspectiveTransform localPerspectiveTransform = a(localFinderPattern1, localFinderPattern2, localFinderPattern3, localObject, i);
        BitMatrix localBitMatrix = a(this.a, localPerspectiveTransform, i);
        if (localObject != null)
          break label270;
        arrayOfResultPoint = new ResultPoint[] { localFinderPattern3, localFinderPattern1, localFinderPattern2 };
        return new DetectorResult(localBitMatrix, arrayOfResultPoint);
      }
      catch (NotFoundException localNotFoundException)
      {
        i1 <<= 1;
      }
      break;
      label270: ResultPoint[] arrayOfResultPoint = { localFinderPattern3, localFinderPattern1, localFinderPattern2, localObject };
    }
  }

  public final DetectorResult a(Map<DecodeHintType, ?> paramMap)
  {
    if (paramMap == null);
    for (ResultPointCallback localResultPointCallback = null; ; localResultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK))
    {
      this.b = localResultPointCallback;
      return a(new FinderPatternFinder(this.a, this.b).a(paramMap));
    }
  }

  protected final AlignmentPattern a(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2)
  {
    int i = (int)(paramFloat2 * paramFloat1);
    int j = Math.max(0, paramInt1 - i);
    int k = Math.min(-1 + this.a.c(), paramInt1 + i);
    if (k - j < paramFloat1 * 3.0F)
      throw NotFoundException.a();
    int m = Math.max(0, paramInt2 - i);
    int n = Math.min(-1 + this.a.d(), i + paramInt2);
    if (n - m < paramFloat1 * 3.0F)
      throw NotFoundException.a();
    return new AlignmentPatternFinder(this.a, j, m, k - j, n - m, paramFloat1, this.b).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.Detector
 * JD-Core Version:    0.6.0
 */
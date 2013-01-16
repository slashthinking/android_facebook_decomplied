package com.google.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

final class FinderPatternFinder$CenterComparator
  implements Serializable, Comparator<FinderPattern>
{
  private final float average;

  private FinderPatternFinder$CenterComparator(float paramFloat)
  {
    this.average = paramFloat;
  }

  public int a(FinderPattern paramFinderPattern1, FinderPattern paramFinderPattern2)
  {
    float f1;
    float f2;
    int i;
    if (paramFinderPattern2.d() == paramFinderPattern1.d())
    {
      f1 = Math.abs(paramFinderPattern2.c() - this.average);
      f2 = Math.abs(paramFinderPattern1.c() - this.average);
      if (f1 < f2)
        i = 1;
    }
    while (true)
    {
      return i;
      if (f1 == f2)
      {
        i = 0;
        continue;
      }
      i = -1;
      continue;
      i = paramFinderPattern2.d() - paramFinderPattern1.d();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPatternFinder.CenterComparator
 * JD-Core Version:    0.6.0
 */
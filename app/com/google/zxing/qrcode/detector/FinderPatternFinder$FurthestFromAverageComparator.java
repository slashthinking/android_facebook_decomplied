package com.google.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

final class FinderPatternFinder$FurthestFromAverageComparator
  implements Serializable, Comparator<FinderPattern>
{
  private final float average;

  private FinderPatternFinder$FurthestFromAverageComparator(float paramFloat)
  {
    this.average = paramFloat;
  }

  public int a(FinderPattern paramFinderPattern1, FinderPattern paramFinderPattern2)
  {
    float f1 = Math.abs(paramFinderPattern2.c() - this.average);
    float f2 = Math.abs(paramFinderPattern1.c() - this.average);
    int i;
    if (f1 < f2)
      i = -1;
    while (true)
    {
      return i;
      if (f1 == f2)
      {
        i = 0;
        continue;
      }
      i = 1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPatternFinder.FurthestFromAverageComparator
 * JD-Core Version:    0.6.0
 */
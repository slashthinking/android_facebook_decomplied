package com.facebook.orca.emoji;

import android.content.res.Resources;
import com.facebook.orca.common.util.SizeUtil;

public class EmojiSizingCalculator
{
  private final Resources a;

  public EmojiSizingCalculator(Resources paramResources)
  {
    this.a = paramResources;
  }

  public EmojiSizingCalculator.Sizes a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = SizeUtil.a(this.a, 8.0F);
    int j = SizeUtil.a(this.a, 9.0F);
    int k = SizeUtil.a(this.a, 8.0F);
    int m = SizeUtil.a(this.a, 9.0F);
    int n = SizeUtil.a(this.a, 45.0F);
    int i1 = SizeUtil.a(this.a, 20.0F);
    int i2 = paramInt2 - i1;
    int i3 = paramInt1 / n;
    if (i3 > 7)
      i3 = Math.max(7, i3 - 2);
    int i4 = i2 / n;
    if ((!paramBoolean) && (i4 > 4))
      i4 = 4;
    int i5 = paramInt1 / i3;
    if (i5 > n)
    {
      int i10 = i5 - n;
      i += i10 / 2 + i10 % 2;
      j += i10 / 2;
    }
    while (true)
    {
      int i6 = i2 / i4;
      int i8;
      int i7;
      if (i6 > n)
      {
        int i9 = i6 - n;
        i8 = k + (i9 / 2 + i9 % 2);
        i7 = m + i9 / 2;
      }
      while (true)
      {
        return new EmojiSizingCalculator.Sizes(i3, i4, i, j, i8, i7, k, m, i5, i6, n, i1 + i4 * i5);
        i7 = m;
        i8 = k;
        i6 = n;
      }
      i5 = n;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiSizingCalculator
 * JD-Core Version:    0.6.0
 */
package com.karmascience.gifts.views;

class iTunesSkuSelectionView$SkuPricePair
  implements Comparable<SkuPricePair>
{
  final int a;
  final String b;

  private iTunesSkuSelectionView$SkuPricePair(iTunesSkuSelectionView paramiTunesSkuSelectionView, int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }

  public int a(SkuPricePair paramSkuPricePair)
  {
    int i;
    if (this.a < paramSkuPricePair.a)
      i = -1;
    while (true)
    {
      return i;
      if (this.a > paramSkuPricePair.a)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.iTunesSkuSelectionView.SkuPricePair
 * JD-Core Version:    0.6.0
 */
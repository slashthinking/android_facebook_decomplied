package com.facebook.katana.ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SectionedListAdapter$SectionCache
{
  static Comparator<SectionCache> d = new SectionedListAdapter.SectionCache.1();
  final int a;
  int b;
  int c;

  SectionedListAdapter$SectionCache(int paramInt)
  {
    this.a = paramInt;
  }

  static int a(List<SectionCache> paramList, int paramInt)
  {
    SectionCache localSectionCache = new SectionCache(0);
    localSectionCache.b = paramInt;
    return Collections.binarySearch(paramList, localSectionCache, d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.SectionedListAdapter.SectionCache
 * JD-Core Version:    0.6.0
 */
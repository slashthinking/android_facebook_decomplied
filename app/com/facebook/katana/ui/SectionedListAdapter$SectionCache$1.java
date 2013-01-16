package com.facebook.katana.ui;

import java.util.Comparator;

final class SectionedListAdapter$SectionCache$1
  implements Comparator<SectionedListAdapter.SectionCache>
{
  public int a(SectionedListAdapter.SectionCache paramSectionCache1, SectionedListAdapter.SectionCache paramSectionCache2)
  {
    int i;
    if (paramSectionCache1.b + paramSectionCache1.c < paramSectionCache2.b)
      i = -1;
    while (true)
    {
      return i;
      if (paramSectionCache1.b > paramSectionCache2.b + paramSectionCache2.c)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.SectionedListAdapter.SectionCache.1
 * JD-Core Version:    0.6.0
 */
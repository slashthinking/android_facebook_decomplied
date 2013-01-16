package com.facebook.orca.prefs;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

class PrefKeyUtil
{
  static SortedMap<PrefKey, Object> a(SortedMap<PrefKey, Object> paramSortedMap, PrefKey paramPrefKey)
  {
    SortedMap localSortedMap1 = paramSortedMap.tailMap(paramPrefKey);
    Iterator localIterator = localSortedMap1.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext())
        break;
      localEntry = (Map.Entry)localIterator.next();
    }
    while (((PrefKey)localEntry.getKey()).a(paramPrefKey));
    for (SortedMap localSortedMap2 = localSortedMap1.headMap(localEntry.getKey()); ; localSortedMap2 = localSortedMap1)
      return localSortedMap2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.PrefKeyUtil
 * JD-Core Version:    0.6.0
 */
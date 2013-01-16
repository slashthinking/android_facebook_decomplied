package com.facebook.orca.media;

import com.facebook.orca.common.util.Clock;
import java.util.Comparator;

class MediaCache$ExpirationComparator
  implements Comparator<MediaCache<KEY, VALUE>.InMemoryCachedValue<KEY, VALUE>>
{
  private long b;

  public MediaCache$ExpirationComparator(MediaCache paramMediaCache)
  {
    this.b = (MediaCache.a(paramMediaCache).a() / 120000L);
  }

  public int a(MediaCache<KEY, VALUE>.InMemoryCachedValue<KEY, VALUE> paramMediaCache1, MediaCache<KEY, VALUE>.InMemoryCachedValue<KEY, VALUE> paramMediaCache2)
  {
    int i = -1;
    long l1 = MediaCache.InMemoryCachedValue.e(paramMediaCache1) / 120000L;
    long l2 = MediaCache.InMemoryCachedValue.e(paramMediaCache2) / 120000L;
    long l3 = MediaCache.InMemoryCachedValue.e(paramMediaCache1);
    long l4 = MediaCache.InMemoryCachedValue.e(paramMediaCache2);
    if (l1 < l2);
    while (true)
    {
      return i;
      if (l1 > l2)
        i = 1;
      else if (l1 == this.b)
      {
        if (l3 >= l4)
          if (l3 > l4)
            i = 1;
          else
            i = 0;
      }
      else
        i = MediaCache.InMemoryCachedValue.b(paramMediaCache2) - MediaCache.InMemoryCachedValue.b(paramMediaCache1);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaCache.ExpirationComparator
 * JD-Core Version:    0.6.2
 */
package com.facebook.orca.media;

import com.facebook.orca.common.util.Clock;

class MediaCache$InMemoryCachedValue<KEY extends MediaCacheKey, VALUE>
{
  private final KEY b;
  private final VALUE c;
  private final int d;
  private volatile long e;
  private long f;

  MediaCache$InMemoryCachedValue(KEY paramKEY, VALUE paramVALUE, int paramInt)
  {
    this.b = paramVALUE;
    this.c = paramInt;
    int i;
    this.d = i;
    this.e = MediaCache.a(paramKEY).a();
  }

  void a()
  {
    this.e = MediaCache.a(this.a).a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaCache.InMemoryCachedValue
 * JD-Core Version:    0.6.2
 */
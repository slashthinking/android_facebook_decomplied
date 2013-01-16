package com.facebook.orca.photos.tiles;

import android.graphics.Bitmap;
import com.google.common.collect.MapMaker;
import java.util.concurrent.ConcurrentMap;

public class DefaultTilesCache
{
  private final ConcurrentMap<DefaultTilesCache.Key, Bitmap> a = new MapMaker().a(128).c(4).i().n();

  public Bitmap a(DefaultTilesCache.Key paramKey)
  {
    return (Bitmap)this.a.get(paramKey);
  }

  public void a(DefaultTilesCache.Key paramKey, Bitmap paramBitmap)
  {
    this.a.put(paramKey, paramBitmap);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.tiles.DefaultTilesCache
 * JD-Core Version:    0.6.0
 */
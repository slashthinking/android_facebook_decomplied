package com.facebook.katana.util;

import android.graphics.Bitmap;
import android.os.Debug;
import android.support.v4.util.LruCache;

public class BitmapCache extends LruCache<Long, Bitmap>
{
  private static final int a = (int)(0.125D * Debug.getNativeHeapSize());

  public BitmapCache()
  {
    super(a);
  }

  public BitmapCache(int paramInt)
  {
    super(paramInt);
  }

  protected int a(Long paramLong, Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.BitmapCache
 * JD-Core Version:    0.6.0
 */
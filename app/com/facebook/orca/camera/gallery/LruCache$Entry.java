package com.facebook.orca.camera.gallery;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class LruCache$Entry<K, V> extends WeakReference<V>
{
  K a;

  public LruCache$Entry(K paramK, V paramV, ReferenceQueue<V> paramReferenceQueue)
  {
    super(paramV, paramReferenceQueue);
    this.a = paramK;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.gallery.LruCache.Entry
 * JD-Core Version:    0.6.0
 */
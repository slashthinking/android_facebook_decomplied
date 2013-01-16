package com.facebook.feed.photos;

import android.net.Uri;
import android.support.v4.util.LruCache;

public class AlbumIndexCache
{
  private LruCache<String, Uri> a = new LruCache(10);

  public Uri a(String paramString)
  {
    return (Uri)this.a.a(paramString);
  }

  public void a(String paramString, Uri paramUri)
  {
    this.a.a(paramString, paramUri);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.photos.AlbumIndexCache
 * JD-Core Version:    0.6.0
 */
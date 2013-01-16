package com.facebook.feed.photos;

import android.net.Uri;
import com.facebook.feed.ui.NewsFeedImageAdapter;
import com.facebook.orca.images.ImageCacheKey;
import com.facebook.widget.UrlImage;

public class FeedPhotoState
{
  private Long a;
  private Uri b;
  private String c;
  private UrlImage d;
  private UrlImage e;
  private NewsFeedImageAdapter f;
  private ImageCacheKey g;
  private Long h;

  public NewsFeedImageAdapter a()
  {
    return this.f;
  }

  public void a(Uri paramUri)
  {
    this.b = paramUri;
  }

  public void a(NewsFeedImageAdapter paramNewsFeedImageAdapter)
  {
    this.f = paramNewsFeedImageAdapter;
  }

  public void a(ImageCacheKey paramImageCacheKey)
  {
    this.g = paramImageCacheKey;
  }

  public void a(UrlImage paramUrlImage)
  {
    this.e = paramUrlImage;
  }

  public void a(Long paramLong)
  {
    this.a = paramLong;
  }

  public void a(String paramString)
  {
    this.c = paramString;
  }

  public ImageCacheKey b()
  {
    return this.g;
  }

  public void b(UrlImage paramUrlImage)
  {
    this.d = paramUrlImage;
  }

  public void b(Long paramLong)
  {
    this.h = paramLong;
  }

  public UrlImage c()
  {
    return this.e;
  }

  public UrlImage d()
  {
    return this.d;
  }

  public Uri e()
  {
    return this.b;
  }

  public Long f()
  {
    return this.a;
  }

  public Long g()
  {
    return this.h;
  }

  public String h()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.photos.FeedPhotoState
 * JD-Core Version:    0.6.0
 */
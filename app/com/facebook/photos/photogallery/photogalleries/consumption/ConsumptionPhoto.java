package com.facebook.photos.photogallery.photogalleries.consumption;

import android.net.Uri;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.images.ImageCacheKey.Options;
import com.facebook.orca.images.ImageCacheKey.OptionsBuilder;
import com.facebook.photos.photogallery.Photo.PhotoSize;
import com.facebook.photos.photogallery.tags.Tag;
import com.facebook.photos.photogallery.tags.TaggedPhoto;
import java.util.List;

public class ConsumptionPhoto extends TaggedPhoto
{
  private String a;
  private int b;
  private int c;
  private int d;
  private int e;
  private String f;
  private int g;
  private int h;
  private boolean i;
  private boolean j;
  private boolean k;

  public ConsumptionPhoto(long paramLong, List<Tag> paramList, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5, int paramInt6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramLong, paramList);
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramString2;
    this.g = paramInt5;
    this.h = paramInt6;
    this.i = paramBoolean1;
    this.j = paramBoolean2;
    this.k = paramBoolean3;
  }

  public FetchImageParams a(Photo.PhotoSize paramPhotoSize)
  {
    ImageCacheKey.OptionsBuilder localOptionsBuilder = ImageCacheKey.Options.newBuilder();
    if ((this.d == 0) || (this.e == 0))
      paramPhotoSize = Photo.PhotoSize.SCREENNAIL;
    switch (ConsumptionPhoto.1.a[paramPhotoSize.ordinal()])
    {
    default:
      throw new IllegalArgumentException("unknown size: " + paramPhotoSize);
    case 1:
      localOptionsBuilder.a(true);
    case 2:
    }
    while (true)
    {
      ImageCacheKey.Options localOptions = localOptionsBuilder.d();
      return new FetchImageParams(Uri.parse(this.a), null, localOptions);
      localOptionsBuilder.a(this.d, this.e);
    }
  }

  public void a(int paramInt)
  {
    this.d = paramInt;
  }

  public String b()
  {
    return this.f;
  }

  public void b(int paramInt)
  {
    this.e = paramInt;
  }

  public int c()
  {
    return this.g;
  }

  public void c(int paramInt)
  {
    this.g = paramInt;
  }

  public int d()
  {
    return this.h;
  }

  public void d(int paramInt)
  {
    this.h = paramInt;
  }

  public boolean e()
  {
    return this.k;
  }

  public boolean f()
  {
    if (!this.f.isEmpty());
    for (int m = 1; ; m = 0)
      return m;
  }

  public boolean g()
  {
    if (i().size() > 0);
    for (int m = 1; ; m = 0)
      return m;
  }

  public boolean h()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhoto
 * JD-Core Version:    0.6.0
 */
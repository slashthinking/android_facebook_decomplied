package com.facebook.orca.images;

import android.net.Uri;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class FetchImageParams
{
  private final Uri a;
  private final UrlImageProcessor b;
  private final String c;
  private final ImageCacheKey.Options d;
  private volatile ImageCacheKey e;
  private volatile ImageCacheKey f;
  private volatile FetchImageParams g;

  public FetchImageParams(Uri paramUri)
  {
    this(paramUri, null);
  }

  public FetchImageParams(Uri paramUri, UrlImageProcessor paramUrlImageProcessor)
  {
    this(paramUri, paramUrlImageProcessor, ImageCacheKey.a);
  }

  public FetchImageParams(Uri paramUri, UrlImageProcessor paramUrlImageProcessor, ImageCacheKey.Options paramOptions)
  {
    Preconditions.checkNotNull(paramUri);
    Preconditions.checkNotNull(paramOptions);
    Preconditions.checkArgument(paramUri.isAbsolute());
    this.a = paramUri;
    this.b = paramUrlImageProcessor;
    if (paramUrlImageProcessor != null);
    for (String str = paramUrlImageProcessor.a(); ; str = null)
    {
      this.c = str;
      this.d = paramOptions;
      return;
    }
  }

  public static boolean a(FetchImageParams paramFetchImageParams1, FetchImageParams paramFetchImageParams2)
  {
    boolean bool;
    if ((paramFetchImageParams1 == null) && (paramFetchImageParams2 == null))
      bool = true;
    while (true)
    {
      return bool;
      if ((paramFetchImageParams1 == null) || (paramFetchImageParams2 == null))
        bool = false;
      else
        bool = paramFetchImageParams1.a(paramFetchImageParams2);
    }
  }

  public Uri a()
  {
    return this.a;
  }

  public boolean a(FetchImageParams paramFetchImageParams)
  {
    if ((Objects.equal(this.a, paramFetchImageParams.a)) && (Objects.equal(this.c, paramFetchImageParams.c)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public UrlImageProcessor b()
  {
    return this.b;
  }

  public ImageCacheKey.Options c()
  {
    return this.d;
  }

  public ImageCacheKey d()
  {
    if (this.e != null);
    for (ImageCacheKey localImageCacheKey = this.e; ; localImageCacheKey = null)
    {
      return localImageCacheKey;
      if (this.b == null)
        break label67;
      if (this.c != UrlImageProcessor.a)
        break;
    }
    label67: for (this.e = new ImageCacheKey(this.a, this.d, this.c); ; this.e = e())
    {
      localImageCacheKey = this.e;
      break;
    }
  }

  public ImageCacheKey e()
  {
    if (this.f == null)
      this.f = new ImageCacheKey(this.a, this.d);
    return this.f;
  }

  public FetchImageParams f()
  {
    if (this.d == ImageCacheKey.b);
    while (true)
    {
      return this;
      if (this.g == null)
        this.g = new FetchImageParams(this.a, null, ImageCacheKey.b);
      this = this.g;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.FetchImageParams
 * JD-Core Version:    0.6.2
 */
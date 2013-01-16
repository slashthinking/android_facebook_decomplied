package com.facebook.orca.media;

import android.net.Uri;

public class MediaResource$Builder
{
  private MediaResource.Type a;
  private Uri b;
  private String c;
  private String d;
  private long e;

  public Builder a(long paramLong)
  {
    this.e = paramLong;
    return this;
  }

  public Builder a(Uri paramUri)
  {
    this.b = paramUri;
    return this;
  }

  public Builder a(MediaResource.Type paramType)
  {
    this.a = paramType;
    return this;
  }

  public Builder a(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public MediaResource.Type a()
  {
    return this.a;
  }

  public Uri b()
  {
    return this.b;
  }

  public Builder b(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public long e()
  {
    return this.e;
  }

  public MediaResource f()
  {
    return new MediaResource(this, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaResource.Builder
 * JD-Core Version:    0.6.2
 */
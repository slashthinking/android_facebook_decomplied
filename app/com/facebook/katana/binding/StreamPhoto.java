package com.facebook.katana.binding;

import android.graphics.Bitmap;
import android.net.Uri;
import java.lang.ref.SoftReference;

public class StreamPhoto
{
  private final Uri a;
  private final String b;
  private final String c;
  private final long d;
  private int e;
  private SoftReference<Bitmap> f;

  public StreamPhoto(Uri paramUri, String paramString1, String paramString2, long paramLong, Bitmap paramBitmap)
  {
    this.a = paramUri;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramLong;
    this.e = 0;
    this.f = new SoftReference(paramBitmap);
  }

  public Uri a()
  {
    return this.a;
  }

  public void a(Bitmap paramBitmap)
  {
    this.f = new SoftReference(paramBitmap);
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public long d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }

  public void f()
  {
    this.e = (1 + this.e);
  }

  public Bitmap g()
  {
    return (Bitmap)this.f.get();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.StreamPhoto
 * JD-Core Version:    0.6.0
 */
package com.facebook.katana.binding;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;

public class ProfileImage
{
  public final long a;
  public final String b;
  private int c;
  private SoftReference<Bitmap> d;

  public ProfileImage(long paramLong, String paramString, Bitmap paramBitmap)
  {
    this.a = paramLong;
    this.b = paramString;
    this.c = 0;
    this.d = new SoftReference(paramBitmap);
  }

  public int a()
  {
    return this.c;
  }

  public void a(Bitmap paramBitmap)
  {
    this.d = new SoftReference(paramBitmap);
  }

  public void b()
  {
    this.c = (1 + this.c);
  }

  public Bitmap c()
  {
    return (Bitmap)this.d.get();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.ProfileImage
 * JD-Core Version:    0.6.0
 */
package com.facebook.orca.camera.gallery;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.orca.camera.Util;

public abstract class BaseImage
  implements IImage
{
  private static final Class<?> i = BaseImage.class;
  protected ContentResolver a;
  protected Uri b;
  protected long c;
  protected String d;
  protected long e;
  protected final int f;
  protected String g;
  protected BaseImageList h;
  private final long j;
  private String k;
  private final String l;
  private int m = -1;
  private int n = -1;

  protected BaseImage(BaseImageList paramBaseImageList, ContentResolver paramContentResolver, long paramLong1, int paramInt, Uri paramUri, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, String paramString4)
  {
    this.h = paramBaseImageList;
    this.a = paramContentResolver;
    this.c = paramLong1;
    this.f = paramInt;
    this.b = paramUri;
    this.d = paramString1;
    this.e = paramLong2;
    this.g = paramString2;
    this.j = paramLong3;
    this.k = paramString3;
    this.l = paramString4;
  }

  public Bitmap a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, true, false);
  }

  public Bitmap a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Uri localUri = this.h.a(this.c);
    if (localUri == null);
    for (Bitmap localBitmap = null; ; localBitmap = Util.a(localBitmap, c()))
      do
      {
        return localBitmap;
        localBitmap = Util.a(paramInt1, paramInt2, localUri, this.a, paramBoolean2);
      }
      while ((localBitmap == null) || (!paramBoolean1));
  }

  public String a()
  {
    return this.d;
  }

  public long b()
  {
    return this.j;
  }

  public int c()
  {
    return 0;
  }

  public String d()
  {
    return this.k;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Image)));
    for (boolean bool = false; ; bool = this.b.equals(((Image)paramObject).b))
      return bool;
  }

  public int hashCode()
  {
    return this.b.hashCode();
  }

  public String toString()
  {
    return this.b.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.gallery.BaseImage
 * JD-Core Version:    0.6.0
 */
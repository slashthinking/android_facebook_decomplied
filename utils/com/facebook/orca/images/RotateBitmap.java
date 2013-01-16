package com.facebook.orca.images;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class RotateBitmap
{
  public static final Class<?> a = RotateBitmap.class;
  private Bitmap b;
  private int c;

  public RotateBitmap(Bitmap paramBitmap)
  {
    this.b = paramBitmap;
    this.c = 0;
  }

  public RotateBitmap(Bitmap paramBitmap, int paramInt)
  {
    this.b = paramBitmap;
    this.c = (paramInt % 360);
  }

  public int a()
  {
    return this.c;
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(Bitmap paramBitmap)
  {
    this.b = paramBitmap;
  }

  public Bitmap b()
  {
    return this.b;
  }

  public Matrix c()
  {
    Matrix localMatrix = new Matrix();
    if (this.c != 0)
    {
      int i = this.b.getWidth() / 2;
      int j = this.b.getHeight() / 2;
      localMatrix.preTranslate(-i, -j);
      localMatrix.postRotate(this.c);
      localMatrix.postTranslate(f() / 2, e() / 2);
    }
    return localMatrix;
  }

  public boolean d()
  {
    if (this.c / 90 % 2 != 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int e()
  {
    if (d());
    for (int i = this.b.getWidth(); ; i = this.b.getHeight())
      return i;
  }

  public int f()
  {
    if (d());
    for (int i = this.b.getHeight(); ; i = this.b.getWidth())
      return i;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.RotateBitmap
 * JD-Core Version:    0.6.2
 */
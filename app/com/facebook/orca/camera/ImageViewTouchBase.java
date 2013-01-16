package com.facebook.orca.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.orca.images.RotateBitmap;

abstract class ImageViewTouchBase extends ImageView
{
  private static final Class<?> a = ImageViewTouchBase.class;
  private final Matrix b = new Matrix();
  private final float[] c = new float[9];
  private ImageViewTouchBase.Recycler d;
  private Runnable e = null;
  protected Matrix f = new Matrix();
  protected Matrix g = new Matrix();
  protected final RotateBitmap h = new RotateBitmap(null);
  int i = -1;
  int j = -1;
  float k;
  protected Handler l = new Handler();

  public ImageViewTouchBase(Context paramContext)
  {
    super(paramContext);
    e();
  }

  public ImageViewTouchBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }

  private void a(Bitmap paramBitmap, int paramInt)
  {
    super.setImageBitmap(paramBitmap);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
      localDrawable.setDither(true);
    Bitmap localBitmap = this.h.b();
    this.h.a(paramBitmap);
    this.h.a(paramInt);
    if ((localBitmap != null) && (localBitmap != paramBitmap) && (this.d != null))
      this.d.a(localBitmap);
  }

  private void a(RotateBitmap paramRotateBitmap, Matrix paramMatrix)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    float f3 = paramRotateBitmap.f();
    float f4 = paramRotateBitmap.e();
    paramMatrix.reset();
    float f5 = Math.min(Math.min(f1 / f3, 3.0F), Math.min(f2 / f4, 3.0F));
    paramMatrix.postConcat(paramRotateBitmap.c());
    paramMatrix.postScale(f5, f5);
    paramMatrix.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
  }

  private void e()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
  }

  protected float a(Matrix paramMatrix)
  {
    return a(paramMatrix, 0);
  }

  protected float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.c);
    return this.c[paramInt];
  }

  public void a()
  {
    a(null, true);
  }

  protected void a(float paramFloat)
  {
    a(paramFloat, getWidth() / 2.0F, getHeight() / 2.0F);
  }

  protected void a(float paramFloat1, float paramFloat2)
  {
    this.g.postTranslate(paramFloat1, paramFloat2);
  }

  protected void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > this.k)
      paramFloat1 = this.k;
    float f1 = paramFloat1 / b();
    this.g.postScale(f1, f1, paramFloat2, paramFloat3);
    setImageMatrix(c());
    a(true, true);
  }

  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = (paramFloat1 - b()) / paramFloat4;
    float f2 = b();
    long l1 = System.currentTimeMillis();
    this.l.post(new ImageViewTouchBase.2(this, paramFloat4, l1, f2, f1, paramFloat2, paramFloat3));
  }

  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    a(new RotateBitmap(paramBitmap), paramBoolean);
  }

  public void a(RotateBitmap paramRotateBitmap, boolean paramBoolean)
  {
    if (getWidth() <= 0)
    {
      this.e = new ImageViewTouchBase.1(this, paramRotateBitmap, paramBoolean);
      return;
    }
    if (paramRotateBitmap.b() != null)
    {
      a(paramRotateBitmap, this.f);
      a(paramRotateBitmap.b(), paramRotateBitmap.a());
    }
    while (true)
    {
      if (paramBoolean)
        this.g.reset();
      setImageMatrix(c());
      this.k = d();
      break;
      this.f.reset();
      setImageBitmap(null);
    }
  }

  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.h.b() == null)
      return;
    Matrix localMatrix = c();
    RectF localRectF = new RectF(0.0F, 0.0F, this.h.b().getWidth(), this.h.b().getHeight());
    localMatrix.mapRect(localRectF);
    float f1 = localRectF.height();
    float f2 = localRectF.width();
    int n;
    float f3;
    if (paramBoolean2)
    {
      n = getHeight();
      if (f1 < n)
        f3 = (n - f1) / 2.0F - localRectF.top;
    }
    while (true)
    {
      label105: float f4 = 0.0F;
      int m;
      if (paramBoolean1)
      {
        m = getWidth();
        if (f2 >= m)
          break label211;
        f4 = (m - f2) / 2.0F - localRectF.left;
      }
      while (true)
      {
        a(f4, f3);
        setImageMatrix(c());
        break;
        if (localRectF.top > 0.0F)
        {
          f3 = -localRectF.top;
          break label105;
        }
        if (localRectF.bottom >= n)
          break label265;
        f3 = getHeight() - localRectF.bottom;
        break label105;
        label211: if (localRectF.left > 0.0F)
        {
          f4 = -localRectF.left;
          continue;
        }
        boolean bool = localRectF.right < m;
        f4 = 0.0F;
        if (!bool)
          continue;
        f4 = m - localRectF.right;
      }
      label265: f3 = 0.0F;
    }
  }

  protected float b()
  {
    return a(this.g);
  }

  protected void b(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, paramFloat2);
    setImageMatrix(c());
  }

  protected Matrix c()
  {
    this.b.set(this.f);
    this.b.postConcat(this.g);
    return this.b;
  }

  protected float d()
  {
    float f1;
    if (this.h.b() == null)
      f1 = 1.0F;
    while (true)
    {
      return f1;
      f1 = 4.0F * Math.max(this.h.f() / this.i, this.h.e() / this.j);
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
      paramKeyEvent.startTracking();
    for (boolean bool = true; ; bool = super.onKeyDown(paramInt, paramKeyEvent))
      return bool;
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()) && (b() > 1.0F))
      a(1.0F);
    for (boolean bool = true; ; bool = super.onKeyUp(paramInt, paramKeyEvent))
      return bool;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = (paramInt3 - paramInt1);
    this.j = (paramInt4 - paramInt2);
    Runnable localRunnable = this.e;
    if (localRunnable != null)
    {
      this.e = null;
      localRunnable.run();
    }
    if (this.h.b() != null)
    {
      a(this.h, this.f);
      setImageMatrix(c());
    }
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    a(paramBitmap, 0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.ImageViewTouchBase
 * JD-Core Version:    0.6.0
 */
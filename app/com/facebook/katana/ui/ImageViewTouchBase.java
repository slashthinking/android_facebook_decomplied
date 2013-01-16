package com.facebook.katana.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.katana.RotateBitmap;
import com.facebook.katana.activity.media.PhotoGalleryActivity;

public class ImageViewTouchBase extends ImageView
{
  private static float n = 1.0F;
  protected Matrix a = new Matrix();
  protected Matrix b = new Matrix();
  protected final RotateBitmap c = new RotateBitmap(null);
  int d = -1;
  int e = -1;
  boolean f = true;
  protected float g = 4.0F;
  protected Handler h = new Handler();
  private final Matrix i = new Matrix();
  private final float[] j = new float[9];
  private RectF k = null;
  private ImageViewTouchBase.Recycler l;
  private Runnable m = null;

  public ImageViewTouchBase(Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.MATRIX);
  }

  public ImageViewTouchBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setScaleType(ImageView.ScaleType.MATRIX);
  }

  public ImageViewTouchBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setScaleType(ImageView.ScaleType.MATRIX);
  }

  private void a(Bitmap paramBitmap, int paramInt)
  {
    super.setImageBitmap(paramBitmap);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
      localDrawable.setDither(true);
    Bitmap localBitmap = this.c.b();
    this.c.a(paramBitmap);
    this.c.a(paramInt);
    if ((localBitmap != null) && (localBitmap != paramBitmap) && (this.l != null))
      this.l.a(localBitmap);
  }

  private void a(RotateBitmap paramRotateBitmap, Matrix paramMatrix)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    float f3 = paramRotateBitmap.f();
    float f4 = paramRotateBitmap.e();
    paramMatrix.reset();
    paramMatrix.postConcat(paramRotateBitmap.c());
    float f5 = 1.0F;
    if (this.f)
    {
      f5 = Math.min(Math.min(f1 / f3, 10.0F), Math.min(f2 / f4, 10.0F));
      paramMatrix.postScale(f5, f5);
      paramMatrix.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
    }
    while (true)
    {
      this.k = new RectF((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F, (f1 - f3 * f5) / 2.0F + f3 * f5, (f2 - f4 * f5) / 2.0F + f5 * f4);
      return;
      paramMatrix.postTranslate((f1 - f3) / 2.0F, (f2 - f4) / 2.0F);
    }
  }

  private float b(float paramFloat)
  {
    if (paramFloat > this.g)
      paramFloat = this.g;
    while (true)
    {
      return paramFloat;
      if (paramFloat >= n)
        continue;
      paramFloat = n;
    }
  }

  protected float a()
  {
    float f1;
    if (this.c.b() == null)
      f1 = 1.0F;
    while (true)
    {
      return f1;
      f1 = 4.0F * Math.max(this.c.f() / this.d, this.c.e() / this.e);
    }
  }

  protected float a(Matrix paramMatrix)
  {
    return a(paramMatrix, 0);
  }

  protected float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.j);
    return this.j[paramInt];
  }

  public void a(float paramFloat)
  {
    a(paramFloat, getWidth() / 2.0F, getHeight() / 2.0F);
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    b(paramFloat1, paramFloat2);
    a(true, true);
  }

  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = b(paramFloat1);
    float f2 = getScale();
    float f3 = f1 / f2;
    a("Old scale " + f2 + ", delta " + f3);
    this.b.postScale(f3, f3, paramFloat2, paramFloat3);
    setImageMatrix(getImageViewMatrix());
    a(true, true);
  }

  void a(String paramString)
  {
  }

  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.c.b() == null)
      return;
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF = new RectF(0.0F, 0.0F, this.c.b().getWidth(), this.c.b().getHeight());
    localMatrix.mapRect(localRectF);
    float f1 = localRectF.height();
    float f2 = localRectF.width();
    int i2;
    float f3;
    if (paramBoolean2)
    {
      i2 = getHeight();
      if (f1 < i2)
        f3 = (i2 - f1) / 2.0F - localRectF.top;
    }
    while (true)
    {
      label105: float f4 = 0.0F;
      int i1;
      if (paramBoolean1)
      {
        i1 = getWidth();
        if (f2 >= i1)
          break label245;
        f4 = (i1 - f2) / 2.0F - localRectF.left;
      }
      while (true)
      {
        a("center() delta: " + f4 + ", " + f3);
        b(f4, f3);
        setImageMatrix(getImageViewMatrix());
        break;
        if (localRectF.top > 0.0F)
        {
          f3 = -localRectF.top;
          break label105;
        }
        if (localRectF.bottom >= i2)
          break label299;
        f3 = getHeight() - localRectF.bottom;
        break label105;
        label245: if (localRectF.left > 0.0F)
        {
          f4 = -localRectF.left;
          continue;
        }
        boolean bool = localRectF.right < i1;
        f4 = 0.0F;
        if (!bool)
          continue;
        f4 = i1 - localRectF.right;
      }
      label299: f3 = 0.0F;
    }
  }

  public void b(float paramFloat1, float paramFloat2)
  {
    this.b.postTranslate(paramFloat1, paramFloat2);
  }

  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    c(f1 - paramFloat2, f2 - paramFloat3);
    a(paramFloat1, f1, f2);
  }

  public void c(float paramFloat1, float paramFloat2)
  {
    b(paramFloat1, paramFloat2);
    setImageMatrix(getImageViewMatrix());
  }

  public RectF getDisplayedImageRect()
  {
    return this.k;
  }

  public float getImageLeft()
  {
    return getImageRect().left;
  }

  public RectF getImageRect()
  {
    RectF localRectF;
    if (this.c.b() == null)
      localRectF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    while (true)
    {
      return localRectF;
      Matrix localMatrix = getImageViewMatrix();
      localRectF = new RectF(0.0F, 0.0F, this.c.b().getWidth(), this.c.b().getHeight());
      localMatrix.mapRect(localRectF);
    }
  }

  public float getImageRight()
  {
    return getImageRect().right;
  }

  protected Matrix getImageViewMatrix()
  {
    this.i.set(this.a);
    this.i.postConcat(this.b);
    return this.i;
  }

  public float getMaxZoom()
  {
    return this.g;
  }

  public float getScale()
  {
    return a(this.b);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = (paramInt3 - paramInt1);
    this.e = (paramInt4 - paramInt2);
    Runnable localRunnable = this.m;
    if (localRunnable != null)
    {
      this.m = null;
      localRunnable.run();
    }
    while (true)
    {
      return;
      if (this.c.b() != null)
      {
        a(this.c, this.a);
        setImageMatrix(getImageViewMatrix());
        continue;
      }
    }
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    a(paramBitmap, 0);
  }

  public void setImageBitmapResetBase(Bitmap paramBitmap, boolean paramBoolean)
  {
    setImageRotateBitmapResetBase(new RotateBitmap(paramBitmap), paramBoolean);
  }

  public void setImageBitmapResetBaseNoScale(RotateBitmap paramRotateBitmap, boolean paramBoolean)
  {
    this.f = false;
    if (getWidth() <= 0)
    {
      this.m = new ImageViewTouchBase.1(this, paramRotateBitmap, paramBoolean);
      return;
    }
    if (paramRotateBitmap.b() != null)
    {
      a(paramRotateBitmap, this.a);
      a(paramRotateBitmap.b(), paramRotateBitmap.a());
    }
    while (true)
    {
      if (paramBoolean)
        this.b.reset();
      setImageMatrix(getImageViewMatrix());
      this.g = a();
      break;
      this.a.reset();
      setImageBitmap(null);
    }
  }

  public void setImageMatrix(Matrix paramMatrix)
  {
    super.setImageMatrix(paramMatrix);
    Context localContext = getContext();
    if ((localContext instanceof PhotoGalleryActivity))
      ((PhotoGalleryActivity)localContext).j();
  }

  public void setImageRotateBitmapResetBase(RotateBitmap paramRotateBitmap, boolean paramBoolean)
  {
    this.f = true;
    if (getWidth() <= 0)
    {
      this.m = new ImageViewTouchBase.2(this, paramRotateBitmap, paramBoolean);
      return;
    }
    if (paramRotateBitmap.b() != null)
    {
      a(paramRotateBitmap, this.a);
      a(paramRotateBitmap.b(), paramRotateBitmap.a());
    }
    while (true)
    {
      if (paramBoolean)
        this.b.reset();
      setImageMatrix(getImageViewMatrix());
      this.g = a();
      break;
      this.a.reset();
      setImageBitmap(null);
    }
  }

  public void setRecycler(ImageViewTouchBase.Recycler paramRecycler)
  {
    this.l = paramRecycler;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.ImageViewTouchBase
 * JD-Core Version:    0.6.0
 */
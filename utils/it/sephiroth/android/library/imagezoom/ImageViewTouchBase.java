package it.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import it.sephiroth.android.library.imagezoom.easing.Cubic;
import it.sephiroth.android.library.imagezoom.easing.Easing;
import it.sephiroth.android.library.imagezoom.graphics.FastBitmapDrawable;

public class ImageViewTouchBase extends ImageView
{
  protected RectF A = new RectF();
  protected RectF B = new RectF();
  private ImageViewTouchBase.OnBitmapChangedListener a;
  protected Easing l = new Cubic();
  protected Matrix m = new Matrix();
  protected Matrix n = new Matrix();
  protected Handler o = new Handler();
  protected Runnable p = null;
  protected float q;
  protected float r = -1.0F;
  protected final Matrix s = new Matrix();
  protected final float[] t = new float[9];
  protected int u = -1;
  protected int v = -1;
  protected boolean w = false;
  protected final float x = 2.0F;
  protected final int y = 200;
  protected RectF z = new RectF();

  public ImageViewTouchBase(Context paramContext)
  {
    super(paramContext);
    c();
  }

  public ImageViewTouchBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }

  protected float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.t);
    return this.t[paramInt];
  }

  public Matrix a(Matrix paramMatrix)
  {
    this.s.set(this.m);
    this.s.postConcat(paramMatrix);
    return this.s;
  }

  protected RectF a(Matrix paramMatrix, boolean paramBoolean1, boolean paramBoolean2)
  {
    RectF localRectF1;
    if (getDrawable() == null)
    {
      localRectF1 = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
      return localRectF1;
    }
    this.A.set(0.0F, 0.0F, 0.0F, 0.0F);
    RectF localRectF2 = b(paramMatrix);
    float f1 = localRectF2.height();
    float f2 = localRectF2.width();
    int j;
    float f3;
    if (paramBoolean2)
    {
      j = getHeight();
      if (f1 < j)
        f3 = (j - f1) / 2.0F - localRectF2.top;
    }
    while (true)
    {
      label90: int i;
      float f4;
      if (paramBoolean1)
      {
        i = getWidth();
        if (f2 < i)
          f4 = (i - f2) / 2.0F - localRectF2.left;
      }
      while (true)
      {
        this.A.set(f4, f3, 0.0F, 0.0F);
        localRectF1 = this.A;
        break;
        if (localRectF2.top > 0.0F)
        {
          f3 = -localRectF2.top;
          break label90;
        }
        if (localRectF2.bottom >= j)
          break label249;
        f3 = getHeight() - localRectF2.bottom;
        break label90;
        if (localRectF2.left > 0.0F)
          f4 = -localRectF2.left;
        else if (localRectF2.right < i)
          f4 = i - localRectF2.right;
        else
          f4 = 0.0F;
      }
      label249: f3 = 0.0F;
    }
  }

  protected void a(double paramDouble1, double paramDouble2)
  {
    RectF localRectF = getBitmapRect();
    this.B.set((float)paramDouble1, (float)paramDouble2, 0.0F, 0.0F);
    a(localRectF, this.B);
    b(this.B.left, this.B.top);
    a(true, true);
  }

  protected void a(float paramFloat)
  {
  }

  protected void a(float paramFloat1, float paramFloat2, double paramDouble)
  {
    double d1 = paramFloat1;
    double d2 = paramFloat2;
    long l1 = System.currentTimeMillis();
    this.o.post(new ImageViewTouchBase.2(this, paramDouble, l1, d1, d2));
  }

  protected void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.n.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    setImageMatrix(getImageViewMatrix());
  }

  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 > getMaxZoom())
      paramFloat1 = getMaxZoom();
    long l1 = System.currentTimeMillis();
    float f1 = getScale();
    float f2 = paramFloat1 - f1;
    Matrix localMatrix = new Matrix(this.n);
    localMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    RectF localRectF = a(localMatrix, true, true);
    float f3 = paramFloat2 + paramFloat1 * localRectF.left;
    float f4 = paramFloat3 + paramFloat1 * localRectF.top;
    this.o.post(new ImageViewTouchBase.3(this, paramFloat4, l1, f2, f1, f3, f4));
  }

  protected void a(RectF paramRectF1, RectF paramRectF2)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    if ((paramRectF1.top >= 0.0F) && (paramRectF1.bottom <= f2))
      paramRectF2.top = 0.0F;
    if ((paramRectF1.left >= 0.0F) && (paramRectF1.right <= f1))
      paramRectF2.left = 0.0F;
    if ((paramRectF1.top + paramRectF2.top >= 0.0F) && (paramRectF1.bottom > f2))
      paramRectF2.top = ((int)(0.0F - paramRectF1.top));
    if ((paramRectF1.bottom + paramRectF2.top <= f2 - 0.0F) && (paramRectF1.top < 0.0F))
      paramRectF2.top = ((int)(f2 - 0.0F - paramRectF1.bottom));
    if (paramRectF1.left + paramRectF2.left >= 0.0F)
      paramRectF2.left = ((int)(0.0F - paramRectF1.left));
    if (paramRectF1.right + paramRectF2.left <= f1 - 0.0F)
      paramRectF2.left = ((int)(f1 - 0.0F - paramRectF1.right));
  }

  protected void a(Drawable paramDrawable)
  {
    if (this.a != null)
      this.a.a(paramDrawable);
  }

  protected void a(Drawable paramDrawable, Matrix paramMatrix)
  {
    Log.i("image", "getProperBaseMatrix");
    float f1 = getWidth();
    float f2 = getHeight();
    float f3 = paramDrawable.getIntrinsicWidth();
    float f4 = paramDrawable.getIntrinsicHeight();
    paramMatrix.reset();
    if ((f3 > f1) || (f4 > f2))
    {
      float f5 = Math.min(Math.min(f1 / f3, 2.0F), Math.min(f2 / f4, 2.0F));
      Log.d("image", "scale: " + f5);
      paramMatrix.postScale(f5, f5);
      paramMatrix.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
    }
    while (true)
    {
      return;
      paramMatrix.postTranslate((f1 - f3) / 2.0F, (f2 - f4) / 2.0F);
      Log.d("image", "scale: null");
    }
  }

  protected void a(Drawable paramDrawable, boolean paramBoolean, Matrix paramMatrix, float paramFloat)
  {
    if (paramDrawable != null)
      if (this.w)
      {
        b(paramDrawable, this.m);
        setMinZoom(c(this.m));
        super.setImageDrawable(paramDrawable);
        label37: if (paramBoolean)
        {
          this.n.reset();
          if (paramMatrix != null)
            this.n = new Matrix(paramMatrix);
        }
        setImageMatrix(getImageViewMatrix());
        if (paramFloat >= 1.0F)
          break label128;
      }
    label128: for (this.q = d(); ; this.q = paramFloat)
    {
      a(paramDrawable);
      return;
      a(paramDrawable, this.m);
      setMinZoom(getMinZoom());
      break;
      this.m.reset();
      super.setImageDrawable(null);
      break label37;
    }
  }

  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (getDrawable() == null);
    while (true)
    {
      return;
      RectF localRectF = a(this.n, paramBoolean1, paramBoolean2);
      if ((localRectF.left != 0.0F) || (localRectF.top != 0.0F))
      {
        Log.d("image", "center.rect: " + localRectF.left + "x" + localRectF.top);
        b(localRectF.left, localRectF.top);
      }
    }
  }

  protected RectF b(Matrix paramMatrix)
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null);
    for (RectF localRectF = null; ; localRectF = this.z)
    {
      return localRectF;
      Matrix localMatrix = a(paramMatrix);
      this.z.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localMatrix.mapRect(this.z);
    }
  }

  protected void b(float paramFloat)
  {
  }

  protected void b(float paramFloat1, float paramFloat2)
  {
    this.n.postTranslate(paramFloat1, paramFloat2);
    setImageMatrix(getImageViewMatrix());
  }

  protected void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > this.q)
      paramFloat1 = this.q;
    float f = paramFloat1 / getScale();
    Log.d("image", "zoomTo: " + paramFloat1 + ", center: " + paramFloat2 + "x" + paramFloat3);
    a(f, paramFloat2, paramFloat3);
    a(getScale());
    a(true, true);
  }

  protected void b(Drawable paramDrawable, Matrix paramMatrix)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    float f3 = paramDrawable.getIntrinsicWidth();
    float f4 = paramDrawable.getIntrinsicHeight();
    paramMatrix.reset();
    float f5 = Math.min(Math.min(f1 / f3, 2.0F), Math.min(f2 / f4, 2.0F));
    paramMatrix.postScale(f5, f5);
    paramMatrix.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
  }

  protected float c(Matrix paramMatrix)
  {
    return a(paramMatrix, 0);
  }

  protected void c()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
  }

  protected void c(float paramFloat)
  {
    b(paramFloat, getWidth() / 2.0F, getHeight() / 2.0F);
  }

  public void c(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, getWidth() / 2.0F, getHeight() / 2.0F, paramFloat2);
  }

  protected float d()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null);
    for (float f = 1.0F; ; f = 4.0F * Math.max(localDrawable.getIntrinsicWidth() / this.u, localDrawable.getIntrinsicHeight() / this.v))
      return f;
  }

  public void d(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, paramFloat2);
  }

  protected float e()
  {
    return 1.0F;
  }

  protected RectF getBitmapRect()
  {
    return b(this.n);
  }

  public Matrix getDisplayMatrix()
  {
    return new Matrix(this.n);
  }

  public Matrix getImageViewMatrix()
  {
    return a(this.n);
  }

  public float getMaxZoom()
  {
    if (this.q < 1.0F)
      this.q = d();
    return this.q;
  }

  public float getMinZoom()
  {
    if (this.r < 0.0F)
      this.r = e();
    return this.r;
  }

  public float getRotation()
  {
    return 0.0F;
  }

  public float getScale()
  {
    return c(this.n);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.u = (paramInt3 - paramInt1);
    this.v = (paramInt4 - paramInt2);
    Runnable localRunnable = this.p;
    if (localRunnable != null)
    {
      this.p = null;
      localRunnable.run();
    }
    if (getDrawable() != null)
    {
      if (!this.w)
        break label98;
      b(getDrawable(), this.m);
      setMinZoom(1.0F);
    }
    while (true)
    {
      setImageMatrix(getImageViewMatrix());
      c(getMinZoom());
      return;
      label98: a(getDrawable(), this.m);
      setMinZoom(getMinZoom());
    }
  }

  public void setFitToScreen(boolean paramBoolean)
  {
    if (paramBoolean != this.w)
    {
      this.w = paramBoolean;
      requestLayout();
    }
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageBitmap(paramBitmap, true);
  }

  public void setImageBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    setImageBitmap(paramBitmap, paramBoolean, null);
  }

  public void setImageBitmap(Bitmap paramBitmap, boolean paramBoolean, Matrix paramMatrix)
  {
    setImageBitmap(paramBitmap, paramBoolean, paramMatrix, -1.0F);
  }

  public void setImageBitmap(Bitmap paramBitmap, boolean paramBoolean, Matrix paramMatrix, float paramFloat)
  {
    if (paramBitmap != null)
      setImageDrawable(new FastBitmapDrawable(paramBitmap), paramBoolean, paramMatrix, paramFloat);
    while (true)
    {
      return;
      setImageDrawable(null, paramBoolean, paramMatrix, paramFloat);
    }
  }

  public void setImageDrawable(Drawable paramDrawable)
  {
    setImageDrawable(paramDrawable, true, null, -1.0F);
  }

  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean, Matrix paramMatrix, float paramFloat)
  {
    if (getWidth() <= 0)
      this.p = new ImageViewTouchBase.1(this, paramDrawable, paramBoolean, paramMatrix, paramFloat);
    while (true)
    {
      return;
      a(paramDrawable, paramBoolean, paramMatrix, paramFloat);
    }
  }

  public void setImageResource(int paramInt)
  {
    setImageDrawable(getContext().getResources().getDrawable(paramInt));
  }

  public void setMinZoom(float paramFloat)
  {
    Log.d("image", "minZoom: " + paramFloat);
    this.r = paramFloat;
  }

  public void setOnBitmapChangedListener(ImageViewTouchBase.OnBitmapChangedListener paramOnBitmapChangedListener)
  {
    this.a = paramOnBitmapChangedListener;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     it.sephiroth.android.library.imagezoom.ImageViewTouchBase
 * JD-Core Version:    0.6.2
 */
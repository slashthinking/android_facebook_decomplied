package com.facebook.katana.activity.media.crop;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.facebook.katana.RotateBitmap;
import com.facebook.katana.model.PhotoItem;

public class CropState
{
  private final CropHelper a;
  private PhotoItem b;
  private RotateBitmap c;
  private Matrix d;
  private Matrix e;
  private RectF f;
  private RectF g;
  private boolean h;

  public CropState(RotateBitmap paramRotateBitmap, Matrix paramMatrix1, Matrix paramMatrix2, RectF paramRectF1, RectF paramRectF2, PhotoItem paramPhotoItem, CropHelper paramCropHelper, Boolean paramBoolean)
  {
    this.c = paramRotateBitmap;
    this.d = paramMatrix1;
    this.e = paramMatrix2;
    this.f = paramRectF1;
    this.g = paramRectF2;
    this.b = paramPhotoItem;
    this.a = paramCropHelper;
    this.h = paramBoolean.booleanValue();
  }

  public CropState(CropHelper paramCropHelper)
  {
    this.a = paramCropHelper;
    this.c = new RotateBitmap(null);
    this.d = new Matrix();
    this.e = new Matrix();
    this.f = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.g = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.b = null;
    this.h = false;
  }

  private void a(float paramFloat)
  {
    this.d.postScale(paramFloat, paramFloat);
  }

  private void a(int paramInt1, int paramInt2)
  {
    this.d.postTranslate(paramInt1, paramInt2);
  }

  private void c(Matrix paramMatrix)
  {
    this.d.postConcat(paramMatrix);
  }

  public CropState a(CropState paramCropState, Matrix paramMatrix)
  {
    return new CropState(paramCropState.e(), paramCropState.f(), paramMatrix, paramCropState.i(), paramCropState.j(), paramCropState.h(), paramCropState.d(), Boolean.valueOf(paramCropState.k()));
  }

  public CropState a(CropState paramCropState, RectF paramRectF)
  {
    return new CropState(paramCropState.e(), paramCropState.f(), paramCropState.g(), paramRectF, paramCropState.j(), paramCropState.h(), paramCropState.d(), Boolean.valueOf(paramCropState.k()));
  }

  public void a()
  {
    this.d.reset();
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.a.a(paramFloat1, paramFloat2, this))
      this.e.postTranslate(paramFloat1, paramFloat2);
  }

  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.a.b(paramFloat1, paramFloat2, paramFloat3, this))
    {
      this.e.postTranslate(-paramFloat2, -paramFloat3);
      this.e.postRotate(paramFloat1);
      this.e.postTranslate(paramFloat2, paramFloat3);
    }
  }

  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = e().f();
    int j = e().e();
    a();
    c(e().c());
    float f1 = Math.min(paramFloat * paramInt1 / i, paramFloat * paramInt2 / j);
    a(f1);
    int k = (int)(paramInt1 * (1.0F - paramFloat) / 2.0F + (paramFloat * paramInt1 - f1 * i) / 2.0F);
    int m = (int)(paramInt2 * (1.0F - paramFloat) / 2.0F + (paramFloat * paramInt2 - f1 * j) / 2.0F);
    a(k, m);
    b();
    a(new RectF(k, m, (int)(k + f1 * i), (int)(m + f1 * j)));
  }

  public void a(Matrix paramMatrix)
  {
    this.e.set(paramMatrix);
  }

  public void a(RectF paramRectF)
  {
    this.g.set(paramRectF);
    b(paramRectF);
  }

  public void a(RotateBitmap paramRotateBitmap)
  {
    this.c = paramRotateBitmap;
  }

  public void a(PhotoItem paramPhotoItem)
  {
    this.b = paramPhotoItem;
  }

  public void b()
  {
    this.e.reset();
  }

  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.a.a(paramFloat1, paramFloat2, paramFloat3, this))
      this.e.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
  }

  public void b(Matrix paramMatrix)
  {
    this.e.postConcat(paramMatrix);
    paramMatrix.mapRect(this.f);
  }

  public void b(RectF paramRectF)
  {
    this.f.set(paramRectF);
  }

  public void c()
  {
    this.h = true;
  }

  public CropHelper d()
  {
    return this.a;
  }

  public RotateBitmap e()
  {
    return this.c;
  }

  public Matrix f()
  {
    return this.d;
  }

  public Matrix g()
  {
    return this.e;
  }

  public PhotoItem h()
  {
    return this.b;
  }

  public RectF i()
  {
    return this.f;
  }

  public RectF j()
  {
    return this.g;
  }

  public boolean k()
  {
    if ((this.h) || (!this.e.isIdentity()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void l()
  {
    if (this.c != null)
      this.c.g();
  }

  public Matrix m()
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(this.d);
    localMatrix.postConcat(this.e);
    return localMatrix;
  }

  public boolean n()
  {
    if ((!this.f.equals(new RectF(0.0F, 0.0F, 0.0F, 0.0F))) && (this.c.b() != null));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CropState
 * JD-Core Version:    0.6.0
 */
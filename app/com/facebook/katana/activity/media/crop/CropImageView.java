package com.facebook.katana.activity.media.crop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.RotateBitmap;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageDecodeException;
import com.facebook.katana.util.ImageUtils.ImageOutOfMemoryException;

public class CropImageView extends ImageView
{
  private CropState a = null;
  private CropHelper b = null;
  private Context c = null;
  private CropImageTouchManager d;
  private Runnable e = null;
  private int f = -1;
  private int g = -1;
  private CropImageView.OnImageSizeCalculatedListener h = null;

  public CropImageView(Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.MATRIX);
  }

  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setScaleType(ImageView.ScaleType.MATRIX);
  }

  public CropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setScaleType(ImageView.ScaleType.MATRIX);
  }

  private Bitmap b(Bitmap paramBitmap, int paramInt)
  {
    float f1 = a(paramBitmap, paramInt);
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(f1 * paramBitmap.getWidth()), (int)(f1 * paramBitmap.getHeight()), true);
    paramBitmap.recycle();
    return localBitmap;
  }

  private void b()
  {
    super.setImageBitmap(this.a.e().b());
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
      localDrawable.setDither(true);
  }

  private Matrix c()
  {
    return this.a.m();
  }

  private void c(Bitmap paramBitmap, int paramInt)
  {
    if (this.f <= 0)
      this.e = new CropImageView.1(this, paramBitmap, paramInt);
    while (true)
    {
      return;
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        Bitmap localBitmap = b(paramBitmap, paramInt);
        this.a.l();
        this.a.a(new RotateBitmap(localBitmap, paramInt));
        d();
        continue;
      }
    }
  }

  private void d()
  {
    if (this.a.e().b() != null)
    {
      a();
      b();
    }
    while (true)
    {
      setImageMatrix(c());
      return;
      this.a.a();
      this.a.b();
      b();
    }
  }

  private void e()
  {
    if (this.h != null)
      this.h.a();
  }

  protected float a(Bitmap paramBitmap, int paramInt)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)this.c.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    float f1 = getResources().getDimension(2131230821);
    return this.b.a(paramBitmap, paramInt, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, f1, 0.9F);
  }

  public void a()
  {
    this.a.a(this.f, this.g, 0.9F);
    e();
  }

  public void a(CropHelper paramCropHelper, CropState paramCropState, Context paramContext)
  {
    this.b = paramCropHelper;
    this.a = paramCropState;
    this.c = paramContext;
    this.d = new CropImageTouchManager(paramCropHelper, paramCropState);
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.d != null)
    {
      this.d.a(paramMotionEvent);
      setImageMatrix(this.a.m());
    }
    for (int i = 1; ; i = 0)
      return i;
  }

  protected int getViewHeight()
  {
    return this.g;
  }

  protected int getViewWidth()
  {
    return this.f;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.f = (paramInt3 - paramInt1);
    this.g = (paramInt4 - paramInt2);
    Runnable localRunnable = this.e;
    if (localRunnable != null)
    {
      this.e = null;
      localRunnable.run();
    }
    while (true)
    {
      return;
      if (this.a.e() != null)
      {
        if (this.a.k())
          CropDatabaseHelper.a(this.a);
        d();
        continue;
      }
    }
  }

  public void setImageBitmapResetBase()
  {
    try
    {
      c(ImageUtils.b(this.a.h().b()), this.a.h().h());
      return;
    }
    catch (ImageUtils.ImageOutOfMemoryException localImageOutOfMemoryException)
    {
      while (true)
        ErrorReporting.a("Crop Image", "ImageOutOfMemoryException on loading", localImageOutOfMemoryException);
    }
    catch (ImageUtils.ImageDecodeException localImageDecodeException)
    {
      while (true)
        ErrorReporting.a("Crop Image", "ImageDecodeException on loading", localImageDecodeException);
    }
  }

  public void setImageMatrix(Matrix paramMatrix)
  {
    super.setImageMatrix(paramMatrix);
  }

  public void setOnImageSizeCalculatedListener(CropImageView.OnImageSizeCalculatedListener paramOnImageSizeCalculatedListener)
  {
    this.h = paramOnImageSizeCalculatedListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CropImageView
 * JD-Core Version:    0.6.0
 */
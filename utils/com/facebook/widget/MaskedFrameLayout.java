package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.R.styleable;

public class MaskedFrameLayout extends FrameLayout
{
  private Drawable a = null;
  private Bitmap b = null;

  public MaskedFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public MaskedFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MaskedFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MaskedFrameLayout, paramInt, 0);
    Drawable localDrawable = localTypedArray.getDrawable(0);
    if (localDrawable != null)
      setMaskDrawable(localDrawable);
    localTypedArray.recycle();
  }

  private void a()
  {
    if (this.b != null)
    {
      this.b.recycle();
      this.b = null;
    }
  }

  private Bitmap getMaskBitmap()
  {
    if (this.b != null);
    for (Bitmap localBitmap = this.b; ; localBitmap = this.b)
    {
      return localBitmap;
      int i = getWidth();
      int j = getHeight();
      this.b = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(this.b);
      this.a.setBounds(0, 0, i, j);
      this.a.draw(localCanvas);
    }
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.a == null)
      super.dispatchDraw(paramCanvas);
    while (true)
    {
      return;
      paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
      super.dispatchDraw(paramCanvas);
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      paramCanvas.drawBitmap(getMaskBitmap(), 0.0F, 0.0F, localPaint);
      paramCanvas.restore();
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }

  public void setMaskDrawable(Drawable paramDrawable)
  {
    this.a = paramDrawable;
    a();
    invalidate();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.MaskedFrameLayout
 * JD-Core Version:    0.6.2
 */
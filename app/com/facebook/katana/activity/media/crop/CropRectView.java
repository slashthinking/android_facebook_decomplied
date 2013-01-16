package com.facebook.katana.activity.media.crop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CropRectView extends View
{
  private final boolean a = false;
  private CropState b = null;
  private CropHelper c = null;
  private CropRectTouchManager d;
  private CropRectView.OnAnimationRequestedListener e = null;

  public CropRectView(Context paramContext)
  {
    super(paramContext);
  }

  public CropRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public CropRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private Rect a(RectF paramRectF)
  {
    return new Rect((int)(paramRectF.left - 1.5F), (int)(paramRectF.top - 1.5F), (int)(1.0F + paramRectF.right), (int)(1.0F + paramRectF.bottom));
  }

  private void a()
  {
    this.e.a();
  }

  private RectF b(RectF paramRectF)
  {
    return new RectF(paramRectF.left - 1.5F, paramRectF.top - 1.5F, 1.0F + paramRectF.right, 1.0F + paramRectF.bottom);
  }

  public void a(CropHelper paramCropHelper, CropState paramCropState)
  {
    this.c = paramCropHelper;
    this.b = paramCropState;
    this.d = new CropRectTouchManager(this.c, this.b);
    this.d.a(new CropRectView.1(this));
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (this.d != null)
    {
      bool = this.d.a(paramMotionEvent);
      if (this.d.a())
        invalidate();
    }
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    Paint localPaint1 = new Paint();
    localPaint1.setStyle(Paint.Style.FILL);
    localPaint1.setARGB(125, 0, 0, 0);
    Region localRegion = new Region();
    localRegion.set(new Rect(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight()));
    localRegion.op(a(this.b.i()), Region.Op.DIFFERENCE);
    RegionIterator localRegionIterator = new RegionIterator(localRegion);
    Rect localRect = new Rect();
    while (localRegionIterator.next(localRect))
      paramCanvas.drawRect(localRect, localPaint1);
    Paint localPaint2 = new Paint();
    localPaint2.setStrokeWidth(3.0F);
    localPaint2.setStyle(Paint.Style.STROKE);
    localPaint2.setAntiAlias(true);
    localPaint2.setColor(getResources().getColor(2131165256));
    paramCanvas.restore();
    paramCanvas.drawRect(b(this.b.i()), localPaint2);
  }

  public void setHighlightArea()
  {
    this.d.c();
    invalidate();
  }

  public void setOnAnimationRequestedListener(CropRectView.OnAnimationRequestedListener paramOnAnimationRequestedListener)
  {
    this.e = paramOnAnimationRequestedListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CropRectView
 * JD-Core Version:    0.6.0
 */
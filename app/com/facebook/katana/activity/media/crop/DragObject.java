package com.facebook.katana.activity.media.crop;

import android.graphics.RectF;

class DragObject
{
  protected float a;
  protected float b;
  protected RectF c;
  private Touchable d;

  public DragObject(Touchable paramTouchable, float paramFloat1, float paramFloat2, RectF paramRectF)
  {
    this.d = paramTouchable;
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
  }

  public Touchable a()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.DragObject
 * JD-Core Version:    0.6.0
 */
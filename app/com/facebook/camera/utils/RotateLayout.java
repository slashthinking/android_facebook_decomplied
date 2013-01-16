package com.facebook.camera.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class RotateLayout extends ViewGroup
{
  private int a;
  private View b;

  public RotateLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundResource(17170445);
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.a == 0)
      super.dispatchDraw(paramCanvas);
    while (true)
    {
      return;
      paramCanvas.save();
      paramCanvas.rotate(-this.a, this.b.getMeasuredWidth() / 2, this.b.getMeasuredHeight() / 2);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
    }
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != 0)
    {
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramMotionEvent.getX();
      arrayOfFloat[1] = paramMotionEvent.getY();
      Matrix localMatrix = new Matrix();
      localMatrix.postRotate(this.a, this.b.getMeasuredWidth() / 2, this.b.getMeasuredHeight() / 2);
      localMatrix.mapPoints(arrayOfFloat);
      paramMotionEvent.setLocation(arrayOfFloat[0], arrayOfFloat[1]);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  protected void onFinishInflate()
  {
    this.b = getChildAt(0);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    switch (this.a)
    {
    default:
    case 0:
    case 180:
    case 90:
    case 270:
    }
    while (true)
    {
      return;
      this.b.layout(0, 0, i, j);
      continue;
      this.b.layout(0, 0, j, i);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j;
    switch (this.a)
    {
    default:
      j = 0;
    case 0:
    case 180:
    case 90:
    case 270:
    }
    while (true)
    {
      setMeasuredDimension(j, i);
      return;
      measureChild(this.b, paramInt1, paramInt2);
      j = this.b.getMeasuredWidth();
      i = this.b.getMeasuredHeight();
      continue;
      measureChild(this.b, paramInt2, paramInt1);
      j = this.b.getMeasuredHeight();
      i = this.b.getMeasuredWidth();
    }
  }

  public void setOrientation(int paramInt)
  {
    int i = paramInt % 360;
    if (this.a == i);
    while (true)
    {
      return;
      this.a = i;
      requestLayout();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.utils.RotateLayout
 * JD-Core Version:    0.6.0
 */
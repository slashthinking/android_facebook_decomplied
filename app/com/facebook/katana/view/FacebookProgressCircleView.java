package com.facebook.katana.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class FacebookProgressCircleView extends View
{
  private static int a = 30;
  private static int b = 4;
  private Paint c;
  private int d = 0;
  private RectF e;
  private int f;
  private int g;
  private final int h;

  public FacebookProgressCircleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = paramContext.getResources().getColor(paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "color", 2131165256));
    a();
  }

  private void a()
  {
    this.f = (int)Math.ceil(TypedValue.applyDimension(1, a, getResources().getDisplayMetrics()));
    this.g = (int)Math.ceil(TypedValue.applyDimension(1, b, getResources().getDisplayMetrics()));
    this.c = new Paint();
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setAntiAlias(true);
    this.c.setStrokeWidth(this.g);
    this.c.setColor(this.h);
    int i = (int)Math.ceil(this.g / 2.0D);
    this.e = new RectF(i, i, this.f, this.f);
  }

  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = 360 * this.d / 100.0F;
    if (this.d > 0)
    {
      this.c.setAlpha(255);
      paramCanvas.drawArc(this.e, 270.0F, f1, false, this.c);
    }
    if (this.d < 100)
    {
      this.c.setAlpha(127);
      paramCanvas.drawArc(this.e, 270.0F + f1, 360.0F - f1, false, this.c);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.f + this.g, this.f + this.g);
  }

  public void setProgress(int paramInt)
  {
    if (paramInt == this.d);
    while (true)
    {
      return;
      this.d = Math.min(100, Math.max(0, paramInt));
      invalidate();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.FacebookProgressCircleView
 * JD-Core Version:    0.6.0
 */
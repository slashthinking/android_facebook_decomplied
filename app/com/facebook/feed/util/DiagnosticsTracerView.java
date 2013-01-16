package com.facebook.feed.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class DiagnosticsTracerView extends View
{
  private final Paint a;
  private long b;
  private long c;
  private long d;
  private final String e;

  private String a(long paramLong1, long paramLong2, long paramLong3)
  {
    return this.e + " bind: " + paramLong1 + " onLayout: " + paramLong2 + " onMeasure: " + paramLong3;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    int i = -65536;
    super.onDraw(paramCanvas);
    Paint localPaint = this.a;
    int j;
    if (this.b > 10L)
    {
      j = -256;
      localPaint.setColor(j);
      if (this.b <= 10L)
        break label86;
    }
    while (true)
    {
      setBackgroundColor(i);
      paramCanvas.drawText(a(this.b, this.c, this.d), 10.0F, 20.0F, this.a);
      return;
      j = i;
      break;
      label86: i = -256;
    }
  }

  public void setBindModelTime(long paramLong)
  {
    this.b = paramLong;
  }

  public void setOnLayoutTime(long paramLong)
  {
    this.c = paramLong;
  }

  public void setOnMeasureTime(long paramLong)
  {
    this.d = paramLong;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.DiagnosticsTracerView
 * JD-Core Version:    0.6.0
 */
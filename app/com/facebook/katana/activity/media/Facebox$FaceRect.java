package com.facebook.katana.activity.media;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;

class Facebox$FaceRect extends View
{
  private RectF b;
  private Paint c = new Paint();

  public Facebox$FaceRect(Facebox paramFacebox, Context paramContext)
  {
    super(paramContext);
    this.c.setColor(Color.rgb(0, 255, 0));
    this.c.setStrokeWidth(5.0F);
    this.c.setStyle(Paint.Style.STROKE);
  }

  public void a(RectF paramRectF)
  {
    this.b = paramRectF;
  }

  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawRect(this.b, this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Facebox.FaceRect
 * JD-Core Version:    0.6.0
 */
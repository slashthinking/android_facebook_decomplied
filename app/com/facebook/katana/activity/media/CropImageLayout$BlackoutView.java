package com.facebook.katana.activity.media;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;

class CropImageLayout$BlackoutView extends View
{
  private int b = getResources().getColor(2131165465);

  public CropImageLayout$BlackoutView(CropImageLayout paramCropImageLayout, Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT >= 11)
      setLayerType(1, null);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.clipRect(CropImageLayout.a(this.a), Region.Op.DIFFERENCE);
    paramCanvas.drawColor(this.b);
    paramCanvas.restore();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    default:
      bool = super.onTouchEvent(paramMotionEvent);
    case 0:
    case 1:
    }
    while (true)
    {
      return bool;
      RectF localRectF = CropImageLayout.a(this.a);
      if (localRectF.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        CropImageLayout.a(this.a, bool);
        CropImageLayout.a(this.a, paramMotionEvent.getX() - localRectF.left);
        CropImageLayout.b(this.a, paramMotionEvent.getY() - localRectF.top);
        continue;
      }
      CropImageLayout.a(this.a, false);
      invalidate();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CropImageLayout.BlackoutView
 * JD-Core Version:    0.6.0
 */
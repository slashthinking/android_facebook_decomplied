package com.facebook.orca.common.ui.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class CanvasCaptureView extends View
{
  private Bitmap a;

  public CanvasCaptureView(Context paramContext)
  {
    super(paramContext);
  }

  public CanvasCaptureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public CanvasCaptureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.a, 0.0F, 0.0F, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.animation.CanvasCaptureView
 * JD-Core Version:    0.6.0
 */
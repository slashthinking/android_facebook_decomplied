package com.facebook.feed.pages;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class StoryInsightsBarView extends View
{
  private Paint a = new Paint();
  private float b;

  public StoryInsightsBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = getWidth() * this.b;
    float f2 = getHeight();
    paramCanvas.drawRect(0.0F, getPaddingTop(), f1, f2 - getPaddingBottom(), this.a);
  }

  public void setColor(int paramInt)
  {
    this.a.setColor(paramInt);
  }

  public void setPercentage(float paramFloat)
  {
    this.b = paramFloat;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.pages.StoryInsightsBarView
 * JD-Core Version:    0.6.0
 */
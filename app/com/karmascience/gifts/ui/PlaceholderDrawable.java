package com.karmascience.gifts.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class PlaceholderDrawable extends Drawable
{
  private final int a;
  private final int b;

  public PlaceholderDrawable(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public void draw(Canvas paramCanvas)
  {
  }

  public int getIntrinsicHeight()
  {
    return this.b;
  }

  public int getIntrinsicWidth()
  {
    return this.a;
  }

  public int getMinimumHeight()
  {
    return this.b;
  }

  public int getMinimumWidth()
  {
    return this.a;
  }

  public int getOpacity()
  {
    return 0;
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.ui.PlaceholderDrawable
 * JD-Core Version:    0.6.0
 */
package it.sephiroth.android.library.imagezoom.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class FastBitmapDrawable extends Drawable
{
  protected Bitmap a;
  protected Paint b;

  public FastBitmapDrawable(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    this.b = new Paint();
    this.b.setDither(true);
    this.b.setFilterBitmap(true);
  }

  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.a, 0.0F, 0.0F, this.b);
  }

  public int getIntrinsicHeight()
  {
    return this.a.getHeight();
  }

  public int getIntrinsicWidth()
  {
    return this.a.getWidth();
  }

  public int getMinimumHeight()
  {
    return this.a.getHeight();
  }

  public int getMinimumWidth()
  {
    return this.a.getWidth();
  }

  public int getOpacity()
  {
    return -3;
  }

  public void setAlpha(int paramInt)
  {
    this.b.setAlpha(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     it.sephiroth.android.library.imagezoom.graphics.FastBitmapDrawable
 * JD-Core Version:    0.6.2
 */
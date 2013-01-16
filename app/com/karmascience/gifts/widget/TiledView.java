package com.karmascience.gifts.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R.styleable;

public class TiledView extends View
{
  private Drawable a;
  private int b;
  private final boolean c;

  public TiledView(Context paramContext)
  {
    this(paramContext, null);
  }

  public TiledView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TiledView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TiledView, paramInt, 0);
    int j = localTypedArray.getResourceId(0, 0);
    if (j != 0)
      setBitmapResId(j);
    this.c = localTypedArray.getBoolean(i, false);
    if (localTypedArray.getBoolean(2, false));
    while (true)
    {
      this.b = i;
      localTypedArray.recycle();
      return;
      i = 0;
    }
  }

  private void a(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString)
  {
    int i = getScrollX();
    int j = getScrollY();
    paramCanvas.save();
    paramCanvas.translate(i + paramInt1, j + paramInt2);
    paramDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    super.onDraw(paramCanvas);
    if (this.a != null)
    {
      int j = this.a.getIntrinsicWidth();
      int k = getWidth();
      if (this.b == 0)
      {
        if (this.c)
        {
          int i3 = k - j;
          while (i3 > -j)
          {
            a(paramCanvas, this.a, i3, 0, null);
            i3 -= j;
          }
        }
        int i2 = 0;
        while (i2 < k)
        {
          a(paramCanvas, this.a, i2, 0, null);
          i2 += j;
        }
      }
      int m = this.a.getIntrinsicHeight();
      int n = getHeight();
      int i1;
      if (this.c)
        i1 = getRight() - j;
      while (i < n)
      {
        a(paramCanvas, this.a, i1, i, null);
        i += m;
        continue;
        i1 = 0;
        i = 0;
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }

  public void setBitmapResId(int paramInt)
  {
    this.a = getResources().getDrawable(paramInt);
    int i = this.a.getIntrinsicHeight();
    Rect localRect = new Rect(0, 0, this.a.getIntrinsicWidth(), i);
    this.a.setBounds(localRect);
  }

  public void setMode(int paramInt)
  {
    this.b = paramInt;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.widget.TiledView
 * JD-Core Version:    0.6.0
 */
package com.facebook.katana.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.R.styleable;

public class VerticalRelativeLayout extends RelativeLayout
{
  private boolean a = false;
  private VerticalRelativeLayout.MeasureSpecs b;

  public VerticalRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.VerticalRelativeLayout);
    int i = localTypedArray.getInt(0, -90);
    localTypedArray.recycle();
    setRotation(i);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt;
    int k;
    int j;
    int i;
    if (paramBoolean)
    {
      arrayOfInt = ((RelativeLayout.LayoutParams)getLayoutParams()).getRules();
      if (arrayOfInt[11] == -1)
      {
        k = getWidth() / 2 - getHeight() / 2;
        j = paramInt1 + k;
        i = paramInt3 + k;
        setLeft(j);
        setRight(i);
      }
    }
    while (true)
    {
      super.onLayout(paramBoolean, j, paramInt2, i, paramInt4);
      return;
      if (arrayOfInt[9] == -1)
      {
        k = -1 * (getWidth() / 2 - getHeight() / 2);
        break;
      }
      k = 0;
      break;
      i = paramInt3;
      j = paramInt1;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.b == null)
      this.b = new VerticalRelativeLayout.MeasureSpecs(this, paramInt2, paramInt1);
    int i = View.MeasureSpec.getSize(this.b.a);
    int j = View.MeasureSpec.getSize(this.b.b);
    if (!this.a)
    {
      setMeasuredDimension(i, j);
      this.a = true;
    }
    super.onMeasure(this.b.a, this.b.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.VerticalRelativeLayout
 * JD-Core Version:    0.6.0
 */
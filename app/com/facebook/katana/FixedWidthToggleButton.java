package com.facebook.katana;

import android.content.Context;
import android.graphics.Paint;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.widget.ToggleButton;

class FixedWidthToggleButton extends ToggleButton
{
  public FixedWidthToggleButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public FixedWidthToggleButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    CharSequence[] arrayOfCharSequence = new CharSequence[2];
    arrayOfCharSequence[0] = getTextOn();
    arrayOfCharSequence[1] = getTextOff();
    new Paint().setTypeface(getTypeface());
    int i = arrayOfCharSequence.length;
    int j = 0;
    int k = 0;
    int m;
    if (j < i)
    {
      m = (int)new StaticLayout(arrayOfCharSequence[j], getPaint(), 1000, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineWidth(0);
      if (m <= k)
        break label128;
    }
    while (true)
    {
      j++;
      k = m;
      break;
      setMeasuredDimension(resolveSize(k + getPaddingLeft() + getPaddingRight(), paramInt1), resolveSize(getSuggestedMinimumHeight(), paramInt2));
      return;
      label128: m = k;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FixedWidthToggleButton
 * JD-Core Version:    0.6.0
 */
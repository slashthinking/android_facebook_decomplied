package com.facebook.orca.common.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.widget.CustomViewGroup;

public class ShowSingleViewLayout extends CustomViewGroup
{
  public ShowSingleViewLayout(Context paramContext)
  {
    super(paramContext);
  }

  public ShowSingleViewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ShowSingleViewLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = -1 + getChildCount();
    int j = 0;
    int k = 0;
    int m;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
        k = localView.getMeasuredWidth();
        m = localView.getMeasuredHeight();
        if ((k <= 0) || (m <= 0))
          break label131;
      }
    }
    while (true)
    {
      int n = k + (getPaddingLeft() + getPaddingRight());
      int i1 = Math.max(m + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
      setMeasuredDimension(resolveSize(Math.max(n, getSuggestedMinimumWidth()), paramInt1), resolveSize(i1, paramInt2));
      return;
      m = j;
      label131: i--;
      j = m;
      break;
      m = j;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.ShowSingleViewLayout
 * JD-Core Version:    0.6.0
 */
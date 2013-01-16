package com.facebook.orca.common.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;

public class FloatRightCustomLayout extends ViewGroup
{
  public FloatRightCustomLayout(Context paramContext)
  {
    super(paramContext);
  }

  public FloatRightCustomLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public FloatRightCustomLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LinearLayout.LayoutParams;
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LinearLayout.LayoutParams(-1, -1);
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LinearLayout.LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LinearLayout.LayoutParams(paramLayoutParams);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() != 2)
      throw new IllegalStateException("Should be two children");
    int i = getPaddingTop();
    int j = getPaddingBottom();
    int k = getHeight();
    int m = getPaddingLeft();
    int n = k - i - j;
    int i1 = k - j;
    int i2 = 0;
    int i3 = m;
    if (i2 < 2)
    {
      View localView = getChildAt(i2);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      int i4 = localView.getMeasuredWidth();
      int i5 = localView.getMeasuredHeight();
      int i6;
      switch (0x70 & localLayoutParams.gravity)
      {
      default:
        i6 = i;
      case 48:
      case 16:
      case 80:
      }
      while (true)
      {
        int i7 = i3 + localLayoutParams.leftMargin;
        a(localView, i7, i6, i4, i5);
        int i8 = i7 + (i4 + localLayoutParams.rightMargin);
        i2++;
        i3 = i8;
        break;
        i6 = i + localLayoutParams.topMargin;
        continue;
        i6 = i + (n - i5) / 2 + localLayoutParams.topMargin - localLayoutParams.bottomMargin;
        continue;
        i6 = i1 - i5 - localLayoutParams.bottomMargin;
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (getChildCount() != 2)
      throw new IllegalStateException("Should be two children");
    View localView1 = getChildAt(0);
    View localView2 = getChildAt(1);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView2.getLayoutParams();
    measureChildWithMargins(localView2, View.MeasureSpec.makeMeasureSpec(0, 0), 0, paramInt2, 0);
    int i = localView2.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
    int j = Math.max(0, localView2.getMeasuredHeight());
    int k = 0 + (localView2.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin);
    measureChildWithMargins(localView1, paramInt1, i, paramInt2, 0);
    int m = k + localView1.getMeasuredWidth();
    int n = Math.max(j, localView1.getMeasuredHeight()) + (getPaddingTop() + getPaddingBottom());
    int i1 = Math.max(m + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth());
    int i2 = Math.max(n, getSuggestedMinimumHeight());
    setMeasuredDimension(resolveSize(i1, paramInt1), resolveSize(i2, paramInt2));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.FloatRightCustomLayout
 * JD-Core Version:    0.6.0
 */
package com.facebook.orca.common.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.orca.compose.ComposeMode;

public class CreateThreadCustomLayout extends ViewGroup
{
  private ComposeMode a = ComposeMode.SHRUNK;

  public CreateThreadCustomLayout(Context paramContext)
  {
    super(paramContext);
  }

  public CreateThreadCustomLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public CreateThreadCustomLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ViewGroup.MarginLayoutParams;
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -1);
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() != 2)
      throw new IllegalStateException("Should be two children");
    int i = getPaddingLeft();
    getWidth();
    int j = getPaddingTop();
    int k = getHeight();
    int m = 0;
    int n = 0;
    while (n < 2)
    {
      View localView2 = getChildAt(n);
      int i8 = m + localView2.getMeasuredHeight();
      ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)localView2.getLayoutParams();
      int i9 = i8 + (localMarginLayoutParams2.topMargin + localMarginLayoutParams2.bottomMargin);
      n++;
      m = i9;
    }
    int i1 = Math.max(0, k - m);
    int i2 = 0;
    View localView1;
    ViewGroup.MarginLayoutParams localMarginLayoutParams1;
    int i3;
    int i4;
    int i5;
    if (i2 < 2)
    {
      localView1 = getChildAt(i2);
      localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)localView1.getLayoutParams();
      i3 = localView1.getMeasuredWidth();
      i4 = localView1.getMeasuredHeight();
      i5 = i + localMarginLayoutParams1.leftMargin;
      if (i2 != 1)
        break label226;
    }
    label226: for (int i6 = j + i1; ; i6 = j)
    {
      int i7 = i6 + localMarginLayoutParams1.topMargin;
      a(localView1, i5, i7, i3, i4);
      j = i7 + (i4 + localMarginLayoutParams1.bottomMargin);
      i2++;
      break;
      return;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (getChildCount() != 2)
      throw new IllegalStateException("Should be two children");
    View localView1 = getChildAt(0);
    View localView2 = getChildAt(1);
    measureChildWithMargins(localView2, paramInt1, 0, View.MeasureSpec.makeMeasureSpec(0, 0), 0);
    int i = localView2.getMeasuredHeight();
    int j = Math.max(0, localView2.getMeasuredWidth());
    int k = 0 + localView2.getMeasuredHeight();
    int n;
    int m;
    if ((this.a == ComposeMode.EXPANDED) && (View.MeasureSpec.getMode(paramInt2) == 1073741824))
    {
      localView1.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2) - (k + getPaddingTop() + getPaddingBottom()), 1073741824));
      n = k + localView1.getMeasuredHeight();
      m = j;
    }
    while (true)
    {
      int i1 = m + (getPaddingLeft() + getPaddingRight());
      int i2 = Math.max(n + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
      setMeasuredDimension(resolveSize(Math.max(i1, getSuggestedMinimumWidth()), paramInt1), resolveSize(i2, paramInt2));
      return;
      measureChildWithMargins(localView1, paramInt1, 0, paramInt2, i);
      m = Math.max(j, localView1.getMeasuredWidth());
      n = k + localView1.getMeasuredHeight();
    }
  }

  public void setComposeMode(ComposeMode paramComposeMode)
  {
    this.a = paramComposeMode;
    requestLayout();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.CreateThreadCustomLayout
 * JD-Core Version:    0.6.0
 */
package com.facebook.orca.common.ui.widgets.refreshablelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.facebook.orca.debug.Tracer;

public class RefreshableListViewCustomCenteringContainer extends ViewGroup
{
  public RefreshableListViewCustomCenteringContainer(Context paramContext)
  {
    super(paramContext);
  }

  public RefreshableListViewCustomCenteringContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public RefreshableListViewCustomCenteringContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() != 2)
      throw new IllegalStateException("Expecting 2 children not " + getChildCount());
    Tracer localTracer = Tracer.a("RefreshableListViewCustomCenteringContainer.onLayout");
    int i = getPaddingLeft();
    int j = getRight() - getLeft() - getPaddingRight();
    int k = getBottom() - getTop() - getPaddingBottom();
    int m = getPaddingTop();
    View localView1 = getChildAt(0);
    View localView2 = getChildAt(1);
    int n = i + (j - i) / 2;
    int i1 = m + (k - m) / 2;
    int i2 = n - localView2.getMeasuredWidth() / 2;
    int i3 = i1 - localView2.getMeasuredHeight() / 2;
    int i4 = i2 - localView1.getMeasuredWidth();
    int i5 = i1 - localView1.getMeasuredHeight() / 2;
    localView2.layout(i2, i3, i2 + localView2.getMeasuredWidth(), i3 + localView2.getMeasuredHeight());
    localView1.layout(i4, i5, i2, i5 + localView1.getMeasuredHeight());
    localTracer.a();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (getChildCount() != 2)
      throw new IllegalStateException("Expecting 2 children not " + getChildCount());
    Tracer localTracer = Tracer.a("RefreshableListViewCustomCenteringContainer.onMeasure");
    View localView1 = getChildAt(0);
    View localView2 = getChildAt(1);
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = 0 + (getPaddingLeft() + getPaddingRight());
    int m = 0 + (getPaddingTop() + getPaddingBottom());
    measureChild(localView1, paramInt1, paramInt2);
    int n = k + 2 * localView1.getMeasuredWidth();
    measureChild(localView2, View.MeasureSpec.makeMeasureSpec(j - n, i), paramInt2);
    int i1 = n + localView2.getMeasuredWidth();
    int i2 = Math.max(m + Math.max(localView1.getMeasuredHeight(), localView2.getMeasuredHeight()), getSuggestedMinimumHeight());
    setMeasuredDimension(resolveSize(Math.max(i1, getSuggestedMinimumWidth()), paramInt1), resolveSize(i2, paramInt2));
    localTracer.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewCustomCenteringContainer
 * JD-Core Version:    0.6.2
 */
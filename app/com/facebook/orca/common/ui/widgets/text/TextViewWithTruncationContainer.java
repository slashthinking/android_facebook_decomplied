package com.facebook.orca.common.ui.widgets.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.R.styleable;

public class TextViewWithTruncationContainer extends ViewGroup
{
  private static Class<?> a = TextViewWithTruncationContainer.class;
  private boolean b;
  private int c;

  public TextViewWithTruncationContainer(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public TextViewWithTruncationContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public TextViewWithTruncationContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TextViewWithTruncationContainer);
    setMaxLines(localTypedArray.getInt(0, 20));
    localTypedArray.recycle();
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return true;
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -1);
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.LayoutParams(paramLayoutParams);
  }

  public int getMaxLines()
  {
    return this.c;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() != 2);
    while (true)
    {
      return;
      View localView1 = getChildAt(0);
      View localView2 = getChildAt(1);
      if (this.b)
      {
        int i = paramInt4 - paramInt2;
        int j = Math.min(i, localView1.getMeasuredHeight());
        int k = Math.min(i - j, localView2.getMeasuredHeight());
        int m = j + 0;
        localView1.layout(0, 0, paramInt3 - paramInt1, m);
        int n = m + k;
        localView2.layout(0, m, paramInt3 - paramInt1, n);
        continue;
      }
      localView1.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
      localView2.layout(0, 0, 0, 0);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = getChildCount();
    if (j != 2)
      return;
    TextView localTextView = (TextView)getChildAt(0);
    measureChild(localTextView, paramInt1, paramInt2);
    boolean bool;
    label48: int k;
    int m;
    if (localTextView.getLineCount() > this.c)
    {
      bool = true;
      this.b = bool;
      k = 0;
      m = 0;
    }
    while (true)
    {
      if (k < j)
      {
        View localView = getChildAt(k);
        measureChild(localView, paramInt1, paramInt2);
        m = Math.max(m, localView.getMeasuredWidth());
        i += localView.getMeasuredHeight();
        if (this.b);
      }
      else
      {
        int n = Math.max(i, getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSize(Math.max(m, getSuggestedMinimumWidth()), paramInt1), resolveSize(n, paramInt2));
        break;
        bool = false;
        break label48;
      }
      k++;
    }
  }

  public void setMaxLines(int paramInt)
  {
    this.c = paramInt;
    requestLayout();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.text.TextViewWithTruncationContainer
 * JD-Core Version:    0.6.0
 */
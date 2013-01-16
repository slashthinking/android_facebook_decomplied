package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.R.styleable;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;

public class HorizontalOrVerticalViewGroup extends ViewGroup
{
  private static final Class<?> a = HorizontalOrVerticalViewGroup.class;
  private HorizontalOrVerticalViewGroup.Mode b = HorizontalOrVerticalViewGroup.Mode.VERTICAL;
  private final int c;

  public HorizontalOrVerticalViewGroup(Context paramContext)
  {
    this(paramContext, null);
  }

  public HorizontalOrVerticalViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public HorizontalOrVerticalViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.HorizontalOrVerticalViewGroup).getDimensionPixelSize(0, 0);
  }

  private HorizontalOrVerticalViewGroup.Size a(int paramInt1, int paramInt2, HorizontalOrVerticalViewGroup.Mode paramMode)
  {
    int i = getChildCount();
    ViewGroup.LayoutParams localLayoutParams;
    int j;
    int k;
    int m;
    label36: View localView;
    if (paramMode == HorizontalOrVerticalViewGroup.Mode.HORIZONTAL)
    {
      localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      j = 0;
      k = -2147483648;
      m = -2147483648;
      if (j >= i)
        break label178;
      localView = getChildAt(j);
      if (localView.getVisibility() != 8)
        break label82;
    }
    while (true)
    {
      j++;
      break label36;
      localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      break;
      label82: localView.setLayoutParams(localLayoutParams);
      measureChild(localView, paramInt1, paramInt2);
      int i1 = localView.getMeasuredWidth();
      int i2 = localView.getMeasuredHeight();
      BLog.b(a, "Child " + j + " initial measurement: " + i1 + "x" + i2);
      m = Math.max(m, i1);
      k = Math.max(k, i2);
    }
    label178: HorizontalOrVerticalViewGroup.Size localSize;
    if ((m == -2147483648) && (k == -2147483648))
    {
      BLog.b(a, "No visible children, collapsing view group to zero size.");
      localSize = new HorizontalOrVerticalViewGroup.Size(this, 0, 0);
      return localSize;
    }
    int n = this.c * (i - 1);
    if (paramMode == HorizontalOrVerticalViewGroup.Mode.HORIZONTAL)
      switch (View.MeasureSpec.getMode(paramInt1))
      {
      default:
      case 1073741824:
      case -2147483648:
      }
    while (true)
    {
      localSize = new HorizontalOrVerticalViewGroup.Size(this, m, k);
      break;
      m = Math.max(m, (View.MeasureSpec.getSize(paramInt1) - n) / i);
      continue;
      switch (View.MeasureSpec.getMode(paramInt2))
      {
      default:
        break;
      case 1073741824:
      case -2147483648:
        k = Math.max(k, (View.MeasureSpec.getSize(paramInt2) - n) / i);
      }
    }
  }

  private HorizontalOrVerticalViewGroup.Size a(HorizontalOrVerticalViewGroup.Size paramSize, int paramInt1, int paramInt2, HorizontalOrVerticalViewGroup.Mode paramMode)
  {
    int i = getChildCount();
    int j = this.c * (i - 1);
    int k;
    int m;
    int n;
    HorizontalOrVerticalViewGroup.Size localSize;
    if (paramMode == HorizontalOrVerticalViewGroup.Mode.HORIZONTAL)
    {
      k = j + (i * paramSize.a + getPaddingLeft() + getPaddingRight());
      m = paramSize.b + getPaddingTop() + getPaddingBottom();
      n = getDefaultSize(Math.max(k, getSuggestedMinimumWidth()), paramInt1);
      if (k <= n)
        break label173;
      BLog.b(a, "Desired width " + k + " > spec width " + n + ", switching modes...");
      localSize = null;
    }
    while (true)
    {
      return localSize;
      k = paramSize.a + getPaddingLeft() + getPaddingRight();
      m = j + (i * paramSize.b + getPaddingTop() + getPaddingBottom());
      break;
      label173: int i1 = getDefaultSize(Math.max(m, getSuggestedMinimumHeight()), paramInt2);
      if (m > i1)
      {
        BLog.b(a, "Desired height " + m + " > spec height " + i1);
        localSize = null;
      }
      else
      {
        localSize = new HorizontalOrVerticalViewGroup.Size(this, n, i1);
      }
    }
  }

  public HorizontalOrVerticalViewGroup.Mode getMode()
  {
    return this.b;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = getPaddingLeft();
    int k = getPaddingTop();
    int m = j;
    int n = 0;
    if (n < i)
    {
      View localView = getChildAt(n);
      int i1 = m + localView.getMeasuredWidth();
      int i2 = k + localView.getMeasuredHeight();
      Class localClass = a;
      StringBuilder localStringBuilder = new StringBuilder().append("Laying out child ").append(localView).append(" @ ");
      Joiner localJoiner = Joiner.on(",");
      Integer localInteger1 = Integer.valueOf(m);
      Integer localInteger2 = Integer.valueOf(k);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(i1);
      arrayOfObject[1] = Integer.valueOf(i2);
      BLog.b(localClass, localJoiner.join(localInteger1, localInteger2, arrayOfObject));
      localView.layout(m, k, i1, i2);
      if (this.b == HorizontalOrVerticalViewGroup.Mode.HORIZONTAL)
        m = i1 + this.c;
      while (true)
      {
        n++;
        break;
        k = i2 + this.c;
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = getChildCount();
    boolean bool;
    HorizontalOrVerticalViewGroup.Size localSize1;
    HorizontalOrVerticalViewGroup.Size localSize2;
    label85: int k;
    int m;
    label109: View localView;
    if (j > 0)
    {
      bool = true;
      Preconditions.checkState(bool, "Must have at least one child");
      localSize1 = a(paramInt1, paramInt2, HorizontalOrVerticalViewGroup.Mode.HORIZONTAL);
      localSize2 = a(localSize1, paramInt1, paramInt2, HorizontalOrVerticalViewGroup.Mode.HORIZONTAL);
      if (localSize2 == null)
        break label144;
      BLog.b(a, "Laying out view group horizontally, size " + localSize2);
      this.b = HorizontalOrVerticalViewGroup.Mode.HORIZONTAL;
      k = View.MeasureSpec.makeMeasureSpec(1073741824, localSize1.a);
      m = View.MeasureSpec.makeMeasureSpec(1073741824, localSize1.b);
      if (i >= j)
        break label315;
      localView = getChildAt(i);
      if (localView.getVisibility() != 8)
        break label267;
    }
    while (true)
    {
      i++;
      break label109;
      bool = false;
      break;
      label144: localSize1 = a(paramInt1, paramInt2, HorizontalOrVerticalViewGroup.Mode.VERTICAL);
      localSize2 = a(localSize1, paramInt1, paramInt2, HorizontalOrVerticalViewGroup.Mode.VERTICAL);
      if (localSize2 != null)
      {
        BLog.b(a, "Laying out view group vertically, size " + localSize2);
        this.b = HorizontalOrVerticalViewGroup.Mode.VERTICAL;
        break label85;
      }
      BLog.e(a, "Children of view group " + this + " do not fit either horizontally or vertically.");
      this.b = HorizontalOrVerticalViewGroup.Mode.VERTICAL;
      localSize2 = new HorizontalOrVerticalViewGroup.Size(this, View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
      break label85;
      label267: BLog.b(a, "Setting measured size of child " + localView + " to " + localSize1);
      localView.measure(k, m);
    }
    label315: setMeasuredDimension(localSize2.a, localSize2.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.HorizontalOrVerticalViewGroup
 * JD-Core Version:    0.6.2
 */
package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.facebook.R.styleable;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class BetterTextView extends TextView
{
  private List<BetterTextViewHook> a;
  private boolean b;
  private int c;

  public BetterTextView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public BetterTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public BetterTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BetterTextView);
    this.b = localTypedArray.getBoolean(0, false);
    this.c = localTypedArray.getDimensionPixelOffset(1, -1);
    localTypedArray.recycle();
  }

  private int getMaxLineWidth()
  {
    Layout localLayout = getLayout();
    int i = localLayout.getLineCount();
    float f1 = 0.0F;
    int j = 0;
    if (j < i)
    {
      if (Build.VERSION.SDK_INT > 14);
      for (float f2 = localLayout.getLineMax(j); ; f2 = localLayout.getLineWidth(j))
      {
        f1 = Math.max(f1, f2);
        j++;
        break;
      }
    }
    return (int)f1;
  }

  public void a(BetterTextViewHook paramBetterTextViewHook)
  {
    if (this.a == null)
      this.a = Lists.a();
    this.a.add(paramBetterTextViewHook);
  }

  public float getMaximallyWideThreshold()
  {
    return this.c;
  }

  public boolean getMinimallyWide()
  {
    return this.b;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((BetterTextViewHook)localIterator.next()).a(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    super.onMeasure(paramInt1, paramInt2);
    int j;
    if (getLineCount() > i)
    {
      j = View.MeasureSpec.getMode(paramInt1);
      if ((this.c <= 0) || (j != -2147483648))
        break label145;
      int m = View.MeasureSpec.getSize(paramInt1);
      int n = View.MeasureSpec.getSize(paramInt1);
      int i1 = getMaxLineWidth();
      if ((i1 >= m) || (m - i1 >= this.c))
        break label145;
      if (n < m)
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(m, 1073741824), paramInt2);
    }
    while (true)
    {
      if ((this.b) && ((j == 1073741824) || (j == -2147483648)) && (i == 0))
      {
        int k = getMaxLineWidth();
        if (k < getMeasuredWidth())
          super.onMeasure(View.MeasureSpec.makeMeasureSpec(k, 1073741824), paramInt2);
      }
      return;
      label145: i = 0;
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    List localList = this.a;
    boolean bool = false;
    if (localList != null)
    {
      Iterator localIterator = this.a.iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        bool = ((BetterTextViewHook)localIterator.next()).a(paramMotionEvent);
      }
      while (!bool);
    }
    if (!bool)
      bool = super.onTouchEvent(paramMotionEvent);
    return bool;
  }

  public void setMaximallyWideThreshold(int paramInt)
  {
    this.c = paramInt;
  }

  public void setMinimallyWide(boolean paramBoolean)
  {
    this.b = paramBoolean;
    requestLayout();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.BetterTextView
 * JD-Core Version:    0.6.2
 */
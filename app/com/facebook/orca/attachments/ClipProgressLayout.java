package com.facebook.orca.attachments;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomViewGroup;

public class ClipProgressLayout extends CustomViewGroup
{
  private double a = 1.0D;

  public ClipProgressLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public ClipProgressLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ClipProgressLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getPaddingLeft() + getPaddingRight();
    setMeasuredDimension(i + (int)((getMeasuredWidth() - i) * this.a), getMeasuredHeight());
  }

  public void setProgress(double paramDouble)
  {
    this.a = paramDouble;
    requestLayout();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.ClipProgressLayout
 * JD-Core Version:    0.6.0
 */
package com.facebook.orca.common.ui.overlay;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.R.styleable;

public class OverlayLayout$LayoutParams extends FrameLayout.LayoutParams
{
  public boolean a;
  public int b;
  public int c;

  public OverlayLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }

  public OverlayLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.OverlayLayout_Layout);
    this.a = localTypedArray.getBoolean(1, false);
    this.b = localTypedArray.getResourceId(2, 0);
    this.c = localTypedArray.getInt(0, 129);
    localTypedArray.recycle();
  }

  public OverlayLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.overlay.OverlayLayout.LayoutParams
 * JD-Core Version:    0.6.0
 */
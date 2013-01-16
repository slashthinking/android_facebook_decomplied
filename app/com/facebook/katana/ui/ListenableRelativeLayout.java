package com.facebook.katana.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ListenableRelativeLayout extends RelativeLayout
{
  private ListenableRelativeLayout.LayoutChangedListener a = null;

  public ListenableRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public ListenableRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ListenableRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.a != null))
      this.a.g_();
  }

  public void setOnLayoutChangedListener(ListenableRelativeLayout.LayoutChangedListener paramLayoutChangedListener)
  {
    this.a = paramLayoutChangedListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.ListenableRelativeLayout
 * JD-Core Version:    0.6.0
 */
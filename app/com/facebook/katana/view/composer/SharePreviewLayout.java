package com.facebook.katana.view.composer;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

public class SharePreviewLayout extends LinearLayout
{
  public SharePreviewLayout(Context paramContext)
  {
    super(paramContext);
  }

  public SharePreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public SharePreviewLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    Resources localResources = getResources();
    int j = localResources.getDimensionPixelSize(2131230904) + 2 * localResources.getDimensionPixelSize(2131230905);
    int k = getHeight();
    if (k == 0)
      k = localResources.getDimensionPixelSize(2131230906);
    if (i < k + j)
      setMeasuredDimension(0, 0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.composer.SharePreviewLayout
 * JD-Core Version:    0.6.0
 */
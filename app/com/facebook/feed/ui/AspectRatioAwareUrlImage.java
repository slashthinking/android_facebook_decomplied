package com.facebook.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.facebook.widget.UrlImage;

public class AspectRatioAwareUrlImage extends UrlImage
{
  private float b = 0.0F;

  public AspectRatioAwareUrlImage(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public AspectRatioAwareUrlImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AspectRatioAwareUrlImage(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public float getAspectRatio()
  {
    return this.b;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j;
    ViewGroup.LayoutParams localLayoutParams;
    if (this.b != 0.0F)
    {
      int i = View.MeasureSpec.getSize(paramInt1);
      j = View.MeasureSpec.getSize(paramInt2);
      localLayoutParams = getLayoutParams();
      if ((localLayoutParams.height != -2) || (localLayoutParams.width != -1))
        break label70;
      paramInt2 = View.MeasureSpec.makeMeasureSpec((int)Math.ceil(i / this.b), 1073741824);
    }
    while (true)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      label70: if ((localLayoutParams.width != -2) || (localLayoutParams.height != -1))
        continue;
      paramInt1 = View.MeasureSpec.makeMeasureSpec((int)Math.ceil(j * this.b), 1073741824);
    }
  }

  public void setAspectRatio(float paramFloat)
  {
    this.b = paramFloat;
    requestLayout();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.AspectRatioAwareUrlImage
 * JD-Core Version:    0.6.0
 */
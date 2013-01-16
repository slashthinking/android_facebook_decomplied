package com.facebook.bugreporter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.orca.common.ui.util.TouchDelegateUtils;

public class ScreenShotSectionContainer extends RelativeLayout
{
  private View a;

  public ScreenShotSectionContainer(Context paramContext)
  {
    super(paramContext);
  }

  public ScreenShotSectionContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ScreenShotSectionContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a()
  {
    setTouchDelegate(TouchDelegateUtils.a(this.a, 8));
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = findViewById(2131296435);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
      a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.ScreenShotSectionContainer
 * JD-Core Version:    0.6.0
 */
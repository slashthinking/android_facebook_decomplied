package com.facebook.katana.util;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class DisplayUtils
{
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    View localView = paramActivity.findViewById(paramInt1);
    if (localView != null)
    {
      int i = paramActivity.getResources().getDimensionPixelSize(paramInt2);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = i;
      localView.setLayoutParams(localLayoutParams);
      localView.requestLayout();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.DisplayUtils
 * JD-Core Version:    0.6.0
 */
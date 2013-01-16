package com.facebook.orca.common.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;

public class RectUtil
{
  public static void a(View paramView1, View paramView2, Rect paramRect)
  {
    paramView1.getHitRect(paramRect);
    View localView;
    for (ViewParent localViewParent = paramView1.getParent(); (localViewParent != paramView2) && (localViewParent != null) && ((localViewParent instanceof View)); localViewParent = localView.getParent())
    {
      localView = (View)localViewParent;
      paramRect.offset(localView.getLeft(), localView.getTop());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.RectUtil
 * JD-Core Version:    0.6.0
 */
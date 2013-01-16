package com.facebook.orca.common.ui.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.facebook.orca.common.util.SizeUtil;

public class TouchDelegateUtils
{
  public static TouchDelegate a(View paramView, int paramInt)
  {
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    int i = SizeUtil.a(paramView.getContext(), paramInt);
    localRect.left -= i;
    localRect.top -= i;
    localRect.right = (i + localRect.right);
    localRect.bottom = (i + localRect.bottom);
    return new TouchDelegate(localRect, paramView);
  }

  public static TouchDelegate a(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    localRect.top = paramInt1;
    localRect.bottom = paramInt2;
    return new TouchDelegate(localRect, paramView);
  }

  public static TouchDelegate a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    int i = SizeUtil.a(paramView.getContext(), paramInt3);
    localRect.left -= i;
    localRect.right = (i + localRect.right);
    localRect.top = paramInt1;
    localRect.bottom = paramInt2;
    return new TouchDelegate(localRect, paramView);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.util.TouchDelegateUtils
 * JD-Core Version:    0.6.0
 */
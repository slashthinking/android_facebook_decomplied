package com.facebook.widget.listview.recycle;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.widget.FbCustomViewGroup;
import com.google.common.base.Preconditions;

public class RecyclableViewHelper
{
  public static boolean a(FbCustomViewGroup paramFbCustomViewGroup, View paramView, int paramInt)
  {
    Preconditions.checkArgument(paramView instanceof IViewAttachAware);
    if (!((IViewAttachAware)paramView).a())
      ((ViewGroup)paramFbCustomViewGroup).addView(paramView, paramInt);
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.listview.recycle.RecyclableViewHelper
 * JD-Core Version:    0.6.2
 */
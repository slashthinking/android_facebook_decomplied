package com.facebook.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

public abstract interface FbCustomViewGroup
{
  public abstract void attachRecyclableViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams);

  public abstract void detachRecyclableViewFromParent(View paramView);

  public abstract void removeRecyclableViewFromParent(View paramView, boolean paramBoolean);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.FbCustomViewGroup
 * JD-Core Version:    0.6.2
 */
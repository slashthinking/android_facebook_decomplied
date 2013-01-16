package com.facebook.orca.common.ui.widgets.refreshablelistview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class RefreshableListViewOverflowItem extends View
{
  public RefreshableListViewOverflowItem(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public RefreshableListViewOverflowItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public RefreshableListViewOverflowItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    setMinimumHeight((int)(500.0F * getContext().getResources().getDisplayMetrics().density));
    setBackgroundDrawable(new ColorDrawable(Color.rgb(255, 255, 255)));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewOverflowItem
 * JD-Core Version:    0.6.2
 */
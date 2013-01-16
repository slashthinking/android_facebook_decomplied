package com.facebook.katana.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.AbsListView.LayoutParams;
import com.facebook.orca.threadlist.ThreadItemView;
import com.google.common.base.Supplier;

class FullscreenPopupViewDelegate$JewelThreadItemViewSupplier
  implements Supplier<ThreadItemView>
{
  private FullscreenPopupViewDelegate$JewelThreadItemViewSupplier(FullscreenPopupViewDelegate paramFullscreenPopupViewDelegate)
  {
  }

  public ThreadItemView a()
  {
    Context localContext = this.a.a.getContext();
    Resources localResources = localContext.getResources();
    ThreadItemView localThreadItemView = new ThreadItemView(localContext);
    localThreadItemView.setTimeTextColor(localResources.getColor(2131165512));
    int i = (int)localResources.getDimension(2131230932);
    localThreadItemView.setThreadIconSize(i);
    int j = (int)localResources.getDimension(2131230933);
    localThreadItemView.setPadding(j, 0, j, 0);
    localThreadItemView.setThreadDivider(localResources.getDrawable(2130838263), (int)localResources.getDimension(2131230816));
    localThreadItemView.setLayoutParams(new AbsListView.LayoutParams(-2, i + j));
    return localThreadItemView;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.FullscreenPopupViewDelegate.JewelThreadItemViewSupplier
 * JD-Core Version:    0.6.0
 */
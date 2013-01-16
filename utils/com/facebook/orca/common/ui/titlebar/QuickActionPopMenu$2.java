package com.facebook.orca.common.ui.titlebar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class QuickActionPopMenu$2
  implements AdapterView.OnItemClickListener
{
  QuickActionPopMenu$2(QuickActionPopMenu paramQuickActionPopMenu)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    TitleBarQuickActionItem localTitleBarQuickActionItem = (TitleBarQuickActionItem)paramView.getTag();
    this.a.b();
    if (QuickActionPopMenu.b(this.a) != null)
    {
      QuickActionPopMenu.a(this.a, localTitleBarQuickActionItem.b());
      QuickActionPopMenu.b(this.a).a(localTitleBarQuickActionItem);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.QuickActionPopMenu.2
 * JD-Core Version:    0.6.2
 */
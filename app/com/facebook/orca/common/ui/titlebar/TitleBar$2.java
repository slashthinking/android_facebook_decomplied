package com.facebook.orca.common.ui.titlebar;

import android.view.View;
import android.view.View.OnClickListener;

class TitleBar$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (TitleBar.b(this.a) != null)
    {
      QuickActionPopMenu localQuickActionPopMenu = new QuickActionPopMenu(TitleBar.c(this.a), TitleBar.b(this.a));
      localQuickActionPopMenu.a(-3);
      localQuickActionPopMenu.a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.TitleBar.2
 * JD-Core Version:    0.6.0
 */
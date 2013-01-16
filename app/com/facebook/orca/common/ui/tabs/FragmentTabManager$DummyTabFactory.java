package com.facebook.orca.common.ui.tabs;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

class FragmentTabManager$DummyTabFactory
  implements TabHost.TabContentFactory
{
  private final Context a;

  public FragmentTabManager$DummyTabFactory(Context paramContext)
  {
    this.a = paramContext;
  }

  public View createTabContent(String paramString)
  {
    View localView = new View(this.a);
    localView.setMinimumWidth(0);
    localView.setMinimumHeight(0);
    return localView;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.tabs.FragmentTabManager.DummyTabFactory
 * JD-Core Version:    0.6.0
 */
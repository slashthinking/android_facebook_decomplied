package com.facebook.orca.common.ui.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import java.util.HashMap;
import java.util.Map;

public class FragmentTabManager
  implements TabHost.OnTabChangeListener
{
  private final FragmentManager a;
  private final TabHost b;
  private final int c;
  private final Map<String, FragmentTabManager.TabInfo> d = new HashMap();
  private final FragmentTabManager.FragmentStrategy e;
  private FragmentTabManager.TabInfo f;
  private TabHost.OnTabChangeListener g;

  public FragmentTabManager(FragmentManager paramFragmentManager, TabHost paramTabHost, int paramInt, FragmentTabManager.FragmentStrategy paramFragmentStrategy)
  {
    this.a = paramFragmentManager;
    this.b = paramTabHost;
    this.c = paramInt;
    this.e = paramFragmentStrategy;
    this.b.setOnTabChangedListener(this);
  }

  public void a(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.g = paramOnTabChangeListener;
  }

  public void a(TabHost.TabSpec paramTabSpec, Class<?> paramClass, Bundle paramBundle)
  {
    paramTabSpec.setContent(new FragmentTabManager.DummyTabFactory(this.b.getContext()));
    String str = paramTabSpec.getTag();
    FragmentTabManager.TabInfo localTabInfo = new FragmentTabManager.TabInfo(str, paramClass, paramBundle);
    FragmentTabManager.TabInfo.a(localTabInfo, this.a.a(str));
    if ((FragmentTabManager.TabInfo.a(localTabInfo) != null) && (!FragmentTabManager.TabInfo.a(localTabInfo).t()))
    {
      FragmentTransaction localFragmentTransaction = this.a.a();
      localFragmentTransaction.d(FragmentTabManager.TabInfo.a(localTabInfo));
      localFragmentTransaction.a();
    }
    this.d.put(str, localTabInfo);
    this.b.addTab(paramTabSpec);
  }

  public void onTabChanged(String paramString)
  {
    FragmentTabManager.TabInfo localTabInfo = (FragmentTabManager.TabInfo)this.d.get(paramString);
    FragmentTransaction localFragmentTransaction;
    if (this.f != localTabInfo)
    {
      localFragmentTransaction = this.a.a();
      if ((this.f != null) && (FragmentTabManager.TabInfo.a(this.f) != null))
      {
        if (this.e != FragmentTabManager.FragmentStrategy.SHOW_HIDE)
          break label159;
        localFragmentTransaction.b(FragmentTabManager.TabInfo.a(this.f));
      }
      if (localTabInfo != null)
      {
        if (FragmentTabManager.TabInfo.a(localTabInfo) != null)
          break label174;
        FragmentTabManager.TabInfo.a(localTabInfo, Fragment.a(this.b.getContext(), FragmentTabManager.TabInfo.b(localTabInfo).getName(), FragmentTabManager.TabInfo.c(localTabInfo)));
        localFragmentTransaction.a(this.c, FragmentTabManager.TabInfo.a(localTabInfo), FragmentTabManager.TabInfo.d(localTabInfo));
      }
    }
    while (true)
    {
      this.f = localTabInfo;
      localFragmentTransaction.a();
      this.a.b();
      if (this.g != null)
        this.g.onTabChanged(paramString);
      return;
      label159: localFragmentTransaction.d(FragmentTabManager.TabInfo.a(this.f));
      break;
      label174: if (this.e == FragmentTabManager.FragmentStrategy.SHOW_HIDE)
      {
        localFragmentTransaction.c(FragmentTabManager.TabInfo.a(localTabInfo));
        continue;
      }
      localFragmentTransaction.e(FragmentTabManager.TabInfo.a(localTabInfo));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.tabs.FragmentTabManager
 * JD-Core Version:    0.6.0
 */
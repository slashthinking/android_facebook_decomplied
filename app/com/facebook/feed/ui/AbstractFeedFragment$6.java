package com.facebook.feed.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;

class AbstractFeedFragment$6
  implements FragmentManager.OnBackStackChangedListener
{
  public void a()
  {
    FragmentManager localFragmentManager = this.a.n().g();
    if (localFragmentManager != null)
    {
      Fragment localFragment = localFragmentManager.a(2131296394);
      if ((localFragment instanceof AbstractFeedFragment))
        AbstractFeedFragment.a((AbstractFeedFragment)localFragment);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.AbstractFeedFragment.6
 * JD-Core Version:    0.6.0
 */
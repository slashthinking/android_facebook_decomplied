package com.facebook.katana.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.appcenter.ui.AppBrowseFragment;
import com.facebook.fragment.IFragmentFactory;

class FbandroidFragmentFactoryInitializer$AppCenterBrowseFragmentFactory
  implements IFragmentFactory
{
  public int a()
  {
    return 4;
  }

  public Fragment a(Intent paramIntent)
  {
    return AppBrowseFragment.a(paramIntent.getStringExtra(AppBrowseFragment.a), paramIntent.getIntExtra("category_index", 0));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FbandroidFragmentFactoryInitializer.AppCenterBrowseFragmentFactory
 * JD-Core Version:    0.6.0
 */
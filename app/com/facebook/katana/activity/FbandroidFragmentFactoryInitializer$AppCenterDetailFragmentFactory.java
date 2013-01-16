package com.facebook.katana.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.appcenter.ui.AppDetailFragment;
import com.facebook.fragment.IFragmentFactory;

class FbandroidFragmentFactoryInitializer$AppCenterDetailFragmentFactory
  implements IFragmentFactory
{
  private FbandroidFragmentFactoryInitializer$AppCenterDetailFragmentFactory(FbandroidFragmentFactoryInitializer paramFbandroidFragmentFactoryInitializer)
  {
  }

  public int a()
  {
    return 5;
  }

  public Fragment a(Intent paramIntent)
  {
    return AppDetailFragment.a(paramIntent.getStringExtra("id"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FbandroidFragmentFactoryInitializer.AppCenterDetailFragmentFactory
 * JD-Core Version:    0.6.0
 */
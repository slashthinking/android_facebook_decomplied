package com.facebook.katana.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.fragment.IFragmentFactory;
import com.facebook.katana.activity.faceweb.FacewebFragment;

class FbandroidFragmentFactoryInitializer$FacewebFragmentFactory
  implements IFragmentFactory
{
  public int a()
  {
    return 0;
  }

  public Fragment a(Intent paramIntent)
  {
    return FacewebFragment.a(paramIntent.getStringExtra("mobile_page"), paramIntent.getBooleanExtra("faceweb_modal", false));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FbandroidFragmentFactoryInitializer.FacewebFragmentFactory
 * JD-Core Version:    0.6.0
 */
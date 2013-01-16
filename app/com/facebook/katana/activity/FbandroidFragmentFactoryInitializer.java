package com.facebook.katana.activity;

import com.facebook.fragment.IFragmentFactory;
import com.facebook.fragment.IFragmentFactoryInitializer;
import com.google.common.collect.ImmutableList;

public class FbandroidFragmentFactoryInitializer
  implements IFragmentFactoryInitializer
{
  public ImmutableList<IFragmentFactory> a()
  {
    return ImmutableList.a(new FbandroidFragmentFactoryInitializer.AppCenterBrowseFragmentFactory(null), new FbandroidFragmentFactoryInitializer.AppCenterDetailFragmentFactory(this, null), new FbandroidFragmentFactoryInitializer.FacewebFragmentFactory(null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FbandroidFragmentFactoryInitializer
 * JD-Core Version:    0.6.0
 */
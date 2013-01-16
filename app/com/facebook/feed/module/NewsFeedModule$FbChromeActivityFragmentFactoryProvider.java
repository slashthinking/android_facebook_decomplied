package com.facebook.feed.module;

import com.facebook.feed.activity.FbChromeActivityFragmentFactory;
import com.facebook.fragment.IFragmentFactoryInitializer;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$FbChromeActivityFragmentFactoryProvider extends AbstractProvider<FbChromeActivityFragmentFactory>
{
  private NewsFeedModule$FbChromeActivityFragmentFactoryProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FbChromeActivityFragmentFactory a()
  {
    return new FbChromeActivityFragmentFactory(c(IFragmentFactoryInitializer.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FbChromeActivityFragmentFactoryProvider
 * JD-Core Version:    0.6.0
 */
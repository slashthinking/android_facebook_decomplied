package com.facebook.feed.activity;

import com.facebook.fragment.IFragmentFactory;
import com.facebook.fragment.IFragmentFactoryInitializer;
import com.google.common.collect.ImmutableList;

public class NewsFeedFragmentFactoryInitializer
  implements IFragmentFactoryInitializer
{
  public ImmutableList<IFragmentFactory> a()
  {
    return ImmutableList.a(new NewsFeedFragmentFactoryInitializer.NewsFeedFragmentFactory(null), new NewsFeedFragmentFactoryInitializer.PermalinkFragmentFactory(null), new NewsFeedFragmentFactoryInitializer.ProfileListFragmentFactory(null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.activity.NewsFeedFragmentFactoryInitializer
 * JD-Core Version:    0.6.0
 */
package com.facebook.feed.module;

import com.facebook.feed.util.composer.UniqueRequestIdGenerator;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$UniqueRequestIdGeneratorProvider extends AbstractProvider<UniqueRequestIdGenerator>
{
  private NewsFeedModule$UniqueRequestIdGeneratorProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public UniqueRequestIdGenerator a()
  {
    return new UniqueRequestIdGenerator();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.UniqueRequestIdGeneratorProvider
 * JD-Core Version:    0.6.0
 */
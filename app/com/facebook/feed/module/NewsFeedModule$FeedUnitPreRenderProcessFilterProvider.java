package com.facebook.feed.module;

import com.facebook.feed.server.FeedUnitPreRenderProcessFilter;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$FeedUnitPreRenderProcessFilterProvider extends AbstractProvider<FeedUnitPreRenderProcessFilter>
{
  private NewsFeedModule$FeedUnitPreRenderProcessFilterProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FeedUnitPreRenderProcessFilter a()
  {
    return new FeedUnitPreRenderProcessFilter((FeedLinkifyUtil)b(FeedLinkifyUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FeedUnitPreRenderProcessFilterProvider
 * JD-Core Version:    0.6.0
 */
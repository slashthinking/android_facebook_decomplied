package com.facebook.feed.module;

import com.facebook.feed.cache.NFCacheServiceHandler;
import com.facebook.feed.cache.NFCacheServicePreprocessFilter;
import com.facebook.feed.db.NFDbServiceHandler;
import com.facebook.feed.server.FeedUnitPreRenderProcessFilter;
import com.facebook.feed.server.NewsFeedFilterHandler;
import com.facebook.feed.server.NewsFeedServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.FilterChainLink;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;

class NewsFeedModule$OrcaServiceHandlerForNewsFeedQueueProvider extends AbstractProvider<OrcaServiceHandler>
{
  private NewsFeedModule$OrcaServiceHandlerForNewsFeedQueueProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return new FilterChainLink((OrcaServiceHandler.Filter)b(NFCacheServiceHandler.class), new FilterChainLink((OrcaServiceHandler.Filter)b(FeedUnitPreRenderProcessFilter.class), new FilterChainLink(new NFCacheServicePreprocessFilter(), new FilterChainLink((OrcaServiceHandler.Filter)b(NFDbServiceHandler.class), new FilterChainLink((OrcaServiceHandler.Filter)b(NewsFeedFilterHandler.class), (OrcaServiceHandler)b(NewsFeedServiceHandler.class))))));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.OrcaServiceHandlerForNewsFeedQueueProvider
 * JD-Core Version:    0.6.0
 */
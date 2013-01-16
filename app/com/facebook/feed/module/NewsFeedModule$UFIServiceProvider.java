package com.facebook.feed.module;

import com.facebook.feed.protocol.UFIService;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;

class NewsFeedModule$UFIServiceProvider extends AbstractProvider<UFIService>
{
  private NewsFeedModule$UFIServiceProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public UFIService a()
  {
    return new UFIService((OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.UFIServiceProvider
 * JD-Core Version:    0.6.0
 */
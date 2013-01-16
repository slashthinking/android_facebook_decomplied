package com.facebook.feed.server;

import com.facebook.feed.protocol.FetchNewsFeedResult;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.FeedHomeStories;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnit;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import java.util.Iterator;
import java.util.List;

public class FeedUnitPreRenderProcessFilter
  implements OrcaServiceHandler.Filter
{
  private final FeedLinkifyUtil a;

  public FeedUnitPreRenderProcessFilter(FeedLinkifyUtil paramFeedLinkifyUtil)
  {
    this.a = paramFeedLinkifyUtil;
  }

  private void a(FetchNewsFeedResult paramFetchNewsFeedResult)
  {
    if ((paramFetchNewsFeedResult == null) || (paramFetchNewsFeedResult.c == null) || (paramFetchNewsFeedResult.c.feedUnitEdges == null));
    while (true)
    {
      return;
      Iterator localIterator = paramFetchNewsFeedResult.c.feedUnitEdges.iterator();
      while (localIterator.hasNext())
      {
        FeedUnit localFeedUnit = ((FeedUnitEdge)localIterator.next()).story;
        if ((localFeedUnit instanceof FeedStory))
        {
          this.a.a((FeedStory)localFeedUnit);
          continue;
        }
        if (!(localFeedUnit instanceof PagesYouMayLikeFeedUnit))
          continue;
        this.a.a((PagesYouMayLikeFeedUnit)localFeedUnit);
      }
    }
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = paramOperationParams.a();
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    if ((localOperationResult.c()) && (FeedUtils.a(str)))
      a((FetchNewsFeedResult)localOperationResult.h());
    return localOperationResult;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.server.FeedUnitPreRenderProcessFilter
 * JD-Core Version:    0.6.0
 */
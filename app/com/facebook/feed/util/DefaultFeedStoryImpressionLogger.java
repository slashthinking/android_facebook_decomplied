package com.facebook.feed.util;

import android.content.Context;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.protocol.MarkImpressionsLoggedParams;
import com.facebook.feed.protocol.MarkImpressionsLoggedParams.Builder;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnitItem;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowItem;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.orca.common.http.OrcaHttpClient;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.google.common.collect.ObjectArrays;
import java.util.Iterator;
import java.util.List;

public class DefaultFeedStoryImpressionLogger
  implements IFeedStoryImpressionLogger
{
  private final Context a;
  private final OrcaHttpClient b;
  private final AnalyticsLogger c;
  private final NewsFeedAnalyticsEventBuilder d;
  private final AndroidThreadUtil e;
  private final OrcaServiceOperationFactory f;

  public DefaultFeedStoryImpressionLogger(Context paramContext, OrcaHttpClient paramOrcaHttpClient, AnalyticsLogger paramAnalyticsLogger, NewsFeedAnalyticsEventBuilder paramNewsFeedAnalyticsEventBuilder, AndroidThreadUtil paramAndroidThreadUtil, OrcaServiceOperationFactory paramOrcaServiceOperationFactory)
  {
    this.a = paramContext;
    this.b = paramOrcaHttpClient;
    this.c = paramAnalyticsLogger;
    this.d = paramNewsFeedAnalyticsEventBuilder;
    this.e = paramAndroidThreadUtil;
    this.f = paramOrcaServiceOperationFactory;
  }

  public void a(PagesYouMayLikeFeedUnit paramPagesYouMayLikeFeedUnit)
  {
    if ((paramPagesYouMayLikeFeedUnit == null) || (paramPagesYouMayLikeFeedUnit.items == null) || (paramPagesYouMayLikeFeedUnit.z()));
    while (true)
    {
      return;
      Iterator localIterator = paramPagesYouMayLikeFeedUnit.items.iterator();
      while (localIterator.hasNext())
      {
        PagesYouMayLikeFeedUnitItem localPagesYouMayLikeFeedUnitItem = (PagesYouMayLikeFeedUnitItem)localIterator.next();
        HoneyClientEvent localHoneyClientEvent = this.d.d(localPagesYouMayLikeFeedUnitItem.a());
        this.c.b(localHoneyClientEvent);
      }
    }
  }

  public void a(PeopleYouMayKnowFeedUnit paramPeopleYouMayKnowFeedUnit)
  {
    if ((paramPeopleYouMayKnowFeedUnit == null) || (paramPeopleYouMayKnowFeedUnit.a()));
    while (true)
    {
      return;
      int i = Math.min(paramPeopleYouMayKnowFeedUnit.suggestions.size(), 2);
      for (int j = 0; j < i; j++)
      {
        PeopleYouMayKnowItem localPeopleYouMayKnowItem = (PeopleYouMayKnowItem)paramPeopleYouMayKnowFeedUnit.suggestions.get(j);
        if (localPeopleYouMayKnowItem.a())
          continue;
        HoneyClientEvent localHoneyClientEvent = this.d.c(localPeopleYouMayKnowItem.c());
        this.c.b(localHoneyClientEvent);
        localPeopleYouMayKnowItem.b();
      }
      paramPeopleYouMayKnowFeedUnit.b();
    }
  }

  public void a(Sponsorable paramSponsorable)
  {
    List localList = paramSponsorable.x();
    if ((localList == null) || (localList.isEmpty()) || (paramSponsorable.z()));
    while (true)
    {
      return;
      if ((paramSponsorable instanceof FeedStory))
      {
        MarkImpressionsLoggedParams localMarkImpressionsLoggedParams = MarkImpressionsLoggedParams.a().a(paramSponsorable.getCacheId()).a(paramSponsorable.getType()).a();
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("markImpressionLoggedParams", localMarkImpressionsLoggedParams);
        OrcaServiceOperationFactory.OrcaServiceOperation localOrcaServiceOperation = this.f.a("mark_impression_logged", localBundle);
        localOrcaServiceOperation.a(true);
        localOrcaServiceOperation.d();
      }
      new DefaultFeedStoryImpressionLogger.1(this).execute(localList.toArray(ObjectArrays.a(String.class, localList.size())));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.DefaultFeedStoryImpressionLogger
 * JD-Core Version:    0.6.0
 */
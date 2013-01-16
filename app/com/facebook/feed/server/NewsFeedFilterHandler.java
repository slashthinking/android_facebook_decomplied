package com.facebook.feed.server;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.feed.model.FeedRowType;
import com.facebook.feed.protocol.FetchNewsFeedResult;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.FeedHomeStories;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.PlatformApplication;
import com.facebook.graphql.model.PlatformNativeApplicationConfig;
import com.facebook.graphql.model.RecommendedApplicationsFeedUnit;
import com.facebook.graphql.model.RecommendedApplicationsFeedUnitBuilder;
import com.facebook.graphql.model.RecommendedApplicationsFeedUnitItem;
import com.facebook.graphql.model.UnknownFeedUnit;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;

public class NewsFeedFilterHandler
  implements OrcaServiceHandler.Filter
{
  private final Class<?> a = NewsFeedFilterHandler.class;
  private final Context b;
  private final FbErrorReporter c;

  public NewsFeedFilterHandler(@FromApplication Context paramContext, FbErrorReporter paramFbErrorReporter)
  {
    this.c = paramFbErrorReporter;
    this.b = paramContext.getApplicationContext();
  }

  private FeedStory a(FeedStory paramFeedStory)
  {
    int i = paramFeedStory.u();
    if (i >= 2)
    {
      Class localClass = this.a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(i);
      arrayOfObject[1] = Integer.valueOf(2);
      Log.b(localClass, StringLocaleUtil.a("Dropped a story of height %s. Max: %s", arrayOfObject));
      paramFeedStory = null;
    }
    return paramFeedStory;
  }

  private FeedUnitEdge a(FeedUnitEdge paramFeedUnitEdge)
  {
    if (paramFeedUnitEdge.b() == null)
      if (!BuildConstants.a());
    while (true)
    {
      return paramFeedUnitEdge;
      paramFeedUnitEdge = null;
      continue;
      if ((paramFeedUnitEdge.story instanceof PeopleYouMayKnowFeedUnit))
      {
        paramFeedUnitEdge = null;
        continue;
      }
      if ((paramFeedUnitEdge.story instanceof RecommendedApplicationsFeedUnit));
      for (Object localObject = a((RecommendedApplicationsFeedUnit)paramFeedUnitEdge.story); ; localObject = a((FeedStory)paramFeedUnitEdge.story))
      {
        if (localObject == paramFeedUnitEdge.story)
          break label97;
        if (localObject != null)
          break label148;
        paramFeedUnitEdge = null;
        break;
        if (!(paramFeedUnitEdge.story instanceof FeedStory))
          break label99;
      }
      label97: continue;
      label99: if ((paramFeedUnitEdge.story instanceof PagesYouMayLikeFeedUnit))
      {
        if (((PagesYouMayLikeFeedUnit)paramFeedUnitEdge.story).a())
          continue;
        paramFeedUnitEdge = null;
        continue;
      }
      if ((!(paramFeedUnitEdge.story instanceof UnknownFeedUnit)) || (BuildConstants.a()))
        continue;
      paramFeedUnitEdge = null;
      continue;
      label148: paramFeedUnitEdge = new FeedUnitEdge((FeedUnit)localObject, paramFeedUnitEdge.dedupKey, paramFeedUnitEdge.sortKey);
    }
  }

  private RecommendedApplicationsFeedUnit a(RecommendedApplicationsFeedUnit paramRecommendedApplicationsFeedUnit)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    if ((paramRecommendedApplicationsFeedUnit.apps == null) || (paramRecommendedApplicationsFeedUnit.apps.isEmpty()))
      paramRecommendedApplicationsFeedUnit = null;
    while (true)
    {
      return paramRecommendedApplicationsFeedUnit;
      Iterator localIterator = paramRecommendedApplicationsFeedUnit.apps.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        RecommendedApplicationsFeedUnitItem localRecommendedApplicationsFeedUnitItem = (RecommendedApplicationsFeedUnitItem)localIterator.next();
        if ((localRecommendedApplicationsFeedUnitItem.sponsoredData != null) && (a(localRecommendedApplicationsFeedUnitItem.application)));
        for (int j = 1; ; j = i)
        {
          i = j;
          break;
          localBuilder.b(localRecommendedApplicationsFeedUnitItem);
        }
      }
      if (i == 0)
        continue;
      RecommendedApplicationsFeedUnitBuilder localRecommendedApplicationsFeedUnitBuilder = new RecommendedApplicationsFeedUnitBuilder(paramRecommendedApplicationsFeedUnit).a(localBuilder.b());
      if (localRecommendedApplicationsFeedUnitBuilder.d().isEmpty())
      {
        paramRecommendedApplicationsFeedUnit = null;
        continue;
      }
      paramRecommendedApplicationsFeedUnit = localRecommendedApplicationsFeedUnitBuilder.e();
    }
  }

  private OperationResult a(FetchNewsFeedResult paramFetchNewsFeedResult)
  {
    ImmutableList.Builder localBuilder;
    int i;
    FeedUnitEdge localFeedUnitEdge2;
    if ((paramFetchNewsFeedResult != null) && (paramFetchNewsFeedResult.c != null) && (paramFetchNewsFeedResult.c.feedUnitEdges != null))
    {
      localBuilder = ImmutableList.e();
      Iterator localIterator = paramFetchNewsFeedResult.c.feedUnitEdges.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        FeedUnitEdge localFeedUnitEdge1 = (FeedUnitEdge)localIterator.next();
        localFeedUnitEdge2 = a(localFeedUnitEdge1);
        if (localFeedUnitEdge2 == localFeedUnitEdge1)
          break label163;
      }
    }
    label163: for (int j = 1; ; j = i)
    {
      if (localFeedUnitEdge2 != null)
      {
        FeedUnit localFeedUnit = localFeedUnitEdge2.b();
        if (FeedUtils.a(localFeedUnit) == FeedRowType.UNKNOWN)
          a(localFeedUnit);
        localBuilder.b(localFeedUnitEdge2);
      }
      i = j;
      break;
      if (i != 0)
        paramFetchNewsFeedResult = new FetchNewsFeedResult(paramFetchNewsFeedResult.b, localBuilder.b(), paramFetchNewsFeedResult.c.pageInfo, paramFetchNewsFeedResult.e(), paramFetchNewsFeedResult.f());
      return OperationResult.a(paramFetchNewsFeedResult);
    }
  }

  private void a(FeedUnit paramFeedUnit)
  {
    FbErrorReporter localFbErrorReporter = this.c;
    Object[] arrayOfObject = new Object[1];
    if (paramFeedUnit == null);
    for (String str = "null"; ; str = paramFeedUnit.getClass().getSimpleName())
    {
      arrayOfObject[0] = str;
      localFbErrorReporter.a("NewsFeedStoryNotSupported", StringLocaleUtil.a("The object isn't supported: [FeedUnit: %s]", arrayOfObject), false);
      return;
    }
  }

  private boolean a(PlatformApplication paramPlatformApplication)
  {
    int i = 1;
    PackageManager localPackageManager;
    if ((paramPlatformApplication != null) && (paramPlatformApplication.androidAppConfig != null))
      localPackageManager = this.b.getPackageManager();
    while (true)
    {
      try
      {
        localPackageManager.getPackageInfo(paramPlatformApplication.androidAppConfig.packageName, 1);
        return i;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        i = 0;
        continue;
      }
      i = 0;
    }
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = paramOperationParams.a();
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    if ((localOperationResult.c()) && (FeedUtils.a(str)))
      localOperationResult = a((FetchNewsFeedResult)localOperationResult.h());
    return localOperationResult;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.server.NewsFeedFilterHandler
 * JD-Core Version:    0.6.0
 */
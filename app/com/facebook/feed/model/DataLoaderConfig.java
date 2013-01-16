package com.facebook.feed.model;

import android.os.Bundle;
import com.facebook.feed.data.AbstractDataLoader.FetchFeedDirection;
import com.facebook.feed.data.PagedFeedUnitCollection;
import com.facebook.feed.protocol.FetchFriendListFeedParamsBuilder;
import com.facebook.feed.protocol.FetchNewsFeedParams;
import com.facebook.feed.protocol.FetchNewsFeedParamsBuilder;
import com.facebook.orca.server.DataFreshnessParam;
import com.google.common.base.Preconditions;

public class DataLoaderConfig
{
  private final FeedType a;
  private final PagedFeedUnitCollection b;
  private final Bundle c;
  private final String d;

  public DataLoaderConfig(FeedType paramFeedType, PagedFeedUnitCollection paramPagedFeedUnitCollection, Bundle paramBundle, String paramString)
  {
    this.a = ((FeedType)Preconditions.checkNotNull(paramFeedType));
    this.b = ((PagedFeedUnitCollection)Preconditions.checkNotNull(paramPagedFeedUnitCollection));
    this.c = paramBundle;
    if (paramString == null)
      paramString = "fetchNewsFeedParams";
    this.d = paramString;
  }

  private boolean d()
  {
    return "fetchFriendListFeedParams".equals(this.d);
  }

  private boolean e()
  {
    return "fetchNewsFeedParams".equals(this.d);
  }

  public PagedFeedUnitCollection a()
  {
    return this.b;
  }

  public FetchNewsFeedParams a(AbstractDataLoader.FetchFeedDirection paramFetchFeedDirection, int paramInt, DataFreshnessParam paramDataFreshnessParam)
  {
    String str1 = null;
    String str2;
    DataFreshnessParam localDataFreshnessParam;
    if (paramFetchFeedDirection == AbstractDataLoader.FetchFeedDirection.BEFORE)
    {
      str2 = this.b.c();
      if (!d())
        break label90;
      localDataFreshnessParam = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
    }
    for (Object localObject = new FetchFriendListFeedParamsBuilder().a(localDataFreshnessParam).a(paramInt).a(this.a.c).c(str2).b(str1).b(); ; localObject = new FetchNewsFeedParamsBuilder().b(paramDataFreshnessParam).f(this.a.c).b(paramInt).d(str2).e(str1).c())
    {
      return localObject;
      str1 = this.b.d();
      str2 = null;
      break;
      label90: if (paramDataFreshnessParam != null)
        continue;
      paramDataFreshnessParam = DataFreshnessParam.STALE_DATA_OKAY;
    }
  }

  public String a(AbstractDataLoader.FetchFeedDirection paramFetchFeedDirection)
  {
    String str;
    if (e())
      if (paramFetchFeedDirection == AbstractDataLoader.FetchFeedDirection.AFTER)
        str = "fetch_news_feed_after";
    while (true)
    {
      return str;
      str = "fetch_news_feed_before";
      continue;
      if (paramFetchFeedDirection == AbstractDataLoader.FetchFeedDirection.AFTER)
      {
        str = "fetch_friend_list_feed_after";
        continue;
      }
      str = "fetch_friend_list_feed_before";
    }
  }

  public Bundle b()
  {
    return this.c;
  }

  public String c()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.model.DataLoaderConfig
 * JD-Core Version:    0.6.0
 */
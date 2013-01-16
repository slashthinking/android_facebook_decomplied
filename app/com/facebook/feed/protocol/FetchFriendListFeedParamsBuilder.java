package com.facebook.feed.protocol;

import com.facebook.feed.model.NewsFeedType;
import com.facebook.orca.server.DataFreshnessParam;
import com.google.common.base.Preconditions;

public class FetchFriendListFeedParamsBuilder extends FetchNewsFeedParamsBuilder
{
  private String a;

  public FetchFriendListFeedParamsBuilder a(int paramInt)
  {
    super.b(paramInt);
    return this;
  }

  public FetchFriendListFeedParamsBuilder a(NewsFeedType paramNewsFeedType)
  {
    super.b(paramNewsFeedType);
    return this;
  }

  public FetchFriendListFeedParamsBuilder a(FetchFriendListFeedParams paramFetchFriendListFeedParams)
  {
    super.a(paramFetchFriendListFeedParams);
    this.a = paramFetchFriendListFeedParams.a();
    return this;
  }

  public FetchFriendListFeedParamsBuilder a(DataFreshnessParam paramDataFreshnessParam)
  {
    super.b(paramDataFreshnessParam);
    return this;
  }

  public FetchFriendListFeedParamsBuilder a(String paramString)
  {
    this.a = ((String)Preconditions.checkNotNull(paramString));
    return this;
  }

  public FetchNewsFeedParamsBuilder a(FetchNewsFeedParams.ViewMode paramViewMode)
  {
    super.a(paramViewMode);
    return this;
  }

  public String a()
  {
    return this.a;
  }

  public FetchFriendListFeedParams b()
  {
    return new FetchFriendListFeedParams(this);
  }

  public FetchFriendListFeedParamsBuilder b(String paramString)
  {
    super.e(paramString);
    return this;
  }

  public FetchFriendListFeedParamsBuilder c(String paramString)
  {
    super.d(paramString);
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchFriendListFeedParamsBuilder
 * JD-Core Version:    0.6.0
 */
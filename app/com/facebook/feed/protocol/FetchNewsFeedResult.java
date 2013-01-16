package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.FeedHomeStories;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class FetchNewsFeedResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchNewsFeedResult> CREATOR;
  public static final FetchNewsFeedResult a = new FetchNewsFeedResult(null, new FeedHomeStories(ImmutableList.d(), new GraphQLPageInfo(null, null, false, false)), DataFreshnessResult.NO_DATA, -1L);
  public final FetchNewsFeedParams b;
  public final FeedHomeStories c;

  static
  {
    CREATOR = new FetchNewsFeedResult.1();
  }

  public FetchNewsFeedResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.b = ((FetchNewsFeedParams)paramParcel.readParcelable(FetchNewsFeedParams.class.getClassLoader()));
    this.c = ((FeedHomeStories)paramParcel.readParcelable(FeedHomeStories.class.getClassLoader()));
  }

  public FetchNewsFeedResult(FetchNewsFeedParams paramFetchNewsFeedParams, FeedHomeStories paramFeedHomeStories, DataFreshnessResult paramDataFreshnessResult, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.b = paramFetchNewsFeedParams;
    this.c = paramFeedHomeStories;
  }

  public FetchNewsFeedResult(FetchNewsFeedParams paramFetchNewsFeedParams, List<FeedUnitEdge> paramList, GraphQLPageInfo paramGraphQLPageInfo, DataFreshnessResult paramDataFreshnessResult, long paramLong)
  {
    this(paramFetchNewsFeedParams, new FeedHomeStories(paramList, paramGraphQLPageInfo), paramDataFreshnessResult, paramLong);
  }

  public List<FeedUnitEdge> a()
  {
    if (this.c == null);
    for (List localList = null; ; localList = this.c.feedUnitEdges)
      return localList;
  }

  public GraphQLPageInfo b()
  {
    if (this.c == null);
    for (GraphQLPageInfo localGraphQLPageInfo = null; ; localGraphQLPageInfo = this.c.pageInfo)
      return localGraphQLPageInfo;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeParcelable(this.c, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchNewsFeedResult
 * JD-Core Version:    0.6.0
 */
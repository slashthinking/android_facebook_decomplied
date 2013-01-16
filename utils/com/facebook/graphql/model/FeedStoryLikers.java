package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class FeedStoryLikers
  implements Parcelable
{
  public static final FeedStoryLikers a = new FeedStoryLikers();

  @JsonProperty("count")
  public final int count;

  @JsonProperty("nodes")
  public final List<GraphQLProfile> likers;

  @JsonProperty("page_info")
  public final GraphQLPageInfo pageInfo;

  private FeedStoryLikers()
  {
    this.count = 0;
    this.likers = ImmutableList.d();
    this.pageInfo = GraphQLPageInfo.a;
  }

  public FeedStoryLikers(int paramInt)
  {
    this(paramInt, null, null);
  }

  public FeedStoryLikers(int paramInt, List<GraphQLProfile> paramList, GraphQLPageInfo paramGraphQLPageInfo)
  {
    this.count = paramInt;
    if (paramList == null)
    {
      this.likers = ImmutableList.d();
      if (paramGraphQLPageInfo != null)
        break label40;
    }
    label40: for (this.pageInfo = GraphQLPageInfo.a; ; this.pageInfo = paramGraphQLPageInfo)
    {
      return;
      this.likers = paramList;
      break;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedStoryLikers
 * JD-Core Version:    0.6.2
 */
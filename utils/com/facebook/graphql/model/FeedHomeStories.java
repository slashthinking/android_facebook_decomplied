package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class FeedHomeStories
  implements Parcelable
{

  @JsonProperty("edges")
  public final List<FeedUnitEdge> feedUnitEdges;

  @JsonProperty("page_info")
  public final GraphQLPageInfo pageInfo;

  protected FeedHomeStories()
  {
    this.feedUnitEdges = null;
    this.pageInfo = null;
  }

  public FeedHomeStories(List<FeedUnitEdge> paramList, GraphQLPageInfo paramGraphQLPageInfo)
  {
    this.feedUnitEdges = paramList;
    this.pageInfo = paramGraphQLPageInfo;
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
 * Qualified Name:     com.facebook.graphql.model.FeedHomeStories
 * JD-Core Version:    0.6.2
 */
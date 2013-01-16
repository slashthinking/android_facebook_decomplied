package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class FeedStoryComments
  implements Parcelable
{
  public static final FeedStoryComments a = new FeedStoryComments();
  public static final Comparator<FeedComment> b = new FeedStoryComments.1();

  @JsonProperty("nodes")
  @JsonDeserialize(as=FeedStoryComments.FeedCommentTreeSet.class)
  public final TreeSet<FeedComment> comments;

  @JsonProperty("count")
  public final int count;

  @JsonProperty("page_info")
  public final GraphQLPageInfo pageInfo;

  private FeedStoryComments()
  {
    this.count = 0;
    this.comments = FeedStoryComments.FeedCommentTreeSet.a;
    this.pageInfo = GraphQLPageInfo.a;
  }

  public FeedStoryComments(int paramInt)
  {
    this(paramInt, null, null);
  }

  public FeedStoryComments(int paramInt, Set<FeedComment> paramSet, GraphQLPageInfo paramGraphQLPageInfo)
  {
    this.count = paramInt;
    if (paramSet != null)
    {
      FeedStoryComments.FeedCommentTreeSet localFeedCommentTreeSet = new FeedStoryComments.FeedCommentTreeSet();
      localFeedCommentTreeSet.addAll(paramSet);
      this.comments = localFeedCommentTreeSet;
      if (paramGraphQLPageInfo == null)
        break label55;
    }
    label55: for (this.pageInfo = paramGraphQLPageInfo; ; this.pageInfo = GraphQLPageInfo.a)
    {
      return;
      this.comments = FeedStoryComments.FeedCommentTreeSet.a;
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
 * Qualified Name:     com.facebook.graphql.model.FeedStoryComments
 * JD-Core Version:    0.6.2
 */
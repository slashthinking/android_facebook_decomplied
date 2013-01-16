package com.facebook.feed.cache;

import com.facebook.feed.model.FeedType;
import com.facebook.feed.protocol.FetchFeedbackResult;
import com.facebook.feed.protocol.FetchNewsFeedParams;
import com.facebook.feed.protocol.FetchNewsFeedResult;
import com.facebook.feed.protocol.FetchNodeListParams;
import com.facebook.feed.protocol.FetchSingleStoryResult;
import com.facebook.feed.util.FetchFeedbackType;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLProfile;
import java.util.ArrayList;
import java.util.List;

public abstract interface NewsFeedCache
{
  public abstract int a(FeedType paramFeedType, int paramInt);

  public abstract FetchFeedbackResult a(String paramString1, String paramString2, FetchNodeListParams paramFetchNodeListParams);

  public abstract FetchNewsFeedResult a(FeedType paramFeedType, FetchNewsFeedParams paramFetchNewsFeedParams);

  public abstract FetchSingleStoryResult a(String paramString);

  public abstract ArrayList<StoryUpdate> a(long paramLong);

  public abstract List<String> a(FeedType paramFeedType, String paramString);

  public abstract void a();

  public abstract void a(FeedType paramFeedType, FetchNewsFeedResult paramFetchNewsFeedResult);

  public abstract void a(FetchSingleStoryResult paramFetchSingleStoryResult, String paramString, FetchFeedbackType paramFetchFeedbackType);

  public abstract void a(Feedback paramFeedback, FetchFeedbackType paramFetchFeedbackType, String paramString);

  public abstract void a(Feedback paramFeedback, String paramString);

  public abstract void a(String paramString, FeedComment paramFeedComment);

  public abstract void a(String paramString, GraphQLProfile paramGraphQLProfile, boolean paramBoolean);

  public abstract void a(String paramString1, String paramString2, GraphQLProfile paramGraphQLProfile, boolean paramBoolean);

  public abstract void a(String paramString, boolean paramBoolean);

  public abstract boolean a(FeedType paramFeedType);

  public abstract FetchSingleStoryResult b(String paramString);

  public abstract FetchSingleStoryResult c(String paramString);

  public abstract FetchFeedbackResult d(String paramString);

  public abstract Feedback e(String paramString);

  public abstract void f(String paramString);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.NewsFeedCache
 * JD-Core Version:    0.6.0
 */
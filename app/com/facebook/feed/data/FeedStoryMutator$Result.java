package com.facebook.feed.data;

import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedStory;

public class FeedStoryMutator$Result
{
  private final FeedStory a;
  private final FeedStory b;
  private final FeedComment c;

  public FeedStoryMutator$Result(FeedStory paramFeedStory1, FeedStory paramFeedStory2)
  {
    this(paramFeedStory1, paramFeedStory2, null);
  }

  public FeedStoryMutator$Result(FeedStory paramFeedStory1, FeedStory paramFeedStory2, FeedComment paramFeedComment)
  {
    this.a = paramFeedStory1;
    this.b = paramFeedStory2;
    this.c = paramFeedComment;
  }

  public FeedStory a()
  {
    return this.a;
  }

  public FeedStory b()
  {
    return this.b;
  }

  public FeedComment c()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.FeedStoryMutator.Result
 * JD-Core Version:    0.6.0
 */
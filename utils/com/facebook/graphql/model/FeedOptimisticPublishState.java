package com.facebook.graphql.model;

public enum FeedOptimisticPublishState
{
  static
  {
    FAILED = new FeedOptimisticPublishState("FAILED", 3);
    FeedOptimisticPublishState[] arrayOfFeedOptimisticPublishState = new FeedOptimisticPublishState[4];
    arrayOfFeedOptimisticPublishState[0] = NONE;
    arrayOfFeedOptimisticPublishState[1] = POSTING;
    arrayOfFeedOptimisticPublishState[2] = SUCCESS;
    arrayOfFeedOptimisticPublishState[3] = FAILED;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedOptimisticPublishState
 * JD-Core Version:    0.6.2
 */
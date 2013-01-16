package com.facebook.graphql.model;

public class NotificationStoryEdge$Builder
{
  private FeedStory a = null;
  private String b = null;

  public Builder a(FeedStory paramFeedStory)
  {
    this.a = paramFeedStory;
    return this;
  }

  public Builder a(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public NotificationStoryEdge a()
  {
    return new NotificationStoryEdge(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.NotificationStoryEdge.Builder
 * JD-Core Version:    0.6.2
 */
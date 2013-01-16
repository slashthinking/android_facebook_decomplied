package com.facebook.feed.cache;

public class FeedStoryPartial$Builder
{
  private String a;
  private long b;
  private boolean c;

  public Builder a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }

  public Builder a(FeedStoryPartial paramFeedStoryPartial)
  {
    this.a = paramFeedStoryPartial.c;
    this.b = paramFeedStoryPartial.d;
    this.c = paramFeedStoryPartial.b;
    return this;
  }

  public Builder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public Builder a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }

  public FeedStoryPartial a()
  {
    return new FeedStoryPartial(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.FeedStoryPartial.Builder
 * JD-Core Version:    0.6.0
 */
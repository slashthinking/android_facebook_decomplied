package com.facebook.feed.cache;

public abstract class FeedUnitPartial
{
  public final String c;
  public final long d;

  public FeedUnitPartial(String paramString, long paramLong)
  {
    this.c = paramString;
    this.d = paramLong;
  }

  public FeedUnitPartial a(FeedUnitPartial paramFeedUnitPartial)
  {
    if (paramFeedUnitPartial == null)
      return this;
    if (paramFeedUnitPartial.d > this.d);
    while (true)
    {
      this = paramFeedUnitPartial;
      break;
      paramFeedUnitPartial = this;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.FeedUnitPartial
 * JD-Core Version:    0.6.0
 */
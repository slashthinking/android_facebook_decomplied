package com.facebook.feed.cache;

import com.facebook.debug.Assert;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.LinkedList;
import java.util.Map;

class DefaultNewsFeedCache$FeedSegmentsCache
{
  private final LinkedList<FeedSegment> a = Lists.b();
  private final Map<String, FeedSegment> b = Maps.a();
  private int c = 0;

  private void a(int paramInt)
  {
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      while (this.c > paramInt)
        a((FeedSegment)this.a.getLast());
    }
    if (!this.a.isEmpty())
      ((FeedSegment)this.a.getLast()).a(true);
  }

  private void c(FeedSegment paramFeedSegment)
  {
    this.b.put(paramFeedSegment.d(), paramFeedSegment);
    this.b.put(paramFeedSegment.c(), paramFeedSegment);
    this.c += paramFeedSegment.e();
  }

  private void d(FeedSegment paramFeedSegment)
  {
    this.b.remove(paramFeedSegment.d());
    this.b.remove(paramFeedSegment.c());
    this.c -= paramFeedSegment.e();
  }

  public FeedSegment a(String paramString)
  {
    FeedSegment localFeedSegment = (FeedSegment)this.b.get(paramString);
    if ((localFeedSegment != null) && (localFeedSegment.c().equals(paramString)));
    while (true)
    {
      return localFeedSegment;
      localFeedSegment = null;
    }
  }

  public void a(FeedSegment paramFeedSegment)
  {
    Preconditions.checkNotNull(paramFeedSegment);
    this.a.remove(paramFeedSegment);
    d(paramFeedSegment);
  }

  public boolean a()
  {
    return this.a.isEmpty();
  }

  public boolean a(String paramString, FeedSegment paramFeedSegment)
  {
    FeedSegment localFeedSegment = a(paramString);
    int i = 0;
    if (localFeedSegment == null);
    while (true)
    {
      return i;
      Assert.b(localFeedSegment.f());
      int j = this.a.indexOf(localFeedSegment);
      this.a.add(j + 1, paramFeedSegment);
      c(paramFeedSegment);
      localFeedSegment.a(false);
      paramFeedSegment.a(true);
      i = 1;
    }
  }

  public FeedSegment b(String paramString)
  {
    FeedSegment localFeedSegment = (FeedSegment)this.b.get(paramString);
    if ((localFeedSegment != null) && (localFeedSegment.d().equals(paramString)));
    while (true)
    {
      return localFeedSegment;
      localFeedSegment = null;
    }
  }

  public boolean b(FeedSegment paramFeedSegment)
  {
    if (!this.a.isEmpty());
    for (int i = 0; ; i = 1)
    {
      return i;
      Assert.b(this.b.isEmpty());
      this.a.add(paramFeedSegment);
      c(paramFeedSegment);
    }
  }

  public boolean b(String paramString, FeedSegment paramFeedSegment)
  {
    FeedSegment localFeedSegment = b(paramString);
    int i = 0;
    if (localFeedSegment == null);
    while (true)
    {
      return i;
      int j = this.a.indexOf(localFeedSegment);
      i = 0;
      if (j != 0)
        continue;
      this.a.add(j, paramFeedSegment);
      c(paramFeedSegment);
      i = 1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.DefaultNewsFeedCache.FeedSegmentsCache
 * JD-Core Version:    0.6.0
 */
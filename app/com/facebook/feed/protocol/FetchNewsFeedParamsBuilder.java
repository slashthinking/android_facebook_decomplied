package com.facebook.feed.protocol;

import com.facebook.feed.model.NewsFeedType;
import com.facebook.orca.server.DataFreshnessParam;
import com.google.common.base.Preconditions;

public class FetchNewsFeedParamsBuilder
{
  private DataFreshnessParam a;
  private NewsFeedType b;
  private int c;
  private String d;
  private String e;
  private FetchNewsFeedParams.ViewMode f = FetchNewsFeedParams.ViewMode.NORMAL;

  public FetchNewsFeedParamsBuilder a(FetchNewsFeedParams.ViewMode paramViewMode)
  {
    this.f = paramViewMode;
    return this;
  }

  public FetchNewsFeedParamsBuilder a(FetchNewsFeedParams paramFetchNewsFeedParams)
  {
    this.d = paramFetchNewsFeedParams.d();
    this.e = paramFetchNewsFeedParams.c();
    this.a = paramFetchNewsFeedParams.e();
    this.b = paramFetchNewsFeedParams.f();
    this.c = paramFetchNewsFeedParams.b();
    this.f = paramFetchNewsFeedParams.g();
    return this;
  }

  public FetchNewsFeedParamsBuilder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }

  public FetchNewsFeedParamsBuilder b(NewsFeedType paramNewsFeedType)
  {
    this.b = paramNewsFeedType;
    return this;
  }

  public FetchNewsFeedParamsBuilder b(DataFreshnessParam paramDataFreshnessParam)
  {
    this.a = paramDataFreshnessParam;
    return this;
  }

  public FetchNewsFeedParams c()
  {
    Preconditions.checkNotNull(this.a);
    return new FetchNewsFeedParams(this);
  }

  public FetchNewsFeedParams.ViewMode d()
  {
    return this.f;
  }

  public FetchNewsFeedParamsBuilder d(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public FetchNewsFeedParamsBuilder e(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public DataFreshnessParam e()
  {
    return this.a;
  }

  public NewsFeedType f()
  {
    if (this.b == null);
    for (NewsFeedType localNewsFeedType = NewsFeedType.MOST_RECENT; ; localNewsFeedType = this.b)
      return localNewsFeedType;
  }

  public FetchNewsFeedParamsBuilder f(String paramString)
  {
    this.b = NewsFeedType.getNewsFeedTypeByValue(paramString);
    return this;
  }

  public int g()
  {
    return this.c;
  }

  public String h()
  {
    return this.d;
  }

  public String i()
  {
    return this.e;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchNewsFeedParamsBuilder
 * JD-Core Version:    0.6.0
 */
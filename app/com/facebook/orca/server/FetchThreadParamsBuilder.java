package com.facebook.orca.server;

public class FetchThreadParamsBuilder
{
  private ThreadCriteria a;
  private DataFreshnessParam b;
  private DataFreshnessParam c;
  private long d = -1L;
  private boolean e;
  private int f = 50;
  private long g = -1L;

  public FetchThreadParamsBuilder a(int paramInt)
  {
    this.f = paramInt;
    return this;
  }

  public FetchThreadParamsBuilder a(long paramLong)
  {
    this.d = paramLong;
    return this;
  }

  public FetchThreadParamsBuilder a(DataFreshnessParam paramDataFreshnessParam)
  {
    this.b = paramDataFreshnessParam;
    return this;
  }

  public FetchThreadParamsBuilder a(FetchThreadParams paramFetchThreadParams)
  {
    this.a = paramFetchThreadParams.a();
    this.b = paramFetchThreadParams.b();
    this.c = paramFetchThreadParams.c();
    this.e = paramFetchThreadParams.d();
    this.d = paramFetchThreadParams.e();
    this.f = paramFetchThreadParams.f();
    this.g = paramFetchThreadParams.g();
    return this;
  }

  public FetchThreadParamsBuilder a(ThreadCriteria paramThreadCriteria)
  {
    this.a = paramThreadCriteria;
    return this;
  }

  public FetchThreadParamsBuilder a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }

  public ThreadCriteria a()
  {
    return this.a;
  }

  public DataFreshnessParam b()
  {
    return this.b;
  }

  public FetchThreadParamsBuilder b(long paramLong)
  {
    this.g = paramLong;
    return this;
  }

  public FetchThreadParamsBuilder b(DataFreshnessParam paramDataFreshnessParam)
  {
    this.c = paramDataFreshnessParam;
    return this;
  }

  public DataFreshnessParam c()
  {
    if (this.c == null);
    for (DataFreshnessParam localDataFreshnessParam = this.b; ; localDataFreshnessParam = this.c)
      return localDataFreshnessParam;
  }

  public boolean d()
  {
    return this.e;
  }

  public long e()
  {
    return this.d;
  }

  public int f()
  {
    return this.f;
  }

  public long g()
  {
    return this.g;
  }

  public FetchThreadParams h()
  {
    return new FetchThreadParams(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchThreadParamsBuilder
 * JD-Core Version:    0.6.0
 */
package com.facebook.orca.server;

import com.facebook.orca.threads.FolderName;

public class FetchThreadListParamsBuilder
{
  private DataFreshnessParam a;
  private FolderName b;
  private long c = -1L;
  private int d = 20;
  private boolean e;

  public DataFreshnessParam a()
  {
    return this.a;
  }

  public FetchThreadListParamsBuilder a(long paramLong)
  {
    this.c = paramLong;
    return this;
  }

  public FetchThreadListParamsBuilder a(DataFreshnessParam paramDataFreshnessParam)
  {
    this.a = paramDataFreshnessParam;
    return this;
  }

  public FetchThreadListParamsBuilder a(FetchThreadListParams paramFetchThreadListParams)
  {
    this.a = paramFetchThreadListParams.a();
    this.b = paramFetchThreadListParams.b();
    this.c = paramFetchThreadListParams.c();
    this.d = paramFetchThreadListParams.d();
    this.e = paramFetchThreadListParams.e();
    return this;
  }

  public FetchThreadListParamsBuilder a(FolderName paramFolderName)
  {
    this.b = paramFolderName;
    return this;
  }

  public FetchThreadListParamsBuilder a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }

  public FolderName b()
  {
    return this.b;
  }

  public long c()
  {
    return this.c;
  }

  public int d()
  {
    return this.d;
  }

  public boolean e()
  {
    return this.e;
  }

  public FetchThreadListParams f()
  {
    return new FetchThreadListParams(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchThreadListParamsBuilder
 * JD-Core Version:    0.6.0
 */
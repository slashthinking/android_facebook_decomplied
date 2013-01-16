package com.facebook.notifications.protocol;

import com.facebook.orca.server.DataFreshnessParam;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;

public class FetchGraphQLNotificationsParamsBuilder
{
  private DataFreshnessParam a;
  private int b = -1;
  private String c;
  private String d;
  private long e = -1L;
  private List<String> f = Lists.a();

  public FetchGraphQLNotificationsParamsBuilder a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }

  public FetchGraphQLNotificationsParamsBuilder a(long paramLong)
  {
    this.e = paramLong;
    return this;
  }

  public FetchGraphQLNotificationsParamsBuilder a(DataFreshnessParam paramDataFreshnessParam)
  {
    this.a = paramDataFreshnessParam;
    return this;
  }

  public FetchGraphQLNotificationsParamsBuilder a(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public FetchGraphQLNotificationsParamsBuilder a(List<String> paramList)
  {
    Preconditions.checkNotNull(paramList);
    this.f = paramList;
    return this;
  }

  public DataFreshnessParam a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public long e()
  {
    return this.e;
  }

  public List<String> f()
  {
    return this.f;
  }

  public FetchGraphQLNotificationsParams g()
  {
    Preconditions.checkNotNull(this.a);
    return new FetchGraphQLNotificationsParams(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.FetchGraphQLNotificationsParamsBuilder
 * JD-Core Version:    0.6.2
 */
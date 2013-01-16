package com.facebook.appcenter.cache;

import com.facebook.appcenter.graphql.model.AppList;
import com.facebook.appcenter.service.FetchAppListParams;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class AppListCache
{
  private final ConcurrentMap<Integer, AppList> a = new MapMaker().b(600L, TimeUnit.SECONDS).b(20).n();

  public AppList a(FetchAppListParams paramFetchAppListParams)
  {
    Preconditions.checkNotNull(paramFetchAppListParams);
    return (AppList)this.a.get(Integer.valueOf(paramFetchAppListParams.hashCode()));
  }

  public void a(FetchAppListParams paramFetchAppListParams, AppList paramAppList)
  {
    Preconditions.checkNotNull(paramAppList);
    Preconditions.checkNotNull(paramFetchAppListParams);
    this.a.put(Integer.valueOf(paramFetchAppListParams.hashCode()), paramAppList);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.cache.AppListCache
 * JD-Core Version:    0.6.0
 */
package com.facebook.appcenter.cache;

import com.facebook.appcenter.graphql.model.AppDetail;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class AppDetailCache
{
  private final ConcurrentMap<String, AppDetail> a = new MapMaker().b(300L, TimeUnit.SECONDS).b(100).n();

  public AppDetail a(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    return (AppDetail)this.a.get(paramString);
  }

  public void a(AppDetail paramAppDetail)
  {
    Preconditions.checkNotNull(paramAppDetail);
    Preconditions.checkNotNull(paramAppDetail.id);
    this.a.put(paramAppDetail.id, paramAppDetail);
  }

  public void b(String paramString)
  {
    this.a.remove(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.cache.AppDetailCache
 * JD-Core Version:    0.6.0
 */
package com.facebook.appcenter.service;

import android.os.Bundle;
import com.facebook.appcenter.cache.AppCategoryCache;
import com.facebook.appcenter.cache.AppDetailCache;
import com.facebook.appcenter.cache.AppListCache;
import com.facebook.appcenter.db.DbAppDetailDeleter;
import com.facebook.appcenter.db.DbAppDetailFetcher;
import com.facebook.appcenter.db.DbAppDetailInserter;
import com.facebook.appcenter.graphql.model.AppCenterCategory;
import com.facebook.appcenter.graphql.model.AppCenterCategoryList;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.appcenter.graphql.model.AppList;
import com.facebook.appcenter.protocol.FetchAppCategoryMethod;
import com.facebook.appcenter.protocol.FetchAppCategoryResult;
import com.facebook.appcenter.protocol.FetchAppDetailMethod;
import com.facebook.appcenter.protocol.FetchAppDetailResult;
import com.facebook.appcenter.protocol.FetchAppListMethod;
import com.facebook.appcenter.protocol.FetchAppListResult;
import com.facebook.appcenter.protocol.GrantAppGdpMethod;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.inject.Provider;

public class AppDataServiceHandler
  implements OrcaServiceHandler
{
  private static final Class<?> a = AppDataServiceHandler.class;
  private final Provider<SingleMethodRunner> b;
  private final FetchAppDetailMethod c;
  private final FetchAppListMethod d;
  private final FetchAppCategoryMethod e;
  private final GrantAppGdpMethod f;
  private final AppDetailCache g;
  private final AppListCache h;
  private final AppCategoryCache i;
  private final DbAppDetailFetcher j;
  private final DbAppDetailInserter k;
  private final DbAppDetailDeleter l;

  public AppDataServiceHandler(Provider<SingleMethodRunner> paramProvider, FetchAppDetailMethod paramFetchAppDetailMethod, FetchAppListMethod paramFetchAppListMethod, FetchAppCategoryMethod paramFetchAppCategoryMethod, GrantAppGdpMethod paramGrantAppGdpMethod, AppDetailCache paramAppDetailCache, AppListCache paramAppListCache, AppCategoryCache paramAppCategoryCache, DbAppDetailFetcher paramDbAppDetailFetcher, DbAppDetailInserter paramDbAppDetailInserter, DbAppDetailDeleter paramDbAppDetailDeleter)
  {
    Preconditions.checkNotNull(paramProvider);
    Preconditions.checkNotNull(paramFetchAppDetailMethod);
    Preconditions.checkNotNull(paramFetchAppListMethod);
    Preconditions.checkNotNull(paramFetchAppCategoryMethod);
    Preconditions.checkNotNull(paramAppDetailCache);
    Preconditions.checkNotNull(paramAppListCache);
    Preconditions.checkNotNull(paramAppCategoryCache);
    Preconditions.checkNotNull(paramDbAppDetailFetcher);
    Preconditions.checkNotNull(paramDbAppDetailInserter);
    Preconditions.checkNotNull(paramDbAppDetailDeleter);
    this.c = paramFetchAppDetailMethod;
    this.d = paramFetchAppListMethod;
    this.e = paramFetchAppCategoryMethod;
    this.f = paramGrantAppGdpMethod;
    this.b = paramProvider;
    this.g = paramAppDetailCache;
    this.h = paramAppListCache;
    this.i = paramAppCategoryCache;
    this.j = paramDbAppDetailFetcher;
    this.k = paramDbAppDetailInserter;
    this.l = paramDbAppDetailDeleter;
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    int m = 0;
    FetchAppCategoryParams localFetchAppCategoryParams = (FetchAppCategoryParams)paramOperationParams.b().getParcelable("fetchAppCategoryParams");
    if (this.i.b() == 0)
    {
      if (this.i.a() == null);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        localFetchAppCategoryResult = (FetchAppCategoryResult)((SingleMethodRunner)this.b.b()).a(this.e, localFetchAppCategoryParams);
        Preconditions.checkNotNull(localFetchAppCategoryResult);
        AppCenterCategoryList localAppCenterCategoryList = localFetchAppCategoryResult.b();
        this.i.a(localAppCenterCategoryList);
        List localList = localAppCenterCategoryList.applicationCategories;
        Preconditions.checkNotNull(localList);
        while (m < localList.size())
        {
          AppCenterCategory localAppCenterCategory = (AppCenterCategory)localList.get(m);
          this.i.a(localAppCenterCategory.label, localAppCenterCategory);
          m++;
        }
      }
    }
    FetchAppCategoryResult localFetchAppCategoryResult = new FetchAppCategoryResult(this.i.a(), DataFreshnessResult.FROM_CACHE_UP_TO_DATE, System.currentTimeMillis());
    return OperationResult.a(localFetchAppCategoryResult);
  }

  private OperationResult c(OperationParams paramOperationParams)
  {
    FetchAppListParams localFetchAppListParams = (FetchAppListParams)paramOperationParams.b().getParcelable("fetchAppListParams");
    Preconditions.checkNotNull(localFetchAppListParams);
    AppList localAppList = this.h.a(localFetchAppListParams);
    if (localAppList != null);
    FetchAppListResult localFetchAppListResult;
    for (OperationResult localOperationResult = OperationResult.a(new FetchAppListResult(localAppList, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, System.currentTimeMillis())); ; localOperationResult = OperationResult.a(localFetchAppListResult))
    {
      return localOperationResult;
      localFetchAppListResult = (FetchAppListResult)((SingleMethodRunner)this.b.b()).a(this.d, localFetchAppListParams);
      Preconditions.checkNotNull(localFetchAppListResult);
      if (localFetchAppListResult == null)
        continue;
      this.h.a(localFetchAppListParams, localFetchAppListResult.a());
    }
  }

  private OperationResult d(OperationParams paramOperationParams)
  {
    FetchAppDetailParams localFetchAppDetailParams = (FetchAppDetailParams)paramOperationParams.b().getParcelable("fetchAppDetailParams");
    String str = localFetchAppDetailParams.a();
    Preconditions.checkNotNull(str);
    AppDetail localAppDetail1 = this.g.a(str);
    OperationResult localOperationResult;
    if (localAppDetail1 != null)
      localOperationResult = OperationResult.a(new FetchAppDetailResult(localAppDetail1, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, System.currentTimeMillis()));
    while (true)
    {
      return localOperationResult;
      FetchAppDetailResult localFetchAppDetailResult1 = this.j.a(str);
      if (localFetchAppDetailResult1 != FetchAppDetailResult.a)
      {
        BLog.c(a, "Got DB app detail info: " + localFetchAppDetailResult1.toString());
        Preconditions.checkNotNull(localFetchAppDetailResult1);
        this.g.a(localFetchAppDetailResult1.a());
        localOperationResult = OperationResult.a(localFetchAppDetailResult1);
        continue;
      }
      FetchAppDetailResult localFetchAppDetailResult2 = (FetchAppDetailResult)((SingleMethodRunner)this.b.b()).a(this.c, localFetchAppDetailParams);
      Preconditions.checkNotNull(localFetchAppDetailResult2);
      AppDetail localAppDetail2 = localFetchAppDetailResult2.a();
      if (localAppDetail2 != null)
      {
        this.g.a(localAppDetail2);
        this.k.a(localAppDetail2);
      }
      localOperationResult = OperationResult.a(localFetchAppDetailResult2);
    }
  }

  private OperationResult e(OperationParams paramOperationParams)
  {
    GrantAppGdpParams localGrantAppGdpParams = (GrantAppGdpParams)paramOperationParams.b().getParcelable("grantAppGdpParams");
    return OperationResult.a((String)((SingleMethodRunner)this.b.b()).a(this.f, localGrantAppGdpParams));
  }

  private OperationResult f(OperationParams paramOperationParams)
  {
    String str = ((DeleteAppDetailParams)paramOperationParams.b().getParcelable("deleteAppDetailParams")).a();
    Preconditions.checkNotNull(str);
    this.g.b(str);
    this.l.a(str);
    return OperationResult.a("Deleted");
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    OperationResult localOperationResult;
    if ("fetch_app_detail".equals(str))
      localOperationResult = d(paramOperationParams);
    while (true)
    {
      return localOperationResult;
      if ("fetch_app_list".equals(str))
      {
        localOperationResult = c(paramOperationParams);
        continue;
      }
      if ("fetch_app_categories".equals(str))
      {
        localOperationResult = b(paramOperationParams);
        continue;
      }
      if ("grant_app_gdp".equals(str))
      {
        localOperationResult = e(paramOperationParams);
        continue;
      }
      if (!"delete_app_detail".equals(str))
        break;
      localOperationResult = f(paramOperationParams);
    }
    throw new Exception("Unknown type");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.service.AppDataServiceHandler
 * JD-Core Version:    0.6.0
 */
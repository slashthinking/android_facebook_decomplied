package com.facebook.pages.identity.service;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.BatchOperation;
import com.facebook.orca.protocol.base.BatchOperation.Builder;
import com.facebook.orca.protocol.base.BatchRunner;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.pages.identity.protocol.FetchPageIdentityDataMethod;
import com.facebook.pages.identity.protocol.FetchPageIdentityDataMethod.Params;
import com.facebook.pages.identity.protocol.FetchPageRecommendationDataMethod;
import com.facebook.pages.identity.protocol.FetchPageRecommendationDataMethod.Params;
import com.facebook.pages.identity.protocol.RatePageMethod;
import com.facebook.pages.identity.protocol.RatePageParams;
import javax.inject.Provider;

public class PageIdentityServiceHandler
  implements OrcaServiceHandler
{
  private final Provider<BatchRunner> a;
  private final Provider<SingleMethodRunner> b;
  private final FetchPageIdentityDataMethod c;
  private final FetchPageRecommendationDataMethod d;
  private final RatePageMethod e;

  public PageIdentityServiceHandler(Provider<BatchRunner> paramProvider, Provider<SingleMethodRunner> paramProvider1, FetchPageIdentityDataMethod paramFetchPageIdentityDataMethod, FetchPageRecommendationDataMethod paramFetchPageRecommendationDataMethod, RatePageMethod paramRatePageMethod)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramFetchPageIdentityDataMethod;
    this.d = paramFetchPageRecommendationDataMethod;
    this.e = paramRatePageMethod;
  }

  private OperationResult a(ApiMethod paramApiMethod, Parcelable paramParcelable)
  {
    BatchRunner localBatchRunner = (BatchRunner)this.a.b();
    localBatchRunner.a(BatchOperation.a(paramApiMethod, paramParcelable).a());
    localBatchRunner.b("singleMethod");
    return OperationResult.a((Parcelable)localBatchRunner.a(0));
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    RatePageParams localRatePageParams = (RatePageParams)paramOperationParams.b().getParcelable("ratePageParams");
    ((SingleMethodRunner)this.b.b()).a(this.e, localRatePageParams);
    return OperationResult.b();
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    Bundle localBundle = paramOperationParams.b();
    String str = paramOperationParams.a();
    OperationResult localOperationResult;
    if ("fetch_page_identity_data".equals(str))
    {
      FetchPageIdentityDataMethod.Params localParams1 = (FetchPageIdentityDataMethod.Params)localBundle.getParcelable("fetchPageIdentityDataParams");
      localOperationResult = a(this.c, localParams1);
    }
    while (true)
    {
      return localOperationResult;
      if ("fetch_page_recommendation".equals(str))
      {
        FetchPageRecommendationDataMethod.Params localParams = (FetchPageRecommendationDataMethod.Params)localBundle.getParcelable("fetchPageRecommendationParam");
        localOperationResult = a(this.d, localParams);
      }
      else
      {
        if (!"rate_page_data".equals(str))
          break;
        localOperationResult = b(paramOperationParams);
      }
    }
    throw new Exception("Unknown operation type: " + str);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.service.PageIdentityServiceHandler
 * JD-Core Version:    0.6.2
 */
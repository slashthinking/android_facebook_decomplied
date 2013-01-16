package com.facebook.pages.identity.fetcher;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.feed.protocol.ToggleLikeParams;
import com.facebook.feed.protocol.ToggleLikeParams.Builder;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.OperationResult;
import com.facebook.pages.identity.protocol.FetchPageIdentityDataMethod.Params;
import com.facebook.pages.identity.protocol.FetchPageRecommendationDataMethod.Params;
import com.facebook.pages.identity.protocol.RatePageParams;
import com.google.common.util.concurrent.ListenableFuture;

public class PageIdentityDataFetcher
{
  private final OrcaServiceOperationFactory a;

  public PageIdentityDataFetcher(OrcaServiceOperationFactory paramOrcaServiceOperationFactory)
  {
    this.a = paramOrcaServiceOperationFactory;
  }

  private ListenableFuture<OperationResult> a(Parcelable paramParcelable, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    if (paramParcelable != null)
      localBundle.putParcelable(paramString1, paramParcelable);
    return this.a.a(paramString2, localBundle).d();
  }

  public ListenableFuture<OperationResult> a(int paramInt, String paramString)
  {
    return a(new RatePageParams(paramString, paramInt), "ratePageParams", "rate_page_data");
  }

  public ListenableFuture<OperationResult> a(long paramLong, int paramInt)
  {
    return a(new FetchPageIdentityDataMethod.Params(paramLong, paramInt), "fetchPageIdentityDataParams", "fetch_page_identity_data");
  }

  public ListenableFuture<OperationResult> a(long paramLong, boolean paramBoolean)
  {
    return a(new FetchPageRecommendationDataMethod.Params(paramLong, paramBoolean), "fetchPageRecommendationParam", "fetch_page_recommendation");
  }

  public ListenableFuture<OperationResult> a(boolean paramBoolean, long paramLong)
  {
    return a(ToggleLikeParams.a().a(paramBoolean).a(String.valueOf(paramLong)).a(), "toggleLikeParams", "toggle_like");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.fetcher.PageIdentityDataFetcher
 * JD-Core Version:    0.6.2
 */
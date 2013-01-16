package com.facebook.pages.identity.module;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.BatchRunner;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.pages.identity.protocol.FetchPageIdentityDataMethod;
import com.facebook.pages.identity.protocol.FetchPageRecommendationDataMethod;
import com.facebook.pages.identity.protocol.RatePageMethod;
import com.facebook.pages.identity.service.PageIdentityServiceHandler;

class PageIdentityModule$PagesServiceHandlerProvider extends AbstractProvider<PageIdentityServiceHandler>
{
  private PageIdentityModule$PagesServiceHandlerProvider(PageIdentityModule paramPageIdentityModule)
  {
  }

  public PageIdentityServiceHandler a()
  {
    return new PageIdentityServiceHandler(a(BatchRunner.class), a(SingleMethodRunner.class), (FetchPageIdentityDataMethod)b(FetchPageIdentityDataMethod.class), (FetchPageRecommendationDataMethod)b(FetchPageRecommendationDataMethod.class), (RatePageMethod)b(RatePageMethod.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.module.PageIdentityModule.PagesServiceHandlerProvider
 * JD-Core Version:    0.6.2
 */
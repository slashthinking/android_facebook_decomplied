package com.facebook.pages.identity.module;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.pages.identity.fetcher.PageIdentityDataFetcher;

class PageIdentityModule$PageIdentityDataFetcherProvider extends AbstractProvider<PageIdentityDataFetcher>
{
  private PageIdentityModule$PageIdentityDataFetcherProvider(PageIdentityModule paramPageIdentityModule)
  {
  }

  public PageIdentityDataFetcher a()
  {
    return new PageIdentityDataFetcher((OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.module.PageIdentityModule.PageIdentityDataFetcherProvider
 * JD-Core Version:    0.6.2
 */
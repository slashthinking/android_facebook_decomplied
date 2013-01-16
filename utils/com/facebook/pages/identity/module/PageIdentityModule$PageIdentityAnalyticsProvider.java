package com.facebook.pages.identity.module;

import com.facebook.analytics.InteractionLogger;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.pages.identity.analytics.PageIdentityAnalytics;

class PageIdentityModule$PageIdentityAnalyticsProvider extends AbstractProvider<PageIdentityAnalytics>
{
  private PageIdentityModule$PageIdentityAnalyticsProvider(PageIdentityModule paramPageIdentityModule)
  {
  }

  public PageIdentityAnalytics a()
  {
    return new PageIdentityAnalytics((InteractionLogger)b(InteractionLogger.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.module.PageIdentityModule.PageIdentityAnalyticsProvider
 * JD-Core Version:    0.6.2
 */
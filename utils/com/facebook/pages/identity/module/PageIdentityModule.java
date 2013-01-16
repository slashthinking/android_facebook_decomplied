package com.facebook.pages.identity.module;

import android.app.Application;
import com.facebook.graphql.module.GraphQLModule;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.facebook.orca.server.OrcaServiceRegistry;
import com.facebook.pages.identity.analytics.PageIdentityAnalytics;
import com.facebook.pages.identity.annotations.IsNewPageIdentityEnabled;
import com.facebook.pages.identity.fetcher.PageIdentityDataFetcher;
import com.facebook.pages.identity.protocol.FetchPageIdentityDataMethod;
import com.facebook.pages.identity.protocol.FetchPageRecommendationDataMethod;
import com.facebook.pages.identity.protocol.RatePageMethod;
import com.facebook.pages.identity.service.PageIdentityMethodsQueue;
import com.facebook.pages.identity.service.PageIdentityService;
import com.facebook.pages.identity.service.PageIdentityServiceHandler;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class PageIdentityModule extends AbstractModule
{
  private Application a;

  public PageIdentityModule(Application paramApplication)
  {
    this.a = paramApplication;
  }

  private void a(Class<? extends Annotation> paramClass, Provider<OrcaServiceHandler> paramProvider)
  {
    a(OrcaServiceHandler.class).a(paramClass).a(paramProvider);
    c(Key.a(OrcaServiceQueueHook.class, paramClass));
  }

  protected void a()
  {
    a(new GraphQLModule(this.a));
    a(FetchPageIdentityDataMethod.class).a(new PageIdentityModule.FetchPageIdentityDataMethodProvider(this, null));
    a(FetchPageRecommendationDataMethod.class).a(new PageIdentityModule.FetchPageRecommendationDataMethodProvider(this, null));
    a(RatePageMethod.class).a(new PageIdentityModule.RatePageMethodProvider(this, null));
    a(PageIdentityServiceHandler.class).a(new PageIdentityModule.PagesServiceHandlerProvider(this, null));
    a(PageIdentityDataFetcher.class).a(new PageIdentityModule.PageIdentityDataFetcherProvider(this, null));
    a(PageIdentityMethodsQueue.class, new PageIdentityModule.OrcaServiceHandlerForPagesMethodsQueueProvider(this, null));
    a(PageIdentityAnalytics.class).a(new PageIdentityModule.PageIdentityAnalyticsProvider(this, null));
    b(Boolean.class).a(IsNewPageIdentityEnabled.class).a(Boolean.valueOf(false));
  }

  public void a(FbInjector paramFbInjector)
  {
    super.a(paramFbInjector);
    OrcaServiceRegistry localOrcaServiceRegistry = (OrcaServiceRegistry)paramFbInjector.a(OrcaServiceRegistry.class);
    localOrcaServiceRegistry.a(PageIdentityMethodsQueue.class, PageIdentityService.class);
    localOrcaServiceRegistry.a("fetch_page_identity_data", PageIdentityMethodsQueue.class);
    localOrcaServiceRegistry.a("fetch_page_recommendation", PageIdentityMethodsQueue.class);
    localOrcaServiceRegistry.a("rate_page_data", PageIdentityMethodsQueue.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.module.PageIdentityModule
 * JD-Core Version:    0.6.2
 */
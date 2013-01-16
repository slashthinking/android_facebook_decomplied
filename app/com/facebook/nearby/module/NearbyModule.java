package com.facebook.nearby.module;

import android.content.Context;
import com.facebook.nearby.analytics.NearbyAnalytics;
import com.facebook.nearby.data.CategorySearchHistoryManager;
import com.facebook.nearby.places.NearbyMapPinFactory;
import com.facebook.nearby.protocol.FetchNearbyPlacesMethod;
import com.facebook.nearby.protocol.NearbyMethodsQueue;
import com.facebook.nearby.protocol.SearchNearbyPlacesMethod;
import com.facebook.nearby.server.NearbyServiceHandler;
import com.facebook.nearby.service.NearbyService;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.facebook.orca.server.OrcaServiceRegistry;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class NearbyModule extends AbstractModule
{
  private final Context a;

  public NearbyModule(Context paramContext)
  {
    this.a = paramContext;
  }

  private void a(Class<? extends Annotation> paramClass, Provider<OrcaServiceHandler> paramProvider)
  {
    a(OrcaServiceHandler.class).a(paramClass).a(paramProvider);
    c(Key.a(OrcaServiceQueueHook.class, paramClass));
  }

  protected void a()
  {
    a(FetchNearbyPlacesMethod.class).a(new NearbyModule.FetchNearbyPlacesMethodProvider(this, null));
    a(SearchNearbyPlacesMethod.class).a(new NearbyModule.SearchNearbyPlacesMethodProvider(this, null));
    a(NearbyServiceHandler.class).a(new NearbyModule.NearbyServiceHandlerProvider(this, null));
    a(NearbyMethodsQueue.class, new NearbyModule.OrcaServiceHandlerForNearbyQueueProvider(this, null));
    a(NearbyAnalytics.class).a(new NearbyModule.NearbyAnalyticsProvider(this, null));
    a(NearbyMapPinFactory.class).a(new NearbyModule.PinIconFactoryProvider(this, null));
    a(CategorySearchHistoryManager.class).a(new NearbyModule.CategorySearchHistoryManagerProvider(this, null));
  }

  public void a(FbInjector paramFbInjector)
  {
    super.a(paramFbInjector);
    OrcaServiceRegistry localOrcaServiceRegistry = (OrcaServiceRegistry)paramFbInjector.a(OrcaServiceRegistry.class);
    localOrcaServiceRegistry.a(NearbyMethodsQueue.class, NearbyService.class);
    localOrcaServiceRegistry.a("fetch_nearby_places", NearbyMethodsQueue.class);
    localOrcaServiceRegistry.a("search_nearby_places", NearbyMethodsQueue.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.module.NearbyModule
 * JD-Core Version:    0.6.0
 */
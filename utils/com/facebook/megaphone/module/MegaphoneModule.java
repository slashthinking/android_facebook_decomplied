package com.facebook.megaphone.module;

import android.content.Context;
import com.facebook.graphql.module.GraphQLModule;
import com.facebook.megaphone.api.FetchMegaphoneMethod;
import com.facebook.megaphone.api.LogMegaphoneMethod;
import com.facebook.megaphone.api.MegaphoneQueue;
import com.facebook.megaphone.api.MegaphoneServiceHandler;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.megaphone.fetcher.MegaphoneFetcher;
import com.facebook.megaphone.logger.MegaphoneLogger;
import com.facebook.megaphone.service.MegaphoneService;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.facebook.orca.server.OrcaServiceRegistry;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class MegaphoneModule extends AbstractModule
{
  private final Context a;

  public MegaphoneModule(Context paramContext)
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
    a(new GraphQLModule(this.a));
    a(FetchMegaphoneMethod.class).a(new MegaphoneModule.FetchMegaphoneMethodProvider(this, null));
    a(LogMegaphoneMethod.class).a(new MegaphoneModule.LogMegaphoneMethodProvider(this, null));
    a(MegaphoneStore.class).a(new MegaphoneModule.MegaphoneStoreProvider(this, null)).a();
    a(MegaphoneServiceHandler.class).a(new MegaphoneModule.MegaphoneServiceHandlerProvider(this, null)).a();
    a(MegaphoneQueue.class, new MegaphoneModule.OrcaServiceHandlerForMegaphoneQueueProvider(this, null));
    a(MegaphoneFetcher.class).a(new MegaphoneModule.MegaphoneFetcherProvider(this, null));
    a(MegaphoneLogger.class).a(new MegaphoneModule.MegaphoneLoggerProvider(this, null));
  }

  public void a(FbInjector paramFbInjector)
  {
    OrcaServiceRegistry localOrcaServiceRegistry = (OrcaServiceRegistry)paramFbInjector.a(OrcaServiceRegistry.class);
    localOrcaServiceRegistry.a(MegaphoneQueue.class, MegaphoneService.class);
    localOrcaServiceRegistry.a("fetch_megaphone", MegaphoneQueue.class);
    localOrcaServiceRegistry.a("log_megaphone", MegaphoneQueue.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.module.MegaphoneModule
 * JD-Core Version:    0.6.2
 */
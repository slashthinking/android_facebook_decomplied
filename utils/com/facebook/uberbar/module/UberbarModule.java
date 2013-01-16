package com.facebook.uberbar.module;

import android.content.Context;
import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.facebook.uberbar.annotations.FriendsResolver;
import com.facebook.uberbar.annotations.PagesResolver;
import com.facebook.uberbar.api.FetchUberbarResultMethod;
import com.facebook.uberbar.api.FetchUberbarResultQueue;
import com.facebook.uberbar.resolvers.LocalUberbarResultResolver;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class UberbarModule extends AbstractModule
{
  private final Context a;

  public UberbarModule(Context paramContext)
  {
    this.a = paramContext;
  }

  private void a(Class<? extends Annotation> paramClass, Provider<? extends OrcaServiceHandler> paramProvider)
  {
    a(OrcaServiceHandler.class).a(paramClass).a(paramProvider);
    c(Key.a(OrcaServiceQueueHook.class, paramClass));
  }

  protected void a()
  {
    a(FetchUberbarResultMethod.class).a(new UberbarModule.FetchQueryResultMethodProvider(this, null));
    a(LocalUberbarResultResolver.class).a(FriendsResolver.class).a(new UberbarModule.FriendsLocalUberbarResultResolverProvider(this, null)).a();
    a(LocalUberbarResultResolver.class).a(PagesResolver.class).a(new UberbarModule.PagesLocalUberbarResultResolverProvider(this, null)).a();
    a(FetchUberbarResultQueue.class, new UberbarModule.UberbarServiceHandlerProvider(this, null));
    a(UberbarServicesInitializer.class).a(new UberbarModule.UberbarServicesInitializerProvider(this, null));
    a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class).a(UberbarServicesInitializer.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.module.UberbarModule
 * JD-Core Version:    0.6.2
 */
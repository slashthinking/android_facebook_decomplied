package com.facebook.katana.server.module;

import android.content.Context;
import com.facebook.background.BackgroundTask;
import com.facebook.katana.platform.Permissions;
import com.facebook.katana.server.FetchMinorStatusQueue;
import com.facebook.katana.server.PlatformOperationQueue;
import com.facebook.katana.server.UserSetContactInfoQueue;
import com.facebook.katana.server.background.UserSetContactInfoBackgroundTask;
import com.facebook.katana.server.handler.FetchMinorStatusHandler;
import com.facebook.katana.server.handler.PlatformOperationHandler;
import com.facebook.katana.server.handler.UserSetContactInfoServiceHandler;
import com.facebook.katana.server.protocol.AuthorizeAppMethod;
import com.facebook.katana.server.protocol.FetchMinorStatusMethod;
import com.facebook.katana.server.protocol.GetPermissionsDescriptionMethod;
import com.facebook.katana.server.protocol.UserSetContactInfoMethod;
import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class Fb4aServiceModule extends AbstractModule
{
  private final Context a;

  public Fb4aServiceModule(Context paramContext)
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
    a(FetchMinorStatusMethod.class).a(new Fb4aServiceModule.FetchMinorStatusMethodProvider(this, null));
    a(UserSetContactInfoMethod.class).a(new Fb4aServiceModule.UserSetContactInfoMethodProvider(this, null));
    a(AuthorizeAppMethod.class).a(new Fb4aServiceModule.AuthorizeAppMethodProvider(this, null));
    a(GetPermissionsDescriptionMethod.class).a(new Fb4aServiceModule.GetPermissionsDescriptionMethodProvider(this, null));
    a(FetchMinorStatusHandler.class).a(new Fb4aServiceModule.Fb4aServiceHandlerProvider(this, null));
    a(UserSetContactInfoServiceHandler.class).a(new Fb4aServiceModule.UserSetContactInfoServiceHandlerProvider(this, null));
    a(PlatformOperationHandler.class).a(new Fb4aServiceModule.PlatformOperationHandlerProvider(this, null));
    a(FetchMinorStatusQueue.class, new Fb4aServiceModule.OrcaServiceHandlerForFb4aServiceQueueProvider(this, null));
    a(PlatformOperationQueue.class, new Fb4aServiceModule.OrcaServiceHandlerForPlatformOperationQueueProvider(this, null));
    a(Fb4aServiceInitializer.class).a(new Fb4aServiceModule.Fb4aServiceInitializerProvider(this, null));
    a(Permissions.class).a(new Fb4aServiceModule.PermissionsProvider(this, null)).a();
    a(UserSetContactInfoQueue.class, new Fb4aServiceModule.OrcaServiceHandlerForUserSetContactInfoQueueProvider(this, null));
    a(UserSetContactInfoBackgroundTask.class).a(new Fb4aServiceModule.UserSetContactInfoBackgroundTaskProvider(this, null)).a();
    c(BackgroundTask.class).a(UserSetContactInfoBackgroundTask.class);
    a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class).a(Fb4aServiceInitializer.class).a(Permissions.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.module.Fb4aServiceModule
 * JD-Core Version:    0.6.0
 */
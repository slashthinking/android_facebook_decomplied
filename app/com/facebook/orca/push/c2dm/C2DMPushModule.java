package com.facebook.orca.push.c2dm;

import com.facebook.analytics.AnalyticsModule;
import com.facebook.device_id.DeviceIdChangedCallback;
import com.facebook.orca.common.http.OrcaHttpModule;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.push.PushManager;
import com.facebook.orca.push.PushModule;
import com.facebook.orca.push.annotations.IsGcmEnabled;
import com.facebook.orca.push.annotations.RegistrationQueue;
import com.facebook.orca.push.service.PushNotificationService;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.facebook.orca.server.OrcaServiceRegistry;
import com.facebook.orca.server.ServicesModule;

public class C2DMPushModule extends AbstractModule
{
  protected void a()
  {
    e(OrcaHttpModule.class);
    e(ServicesModule.class);
    e(AnalyticsModule.class);
    e(PushModule.class);
    a(Boolean.class).a(IsGcmEnabled.class).a(Boolean.TRUE);
    a(C2dmPushManager.class).a(new C2DMPushModule.C2dmPushManagerProvider(this, null)).a();
    a(PushTokenHolder.class).a(new C2DMPushModule.PushTokenHolderProvider(this, null)).a();
    a(FacebookPushServerRegistrar.class).a(new C2DMPushModule.FacebookPushServerRegistrarProvider(this, null)).a();
    a(C2DMRegistrar.class).a(new C2DMPushModule.C2DMRegistrarProvider(this, null)).a();
    a(C2DMReceiverWakeLockHolder.class).a(new C2DMPushModule.C2DMReceiverWakeLockHolderProvider(this, null)).a();
    a(C2DMRegistrationHandler.class).a(new C2DMPushModule.C2DMRegistrationHandlerProvider(this, null));
    a(OrcaServiceHandler.class).a(RegistrationQueue.class).b(C2DMRegistrationHandler.class);
    a(OrcaServiceQueueHook.class, RegistrationQueue.class);
    a(ReregisterPushTokenCallback.class).a(new C2DMPushModule.ReregisterPushTokenCallbackProvider(this, null));
    c(C2DMPushHandler.class);
    c(PushManager.class).a(C2dmPushManager.class);
    c(DeviceIdChangedCallback.class).a(ReregisterPushTokenCallback.class);
  }

  public void a(FbInjector paramFbInjector)
  {
    OrcaServiceRegistry localOrcaServiceRegistry = (OrcaServiceRegistry)paramFbInjector.a(OrcaServiceRegistry.class);
    localOrcaServiceRegistry.a(RegistrationQueue.class, PushNotificationService.class);
    localOrcaServiceRegistry.a("register_push", RegistrationQueue.class);
    localOrcaServiceRegistry.a("unregister_push", RegistrationQueue.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMPushModule
 * JD-Core Version:    0.6.0
 */
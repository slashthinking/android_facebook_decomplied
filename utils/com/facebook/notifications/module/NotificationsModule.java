package com.facebook.notifications.module;

import com.facebook.ipc.notifications.GQLNotificationsContract;
import com.facebook.ipc.notifications.NotificationsContract;
import com.facebook.notifications.annotations.IsGraphQLNotificationsEnabled;
import com.facebook.notifications.annotations.IsStaleClientNotificationEnabled;
import com.facebook.notifications.background.FetchStaleClientNotificationBackgroundTask;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsMethod;
import com.facebook.notifications.protocol.FetchNotificationsMethod;
import com.facebook.notifications.protocol.FetchStaleClientNotificationMethod;
import com.facebook.notifications.protocol.GetNotificationsSettingsMethod;
import com.facebook.notifications.protocol.NotificationsChangeReadMethod;
import com.facebook.notifications.protocol.NotificationsChangeSettingsMethod;
import com.facebook.notifications.protocol.NotificationsQueue;
import com.facebook.notifications.protocol.NotificationsServiceHandler;
import com.facebook.notifications.provider.GQLNotificationsContentProviderHandler;
import com.facebook.notifications.provider.GQLNotificationsContentProviderHelper;
import com.facebook.notifications.provider.NotificationsContentProviderHandler;
import com.facebook.notifications.provider.NotificationsContentProviderHelper;
import com.facebook.notifications.server.NotificationsService;
import com.facebook.notifications.util.NotificationsLastUpdatedTimeUtil;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.facebook.orca.server.OrcaServiceRegistry;
import com.google.common.base.Preconditions;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class NotificationsModule extends AbstractModule
{
  private final String a;

  public NotificationsModule(String paramString)
  {
    this.a = ((String)Preconditions.checkNotNull(paramString));
  }

  private void a(Class<? extends Annotation> paramClass, Provider<OrcaServiceHandler> paramProvider)
  {
    a(OrcaServiceHandler.class).a(paramClass).a(paramProvider);
    c(Key.a(OrcaServiceQueueHook.class, paramClass));
  }

  protected void a()
  {
    d(OrcaServiceOperationFactory.class);
    a(NotificationsContract.class).a(new NotificationsContract(this.a));
    a(GQLNotificationsContract.class).a(new GQLNotificationsContract(this.a));
    a(FetchNotificationsMethod.class).a(new NotificationsModule.FetchNotificationsMethodProvider(this, null));
    a(FetchGraphQLNotificationsMethod.class).a(new NotificationsModule.FetchGraphQLNotificationsMethodProvider(this, null));
    a(FetchStaleClientNotificationMethod.class).a(new NotificationsModule.FetchStaleClientNotificationProvider(this, null));
    a(NotificationsChangeReadMethod.class).a(new NotificationsModule.NotificationsChangeReadProvider(this, null));
    a(NotificationsChangeSettingsMethod.class).a(new NotificationsModule.NotificationsChangeSettingsProvider(this, null));
    a(NotificationsLastUpdatedTimeUtil.class).a(new NotificationsModule.NotificationsLastUpdatedTimeUtilProvider(this, null));
    a(NotificationsUtils.class).a(new NotificationsModule.NotificationsUtilsProvider(this, null));
    a(GetNotificationsSettingsMethod.class).a(new NotificationsModule.GetNotificationsSettingsProvider(this, null));
    a(NotificationsServiceHandler.class).a(new NotificationsModule.NotificationsHandlerProvider(this, null));
    a(NotificationsContentProviderHandler.class).a(new NotificationsModule.NotificationsContentProviderHandlerProvider(this, null));
    a(GQLNotificationsContentProviderHandler.class).a(new NotificationsModule.GQLNotificationsContentProviderHandlerProvider(this, null));
    a(NotificationsContentProviderHelper.class).a(new NotificationsModule.NotificationsContentProviderHelperProvider(this, null));
    a(GQLNotificationsContentProviderHelper.class).a(new NotificationsModule.GQLNotificationsContentProviderHelperProvider(this, null));
    a(FetchStaleClientNotificationBackgroundTask.class).a(new NotificationsModule.StaleClientNotificationBackgroundTaskProvider(this, null)).a();
    a(NotificationsQueue.class, new NotificationsModule.OrcaServiceHandlerForNotificationsQueueProvider(this, null));
    b(Boolean.class).a(IsStaleClientNotificationEnabled.class).a(Boolean.valueOf(false));
    b(Boolean.class).a(IsGraphQLNotificationsEnabled.class).a(Boolean.valueOf(false));
  }

  public void a(FbInjector paramFbInjector)
  {
    OrcaServiceRegistry localOrcaServiceRegistry = (OrcaServiceRegistry)paramFbInjector.a(OrcaServiceRegistry.class);
    localOrcaServiceRegistry.a(NotificationsQueue.class, NotificationsService.class);
    localOrcaServiceRegistry.a("fetch_notifications", NotificationsQueue.class);
    localOrcaServiceRegistry.a("notifMarkRead", NotificationsQueue.class);
    localOrcaServiceRegistry.a("notifChangeSetting", NotificationsQueue.class);
    localOrcaServiceRegistry.a("fetch_gql_notifications", NotificationsQueue.class);
    localOrcaServiceRegistry.a("gqlNotifUpdateSeenState", NotificationsQueue.class);
    localOrcaServiceRegistry.a("fetchStaleClientNotification", NotificationsQueue.class);
    localOrcaServiceRegistry.a("getNotificationsSettings", NotificationsQueue.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule
 * JD-Core Version:    0.6.2
 */
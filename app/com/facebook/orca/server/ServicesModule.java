package com.facebook.orca.server;

import android.content.Context;
import com.facebook.background.AreBackgroundTasksEnabled;
import com.facebook.background.BackgroundTask;
import com.facebook.background.BackgroundTaskManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnUiThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.ops.OrcaServiceOperationFactory;

public class ServicesModule extends AbstractModule
{
  private final Context a;

  public ServicesModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    a(OrcaServiceQueueManager.class).a(new ServicesModule.OrcaServiceQueueManagerProvider(this, null)).a();
    a(OrcaServiceRegistry.class).a(new ServicesModule.OrcaServiceRegistryProvider(this, null)).a();
    a(OrcaServiceOperation.class).a(new ServicesModule.OrcaServiceOperationProvider(this, null));
    a(OrcaServiceOperation.class).a(FromApplication.class).a(new ServicesModule.OrcaServiceOperationForAppProvider(this, null));
    a(OrcaServiceOperationFactory.class).a(new ServicesModule.OrcaServiceOperationFactoryProvider(this, null));
    a(OrcaServiceOperationFactory.class).a(FromApplication.class).a(new ServicesModule.OrcaServiceOperationFactoryForAppProvider(this, null));
    a(BackgroundTaskManager.class).a(new ServicesModule.BackgroundTaskManagerProvider(this, null)).a();
    a(Boolean.class).a(AreBackgroundTasksEnabled.class).a(Boolean.valueOf(true));
    c(OrcaServiceHandlerHook.class);
    c(OrcaServiceQueueHook.class);
    c(BackgroundTask.class);
    a(INeedInit.class, NeedsLowPriorityInitOnUiThread.class).a(BackgroundTaskManager.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ServicesModule
 * JD-Core Version:    0.6.0
 */
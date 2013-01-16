package com.facebook.abtest.qe.service.module;

import com.facebook.abtest.qe.protocol.SyncQuickExperimentMethod;
import com.facebook.abtest.qe.service.QuickExperimentDbServiceHandler;
import com.facebook.abtest.qe.service.QuickExperimentSyncServiceHandler;
import com.facebook.abtest.qe.service.background.SyncQuickExperimentBackgroundTask;
import com.facebook.background.BackgroundTask;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.server.OrcaService;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.facebook.orca.server.OrcaServiceRegistry;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class QuickExperimentServiceModule extends AbstractModule
{
  private final Class<? extends OrcaService> a;

  public QuickExperimentServiceModule(Class<? extends OrcaService> paramClass)
  {
    this.a = paramClass;
  }

  private void a(Class<? extends Annotation> paramClass, Provider<OrcaServiceHandler> paramProvider)
  {
    a(OrcaServiceHandler.class).a(paramClass).a(paramProvider);
    c(Key.a(OrcaServiceQueueHook.class, paramClass));
  }

  protected void a()
  {
    a(SyncQuickExperimentMethod.class).a(new QuickExperimentServiceModule.SyncQuickExperimentMethodProvider(this, null));
    a(QuickExperimentQueue.class, new QuickExperimentServiceModule.OrcaServiceHandlerForQuickExperimentProvider(this, null));
    a(QuickExperimentDbServiceHandler.class).a(new QuickExperimentServiceModule.QuickExperimentDbServiceHandlerProvider(this, null));
    a(QuickExperimentSyncServiceHandler.class).a(new QuickExperimentServiceModule.QuickExperimentSyncServiceHandlerProvider(this, null));
    a(SyncQuickExperimentBackgroundTask.class).a(new QuickExperimentServiceModule.SyncQuickExperimentBackgroundTaskProvider(this, null)).a();
    c(BackgroundTask.class).a(SyncQuickExperimentBackgroundTask.class);
  }

  public void a(FbInjector paramFbInjector)
  {
    super.a(paramFbInjector);
    OrcaServiceRegistry localOrcaServiceRegistry = (OrcaServiceRegistry)paramFbInjector.a(OrcaServiceRegistry.class);
    localOrcaServiceRegistry.a(QuickExperimentQueue.class, this.a);
    localOrcaServiceRegistry.a("sync_qe", QuickExperimentQueue.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.service.module.QuickExperimentServiceModule
 * JD-Core Version:    0.6.2
 */
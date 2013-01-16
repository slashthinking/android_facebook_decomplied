package com.facebook.abtest.qe;

import android.content.Context;
import com.facebook.abtest.qe.db.QuickExperimentDbSchemaPart;
import com.facebook.abtest.qe.db.QuickExperimentDbSupplier;
import com.facebook.abtest.qe.db.QuickExperimentStorage;
import com.facebook.abtest.qe.registry.QuickExperimentNameHolder;
import com.facebook.abtest.qe.service.module.QuickExperimentServiceModule;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.analytics.AnalyticsModule;
import com.facebook.orca.app.FbBaseModule;
import com.facebook.orca.common.http.OrcaHttpModule;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.prefs.OrcaSharedPreferencesModule;
import com.facebook.orca.server.OrcaService;

public class QuickExperimentModule extends AbstractModule
{
  private final Context a;
  private final Class<? extends OrcaService> b;

  public QuickExperimentModule(Context paramContext, Class<? extends OrcaService> paramClass)
  {
    this.a = paramContext;
    this.b = paramClass;
  }

  protected void a()
  {
    e(FbBaseModule.class);
    e(OrcaHttpModule.class);
    e(OrcaSharedPreferencesModule.class);
    e(AnalyticsModule.class);
    a(new QuickExperimentServiceModule(this.b));
    a(LocaleUtil.class).a(new QuickExperimentModule.LocaleUtilProvider(this, null));
    a(QuickExperimentDbSchemaPart.class).a(new QuickExperimentModule.QuickExperimentDbSchemaPartProvider(this, null)).a();
    a(QuickExperimentDbSupplier.class).a(new QuickExperimentModule.QuickExperimentDbSupplierProvider(this, null)).a();
    a(QuickExperimentStorage.class).a(new QuickExperimentModule.QuickExperimentStorageProvider(this, null));
    a(QuickExperimentManager.class).a(new QuickExperimentModule.QuickExperimentManagerProvider(this, null)).a();
    c(QuickExperimentNameHolder.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.QuickExperimentModule
 * JD-Core Version:    0.6.2
 */
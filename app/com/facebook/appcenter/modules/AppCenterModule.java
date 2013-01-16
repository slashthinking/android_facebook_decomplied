package com.facebook.appcenter.modules;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.analytics.AnalyticsModule;
import com.facebook.appcenter.annotations.IsNativeAppCenterEnabled;
import com.facebook.appcenter.app.AppCenterDataManager;
import com.facebook.appcenter.cache.AppCategoryCache;
import com.facebook.appcenter.cache.AppDetailCache;
import com.facebook.appcenter.cache.AppListCache;
import com.facebook.appcenter.cache.AppServerStateCache;
import com.facebook.appcenter.data.AppCenterCategoryCollection;
import com.facebook.appcenter.db.AppCenterDatabaseSupplier;
import com.facebook.appcenter.db.AppCenterDb;
import com.facebook.appcenter.db.AppCenterDbSchemaPart;
import com.facebook.appcenter.db.DbAppDetailDeleter;
import com.facebook.appcenter.db.DbAppDetailFetcher;
import com.facebook.appcenter.db.DbAppDetailInserter;
import com.facebook.appcenter.intent.AppCenterUriIntentBuilder;
import com.facebook.appcenter.model.AppPrivacyOptionList;
import com.facebook.appcenter.protocol.FetchAppCategoryMethod;
import com.facebook.appcenter.protocol.FetchAppDetailMethod;
import com.facebook.appcenter.protocol.FetchAppListMethod;
import com.facebook.appcenter.protocol.GrantAppGdpMethod;
import com.facebook.appcenter.renderer.IAppBrowseListRenderer;
import com.facebook.appcenter.service.AppCenterServicesInitializer;
import com.facebook.appcenter.service.AppDataServiceHandler;
import com.facebook.appcenter.service.FetchAppDataQueue;
import com.facebook.appcenter.ui.AppCenterAdapterFactory;
import com.facebook.appcenter.util.AppCenterInlineGDPHelper;
import com.facebook.appcenter.util.SocialTextStringGenerator;
import com.facebook.appcenter.workflow.AppWorkflowManager;
import com.facebook.graphql.module.GraphQLModule;
import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnBackgroundThread;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnUiThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.common.http.OrcaHttpModule;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.ContextScope;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.module.UiModule;
import com.facebook.orca.prefs.DefaultSharedPreferencesModule;
import com.facebook.orca.prefs.OrcaSharedPreferencesModule;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceQueueHook;
import com.facebook.orca.server.ServicesModule;
import com.facebook.uri.UriIntentBuilder;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

public class AppCenterModule extends AbstractModule
{
  private final Context a;
  private final ContextScope b;

  public AppCenterModule(Context paramContext, ContextScope paramContextScope)
  {
    this.a = paramContext;
    this.b = paramContextScope;
  }

  private void a(Class<? extends Annotation> paramClass, Provider<OrcaServiceHandler> paramProvider)
  {
    a(OrcaServiceHandler.class).a(paramClass).a(paramProvider);
    c(Key.a(OrcaServiceQueueHook.class, paramClass));
  }

  protected void a()
  {
    Tracer localTracer = Tracer.a("AppCenterModule.configure");
    e(OrcaHttpModule.class);
    e(ServicesModule.class);
    e(UiModule.class);
    e(GraphQLModule.class);
    e(OrcaSharedPreferencesModule.class);
    e(DefaultSharedPreferencesModule.class);
    e(AnalyticsModule.class);
    if (AppWorkflowManager.a)
      a(new WorkflowModule(this.a));
    a(FetchAppDetailMethod.class).a(new AppCenterModule.FetchAppDetailMethodProvider(this, null));
    a(FetchAppListMethod.class).a(new AppCenterModule.FetchAppListMethodProvider(this, null));
    a(FetchAppCategoryMethod.class).a(new AppCenterModule.FetchAppCategoryMethodProvider(this, null));
    a(GrantAppGdpMethod.class).a(new AppCenterModule.GrantAppGdpMethodProvider(this, null));
    a(AppCenterDataManager.class).a(new AppCenterModule.AppCenterDataManagerProvider(this, null)).a();
    a(AppServerStateCache.class).a(new AppCenterModule.AppServerStateCacheProvider(this, null)).a();
    a(AppCategoryCache.class).a(new AppCenterModule.AppCenterCategoriesCacheProvider(this, null)).a();
    a(AppDetailCache.class).a(new AppCenterModule.AppDetailCacheProvider(this, null)).a();
    a(AppListCache.class).a(new AppCenterModule.AppListCacheProvider(this, null)).a();
    a(SQLiteDatabase.class).a(AppCenterDb.class).a(new AppCenterModule.AppCenterDatabaseProvider(this, null)).a();
    a(AppCenterDbSchemaPart.class).a(new AppCenterModule.AppCenterDbSchemaPartProvider(this, null)).a();
    a(AppCenterDatabaseSupplier.class).a(new AppCenterModule.AppCenterDatabaseSupplierProvider(this, null)).a();
    a(DbAppDetailFetcher.class).a(new AppCenterModule.DbFetchAppDetailHandlerProvider(this, null)).a();
    a(DbAppDetailInserter.class).a(new AppCenterModule.DbInsertAppDetailHandlerProvider(this, null)).a();
    a(DbAppDetailDeleter.class).a(new AppCenterModule.DbDeleteAppDetailHandlerProvider(this, null)).a();
    a(AppDataServiceHandler.class).a(new AppCenterModule.AppCenterHandlerProvider(this, null));
    a(FetchAppDataQueue.class, new AppCenterModule.AppCenterQueueProvider(this, null));
    a(AppCenterUriIntentBuilder.class).a(new AppCenterModule.AppCenterUriIntentBuilderProvider(this, null)).a();
    c(UriIntentBuilder.class).a(AppCenterUriIntentBuilder.class);
    a(INeedInit.class, NeedsLowPriorityInitOnUiThread.class);
    a(INeedInit.class, NeedsLowPriorityInitOnBackgroundThread.class);
    a(AppCenterServicesInitializer.class).a(new AppCenterModule.AppCenterServicesInitializerProvider(this, null));
    a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class).a(AppCenterServicesInitializer.class);
    localTracer.a();
    a(AppCenterCategoryCollection.class).a(new AppCenterModule.AppCenterCategoryCollectionProvider(this, null)).a();
    a(AppPrivacyOptionList.class).a(new AppCenterModule.AppPrivacyOptionListProvider(this, null)).a();
    a(IAppBrowseListRenderer.class).a(new AppCenterModule.AppCenterBrowseRendererProvider(this, null));
    a(AppCenterAdapterFactory.class).a(new AppCenterModule.AppCenterAdapterFactoryProvider(this, null));
    a(SocialTextStringGenerator.class).a(new AppCenterModule.AppCenterStringHelperProvider(this, null));
    a(AppCenterInlineGDPHelper.class).a(new AppCenterModule.AppCenterInlineGDPHelperProvider(this, null)).a();
    b(Boolean.class).a(IsNativeAppCenterEnabled.class).a(Boolean.valueOf(false));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule
 * JD-Core Version:    0.6.0
 */
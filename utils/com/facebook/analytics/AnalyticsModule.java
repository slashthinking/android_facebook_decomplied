package com.facebook.analytics;

import android.content.Context;
import com.facebook.analytics.feature.FeatureStatusReporter;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.analytics.util.NetworkDataLogUtils;
import com.facebook.device_id.DeviceIdChangedCallback;
import com.facebook.orca.activity.FbActivityListener;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnBackgroundThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.common.http.OrcaHttpClientObserver;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class AnalyticsModule extends AbstractModule
{
  private final Context a;

  public AnalyticsModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    a(AnalyticsDatabaseSupplier.class).a(new AnalyticsModule.AnalyticsDatabaseSupplierProvider(this, null)).a();
    a(AnalyticsDbSchemaPart.class).a(new AnalyticsModule.AnalyticsDbSchemaPartProvider(this, null)).a();
    a(AnalyticsPropertyUtil.class).a(new AnalyticsModule.AnalyticsPropertyUtilProvider(this, null));
    a(AnalyticsStorage.class).a(new AnalyticsModule.AnalyticsStorageProvider(this, null)).a();
    a(AnalyticsEventProcessor.class).a(new AnalyticsModule.AnalyticsEventProcessorProvider(this, null)).a();
    a(AnalyticCounters.class).a(new AnalyticsModule.AnalyticCountersProvider(this, null)).a();
    a(AnalyticsLogger.class).a(new AnalyticsModule.AnalyticsLoggerProvider(this, null)).a();
    a(CounterHistoricalData.class).a(new AnalyticsModule.CounterHistoricalDataProvider(this, null)).a();
    a(AnalyticsConfig.class).a(new AnalyticsModule.DefaultAnalyticsConfigProvider(this, null)).a();
    a(AnalyticsLogger.MyActivityListener.class).a(new AnalyticsModule.AnalyticsLoggerActivityListenerProvider(this, null)).a();
    c(FbActivityListener.class).a(AnalyticsLogger.MyActivityListener.class);
    a(AnalyticsDeviceUtils.class).a(new AnalyticsModule.AnalyticsDeviceUtilsProvider(this, null)).a();
    a(HoneyAnalyticsUploadHandler.class).a(new AnalyticsModule.HoneyAnalyticsUploadHandlerProvider(this, null)).a();
    a(SendAnalyticLogsMethod.class).a(new AnalyticsModule.SendAnalyticLogsMethodProvider(this, null)).a();
    a(PerformanceLogger.class).a(new AnalyticsModule.PerformanceLoggerProvider(this, null)).a();
    a(AnalyticsInitializer.class).a(new AnalyticsModule.AnalyticsInitializerProvider(this, null)).a();
    a(HoneyAnalyticsPeriodicReporter.class).b(DefaultHoneyAnalyticsPeriodicReporter.class);
    a(DefaultHoneyAnalyticsPeriodicReporter.class).a(new AnalyticsModule.DefaultHoneyAnalyticsPeriodicReporterProvider(this, null)).a();
    a(ReliabilityAnalyticsLogger.class).a(new AnalyticsModule.ReliabilityAnalyticsLoggerProvider(this, null)).a();
    a(AnalyticsOrcaHttpClientObserver.class).a(new AnalyticsModule.AnalyticsOrcaHttpClientObserverProvider(this, null)).a();
    a(AnalyticsServiceOperation.class).a(new AnalyticsModule.AnalyticsServiceOperationProvider(this, null));
    a(AnalyticsServiceManager.class).a(new AnalyticsModule.AnalyticsServiceManagerProvider(this, null)).b();
    a(IAnalyticsService.class).a(new AnalyticsModule.DefaultAnalyticsServiceProvider(this, null));
    c(OrcaHttpClientObserver.class).a(AnalyticsOrcaHttpClientObserver.class);
    a(NetworkDataLogUtils.class).a(new AnalyticsModule.NetworkDataLogUtilsProvider(this, null)).a();
    a(NetworkDataLogger.class).a(null);
    c(FeatureStatusReporter.class);
    a(INeedInit.class, NeedsLowPriorityInitOnBackgroundThread.class).a(AnalyticsInitializer.class);
    c(DeviceIdChangedCallback.class).a(AnalyticsInitializer.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule
 * JD-Core Version:    0.6.2
 */
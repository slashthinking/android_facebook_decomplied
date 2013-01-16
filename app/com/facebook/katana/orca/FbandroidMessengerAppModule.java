package com.facebook.katana.orca;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import com.facebook.analytics.AnalyticsConfig;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.AnalyticsServiceManager;
import com.facebook.analytics.DefaultHoneyAnalyticsPeriodicReporter;
import com.facebook.common.util.TriState;
import com.facebook.config.AppBuildInfo;
import com.facebook.orca.activity.FbActivityListener;
import com.facebook.orca.annotations.DefaultSharedPreferences;
import com.facebook.orca.annotations.IsAnalyticsEnabled;
import com.facebook.orca.annotations.IsInAppNotificationsEnabled;
import com.facebook.orca.annotations.IsMobileAppDataEnabled;
import com.facebook.orca.annotations.MessagesForegroundProviderAuthority;
import com.facebook.orca.annotations.MessagesForegroundProviderUri;
import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnBackgroundThread;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnUiThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.app.IntendedAudience;
import com.facebook.orca.app.MessagesDataInitializationActivityHelper;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.common.visuals.VisualAppTheme;
import com.facebook.orca.config.OrcaConfig;
import com.facebook.orca.config.OrcaProductionConfig;
import com.facebook.orca.config.PlatformAppConfig;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.ContextScope;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.intents.MessagingIntentUris;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.notify.MessagingNotificationPreferences;
import com.facebook.orca.notify.MessengerForegroundProvider;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.push.mqtt.MqttPushServiceManager;
import com.google.inject.util.Providers;

public class FbandroidMessengerAppModule extends AbstractModule
{
  private final Application a;

  public FbandroidMessengerAppModule(Application paramApplication, ContextScope paramContextScope)
  {
    this.a = paramApplication;
  }

  protected void a()
  {
    a(PackageInfo.class).a(new FbandroidMessengerAppModule.FbandroidPackageInfoProvider(this, null));
    a(PlatformAppConfig.class).b(OrcaAppType.class);
    a(IntendedAudience.class).a(new FbandroidMessengerAppModule.IntendedAudienceProvider(null));
    a(SharedPreferences.class).a(DefaultSharedPreferences.class).a(new FbandroidMessengerAppModule.DefaultSharedPreferencesProvider(this, null)).a();
    a(OrcaProductionConfig.class).a(new FbandroidMessengerAppModule.OrcaProductionConfigProvider(this, null)).a();
    a(AppBuildInfo.class).b(OrcaConfig.class);
    a(OrcaConfig.class).a(new FbandroidMessengerAppModule.OrcaConfigProvider(this, null));
    a(MessagingIntentUris.class).a(new FbandroidMessengerAppModule.MessagingIntentUrisProvider(this, null)).a();
    a(MessagingNotificationPreferences.class).a(new FbandroidMessengerAppModule.MessagingNotificationPreferencesProvider(this, null)).a();
    a(VisualAppTheme.class).a(Providers.a(VisualAppTheme.FB4A));
    a(TriState.class).a(IsAnalyticsEnabled.class).a(TriState.NO);
    a(MessagesDataInitializationActivityHelper.class).a(new FbandroidMessengerAppModule.DataInitializationActivityHelperProvider(this, null));
    a(AnalyticsConfig.class).a(new FbandroidMessengerAppModule.AnalyticsConfigProvider(this, null)).a();
    a(FbandroidPushHandler.class).a(new FbandroidMessengerAppModule.FbandroidPushHandlerProvider(this, null));
    a(Boolean.class).a(IsMobileAppDataEnabled.class).c(FbandroidIsMobileAppDataEnabledProvider.class);
    a(Boolean.class).a(IsInAppNotificationsEnabled.class).c(FbAndroidInAppNotificationEnabledProvider.class);
    a(MessengerForegroundProvider.class).a(new FbandroidMessengerAppModule.MessengerForegroundProviderProvider(this, null)).a();
    a(String.class).a(MessagesForegroundProviderUri.class).a("content://com.facebook.orca.notify.MessengerForegroundProvider/orca_foreground");
    a(String.class).a(MessagesForegroundProviderAuthority.class).a("content://com.facebook.orca.notify.FbandroidMessagesForegroundProvider/orca_foreground");
    c(FbActivityListener.class).a(MessagesDataInitializationActivityHelper.class);
    a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class);
    a(INeedInit.class, NeedsLowPriorityInitOnUiThread.class).a(OrcaNetworkManager.class).a(PresenceManager.class).a(MqttPushServiceManager.class).a(AnalyticsLogger.class).a(AnalyticsServiceManager.class).a(DefaultHoneyAnalyticsPeriodicReporter.class);
    a(INeedInit.class, NeedsLowPriorityInitOnBackgroundThread.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidMessengerAppModule
 * JD-Core Version:    0.6.0
 */
package com.facebook.katana.orca;

import android.app.Activity;
import android.app.Application;
import com.facebook.abtest.qe.QuickExperimentModule;
import com.facebook.abtest.qe.registry.QuickExperimentNameHolder;
import com.facebook.analytics.AnalyticsModule;
import com.facebook.analytics.NetworkDataLogger;
import com.facebook.analytics.performance.PerformanceLoggingActivityListener;
import com.facebook.annotations.FragmentChromeActivity;
import com.facebook.annotations.GitHash;
import com.facebook.annotations.IsMeUserAnEmployee;
import com.facebook.annotations.IsMeUserFb4aDeveloper;
import com.facebook.annotations.IsMeUserTrustedTester;
import com.facebook.app.Product;
import com.facebook.appcenter.annotations.IsNativeAppCenterEnabled;
import com.facebook.appcenter.modules.AppCenterModule;
import com.facebook.background.BackgroundTask;
import com.facebook.base.BuildConstants;
import com.facebook.bookmark.client.BookmarkClientModule;
import com.facebook.bookmark.service.BookmarkServiceModule;
import com.facebook.bookmark.ui.event.OnBookmarkSelectedListener;
import com.facebook.bugreporter.BugReporterConfig;
import com.facebook.bugreporter.BugReporterModule;
import com.facebook.common.util.FbBaseCommonUtilsModule;
import com.facebook.common.util.FileUtil;
import com.facebook.common.util.TriState;
import com.facebook.contacts.data.ContactsModule;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.device_id.DeviceIdModule;
import com.facebook.feed.annotations.IsNativeNewsFeedEnabled;
import com.facebook.feed.annotations.IsNativeNewsFeedLogFetchErrorsEnabled;
import com.facebook.feed.annotations.IsNativeNewsFeedPrefetchEnabled;
import com.facebook.feed.annotations.IsNativeNewsfeedSpamReportingEnabled;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.module.NewsFeedModule;
import com.facebook.feed.module.NewsFeedPrefetchTaskModule;
import com.facebook.fragment.IFragmentFactoryInitializer;
import com.facebook.graphql.module.GraphQLModule;
import com.facebook.ipc.feed.FeedIpcModule;
import com.facebook.ipc.notifications.NotificationsContract;
import com.facebook.katana.FbandroidPushModule;
import com.facebook.katana.abtest.FbandroidQuickExperimentNameHolder;
import com.facebook.katana.activity.ActivityAuthHelper;
import com.facebook.katana.activity.ActivityCleaner;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.activity.FbFragmentChromeActivity;
import com.facebook.katana.activity.FbandroidFragmentFactoryInitializer;
import com.facebook.katana.activity.InstallMessengerApkDialogInjector;
import com.facebook.katana.activity.composer.ComposerModule;
import com.facebook.katana.activity.composer.ComposerUriIntentBuilder;
import com.facebook.katana.activity.media.Fb4aCameraModule;
import com.facebook.katana.activity.media.Fb4aPhotosModule;
import com.facebook.katana.activity.nearby.FallBackToFriendCheckinsUriBuilder;
import com.facebook.katana.activity.nearby.IsNearbyPlacesEnabled;
import com.facebook.katana.activity.nearby.NearbyPlacesUriIntentBuilder;
import com.facebook.katana.activity.nearby.SubcategorySelectionUriIntentBuilder;
import com.facebook.katana.activity.pageidentity.PageFriendsInfoUriIntentBuilder;
import com.facebook.katana.activity.pageidentity.PageIdentityUriIntentBuilder;
import com.facebook.katana.activity.pageidentity.PageRecommendationListUriIntentBuilder;
import com.facebook.katana.activity.pageidentity.PageRecommendationUriIntentBuilder;
import com.facebook.katana.annotations.IsFullscreenJewelsEnabled;
import com.facebook.katana.annotations.UserValuesManagerBackend;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.c2dm.Fb4aC2dmPushModule;
import com.facebook.katana.diagnostics.FpsEnableFlagsProvider;
import com.facebook.katana.features.bugreporter.annotations.IsBugReporterAvailable;
import com.facebook.katana.features.tagging.TaggingModule;
import com.facebook.katana.features.uberbar.UberbarFB4AModule;
import com.facebook.katana.friendrequests.FriendingModule;
import com.facebook.katana.gating.Fb4aFeatureGating;
import com.facebook.katana.model.NotificationHelper;
import com.facebook.katana.orca.divebar.Fb4aContactPickerModule;
import com.facebook.katana.platform.PlatformUtilitiesModule;
import com.facebook.katana.provider.FbAndroidKeyValueModule;
import com.facebook.katana.provider.KeyValueStore;
import com.facebook.katana.provider.LegacyKeyValueStore;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.security.MalwareDetector;
import com.facebook.katana.server.Fb4aService;
import com.facebook.katana.server.module.Fb4aServiceModule;
import com.facebook.katana.service.autoupdate.AutoUpdateModule;
import com.facebook.katana.service.vault.VaultModule;
import com.facebook.katana.settings.AppLoggedOutSettingsManager;
import com.facebook.katana.ui.bookmark.BookmarkMenuController;
import com.facebook.katana.util.Fb4aUtilsModule;
import com.facebook.katana.util.FbandroidErrorReportingInitializer;
import com.facebook.katana.util.FqlQueryBuilderUtils;
import com.facebook.katana.util.ImageUtil;
import com.facebook.katana.util.RingtoneUtils;
import com.facebook.location.LocationModule;
import com.facebook.maps.MapsModule;
import com.facebook.maps.annotation.MapApiKeyString;
import com.facebook.megaphone.intent.IMegaphoneIntentBuilder;
import com.facebook.nearby.module.NearbyModule;
import com.facebook.notifications.annotations.IsGraphQLNotificationsEnabled;
import com.facebook.notifications.annotations.IsStaleClientNotificationEnabled;
import com.facebook.notifications.background.FetchStaleClientNotificationBackgroundTask;
import com.facebook.notifications.intent.INotificationRenderer;
import com.facebook.notifications.module.NotificationsModule;
import com.facebook.orca.activity.FbActivityListener;
import com.facebook.orca.annotations.IsSmsOnlyModeActive;
import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.app.AppInitCompleteInitializer;
import com.facebook.orca.app.AppInitializationActivityHelper;
import com.facebook.orca.app.FbBaseModule;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.app.MessagesModule;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.auth.AuthDataStore;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.common.http.OrcaHttpModule;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.ContextScope;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.module.UiModule;
import com.facebook.orca.prefs.DefaultSharedPreferencesModule;
import com.facebook.orca.prefs.OrcaSharedPreferencesModule;
import com.facebook.orca.push.PushModule;
import com.facebook.orca.push.annotations.IsPersistentPushServiceEnabledForApp;
import com.facebook.orca.push.c2dm.C2DMPushModule;
import com.facebook.orca.push.mqtt.MqttPushModule;
import com.facebook.orca.push.mqtt.OrcaMqttPushModule;
import com.facebook.orca.server.ServicesModule;
import com.facebook.pages.identity.annotations.IsNewPageIdentityEnabled;
import com.facebook.pages.identity.module.PageIdentityModule;
import com.facebook.timeline.TimelineModule;
import com.facebook.timeline.annotations.IsNativeTimelineEnabled;
import com.facebook.timeline.ui.titlebar.ITitleBarController;
import com.facebook.timeline.ui.titlebar.IsTimelineTitleBarControllerUsed;
import com.facebook.uberbar.module.UberbarModule;
import com.facebook.uri.UriIntentBuilder;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Key;
import java.util.Set;

public class FbandroidAppModule extends AbstractModule
{
  public static final String a;
  private static final String b = BuildConstants.b() + ".provider.OrcaSharedPrefsProvider";
  private final Application c;
  private final ContextScope d;
  private final OrcaAppType e;
  private final ImmutableSet<FbandroidAppModule.Flag> f;

  static
  {
    a = BuildConstants.b() + ".provider.ACCESS";
  }

  public FbandroidAppModule(Application paramApplication, ContextScope paramContextScope, OrcaAppType paramOrcaAppType, Set<FbandroidAppModule.Flag> paramSet)
  {
    this.c = paramApplication;
    this.d = paramContextScope;
    this.e = paramOrcaAppType;
    this.f = ImmutableSet.a(paramSet);
  }

  private Activity b()
  {
    return (Activity)this.d.getContext();
  }

  // ERROR //
  private void c()
  {
    // Byte code:
    //   0: ldc 85
    //   2: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_2
    //   6: aload_2
    //   7: ldc 93
    //   9: iconst_2
    //   10: anewarray 87	java/lang/Class
    //   13: dup
    //   14: iconst_0
    //   15: ldc 95
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: ldc 97
    //   22: aastore
    //   23: invokevirtual 101	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   26: astore 9
    //   28: new 103	com/facebook/katana/orca/FbandroidAppModule$3
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 106	com/facebook/katana/orca/FbandroidAppModule$3:<init>	(Lcom/facebook/katana/orca/FbandroidAppModule;)V
    //   36: astore 10
    //   38: iconst_2
    //   39: anewarray 108	java/lang/Object
    //   42: astore 11
    //   44: aload 11
    //   46: iconst_0
    //   47: aload 10
    //   49: aastore
    //   50: aload 11
    //   52: iconst_1
    //   53: aload_0
    //   54: getfield 47	com/facebook/katana/orca/FbandroidAppModule:c	Landroid/app/Application;
    //   57: aastore
    //   58: aload 9
    //   60: aconst_null
    //   61: aload 11
    //   63: invokevirtual 114	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: return
    //   68: astore_1
    //   69: aload_1
    //   70: invokestatic 120	com/google/common/base/Throwables:propagate	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   73: athrow
    //   74: astore 7
    //   76: aload 7
    //   78: invokestatic 120	com/google/common/base/Throwables:propagate	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   81: pop
    //   82: goto -15 -> 67
    //   85: astore 5
    //   87: aload 5
    //   89: invokestatic 120	com/google/common/base/Throwables:propagate	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   92: pop
    //   93: goto -26 -> 67
    //   96: astore_3
    //   97: aload_3
    //   98: invokestatic 120	com/google/common/base/Throwables:propagate	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   101: pop
    //   102: goto -35 -> 67
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	68	java/lang/ClassNotFoundException
    //   6	67	74	java/lang/NoSuchMethodException
    //   6	67	85	java/lang/reflect/InvocationTargetException
    //   6	67	96	java/lang/IllegalAccessException
  }

  protected void a()
  {
    a(new FbBaseModule(this.c, this.d, "fb4a"));
    a(new OrcaSharedPreferencesModule(b, a));
    a(new DeviceIdModule());
    a(new FbAndroidKeyValueModule());
    a(new FeedIpcModule(this.c));
    a(new UiModule(this.c));
    Application localApplication = this.c;
    if (!this.f.contains(FbandroidAppModule.Flag.DISABLE_MESSAGES_BACKGROUND_TASKS));
    for (boolean bool = true; ; bool = false)
    {
      a(new MessagesModule(localApplication, bool));
      a(new AnalyticsModule(this.c));
      a(new ContactsModule(this.c));
      a(new OrcaHttpModule(this.c));
      a(new ServicesModule(this.c));
      a(new DefaultSharedPreferencesModule());
      a(new FbandroidMessengerAppModule(this.c, this.d));
      a(new PushModule());
      a(new MqttPushModule(this.c));
      a(new OrcaMqttPushModule(this.c));
      a(new FbandroidPushModule());
      a(new VaultModule(this.c));
      a(new ComposerModule(this.c));
      a(new NewsFeedModule(this.c));
      a(new TimelineModule(this.c));
      a(new AutoUpdateModule());
      a(new BugReporterModule());
      a(new UberbarModule(this.c));
      if (!this.f.contains(FbandroidAppModule.Flag.DISABLE_DASH_MODULE))
        c();
      a(new Fb4aServiceModule(this.c));
      a(new Fb4aUtilsModule(this.c));
      a(new NotificationsModule(NotificationsContract.a));
      a(new FriendingModule());
      a(new Fb4aPhotosModule(this.c));
      a(new Fb4aCameraModule());
      a(new UberbarFB4AModule());
      a(new C2DMPushModule());
      a(new Fb4aC2dmPushModule());
      a(new GraphQLModule(this.c));
      a(new MapsModule());
      a(new NearbyModule(this.c));
      a(new AppCenterModule(this.c, this.d));
      a(new FbBaseCommonUtilsModule(this.c));
      a(new Fb4aContactPickerModule());
      a(new ForceMessengerModule());
      a(new BookmarkClientModule(this.c, Fb4aService.class));
      a(new BookmarkServiceModule(this.c, 1200000));
      a(new PageIdentityModule(this.c));
      a(new TaggingModule());
      a(new LocationModule());
      a(new QuickExperimentModule(this.c, Fb4aService.class));
      a(new PlatformUtilitiesModule());
      if (!this.f.contains(FbandroidAppModule.Flag.DISABLE_NEWSFEED_PREFETCH))
        a(new NewsFeedPrefetchTaskModule(this.c));
      a(FbandroidAuthDataStore.class).a(new FbandroidAppModule.FbandroidAuthDataStoreProvider(this, null)).a();
      a(MeUserAuthDataStore.class).b(FbandroidAuthDataStore.class);
      a(AuthDataStore.class).b(FbandroidAuthDataStore.class);
      a(Boolean.class).a(IsPersistentPushServiceEnabledForApp.class).a(Boolean.valueOf(true));
      a(Boolean.class).a(IsSmsOnlyModeActive.class).a(Boolean.valueOf(false));
      a(InstallMessengerApkDialogInjector.class).a(new FbandroidAppModule.InstallMessengerApkDialogInjectorProvider(this, null)).a();
      a(ActivityAuthHelper.class).a(new FbandroidAppModule.ActivityAuthHelperProvider(this, null));
      a(AppInitializationActivityHelper.class).a(new FbandroidAppModule.AppInitializationActivityHelperProvider(this, null));
      a(FacebookActivityDelegate.class).a(new FbandroidAppModule.FacebookActivityDelegateProvider(this, null)).e();
      a(ITitleBarController.class).a(new FbandroidAppModule.TitleBarControllerProvider(this, null)).e();
      a(Boolean.class).a(IsTimelineTitleBarControllerUsed.class).a(Boolean.valueOf(true));
      a(OnBookmarkSelectedListener.class).a(new FbandroidAppModule.OnBookmarkSelectedListenerProvider(this, null)).e();
      a(BookmarkMenuController.class).a(new FbandroidAppModule.BookmarkMenuControllerProvider(this, null)).e();
      a(PerformanceLoggingActivityListener.class).a(new FbandroidAppModule.PerformanceLoggingActivityListenerProvider(this, null));
      c(FbActivityListener.class).a(AppInitializationActivityHelper.class).a(PerformanceLoggingActivityListener.class).a(FacebookActivityDelegate.class).a(ActivityAuthHelper.class).a(InstallMessengerApkDialogInjector.class);
      a(IFeedIntentBuilder.class).a(new FbandroidAppModule.NewsFeedIntentBuilderProvider(this, null)).a();
      a(INotificationRenderer.class).a(new FbandroidAppModule.NotificationIntentBuilderProvider(this, null)).a();
      a(IMegaphoneIntentBuilder.class).a(new FbandroidAppModule.MegaphoneIntentBuilderProvider(this, null)).a();
      a(ImageUtil.class).a(new FbandroidAppModule.ImageUtilProvider(this, null));
      a(AppSession.class).a(new FbandroidAppModule.AppSessionProvider(this, null));
      a(NetworkDataLogger.class).a(new FbandroidAppModule.NetworkDataLoggerProvider(this, null)).a();
      a(OrcaAppType.class).a(this.e);
      a(Key.a(new FbandroidAppModule.1(this), FragmentChromeActivity.class)).a(FbFragmentChromeActivity.class);
      a(Fb4aFeatureGating.class).a(new FbandroidAppModule.FeatureGatingProvider(this, null)).a();
      a(Boolean.class).a(IsBugReporterAvailable.class).a(new FbandroidAppModule.IsBugReporterAvailableProvider(this, null));
      a(NotificationHelper.class).a(new FbandroidAppModule.NotificationHelperProvider(this, null));
      a(FqlQueryBuilderUtils.class).a(new FqlQueryBuilderUtils());
      a(DeviceConditionHelper.class).a(new FbandroidAppModule.DeviceConditionHelperProvider(this, null)).a();
      c(BackgroundTask.class).a(FetchStaleClientNotificationBackgroundTask.class);
      a(FileUtil.class).a(new FileUtil());
      a(RingtoneUtils.class).a(new FbandroidAppModule.RingtoneUtilsProvider(this, null));
      c(QuickExperimentNameHolder.class).a(FbandroidQuickExperimentNameHolder.class);
      a(FbandroidErrorReportingInitializer.class).a(new FbandroidAppModule.FbandroidErrorReportingInitializerProvider(this, null));
      a(Product.class).a(new FbandroidAppModule.ProductProvider(this, null));
      a(String.class).a(MapApiKeyString.class).a(new FbandroidAppModule.MapApiKeyProvider(this, null));
      a(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class).a(FbandroidErrorReportingInitializer.class).a(AppInitCompleteInitializer.class);
      a(TriState.class).a(IsMeUserAnEmployee.class).a(new FbandroidAppModule.IsMeUserAnEmployeeProvider(this));
      a(TriState.class).a(IsMeUserFb4aDeveloper.class).a(new FbandroidAppModule.IsMeUserFb4aDeveloperProvider(this));
      a(TriState.class).a(IsMeUserTrustedTester.class).a(new FbandroidAppModule.IsMeUserTrustedTesterProvider(this));
      a(UserValuesManager.class).a(new FbandroidAppModule.UserValuesManagerProvider(this, null));
      a(KeyValueStore.class).a(UserValuesManagerBackend.class).a(new FbandroidAppModule.UserValuesStoreProvider(this, null));
      a(LegacyKeyValueStore.class).a(UserValuesManagerBackend.class).a(new FbandroidAppModule.UserValuesLegacyKeyValueStoreProvider(this, null));
      a(MalwareDetector.class).a(new FbandroidAppModule.MalwareDetectorProvider(this, null)).a();
      a(String.class).a(GitHash.class).a(new FbandroidAppModule.GitHashProvider(this, null));
      a(PageIdentityUriIntentBuilder.class).a(new FbandroidAppModule.PagesUriIntentBuilderProvider(this, null)).a();
      c(UriIntentBuilder.class).a(PageIdentityUriIntentBuilder.class);
      a(PageFriendsInfoUriIntentBuilder.class).a(new FbandroidAppModule.PageFriendsInfoUriIntentBuilderProvider(this, null)).a();
      c(UriIntentBuilder.class).a(PageFriendsInfoUriIntentBuilder.class);
      a(ComposerUriIntentBuilder.class).a(new FbandroidAppModule.ComposerUriIntentBuilderProvider(this, null)).a();
      c(UriIntentBuilder.class).a(ComposerUriIntentBuilder.class);
      a(PageRecommendationListUriIntentBuilder.class).a(new FbandroidAppModule.PageRecommenationListUriIntentBuilderProvider(this, null)).a();
      c(UriIntentBuilder.class).a(PageRecommendationListUriIntentBuilder.class);
      a(PageRecommendationUriIntentBuilder.class).a(new FbandroidAppModule.PageRecommendationUriIntentBuilderProvider(this, null)).a();
      c(UriIntentBuilder.class).a(PageRecommendationUriIntentBuilder.class);
      a(NearbyPlacesUriIntentBuilder.class).a(new FbandroidAppModule.NearbyPlacesUriIntentBuilderProvider(this, null)).a();
      c(UriIntentBuilder.class).a(NearbyPlacesUriIntentBuilder.class);
      a(SubcategorySelectionUriIntentBuilder.class).a(new FbandroidAppModule.SubcategorySelectionUriIntentBuilderProvider(this, null)).a();
      c(UriIntentBuilder.class).a(SubcategorySelectionUriIntentBuilder.class);
      a(FallBackToFriendCheckinsUriBuilder.class).a(new FbandroidAppModule.FriendCheckinsActivityUriBuilderProvider(this, null)).a();
      c(UriIntentBuilder.class).a(FallBackToFriendCheckinsUriBuilder.class);
      a(FbandroidFragmentFactoryInitializer.class).a(new FbandroidAppModule.FbandroidFragmentFactoryInitializerProvider(this, null));
      c(IFragmentFactoryInitializer.class).a(FbandroidFragmentFactoryInitializer.class);
      a(BugReporterConfig.class).a(new FbandroidAppModule.Fb4aBugReporterConfigProvider(this, null)).a();
      a(ActivityCleaner.class).a(new FbandroidAppModule.ActivityCleanerProvider(this, null)).a();
      c(FbActivityListener.class).a(ActivityCleaner.class);
      a(Boolean.class).a(IsNativeNewsFeedEnabled.class).a(new FbandroidAppModule.IsNativeNewsFeedEnabledProvider(this, null));
      a(Boolean.class).a(IsNativeNewsFeedPrefetchEnabled.class).a(new FbandroidAppModule.IsNativeNewsFeedPrefetchEnabledProvider(this, null));
      a(Boolean.class).a(IsNativeNewsFeedLogFetchErrorsEnabled.class).a(new FbandroidAppModule.IsNativeNewsFeedLogFetchErrorsEnabledProvider(this, null));
      a(Boolean.class).a(IsNativeNewsfeedSpamReportingEnabled.class).a(new FbandroidAppModule.IsNativeNewsfeedSpamReportingEnabledProvider(this, null));
      a(Boolean.class).a(IsNativeTimelineEnabled.class).a(new FbandroidAppModule.IsNativeTimelineEnabledProvider(this, null));
      a(Boolean.class).a(IsNativeAppCenterEnabled.class).a(new FbandroidAppModule.IsNativeAppCenterEnabledProvider(this, null));
      a(Boolean.class).a(IsNewPageIdentityEnabled.class).a(new FbandroidAppModule.IsNewPageIdentityEnabledProvider(this, null));
      a(Boolean.class).a(IsStaleClientNotificationEnabled.class).a(new FbandroidAppModule.IsStaleClientNotificationEnabledProvider(this, null));
      a(Boolean.class).a(IsNearbyPlacesEnabled.class).a(new FbandroidAppModule.IsNearbyPlacesEnabledProvider(this, null));
      a(Boolean.class).a(IsGraphQLNotificationsEnabled.class).a(new FbandroidAppModule.IsGraphQLNotificationsEnabledProvider(this, null));
      a(AppLoggedOutSettingsManager.class).a(new FbandroidAppModule.AppLoggedOutSettingsManagerProvider(this, null)).a();
      a(Key.a(new FbandroidAppModule.2(this))).c(FpsEnableFlagsProvider.class);
      a(Boolean.class).a(IsFullscreenJewelsEnabled.class).a(new FbandroidAppModule.IsFullscreenJewelsEnabledProvider(null));
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule
 * JD-Core Version:    0.6.0
 */
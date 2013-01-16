package com.facebook.orca.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.admin.DevicePolicyManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.location.Geocoder;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Vibrator;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.TelephonyManager;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.facebook.android.os.DeferredHandler;
import com.facebook.annotations.GitHash;
import com.facebook.annotations.MyProcessId;
import com.facebook.app.Product;
import com.facebook.app.UserActivityModule;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.ProcessUtil;
import com.facebook.content.ContentModule;
import com.facebook.hardware.BatteryStateManager;
import com.facebook.hardware.CellDiagnosticsSerializer;
import com.facebook.hardware.DeviceInfoSerializer;
import com.facebook.hardware.ScreenPowerState;
import com.facebook.hardware.WifiDiagnosticsSerializer;
import com.facebook.login.LoginModule;
import com.facebook.orca.activity.FbActivityListener;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.annotations.ForLightweightTaskHandlerThread;
import com.facebook.orca.annotations.ForUiThread;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.InsecureRandom;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnBackgroundThread;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnUiThread;
import com.facebook.orca.annotations.PhoneIsoCountryCode;
import com.facebook.orca.common.OrcaWakeLockManager;
import com.facebook.orca.common.async.KeyedExecutor;
import com.facebook.orca.common.async.PrioritySerialExecutor;
import com.facebook.orca.common.util.AndroidTaskUtil;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.ObjectPoolManager;
import com.facebook.orca.common.util.PhoneIsoCountryCodeProvider;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.debug.ActivityTracer;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.FbLog;
import com.facebook.orca.debug.FbLogImpl;
import com.facebook.orca.debug.FbLogWriter;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.ContextScope;
import com.facebook.orca.inject.ContextScoped;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.FbInjectorImpl.LessEagerUiThreadSingletonInitializer;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.login.AuthComponent;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.task.IncrementalTaskExecutor;
import com.facebook.uri.FbUriIntentHandler;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.ExecutionList;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class FbBaseModule extends AbstractModule
{
  private final Context a;
  private final ContextScope b;
  private final String c;

  static
  {
    ExecutionList.a(new FbBaseModule.1());
  }

  public FbBaseModule(Context paramContext, ContextScope paramContextScope, String paramString)
  {
    this.a = paramContext;
    this.b = paramContextScope;
    this.c = paramString;
  }

  private <T> void a(Class<T> paramClass, String paramString)
  {
    a(paramClass).a(new FbBaseModule.SystemServiceProvider(this, paramString));
    a(paramClass).a(FromApplication.class).a(new FbBaseModule.AppSystemServiceProvider(this, paramString));
  }

  protected void a()
  {
    a(new LoginModule());
    a(new UserActivityModule());
    a(new ContentModule());
    a(ContextScoped.class, this.b);
    a(ContextScope.class).a(this.b);
    a(Context.class).a(new FbBaseModule.ContextProvider(this, null));
    this.b.a(this.a);
    a(Clock.class).b(SystemClock.class);
    a(SystemClock.class).a(new FbBaseModule.SystemClockProvider(null)).a();
    a(Random.class).a(InsecureRandom.class).a(new FbBaseModule.RandomProvider(null));
    a(JsonFactory.class).a(new FbBaseModule.JsonFactoryProvider(null)).a();
    a(ObjectMapper.class).a(new FbBaseModule.ObjectMapperProvider(null)).a();
    a(ObjectPoolManager.class).a(new FbBaseModule.ObjectPoolManagerProvider(this, null)).a();
    a(Locale.class).a(new FbBaseModule.LocaleProvider(null));
    a(LocationManager.class, "location");
    a(WindowManager.class, "window");
    a(LayoutInflater.class, "layout_inflater");
    a(ActivityManager.class, "activity");
    a(PowerManager.class, "power");
    a(DevicePolicyManager.class, "device_policy");
    a(AlarmManager.class, "alarm");
    a(NotificationManager.class, "notification");
    a(KeyguardManager.class, "keyguard");
    a(SearchManager.class, "search");
    a(Vibrator.class, "vibrator");
    a(ConnectivityManager.class, "connectivity");
    a(WifiManager.class, "wifi");
    a(InputMethodManager.class, "input_method");
    a(SensorManager.class, "sensor");
    a(ClipboardManager.class, "clipboard");
    a(TelephonyManager.class, "phone");
    a(AudioManager.class, "audio");
    if (Build.VERSION.SDK_INT >= 9)
      a(DownloadManager.class, "download");
    a(Context.class).a(new FbBaseModule.ContextProvider(this, null));
    a(Context.class).a(FromApplication.class).a(this.a);
    a(Activity.class).a(new FbBaseModule.ActivityProvider(this, null));
    a(Resources.class).a(new FbBaseModule.ResourcesProvider(this, null));
    a(ContentResolver.class).a(new FbBaseModule.ContentResolverProvider(this, null));
    a(ContentResolver.class).a(FromApplication.class).a(new FbBaseModule.ContentResolverProviderFromApp(this, null));
    a(FragmentManager.class).a(new FbBaseModule.FragmentManagerProvider(this, null));
    a(ProcessUtil.class).a(new FbBaseModule.ProcessUtilProvider(this, null)).a();
    a(Integer.class).a(MyProcessId.class).a(new FbBaseModule.MyProcessIdProvider(this, null));
    a(PackageManager.class).a(this.a.getPackageManager());
    a(AndroidTaskUtil.class).a(new FbBaseModule.AndroidTaskUtilProvider(this, null));
    a(LocalBroadcastManager.class).a(new FbBaseModule.LocalBroadcastManagerProvider(this, null)).a();
    a(OrcaNetworkManager.class).a(new FbBaseModule.NetworkManagerProvider(this, null)).a();
    a(Handler.class).a(new FbBaseModule.HandlerProvider(null));
    a(ExecutorService.class).a(DefaultExecutorService.class).a(new FbBaseModule.DefaultExecutorServiceProvider(this, null)).a();
    a(ListeningExecutorService.class).a(DefaultExecutorService.class).a(new FbBaseModule.DefaultListeningExecutorServiceProvider(this, null)).a();
    a(AndroidThreadUtil.class).a(new FbBaseModule.AndroidThreadUtilProvider(this, null)).a();
    a(KeyedExecutor.class).a(new FbBaseModule.KeyedExecutorProvider(this, null)).a();
    a(PrioritySerialExecutor.class).a(DefaultExecutorService.class).a(new FbBaseModule.DefaultPrioritySerialExecutorProvider(this, null));
    a(ActivityTracer.class).a(new FbBaseModule.ActivityTracerProvider(this, null)).a();
    a(Executor.class).a(ForUiThread.class).a(ExecutorService.class, ForUiThread.class);
    a(ExecutorService.class).a(ForUiThread.class).a(ListeningExecutorService.class, ForUiThread.class);
    a(ListeningExecutorService.class).a(ForUiThread.class).a(ListeningScheduledExecutorService.class, ForUiThread.class);
    a(ScheduledExecutorService.class).a(ForUiThread.class).a(ListeningScheduledExecutorService.class, ForUiThread.class);
    a(ScheduledExecutorService.class).a(ForLightweightTaskHandlerThread.class).a(ListeningScheduledExecutorService.class, ForUiThread.class);
    a(ListeningScheduledExecutorService.class).a(ForUiThread.class).a(new FbBaseModule.UiThreadListeningScheduledExecutorServiceProvider(this, null)).a();
    a(DeferredHandler.class).a(new FbBaseModule.DeferredHandlerProvider(this, null));
    a(Geocoder.class).a(new FbBaseModule.GeocoderProvider(this, null)).a();
    a(IncrementalTaskExecutor.class).a(new FbBaseModule.IncrementalTaskExecutorProvider(this, null)).a();
    a(UserInteractionController.class).a(new FbBaseModule.UserInteractionControllerProvider(this, null)).a();
    a(UserInteractionController.ActivityListener.class).a(new FbBaseModule.UserInteractionControllerActivityListenerProvider(this, null));
    a(ScreenPowerState.class).a(new FbBaseModule.ScreenPowerStateProvider(this, null)).a();
    a(BatteryStateManager.class).a(new FbBaseModule.BatteryStateManagerProvider(this, null)).a();
    a(CellDiagnosticsSerializer.class).a(new FbBaseModule.CellDiagnosticsSerializerProvider(this, null)).a();
    a(WifiDiagnosticsSerializer.class).a(new FbBaseModule.WifiDiagnosticsSerializerProvider(this, null)).a();
    a(DeviceInfoSerializer.class).a(new FbBaseModule.DeviceInfoSerializerProvider(this, null)).a();
    a(ActivityBroadcaster.class).a(new FbBaseModule.ActivityBroadcasterProvider(this, null)).a();
    a(FbAppInitializer.class).a(new FbBaseModule.FbAppInitializerProvider(this, null));
    a(AppInitLock.class).a(new FbBaseModule.AppInitLockProvider(this, null)).a();
    a(AppInitCompleteInitializer.class).a(new FbBaseModule.AppInitCompleteInitializerProvider(this, null));
    a(FbAppUserDataCleaner.class).a(new FbBaseModule.FbAppUserDataCleanerProvider(this, null)).a();
    a(FbUriIntentHandler.class).a(new FbBaseModule.FbUriIntentHandlerProvider(this, null)).a();
    b(Product.class).a(Product.UNKNOWN);
    a(FbLogImpl.class).a(new FbBaseModule.FbLogImplProvider(this, null)).a();
    a(FbErrorReporter.class).a(new FbBaseModule.FbErrorReporterProvider(this, null)).a();
    a(OrcaWakeLockManager.class).a(new FbBaseModule.OrcaWakeLockManagerProvider(this, null)).a();
    c(FbActivityListener.class);
    c(FbLogWriter.class);
    a(INeedInit.class, NeedsLowPriorityInitOnUiThread.class);
    a(INeedInit.class, NeedsLowPriorityInitOnBackgroundThread.class);
    c(IHaveUserData.class);
    c(AuthComponent.class).a(FbAppUserDataCleaner.class);
    c(FbActivityListener.class).a(UserInteractionController.ActivityListener.class);
    a(FbInjectorImpl.LessEagerUiThreadSingletonInitializer.class).a(new FbBaseModule.LessEagerUiThreadSingletonInitializerProvider(this, null));
    a(INeedInit.class, NeedsLowPriorityInitOnUiThread.class).a(FbInjectorImpl.LessEagerUiThreadSingletonInitializer.class);
    a(String.class).a(GitHash.class).a("");
    a(String.class).a(PhoneIsoCountryCode.class).c(PhoneIsoCountryCodeProvider.class);
  }

  public void a(FbInjector paramFbInjector)
  {
    BLog.a((FbLog)paramFbInjector.a(FbLogImpl.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule
 * JD-Core Version:    0.6.0
 */
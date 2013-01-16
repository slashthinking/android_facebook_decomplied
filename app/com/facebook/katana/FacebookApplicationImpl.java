package com.facebook.katana;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.analytics.performance.PerformanceLogger.MarkerConfig;
import com.facebook.app.ApplicationLike;
import com.facebook.base.BuildConstants;
import com.facebook.katana.activity.FbFragmentChromeActivity;
import com.facebook.katana.orca.FbandroidAppModule;
import com.facebook.katana.orca.FbandroidAppModule.Flag;
import com.facebook.katana.util.FB4AErrorReporting;
import com.facebook.orca.app.AppInitLock;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.inject.ContextScope;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.FbInjectorProvider;
import com.facebook.orca.inject.Module;
import com.google.common.base.FinalizableReferenceQueue;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FacebookApplicationImpl extends ApplicationLike
  implements FbInjectorProvider
{
  public static final String a = FacebookApplication.class.getSimpleName();
  private final OrcaAppType b;
  private final List<String> c = Lists.a(new String[] { "android.permission.DISABLE_KEYGUARD", "android.permission.READ_CALENDAR", "android.permission.RECEIVE_BOOT_COMPLETED", "android.permission.WRITE_CALENDAR", "android.permission.WRITE_SETTINGS", "android.permission.RECEIVE_MMS", "android.permission.SEND_SMS" });

  public FacebookApplicationImpl(Application paramApplication, OrcaAppType paramOrcaAppType)
  {
    super(paramApplication);
    this.b = paramOrcaAppType;
  }

  private void a(long paramLong1, long paramLong2)
  {
    PerformanceLogger localPerformanceLogger = (PerformanceLogger)d().a(PerformanceLogger.class);
    localPerformanceLogger.a(paramLong2);
    localPerformanceLogger.a(new PerformanceLogger.MarkerConfig("ColdStart").a(paramLong1).a(new Class[] { LoginActivity.class, FbFragmentChromeActivity.class }).a());
    localPerformanceLogger.a(new PerformanceLogger.MarkerConfig("NNFColdStart").a(paramLong1).a(new Class[] { LoginActivity.class, FbFragmentChromeActivity.class }).a());
    localPerformanceLogger.a(new PerformanceLogger.MarkerConfig("NNFCacheColdStart").a(paramLong1).a(new Class[] { LoginActivity.class, FbFragmentChromeActivity.class }).a());
    PerformanceLogger.MarkerConfig localMarkerConfig = new PerformanceLogger.MarkerConfig("ApplicationOnCreate").a(paramLong1).b(paramLong2);
    localPerformanceLogger.a(localMarkerConfig);
    localPerformanceLogger.b(localMarkerConfig);
  }

  private static void e()
  {
  }

  protected List<Module> a(String paramString, ContextScope paramContextScope)
  {
    String[] arrayOfString = paramString.split(":");
    if (arrayOfString.length == 1);
    for (EnumSet localEnumSet = EnumSet.noneOf(FbandroidAppModule.Flag.class); ; localEnumSet = EnumSet.of(FbandroidAppModule.Flag.DISABLE_MESSAGES_BACKGROUND_TASKS, FbandroidAppModule.Flag.DISABLE_NEWSFEED_PREFETCH))
    {
      if (!BuildConstants.a())
        localEnumSet.add(FbandroidAppModule.Flag.DISABLE_DASH_MODULE);
      return ImmutableList.a(new FbandroidAppModule(a(), paramContextScope, this.b, localEnumSet));
      if (!"lss".equals(arrayOfString[1]))
        break;
    }
    throw new IllegalArgumentException("Unknown process: " + arrayOfString[1]);
  }

  public void b()
  {
    long l1 = SystemClock.b().a();
    super.b();
    Logger.getLogger(FinalizableReferenceQueue.class.getName()).setLevel(Level.SEVERE);
    if ((!BuildConstants.a()) && ((0x2 & a().getApplicationInfo().flags) != 0))
      throw new RuntimeException("Forcing crash (debuggable=true in release build)");
    Tracer.b(5L);
    Tracer localTracer = Tracer.a("FacebookApplicationImpl.onCreate");
    FB4AErrorReporting.a(a());
    BLog.a(5);
    e();
    FbInjector localFbInjector = d();
    if (!BuildConstants.a())
    {
      PackageManager localPackageManager = (PackageManager)localFbInjector.a(PackageManager.class);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (localPackageManager.checkPermission(str, BuildConstants.b()) != 0)
          continue;
        throw new RuntimeException(BuildConstants.b() + " has permission " + str + ", which should be stripped out of the build");
      }
    }
    localTracer.a();
    long l2 = SystemClock.b().a();
    ((AppInitLock)localFbInjector.a(AppInitLock.class)).a(new FacebookApplicationImpl.1(this, l1, l2, localFbInjector));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FacebookApplicationImpl
 * JD-Core Version:    0.6.0
 */
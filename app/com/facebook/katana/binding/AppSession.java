package com.facebook.katana.binding;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebStorage;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.common.util.Tuple;
import com.facebook.debug.Assert;
import com.facebook.device_id.UniqueDeviceIdBroadcastSender;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.LoginActivity;
import com.facebook.katana.activity.composer.ComposerActivity;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.features.faceweb.FacewebUriMap;
import com.facebook.katana.features.places.SelectAtTagFetcher.SearchType;
import com.facebook.katana.features.places.SelectAtTagFetcher.SelectAtTagArgType;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.model.FacebookNotifications;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.FacebookPhotoSet;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.katana.model.FacebookPhotoTagBase;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.FacebookUserFull;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.prefs.NativeGdpPrefsKeys;
import com.facebook.katana.prefs.NotificationPrefKeys;
import com.facebook.katana.provider.FacebookDatabaseHelper;
import com.facebook.katana.provider.KeyValueManager;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.service.BackgroundDetectionService;
import com.facebook.katana.service.FacebookService;
import com.facebook.katana.service.MediaUploadService;
import com.facebook.katana.service.autoupdate.AutoUpdateServiceStarter;
import com.facebook.katana.service.method.ApiMethod;
import com.facebook.katana.service.method.ApiMethodCallback;
import com.facebook.katana.service.method.FqlGetAtTags;
import com.facebook.katana.service.method.FqlGetFriendCheckins;
import com.facebook.katana.service.method.PlacesCheckin;
import com.facebook.katana.service.method.PostLoginSyncRequest;
import com.facebook.katana.service.method.ServiceOperation;
import com.facebook.katana.service.method.StreamPublish;
import com.facebook.katana.service.vault.VaultManager;
import com.facebook.katana.ui.mentions.MentionsUtils;
import com.facebook.katana.util.FB4AErrorReporting;
import com.facebook.katana.util.PlatformUtils;
import com.facebook.katana.util.ReentrantCallback;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.logging.MobileEventLogger;
import com.facebook.katana.util.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.katana.webview.FacewebComponentsStoreCache;
import com.facebook.notifications.annotations.IsGraphQLNotificationsEnabled;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.app.FbAppUserDataCleaner;
import com.facebook.orca.app.OrcaDataManager;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.SecureHashUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.login.AuthStateMachineMonitor;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.push.PushInitializer;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class AppSession
{
  public static boolean a;
  private static final Class<?> e = AppSession.class;
  private static boolean f = false;
  private static boolean g = false;
  private static final AppSession.PreloadStep[] h;
  private static final AppSessionManager i;
  private static int j;
  private boolean A = false;
  private PowerManager.WakeLock B;
  private final Map<Integer, Integer> C = new HashMap();
  private PerformanceLogger D;
  private Map<String, Intent> E = new HashMap();
  final ReentrantCallback<AppSessionListener> b;
  public Map<String, Long> c;
  public Map<Tuple<String, String>, String> d;
  private final String k = m();
  private final Map<String, Intent> l;
  private final ProfileImagesCache m;
  private final StreamPhotosCache n;
  private WorkerThread o;
  private FacebookSessionInfo p;
  private AppSession.LoginStatus q;
  private PendingIntent r;
  private PendingIntent s;
  private PendingIntent t;
  private PendingIntent u;
  private PendingIntent v;
  private PendingIntent w;
  private long x;
  private boolean y = false;
  private Set<AppSession.PreloadStep> z = new HashSet();

  static
  {
    a = false;
    AppSession.PreloadStep[] arrayOfPreloadStep = new AppSession.PreloadStep[3];
    arrayOfPreloadStep[0] = AppSession.PreloadStep.FETCH_GATEKEEPERS;
    arrayOfPreloadStep[1] = AppSession.PreloadStep.FETCH_SKELETON;
    arrayOfPreloadStep[2] = AppSession.PreloadStep.FETCH_FACEWEB_URI_MAP;
    h = arrayOfPreloadStep;
    i = new AppSessionManager();
  }

  public AppSession()
  {
    i.a(this);
    this.l = new ConcurrentHashMap();
    this.b = new ReentrantCallback();
    this.q = AppSession.LoginStatus.STATUS_LOGGED_OUT;
    this.m = new ProfileImagesCache(new AppSession.1(this));
    this.n = new StreamPhotosCache(new AppSession.2(this));
    this.x = -1L;
    this.p = FacebookSessionInfo.sInvalidSessionInfo;
    n();
  }

  public static AppSession a(Context paramContext, boolean paramBoolean)
  {
    return i.a(paramContext, paramBoolean);
  }

  public static String a(Context paramContext)
  {
    try
    {
      String str2 = KeyValueManager.a(paramContext, "last_username", null);
      str1 = str2;
      return str1;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        String str1 = null;
    }
  }

  private String a(Context paramContext, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2, String paramString3)
  {
    String str = m();
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    localIntent.putExtra("type", paramInt);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("uid", paramLong1);
    localIntent.putExtra("aid", paramString1);
    localIntent.putExtra("pid", paramString2);
    localIntent.putExtra("fbid", paramLong2);
    localIntent.putExtra("uri", paramString3);
    a(paramContext, str, localIntent);
    return str;
  }

  private String a(Context paramContext, long paramLong, String paramString)
  {
    String str = m();
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    localIntent.putExtra("type", 100);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("uid", paramLong);
    localIntent.putExtra("uri", paramString);
    a(paramContext, str, localIntent);
    return str;
  }

  public static void a(Context paramContext, Intent paramIntent, int paramInt, String paramString, Exception paramException, Object paramObject1, Object paramObject2)
  {
    String str1 = paramIntent.getStringExtra("sid");
    AppSession localAppSession1 = i.b(str1);
    if (localAppSession1 != null)
    {
      localAppSession1.b(paramContext, paramIntent, paramInt, paramString, paramException, paramObject1, paramObject2);
      return;
    }
    int i1 = paramIntent.getIntExtra("type", -1);
    StringBuilder localStringBuilder1;
    Bundle localBundle;
    StringBuilder localStringBuilder2;
    switch (i1)
    {
    default:
      if (i1 != 65)
        break;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(" reqIntent: ").append(paramIntent.toString());
      localBundle = paramIntent.getExtras();
      localStringBuilder2 = localStringBuilder1.append(" reqIntent.extras: ");
      if (localBundle == null);
    case 90:
    case 91:
    case 92:
    case 201:
    case 202:
    case 203:
    case 204:
    case 300:
    case 205:
    }
    for (String str2 = localBundle.toString(); ; str2 = "")
    {
      localStringBuilder2.append(str2);
      localStringBuilder1.append(" mSessionMap: ");
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = i.c();
      StringUtils.a(localStringBuilder1, ", ", null, arrayOfObject);
      ErrorReporting.a("photoupload_stuck", localStringBuilder1.toString());
      Log.a("onServiceOperationComplete", "No session: " + i1);
      break;
      AppSession localAppSession3 = a(paramContext, false);
      if (localAppSession3 != null)
      {
        localAppSession3.b(paramContext, paramIntent, paramInt, paramString, paramException, paramObject1, paramObject2);
        break;
      }
      Log.a("onServiceOperationComplete", "No session: " + paramIntent.getIntExtra("type", -1));
      break;
      AppSession localAppSession2 = a(paramContext, false);
      if (localAppSession2 != null)
      {
        localAppSession2.b(paramContext, paramIntent, paramInt, paramString, paramException, paramObject1, paramObject2);
        break;
      }
      Log.a("onServiceOperationComplete", "No session: " + paramIntent.getIntExtra("type", -1));
      break;
    }
  }

  public static void a(Context paramContext, Intent paramIntent, Object paramObject1, Object paramObject2)
  {
    String str = paramIntent.getStringExtra("sid");
    AppSession localAppSession = i.b(str);
    if (localAppSession != null)
      localAppSession.b(paramContext, paramIntent, paramObject1, paramObject2);
  }

  public static void a(Context paramContext, AppSession paramAppSession)
  {
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    String str = m();
    localIntent.putExtra("type", 3);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", paramAppSession.k);
    localIntent.putExtra("session_key", paramAppSession.p.sessionKey);
    localIntent.putExtra("uid", paramAppSession.p.userId);
    paramAppSession.a(paramContext, str, localIntent);
  }

  private void a(Context paramContext, Integer paramInteger)
  {
    monitorenter;
    try
    {
      if (this.B == null)
        this.B = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "FacebookService");
      this.B.acquire();
      if (!this.C.containsKey(paramInteger));
      int i1;
      for (int i2 = 0; ; i2 = i1)
      {
        this.C.put(paramInteger, Integer.valueOf(i2 + 1));
        return;
        i1 = ((Integer)this.C.get(paramInteger)).intValue();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void a(Context paramContext, String paramString1, int paramInt, String paramString2, Exception paramException, Object paramObject, boolean paramBoolean)
  {
    if (i.a().equals(this.k))
      if (paramInt == 200)
      {
        if (!paramBoolean)
          ((UniqueDeviceIdBroadcastSender)j(paramContext).a(UniqueDeviceIdBroadcastSender.class)).a();
        b(paramContext, (FacebookSessionInfo)paramObject);
        FacebookAffiliation.b(paramContext);
        if (!paramBoolean)
          ((PushInitializer)j(paramContext).a(PushInitializer.class)).b();
      }
    while (true)
    {
      Iterator localIterator = this.b.a().iterator();
      while (localIterator.hasNext())
        ((AppSessionListener)localIterator.next()).b(this, paramString1, paramInt, paramString2, paramException);
      this.q = AppSession.LoginStatus.STATUS_LOGGED_OUT;
      i.a(this.k);
      continue;
      i.a(this.k);
    }
  }

  private void a(Context paramContext, String paramString, Intent paramIntent)
  {
    if (c())
    {
      String str = b().sessionSecret;
      if (str != null)
        paramIntent.putExtra("ApiMethod.secret", str);
    }
    if ((AppSession.LoginStatus.STATUS_LOGGING_IN != this.q) || (a(paramIntent)))
    {
      this.l.put(paramString, paramIntent);
      paramContext.startService(paramIntent);
    }
  }

  public static void a(Context paramContext, String paramString, AppSession.LogoutReason paramLogoutReason)
  {
    FB4AErrorReporting.a();
    AppSession localAppSession = a(paramContext, false);
    if (localAppSession != null)
      localAppSession.b(paramContext, paramLogoutReason);
  }

  private void a(Integer paramInteger)
  {
    monitorenter;
    try
    {
      Assert.a(this.B);
      if (this.C.containsKey(paramInteger))
      {
        int i1 = ((Integer)this.C.get(paramInteger)).intValue();
        for (int i2 = 0; i2 < i1; i2++)
          this.B.release();
        this.C.remove(paramInteger);
      }
      if ((this.B != null) && (this.C.size() == 0))
        Assert.a(this.B.isHeld());
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private static boolean a(Intent paramIntent)
  {
    int i1 = 1;
    if (i1 == paramIntent.getIntExtra("type", -1));
    while (true)
    {
      return i1;
      i1 = 0;
    }
  }

  private String[] a(Collection<String> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection);
    Collections.sort(localArrayList);
    return (String[])localArrayList.toArray(new String[0]);
  }

  public static AppSession b(Context paramContext, boolean paramBoolean)
  {
    AppSession localAppSession = a(paramContext, paramBoolean);
    if ((localAppSession != null) && (localAppSession.c()));
    while (true)
    {
      return localAppSession;
      localAppSession = null;
    }
  }

  public static String b(Context paramContext)
  {
    try
    {
      String str2 = KeyValueManager.a(paramContext, "hashed_uid", null);
      str1 = str2;
      return str1;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        String str1 = null;
    }
  }

  private void b(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -1) && (PlatformUtils.a(paramContext)));
    while (true)
    {
      return;
      AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
      if (this.r != null)
      {
        localAlarmManager.cancel(this.r);
        this.r.cancel();
      }
      Intent localIntent = new Intent(paramContext, FacebookService.class);
      localIntent.setAction("com.facebook.katana.service." + m());
      localIntent.putExtra("type", 202);
      localIntent.putExtra("sid", this.k);
      localIntent.putExtra("extra_attempt", paramInt2);
      this.r = PendingIntent.getService(paramContext, 0, localIntent, 0);
      if (paramInt1 == -1)
        paramInt1 = 172800000;
      localAlarmManager.set(3, SystemClock.elapsedRealtime() + paramInt1, this.r);
    }
  }

  private void b(Context paramContext, Intent paramIntent, int paramInt, String paramString, Exception paramException, Object paramObject1, Object paramObject2)
  {
    int i1 = paramIntent.getIntExtra("type", -1);
    if (ApiMethod.a(paramInt, paramException))
    {
      if (f)
        g = true;
      if ((c()) && (StringUtils.a(paramIntent.getStringExtra("session_key"), b().sessionKey)) && (!this.y))
      {
        c(paramContext, AppSession.LogoutReason.FORCED_ERROR_102_INVALID_SESSION);
        this.y = true;
      }
    }
    String str1 = paramIntent.getStringExtra("rid");
    if (str1 != null)
      this.l.remove(str1);
    switch (i1)
    {
    case 204:
    default:
    case 1:
    case 2:
    case 82:
    case 83:
    case 3:
    case 80:
    case 81:
    case 50:
    case 1100:
    case 51:
    case 60:
    case 61:
    case 62:
    case 63:
    case 64:
    case 65:
    case 507:
    case 66:
    case 67:
    case 68:
    case 72:
    case 73:
    case 74:
    case 75:
    case 76:
    case 77:
    case 100:
    case 211:
    case 201:
    case 205:
    case 202:
    case 203:
    case 90:
    case 91:
    case 92:
    case 300:
    case 131:
    case 132:
    case 133:
    case 1000:
    case 1001:
    case 140:
    }
    while (true)
    {
      if (this.l.size() == 0)
      {
        paramContext.stopService(new Intent(paramContext, FacebookService.class));
        FacebookService.a.clear();
      }
      return;
      a(paramContext, str1, paramInt, paramString, paramException, paramObject1, paramIntent.getBooleanExtra("fake_login", false));
      continue;
      if (i.a().equals(this.k))
        UserValuesManager.c(paramContext, null);
      UserValuesManager.n(paramContext);
      Iterator localIterator27 = this.l.values().iterator();
      while (localIterator27.hasNext())
      {
        Intent localIntent = (Intent)localIterator27.next();
        if (localIntent.getIntExtra("type", -1) != 80)
          continue;
        String str8 = localIntent.getStringExtra("rid");
        Iterator localIterator29 = this.b.a().iterator();
        while (localIterator29.hasNext())
          ((AppSessionListener)localIterator29.next()).a(this, str8, 400, "Canceled", null);
      }
      Iterator localIterator28 = this.b.a().iterator();
      while (localIterator28.hasNext())
        ((AppSessionListener)localIterator28.next()).c(this, str1, paramInt, paramString, paramException);
      y(paramContext);
      continue;
      FacebookUserFull localFacebookUserFull = (FacebookUserFull)paramObject1;
      Iterator localIterator26 = this.b.a().iterator();
      while (localIterator26.hasNext())
        ((AppSessionListener)localIterator26.next()).a(this, str1, paramInt, paramString, paramException, paramIntent.getLongExtra("uid", -1L), localFacebookUserFull, ((Boolean)paramObject2).booleanValue());
      FacebookUser localFacebookUser2 = (FacebookUser)paramObject1;
      Iterator localIterator25 = this.b.a().iterator();
      while (localIterator25.hasNext())
        ((AppSessionListener)localIterator25.next()).a(this, str1, paramInt, paramString, paramException, paramIntent.getLongExtra("uid", -1L), localFacebookUser2, false);
      FacebookSessionInfo localFacebookSessionInfo = (FacebookSessionInfo)paramObject1;
      Iterator localIterator24 = this.b.a().iterator();
      while (localIterator24.hasNext())
        ((AppSessionListener)localIterator24.next()).a(this, str1, paramInt, paramString, paramException, localFacebookSessionInfo);
      if (paramInt == 200)
      {
        UserValuesManager.e(paramContext);
        Map localMap3 = (Map)paramObject1;
        this.m.a(this, paramContext, localMap3);
        b(paramContext, -1, 0);
      }
      while (true)
      {
        a(paramContext, 1000, 0);
        Iterator localIterator23 = this.b.a().iterator();
        while (localIterator23.hasNext())
          ((AppSessionListener)localIterator23.next()).a(this, str1, paramInt, paramString, paramException);
        int i9 = 1 + paramIntent.getIntExtra("extra_attempt", 0);
        if (i9 < 3)
        {
          b(paramContext, 300000, i9);
          continue;
        }
        b(paramContext, -1, 0);
      }
      if (!paramIntent.getBooleanExtra("release_wake_lock", false))
        continue;
      a(Integer.valueOf(80));
      continue;
      if (paramInt == 200)
      {
        Widget.a().a(paramContext, (List)paramObject1);
        a(paramContext, -1, 0);
      }
      while (paramIntent.getBooleanExtra("release_wake_lock", false))
      {
        a(Integer.valueOf(81));
        break;
        int i8 = 1 + paramIntent.getIntExtra("extra_attempt", 0);
        if (i8 < 3)
        {
          a(paramContext, 30000, i8);
          continue;
        }
        Widget.a().a(paramContext);
        a(paramContext, -1, 0);
      }
      if (paramInt == 200)
      {
        int i6 = ((FacebookNotifications)paramObject1).c();
        OrcaSharedPreferences localOrcaSharedPreferences = (OrcaSharedPreferences)j(paramContext).a(OrcaSharedPreferences.class);
        int i7 = localOrcaSharedPreferences.a(NotificationPrefKeys.b, 0);
        long l4 = localOrcaSharedPreferences.a(NotificationPrefKeys.c, 0L);
        long l5 = System.currentTimeMillis();
        long l6 = l5 - l4;
        if ((i6 != i7) || (l6 >= 7200000L))
        {
          if (Boolean.TRUE.equals(FbInjector.a(paramContext).a(Boolean.class, IsGraphQLNotificationsEnabled.class)))
          {
            n(paramContext);
            label1274: localOrcaSharedPreferences.b().a(NotificationPrefKeys.b, i6).a(NotificationPrefKeys.c, l5).a();
          }
        }
        else
        {
          c(paramContext, -1, 0);
          m(paramContext);
          this.D.b("pollNotifications", str1);
        }
      }
      while (true)
      {
        if (paramIntent.getBooleanExtra("release_wake_lock", false))
          a(Integer.valueOf(50));
        Iterator localIterator22 = this.b.a().iterator();
        while (localIterator22.hasNext())
          ((AppSessionListener)localIterator22.next()).j(this, str1, paramInt, paramString, paramException);
        f(paramContext);
        break label1274;
        int i5 = 1 + paramIntent.getIntExtra("extra_attempt", 0);
        if ((i5 < 3) && (!BackgroundDetectionService.a()))
        {
          c(paramContext, 60000, i5);
          continue;
        }
        c(paramContext, -1, 0);
      }
      if (i() != AppSession.LoginStatus.STATUS_LOGGED_IN)
        continue;
      if (paramInt == 200)
        d(paramContext, -1, 0);
      while (paramIntent.getBooleanExtra("release_wake_lock", false))
      {
        a(Integer.valueOf(1100));
        break;
        int i4 = 1 + paramIntent.getIntExtra("extra_attempt", 0);
        if (i4 < 3)
        {
          d(paramContext, 3600000, i4);
          continue;
        }
        d(paramContext, -1, 0);
      }
      Iterator localIterator21 = this.b.a().iterator();
      while (localIterator21.hasNext())
        ((AppSessionListener)localIterator21.next()).i(this, str1, paramInt, paramString, paramException);
      long l3 = paramIntent.getLongExtra("uid", -1L);
      String[] arrayOfString2 = paramIntent.getStringArrayExtra("aid");
      Iterator localIterator20 = this.b.a().iterator();
      while (localIterator20.hasNext())
        ((AppSessionListener)localIterator20.next()).a(this, str1, paramInt, paramString, paramException, arrayOfString2, l3);
      Iterator localIterator19 = this.b.a().iterator();
      while (localIterator19.hasNext())
        ((AppSessionListener)localIterator19.next()).a(this, str1, paramInt, paramString, paramException, (FacebookAlbum)paramObject1);
      Iterator localIterator18 = this.b.a().iterator();
      while (localIterator18.hasNext())
        ((AppSessionListener)localIterator18.next()).b(this, str1, paramInt, paramString, paramException, paramIntent.getStringExtra("aid"));
      Iterator localIterator17 = this.b.a().iterator();
      while (localIterator17.hasNext())
        ((AppSessionListener)localIterator17.next()).a(this, str1, paramInt, paramString, paramException, paramIntent.getStringExtra("aid"));
      String str7 = paramIntent.getStringExtra("aid");
      String[] arrayOfString1 = paramIntent.getStringArrayExtra("pid");
      long l2 = paramIntent.getLongExtra("uid", -1L);
      Iterator localIterator16 = this.b.a().iterator();
      while (localIterator16.hasNext())
        ((AppSessionListener)localIterator16.next()).a(this, str1, paramInt, paramString, paramException, str7, arrayOfString1, l2);
      FacebookPhoto localFacebookPhoto = (FacebookPhoto)paramObject1;
      String str4;
      if (localFacebookPhoto != null)
        str4 = localFacebookPhoto.b();
      for (String str5 = localFacebookPhoto.a(); ; str5 = null)
      {
        if ((paramInt == 200) && (str4 != null))
        {
          ArrayList localArrayList2 = new ArrayList(1);
          localArrayList2.add(str4);
          a(paramContext, -1L, localArrayList2);
        }
        FacebookPhotoSet.a(paramContext);
        String str6 = paramIntent.getStringExtra("uri");
        if (!SystemTrayNotificationManager.a(paramContext, Integer.parseInt(str1), paramInt, str6, str4, str5, i1));
        Iterator localIterator15 = this.b.a().iterator();
        while (localIterator15.hasNext())
          ((AppSessionListener)localIterator15.next()).a(this, str1, paramInt, paramString, paramException, paramIntent.getIntExtra("upload_id", -1), localFacebookPhoto, paramIntent.getStringExtra("uri"), paramIntent.getLongExtra("checkin_id", -1L), paramIntent.getLongExtra("profile_id", -1L), paramIntent.getBooleanExtra("is_single_photo", true));
        str4 = null;
      }
      String str3 = paramIntent.getStringExtra("uri");
      if (!SystemTrayNotificationManager.a(paramContext, Integer.parseInt(str1), paramInt, str3, null, null, i1));
      Iterator localIterator14 = this.b.a().iterator();
      while (localIterator14.hasNext())
        ((AppSessionListener)localIterator14.next()).b(this, str1, paramInt, paramString, paramException, paramIntent.getIntExtra("upload_id", -1));
      Iterator localIterator13 = this.b.a().iterator();
      while (localIterator13.hasNext())
        ((AppSessionListener)localIterator13.next()).b(this, str1, paramInt, paramString, paramException, paramIntent.getStringExtra("aid"), paramIntent.getStringExtra("pid"));
      if (((Boolean)paramObject1).booleanValue())
      {
        ArrayList localArrayList1 = new ArrayList();
        localArrayList1.add(paramIntent.getStringExtra("aid"));
        a(paramContext, -1L, localArrayList1);
      }
      FacebookPhotoSet.a(paramContext);
      Iterator localIterator12 = this.b.a().iterator();
      while (localIterator12.hasNext())
        ((AppSessionListener)localIterator12.next()).a(this, str1, paramInt, paramString, paramException, paramIntent.getStringExtra("aid"), paramIntent.getStringExtra("pid"));
      Iterator localIterator11 = this.b.a().iterator();
      while (localIterator11.hasNext())
        ((AppSessionListener)localIterator11.next()).a(this, str1, paramInt, paramString, paramException, paramIntent.getStringExtra("pid"), (List)paramObject1);
      String str2 = paramIntent.getStringExtra("uri");
      StreamPhoto localStreamPhoto = (StreamPhoto)paramObject1;
      this.n.a(paramContext, paramInt, str2, localStreamPhoto);
      Iterator localIterator10 = this.b.a().iterator();
      if (!localIterator10.hasNext())
        continue;
      AppSessionListener localAppSessionListener = (AppSessionListener)localIterator10.next();
      if (localStreamPhoto != null);
      for (Bitmap localBitmap2 = localStreamPhoto.g(); ; localBitmap2 = null)
      {
        localAppSessionListener.a(this, str1, paramInt, paramString, paramException, str2, localBitmap2);
        break;
      }
      Iterator localIterator9 = this.b.a().iterator();
      while (localIterator9.hasNext())
        ((AppSessionListener)localIterator9.next()).c(this, str1, paramInt, paramString, paramException, paramIntent.getStringExtra("aid"));
      Iterator localIterator8 = this.b.a().iterator();
      while (localIterator8.hasNext())
        ((AppSessionListener)localIterator8.next()).a(this, str1, paramInt, paramString, paramException, paramIntent.getStringExtra("aid"), paramIntent.getStringExtra("pid"), paramIntent.getLongExtra("fbid", -1L));
      Iterator localIterator7 = this.b.a().iterator();
      while (localIterator7.hasNext())
        ((AppSessionListener)localIterator7.next()).a(this, str1, paramInt, paramString, paramException, paramIntent.getStringExtra("aid"), paramIntent.getStringExtra("pid"), paramIntent.getLongExtra("fbid", -1L), (byte[])(byte[])paramObject1);
      Bitmap localBitmap1 = (Bitmap)paramObject1;
      Iterator localIterator6 = this.b.a().iterator();
      while (localIterator6.hasNext())
        ((AppSessionListener)localIterator6.next()).a(this, str1, paramInt, paramString, paramException, localBitmap1);
      if (paramObject1 == null)
      {
        Log.e(e, "REQ_DOWNLOAD_USER_IMAGE receives null result");
        continue;
      }
      long l1 = paramIntent.getLongExtra("uid", -1L);
      ProfileImage localProfileImage = (ProfileImage)paramObject1;
      this.m.a(paramContext, paramInt, l1, localProfileImage);
      if (paramInt != 200)
        continue;
      Widget.a().a(paramContext, localProfileImage);
      if (this.p.userId == l1)
      {
        FacebookUser localFacebookUser1 = this.p.a();
        if (!localProfileImage.b.equals(localFacebookUser1.mImageUrl))
        {
          this.p.a(new FacebookUser(localFacebookUser1.mUserId, localFacebookUser1.mFirstName, localFacebookUser1.mLastName, localFacebookUser1.mDisplayName, localProfileImage.b));
          UserValuesManager.c(paramContext, this.p.d().toString());
        }
      }
      Iterator localIterator5 = this.b.a().iterator();
      while (localIterator5.hasNext())
        ((AppSessionListener)localIterator5.next()).a(this, str1, paramInt, paramString, paramException, localProfileImage, this.m);
      int i2 = ((Integer)paramObject1).intValue();
      int i3 = ((Integer)paramObject2).intValue();
      Iterator localIterator4 = this.b.a().iterator();
      while (localIterator4.hasNext())
        ((AppSessionListener)localIterator4.next()).a(this, str1, paramInt, paramString, paramException, i2, i3);
      b(paramContext, paramIntent.getIntExtra("extra_attempt", 0), true);
      continue;
      if (((ConnectivityManager)paramContext.getSystemService("connectivity")).getBackgroundDataSetting())
      {
        d(paramContext, paramIntent.getIntExtra("extra_attempt", 0), true);
        continue;
      }
      d(paramContext, -1, 0);
      continue;
      if (((ConnectivityManager)paramContext.getSystemService("connectivity")).getBackgroundDataSetting())
      {
        c(paramContext, paramIntent.getIntExtra("extra_attempt", 0), true);
        continue;
      }
      b(paramContext, -1, 0);
      continue;
      if (!Widget.a().d(paramContext))
        continue;
      a(paramContext, paramIntent.getIntExtra("extra_attempt", 0), true);
      continue;
      Widget.a().b(paramContext);
      continue;
      Widget.a().c(paramContext);
      continue;
      StreamPublish.a(paramContext, this.p.userId, paramIntent.getStringExtra("status"), paramIntent.getStringExtra("status"), null, true, null);
      continue;
      SystemTrayNotificationManager.b(paramContext);
      continue;
      Map localMap2 = (Map)paramObject1;
      Iterator localIterator3 = this.b.a().iterator();
      while (localIterator3.hasNext())
        ((AppSessionListener)localIterator3.next()).a(this, str1, paramInt, paramString, paramException, localMap2);
      Long localLong = (Long)paramObject1;
      Boolean localBoolean = (Boolean)paramObject2;
      Iterator localIterator2 = this.b.a().iterator();
      while (localIterator2.hasNext())
        ((AppSessionListener)localIterator2.next()).a(this, str1, paramInt, paramString, paramException, localLong.longValue(), localBoolean.booleanValue());
      Map localMap1 = (Map)paramObject1;
      Iterator localIterator1 = this.b.a().iterator();
      while (localIterator1.hasNext())
        ((AppSessionListener)localIterator1.next()).b(this, str1, paramInt, paramString, paramException, localMap1);
      ExtendedReq.a(this, paramContext, paramIntent, paramInt, paramString, paramException, (ServiceOperation)paramObject1);
      continue;
      ((ApiMethodCallback)paramObject1).a(this, paramContext, paramIntent, str1, paramInt, paramString, paramException);
      continue;
      t(paramContext);
      HttpOperation.c();
    }
  }

  private void b(Context paramContext, Intent paramIntent, Object paramObject1, Object paramObject2)
  {
    switch (paramIntent.getIntExtra("type", -1))
    {
    default:
    case 65:
    }
    while (true)
    {
      return;
      SystemTrayNotificationManager.a(paramContext, Integer.parseInt(paramIntent.getStringExtra("rid")), ((Integer)paramObject1).intValue());
    }
  }

  private void b(Context paramContext, FacebookSessionInfo paramFacebookSessionInfo)
  {
    if ((f) && (g))
      a = true;
    UserValuesManager.c(paramContext, paramFacebookSessionInfo.d().toString());
    i(paramContext);
    this.p = paramFacebookSessionInfo;
    FB4AErrorReporting.a(paramContext, ((UniqueIdForDeviceHolder)j(paramContext).a(UniqueIdForDeviceHolder.class)).b());
    this.y = false;
    if (AppSession.LoginStatus.STATUS_LOGGING_IN.equals(this.q))
    {
      o();
      this.q = AppSession.LoginStatus.STATUS_LOGGED_IN;
      p(paramContext);
    }
    this.q = AppSession.LoginStatus.STATUS_LOGGED_IN;
    o(paramContext);
    new AppSession.4(this, paramContext).start();
  }

  public static long c(Context paramContext)
  {
    long l1 = 0L;
    try
    {
      long l2 = KeyValueManager.a(paramContext, "last_login_time", 0L);
      l1 = l2;
      label15: return l1;
    }
    catch (Throwable localThrowable)
    {
      break label15;
    }
  }

  private String c(Context paramContext, int paramInt, boolean paramBoolean)
  {
    boolean bool = e();
    String str = null;
    if (bool);
    while (true)
    {
      return str;
      FacebookSessionInfo localFacebookSessionInfo1 = this.p;
      FacebookSessionInfo localFacebookSessionInfo2 = FacebookSessionInfo.sInvalidSessionInfo;
      str = null;
      if (localFacebookSessionInfo1 == localFacebookSessionInfo2)
        continue;
      if (paramBoolean)
      {
        long l1 = UserValuesManager.f(paramContext);
        if (System.currentTimeMillis() - l1 < 86400000L)
        {
          b(paramContext, -1, 0);
          str = null;
          continue;
        }
        a(paramContext, Integer.valueOf(80));
      }
      Intent localIntent = new Intent(paramContext, FacebookService.class);
      str = m();
      localIntent.putExtra("type", 80);
      localIntent.putExtra("rid", str);
      localIntent.putExtra("sid", this.k);
      localIntent.putExtra("session_key", this.p.sessionKey);
      localIntent.putExtra("session_user_id", this.p.userId);
      localIntent.putExtra("extra_attempt", paramInt);
      localIntent.putExtra("un", this.p.username);
      localIntent.putExtra("release_wake_lock", paramBoolean);
      a(paramContext, str, localIntent);
    }
  }

  private void c(Context paramContext, int paramInt1, int paramInt2)
  {
    int i1 = 120;
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (this.t != null)
    {
      localAlarmManager.cancel(this.t);
      this.t.cancel();
    }
    int i2;
    if (paramInt1 == -1)
    {
      i2 = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(paramContext).getString("polling_interval", "60"));
      if (i2 <= i1)
        break label180;
    }
    while (true)
    {
      paramInt1 = i1 * 60000;
      Intent localIntent = new Intent(paramContext, FacebookService.class);
      localIntent.setAction("com.facebook.katana.service." + m());
      localIntent.putExtra("type", 201);
      localIntent.putExtra("sid", this.k);
      localIntent.putExtra("extra_attempt", paramInt2);
      this.t = PendingIntent.getService(paramContext, 0, localIntent, 0);
      localAlarmManager.set(3, SystemClock.elapsedRealtime() + paramInt1, this.t);
      return;
      label180: if (i2 == 0)
      {
        i1 = 30;
        continue;
      }
      i1 = i2;
    }
  }

  private void c(Context paramContext, AppSession.LogoutReason paramLogoutReason)
  {
    if ((this.q == AppSession.LoginStatus.STATUS_LOGGING_OUT) || (this.q == AppSession.LoginStatus.STATUS_LOGGED_OUT));
    while (true)
    {
      return;
      a(paramContext, this.p.username, paramLogoutReason);
    }
  }

  public static long d(Context paramContext)
  {
    long l1 = 0L;
    try
    {
      long l2 = KeyValueManager.a(paramContext, "last_logout_time", 0L);
      l1 = l2;
      label15: return l1;
    }
    catch (Throwable localThrowable)
    {
      break label15;
    }
  }

  private String d(Context paramContext, int paramInt, boolean paramBoolean)
  {
    String str;
    if (g())
      str = null;
    while (true)
    {
      return str;
      if (paramBoolean)
        a(paramContext, Integer.valueOf(1100));
      Intent localIntent = new Intent(paramContext, FacebookService.class);
      str = m();
      localIntent.putExtra("type", 1100);
      localIntent.putExtra("rid", str);
      localIntent.putExtra("sid", this.k);
      localIntent.putExtra("session_key", this.p.sessionKey);
      localIntent.putExtra("session_user_id", this.p.userId);
      localIntent.putExtra("extra_attempt", paramInt);
      localIntent.putExtra("un", this.p.username);
      localIntent.putExtra("release_wake_lock", paramBoolean);
      a(paramContext, str, localIntent);
    }
  }

  private void d(Context paramContext, int paramInt1, int paramInt2)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (this.w != null)
    {
      localAlarmManager.cancel(this.w);
      this.w.cancel();
    }
    if (paramInt1 == -1)
      paramInt1 = 86400000;
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    localIntent.setAction("com.facebook.katana.service." + m());
    localIntent.putExtra("type", 205);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("extra_attempt", paramInt2);
    this.w = PendingIntent.getService(paramContext, 0, localIntent, 0);
    localAlarmManager.setInexactRepeating(3, SystemClock.elapsedRealtime() + paramInt1, paramInt1, this.w);
  }

  private FbInjector j(Context paramContext)
  {
    return FbInjector.a(paramContext);
  }

  private static void k(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, MediaUploadService.class);
    localIntent.putExtra("type", 2);
    paramContext.startService(localIntent);
  }

  private static void l(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, MediaUploadService.class);
    localIntent.putExtra("type", 1);
    paramContext.startService(localIntent);
  }

  protected static String m()
  {
    monitorenter;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("");
      int i1 = j;
      j = i1 + 1;
      String str = i1;
      monitorexit;
      return str;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private void m(Context paramContext)
  {
    if (this.D == null)
      this.D = ((PerformanceLogger)j(paramContext).a(PerformanceLogger.class));
  }

  private void n(Context paramContext)
  {
    ((NotificationsUtils)FbInjector.a(paramContext).a(NotificationsUtils.class)).a(this.p.userId, true);
  }

  private void o(Context paramContext)
  {
    q(paramContext);
    PostLoginSyncRequest.a(paramContext);
    FacewebUriMap.a(paramContext);
  }

  public static String p()
  {
    return i.a();
  }

  private void p(Context paramContext)
  {
    FacewebComponentsStoreCache.a(paramContext, new AppSession.5(this));
  }

  private void q(Context paramContext)
  {
    this.o = new WorkerThread();
    this.m.a(paramContext, this.o);
    this.n.a(paramContext, this.o);
  }

  private void r(Context paramContext)
  {
    b(paramContext, 1000, 0);
    c(paramContext, 10000, 0);
    d(paramContext, 60000, 0);
  }

  private void s(Context paramContext)
  {
    if (!FacebookAffiliation.a())
      FacebookAffiliation.a(paramContext);
    if (FacebookAffiliation.d())
      c(paramContext, this.p.userId);
  }

  private void t(Context paramContext)
  {
    if ((FacebookAffiliation.b()) && (Build.VERSION.SDK_INT >= 14))
      ((AutoUpdateServiceStarter)j(paramContext).a(AutoUpdateServiceStarter.class)).a();
  }

  private void u(Context paramContext)
  {
    if (Boolean.TRUE.equals(FbInjector.a(paramContext).a(Boolean.class, IsGraphQLNotificationsEnabled.class)))
      n(paramContext);
    while (true)
    {
      Widget.a().e(paramContext);
      r(paramContext);
      l(paramContext);
      MobileEventLogger.a().a(paramContext);
      FacebookDatabaseHelper.a(paramContext).a();
      if (this.q == AppSession.LoginStatus.STATUS_LOGGED_IN)
      {
        PostLoginSyncRequest.a(paramContext);
        s(paramContext);
        ((NotificationManager)paramContext.getSystemService("notification")).cancel(7);
      }
      ((VaultManager)j(paramContext).a(VaultManager.class)).a();
      t(paramContext);
      ((AndroidThreadUtil)j(paramContext).a(AndroidThreadUtil.class)).a(new AppSession.6(this, paramContext));
      Uri localUri = new Uri.Builder().scheme("content").authority(BuildConstants.b() + ".provider.AttributionIdProvider").build();
      paramContext.getContentResolver().query(localUri, null, null, null, null);
      v(paramContext);
      return;
      f(paramContext);
    }
  }

  private void v(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    FbInjector localFbInjector = FbInjector.a(localContext);
    OrcaSharedPreferences localOrcaSharedPreferences = (OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class);
    if (localOrcaSharedPreferences.a(NativeGdpPrefsKeys.b));
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      AppInitLockHelper.a(localContext);
      Futures.a(((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class)).a("platform_get_native_gdp_nux_status", localBundle).d(), new AppSession.7(this, localOrcaSharedPreferences));
    }
  }

  private static void w(Context paramContext)
  {
    CookieSyncManager.createInstance(paramContext);
    CookieManager.getInstance().removeAllCookie();
  }

  private void x(Context paramContext)
  {
    w(paramContext);
    z(paramContext);
    WebStorage.getInstance().deleteAllData();
    FacewebComponentsStoreCache.a(paramContext);
    i(paramContext);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().clear().commit();
    ComposerActivity.b(paramContext);
  }

  private void y(Context paramContext)
  {
    KeyValueManager.a(paramContext, "last_username", this.p.username);
    KeyValueManager.a(paramContext, "hashed_uid", SecureHashUtil.a(String.valueOf(this.p.userId)));
    KeyValueManager.a(paramContext, "last_logout_time", Long.valueOf(System.currentTimeMillis()));
    this.q = AppSession.LoginStatus.STATUS_LOGGED_OUT;
    this.l.clear();
    this.b.c();
    this.m.a();
    this.n.a();
    if (this.o != null)
    {
      this.o.c();
      this.o = null;
    }
    Widget.a().f(paramContext);
    k(paramContext);
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (this.r != null)
    {
      localAlarmManager.cancel(this.r);
      this.r.cancel();
      this.r = null;
    }
    if (this.s != null)
    {
      localAlarmManager.cancel(this.s);
      this.s.cancel();
      this.s = null;
    }
    if (this.t != null)
    {
      localAlarmManager.cancel(this.t);
      this.t.cancel();
      this.t = null;
    }
    if (this.u != null)
    {
      localAlarmManager.cancel(this.u);
      this.u.cancel();
      this.u = null;
    }
    if (this.v != null)
    {
      localAlarmManager.cancel(this.v);
      this.v.cancel();
      this.v = null;
    }
    ((VaultManager)j(paramContext).a(VaultManager.class)).g();
    if (this.w != null)
    {
      localAlarmManager.cancel(this.w);
      this.w.cancel();
      this.w = null;
    }
    n();
    FacebookAffiliation.b(paramContext);
    ManagedDataStore.a();
    i.a(this.k);
    if (i.a().equals(this.k))
      SystemTrayNotificationManager.a(paramContext);
    if (i.b())
    {
      l();
      paramContext.stopService(new Intent(paramContext, FacebookService.class));
      FacebookService.a.clear();
    }
    FB4AErrorReporting.a();
    NotificationsLogger.NotificationLogObject localNotificationLogObject = new NotificationsLogger.NotificationLogObject().a(7).b(1);
    if (this.A)
    {
      SystemTrayNotificationManager.a(paramContext, 7, new NotificationBuilder(paramContext).a(paramContext.getString(2131362992)).c(paramContext.getResources().getString(2131362037)).b(paramContext.getString(2131362992)).a(17301642).a(System.currentTimeMillis()), new Intent(paramContext, LoginActivity.class), localNotificationLogObject);
      this.A = false;
    }
  }

  private void z(Context paramContext)
  {
    FbInjector localFbInjector = j(paramContext);
    ((OrcaDataManager)localFbInjector.a(OrcaDataManager.class)).b();
    ((FbAppUserDataCleaner)localFbInjector.a(FbAppUserDataCleaner.class)).b();
    ((AuthStateMachineMonitor)localFbInjector.a(AuthStateMachineMonitor.class)).c();
  }

  public String a()
  {
    return this.k;
  }

  public String a(Context paramContext, int paramInt, long paramLong, String paramString, FacebookPlace paramFacebookPlace)
  {
    String str1 = m();
    SystemTrayNotificationManager.a(paramContext, Integer.parseInt(str1), null, null, paramString, 1, 1);
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    localIntent.putExtra("type", 507);
    localIntent.putExtra("rid", str1);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("upload_id", paramInt);
    localIntent.putExtra("profile_id", paramLong);
    localIntent.putExtra("uri", paramString);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("session_user_id", this.p.userId);
    localIntent.putExtra("suggested_place", paramFacebookPlace);
    if (c())
    {
      String str2 = b().sessionSecret;
      if (str2 != null)
        localIntent.putExtra("ApiMethod.secret", str2);
    }
    a(paramContext, str1, localIntent);
    return str1;
  }

  public String a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, String paramString4, long paramLong4, String paramString5, int paramInt2, int paramInt3, String paramString6)
  {
    String str1 = m();
    if (paramInt3 <= 1);
    for (boolean bool = true; ; bool = false)
    {
      String str2 = null;
      if (paramString2 != null)
        str2 = MentionsUtils.a(paramString2);
      SystemTrayNotificationManager.a(paramContext, Integer.parseInt(str1), paramString1, str2, paramString3, paramInt2, paramInt3);
      Intent localIntent = new Intent(paramContext, FacebookService.class);
      localIntent.putExtra("type", 65);
      localIntent.putExtra("rid", str1);
      localIntent.putExtra("sid", this.k);
      localIntent.putExtra("upload_id", paramInt1);
      if (paramString1 != null)
        localIntent.putExtra("aid", paramString1);
      if (paramString2 != null)
        localIntent.putExtra("caption", paramString2);
      localIntent.putExtra("profile_id", paramLong1);
      localIntent.putExtra("checkin_id", paramLong2);
      localIntent.putExtra("uri", paramString3);
      localIntent.putExtra("session_key", this.p.sessionKey);
      localIntent.putExtra("session_user_id", this.p.userId);
      localIntent.putExtra("extra_photo_publish", paramBoolean);
      localIntent.putExtra("extra_place", paramLong3);
      localIntent.putExtra("tags", paramString4);
      localIntent.putExtra("extra_status_target_id", paramLong4);
      localIntent.putExtra("extra_status_privacy", paramString5);
      localIntent.putExtra("is_single_photo", bool);
      localIntent.putExtra("nectar_module", paramString6);
      a(paramContext, str1, localIntent);
      return str1;
    }
  }

  public String a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
      a(paramContext, Integer.valueOf(81));
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    String str = m();
    localIntent.putExtra("type", 81);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("session_user_id", this.p.userId);
    localIntent.putExtra("extra_attempt", paramInt);
    localIntent.putExtra("un", this.p.username);
    localIntent.putExtra("release_wake_lock", paramBoolean);
    a(paramContext, str, localIntent);
    return str;
  }

  public String a(Context paramContext, long paramLong)
  {
    String str = m();
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    localIntent.putExtra("type", 131);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("uid", paramLong);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("session_user_id", this.p.userId);
    a(paramContext, str, localIntent);
    return str;
  }

  public String a(Context paramContext, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, boolean paramBoolean, long paramLong4, List<FacebookPhotoTagBase> paramList, long paramLong5, String paramString3)
  {
    String str1 = m();
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    localIntent.putExtra("type", 65);
    localIntent.putExtra("rid", str1);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("vault_image_fbid", paramLong1);
    if (paramString1 != null)
      localIntent.putExtra("aid", paramString1);
    if (paramString2 != null)
      localIntent.putExtra("caption", paramString2);
    localIntent.putExtra("profile_id", paramLong2);
    localIntent.putExtra("checkin_id", paramLong3);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("session_user_id", this.p.userId);
    localIntent.putExtra("extra_photo_publish", paramBoolean);
    localIntent.putExtra("extra_place", paramLong4);
    String str2 = null;
    if (paramList != null)
    {
      boolean bool = paramList.isEmpty();
      str2 = null;
      if (!bool)
        str2 = FacebookPhotoTagBase.a(paramList);
    }
    localIntent.putExtra("tags", str2);
    localIntent.putExtra("extra_status_target_id", paramLong5);
    localIntent.putExtra("extra_status_privacy", paramString3);
    a(paramContext, str1, localIntent);
    return str1;
  }

  public String a(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    return a(paramContext, 74, paramLong, paramString1, paramString2, -1L, paramString3);
  }

  public String a(Context paramContext, long paramLong, List<String> paramList)
  {
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    String str = m();
    localIntent.putExtra("type", 60);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("uid", paramLong);
    if (paramList != null)
      localIntent.putExtra("aid", a(paramList));
    a(paramContext, str, localIntent);
    return str;
  }

  public String a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    String str = m();
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    localIntent.putExtra("type", 132);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("uid", paramLong);
    localIntent.putExtra("confirm", paramBoolean);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("session_user_id", this.p.userId);
    a(paramContext, str, localIntent);
    return str;
  }

  public String a(Context paramContext, Location paramLocation, String paramString, SelectAtTagFetcher.SearchType paramSearchType, long paramLong, NetworkRequestCallback<SelectAtTagFetcher.SelectAtTagArgType, FqlGetAtTags> paramNetworkRequestCallback)
  {
    if (this.p == null);
    for (String str = null; ; str = a(paramContext, new FqlGetAtTags(paramContext, null, this.p.sessionKey, null, paramLocation, paramString, paramSearchType, paramLong, paramNetworkRequestCallback), 501, null))
      return str;
  }

  public String a(Context paramContext, FacebookPlace paramFacebookPlace, Location paramLocation, String paramString1, Set<Long> paramSet, String paramString2)
  {
    return a(paramContext, new PlacesCheckin(paramContext, null, this.p.sessionKey, null, paramFacebookPlace, paramLocation, paramString1, paramSet, paramString2), 503, null);
  }

  public String a(Context paramContext, FacebookPhoto paramFacebookPhoto)
  {
    return a(paramContext, paramFacebookPhoto.b(), paramFacebookPhoto.a(), paramFacebookPhoto.j(), paramFacebookPhoto.f());
  }

  public String a(Context paramContext, ServiceOperation paramServiceOperation, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    String str1 = m();
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    localIntent.putExtra("type", paramInt1);
    localIntent.putExtra("rid", str1);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("extended_type", paramInt2);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    if (c())
    {
      String str2 = b().sessionSecret;
      if (str2 != null)
        localIntent.putExtra("ApiMethod.secret", str2);
    }
    if ((AppSession.LoginStatus.STATUS_LOGGING_IN != this.q) || (a(localIntent)))
    {
      this.l.put(str1, localIntent);
      FacebookService.a.put(str1, paramServiceOperation);
      paramContext.startService(localIntent);
    }
    return str1;
  }

  protected String a(Context paramContext, ServiceOperation paramServiceOperation, int paramInt, Bundle paramBundle)
  {
    return a(paramContext, paramServiceOperation, 1000, paramInt, paramBundle);
  }

  public String a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    String str = m();
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    localIntent.putExtra("type", 211);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("subject", paramString);
    localIntent.putExtra("start", paramInt1);
    localIntent.putExtra("limit", paramInt2);
    a(paramContext, str, localIntent);
    return str;
  }

  public String a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    String str = m();
    localIntent.putExtra("type", 67);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("aid", paramString1);
    localIntent.putExtra("pid", paramString2);
    a(paramContext, str, localIntent);
    return str;
  }

  public String a(Context paramContext, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    return a(paramContext, 75, -1L, paramString1, paramString2, paramLong, paramString3);
  }

  public String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    String str = m();
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("un", paramString1);
    localIntent.putExtra("pwd", paramString2);
    localIntent.putExtra("cred_type", paramString3);
    w(paramContext);
    a(paramContext, str, localIntent);
    this.q = AppSession.LoginStatus.STATUS_LOGGING_IN;
    return str;
  }

  public String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    String str = m();
    localIntent.putExtra("type", 61);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("name", paramString1);
    if (paramString2 != null)
      localIntent.putExtra("location", paramString2);
    if (paramString3 != null)
      localIntent.putExtra("description", paramString3);
    if (paramString4 != null)
      localIntent.putExtra("visibility", paramString4);
    a(paramContext, str, localIntent);
    return str;
  }

  public String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    String str = m();
    localIntent.putExtra("type", 62);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("aid", paramString1);
    localIntent.putExtra("name", paramString2);
    if (paramString3 != null)
      localIntent.putExtra("location", paramString3);
    if (paramString4 != null)
      localIntent.putExtra("description", paramString4);
    if (paramString5 != null)
      localIntent.putExtra("visibility", paramString5);
    a(paramContext, str, localIntent);
    return str;
  }

  public String a(Context paramContext, String paramString, Collection<String> paramCollection, long paramLong)
  {
    return a(paramContext, paramString, paramCollection, paramLong, 0, -1);
  }

  public String a(Context paramContext, String paramString, Collection<String> paramCollection, long paramLong, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    String str = m();
    localIntent.putExtra("type", 64);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("aid", paramString);
    localIntent.putExtra("start", paramInt1);
    localIntent.putExtra("limit", paramInt2);
    if (paramCollection != null)
      localIntent.putExtra("pid", a(paramCollection));
    localIntent.putExtra("uid", paramLong);
    a(paramContext, str, localIntent);
    return str;
  }

  public String a(Context paramContext, String paramString, List<FacebookPhotoTag> paramList)
  {
    return b(paramContext, paramString, FacebookPhotoTag.a(paramList));
  }

  public String a(Context paramContext, long[] paramArrayOfLong)
  {
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    String str = m();
    localIntent.putExtra("type", 52);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("item_id", paramArrayOfLong);
    a(paramContext, str, localIntent);
    return str;
  }

  public void a(Context paramContext, int paramInt1, int paramInt2)
  {
    int i1 = 120;
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (this.s != null)
    {
      localAlarmManager.cancel(this.s);
      this.s.cancel();
    }
    int i2;
    if (paramInt1 == -1)
    {
      i2 = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(paramContext).getString("polling_interval", "60"));
      if (i2 <= i1)
        break label180;
    }
    while (true)
    {
      paramInt1 = i1 * 60000;
      Intent localIntent = new Intent(paramContext, FacebookService.class);
      localIntent.setAction("com.facebook.katana.service." + m());
      localIntent.putExtra("type", 203);
      localIntent.putExtra("sid", this.k);
      localIntent.putExtra("extra_attempt", paramInt2);
      this.s = PendingIntent.getService(paramContext, 0, localIntent, 0);
      localAlarmManager.set(3, SystemClock.elapsedRealtime() + paramInt1, this.s);
      label180: 
      do
        return;
      while (i2 == 0);
      i1 = i2;
    }
  }

  public void a(Context paramContext, AppSession.LogoutReason paramLogoutReason)
  {
    new InteractionLogger(paramContext).b();
    new AppSession.3(this, paramContext, paramLogoutReason).execute(new Void[0]);
  }

  public void a(Context paramContext, FacebookSessionInfo paramFacebookSessionInfo)
  {
    this.p = paramFacebookSessionInfo;
    UserValuesManager.c(paramContext, this.p.d().toString());
  }

  public void a(Context paramContext, String paramString)
  {
    SystemTrayNotificationManager.a(paramContext, Integer.parseInt(paramString));
  }

  // ERROR //
  public void a(AppSession.PreloadStep paramPreloadStep)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 97	com/facebook/katana/binding/AppSession:z	Ljava/util/Set;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: ldc_w 1430
    //   10: new 246	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1432
    //   20: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 1435	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: ldc_w 1437
    //   30: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 97	com/facebook/katana/binding/AppSession:z	Ljava/util/Set;
    //   37: invokevirtual 1435	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 1439	com/facebook/common/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 97	com/facebook/katana/binding/AppSession:z	Ljava/util/Set;
    //   50: invokeinterface 1440 1 0
    //   55: ifeq +40 -> 95
    //   58: ldc_w 1430
    //   61: new 246	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 1442
    //   71: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: invokevirtual 1435	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: ldc_w 1444
    //   81: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 1439	com/facebook/common/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_2
    //   91: monitorexit
    //   92: goto +172 -> 264
    //   95: aload_0
    //   96: getfield 97	com/facebook/katana/binding/AppSession:z	Ljava/util/Set;
    //   99: aload_1
    //   100: invokeinterface 1447 2 0
    //   105: ifne +45 -> 150
    //   108: ldc_w 1430
    //   111: new 246	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 1449
    //   121: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_1
    //   125: invokevirtual 1435	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: ldc_w 1451
    //   131: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 1439	com/facebook/common/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_2
    //   141: monitorexit
    //   142: goto +122 -> 264
    //   145: astore_3
    //   146: aload_2
    //   147: monitorexit
    //   148: aload_3
    //   149: athrow
    //   150: aload_0
    //   151: getfield 97	com/facebook/katana/binding/AppSession:z	Ljava/util/Set;
    //   154: aload_1
    //   155: invokeinterface 1453 2 0
    //   160: pop
    //   161: aload_0
    //   162: getfield 97	com/facebook/katana/binding/AppSession:z	Ljava/util/Set;
    //   165: invokeinterface 1440 1 0
    //   170: ifeq +12 -> 182
    //   173: ldc_w 1430
    //   176: ldc_w 1455
    //   179: invokestatic 1439	com/facebook/common/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: ldc_w 1456
    //   185: getstatic 84	com/facebook/katana/binding/AppSession:h	[Lcom/facebook/katana/binding/AppSession$PreloadStep;
    //   188: arraylength
    //   189: aload_0
    //   190: getfield 97	com/facebook/katana/binding/AppSession:z	Ljava/util/Set;
    //   193: invokeinterface 1457 1 0
    //   198: isub
    //   199: i2f
    //   200: getstatic 84	com/facebook/katana/binding/AppSession:h	[Lcom/facebook/katana/binding/AppSession$PreloadStep;
    //   203: arraylength
    //   204: i2f
    //   205: fdiv
    //   206: fmul
    //   207: f2i
    //   208: istore 5
    //   210: aload_0
    //   211: getfield 126	com/facebook/katana/binding/AppSession:b	Lcom/facebook/katana/util/ReentrantCallback;
    //   214: invokevirtual 389	com/facebook/katana/util/ReentrantCallback:a	()Ljava/util/Set;
    //   217: invokeinterface 395 1 0
    //   222: astore 6
    //   224: aload 6
    //   226: invokeinterface 401 1 0
    //   231: ifeq +31 -> 262
    //   234: aload 6
    //   236: invokeinterface 405 1 0
    //   241: checkcast 407	com/facebook/katana/binding/AppSessionListener
    //   244: aload_0
    //   245: iload 5
    //   247: aload_0
    //   248: getfield 97	com/facebook/katana/binding/AppSession:z	Ljava/util/Set;
    //   251: invokeinterface 1440 1 0
    //   256: invokevirtual 1460	com/facebook/katana/binding/AppSessionListener:a	(Lcom/facebook/katana/binding/AppSession;IZ)V
    //   259: goto -35 -> 224
    //   262: aload_2
    //   263: monitorexit
    //   264: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	148	145	finally
    //   150	264	145	finally
  }

  public void a(AppSessionListener paramAppSessionListener)
  {
    this.b.a(paramAppSessionListener);
  }

  public void a(String paramString, Intent paramIntent)
  {
    this.E.put(paramString, paramIntent);
  }

  public void a(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }

  public boolean a(int paramInt)
  {
    Iterator localIterator = this.l.values().iterator();
    Intent localIntent;
    int i2;
    int i1;
    if (localIterator.hasNext())
    {
      localIntent = (Intent)localIterator.next();
      i2 = localIntent.getIntExtra("type", -1);
      if (i2 == paramInt)
        i1 = 1;
    }
    while (true)
    {
      return i1;
      if ((i2 != 1001) || (localIntent.getIntExtra("extended_type", -1) != paramInt))
        break;
      i1 = 1;
      continue;
      i1 = 0;
    }
  }

  public boolean a(long paramLong)
  {
    Iterator localIterator = this.l.values().iterator();
    Intent localIntent;
    do
    {
      if (!localIterator.hasNext())
        break;
      localIntent = (Intent)localIterator.next();
    }
    while ((localIntent.getIntExtra("type", -1) != 60) || (localIntent.getLongExtra("uid", -1L) != paramLong));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean a(String paramString)
  {
    return this.l.containsKey(paramString);
  }

  public Intent b(String paramString)
  {
    return (Intent)this.E.get(paramString);
  }

  public FacebookSessionInfo b()
  {
    if (!FacebookSessionInfo.a(this.p))
      ErrorReporting.a("SessionInfo", "Invalid Session Info encountered", true);
    return this.p;
  }

  public String b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    String str;
    if (this.p == null)
      str = null;
    while (true)
    {
      return str;
      if (paramBoolean)
        a(paramContext, Integer.valueOf(50));
      Intent localIntent = new Intent(paramContext, FacebookService.class);
      str = m();
      localIntent.putExtra("type", 50);
      localIntent.putExtra("rid", str);
      localIntent.putExtra("sid", this.k);
      localIntent.putExtra("session_key", this.p.sessionKey);
      localIntent.putExtra("extra_attempt", paramInt);
      localIntent.putExtra("release_wake_lock", paramBoolean);
      m(paramContext);
      this.D.a("pollNotifications", str);
      a(paramContext, str, localIntent);
    }
  }

  public String b(Context paramContext, long paramLong)
  {
    String str = m();
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    localIntent.putExtra("type", 133);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("uid", paramLong);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("session_user_id", this.p.userId);
    a(paramContext, str, localIntent);
    return str;
  }

  public String b(Context paramContext, FacebookPhoto paramFacebookPhoto)
  {
    return b(paramContext, paramFacebookPhoto.b(), paramFacebookPhoto.a(), paramFacebookPhoto.j(), paramFacebookPhoto.g());
  }

  public String b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    String str = m();
    localIntent.putExtra("type", 63);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("uid", this.p.userId);
    localIntent.putExtra("aid", paramString);
    a(paramContext, str, localIntent);
    return str;
  }

  public String b(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    String str = m();
    localIntent.putExtra("type", 68);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("pid", paramString1);
    localIntent.putExtra("tags", paramString2);
    a(paramContext, str, localIntent);
    return str;
  }

  public String b(Context paramContext, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    return a(paramContext, 76, -1L, paramString1, paramString2, paramLong, paramString3);
  }

  public String b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    String str = m();
    localIntent.putExtra("type", 66);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("aid", paramString1);
    localIntent.putExtra("pid", paramString2);
    if (paramString3 != null)
      localIntent.putExtra("caption", paramString3);
    a(paramContext, str, localIntent);
    return str;
  }

  public void b(Context paramContext, AppSession.LogoutReason paramLogoutReason)
  {
    ErrorReporting.a("FORCED_LOGOUT", paramLogoutReason.toString());
    a(true);
    a(paramContext, paramLogoutReason);
  }

  public void b(AppSessionListener paramAppSessionListener)
  {
    this.b.b(paramAppSessionListener);
  }

  public String c(Context paramContext, long paramLong)
  {
    String str = m();
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    localIntent.putExtra("type", 140);
    localIntent.putExtra("rid", str);
    localIntent.putExtra("sid", this.k);
    localIntent.putExtra("uid", paramLong);
    localIntent.putExtra("session_key", this.p.sessionKey);
    localIntent.putExtra("session_user_id", this.p.userId);
    a(paramContext, str, localIntent);
    return str;
  }

  public String c(Context paramContext, String paramString)
  {
    return a(paramContext, 77, -1L, null, null, -1L, paramString);
  }

  public void c(String paramString)
  {
    this.E.remove(paramString);
  }

  public boolean c()
  {
    return FacebookSessionInfo.a(this.p);
  }

  public boolean c(AppSessionListener paramAppSessionListener)
  {
    int i1;
    synchronized (this.z)
    {
      if (this.z.isEmpty())
      {
        Log.e("PRELOAD", "did not add listener " + paramAppSessionListener);
        i1 = 0;
      }
      else
      {
        Log.e("PRELOAD", "added listener " + paramAppSessionListener);
        a(paramAppSessionListener);
        i1 = 1;
      }
    }
    return i1;
  }

  public Set<AppSessionListener> d()
  {
    return this.b.a();
  }

  public void d(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, FacebookService.class);
    localIntent.putExtra("type", 2000);
    localIntent.putExtra("rid", paramString);
    if (this.l.containsKey(paramString))
    {
      this.l.remove(paramString);
      paramContext.startService(localIntent);
    }
  }

  public String e(Context paramContext)
  {
    return c(paramContext, 3, false);
  }

  public boolean e()
  {
    Iterator localIterator = this.l.values().iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (((Intent)localIterator.next()).getIntExtra("type", -1) != 80);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public String f(Context paramContext)
  {
    String str;
    if (this.p == null)
      str = null;
    while (true)
    {
      return str;
      Intent localIntent = new Intent(paramContext, FacebookService.class);
      str = m();
      localIntent.putExtra("type", 51);
      localIntent.putExtra("rid", str);
      localIntent.putExtra("sid", this.k);
      localIntent.putExtra("session_key", this.p.sessionKey);
      localIntent.putExtra("session_user_id", this.p.userId);
      a(paramContext, str, localIntent);
    }
  }

  public boolean f()
  {
    Iterator localIterator = this.l.values().iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (((Intent)localIterator.next()).getIntExtra("type", -1) != 50);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public String g(Context paramContext)
  {
    return a(paramContext, new FqlGetFriendCheckins(paramContext, null, this.p.sessionKey, null), 500, null);
  }

  public boolean g()
  {
    Iterator localIterator = this.l.values().iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (((Intent)localIterator.next()).getIntExtra("type", -1) != 1100);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void h(Context paramContext)
  {
    c(paramContext, -1, 0);
    b(paramContext, -1, 0);
    a(paramContext, -1, 0);
    d(paramContext, -1, 0);
  }

  public boolean h()
  {
    Iterator localIterator = this.l.values().iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (((Intent)localIterator.next()).getIntExtra("type", -1) != 51);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public AppSession.LoginStatus i()
  {
    return this.q;
  }

  public void i(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("extra_composer_setting", 0).edit();
    localEditor.clear();
    localEditor.commit();
  }

  public ProfileImagesCache j()
  {
    return this.m;
  }

  public StreamPhotosCache k()
  {
    return this.n;
  }

  public void l()
  {
    monitorenter;
    try
    {
      if (this.B == null)
        break label48;
      while (this.B.isHeld())
        this.B.release();
    }
    finally
    {
      monitorexit;
    }
    this.C.clear();
    this.B = null;
    label48: monitorexit;
  }

  protected void n()
  {
    Gatekeeper.a();
    this.d = new HashMap();
    this.c = new HashMap();
  }

  public void o()
  {
    synchronized (this.z)
    {
      this.z.clear();
      this.z.addAll(Arrays.asList(h));
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.AppSession
 * JD-Core Version:    0.6.0
 */
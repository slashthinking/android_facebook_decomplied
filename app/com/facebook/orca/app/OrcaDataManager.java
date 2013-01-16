package com.facebook.orca.app;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.analytics.AnalyticsDatabaseSupplier;
import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.data.ContactsDatabaseSupplier;
import com.facebook.location.LocationCache;
import com.facebook.orca.audio.AudioCache;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.cache.ChatVisibilityCache;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.cache.ThreadsCache;
import com.facebook.orca.common.http.OrcaHttpRequestProcessor;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.contacts.divebar.DivebarCache;
import com.facebook.orca.contacts.favorites.FavoriteContactsCache;
import com.facebook.orca.contacts.favorites.MobileAppDataCache;
import com.facebook.orca.contacts.favorites.TopLastActiveCache;
import com.facebook.orca.database.DbMessageCache;
import com.facebook.orca.database.ThreadsDatabaseSupplier;
import com.facebook.orca.database.UsersDatabaseSupplier;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.location.GeocodingCache;
import com.facebook.orca.prefs.AuthPrefKeys;
import com.facebook.orca.prefs.ConfigPrefKeys;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.MessengerPrefKeys;
import com.facebook.orca.prefs.OrcaAuthPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.OrcaSharedPreferencesImpl;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;
import com.facebook.orca.prefs.UiCounters;
import com.facebook.orca.rollout.OrcaRolloutManager;
import com.facebook.orca.server.OrcaServiceQueueManager;
import com.facebook.zero.prefs.ZeroPrefKeys;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.inject.Provider;

public class OrcaDataManager
  implements INeedInit
{
  private static final Set<PrefKey> E;
  private static final Class<?> a = OrcaDataManager.class;
  private final OrcaRolloutManager A;
  private final OrcaActivityBroadcaster B;
  private final OrcaDataManager.MyAuthComponent C;
  private OrcaSharedPreferences.OnSharedPreferenceChangeListener D;
  private final Context b;
  private final MeUserAuthDataStore c;
  private final Provider<Boolean> d;
  private final ImageCache e;
  private final AudioCache f;
  private final ThreadsDatabaseSupplier g;
  private final ThreadsCache h;
  private final ThreadDisplayCache i;
  private final UsersDatabaseSupplier j;
  private final AnalyticsDatabaseSupplier k;
  private final ContactsDatabaseSupplier l;
  private final OrcaSharedPreferencesImpl m;
  private final UiCounters n;
  private final DivebarCache o;
  private final FavoriteContactsCache p;
  private final TopLastActiveCache q;
  private final ContactsCache r;
  private final MobileAppDataCache s;
  private final AndroidThreadUtil t;
  private final OrcaServiceQueueManager u;
  private final OrcaHttpRequestProcessor v;
  private final LocationCache w;
  private final GeocodingCache x;
  private final DbMessageCache y;
  private final ChatVisibilityCache z;

  static
  {
    PrefKey localPrefKey1 = AuthPrefKeys.b;
    PrefKey localPrefKey2 = OrcaAuthPrefKeys.c;
    PrefKey localPrefKey3 = MessengerPrefKeys.p;
    PrefKey localPrefKey4 = ConfigPrefKeys.a;
    PrefKey localPrefKey5 = MessagesPrefKeys.s;
    PrefKey localPrefKey6 = MessagesPrefKeys.u;
    PrefKey[] arrayOfPrefKey = new PrefKey[2];
    arrayOfPrefKey[0] = GkPrefKeys.c;
    arrayOfPrefKey[1] = ZeroPrefKeys.b;
    E = ImmutableSet.a(localPrefKey1, localPrefKey2, localPrefKey3, localPrefKey4, localPrefKey5, localPrefKey6, arrayOfPrefKey);
  }

  public OrcaDataManager(Context paramContext, MeUserAuthDataStore paramMeUserAuthDataStore, Provider<Boolean> paramProvider, ImageCache paramImageCache, AudioCache paramAudioCache, ThreadsDatabaseSupplier paramThreadsDatabaseSupplier, ThreadsCache paramThreadsCache, ThreadDisplayCache paramThreadDisplayCache, UsersDatabaseSupplier paramUsersDatabaseSupplier, AnalyticsDatabaseSupplier paramAnalyticsDatabaseSupplier, OrcaSharedPreferencesImpl paramOrcaSharedPreferencesImpl, UiCounters paramUiCounters, DivebarCache paramDivebarCache, FavoriteContactsCache paramFavoriteContactsCache, TopLastActiveCache paramTopLastActiveCache, AndroidThreadUtil paramAndroidThreadUtil, OrcaServiceQueueManager paramOrcaServiceQueueManager, OrcaHttpRequestProcessor paramOrcaHttpRequestProcessor, LocationCache paramLocationCache, GeocodingCache paramGeocodingCache, DbMessageCache paramDbMessageCache, ChatVisibilityCache paramChatVisibilityCache, OrcaRolloutManager paramOrcaRolloutManager, OrcaActivityBroadcaster paramOrcaActivityBroadcaster, ContactsDatabaseSupplier paramContactsDatabaseSupplier, ContactsCache paramContactsCache, MobileAppDataCache paramMobileAppDataCache)
  {
    this.b = paramContext;
    this.c = paramMeUserAuthDataStore;
    this.d = paramProvider;
    this.e = paramImageCache;
    this.f = paramAudioCache;
    this.g = paramThreadsDatabaseSupplier;
    this.h = paramThreadsCache;
    this.i = paramThreadDisplayCache;
    this.j = paramUsersDatabaseSupplier;
    this.k = paramAnalyticsDatabaseSupplier;
    this.m = paramOrcaSharedPreferencesImpl;
    this.n = paramUiCounters;
    this.o = paramDivebarCache;
    this.p = paramFavoriteContactsCache;
    this.t = paramAndroidThreadUtil;
    this.u = paramOrcaServiceQueueManager;
    this.v = paramOrcaHttpRequestProcessor;
    this.w = paramLocationCache;
    this.x = paramGeocodingCache;
    this.y = paramDbMessageCache;
    this.z = paramChatVisibilityCache;
    this.A = paramOrcaRolloutManager;
    this.B = paramOrcaActivityBroadcaster;
    this.q = paramTopLastActiveCache;
    this.C = new OrcaDataManager.MyAuthComponent(this);
    this.l = paramContactsDatabaseSupplier;
    this.r = paramContactsCache;
    this.s = paramMobileAppDataCache;
  }

  private void k()
  {
    this.t.c(new OrcaDataManager.2(this));
  }

  private void l()
  {
    this.w.b();
    this.x.a();
  }

  private void m()
  {
    this.l.a();
    this.r.a();
  }

  private void n()
  {
    String str = this.m.a(SharedPrefKeys.i, "-1");
    int i1;
    if (this.m.a(SharedPrefKeys.j, false))
    {
      i1 = 2;
      if (i1 == -1)
        break label57;
      BLog.a(i1);
    }
    while (true)
    {
      while (true)
      {
        return;
        try
        {
          int i2 = Integer.parseInt(str);
          i1 = i2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          i1 = -1;
        }
      }
      break;
      label57: BLog.a(5);
    }
  }

  public void b()
  {
    this.t.b();
    this.u.a();
    while (true)
    {
      try
      {
        this.v.a();
      }
      finally
      {
        try
        {
          this.v.c();
          this.u.d();
          c();
          if (((Boolean)this.d.b()).booleanValue())
            break label144;
          if (this.c.d())
            continue;
          break label144;
          Preconditions.checkState(bool1);
          if (this.c.e())
            continue;
          boolean bool2 = true;
          Preconditions.checkState(bool2);
          this.v.b();
          return;
          bool1 = false;
          continue;
          bool2 = false;
        }
        finally
        {
          this.v.b();
        }
        this.u.b();
      }
      label144: boolean bool1 = true;
    }
  }

  public void c()
  {
    d();
    i();
  }

  public void d()
  {
    e();
    h();
    l();
    m();
    this.e.c();
    this.f.c();
    this.z.c();
  }

  public void e()
  {
    this.g.a();
    this.y.a();
    this.h.b();
    this.i.a();
    Intent localIntent = new Intent();
    localIntent.setAction("com.facebook.orca.ACTION_THREAD_CACHE_CLEARED");
    LocalBroadcastManager.a(this.b).a(localIntent);
  }

  public void f()
  {
    this.h.c();
    this.i.b();
  }

  public void g()
  {
    this.g.c();
    this.y.b();
  }

  public void h()
  {
    this.j.a();
    this.o.e();
    this.p.a();
    this.q.b();
    this.s.c();
  }

  public void i()
  {
    this.m.a(E);
    this.c.f();
  }

  public void i_()
  {
    Tracer localTracer = Tracer.a("OrcaDataManager.init");
    n();
    if (BLog.b(2))
      this.m.d();
    if (this.m.a(OrcaAuthPrefKeys.c, -1) < 2)
    {
      BLog.c(a, "Me user version upgrade to version 2");
      this.c.f();
      d();
      OrcaSharedPreferences.Editor localEditor3 = this.m.b();
      localEditor3.a(OrcaAuthPrefKeys.c, 2);
      localEditor3.a();
    }
    if (this.m.a(GkPrefKeys.b, -1) < 8)
    {
      Class localClass2 = a;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(8);
      BLog.c(localClass2, "GK version upgrade to version %d", arrayOfObject2);
      this.c.f();
      OrcaSharedPreferences.Editor localEditor2 = this.m.b();
      localEditor2.a(GkPrefKeys.b, 8);
      localEditor2.a();
    }
    int i1 = this.m.a(ConfigPrefKeys.e, -1);
    int i2 = this.A.b();
    if (i1 < i2)
    {
      Class localClass1 = a;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(i2);
      BLog.c(localClass1, "Rollout version upgrade to version %d", arrayOfObject1);
      this.c.f();
      OrcaSharedPreferences.Editor localEditor1 = this.m.b();
      localEditor1.a(ConfigPrefKeys.e, i2);
      localEditor1.a();
    }
    this.D = new OrcaDataManager.1(this);
    this.m.a(this.D);
    localTracer.a();
  }

  public OrcaDataManager.MyAuthComponent j()
  {
    return this.C;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.OrcaDataManager
 * JD-Core Version:    0.6.0
 */
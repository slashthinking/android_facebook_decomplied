package com.facebook.orca.presence;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.common.util.TriState;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.mqtt.MqttQOSLevel;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.PayForPlayPresence;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.push.mqtt.MqttConnectionManager;
import com.facebook.orca.push.prefs.PushPrefKeys;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.users.FacebookUserIterator;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public class PresenceManager
  implements INeedInit
{
  private static final Class<?> a = PresenceManager.class;
  private static final PrefKey b = GkPrefKeys.a("messenger_user_presence_active_android");
  private final MqttConnectionManager c;
  private final Provider<FacebookUserIterator> d;
  private final Provider<Boolean> e;
  private final AndroidThreadUtil f;
  private final ListeningExecutorService g;
  private final Executor h;
  private final OrcaSharedPreferences i;
  private final LocalBroadcastManager j;
  private final OrcaSharedPreferences.OnSharedPreferenceChangeListener k;
  private final Multimap<UserKey, PresenceManager.OnContactPresenceStateChangedListener> l;
  private final ConcurrentMap<PresenceManager.OnPresenceReceivedListener, Boolean> m;
  private final ConcurrentMap<UserKey, PresenceManager.UserState> n;
  private volatile boolean o;
  private final SafeLocalBroadcastReceiver p;

  public PresenceManager(Context paramContext, MqttConnectionManager paramMqttConnectionManager, Provider<FacebookUserIterator> paramProvider, Provider<Boolean> paramProvider1, AndroidThreadUtil paramAndroidThreadUtil, ListeningExecutorService paramListeningExecutorService, Executor paramExecutor, OrcaSharedPreferences paramOrcaSharedPreferences, LocalBroadcastManager paramLocalBroadcastManager)
  {
    paramAndroidThreadUtil.a();
    this.c = paramMqttConnectionManager;
    this.d = paramProvider;
    this.e = paramProvider1;
    this.f = paramAndroidThreadUtil;
    this.g = paramListeningExecutorService;
    this.h = paramExecutor;
    this.i = paramOrcaSharedPreferences;
    this.j = paramLocalBroadcastManager;
    this.l = HashMultimap.m();
    this.m = Maps.c();
    this.n = Maps.c();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.orca.ACTION_PERSISTENT_CHANNEL_STATE_CHANGED");
    localIntentFilter.addAction("com.facebook.orca.ACTION_FRIEND_SYNC_PROGRESS");
    this.p = new PresenceManager.1(this, paramContext, localIntentFilter);
    this.k = new PresenceManager.2(this);
    paramOrcaSharedPreferences.a(this.k);
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator2 = this.l.h().iterator();
      while (localIterator2.hasNext())
        d((UserKey)localIterator2.next());
    }
    Iterator localIterator1 = this.m.keySet().iterator();
    while (localIterator1.hasNext())
      ((PresenceManager.OnPresenceReceivedListener)localIterator1.next()).a();
  }

  private void b(Message paramMessage)
  {
    BLog.a(a, "Message received: %s", new Object[] { paramMessage });
    UserKey localUserKey = paramMessage.f().e();
    PresenceManager.UserState localUserState = (PresenceManager.UserState)this.n.get(localUserKey);
    if ((localUserState != null) && (localUserState.a))
    {
      localUserState.a = false;
      d(localUserKey);
    }
  }

  private void b(UserKey paramUserKey, int paramInt)
  {
    int i1 = 1;
    Class localClass = a;
    Object[] arrayOfObject = new Object[i1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    BLog.a(localClass, "User typing state changed: %d", arrayOfObject);
    PresenceManager.UserState localUserState = c(paramUserKey);
    if (paramInt == i1);
    while (true)
    {
      localUserState.a = i1;
      d(paramUserKey);
      return;
      i1 = 0;
    }
  }

  private void b(Map<UserKey, Integer> paramMap, boolean paramBoolean)
  {
    BLog.a(a, "Presence map received");
    if (paramBoolean)
    {
      Iterator localIterator2 = this.n.values().iterator();
      while (localIterator2.hasNext())
        ((PresenceManager.UserState)localIterator2.next()).c = false;
    }
    Iterator localIterator1 = paramMap.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      PresenceManager.UserState localUserState = c((UserKey)localEntry.getKey());
      if (((Integer)localEntry.getValue()).intValue() == 2);
      for (boolean bool = true; ; bool = false)
      {
        localUserState.c = bool;
        d((UserKey)localEntry.getKey());
        break;
      }
    }
    a(paramBoolean);
  }

  private PresenceManager.UserState c(UserKey paramUserKey)
  {
    Object localObject = (PresenceManager.UserState)this.n.get(paramUserKey);
    if (localObject == null)
    {
      PresenceManager.UserState localUserState = new PresenceManager.UserState(null);
      localObject = (PresenceManager.UserState)this.n.putIfAbsent(paramUserKey, localUserState);
      if (localObject == null)
        localObject = localUserState;
    }
    return (PresenceManager.UserState)localObject;
  }

  private void d(UserKey paramUserKey)
  {
    this.f.a();
    if (this.l.d(paramUserKey))
    {
      PresenceState localPresenceState = b(paramUserKey);
      Iterator localIterator = this.l.b(paramUserKey).iterator();
      while (localIterator.hasNext())
        ((PresenceManager.OnContactPresenceStateChangedListener)localIterator.next()).a(paramUserKey, localPresenceState);
    }
  }

  private void k()
  {
    Intent localIntent = new Intent("com.facebook.orca.presence.PRESENCE_MANAGER_SETTINGS_CHANGED");
    this.j.a(localIntent);
    a(true);
  }

  private void l()
  {
    this.o = false;
    m();
  }

  private void m()
  {
    if (this.o);
    while (true)
    {
      return;
      this.o = true;
      Futures.a(this.g.a(new PresenceManager.3(this)), new PresenceManager.4(this), this.h);
    }
  }

  private void n()
  {
    this.f.b();
    FacebookUserIterator localFacebookUserIterator = (FacebookUserIterator)this.d.b();
    localFacebookUserIterator.a();
    while (true)
    {
      boolean bool;
      try
      {
        User localUser = localFacebookUserIterator.d();
        if (localUser == null)
          break;
        PresenceManager.UserState localUserState = c(localUser.c());
        if (localUser.w() != TriState.YES)
          continue;
        bool = true;
        localUserState.b = bool;
      }
      finally
      {
        localFacebookUserIterator.e();
      }
    }
    localFacebookUserIterator.e();
  }

  private void o()
  {
    this.f.a();
    Iterator localIterator = this.n.keySet().iterator();
    while (localIterator.hasNext())
      d((UserKey)localIterator.next());
  }

  private void p()
  {
    BLog.a(a, "MQTT disconnected");
    Iterator localIterator1 = this.n.values().iterator();
    while (localIterator1.hasNext())
    {
      PresenceManager.UserState localUserState = (PresenceManager.UserState)localIterator1.next();
      localUserState.c = false;
      localUserState.a = false;
    }
    Iterator localIterator2 = this.l.h().iterator();
    while (localIterator2.hasNext())
      d((UserKey)localIterator2.next());
  }

  private boolean q()
  {
    return h().shouldShowPresence();
  }

  public void a(PresenceManager.OnPresenceReceivedListener paramOnPresenceReceivedListener)
  {
    this.m.put(paramOnPresenceReceivedListener, Boolean.valueOf(true));
    m();
  }

  public void a(Message paramMessage)
  {
    this.f.b(new PresenceManager.7(this, paramMessage));
  }

  public void a(UserKey paramUserKey, int paramInt)
  {
    this.f.b(new PresenceManager.5(this, paramUserKey, paramInt));
  }

  public void a(UserKey paramUserKey, PresenceManager.OnContactPresenceStateChangedListener paramOnContactPresenceStateChangedListener)
  {
    this.f.a();
    this.l.a(paramUserKey, paramOnContactPresenceStateChangedListener);
    m();
  }

  public void a(String paramString, int paramInt)
  {
    this.f.a();
    if (!((Boolean)this.e.b()).booleanValue());
    while (true)
    {
      return;
      ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("to", paramString);
      localObjectNode.put("state", paramInt);
      this.c.a("/typing", localObjectNode, MqttQOSLevel.FIRE_AND_FORGET);
    }
  }

  public void a(Map<UserKey, Integer> paramMap, boolean paramBoolean)
  {
    this.f.b(new PresenceManager.6(this, paramMap, paramBoolean));
  }

  public boolean a(UserKey paramUserKey)
  {
    boolean bool;
    if (!q())
      bool = false;
    while (true)
    {
      return bool;
      PresenceManager.UserState localUserState = (PresenceManager.UserState)this.n.get(paramUserKey);
      if (localUserState == null)
      {
        bool = false;
        continue;
      }
      bool = localUserState.c;
    }
  }

  public PresenceState b(UserKey paramUserKey)
  {
    if (!q());
    PresenceManager.UserState localUserState;
    for (PresenceState localPresenceState = new PresenceState(Availability.NONE, false, false); ; localPresenceState = new PresenceState(Availability.NONE, false, false))
    {
      return localPresenceState;
      localUserState = (PresenceManager.UserState)this.n.get(paramUserKey);
      if (localUserState != null)
        break;
    }
    if (localUserState.c);
    for (Availability localAvailability = Availability.AVAILABLE; ; localAvailability = Availability.NONE)
    {
      localPresenceState = new PresenceState(localAvailability, localUserState.b, localUserState.a);
      break;
    }
  }

  public void b(PresenceManager.OnPresenceReceivedListener paramOnPresenceReceivedListener)
  {
    this.m.remove(paramOnPresenceReceivedListener);
  }

  public void b(UserKey paramUserKey, PresenceManager.OnContactPresenceStateChangedListener paramOnContactPresenceStateChangedListener)
  {
    this.f.a();
    this.l.c(paramUserKey, paramOnContactPresenceStateChangedListener);
  }

  public boolean b()
  {
    if (!((Boolean)this.e.b()).booleanValue());
    for (boolean bool = false; ; bool = this.c.g())
      return bool;
  }

  public Collection<UserKey> c()
  {
    if (!q());
    ArrayList localArrayList;
    for (Object localObject = Collections.emptyList(); ; localObject = localArrayList)
    {
      return localObject;
      localArrayList = Lists.a();
      Iterator localIterator = this.n.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!((PresenceManager.UserState)localEntry.getValue()).c)
          continue;
        localArrayList.add(localEntry.getKey());
      }
    }
  }

  public Collection<UserKey> d()
  {
    if (!((Boolean)this.e.b()).booleanValue());
    ArrayList localArrayList;
    for (Object localObject = Collections.emptyList(); ; localObject = localArrayList)
    {
      return localObject;
      localArrayList = Lists.a();
      Iterator localIterator = this.n.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!((PresenceManager.UserState)localEntry.getValue()).b)
          continue;
        localArrayList.add(localEntry.getKey());
      }
    }
  }

  public void e()
  {
    this.f.b(new PresenceManager.8(this));
  }

  public boolean f()
  {
    if ((((Boolean)this.e.b()).booleanValue()) && (this.i.a(b, false)));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean g()
  {
    boolean bool = true;
    if ((f()) && (this.i.a(PushPrefKeys.a, bool)));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public PayForPlayPresence h()
  {
    PayForPlayPresence localPayForPlayPresence;
    if (f())
      if (g())
        localPayForPlayPresence = PayForPlayPresence.ENABLED;
    while (true)
    {
      return localPayForPlayPresence;
      localPayForPlayPresence = PayForPlayPresence.DISABLED;
      continue;
      localPayForPlayPresence = PayForPlayPresence.OFF;
    }
  }

  public void i_()
  {
    this.p.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.presence.PresenceManager
 * JD-Core Version:    0.6.0
 */
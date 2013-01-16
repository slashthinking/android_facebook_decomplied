package com.facebook.orca.prefs;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedMap<Lcom.facebook.orca.prefs.PrefKey;Ljava.lang.Object;>;
import java.util.TreeMap;

public class PrefsMigrator
{
  static final ImmutableMap<String, String> a;
  static final ImmutableMap<String, String> b;
  static final PrefKey c;
  static final PrefKey d;
  private static final String e = new String();

  static
  {
    a = ImmutableMap.k().b("/app_info", e).b("//gk", e).b();
    b = ImmutableMap.k().b("/auth/", "/auth/user_data/").b("/orca/auth_machine_id", "/auth/auth_machine_id").b("/orca/me_user_version", "/auth/me_user_version").b("/orca/app_info", "/config/app_info").b("/orca/gk/", "/config/gk/").b("/orca/gk_version", "/config/gk/version").b("/orca/rollout/", "/config/rollout").b("/orca/rollout_version", "/config/rollout/version").b("/orca/device_id/", "/shared/device_id").b("/orca/c2dm/", "/messenger/c2dm/").b("/orca/first_install_time", "/messenger/first_install_time").b("/orca/nux_completed", "/messenger/nux_completed").b("/orca/login_reminder_trigger_state", "/messenger/login_reminder_trigger_state").b("/orca/phone_confirm", "/messenger/phone_confirm").b("/orca/sms", "/messages/sms").b("/orca/ui_counters", "/messages/ui_counters").b("/orca/notifications/recent_threads", "/messages/notifications/recent_threads").b("/preferences/notifications/location_services", "/settings/messages/location_services").b("/preferences/notifications", "/settings/messages/notifications").b("/preferences/threads", "/settings/messages/threads").b("/orca/internal/debug_logs", "/settings/logging/debug_logs").b("/orca/internal/logging_level", "/settings/logging/logging_level").b("/orca/internal/php_profiling", "/settings/http/php_profiling").b("/orca/internal/wirehog_profiling", "/settings/http/wirehog_profiling").b("/orca/internal/force_fb4a_look_and_feel", "/settings/messenger/force_fb4a_look_and_feel").b("/orca/internal/web", "/settings/sandbox/web").b("/orca/internal/mqtt", "/settings/sandbox/mqtt").b("/orca/device_id", "/shared/device_id").b("/orca/mqtt", "/mqtt").b("/orca/top_last_active_sync_time", e).b();
    c = new PrefKey("/orca/pref_version");
    d = new PrefKey("/_meta_/prefs_version");
  }

  private void a(PrefKey paramPrefKey1, PrefKey paramPrefKey2, SortedMap<PrefKey, Object> paramSortedMap1, SortedMap<PrefKey, Object> paramSortedMap2)
  {
    SortedMap localSortedMap = PrefKeyUtil.a(paramSortedMap1, paramPrefKey1);
    Iterator localIterator = localSortedMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramPrefKey2 == null)
        continue;
      paramSortedMap2.put((PrefKey)paramPrefKey2.c(((PrefKey)localEntry.getKey()).b(paramPrefKey1)), localEntry.getValue());
    }
    localSortedMap.clear();
  }

  private int b(Map<PrefKey, Object> paramMap)
  {
    int i;
    if (paramMap.containsKey(d))
      i = ((Integer)paramMap.get(d)).intValue();
    while (true)
    {
      return i;
      if (paramMap.containsKey(c))
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public SortedMap<PrefKey, Object> a(SortedMap<PrefKey, Object> paramSortedMap)
  {
    Object localObject = Maps.a(paramSortedMap);
    int i = b((Map)localObject);
    if (i == 0)
    {
      localObject = a((SortedMap)localObject, a);
      i = 1;
    }
    if (i == 1)
    {
      ((SortedMap)localObject).remove(c);
      localObject = a((SortedMap)localObject, b);
      ((SortedMap)localObject).put(d, Integer.valueOf(2));
    }
    return (SortedMap<PrefKey, Object>)localObject;
  }

  SortedMap<PrefKey, Object> a(SortedMap<PrefKey, Object> paramSortedMap, Map<String, String> paramMap)
  {
    TreeMap localTreeMap = Maps.d();
    Iterator localIterator = paramMap.entrySet().iterator();
    Map.Entry localEntry;
    PrefKey localPrefKey1;
    if (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localPrefKey1 = new PrefKey((String)localEntry.getKey());
      if (localEntry.getValue() == e)
        break label105;
    }
    label105: for (PrefKey localPrefKey2 = new PrefKey((String)localEntry.getValue()); ; localPrefKey2 = null)
    {
      a(localPrefKey1, localPrefKey2, paramSortedMap, localTreeMap);
      break;
      return localTreeMap;
    }
  }

  public boolean a(Map<PrefKey, Object> paramMap)
  {
    if (b(paramMap) != 2);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.PrefsMigrator
 * JD-Core Version:    0.6.0
 */
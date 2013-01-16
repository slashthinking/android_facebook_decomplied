package com.facebook.katana.provider;

import android.content.Context;
import com.facebook.katana.service.vault.VaultManager;
import com.facebook.orca.inject.FbInjector;

public class UserValuesManager
{
  private static final String[] a = { "value" };
  private static final String[] b = { "_id" };
  private final KeyValueStore c;

  public UserValuesManager(KeyValueStore paramKeyValueStore)
  {
    this.c = paramKeyValueStore;
  }

  public static long a(Context paramContext, String paramString, long paramLong)
  {
    return o(paramContext).a(paramString, paramLong);
  }

  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return o(paramContext).a(paramString1, paramString2);
  }

  public static void a(Context paramContext, long paramLong)
  {
    a(paramContext, "vault:device_fbid", Long.valueOf(paramLong));
  }

  public static void a(Context paramContext, String paramString, Object paramObject)
  {
    UserValuesManager localUserValuesManager = o(paramContext);
    if (paramObject == null);
    for (String str = null; ; str = paramObject.toString())
    {
      localUserValuesManager.b(paramString, str);
      return;
    }
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, "sync", Boolean.valueOf(paramBoolean));
  }

  public static boolean a(Context paramContext)
  {
    return a(paramContext, "sync");
  }

  public static boolean a(Context paramContext, String paramString)
  {
    return o(paramContext).a(paramString);
  }

  public static void b(Context paramContext, long paramLong)
  {
    a(paramContext, "vault:last_synced_date", Long.valueOf(paramLong));
  }

  public static void b(Context paramContext, String paramString)
  {
    if (paramString == null)
      o(paramContext).b("current_account");
    while (true)
    {
      return;
      o(paramContext).b("current_account", paramString);
    }
  }

  public static void b(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, "ringtone", Boolean.valueOf(paramBoolean));
  }

  public static boolean b(Context paramContext)
  {
    return Boolean.parseBoolean(a(paramContext, "ringtone", "false"));
  }

  public static String c(Context paramContext)
  {
    return a(paramContext, "current_account", null);
  }

  public static void c(Context paramContext, long paramLong)
  {
    a(paramContext, "vault:retry_millis", Long.valueOf(paramLong));
  }

  public static void c(Context paramContext, String paramString)
  {
    o(paramContext).d(paramContext, paramString);
  }

  public static void c(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, "vault:sync_old_photo", Boolean.valueOf(paramBoolean));
  }

  public static String d(Context paramContext)
  {
    return a(paramContext, "active_session_info", null);
  }

  public static void d(Context paramContext, long paramLong)
  {
    a(paramContext, "vault:vault_table_cutoff_time", Long.valueOf(paramLong));
  }

  public static void e(Context paramContext)
  {
    a(paramContext, "last_contacts_sync", Long.valueOf(System.currentTimeMillis()));
  }

  public static void e(Context paramContext, long paramLong)
  {
    a(paramContext, "vault:device_created_time", Long.valueOf(paramLong));
  }

  public static void e(Context paramContext, String paramString)
  {
    a(paramContext, "vault:sync_mode", paramString);
    ((VaultManager)FbInjector.a(paramContext).a(VaultManager.class)).d();
  }

  public static long f(Context paramContext)
  {
    return Long.parseLong(a(paramContext, "last_contacts_sync", "0"));
  }

  public static long g(Context paramContext)
  {
    return a(paramContext, "vault:device_fbid", 0L);
  }

  public static boolean h(Context paramContext)
  {
    return a(paramContext, "vault:sync_old_photo");
  }

  public static long i(Context paramContext)
  {
    return a(paramContext, "vault:last_synced_date", 0L);
  }

  public static String j(Context paramContext)
  {
    return a(paramContext, "vault:sync_mode", "OFF");
  }

  public static long k(Context paramContext)
  {
    return a(paramContext, "vault:retry_millis", 120000L);
  }

  public static long l(Context paramContext)
  {
    return a(paramContext, "vault:vault_table_cutoff_time", 0L);
  }

  public static long m(Context paramContext)
  {
    return a(paramContext, "vault:device_created_time", 0L);
  }

  public static void n(Context paramContext)
  {
    o(paramContext).a();
    b(paramContext, true);
  }

  private static UserValuesManager o(Context paramContext)
  {
    return (UserValuesManager)FbInjector.a(paramContext).a(UserValuesManager.class);
  }

  public long a(String paramString, long paramLong)
  {
    String str = a(paramString, null);
    if (str != null)
      paramLong = Long.parseLong(str);
    return paramLong;
  }

  public String a(String paramString1, String paramString2)
  {
    return this.c.a(paramString1, paramString2);
  }

  public void a()
  {
    this.c.a();
  }

  public boolean a(String paramString)
  {
    return Boolean.parseBoolean(a(paramString, "false"));
  }

  public void b(String paramString)
  {
    this.c.a(paramString);
  }

  public void b(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2, true);
  }

  void d(Context paramContext, String paramString)
  {
    if (paramString == null)
      b("active_session_info");
    while (true)
    {
      return;
      b("active_session_info", paramString);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.UserValuesManager
 * JD-Core Version:    0.6.0
 */
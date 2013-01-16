package com.facebook.katana.util.logging;

import android.content.Context;
import android.net.NetworkInfo;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.binding.UploadManagerConnectivity;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.provider.VaultImageProviderRow;
import com.facebook.katana.service.vault.VaultLocalImageFetcher;
import com.facebook.orca.inject.FbInjector;

public class VaultLogger extends InteractionLogger
{
  public static String a = "nux_shown";
  public static String b = "nux_accept";
  public static String c = "nux_reject";
  public static String d = "sync_start";
  public static String e = "sync_photo_start";
  public static String f = "sync_photo_success";
  public static String g = "sync_photo_failure";
  public static String h = "sync_snap_to_first_sync_time";
  public static String i = "sync_snap_to_success";
  public static String j = "sync_hit_max_sync_failure";
  public static String k = "enable_sync";
  public static String l = "disable_sync";
  public static String m = "connectivity";
  public static String n = "image_observer";
  public static String o = "observer_startup";
  public static String p = "retry";
  public static String q = "setup";
  public static String r = "mobile_highres_pref";
  public static String s = "processor_idle";
  public static String t = "photo_status";
  private final Context u;

  public VaultLogger(Context paramContext)
  {
    super(paramContext);
    this.u = paramContext;
  }

  private void a(HoneyClientEvent paramHoneyClientEvent)
  {
    NetworkInfo localNetworkInfo = UploadManagerConnectivity.c(this.u);
    if (localNetworkInfo != null)
    {
      paramHoneyClientEvent.b("connectivity", localNetworkInfo.getTypeName());
      paramHoneyClientEvent.b("connectivity_subtype", localNetworkInfo.getSubtypeName());
    }
    while (true)
    {
      a(paramHoneyClientEvent);
      return;
      paramHoneyClientEvent.b("connectivity", "NONE");
      paramHoneyClientEvent.b("connectivity_subtype", "NONE");
    }
  }

  private HoneyClientEvent f(String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent(paramString);
    localHoneyClientEvent.d(FB4A_AnalyticEntities.Modules.m);
    localHoneyClientEvent.a("vault_device_oid", UserValuesManager.g(this.u));
    return localHoneyClientEvent;
  }

  public void a(int paramInt1, int paramInt2)
  {
    HoneyClientEvent localHoneyClientEvent = f(d);
    switch (paramInt1)
    {
    default:
      ErrorReporting.a("vault_logger", "unknown sync reason: " + paramInt1, true);
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    }
    while (true)
    {
      localHoneyClientEvent.a("images_queued", paramInt2);
      a(localHoneyClientEvent);
      return;
      localHoneyClientEvent.b("reason", n);
      continue;
      localHoneyClientEvent.b("reason", o);
      continue;
      localHoneyClientEvent.b("reason", m);
      continue;
      localHoneyClientEvent.b("reason", p);
      continue;
      localHoneyClientEvent.b("reason", q);
      continue;
      localHoneyClientEvent.b("reason", r);
      continue;
      localHoneyClientEvent.b("reason", r);
      continue;
      localHoneyClientEvent.b("reason", s);
      continue;
      localHoneyClientEvent.b("reason", t);
      continue;
      localHoneyClientEvent.b("reason", "power_plugged_in");
      continue;
      localHoneyClientEvent.b("reason", "sync_older_photos");
      localHoneyClientEvent.a("library_size", ((VaultLocalImageFetcher)FbInjector.a(this.u).a(VaultLocalImageFetcher.class)).a());
      continue;
      localHoneyClientEvent.b("reason", "retry_by_hashes");
      continue;
      localHoneyClientEvent.b("reason", "pull_to_refresh");
    }
  }

  public void a(VaultImageProviderRow paramVaultImageProviderRow, long paramLong)
  {
    HoneyClientEvent localHoneyClientEvent = f(h);
    localHoneyClientEvent.b("img_hash", paramVaultImageProviderRow.a);
    localHoneyClientEvent.a("time_to_first_sync", System.currentTimeMillis() - paramVaultImageProviderRow.c);
    localHoneyClientEvent.a("file_size", paramLong);
    a(localHoneyClientEvent);
    a(localHoneyClientEvent);
  }

  public void a(VaultImageProviderRow paramVaultImageProviderRow, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = f(f);
    localHoneyClientEvent.b("img_hash", paramVaultImageProviderRow.a);
    if (paramVaultImageProviderRow.f == 0);
    for (String str = "low"; ; str = "high")
    {
      localHoneyClientEvent.b("resolution", str);
      localHoneyClientEvent.a("file_size", paramLong2);
      localHoneyClientEvent.a("upload_time", paramLong1);
      localHoneyClientEvent.a("time_to_success", System.currentTimeMillis() - paramVaultImageProviderRow.c);
      localHoneyClientEvent.a("is_upgrade", paramBoolean);
      localHoneyClientEvent.a("failures", paramVaultImageProviderRow.e);
      localHoneyClientEvent.b("file_path", paramString);
      a(localHoneyClientEvent);
      a(localHoneyClientEvent);
      return;
    }
  }

  public void a(VaultImageProviderRow paramVaultImageProviderRow, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    HoneyClientEvent localHoneyClientEvent = f(g);
    localHoneyClientEvent.b("img_hash", paramVaultImageProviderRow.a);
    localHoneyClientEvent.b("error_msg", paramString1);
    localHoneyClientEvent.a("upload_time", paramLong1);
    localHoneyClientEvent.a("file_size", paramLong2);
    localHoneyClientEvent.b("file_path", paramString2);
    a(localHoneyClientEvent);
    a(localHoneyClientEvent);
  }

  public void a(VaultImageProviderRow paramVaultImageProviderRow, boolean paramBoolean, long paramLong)
  {
    HoneyClientEvent localHoneyClientEvent = f(e);
    localHoneyClientEvent.b("img_hash", paramVaultImageProviderRow.a);
    if (paramBoolean);
    for (String str = "high"; ; str = "low")
    {
      localHoneyClientEvent.b("resolution", str);
      localHoneyClientEvent.a("file_size", paramLong);
      a(localHoneyClientEvent);
      a(localHoneyClientEvent);
      return;
    }
  }

  public void b(VaultImageProviderRow paramVaultImageProviderRow, long paramLong)
  {
    HoneyClientEvent localHoneyClientEvent = f(j);
    localHoneyClientEvent.b("img_hash", paramVaultImageProviderRow.a);
    localHoneyClientEvent.a("file_size", paramLong);
    a(localHoneyClientEvent);
    a(localHoneyClientEvent);
  }

  public void c(String paramString)
  {
    if (paramString.equals("OFF"));
    for (HoneyClientEvent localHoneyClientEvent = f(l); ; localHoneyClientEvent = f(k))
    {
      localHoneyClientEvent.b("mode", paramString);
      a(localHoneyClientEvent);
      a(localHoneyClientEvent);
      return;
    }
  }

  public void d(String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = f(a);
    localHoneyClientEvent.b("ref", paramString);
    a(localHoneyClientEvent);
  }

  public void e(String paramString)
  {
    if (paramString.equals("OFF"));
    for (HoneyClientEvent localHoneyClientEvent = f(c); ; localHoneyClientEvent = f(b))
    {
      localHoneyClientEvent.b("mode", paramString);
      a(localHoneyClientEvent);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.VaultLogger
 * JD-Core Version:    0.6.0
 */
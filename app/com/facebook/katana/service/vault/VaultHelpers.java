package com.facebook.katana.service.vault;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ReceiverCallNotAllowedException;
import android.net.ConnectivityManager;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.UploadManagerConnectivity;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.provider.UserValuesManager;

public class VaultHelpers
{
  private static final Class<?> a = VaultHelpers.class;

  public static void a(Context paramContext, Intent paramIntent, int paramInt)
  {
    if (a(paramContext, paramInt))
    {
      paramIntent.setClass(paramContext, VaultSyncService.class);
      paramIntent.putExtra("sync_reason", paramInt);
      paramContext.startService(paramIntent);
    }
  }

  private static boolean a(int paramInt)
  {
    if ((paramInt == 12) || (paramInt == 11));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(Context paramContext)
  {
    try
    {
      AppSession localAppSession = AppSession.b(paramContext, false);
      bool = false;
      if (localAppSession == null)
        return bool;
    }
    catch (Exception localException)
    {
      while (true)
      {
        ErrorReporting.a("isVaultGKOn: " + localException.getMessage(), "", localException);
        boolean bool = false;
        continue;
        Boolean localBoolean = Gatekeeper.a(paramContext, "vault");
        bool = Boolean.TRUE.equals(localBoolean);
      }
    }
  }

  public static boolean a(Context paramContext, int paramInt)
  {
    boolean bool;
    if (!a(paramContext))
    {
      Log.c(a, "vault gk is off or there is no session, no syncing for you");
      bool = false;
    }
    while (true)
    {
      return bool;
      if (UserValuesManager.g(paramContext) == 0L)
      {
        Log.c(a, "vault device hasn't been setup, can't sync until that happens");
        bool = false;
        continue;
      }
      if (!UploadManagerConnectivity.a(paramContext))
      {
        bool = false;
        continue;
      }
      if (paramInt == 8)
      {
        bool = true;
        continue;
      }
      if ((e(paramContext)) && (!a(paramInt)))
      {
        Log.c(a, "not running VaultServices because battery is low");
        bool = false;
        continue;
      }
      if (!((ConnectivityManager)paramContext.getSystemService("connectivity")).getBackgroundDataSetting())
      {
        Log.b(a, "background data is off, cannot run Vault Services");
        bool = false;
        continue;
      }
      bool = c(paramContext);
    }
  }

  public static Intent b(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, VaultSyncService.class);
    localIntent.putExtra("sync_reason", paramInt);
    return localIntent;
  }

  public static boolean b(Context paramContext)
  {
    String str = UserValuesManager.j(paramContext);
    if ((a(paramContext)) && (!str.equals("OFF")));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static void c(Context paramContext, int paramInt)
  {
    if (a(paramContext, paramInt))
      paramContext.startService(b(paramContext, paramInt));
  }

  public static boolean c(Context paramContext)
  {
    String str = UserValuesManager.j(paramContext);
    boolean bool;
    if (str.equals("WIFI_ONLY"))
      bool = UploadManagerConnectivity.b(paramContext);
    while (true)
    {
      return bool;
      if (str.equals("MOBILE_RADIO"))
      {
        bool = UploadManagerConnectivity.a(paramContext);
        continue;
      }
      bool = false;
    }
  }

  public static boolean d(Context paramContext)
  {
    return UploadManagerConnectivity.b(paramContext);
  }

  public static boolean e(Context paramContext)
  {
    int i = 1;
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    try
    {
      Intent localIntent = paramContext.registerReceiver(null, localIntentFilter);
      j = 0;
      if (localIntent != null)
      {
        int k = localIntent.getIntExtra("plugged", -1);
        j = 0;
        if (k != i)
        {
          j = 0;
          if (k != 2)
            break label59;
        }
      }
      label59: int m;
      int n;
      do
      {
        do
        {
          return j;
          m = localIntent.getIntExtra("level", -1);
          n = localIntent.getIntExtra("scale", -1);
          j = 0;
        }
        while (m < 0);
        j = 0;
      }
      while (n <= 0);
      if (m * 100 / n < 15);
      while (true)
      {
        j = i;
        break;
        i = 0;
      }
    }
    catch (ReceiverCallNotAllowedException localReceiverCallNotAllowedException)
    {
      while (true)
        int j = 0;
    }
  }

  public static boolean f(Context paramContext)
  {
    if (UserValuesManager.g(paramContext) == 0L);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static void g(Context paramContext)
  {
    paramContext.startActivity(IntentUriHandler.a(paramContext, "fb://photosync_help"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultHelpers
 * JD-Core Version:    0.6.0
 */
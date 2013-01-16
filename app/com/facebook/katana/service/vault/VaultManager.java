package com.facebook.katana.service.vault;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.common.util.ProcessUtil;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.service.vault.methods.VaultBlacklistedSyncPathsGet;
import com.facebook.katana.util.FB4AErrorReporting;
import com.facebook.katana.util.logging.VaultLogger;
import com.facebook.orca.inject.FbInjector;
import java.util.Iterator;
import java.util.List;

public class VaultManager
{
  private static final Class<?> a = VaultManager.class;
  private final Context b;
  private boolean c = false;
  private UniqueIdForDeviceHolder d;
  private ProcessUtil e;
  private VaultLogger f;
  private AppSessionListener g;

  public VaultManager(Context paramContext, UniqueIdForDeviceHolder paramUniqueIdForDeviceHolder, ProcessUtil paramProcessUtil)
  {
    this.b = paramContext;
    this.d = paramUniqueIdForDeviceHolder;
    this.e = paramProcessUtil;
  }

  private boolean i()
  {
    return this.e.a(this.b.getPackageName());
  }

  private void j()
  {
    this.b.startService(new Intent(this.b, VaultObserverService.class));
  }

  private void k()
  {
    Log.e(a, "Stopping Observer, VaultSyncService, VaultSyncJobProcessor");
    this.b.stopService(new Intent(this.b, VaultObserverService.class));
    this.b.stopService(new Intent(this.b, VaultSyncService.class));
    this.b.stopService(new Intent(this.b, VaultSyncJobProcessor.class));
    f();
    new Thread(new VaultManager.3(this)).start();
    VaultNotificationManager localVaultNotificationManager = (VaultNotificationManager)FbInjector.a(this.b).a(VaultNotificationManager.class);
    if (localVaultNotificationManager.d() != "end_vault_upload")
      localVaultNotificationManager.b();
  }

  public void a()
  {
    this.f = new VaultLogger(this.b);
    if (!i())
    {
      Log.e(a, "simple VaultManager init for child processes");
      FB4AErrorReporting.a(this.b, this.d.b());
    }
    while (true)
    {
      return;
      if (!this.c)
      {
        Log.e(a, "initing VaultManager in main app");
        AppSession localAppSession = AppSession.b(this.b, false);
        if (localAppSession != null)
          if (VaultHelpers.a(this.b))
            b();
        while (true)
        {
          this.c = true;
          break;
          if (Gatekeeper.a(this.b, "vault") != null)
            continue;
          Log.d(a, "adding gk session listener!");
          this.g = new VaultManager.1(this);
          localAppSession.a(this.g);
          continue;
          ErrorReporting.a("Vault manager encountered invalid session", "there should always be a session at this point", true);
        }
      }
      if (!VaultHelpers.b(this.b))
        continue;
      e();
    }
  }

  public void b()
  {
    Intent localIntent = new Intent(this.b, VaultManagerService.class);
    localIntent.putExtra(VaultManagerService.a, 1);
    this.b.startService(localIntent);
  }

  public void c()
  {
    Intent localIntent = new Intent(this.b, VaultManagerService.class);
    localIntent.putExtra(VaultManagerService.a, 2);
    this.b.startService(localIntent);
  }

  public void d()
  {
    String str = UserValuesManager.j(this.b);
    Log.e(a, "sync mode changed to: " + str);
    this.f.c(str);
    if (VaultHelpers.b(this.b))
      c();
    while (true)
    {
      return;
      if (((VaultDeviceSetup)FbInjector.a(this.b).a(VaultDeviceSetup.class)).a())
      {
        Intent localIntent = new Intent(this.b, VaultUpdateService.class);
        this.b.startService(localIntent);
      }
      k();
    }
  }

  public void e()
  {
    if (VaultBlacklistedSyncPathsGet.a(this.b, new VaultManager.2(this)) != null)
      j();
  }

  public PendingIntent f()
  {
    Log.e(a, "cancelling any pending retry alarms");
    Intent localIntent = VaultHelpers.b(this.b, 3);
    PendingIntent localPendingIntent = PendingIntent.getService(this.b, 0, localIntent, 536870912);
    if (localPendingIntent != null)
    {
      localPendingIntent.cancel();
      ((AlarmManager)this.b.getSystemService("alarm")).cancel(localPendingIntent);
    }
    return localPendingIntent;
  }

  public void g()
  {
    this.c = false;
    if (this.g != null)
    {
      AppSession.b(this.b, false).b(this.g);
      this.g = null;
    }
    k();
    List localList = ((ActivityManager)this.b.getSystemService("activity")).getRunningAppProcesses();
    String str = this.b.getPackageName() + ":vault";
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (!localRunningAppProcessInfo.processName.equals(str))
        continue;
      Process.killProcess(localRunningAppProcessInfo.pid);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultManager
 * JD-Core Version:    0.6.0
 */
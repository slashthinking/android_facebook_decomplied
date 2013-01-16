package com.facebook.katana.service.vault;

import android.app.IntentService;
import android.content.Intent;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;
import java.util.Set;

public class VaultManagerService extends IntentService
{
  public static String a;
  private static final String b = VaultDeviceSetup.class.getSimpleName();

  static
  {
    a = "method_key";
  }

  public VaultManagerService()
  {
    super("VaultSyncManagerService");
  }

  private void b()
  {
    VaultDeviceSetup localVaultDeviceSetup = (VaultDeviceSetup)FbInjector.a(this).a(VaultDeviceSetup.class);
    VaultManager localVaultManager = (VaultManager)FbInjector.a(this).a(VaultManager.class);
    if (!localVaultDeviceSetup.a())
      if (localVaultDeviceSetup.b())
      {
        Log.e(b, "Setup device with existing server data");
        localVaultManager.e();
        VaultHelpers.c(this, 5);
      }
    while (true)
    {
      startService(new Intent(this, VaultUpdateService.class));
      return;
      c();
      localVaultManager.e();
      VaultHelpers.c(this, 4);
      continue;
      localVaultManager.e();
      VaultHelpers.c(this, 5);
    }
  }

  private void c()
  {
    Set localSet = ((VaultTable)FbInjector.a(this).a(VaultTable.class)).a();
    ((VaultNotificationManager)FbInjector.a(this).a(VaultNotificationManager.class)).a(localSet);
  }

  public void a()
  {
    VaultDeviceSetup localVaultDeviceSetup = (VaultDeviceSetup)FbInjector.a(this).a(VaultDeviceSetup.class);
    VaultManager localVaultManager = (VaultManager)FbInjector.a(this).a(VaultManager.class);
    if (!localVaultDeviceSetup.a())
      if (localVaultDeviceSetup.c())
      {
        if (VaultHelpers.b(this))
          localVaultManager.e();
        c();
      }
    while (true)
    {
      return;
      if (VaultHelpers.b(this))
      {
        localVaultManager.e();
        continue;
      }
    }
  }

  public void onCreate()
  {
    super.onCreate();
    AppInitLockHelper.a(this);
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null);
    while (true)
    {
      return;
      switch (paramIntent.getIntExtra(a, -1))
      {
      default:
        ErrorReporting.a(b, "Unsupported method", true);
        break;
      case 1:
        a();
        break;
      case 2:
        b();
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultManagerService
 * JD-Core Version:    0.6.0
 */
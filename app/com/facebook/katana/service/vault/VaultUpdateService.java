package com.facebook.katana.service.vault;

import android.app.IntentService;
import android.content.Intent;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;

public class VaultUpdateService extends IntentService
{
  public VaultUpdateService()
  {
    super("VaultUpdateService");
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
      ((VaultDeviceSetup)FbInjector.a(this).a(VaultDeviceSetup.class)).d();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultUpdateService
 * JD-Core Version:    0.6.0
 */
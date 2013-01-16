package com.facebook.katana.platform;

import android.app.ActivityManager;
import android.content.pm.PackageManager;
import com.facebook.orca.inject.AbstractProvider;

class PlatformUtilitiesModule$PlatformUtilitiesModuleProvider extends AbstractProvider<PlatformPackageUtilities>
{
  private PlatformUtilitiesModule$PlatformUtilitiesModuleProvider(PlatformUtilitiesModule paramPlatformUtilitiesModule)
  {
  }

  public PlatformPackageUtilities a()
  {
    return new PlatformPackageUtilities((PackageManager)b(PackageManager.class), (ActivityManager)b(ActivityManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformUtilitiesModule.PlatformUtilitiesModuleProvider
 * JD-Core Version:    0.6.0
 */
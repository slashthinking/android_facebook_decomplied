package com.facebook.katana.orca;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.base.BuildConstants;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidMessengerAppModule$FbandroidPackageInfoProvider extends AbstractProvider<PackageInfo>
{
  private FbandroidMessengerAppModule$FbandroidPackageInfoProvider(FbandroidMessengerAppModule paramFbandroidMessengerAppModule)
  {
  }

  public PackageInfo a()
  {
    try
    {
      String str = BuildConstants.b();
      PackageInfo localPackageInfo = ((PackageManager)b(PackageManager.class)).getPackageInfo(str, 0);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    throw new RuntimeException(localNameNotFoundException);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidMessengerAppModule.FbandroidPackageInfoProvider
 * JD-Core Version:    0.6.0
 */
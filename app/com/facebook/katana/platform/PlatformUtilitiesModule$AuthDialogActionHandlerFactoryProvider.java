package com.facebook.katana.platform;

import android.support.v4.app.FragmentManager;
import com.facebook.orca.inject.AbstractProvider;

class PlatformUtilitiesModule$AuthDialogActionHandlerFactoryProvider extends AbstractProvider<AuthDialogActionExecutorFactory>
{
  private PlatformUtilitiesModule$AuthDialogActionHandlerFactoryProvider(PlatformUtilitiesModule paramPlatformUtilitiesModule)
  {
  }

  public AuthDialogActionExecutorFactory a()
  {
    return new AuthDialogActionExecutorFactory((FragmentManager)b(FragmentManager.class), (PlatformPackageUtilities)b(PlatformPackageUtilities.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformUtilitiesModule.AuthDialogActionHandlerFactoryProvider
 * JD-Core Version:    0.6.0
 */
package com.facebook.katana.platform;

import com.facebook.katana.provider.ConnectionsProviderInjectable;
import com.facebook.orca.inject.AbstractProvider;

class PlatformUtilitiesModule$ComposeDialogActionExecutorFactoryProvider extends AbstractProvider<ComposeDialogActionExecutorFactory>
{
  private PlatformUtilitiesModule$ComposeDialogActionExecutorFactoryProvider(PlatformUtilitiesModule paramPlatformUtilitiesModule)
  {
  }

  public ComposeDialogActionExecutorFactory a()
  {
    return new ComposeDialogActionExecutorFactory((ConnectionsProviderInjectable)b(ConnectionsProviderInjectable.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformUtilitiesModule.ComposeDialogActionExecutorFactoryProvider
 * JD-Core Version:    0.6.0
 */
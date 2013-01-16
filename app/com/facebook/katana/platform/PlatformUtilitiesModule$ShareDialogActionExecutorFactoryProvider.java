package com.facebook.katana.platform;

import com.facebook.composer.service.ComposerPublishService;
import com.facebook.orca.inject.AbstractProvider;

class PlatformUtilitiesModule$ShareDialogActionExecutorFactoryProvider extends AbstractProvider<ShareDialogActionExecutorFactory>
{
  private PlatformUtilitiesModule$ShareDialogActionExecutorFactoryProvider(PlatformUtilitiesModule paramPlatformUtilitiesModule)
  {
  }

  public ShareDialogActionExecutorFactory a()
  {
    return new ShareDialogActionExecutorFactory((ComposerPublishService)b(ComposerPublishService.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformUtilitiesModule.ShareDialogActionExecutorFactoryProvider
 * JD-Core Version:    0.6.0
 */
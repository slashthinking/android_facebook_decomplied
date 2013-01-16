package com.facebook.katana.platform;

import android.app.Activity;
import com.facebook.composer.service.ComposerPublishService;

public class ShareDialogActionExecutorFactory
{
  private final ComposerPublishService a;

  public ShareDialogActionExecutorFactory(ComposerPublishService paramComposerPublishService)
  {
    this.a = paramComposerPublishService;
  }

  public ShareDialogActionExecutor a(Activity paramActivity, PlatformActivityShareDialogRequest paramPlatformActivityShareDialogRequest)
  {
    return new ShareDialogActionExecutor(this.a, paramActivity, paramPlatformActivityShareDialogRequest);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.ShareDialogActionExecutorFactory
 * JD-Core Version:    0.6.0
 */
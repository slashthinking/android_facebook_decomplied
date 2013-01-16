package com.facebook.katana.platform;

import android.app.Activity;
import com.facebook.katana.provider.ConnectionsProviderInjectable;

public class ComposeDialogActionExecutorFactory
{
  private final ConnectionsProviderInjectable a;

  public ComposeDialogActionExecutorFactory(ConnectionsProviderInjectable paramConnectionsProviderInjectable)
  {
    this.a = paramConnectionsProviderInjectable;
  }

  public ComposeDialogActionExecutor a(Activity paramActivity, PlatformActivityComposeDialogRequest paramPlatformActivityComposeDialogRequest)
  {
    return new ComposeDialogActionExecutor(paramActivity, this.a, paramPlatformActivityComposeDialogRequest);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.ComposeDialogActionExecutorFactory
 * JD-Core Version:    0.6.0
 */
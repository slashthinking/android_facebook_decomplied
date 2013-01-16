package com.facebook.katana.platform;

import android.support.v4.app.FragmentManager;

public class AuthDialogActionExecutorFactory
{
  private final FragmentManager a;
  private final PlatformPackageUtilities b;

  public AuthDialogActionExecutorFactory(FragmentManager paramFragmentManager, PlatformPackageUtilities paramPlatformPackageUtilities)
  {
    this.a = paramFragmentManager;
    this.b = paramPlatformPackageUtilities;
  }

  public AuthDialogActionExecutor a(PlatformActivityLoginDialogRequest paramPlatformActivityLoginDialogRequest, String paramString)
  {
    return new AuthDialogActionExecutor(this.a, paramPlatformActivityLoginDialogRequest.d(), paramString, this.b, paramPlatformActivityLoginDialogRequest.b(), paramPlatformActivityLoginDialogRequest.c());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.AuthDialogActionExecutorFactory
 * JD-Core Version:    0.6.0
 */
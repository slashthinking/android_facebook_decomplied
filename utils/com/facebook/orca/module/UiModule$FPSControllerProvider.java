package com.facebook.orca.module;

import com.facebook.diagnostics.FPSController;
import com.facebook.diagnostics.FpsEnableFlag;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class UiModule$FPSControllerProvider extends AbstractProvider<FPSController>
{
  private UiModule$FPSControllerProvider(UiModule paramUiModule)
  {
  }

  public FPSController a()
  {
    return new FPSController(d(FpsEnableFlag.class), (AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.module.UiModule.FPSControllerProvider
 * JD-Core Version:    0.6.2
 */
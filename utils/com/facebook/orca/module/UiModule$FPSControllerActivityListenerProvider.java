package com.facebook.orca.module;

import com.facebook.diagnostics.FPSController;
import com.facebook.diagnostics.FPSController.ActivityListener;
import com.facebook.orca.inject.AbstractProvider;

class UiModule$FPSControllerActivityListenerProvider extends AbstractProvider<FPSController.ActivityListener>
{
  private UiModule$FPSControllerActivityListenerProvider(UiModule paramUiModule)
  {
  }

  public FPSController.ActivityListener a()
  {
    return ((FPSController)b(FPSController.class)).a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.module.UiModule.FPSControllerActivityListenerProvider
 * JD-Core Version:    0.6.2
 */
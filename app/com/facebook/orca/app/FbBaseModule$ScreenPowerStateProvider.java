package com.facebook.orca.app;

import android.content.Context;
import android.os.PowerManager;
import com.facebook.hardware.ScreenPowerState;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$ScreenPowerStateProvider extends AbstractProvider<ScreenPowerState>
{
  private FbBaseModule$ScreenPowerStateProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public ScreenPowerState a()
  {
    return new ScreenPowerState((Context)b(Context.class, FromApplication.class), (PowerManager)b(PowerManager.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.ScreenPowerStateProvider
 * JD-Core Version:    0.6.0
 */
package com.facebook.orca.app;

import android.content.Context;
import com.facebook.hardware.BatteryStateManager;
import com.facebook.hardware.SystemBatteryStateManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$BatteryStateManagerProvider extends AbstractProvider<BatteryStateManager>
{
  private FbBaseModule$BatteryStateManagerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public BatteryStateManager a()
  {
    return new SystemBatteryStateManager((Context)b(Context.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.BatteryStateManagerProvider
 * JD-Core Version:    0.6.0
 */
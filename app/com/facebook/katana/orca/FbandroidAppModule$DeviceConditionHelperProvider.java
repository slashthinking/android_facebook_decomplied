package com.facebook.katana.orca;

import com.facebook.device.DeviceConditionHelper;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$DeviceConditionHelperProvider extends AbstractProvider<DeviceConditionHelper>
{
  private FbandroidAppModule$DeviceConditionHelperProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public DeviceConditionHelper a()
  {
    return new DeviceConditionHelper(FbandroidAppModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.DeviceConditionHelperProvider
 * JD-Core Version:    0.6.0
 */
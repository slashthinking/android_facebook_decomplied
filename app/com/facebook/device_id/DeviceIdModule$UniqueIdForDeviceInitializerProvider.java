package com.facebook.device_id;

import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class DeviceIdModule$UniqueIdForDeviceInitializerProvider extends AbstractProvider<UniqueIdForDeviceHolder>
{
  private DeviceIdModule$UniqueIdForDeviceInitializerProvider(DeviceIdModule paramDeviceIdModule)
  {
  }

  public UniqueIdForDeviceHolder a()
  {
    return new UniqueIdForDeviceHolder((OrcaSharedPreferences)b(OrcaSharedPreferences.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.device_id.DeviceIdModule.UniqueIdForDeviceInitializerProvider
 * JD-Core Version:    0.6.0
 */
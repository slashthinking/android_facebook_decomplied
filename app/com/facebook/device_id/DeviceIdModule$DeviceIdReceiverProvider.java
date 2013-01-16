package com.facebook.device_id;

import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class DeviceIdModule$DeviceIdReceiverProvider extends AbstractProvider<DeviceIdReceiver>
{
  private DeviceIdModule$DeviceIdReceiverProvider(DeviceIdModule paramDeviceIdModule)
  {
  }

  public DeviceIdReceiver a()
  {
    return new DeviceIdReceiver((Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.device_id.DeviceIdModule.DeviceIdReceiverProvider
 * JD-Core Version:    0.6.0
 */
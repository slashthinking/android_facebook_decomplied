package com.facebook.device_id;

import android.app.AlarmManager;
import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class DeviceIdModule$UniqueDeviceIdBroadcastSenderProvider extends AbstractProvider<UniqueDeviceIdBroadcastSender>
{
  private DeviceIdModule$UniqueDeviceIdBroadcastSenderProvider(DeviceIdModule paramDeviceIdModule)
  {
  }

  public UniqueDeviceIdBroadcastSender a()
  {
    return new UniqueDeviceIdBroadcastSender((UniqueIdForDeviceHolder)b(UniqueIdForDeviceHolder.class), (Clock)b(Clock.class), (Context)b(Context.class, FromApplication.class), (AlarmManager)b(AlarmManager.class, FromApplication.class), a(DeviceIdReceiver.class), c(DeviceIdChangedCallback.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.device_id.DeviceIdModule.UniqueDeviceIdBroadcastSenderProvider
 * JD-Core Version:    0.6.0
 */
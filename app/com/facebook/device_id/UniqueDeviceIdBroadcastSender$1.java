package com.facebook.device_id;

import com.facebook.orca.debug.BLog;
import java.util.Iterator;
import java.util.Set;

class UniqueDeviceIdBroadcastSender$1
  implements DeviceIdReceiver.Callback
{
  public void a(UniqueDeviceId paramUniqueDeviceId)
  {
    UniqueDeviceId localUniqueDeviceId = UniqueDeviceIdBroadcastSender.a(this.a).d();
    if (localUniqueDeviceId.b() > paramUniqueDeviceId.b())
    {
      BLog.d(UniqueDeviceIdBroadcastSender.b(), "device id Changed from: " + localUniqueDeviceId + "to: " + paramUniqueDeviceId);
      UniqueDeviceIdBroadcastSender.a(this.a).a(paramUniqueDeviceId);
      Iterator localIterator = UniqueDeviceIdBroadcastSender.b(this.a).iterator();
      while (localIterator.hasNext())
        ((DeviceIdChangedCallback)localIterator.next()).a(localUniqueDeviceId, paramUniqueDeviceId);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.device_id.UniqueDeviceIdBroadcastSender.1
 * JD-Core Version:    0.6.0
 */
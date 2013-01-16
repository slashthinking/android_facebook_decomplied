package com.facebook.device_id;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;

class DeviceIdReceiver extends BroadcastReceiver
{
  private static final Class<?> a = DeviceIdReceiver.class;
  private final Clock b;
  private volatile DeviceIdReceiver.Callback c;

  public DeviceIdReceiver(Clock paramClock)
  {
    this.b = paramClock;
  }

  public void a(DeviceIdReceiver.Callback paramCallback)
  {
    this.c = paramCallback;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    BLog.d(a, "getting the id response");
    String str = getResultData();
    long l = getResultExtras(true).getLong("device_id_generated_timestamp_ms");
    UniqueDeviceId localUniqueDeviceId;
    if ((getResultCode() == -1) && (str != null))
    {
      localUniqueDeviceId = new UniqueDeviceId(str, l);
      BLog.b(a, "response: " + localUniqueDeviceId);
    }
    while (true)
    {
      if (this.c != null)
        this.c.a(localUniqueDeviceId);
      return;
      localUniqueDeviceId = UniqueIdForDeviceHolder.a(this.b);
      BLog.b(a, "generating new id: " + localUniqueDeviceId);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.device_id.DeviceIdReceiver
 * JD-Core Version:    0.6.0
 */
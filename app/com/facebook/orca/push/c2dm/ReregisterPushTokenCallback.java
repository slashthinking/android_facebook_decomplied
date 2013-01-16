package com.facebook.orca.push.c2dm;

import com.facebook.device_id.DeviceIdChangedCallback;
import com.facebook.device_id.UniqueDeviceId;
import com.facebook.orca.debug.BLog;

public class ReregisterPushTokenCallback
  implements DeviceIdChangedCallback
{
  private static final Class<?> a = ReregisterPushTokenCallback.class;
  private final C2DMRegistrar b;
  private final FacebookPushServerRegistrar c;

  public ReregisterPushTokenCallback(C2DMRegistrar paramC2DMRegistrar, FacebookPushServerRegistrar paramFacebookPushServerRegistrar)
  {
    this.b = paramC2DMRegistrar;
    this.c = paramFacebookPushServerRegistrar;
  }

  public void a(UniqueDeviceId paramUniqueDeviceId1, UniqueDeviceId paramUniqueDeviceId2)
  {
    BLog.b(a, "re-registering push token due to device id changing from " + paramUniqueDeviceId1.a() + " to " + paramUniqueDeviceId2.a());
    this.c.a(this.b.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.ReregisterPushTokenCallback
 * JD-Core Version:    0.6.0
 */
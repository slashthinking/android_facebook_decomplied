package com.facebook.analytics;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.device_id.DeviceIdChangedCallback;
import com.facebook.device_id.UniqueDeviceId;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.debug.BLog;

public class AnalyticsInitializer
  implements DeviceIdChangedCallback, INeedInit
{
  private final Class<?> a = AnalyticsInitializer.class;
  private final UniqueIdForDeviceHolder b;
  private final FbErrorReporter c;

  public AnalyticsInitializer(FbErrorReporter paramFbErrorReporter, UniqueIdForDeviceHolder paramUniqueIdForDeviceHolder)
  {
    this.b = paramUniqueIdForDeviceHolder;
    this.c = paramFbErrorReporter;
  }

  private void a(String paramString)
  {
    if (paramString != null)
    {
      this.c.b("marauder_device_id", paramString);
      BLog.b(this.a, "ErrorReporter DEVICE_ID_KEY set to: " + paramString);
    }
  }

  public void a(UniqueDeviceId paramUniqueDeviceId1, UniqueDeviceId paramUniqueDeviceId2)
  {
    a(paramUniqueDeviceId2.a());
  }

  public void i_()
  {
    a(this.b.b());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsInitializer
 * JD-Core Version:    0.6.2
 */
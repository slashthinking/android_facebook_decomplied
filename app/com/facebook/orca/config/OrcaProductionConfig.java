package com.facebook.orca.config;

import android.content.pm.PackageInfo;
import android.telephony.TelephonyManager;
import com.facebook.app.UserActivityManager;

public class OrcaProductionConfig extends AbstractOrcaConfig
{
  private final PlatformAppHttpConfig a = new PresenceAwarePlatformHttpConfig(paramUserActivityManager, "facebook.com", true, e());
  private final MqttConfig b = new MqttConfig("orcart.facebook.com", 443, true);

  public OrcaProductionConfig(PackageInfo paramPackageInfo, TelephonyManager paramTelephonyManager, UserActivityManager paramUserActivityManager)
  {
    super(paramPackageInfo, paramTelephonyManager);
  }

  public boolean d()
  {
    return true;
  }

  public PlatformAppHttpConfig f()
  {
    return this.a;
  }

  public MqttConfig g()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.config.OrcaProductionConfig
 * JD-Core Version:    0.6.0
 */
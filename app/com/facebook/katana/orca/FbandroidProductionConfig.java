package com.facebook.katana.orca;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.facebook.katana.UserAgent;
import com.facebook.orca.config.MqttConfig;
import com.facebook.orca.config.OrcaConfig;
import com.facebook.orca.config.PlatformAppHttpConfig;

public class FbandroidProductionConfig
  implements OrcaConfig
{
  private final Context a;
  private final String b;
  private final int c;
  private final PlatformAppHttpConfig d;
  private final MqttConfig e;

  public FbandroidProductionConfig(Context paramContext, PackageInfo paramPackageInfo)
  {
    this.a = paramContext;
    this.b = paramPackageInfo.versionName;
    this.c = UserAgent.b(paramContext);
    this.d = new FbandroidProductionConfig.FbAndroidHttpConfig(this);
    this.e = new MqttConfig("orcart.facebook.com", 8883, true);
  }

  public String a()
  {
    return this.b;
  }

  public int b()
  {
    return this.c;
  }

  public int c()
  {
    return 1;
  }

  public boolean d()
  {
    return true;
  }

  public String e()
  {
    return UserAgent.a(this.a, Boolean.valueOf(false));
  }

  public PlatformAppHttpConfig f()
  {
    return this.d;
  }

  public MqttConfig g()
  {
    return this.e;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidProductionConfig
 * JD-Core Version:    0.6.0
 */
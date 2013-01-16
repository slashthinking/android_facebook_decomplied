package com.facebook.orca.config;

import com.facebook.config.AppBuildInfo;

public abstract interface OrcaConfig extends AppBuildInfo
{
  public abstract String a();

  public abstract int b();

  public abstract boolean d();

  public abstract String e();

  public abstract PlatformAppHttpConfig f();

  public abstract MqttConfig g();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.config.OrcaConfig
 * JD-Core Version:    0.6.0
 */
package com.facebook.orca.push.mqtt;

import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class MqttPrefKeys
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.a.c("mqtt/");
  public static final PrefKey b = (PrefKey)a.c("retry_interval");
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPrefKeys
 * JD-Core Version:    0.6.0
 */
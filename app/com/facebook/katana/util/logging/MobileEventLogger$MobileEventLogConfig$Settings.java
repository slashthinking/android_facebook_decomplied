package com.facebook.katana.util.logging;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.katana.features.LoggingConfigSettings.ConfigValues;

public class MobileEventLogger$MobileEventLogConfig$Settings
  implements JMStaticKeysDictDestination, LoggingConfigSettings.ConfigValues
{

  @JMAutogen.InferredType(jsonFieldName="active")
  protected boolean active = true;

  @JMAutogen.InferredType(jsonFieldName="duration")
  protected int duration = 21600000;

  @JMAutogen.InferredType(jsonFieldName="min_scoop_interval")
  protected long min_scoop_interval = 1200000L;

  @JMAutogen.InferredType(jsonFieldName="ratio")
  protected int ratio = 10000;

  public boolean a()
  {
    return this.active;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.MobileEventLogger.MobileEventLogConfig.Settings
 * JD-Core Version:    0.6.0
 */
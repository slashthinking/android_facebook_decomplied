package com.facebook.katana.util.logging;

import com.facebook.common.json.jsonmirror.JMException;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.features.LoggingConfigSettings.ConfigFactory;
import com.facebook.katana.features.LoggingConfigSettings.ConfigValues;
import com.fasterxml.jackson.core.JsonParser;

class MobileEventLogger$MobileEventLogConfig$Factory
  implements LoggingConfigSettings.ConfigFactory
{
  public LoggingConfigSettings.ConfigValues a()
  {
    return new MobileEventLogger.MobileEventLogConfig.Settings();
  }

  public LoggingConfigSettings.ConfigValues a(JsonParser paramJsonParser)
  {
    try
    {
      localConfigValues = (LoggingConfigSettings.ConfigValues)JMParser.a(paramJsonParser, MobileEventLogger.MobileEventLogConfig.Settings.class);
      return localConfigValues;
    }
    catch (JMException localJMException)
    {
      while (true)
        LoggingConfigSettings.ConfigValues localConfigValues = null;
    }
  }

  public String b()
  {
    return MobileEventLogger.MobileEventLogConfig.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.MobileEventLogger.MobileEventLogConfig.Factory
 * JD-Core Version:    0.6.0
 */
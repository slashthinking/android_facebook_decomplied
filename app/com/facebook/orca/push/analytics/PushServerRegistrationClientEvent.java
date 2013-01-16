package com.facebook.orca.push.analytics;

import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.ReliabilityAnalyticsClientEvent;
import java.util.Map;

public class PushServerRegistrationClientEvent
{
  public static HoneyClientEvent a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    return ReliabilityAnalyticsClientEvent.a("push_reg_server", paramString1, paramMap, "registration_id", paramString2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.analytics.PushServerRegistrationClientEvent
 * JD-Core Version:    0.6.0
 */
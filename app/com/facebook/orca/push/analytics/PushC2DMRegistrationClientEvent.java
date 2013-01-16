package com.facebook.orca.push.analytics;

import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.ReliabilityAnalyticsClientEvent;
import java.util.Map;

public class PushC2DMRegistrationClientEvent
{
  public static HoneyClientEvent a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    return ReliabilityAnalyticsClientEvent.a("push_reg_c2dm", paramString1, paramMap, "registration_id", paramString2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.analytics.PushC2DMRegistrationClientEvent
 * JD-Core Version:    0.6.0
 */
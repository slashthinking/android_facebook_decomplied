package com.facebook.orca.push.analytics;

import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.ReliabilityAnalyticsClientEvent;
import com.facebook.orca.push.c2dm.FacebookPushServerRegistrar.RegistrationStatus;

public final class PushServerRegistrationInitialStatusClientEvent
{
  public static HoneyClientEvent a(FacebookPushServerRegistrar.RegistrationStatus paramRegistrationStatus, String paramString)
  {
    return ReliabilityAnalyticsClientEvent.a("push_reg_server_initial_status", a(paramRegistrationStatus), null, "registration_id", paramString);
  }

  private static String a(FacebookPushServerRegistrar.RegistrationStatus paramRegistrationStatus)
  {
    String str;
    if (paramRegistrationStatus == null)
      str = "not_applicable";
    while (true)
    {
      return str;
      switch (PushServerRegistrationInitialStatusClientEvent.1.a[paramRegistrationStatus.ordinal()])
      {
      default:
        str = "none";
        break;
      case 1:
        str = "current";
        break;
      case 2:
        str = "expired";
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.analytics.PushServerRegistrationInitialStatusClientEvent
 * JD-Core Version:    0.6.0
 */